//
//  ScreenChooser.swift
//  IOS-Playground
//
//  Created by Roman Makeev on 29.12.2022.
//

import Foundation
import SwiftUI
import XNavigation
import UIKit
import shared

struct ScreenChooser: View {
    
    @EnvironmentObject var navigation: Navigation
    let greet = Greeting().greeting()


    var body: some View {
        NavigationView {
            VStack {
                let logoResource = MR.images().logo
                Image(logoResource.assetImageName, bundle: logoResource.bundle).resizable().frame(width: 32.0, height: 32.0)
                
                ChooserButton(title: "Button", navigation: navigation) {
                    MainStoryboardScreen
                }
                Text(greet)
            }
            .navigationBarTitle("First Tab", displayMode: .large)
  
        }
    }
}

struct ChooserButton<T>: View where T: View{
    
    var title: String
    var navigation: Navigation
    var viewBuilder: () -> T
    
    var body: some View {
        Button(action: {
            navigation.pushView(viewBuilder(), animated: true)
        }) {
            Text(title)
                .padding(8)
                .cornerRadius(8)
            
        }
    }
    
}

struct BackgroundButton: View {
    var title: String
    var onClick: () -> Void
    
    var body: some View {
        Button(action: {
            onClick()
        }) {
            Text(title)
                .padding(8)
                .cornerRadius(8)
            
        }
    }
}
