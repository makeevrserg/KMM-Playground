//
//  iosAppApp.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import SwiftUI
import MultiPlatformLibrary
import Resources
import ComposeApp

@main
struct iosAppApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate
    
    private var rootHolder: RootHolder { appDelegate.getRootHolder() }
    
    var body: some Scene {
        WindowGroup {
            ComposeContentView()
//            RootView(rootHolder.root)
//                .onAppear { LifecycleRegistryExtKt.resume(self.rootHolder.lifecycle) }
//                .onDisappear { LifecycleRegistryExtKt.stop(self.rootHolder.lifecycle) }
        }
    }
}
struct ComposeContentView: View {
    var body: some View {
       ComposeView()
    }
}

struct ComposeView: UIViewControllerRepresentable {
   func makeUIViewController(context: Context) -> UIViewController {
       MainKt.MainViewController()
   }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context){}
}
