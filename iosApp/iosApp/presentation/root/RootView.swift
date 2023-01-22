//
//  RootView.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import Foundation
import SwiftUI
import shared

struct RootView: View{
    private let root: RootComponent
    
    @ObservedObject
    private var childStack: ObservableValue<ChildStack<AnyObject, RootComponentChild>>
    
    private var stack: ChildStack<AnyObject, RootComponentChild> { childStack.value }
    
    init(_ root: RootComponent) {
        self.root = root
        childStack = ObservableValue(root.childStack)
    }
    
    var body: some View {
        StackView(
            stackValue: childStack,
            getTitle: { $0.description },
            onBack: root.pop,
            childContent: { c in
                ChildView(child: c,root: root)
            }
        )
    }
}

struct SelectionView: View {
    private let root: RootComponent
    
    init(_ root: RootComponent) {
        self.root = root
    }
    
    var body: some View {
        VStack(alignment: .center, spacing: 8) {
            Button("Open rick and morty", action: root.onRickMortyClicked)

            Button("Open sample", action: root.onSampleClicked)
            
            Button("Replace with sample", action: root.onReplaceSampleClicked)
        }
        .navigationBarTitle("Selection screen", displayMode: .inline)
    }
}

private struct ChildView: View {
    let child: RootComponentChild
    let root: RootComponent
    
    var body: some View {
        switch child {
        case let child as RootComponentChild.RickMortyChild: CustomView(text: "RickMorty")
        case let child as RootComponentChild.SampleScreen: CustomView(text: "Sample")
        case let child as RootComponentChild.ScreenSelectionChild: SelectionView(root)
        default: EmptyView()
        }
    }
}

struct CustomView: View{
    let text: String
    var body: some View{
        Text(text)
    }
}
