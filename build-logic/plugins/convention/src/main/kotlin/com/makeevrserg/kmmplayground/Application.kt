package com.makeevrserg.kmmplayground

import org.gradle.api.Project
import java.io.InputStream
import java.util.Properties

object Application {
    const val APPLICATION_ID = "com.makeevrserg.kmmplayground"
    const val GROUP = "com.makeevrserg.kmmplayground"

    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 33
    const val COMPILE_SDK_VERSION = 33
    const val COMPILER_EXTENSION_VERSION = "1.3.0"

    const val VERSION_CODE = 10
    const val VERSION_NAME = "2.0.2"

    val Project.KEY_ALIAS: String
        get() = Application.getCredential(this, "KEY_ALIAS")
    val Project.KEY_PASSWORD: String
        get() = Application.getCredential(this, "KEY_PASSWORD")
    val Project.STORE_PASSWORD: String
        get() = Application.getCredential(this, "STORE_PASSWORD")

    val Project.WEB_CLIENT_ID: String
        get() = Application.getCredential(this, "WEB_CLIENT_ID")
    val Project.BANNER_AD_UNIT_ID: String
        get() = Application.getCredential(this, "BANNER_AD_UNIT_ID")
    val Project.ACTIVITY_AD_UNIT_ID: String
        get() = Application.getCredential(this, "ACTIVITY_AD_UNIT_ID")
    val Project.INTERSITIAL_AD_UNIT_ID: String
        get() = Application.getCredential(this, "INTERSITIAL_AD_UNIT_ID")

    fun getCredential(project: Project, path: String): String {
        val properties: Properties = Properties()
        val inputStream: InputStream = project.rootProject.file("keys.properties").inputStream()
        properties.load(inputStream)
        return properties.getProperty(path)
    }
}
