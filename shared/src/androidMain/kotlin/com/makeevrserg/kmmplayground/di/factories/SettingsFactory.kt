package com.makeevrserg.kmmplayground.di.factories

import com.makeevrserg.kmmplayground.shared.PlatformConfiguration
import com.makeevrserg.mobile.di_container.Factory
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import kotlin.coroutines.coroutineContext

actual class SettingsFactory actual constructor(
    private val platformConfiguration: PlatformConfiguration
) : Factory<Settings>() {
    override fun initializer(): Settings {
        return SharedPreferencesSettings(platformConfiguration.sharedPreferences)
    }
}