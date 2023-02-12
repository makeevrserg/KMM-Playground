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
    let child: RootConfiguration
    let root: RootComponent
    
    var body: some View {
        switch child{
        case let child as RootConfigurationCalculator: Text("Rick and morty")
        case let child as RootConfigurationSampleScreen: Text("Rick and morty")
        case let child as RootConfigurationScreenSelector: Text("Rick and morty")
        case let child as RootConfigurationRickAndMorty: Text("Rick and morty")
        default: Text("None")
        }
    }
}
