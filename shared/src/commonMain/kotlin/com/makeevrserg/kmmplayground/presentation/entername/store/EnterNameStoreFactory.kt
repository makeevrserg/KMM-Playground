package com.makeevrserg.kmmplayground.presentation.entername.store

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.makeevrserg.kmmplayground.data.preferences.LocalPreferencesRepository
import com.makeevrserg.mobile.di_container.Factory

class EnterNameStoreFactory(

    private val storeFactory: StoreFactory,
    private val localPreferencesRepository: LocalPreferencesRepository
) : Factory<EnterNameStore>() {
    override fun initializer(): EnterNameStore {
        return EnterNameStoreImpl(
            storeFactory = storeFactory,
            localPreferencesRepository = localPreferencesRepository
        )
    }

    sealed interface Message {
        class Entered(val value: String) : Message
        class FirstLoaded(val value: String) : Message
        class SetLoading(val state: Boolean) : Message
    }
}