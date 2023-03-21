package com.makeevrserg.kmmplayground.data.preferences.models

import com.makeevrserg.mobilex.ktx_core.storage.DefaultFlowStorageValue
import com.makeevrserg.mobilex.ktx_core.storage.FlowStorageValue
import com.russhwolf.settings.Settings

internal class EnumFlowStorageValue<T : Enum<T>>(
    settings: Settings,
    key: String,
    default: T,
    values: Array<T>
) : FlowStorageValue<T> by DefaultFlowStorageValue(
    default = default,
    loadSettingsValue = {
        val ordinal = settings.getInt(key, default.ordinal)
        values.getOrElse(ordinal) { default }
    },
    saveSettingsValue = { settings.putInt(key, it.ordinal) }
)
