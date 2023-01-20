import org.jetbrains.compose.compose

plugins {
    id("kmm-android")
    id("kmm-jvm")
    id("org.jetbrains.compose")
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
                // Compose
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.materialIconsExtended)
                implementation(compose.runtime)
//                api(libs.moko.resources.core)
                // Network
                implementation(libs.ktor.client.core)
                // MobileX
                implementation(libs.mobileX.uitext.core)
                implementation(libs.mobileX.uitext.mr)
                implementation(libs.mobileX.uitext.compose)
                // Navigation
                implementation("com.arkivanov.decompose:decompose:${libs.versions.decompose.get()}")
                // Local
                api(project(":shared"))

            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.moko.resources.compose)
            }
        }
        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.moko.resources.compose)
            }
        }
    }
}
android {
    namespace = com.makeevrserg.kmmplayground.Application.APPLICATION_ID + ".shared_ui"
}
kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
    install(dev.icerock.moko.kswift.plugin.feature.PlatformExtensionFunctionsFeature)
}
