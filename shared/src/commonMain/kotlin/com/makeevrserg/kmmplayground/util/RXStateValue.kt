package com.makeevrserg.kmmplayground.util

import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.rx.Disposable

fun <T : Any> Store<*, T, *>.stateValue(): Value<T> = RXStateValue(this)

private class RXStateValue<out T : Any>(
    private val store: Store<*, T, *>
) : Value<T>() {
    override val value: T get() = store.state
    private var disposables = emptyMap<(T) -> Unit, Disposable>()

    override fun subscribe(observer: (T) -> Unit) {
        val disposable = store.states(com.arkivanov.mvikotlin.rx.observer(onNext = observer))
        this.disposables += observer to disposable
    }

    override fun unsubscribe(observer: (T) -> Unit) {
        val disposable = disposables[observer] ?: return
        this.disposables -= observer
        disposable.dispose()
    }
}