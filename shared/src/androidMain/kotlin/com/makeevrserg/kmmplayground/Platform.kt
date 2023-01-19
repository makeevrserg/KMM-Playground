package com.makeevrserg.kmmplayground

import com.makeevrserg.kmmplayground.shared.R

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}
fun asds(){
    R.string.splash_loading
}

actual fun getPlatform(): Platform = AndroidPlatform()