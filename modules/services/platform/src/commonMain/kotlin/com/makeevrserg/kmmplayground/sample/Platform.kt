package com.makeevrserg.kmmplayground.sample

import com.makeevrserg.kmmplayground.resources.MR
import dev.icerock.moko.resources.desc.Raw
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

interface Platform {
    val name: String
    val type: PlatformType

    enum class PlatformType {
        JVM, ANDROID, IOS
    }

    fun sharedHelloWorldAsRaw(): StringDesc {
        return StringDesc.Raw("Hello world")
    }

    fun sharedHelloWorldAsResource(): StringDesc {
        return StringDesc.Resource(MR.strings.example_shared_hello_world)
    }
}
