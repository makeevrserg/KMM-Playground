import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-ios")
    id("kmm-jvm")
    id("kmm-android")
    id("kmm-cocoapods")
    kotlin("native.cocoapods")
    id("dev.icerock.mobile.multiplatform-resources")
    id("dev.icerock.moko.kswift")
}

kotlin {
    cocoapods.framework {
        baseName = "shared"
        isStatic = false
        export(libs.moko.mvvm.core)
        export(libs.moko.mvvm.flow)
        export(libs.moko.resources.core)
        export(libs.moko.graphics)
        export(libs.moko.kswift)
        // Decompose
        export(libs.decompose.core)
        export(libs.essenty.lifecycle)
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.multiplatformSetting)
                api(libs.moko.mvvm.core)
                api(libs.moko.mvvm.flow)
                api(libs.moko.resources.core)
                api(libs.moko.kswift)
                // MobileX
                implementation(libs.mobileX.uitext.core)
                implementation(libs.mobileX.uitext.mr)
                // Decompose
                api(libs.decompose.core)
                api(libs.essenty.lifecycle)
                // MVIKotlin
                api(libs.mvikotlin.core)
                api(libs.mvikotlin.main)
                api(libs.mvikotlin.extensions.coroutines)
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.moko.resources.compose)
            }
        }
        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.moko.resources.compose)
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
android {
    namespace = Application.APPLICATION_ID + ".shared"
}
multiplatformResources {
    multiplatformResourcesPackage = Application.APPLICATION_ID + ".shared"
}

kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
    install(dev.icerock.moko.kswift.plugin.feature.PlatformExtensionFunctionsFeature)
}