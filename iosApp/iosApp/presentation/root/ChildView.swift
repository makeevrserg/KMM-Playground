//
//  ChildView.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import Foundation
import SwiftUI
import shared

struct ChildView: View {
    let child: RootComponentChild
    let root: RootComponent
    
    var body: some View {
        switch child{
        case let child as RootComponentChildCalculator: CounterView(component: child.component)
        case let child as RootComponentChildSampleScreen: SampleView(root)
        case let child as RootComponentChildScreenSelector: ScreenSelectorView(child: child, root: root)
        case let child as RootComponentChildGlavContact: GlavContactView(viewModel: child.viewModel)
        case let child as RootComponentChildRickAndMorty: Text("Rick and morty")
        default: Text("None")
        }
    }
}
