import com.makeevrserg.kmmplayground.Application
import com.makeevrserg.kmmplayground.Application.VERSION_NAME
import com.makeevrserg.kmmplayground.Application.COMPILE_SDK_VERSION
import com.makeevrserg.kmmplayground.Application.MIN_SDK_VERSION
import com.makeevrserg.kmmplayground.Application.TARGET_SDK_VERSION
import org.gradle.kotlin.dsl.kotlin

group = Application.GROUP
version = Application.VERSION_NAME
plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
}
