import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-ios")
    id("kmm-jvm")
    id("kmm-android")
    id("kmm-cocoapods")
    kotlin("native.cocoapods")
    id("dev.icerock.mobile.multiplatform-resources")
    id("dev.icerock.moko.kswift")
    kotlin("plugin.serialization")
}

kotlin {
    android {
        apply(plugin = "kotlin-parcelize")
    }
    cocoapods.framework {
        baseName = "shared"
        isStatic = false
        // Moko
        export(libs.moko.mvvm.core)
        export(libs.moko.mvvm.flow)
        // Resources
        export(libs.moko.resources.core)
        export(libs.moko.graphics)
        // KSwift
        export(libs.moko.kswift)
        // Decompose
        export(libs.decompose.core)
        export(libs.essenty.lifecycle)
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.multiplatformSetting)
                api(libs.moko.mvvm.core)
                api(libs.moko.mvvm.flow)
                api(libs.moko.resources.core)
                api(libs.moko.kswift)
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.mobileX.core.ktx)
                // Serialization
                implementation(libs.kotlin.serialization.json)
                // Decompose
                api(libs.decompose.core)
                api(libs.essenty.lifecycle)
                // MVIKotlin
                api(libs.mvikotlin.core)
                api(libs.mvikotlin.main)
                api(libs.mvikotlin.extensions.coroutines)
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.moko.resources.compose)
            }
        }
        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.moko.resources.compose)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}
android {
    namespace = Application.APPLICATION_ID + ".shared"
}
multiplatformResources {
    multiplatformResourcesPackage = Application.APPLICATION_ID + ".shared"
}

kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
    install(dev.icerock.moko.kswift.plugin.feature.PlatformExtensionFunctionsFeature)
}