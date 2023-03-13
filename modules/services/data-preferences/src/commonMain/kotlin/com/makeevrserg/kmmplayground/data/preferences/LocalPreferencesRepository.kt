package com.makeevrserg.kmmplayground.data.preferences

import com.makeevrserg.mobilex.ktx_core.storage.FlowStorageValue

interface LocalPreferencesRepository {
    val name: FlowStorageValue<String>
}
