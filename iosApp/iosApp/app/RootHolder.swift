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
    let root: CNavigationComponent<RootScreen, RootConfiguration>

    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        
        let component = DefaultRootComponent(
            componentContext: DefaultComponentContext(
                lifecycle: lifecycle,
                stateKeeper: nil,
                instanceKeeper: nil,
                backHandler: nil
            )
        )
        root = CNavigationComponent(component: component)

        lifecycle.onCreate()
    }

    deinit {
        lifecycle.onDestroy()
    }
}
