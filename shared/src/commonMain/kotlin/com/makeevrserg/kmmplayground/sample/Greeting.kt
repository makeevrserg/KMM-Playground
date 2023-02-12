package com.makeevrserg.kmmplayground.sample

class Greeting(val platform: Platform) {

    fun getHelloWorld(): String {
        return "Hello, ${platform.name}!"
    }
}
