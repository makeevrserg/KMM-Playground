package com.makeevrserg.kmmplayground.di.factories

import com.makeevrserg.kmmplayground.shared.PlatformConfiguration
import com.makeevrserg.mobile.di_container.Factory
import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings

actual class SettingsFactory actual constructor(
    private val platformConfiguration: PlatformConfiguration
) : Factory<Settings>() {
    override fun initializer(): Settings {
        return PreferencesSettings(platformConfiguration.preferences)
    }
}