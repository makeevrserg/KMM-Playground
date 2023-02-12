package com.makeevrserg.kmmplayground.di

import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.makeevrserg.kmmplayground.sample.Greeting
import com.makeevrserg.kmmplayground.sample.getPlatform
import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobile.di_container.module

object ServiceLocator {
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
