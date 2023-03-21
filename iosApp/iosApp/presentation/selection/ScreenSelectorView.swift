//
//  ScreenSelectorView.swift
//  iosApp
//
//  Created by Roman Makeev on 31.01.2023.
//

import SwiftUI
import MultiPlatformLibrary

struct ScreenSelectorView: View {
    let root: RootComponent
    let child: RootConfigurationScreenSelector
    
    var body: some View {
        VStack(alignment: .center, spacing: 8) {
            Button("Open sample"){
                root.push(screen: RootChildSampleScreen())
                
            }
            Button("Open counter"){
                root.push(screen:RootChildCounter())
                
            }
            
            Button("Open NameEntering"){
                root.push(screen:RootChildEnterName())
                
            }
        }
        .navigationBarTitle("Selection screen", displayMode: .inline)
    }
}
