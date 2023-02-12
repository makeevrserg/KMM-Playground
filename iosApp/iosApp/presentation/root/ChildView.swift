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
        let childKs = RootConfigurationKs(child)
        switch childKs {
            case .counter(let configuration): CounterView(root: root, child: configuration, viewModel: configuration.viewModel)
            case .enterName(let configuration): EnterNameView(root: root, child: configuration, viewModel: configuration.viewModel)
            case .rickAndMorty(let configuration): Text("RickAndMorty")
            case .sampleScreen(let configuration): SampleView(root: root, greeting: configuration.greeting)
            case .screenSelector(let configuration): ScreenSelectorView(root: root, child: configuration)
        }
    }
}
