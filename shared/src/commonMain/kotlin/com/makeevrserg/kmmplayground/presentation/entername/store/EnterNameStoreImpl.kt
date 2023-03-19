package com.makeevrserg.kmmplayground.presentation.entername.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.makeevrserg.kmmplayground.data.preferences.LocalPreferencesRepository
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Label
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Intent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStoreFactory.Message
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.State


class EnterNameStoreImpl(
    storeFactory: StoreFactory,
    localPreferencesRepository: LocalPreferencesRepository
) : EnterNameStore, Store<Intent, State, Label> by storeFactory.create(
    name = "EnterNameStore",
    initialState = State.Loading as State,
    executorFactory = { EnterNameExecutor(localPreferencesRepository) },
    reducer = EnterNameReducer
)

