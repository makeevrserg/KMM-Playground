//
//  ScreenSelectorView.swift
//  iosApp
//
//  Created by Roman Makeev on 31.01.2023.
//

import SwiftUI
import MultiPlatformLibrary

struct ScreenSelectorView: View {
    let root: CNavigationComponent<RootScreen, RootConfiguration>
    let child: RootConfigurationScreenSelector
    
    var body: some View {
        VStack(alignment: .center, spacing: 8) {
            Button("Open rick and morty"){
                root.push(screen: RootScreenRickAndMorty())
            }
            Button("Open sample"){
                root.push(screen: RootScreenSampleScreen())
                
            }
            Button("Open counter"){
                root.push(screen:RootScreenCalculator())
                
            }
        }
        .navigationBarTitle("Selection screen", displayMode: .inline)
    }
}
