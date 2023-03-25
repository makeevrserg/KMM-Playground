import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Moko
                api(libs.moko.resources.core)
                api(libs.moko.mvvm.core)
                // Decompose
                api(libs.decompose.core)
                // MVIKotlin
                api(libs.mvikotlin.core)
                api(libs.mvikotlin.rx)
            }
        }
    }
}
android {
    namespace = Application.APPLICATION_ID + ".core"
}
