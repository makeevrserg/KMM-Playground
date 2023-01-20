package com.makeevrserg.kmmplayground

import com.makeevrserg.kmmplayground.shared.MR
import com.makeevrserg.mobilex.uitext.UiText
import com.makeevrserg.mobilex.uitext.invoke
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()