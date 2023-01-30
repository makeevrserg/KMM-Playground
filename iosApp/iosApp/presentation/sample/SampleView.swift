//
//  SampleView.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import Foundation
import SwiftUI
import shared


struct SampleView: View {
    let root: RootComponent
    let greeting = Greeting()
    let greet = Greeting().greeting()
    
    init(_ root: RootComponent) {
        self.root = root
    }


    var body: some View {
        NavigationView {
            VStack {
                let logoResource = MR.images().logo
                Image(logoResource.assetImageName, bundle: logoResource.bundle).resizable().frame(width: 32.0, height: 32.0)
                
                Text(greet)
                Text(greeting.platform.sharedHelloWorldAsRaw().asString())
                Text(greeting.platform.sharedHelloWorldAsResource().asString())
            }
            .navigationBarTitle("First Tab", displayMode: .large)
  
        }
    }
}
