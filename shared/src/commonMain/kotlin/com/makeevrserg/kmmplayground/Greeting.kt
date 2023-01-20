package com.makeevrserg.kmmplayground

class Greeting {
    val platform: Platform = getPlatform()

    fun greeting(): String {
        return "Hello, ${platform.name}!"
    }
}