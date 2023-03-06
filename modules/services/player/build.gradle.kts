import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.mobileX.serviceLocator)
                // Local
                api(project(":modules:services:core"))
            }
        }
    }
}
android {
    namespace = Application.APPLICATION_ID + ".player"
}
