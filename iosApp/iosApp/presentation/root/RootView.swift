//
//  RootView.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import Foundation
import SwiftUI
import MultiPlatformLibrary

struct RootView: View{
    private let root: CNavigationComponent<RootScreen, RootConfiguration>
    
    @ObservedObject
    private var childStack: ObservableValue<ChildStack<RootScreen, RootConfiguration>>
    
    private var stack: ChildStack<RootScreen, RootConfiguration> { childStack.value }
    
    init(_ root: CNavigationComponent<RootScreen, RootConfiguration>) {
        self.root = root
        childStack = ObservableValue(root.childStack)
    }
    
    var body: some View {
        StackView(
            stackValue: childStack,
            getTitle: { child in
                "Title"
            },
            onBack: {
                root.pop()
            },
            childContent: { c in
                ChildView(child: c,root: root)
            }
        )
    }
}

