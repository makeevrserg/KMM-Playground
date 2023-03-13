package com.makeevrserg.kmmplayground.data.preferences

import com.makeevrserg.mobile.di_container.Factory
import com.russhwolf.settings.Settings

class LocalPreferencesRepositoryFactory(
    private val settings: Settings
) : Factory<LocalPreferencesRepository>() {
    override fun initializer(): LocalPreferencesRepository {
        return LocalPreferencesRepositoryImpl(settings)
    }
}