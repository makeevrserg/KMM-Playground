package com.makeevrserg.kmmplayground

import com.makeevrserg.kmmplayground.shared.MR
import com.makeevrserg.mobilex.uitext.UiText
import com.makeevrserg.mobilex.uitext.invoke

interface Platform {
    val name: String
    fun sharedHelloWorldAsRaw(): UiText{
        return UiText.invoke("Hello world")
    }
    fun sharedHelloWorldAsResource(): UiText {
        return UiText.Companion.invoke(MR.strings.example_shared_hello_world)
    }
}

expect fun getPlatform(): Platform