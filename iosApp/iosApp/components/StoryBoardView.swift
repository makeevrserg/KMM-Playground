//
//  StoryBoardView.swift
//  iosApp
//
//  Created by Roman Makeev on 29.12.2022.
//

import SwiftUI

import Foundation
import Foundation
import SwiftUI

struct StoryBoardView: UIViewControllerRepresentable {
    var name: String
    var identifier: String

    func makeUIViewController(context: Context) -> some UIViewController {
        let storyboard = UIStoryboard(name: name, bundle: Bundle.main)
        let controller = storyboard.instantiateViewController(withIdentifier: identifier)
        return controller
    }

    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {

    }
}

var MainStoryboardScreen: StoryBoardView {
    get {
        return StoryBoardView(name: "Main", identifier: "MainStoryboard")
    }
}

