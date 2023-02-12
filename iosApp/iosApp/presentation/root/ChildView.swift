//
//  ChildView.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import Foundation
import SwiftUI
import MultiPlatformLibrary

struct ChildView: View {
    let child: RootConfiguration
    let root: CNavigationComponent<RootScreen, RootConfiguration>
    
    var body: some View {
        switch child{
        case let child as RootConfigurationCalculator: CounterView(root: root, child: child, viewModel: child.viewModel)
        case let child as RootConfigurationSampleScreen: Text("Rick and morty")
        case let child as RootConfigurationScreenSelector: ScreenSelectorView(root: root,child: child)
        case let child as RootConfigurationRickAndMorty: Text("Rick and morty")
        default: Text("None")
        }
    }
}
