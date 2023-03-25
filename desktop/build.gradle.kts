import com.makeevrserg.kmmplayground.Application
import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.experimental.uikit.tasks.ExperimentalPackComposeApplicationForXCodeTask
import org.jetbrains.kotlin.gradle.tasks.KotlinNativeLink
import kotlin.reflect.full.declaredMemberProperties
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("native.cocoapods")
}
kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    jvm("desktop")
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    cocoapods {
        version = "1.0.0"
        summary = "summary"
        homepage = "homepage"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    sourceSets {
        val commonMain by getting {

            dependencies {
                // Decompose
                implementation(libs.decompose.core)
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains:${libs.versions.decompose.get()}-compose-experimental")
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.mobileX.core.ktx)
                // Local
                implementation(project(":modules:features:root"))
                implementation(project(":modules:features:shared-ui"))
                implementation(project(":modules:services:core"))
                implementation(project(":modules:services:data-preferences"))
                implementation(project(":modules:services:resources"))
                implementation(project(":modules:services:core-ui"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.compose.ui:ui:1.2.1")
                implementation("androidx.compose.foundation:foundation:1.2.1")
                implementation("androidx.compose.ui:ui-tooling:1.2.1")
                implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
                implementation("androidx.compose.material:material:1.2.1")
                implementation("androidx.activity:activity-compose:1.5.1")
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                // Moko
                implementation(libs.moko.resources.core)
                implementation(libs.moko.resources.compose)
            }
        }
        val desktopMain by getting {
            dependencies {
                // Compose
                implementation(compose.desktop.currentOs)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KotlinMultiplatformComposeDesktopApplication"
            packageVersion = "1.0.0"
        }
    }
}

android {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = libs.versions.kotlin.compilerExtensionVersion.get()
    compileSdk = Application.COMPILE_SDK_VERSION
    defaultConfig {
        applicationId = Application.APPLICATION_ID
        versionName = Application.VERSION_NAME
        versionCode = Application.VERSION_CODE
        minSdk = Application.MIN_SDK_VERSION
        targetSdk = Application.TARGET_SDK_VERSION
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}


// Workaround to use Moko resources in ios.
// copy .bundle from all .klib to .kexe
tasks.withType<KotlinNativeLink>()
    .configureEach {
        val linkTask: KotlinNativeLink = this
        val outputDir: File = this.outputFile.get().parentFile

        @Suppress("ObjectLiteralToLambda") // lambda broke up-to-date
        val action = object : Action<Task> {
            override fun execute(t: Task) {
                (linkTask.libraries + linkTask.sources)
                    .filter { library -> library.extension == "klib" }
                    .filter(File::exists)
                    .forEach { inputFile ->
                        val klibKonan = org.jetbrains.kotlin.konan.file.File(inputFile.path)
                        val klib = org.jetbrains.kotlin.library.impl.KotlinLibraryLayoutImpl(
                            klib = klibKonan,
                            component = "default"
                        )
                        val layout = klib.extractingToTemp

                        // extracting bundles
                        layout
                            .resourcesDir
                            .absolutePath
                            .let(::File)
                            .listFiles { file: File -> file.extension == "bundle" }
                            // copying bundles to app
                            ?.forEach {
                                logger.info("${it.absolutePath} copying to $outputDir")
                                it.copyRecursively(
                                    target = File(outputDir, it.name),
                                    overwrite = true
                                )
                            }
                    }
            }
        }
        doLast(action)
    }

// copy .bundle from .kexe to .app
tasks.withType<ExperimentalPackComposeApplicationForXCodeTask>()
    .configureEach {
        val packTask: ExperimentalPackComposeApplicationForXCodeTask = this

        val kclass = ExperimentalPackComposeApplicationForXCodeTask::class
        val kotlinBinaryField =
            kclass.declaredMemberProperties.single { it.name == "kotlinBinary" }
        val destinationDirField =
            kclass.declaredMemberProperties.single { it.name == "destinationDir" }
        val executablePathField =
            kclass.declaredMemberProperties.single { it.name == "executablePath" }

        @Suppress("ObjectLiteralToLambda") // lambda broke up-to-date
        val action = object : Action<Task> {
            override fun execute(t: Task) {
                val kotlinBinary: RegularFile =
                    (kotlinBinaryField.get(packTask) as RegularFileProperty).get()
                val destinationDir: Directory =
                    (destinationDirField.get(packTask) as DirectoryProperty).get()
                val executablePath: String =
                    (executablePathField.get(packTask) as Provider<String>).get()

                val outputDir: File = File(destinationDir.asFile, executablePath).parentFile

                val bundleSearchDir: File = kotlinBinary.asFile.parentFile
                bundleSearchDir
                    .listFiles { file: File -> file.extension == "bundle" }
                    ?.forEach { file ->
                        file.copyRecursively(File(outputDir, file.name), true)
                    }
            }
        }
        doLast(action)
    }