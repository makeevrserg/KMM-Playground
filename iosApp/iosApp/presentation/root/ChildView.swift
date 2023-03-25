//
//  ChildView.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import Foundation
import SwiftUI
import MultiPlatformLibrary
import Resources

struct ChildView: View {
    let child: RootConfiguration
    let root: RootComponent
    var body: some View {
        let childKs = RootConfigurationKs(child)
        switch childKs {
            case .counter(let configuration): CounterView(root: root, child: configuration)
            case .enterName(let configuration): EnterNameView(root: root, child: configuration)
            case .sampleScreen(let configuration): SampleView(root: root, greeting: configuration.greeting)
            case .screenSelector(let configuration): ScreenSelectorView(root: root, child: configuration)
        case .bottomNav(_):
            Text("BottomNav")
        case .connectionScreen(_):
            Text("Connection")
        case .theme(_):
            Text("Theme")
        }
    }
}
