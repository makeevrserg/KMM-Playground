package com.makeevrserg.kmmplayground.presentation.entername

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.makeevrserg.kmmplayground.SharedViewModel
import com.makeevrserg.kmmplayground.domain.LocalStorageRepository
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameIntent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore
import com.makeevrserg.mobilex.ktx_core.platform.KDispatchers
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EnterNameViewModel(
    storeFactory: StoreFactory,
    localStorageRepository: LocalStorageRepository
) : SharedViewModel() {
    val store: EnterNameStore = EnterNameStore(storeFactory, localStorageRepository)

    val enterNameState = store.stateFlow.cStateFlow()
    val enterNameLabels = store.labels.cFlow()
    fun acceptEnterName(intent: EnterNameIntent){
        store.accept(intent)
    }

    init {
        viewModelScope.launch(KDispatchers.IO) {
            delay(1000)
            withContext(KDispatchers.Main) {
                acceptEnterName(EnterNameIntent.LoadValue)
            }
        }
    }
}