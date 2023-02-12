//
//  ScreenSelectorView.swift
//  iosApp
//
//  Created by Roman Makeev on 31.01.2023.
//

import SwiftUI
import shared

struct ScreenSelectorView: View {
    let root: RootComponent
    
    
    var body: some View {
        VStack(alignment: .center, spacing: 8) {
            Button("Open rick and morty"){
                
            }
            Button("Open sample"){
                
            }
            Button("Open counter"){
                
            }
            Button("Open GC"){
                
            }
        }
        .navigationBarTitle("Selection screen", displayMode: .inline)
    }
}
