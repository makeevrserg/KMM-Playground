import com.makeevrserg.kmmplayground.Application
import org.gradle.kotlin.dsl.kotlin

group = Application.GROUP
version = Application.VERSION_NAME
plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

kotlin {
    jvm("jvm") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    android()
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting
        val androidMain by getting
        val jvmMain by getting
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
    compileSdk = Application.COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = Application.MIN_SDK_VERSION
        targetSdk = Application.TARGET_SDK_VERSION
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    packagingOptions {
        with(resources.excludes) {
            add("META-INF/*.kotlin_module")
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
