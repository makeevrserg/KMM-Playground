package com.makeevrserg.kmmplayground.di.factories

import com.makeevrserg.kmmplayground.core.shared.PlatformConfiguration
import com.makeevrserg.mobile.di_container.Factory
import com.russhwolf.settings.Settings

expect class SettingsFactory(
    platformConfiguration: PlatformConfiguration
) : Factory<Settings>
