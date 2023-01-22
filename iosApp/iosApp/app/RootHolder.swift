//
//  RootHolder.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import Foundation
import shared

class RootHolder : ObservableObject {
    let lifecycle: LifecycleRegistry
    let root: RootComponent

    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()

        root = DefaultRootComponent(
            componentContext: DefaultComponentContext(
                lifecycle: lifecycle,
                stateKeeper: nil,
                instanceKeeper: nil,
                backHandler: nil
            )
        )

        lifecycle.onCreate()
    }

    deinit {
        lifecycle.onDestroy()
    }
}
