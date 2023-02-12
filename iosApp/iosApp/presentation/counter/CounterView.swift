//
//  CounterView.swift
//  iosApp
//
//  Created by Roman Makeev on 31.01.2023.
//

import SwiftUI
import shared
import Combine


struct CounterView: View {
    let component: CalculatorComponent
    let binding: Binding<CalculatorState>
    init(component: CalculatorComponent) {
        self.component = component
        binding = Binding(get: {
            component.state.value!
        }) { value, transaction in
            
        }
    }
    var body: some View {
        Group{
            
            Text(binding.wrappedValue.value.description)
            Button("+"){
                component.onIntent(intent: CalculatorIntentIncrement())
            }
            Button("-"){
                component.onIntent(intent: CalculatorIntentDecrement())
            }
        }
    }
}
