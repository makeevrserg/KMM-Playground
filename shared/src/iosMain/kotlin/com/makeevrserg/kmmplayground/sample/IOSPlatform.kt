package com.makeevrserg.kmmplayground.sample

import com.makeevrserg.kmmplayground.sample.Platform
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}
