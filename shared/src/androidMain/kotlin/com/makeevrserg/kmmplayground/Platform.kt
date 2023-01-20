package com.makeevrserg.kmmplayground

import com.makeevrserg.kmmplayground.shared.MR
import com.makeevrserg.mobilex.uitext.UiText
import com.makeevrserg.mobilex.uitext.invoke

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}


actual fun getPlatform(): Platform = AndroidPlatform()