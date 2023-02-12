import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-library-convention")
    id("dev.icerock.moko.kswift")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
}

kotlin {
    android {
        apply(plugin = "kotlin-parcelize")
    }
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "MultiPlatformLibrary"
            isStatic = false
            // Moko
            export(libs.moko.mvvm.core)
            export(libs.moko.mvvm.flow)
            // Resources
            export(libs.moko.resources.core)
            export(libs.moko.graphics)
            // KSwift
            export(libs.moko.kswift)
            // Decompose
            export(libs.decompose.core)
            export(libs.essenty.lifecycle)
            // Local
            export(project(":resources"))
        }
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
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.mobileX.core.ktx)
                // Serialization
                implementation(libs.kotlin.serialization.json)
                // Decompose
                api(libs.decompose.core)
                api(libs.essenty.lifecycle)
                // MVIKotlin
                api(libs.mvikotlin.core)
                api(libs.mvikotlin.main)
                api(libs.mvikotlin.extensions.coroutines)
                // Local
                api(project(":resources"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.moko.resources.compose)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.moko.resources.compose)
            }
        }
    }
}
android {
    namespace = Application.APPLICATION_ID + ".shared"
}

kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
    install(dev.icerock.moko.kswift.plugin.feature.PlatformExtensionFunctionsFeature)
}