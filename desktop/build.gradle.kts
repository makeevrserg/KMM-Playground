import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat


plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}
kotlin {
    jvm {
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                // Compose
                implementation(compose.desktop.currentOs)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.decompose.compose.jetbrains)
                // Local
                implementation(project(":shared-ui"))
                implementation(project(":shared"))
                implementation(project(":resources"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.makeevrserg.kmmplayground.desktop.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jvm"
            packageVersion = "1.0.0"
        }
    }
}
