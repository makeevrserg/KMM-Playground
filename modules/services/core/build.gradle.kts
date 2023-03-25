import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-library-convention")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.moko.resources.core)
                api(libs.moko.mvvm.core)
                // Decompose
                api(libs.decompose.core)
                // MVIKotlin
                api(libs.mvikotlin.core)
                api(libs.mvikotlin.main)
                api(libs.mvikotlin.rx)
            }
        }
    }
}
android {
    namespace = Application.APPLICATION_ID + ".core"
}
multiplatformResources {
    multiplatformResourcesPackage = Application.APPLICATION_ID + ".core"
}
