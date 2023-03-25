package com.makeevrserg.kmmplayground.sample

import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val type: Platform.PlatformType
        get() = Platform.PlatformType.IOS
}
