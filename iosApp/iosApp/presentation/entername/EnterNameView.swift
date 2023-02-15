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
    let root: CNavigationComponent<RootScreen, RootConfiguration>
    let child: RootConfigurationEnterName
    @ObservedObject var viewModel: EnterNameViewModel
    init(root: CNavigationComponent<RootScreen, RootConfiguration>, child: RootConfigurationEnterName, viewModel: EnterNameViewModel) {
        self.root = root
        self.child = child
        self.viewModel = viewModel
    }
    var body: some View {
        EnterNameContent(state: viewModel.state){ intent in
            viewModel.acceptEnterName(intent: intent)
        }
    }
}
private struct EnterNameContent: View{
    let state: EnterNameState
    let onIntent: (EnterNameIntent) -> Void

    var body: some View {
        let stateKs = EnterNameStateKs(state)
        switch stateKs {
        case .loaded(let loadedState): VStack {
            let inputNameBinding = Binding(get: { loadedState.name }, set: { value in onIntent(EnterNameIntentEntered(value: value)) })
            TextField(text: inputNameBinding) {
                Text("Input name")
            }
            Button(action:{
                onIntent(EnterNameIntentSaveValue())
            },label:{
              Text("Save")
            }).disabled(!state.isButtonEnabled)

        }
        case .loading: Text("Loading")
        }
    }
}
