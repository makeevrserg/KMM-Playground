import com.makeevrserg.kmmplayground.Application

plugins {
    id("com.android.library")
}

android {
    compileSdk = Application.COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = Application.MIN_SDK_VERSION
        targetSdk = Application.TARGET_SDK_VERSION
    }
}