package com.makeevrserg.kmmplayground.presentation.entername

import com.arkivanov.decompose.value.Value
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Intent
import dev.icerock.moko.mvvm.flow.CFlow

interface EnterNameComponent {

    val enterNameState: Value<EnterNameStore.State>
    val enterNameLabels: CFlow<EnterNameStore.Label>
    fun acceptEnterName(intent: Intent)
}
