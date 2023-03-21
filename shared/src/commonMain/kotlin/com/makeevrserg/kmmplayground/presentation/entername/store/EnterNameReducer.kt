package com.makeevrserg.kmmplayground.presentation.entername.store

import com.arkivanov.mvikotlin.core.store.Reducer

object EnterNameReducer : Reducer<EnterNameStore.State, EnterNameStoreFactory.Message> {
    override fun EnterNameStore.State.reduce(msg: EnterNameStoreFactory.Message): EnterNameStore.State {
        return when (msg) {
            is EnterNameStoreFactory.Message.Entered -> {
                (this as? EnterNameStore.State.Loaded)?.copy(name = msg.value) ?: this
            }

            is EnterNameStoreFactory.Message.FirstLoaded -> {
                EnterNameStore.State.Loaded(
                    name = msg.value,
                    settingsName = msg.value,
                    isLoading = false
                )
            }

            is EnterNameStoreFactory.Message.SetLoading -> {
                (this as? EnterNameStore.State.Loaded)?.copy(isLoading = msg.state) ?: this
            }
        }
    }
}
