package com.makeevrserg.kmmplayground.domain

import com.makeevrserg.mobilex.ktx_core.storage.FlowStorageValue

interface LocalStorageRepository {
    val name: FlowStorageValue<String>
}
