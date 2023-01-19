import com.makeevrserg.kmmplayground.Application
import com.makeevrserg.kmmplayground.Application.GROUP
import com.makeevrserg.kmmplayground.Application.VERSION_NAME
import com.makeevrserg.kmmplayground.Application.COMPILE_SDK_VERSION
import com.makeevrserg.kmmplayground.Application.MIN_SDK_VERSION
import com.makeevrserg.kmmplayground.Application.TARGET_SDK_VERSION
import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.library")
    kotlin("multiplatform")
}
kotlin {
    android()
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}