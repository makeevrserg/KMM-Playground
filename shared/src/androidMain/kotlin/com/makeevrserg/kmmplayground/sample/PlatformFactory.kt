package com.makeevrserg.kmmplayground.sample

import com.makeevrserg.mobile.di_container.Factory

actual class PlatformFactory : Factory<Platform>() {
    override fun initializer(): Platform {
        return AndroidPlatform()
    }
}
