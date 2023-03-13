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