package com.makeevrserg.kmmplayground.data.preferences

import com.makeevrserg.kmmplayground.data.preferences.models.StringFlowStorageValue
import com.makeevrserg.mobilex.ktx_core.storage.FlowStorageValue
import com.russhwolf.settings.Settings

internal class LocalPreferencesRepositoryImpl(
    settings: Settings
) : LocalPreferencesRepository {
    override val name: FlowStorageValue<String> = StringFlowStorageValue(settings, "NAME", "")
}
