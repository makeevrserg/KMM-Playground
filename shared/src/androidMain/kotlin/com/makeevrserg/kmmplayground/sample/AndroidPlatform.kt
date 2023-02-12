package com.makeevrserg.kmmplayground.sample

import com.makeevrserg.kmmplayground.sample.Platform

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}
