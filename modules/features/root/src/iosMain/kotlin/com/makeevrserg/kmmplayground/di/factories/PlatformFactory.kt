package com.makeevrserg.kmmplayground.di.factories

import com.makeevrserg.kmmplayground.sample.IOSPlatform
import com.makeevrserg.kmmplayground.sample.Platform
import com.makeevrserg.mobile.di_container.Factory

actual class PlatformFactory : Factory<Platform>() {
    override fun initializer(): Platform {
        return IOSPlatform()
    }
}
