plugins {
    id("kmm-android")
    id("kmm-jvm")
    id("org.jetbrains.compose")
}
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.materialIconsExtended)
                implementation(compose.runtime)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.decompose.compose.jetbrains)
                // Local
                implementation(project(":shared"))
            }
        }

        val androidMain by getting {
            dependencies {
                // Compose
                implementation("androidx.compose.ui:ui:1.2.1")
                implementation("androidx.compose.foundation:foundation:1.2.1")
            }
        }
        val jvmMain by getting {
            dependencies {
                // Compose
                implementation(compose.desktop.common)
            }
        }
    }
}
android {
    namespace = com.makeevrserg.kmmplayground.Application.APPLICATION_ID + ".shared_ui"
}