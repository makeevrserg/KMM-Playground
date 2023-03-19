package com.makeevrserg.kmmplayground.presentation.entername.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.makeevrserg.kmmplayground.data.preferences.LocalPreferencesRepository
import com.makeevrserg.mobilex.ktx_core.platform.KDispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Label
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.Intent
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStoreFactory.Message
import com.makeevrserg.kmmplayground.presentation.entername.store.EnterNameStore.State

class EnterNameExecutor(
    private val localPreferencesRepository: LocalPreferencesRepository
) : CoroutineExecutor<Intent, Nothing, State, Message, Label>() {

    override fun executeIntent(intent: Intent, getState: () -> State) {
        when (intent) {
            is Intent.Entered -> Message.Entered(intent.value).also(::dispatch)
            Intent.LoadValue -> {
                val value = localPreferencesRepository.name.loadValue()
                Message.FirstLoaded(value).also(::dispatch)
            }

            Intent.SaveValue -> {
                val state = getState.invoke() as? State.Loaded ?: return
                Message.SetLoading(true).also(::dispatch)
                scope.launch(KDispatchers.IO) {
                    delay(1000)
                    val newName = state.name
                    localPreferencesRepository.name.saveValue(newName)
                    withContext(KDispatchers.Main) {
                        Intent.LoadValue.also(::executeIntent)
                        Label.Successful.also(::publish)
                    }
                }
            }
        }
    }
}
