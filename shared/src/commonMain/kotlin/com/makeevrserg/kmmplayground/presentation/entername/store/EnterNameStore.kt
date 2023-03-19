package com.makeevrserg.kmmplayground.presentation.entername.store

import com.arkivanov.mvikotlin.core.store.Store
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Intent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Label
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.State

interface EnterNameStore : Store<Intent, State, Label> {
    sealed interface State {
        val isLoading: Boolean
        val isButtonEnabled: Boolean

        object Loading : State {
            override val isLoading: Boolean = true
            override val isButtonEnabled: Boolean = false
        }

        data class Loaded(
            val name: String,
            val settingsName: String,
            override val isLoading: Boolean
        ) : State {
            override val isButtonEnabled: Boolean
                get() = name != settingsName && name.isNotBlank() && !isLoading
        }
    }

    sealed interface Label {
        object Successful : Label
    }

    sealed interface Intent {
        class Entered(val value: String) : Intent
        object LoadValue : Intent
        object SaveValue : Intent
    }
}
