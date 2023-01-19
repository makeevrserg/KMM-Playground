import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("kmm-jvm")
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
                implementation(project(":shared-ui"))
                implementation(compose.desktop.currentOs)
                // Navigation
                implementation("com.arkivanov.decompose:decompose:${libs.versions.decompose.get()}")
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains:${libs.versions.decompose.get()}")
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
