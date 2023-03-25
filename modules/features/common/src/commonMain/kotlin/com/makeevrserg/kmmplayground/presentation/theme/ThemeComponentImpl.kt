package com.makeevrserg.kmmplayground.presentation.theme

import com.arkivanov.decompose.ComponentContext
import com.makeevrserg.kmmplayground.data.preferences.LocalPreferencesRepository
import com.makeevrserg.kmmplayground.data.preferences.models.ThemeEnum

class ThemeComponentImpl(
    componentContext: ComponentContext,
    private val localPreferencesRepository: LocalPreferencesRepository
) : ComponentContext by componentContext, ThemeComponent {
    override fun onDefaultDarkThemeClicked() {
        localPreferencesRepository.themeValue.saveValue(ThemeEnum.DEFAULT_DARK)
    }

    override fun onDefaultLightThemeClicked() {
        localPreferencesRepository.themeValue.saveValue(ThemeEnum.DEFAULT_LIGHT)
    }
}
