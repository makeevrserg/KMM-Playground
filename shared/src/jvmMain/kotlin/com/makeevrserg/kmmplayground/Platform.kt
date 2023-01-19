package com.makeevrserg.kmmplayground

class JVMPlatform: Platform {
    override val name: String = "JVM"
}

actual fun getPlatform(): Platform = JVMPlatform()