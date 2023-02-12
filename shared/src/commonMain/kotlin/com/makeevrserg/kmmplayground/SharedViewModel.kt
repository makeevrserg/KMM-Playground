package com.makeevrserg.kmmplayground

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import dev.icerock.moko.mvvm.viewmodel.ViewModel
abstract class SharedViewModel: ViewModel(), InstanceKeeper.Instance {
    override fun onDestroy() {
        onCleared()
    }
}