//
//  CounterView.swift
//  iosApp
//
//  Created by Roman Makeev on 31.01.2023.
//

import SwiftUI
import MultiPlatformLibrary
import Resources
import Combine

struct CounterView: View {
    private let root: RootComponent
    private let child: RootConfigurationCounter
    private let counterComponent: CounterComponent
    @ObservedObject
    private var state: ObservableValue<CounterStoreState>
    @State
    private var toastData: ToastData = ToastData(message: "", isShowed: false)
    struct ToastData{
        var message: String
        var isShowed: Bool
    }
    init(root: RootComponent, child: RootConfigurationCounter) {
        self.root = root
        self.child = child
        self.counterComponent = child.counterComponent
        self.state = ObservableValue(self.counterComponent.counterState)
    }

    
    var body: some View {
        let model = state.value
        
        return VStack{
            
            Text(model.value.description)
            Button("+"){
                counterComponent.acceptCounterIntent(intent: CounterStoreIntentIncrement())
            }
            Button("-"){
                counterComponent.acceptCounterIntent(intent: CounterStoreIntentDecrement())
                
            }
        }.onReceive(createPublisher(counterComponent.counterLabels)){ label in
            toastData = ToastData(message: "\(label)", isShowed: true)
        }.toast(isDisplayed: $toastData.isShowed, text: toastData.message)
    }
}
