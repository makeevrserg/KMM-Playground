package com.makeevrserg.kmmplayground.domain.storage

import com.makeevrserg.mobilex.ktx_core.storage.DefaultFlowStorageValue
import com.makeevrserg.mobilex.ktx_core.storage.FlowStorageValue
import com.russhwolf.settings.Settings

class StringFlowStorageValue(
    settings: Settings,
    key: String,
    default: String,
) : FlowStorageValue<String> by DefaultFlowStorageValue(
    default = default,
    loadSettingsValue = { settings.getString(key, default) },
    saveSettingsValue = { settings.putString(key, it) }
)