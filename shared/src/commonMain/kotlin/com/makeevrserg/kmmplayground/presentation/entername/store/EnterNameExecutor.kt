package com.makeevrserg.kmmplayground.presentation.entername.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.makeevrserg.kmmplayground.data.preferences.LocalPreferencesRepository
import com.makeevrserg.mobilex.ktx_core.platform.KDispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EnterNameExecutor(
    private val localPreferencesRepository: LocalPreferencesRepository
) : CoroutineExecutor<EnterNameIntent, Nothing, EnterNameState, EnterNameMessage, EnterNameLabel>() {

    override fun executeIntent(intent: EnterNameIntent, getState: () -> EnterNameState) {
        when (intent) {
            is EnterNameIntent.Entered -> EnterNameMessage.Entered(intent.value).also(::dispatch)
            EnterNameIntent.LoadValue -> {
                val value = localPreferencesRepository.name.loadValue()
                EnterNameMessage.FirstLoaded(value).also(::dispatch)
            }

            EnterNameIntent.SaveValue -> {
                val state = getState.invoke() as? EnterNameState.Loaded ?: return
                EnterNameMessage.SetLoading(true).also(::dispatch)
                scope.launch(KDispatchers.IO) {
                    delay(1000)
                    val newName = state.name
                    localPreferencesRepository.name.saveValue(newName)
                    withContext(KDispatchers.Main) {
                        EnterNameIntent.LoadValue.also(::executeIntent)
                        EnterNameLabel.Successful.also(::publish)
                    }
                }
            }
        }
    }
}
