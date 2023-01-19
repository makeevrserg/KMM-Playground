import org.jetbrains.compose.compose

plugins {
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
    kotlin("multiplatform")
    id("kmm-android")
    id("dev.icerock.moko.kswift")
}
kotlin {
    android() {
        apply(plugin = "kotlin-parcelize")
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
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
                api(libs.moko.resources.core)
                api(libs.moko.resources.core)
                // Network
                implementation(libs.ktor.client.core)
                // Navigation
                implementation("com.arkivanov.decompose:decompose:${libs.versions.decompose.get()}")
                // Local
                implementation(project(":shared"))

            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.moko.resources.compose)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.moko.resources.compose)
            }
        }
    }
}
android {
    namespace = "com.makeevrserg.kmmplayground.shared_ui"
}
kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
    install(dev.icerock.moko.kswift.plugin.feature.PlatformExtensionFunctionsFeature)
}
