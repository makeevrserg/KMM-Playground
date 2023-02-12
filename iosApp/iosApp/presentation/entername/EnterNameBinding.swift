//
//  EnterNameBinding.swift
//  iosApp
//
//  Created by Roman Makeev on 12.02.2023.
//

import Foundation
import SwiftUI
import MultiPlatformLibrary
import Combine
import mokoMvvmFlowSwiftUI


extension EnterNameViewModel {
    var state: EnterNameState {
        get {
            return self.state(
                \.enterNameState,
                equals: { $0 === $1 },
                 mapper: { state in state }
            )
        }
    }

   
}
