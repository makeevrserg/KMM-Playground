import com.makeevrserg.kmmplayground.Application
import com.makeevrserg.kmmplayground.Application.GROUP
import com.makeevrserg.kmmplayground.Application.VERSION_NAME
import com.makeevrserg.kmmplayground.Application.COMPILE_SDK_VERSION
import com.makeevrserg.kmmplayground.Application.MIN_SDK_VERSION
import com.makeevrserg.kmmplayground.Application.TARGET_SDK_VERSION
import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}
kotlin {
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
    }
}
