package com.makeevrserg.kmmplayground

class Greeting(val platform: Platform) {

    fun greeting(): String {
        return "Hello, ${platform.name}!"
    }
}