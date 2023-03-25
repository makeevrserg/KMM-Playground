package com.makeevrserg.kmmplayground.sample

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val type: Platform.PlatformType
        get() = Platform.PlatformType.ANDROID
}
