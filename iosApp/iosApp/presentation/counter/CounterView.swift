//
//  CounterView.swift
//  iosApp
//
//  Created by Roman Makeev on 31.01.2023.
//

import SwiftUI
import MultiPlatformLibrary
import Combine
import mokoMvvmFlowSwiftUI

struct CounterView: View {
    let root: CNavigationComponent<RootScreen, RootConfiguration>
    let child: RootConfigurationCounter
    @ObservedObject var viewModel: CounterViewModel
    
    var body: some View {
        Group{
            
            Text(viewModel.countState)
            Button("+"){
                viewModel.acceptCalculator(intent: CounterIntentIncrement())
            }
            Button("-"){
                viewModel.acceptCalculator(intent: CounterIntentDecrement())
                
            }
        }
    }
}
