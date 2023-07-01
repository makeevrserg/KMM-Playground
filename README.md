# KMM Playground [Deprecated]

See real life implementation of KMM application on [Empire Projekt Mobile](https://github.com/makeevrserg/EmpireProjekt-Mobile)

### **Platforms**

- [x] IOS - shared logic; native UI
- [x] JVM - shared logic and Compose UI
- [x] Android - shared logic and Compose UI
- [ ] JS - Not yet implemented

### This example provides:

- [x] Shared resources usage(Strings, Images)
- [x] Shared navigation usage via Decompose
- [x] Shared logic usage via MVI-Kotlin and moko-MVVM
- [x] Shared UI via decompose on Desktop/Android
- [x] DI without fraemwork

## The Stack

| What           | Library               |
|----------------|-----------------------|
| DI             | ServiceLocator        |
| Async          | Coroutines            |
| Navigation     | Decompose             |
| MVI            | MVI-Kotlin            |
| UI-Shared      | Compose               |
| UI-ios         | SwiftUI               |
| Resources      | MokoResources         |
| MVVM           | Moko-MVVM             |
| Local settings | russhwolf-MPP Setting |

## Directory structure

    ├── build-logic                 # Build convention
    ├── desktop                     # Desktop/Android app
    ├── iosApp                      # IOS native swiftUI + Storyboard app
    ├── shared                      # shared code
    ├── modules                     # Shared UI for Desktop/Android
    │   ├── features                # Authorize Screen
    │   │   └── shared-ui           # Shared UI JBCompose
    │   ├── services            
    │   │   ├── core                # Core data
    │   │   ├── core-ui             # Core ui
    │   │   ├── data-preferences    # Local preferences  
    └── └── └── resources           # Resources
