//
//  CounterBinding.swift
//  iosApp
//
//  Created by Roman Makeev on 12.02.2023.
//

import Foundation
import SwiftUI
import MultiPlatformLibrary
import Combine
import mokoMvvmFlowSwiftUI


extension CalculatorViewModel {
    var countState: String {
        get {
            return self.state(
                \.stateFlow,
                equals: { $0 === $1 },
                 mapper: { state in state.value.description }
            )
        }
    }
}
