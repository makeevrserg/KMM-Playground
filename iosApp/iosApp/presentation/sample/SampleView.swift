//
//  SampleView.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import Foundation
import SwiftUI
import MultiPlatformLibrary


struct SampleView: View {
    let root: RootComponent
    let greeting: Greeting
    
    


    var body: some View {
        NavigationView {
            VStack {
                let logoResource = MR.images().logo
                Image(logoResource.assetImageName, bundle: logoResource.bundle).resizable().frame(width: 32.0, height: 32.0)
                
                
                Text(greeting.platform.sharedHelloWorldAsRaw().localized())
                Text(greeting.platform.sharedHelloWorldAsResource().localized())
            }
            .navigationBarTitle("First Tab", displayMode: .large)
  
        }
    }
}
