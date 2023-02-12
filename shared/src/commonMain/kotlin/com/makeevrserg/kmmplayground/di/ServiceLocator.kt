package com.makeevrserg.kmmplayground.di

import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.makeevrserg.kmmplayground.di.factories.SettingsFactory
import com.makeevrserg.kmmplayground.domain.LocalStorageRepositoryImpl
import com.makeevrserg.kmmplayground.sample.Greeting
import com.makeevrserg.kmmplayground.sample.getPlatform
import com.makeevrserg.kmmplayground.shared.PlatformConfiguration
import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobile.di_container.module
import com.makeevrserg.mobile.di_container.Lateinit

object ServiceLocator {
    val platformConfigurationModule = Lateinit<PlatformConfiguration>()
    val settingsModule = module {
        val platformConfiguration by platformConfigurationModule
        SettingsFactory(platformConfiguration).value
    }
    val localStorageRepository = module {
        val settings by settingsModule
        LocalStorageRepositoryImpl(settings)
    }
    val storeFactoryModule = module {
        DefaultStoreFactory()
    }
    val platformModule = module {
        getPlatform()
    }
    val greetingModule = module {
        val platform by platformModule
        Greeting(platform)
    }
}
