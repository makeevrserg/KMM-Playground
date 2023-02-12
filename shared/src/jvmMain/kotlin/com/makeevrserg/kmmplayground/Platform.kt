package com.makeevrserg.kmmplayground

class JVMPlatform: Platform {
    override val name: String = "JVM"
}

internal actual fun getPlatform(): Platform = JVMPlatform()