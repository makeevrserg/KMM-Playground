package com.makeevrserg.kmmplayground.presentation.entername.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.makeevrserg.kmmplayground.data.preferences.LocalPreferencesRepository

typealias EnterNameStore = Store<EnterNameIntent, EnterNameState, EnterNameLabel>

fun EnterNameStore(
    storeFactory: StoreFactory,
    localPreferencesRepository: LocalPreferencesRepository
): EnterNameStore {
    return storeFactory.create(
        name = "EnterNameStore",
        initialState = EnterNameState.Loading as EnterNameState,
        executorFactory = { EnterNameExecutor(localPreferencesRepository) },
        reducer = {
            when (it) {
                is EnterNameMessage.Entered -> {
                    (this as? EnterNameState.Loaded)?.copy(name = it.value) ?: this
                }

                is EnterNameMessage.FirstLoaded -> {
                    EnterNameState.Loaded(it.value, it.value, false)
                }

                is EnterNameMessage.SetLoading -> {
                    (this as? EnterNameState.Loaded)?.copy(isLoading = it.state) ?: this
                }
            }
        }
    )
}
