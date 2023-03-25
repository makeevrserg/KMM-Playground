import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-library-convention")
}
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.moko.resources.core)
                implementation(project(":modules:services:resources"))
            }
        }
    }
}

android {
    namespace = Application.APPLICATION_ID + ".core"
}
