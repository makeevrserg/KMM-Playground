import com.makeevrserg.kmmplayground.Application
import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

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
                // Compose
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                // Decompose
                implementation(libs.decompose.core)
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.mobileX.core.ktx)
                // Local
                implementation(project(":shared"))
                implementation(project(":modules:services:core"))
                implementation(project(":modules:services:data-preferences"))
                implementation(project(":modules:services:resources"))
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
                // Decompose
                implementation(libs.decompose.compose.jetbrains)
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                // Moko
                implementation(libs.moko.resources.core)
                implementation(libs.moko.resources.compose)
                // Local
                implementation(project(":modules:features:shared-ui"))
                implementation(project(":modules:services:core-ui"))
            }
        }
        val desktopMain by getting {
            dependencies {
                // Decompose
                implementation(libs.decompose.compose.jetbrains)
                // Compose
                implementation(compose.desktop.currentOs)
                // Local
                implementation(project(":modules:features:shared-ui"))
                implementation(project(":modules:services:core-ui"))
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
    composeOptions.kotlinCompilerExtensionVersion =
        libs.versions.kotlin.compilerExtensionVersion.get()
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
