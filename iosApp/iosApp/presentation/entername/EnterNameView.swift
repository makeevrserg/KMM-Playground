//
//  EnterNameView.swift
//  iosApp
//
//  Created by Roman Makeev on 12.02.2023.
//

import SwiftUI
import MultiPlatformLibrary
import Combine
import mokoMvvmFlowSwiftUI

struct EnterNameView: View {
    private let root: RootComponent
    private let child: RootConfigurationEnterName
    private let enterNameComponent: EnterNameComponent
    @ObservedObject
    private var state: ObservableValue<EnterNameStoreState>
    
    @State var isSuccesfullToastShowed = false
    
    init(root: RootComponent, child: RootConfigurationEnterName) {
        self.root = root
        self.child = child
        self.enterNameComponent = child.enterNameComponent
        self.state = ObservableValue(self.enterNameComponent.enterNameState)
    }
    
    var body: some View {
        let stateModel = state.value
        return EnterNameContent(state: stateModel){ intent in
            enterNameComponent.acceptEnterName(intent: intent)
        }.onReceive(createPublisher(enterNameComponent.enterNameLabels)) { label in
            isSuccesfullToastShowed = true
        }.toast(isDisplayed: $isSuccesfullToastShowed, text: "Successfully saved!")
    }
}


private struct EnterNameContent: View{
    let state: EnterNameStoreState
    let onIntent: (EnterNameStoreIntent) -> Void

    var body: some View {
        let stateKs = EnterNameStoreStateKs(state)
        switch stateKs {
        case .loaded(let loadedState): VStack {
            let inputNameBinding = Binding(get: { loadedState.name }, set: { value in onIntent(EnterNameStoreIntentEntered(value: value)) })
            TextField(text: inputNameBinding) {
                Text("Input name")
            }.disabled(loadedState.isLoading)
            Button(action:{
                onIntent(EnterNameStoreIntentSaveValue())
            },label:{
              Text("Save")
            }).disabled(!state.isButtonEnabled)

        }
        case .loading: Text("Loading")
        }
    }
}
