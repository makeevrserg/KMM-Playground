package com.makeevrserg.kmmplayground

class Greeting(val platform: Platform) {

    fun getHelloWorld(): String {
        return "Hello, ${platform.name}!"
    }
}
