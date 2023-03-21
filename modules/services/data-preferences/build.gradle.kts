import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
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