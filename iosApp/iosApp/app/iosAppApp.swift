//
//  iosAppApp.swift
//  iosApp
//
//  Created by Roman Makeev on 22.01.2023.
//

import SwiftUI
import shared
import MongoSwift

@main
struct iosAppApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate
    init(){
        Modules.shared.setPlatformEncoder(encoder: SwiftEncoder())
    }
    
    private var rootHolder: RootHolder { appDelegate.getRootHolder() }
    
    var body: some Scene {
        WindowGroup {
            RootView(rootHolder.root)
                .onAppear { LifecycleRegistryExtKt.resume(self.rootHolder.lifecycle) }
                .onDisappear { LifecycleRegistryExtKt.stop(self.rootHolder.lifecycle) }
        }
    }
}


class SwiftEncoder: PlatformEncoder{
    func fromByteArray(byteString: KotlinByteArray) -> String {
    }
    
    func fromByteString(byteString: OkioByteString) -> String {
        <#code#>
    }
    
    func toByteArray(string: String) -> KotlinByteArray {
        
        let encoder = BSONEncoder()
        let encoded = try! encoder.encode(string)
        encoded.bytes
    }
    
    func toByteString(string: String) -> OkioByteString {
        <#code#>
    }
    
    
}
