package com.makeevrserg.kmmplayground.sample

class JVMPlatform : Platform {
    override val name: String = "JVM"
    override val type: Platform.PlatformType
        get() = Platform.PlatformType.JVM
}
