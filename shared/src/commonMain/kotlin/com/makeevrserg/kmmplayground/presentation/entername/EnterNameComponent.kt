package com.makeevrserg.kmmplayground.presentation.entername

import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.makeevrserg.kmmplayground.SharedViewModel
import com.makeevrserg.kmmplayground.data.preferences.LocalPreferencesRepository
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Intent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStoreFactory
import com.makeevrserg.mobilex.ktx_core.platform.KDispatchers
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface EnterNameComponent {

    val enterNameState: Value<EnterNameStore.State>
    val enterNameLabels: CFlow<EnterNameStore.Label>
    fun acceptEnterName(intent: Intent)

}
