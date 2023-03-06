import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.multiplatformSetting)
                implementation(libs.moko.mvvm.core)
                implementation(libs.moko.mvvm.flow)
                implementation(libs.moko.resources.core)
                implementation(libs.moko.kswift)
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.mobileX.core.ktx)
                // Serialization
                implementation(libs.kotlin.serialization.json)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.essenty.lifecycle)
                // MVIKotlin
                implementation(libs.mvikotlin.core)
                implementation(libs.mvikotlin.main)
                implementation(libs.mvikotlin.extensions.coroutines)
            }
        }
    }
}
android {
    namespace = Application.APPLICATION_ID + ".core"
}
