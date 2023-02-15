//
//  ToastModifier.swift
//  iosApp
//
//  Created by Roman Makeev on 15.02.2023.
//

import Foundation
import SwiftUI

struct ToastModifier: ViewModifier {
    @Binding var isDisplayed: Bool
    let duration: TimeInterval
    let text: String
    func body(content: Content) -> some View {
        ZStack {
            content
            if isDisplayed {
                VStack {
                    Spacer()
                    HStack {
                        Text(text)
                    }
                    .frame(minWidth: 0, maxWidth: .infinity)
                    .padding()
                    .cornerRadius(5)
                    .shadow(radius: 5)
                    .onAppear {
                        DispatchQueue.main.asyncAfter(deadline: .now() + duration) {
                            withAnimation {
                                isDisplayed = false
                            }
                        }
                    }
                }
            }
        }
    }
}

extension View {
    func toast(isDisplayed: Binding<Bool>, text: String, duration: TimeInterval = 3) -> some View {
        modifier(ToastModifier(isDisplayed: isDisplayed, duration: duration, text: text))
    }
}
