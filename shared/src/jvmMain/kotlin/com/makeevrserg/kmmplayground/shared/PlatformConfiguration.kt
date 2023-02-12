package com.makeevrserg.kmmplayground.shared

import java.util.prefs.Preferences

actual class PlatformConfiguration{
    val preferences = Preferences.userRoot()
}