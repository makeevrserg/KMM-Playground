//
//  RootHolder.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import Foundation
import MultiPlatformLibrary

class RootHolder : ObservableObject {
    let lifecycle: LifecycleRegistry
    let root: RootComponent

    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        let serviceLocator = ServiceLocator.shared
        serviceLocator.platformConfigurationModule.initialize(value: CorePlatformConfiguration())
        let component = RootComponentImpl(
            componentContext: DefaultComponentContext(
                lifecycle: lifecycle,
                stateKeeper: nil,
                instanceKeeper: nil,
                backHandler: nil
            ),
            serviceLocator: serviceLocator
        )
        root = component

        lifecycle.onCreate()
    }

    deinit {
        lifecycle.onDestroy()
    }
}
