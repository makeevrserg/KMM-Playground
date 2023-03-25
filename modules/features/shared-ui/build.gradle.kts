import com.makeevrserg.kmmplayground.Application.APPLICATION_ID
plugins {
    id("compose-library-convention")
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
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.mobileX.core.ktx)
                // Decompose
                implementation(libs.decompose.core)
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains:${libs.versions.decompose.get()}-compose-experimental")
                // Local
                implementation(project(":modules:features:root"))
                implementation(project(":modules:features:common"))
                implementation(project(":modules:services:platform"))
                implementation(project(":modules:services:resources"))
                implementation(project(":modules:services:core"))
                implementation(project(":modules:services:core-ui"))
                implementation(project(":modules:services:data-preferences"))
                implementation(project(":modules:services:data-preferences"))
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
    namespace = "$APPLICATION_ID.shared.ui"
}
