package com.makeevrserg.kmmplayground.presentation.entername.store

sealed interface EnterNameState {
    val isLoading: Boolean
    val isButtonEnabled: Boolean

    object Loading : EnterNameState {
        override val isLoading: Boolean = true
        override val isButtonEnabled: Boolean = false
    }

    data class Loaded(
        val name: String,
        val settingsName: String,
        override val isLoading: Boolean
    ) : EnterNameState {
        override val isButtonEnabled: Boolean
            get() = name != settingsName && name.isNotBlank() && !isLoading
    }
}