package com.makeevrserg.kmmplayground.shared

import android.content.Context

actual class PlatformConfiguration(val context:Context){
    val sharedPreferences = context.getSharedPreferences("ANDROID_KMM_PLAYGROUND", Context.MODE_PRIVATE)
}