import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-library-convention")
    id("dev.icerock.moko.kswift")
    kotlin("plugin.serialization")
}

kotlin {
    android {
        apply(plugin = "kotlin-parcelize")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.multiplatformSetting)
                implementation(libs.moko.mvvm.core)
                implementation(libs.moko.mvvm.flow)
                implementation(libs.moko.resources.core)
                implementation(libs.moko.kswift)
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.mobileX.core.ktx)
                // Serialization
                implementation(libs.kotlin.serialization.json)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.essenty.lifecycle)
                // MVIKotlin
                implementation(libs.mvikotlin.core)
                implementation(libs.mvikotlin.main)
                implementation(libs.mvikotlin.extensions.coroutines)
                implementation(libs.mvikotlin.rx)
                // Local
                implementation(project(":modules:services:resources"))
                implementation(project(":modules:services:core"))
                implementation(project(":modules:services:data-preferences"))
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
    namespace = Application.APPLICATION_ID + ".common"
}

kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
    install(dev.icerock.moko.kswift.plugin.feature.PlatformExtensionFunctionsFeature)
}
