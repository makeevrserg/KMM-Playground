//
//  ScreenSelectorView.swift
//  iosApp
//
//  Created by Roman Makeev on 31.01.2023.
//

import SwiftUI
import shared

struct ScreenSelectorView: View {
    let child: RootComponentChild
    let root: RootComponent
    
    
    var body: some View {
        VStack(alignment: .center, spacing: 8) {
            Button("Open rick and morty", action: root.onShowRickMortyClicked)
            Button("Open sample", action: root.onShowSampleClicked)
            Button("Open counter", action: root.showCalculator)
            Button("Open GC", action: root.showGC)
        }
        .navigationBarTitle("Selection screen", displayMode: .inline)
    }
}
