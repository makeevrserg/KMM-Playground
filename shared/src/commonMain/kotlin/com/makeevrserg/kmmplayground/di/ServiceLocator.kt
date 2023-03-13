package com.makeevrserg.kmmplayground.di

import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.makeevrserg.kmmplayground.di.factories.SettingsFactory
import com.makeevrserg.kmmplayground.sample.Greeting
import com.makeevrserg.kmmplayground.core.shared.PlatformConfiguration
import com.makeevrserg.kmmplayground.data.preferences.LocalPreferencesRepositoryFactory
import com.makeevrserg.kmmplayground.sample.PlatformFactory
import com.makeevrserg.mobile.di_container.Lateinit
import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobile.di_container.module

object ServiceLocator {
    val platformConfigurationModule = Lateinit<PlatformConfiguration>()
    val settingsModule = module {
        val platformConfiguration by platformConfigurationModule
        SettingsFactory(platformConfiguration).value
    }
    val localStorageRepository = module {
        val settings by settingsModule
        LocalPreferencesRepositoryFactory(settings).value
    }
    val storeFactoryModule = module {
        DefaultStoreFactory()
    }
    val platformModule = module {
        PlatformFactory().value
    }
    val greetingModule = module {
        val platform by platformModule
        Greeting(platform)
    }
}
