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
                // MobileX
                implementation(libs.mobileX.core.ktx)
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.multiplatformSetting)
            }
        }
    }
}
android {
    namespace = Application.APPLICATION_ID + ".data.preferences"
}
multiplatformResources {
    multiplatformResourcesPackage = Application.APPLICATION_ID + ".data.preferences"
}
