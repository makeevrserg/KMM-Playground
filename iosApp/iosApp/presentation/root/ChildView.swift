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
        switch child {
        case let child as RootComponentChild.RickMortyChild: Text("RM")
        case let child as RootComponentChild.SampleScreen: SampleView(root)
        case let child as RootComponentChild.ScreenSelectionChild: SelectionView(root)
        default: EmptyView()
        }
    }
}
