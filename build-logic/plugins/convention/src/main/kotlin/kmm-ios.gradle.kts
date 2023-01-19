import com.makeevrserg.kmmplayground.Application
import org.gradle.kotlin.dsl.kotlin

group = Application.GROUP
version = Application.VERSION_NAME
plugins {
    kotlin("multiplatform")
}

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}
