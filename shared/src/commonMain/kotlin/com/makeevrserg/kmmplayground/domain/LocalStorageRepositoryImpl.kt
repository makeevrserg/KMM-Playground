package com.makeevrserg.kmmplayground.domain

import com.makeevrserg.kmmplayground.domain.storage.StringFlowStorageValue
import com.makeevrserg.mobilex.ktx_core.storage.FlowStorageValue
import com.russhwolf.settings.Settings

class LocalStorageRepositoryImpl(
    private val settings: Settings
) : LocalStorageRepository {
    override val name: FlowStorageValue<String> = StringFlowStorageValue(settings, "NAME", "")
}

