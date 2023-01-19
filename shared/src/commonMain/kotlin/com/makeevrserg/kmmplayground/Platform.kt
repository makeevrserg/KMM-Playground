package com.makeevrserg.kmmplayground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform