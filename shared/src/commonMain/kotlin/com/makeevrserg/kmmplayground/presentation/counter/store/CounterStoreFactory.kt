package com.makeevrserg.kmmplayground.presentation.counter.store

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.makeevrserg.mobile.di_container.Factory
import com.makeevrserg.mobilex.ktx_core.platform.KotlinDispatchers


class CounterStoreFactory(
    private val storeFactory: StoreFactory
) : Factory<CounterStore>() {
    override fun initializer(): CounterStore {
        return CounterStoreImpl(
            storeFactory = storeFactory
        )
    }
}