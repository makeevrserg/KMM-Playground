package com.makeevrserg.kmmplayground.core.shared

import java.util.prefs.Preferences

actual class PlatformConfiguration {
    val preferences = Preferences.userRoot()
}
