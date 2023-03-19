package com.makeevrserg.kmmplayground.presentation.entername

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.makeevrserg.kmmplayground.data.preferences.LocalPreferencesRepository
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Intent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStoreFactory
import com.makeevrserg.kmmplayground.util.stateValue
import dev.icerock.moko.mvvm.flow.cFlow

class EnterNameComponentImpl(
    context: ComponentContext,
    storeFactory: StoreFactory,
    localPreferencesRepository: LocalPreferencesRepository
) : EnterNameComponent, ComponentContext by context {
    val store: EnterNameStore = EnterNameStoreFactory(storeFactory, localPreferencesRepository).value

    override val enterNameState = store.stateValue()
    override val enterNameLabels = store.labels.cFlow()
    override fun acceptEnterName(intent: Intent) {
        store.accept(intent)
    }

    init {
        acceptEnterName(Intent.LoadValue)
    }
}
