# KMM Playground [WIP]
<p align="center">
    KMM Playground is a simple Kotlin Multiplatform application for IOS, JS and JVM example with shared logic
</p>

### **Platforms**
- [x] IOS - shared logic; native UI
- [x] JVM - shared logic and Compose UI
- [x] Android - shared logic and Compose UI
- [ ] JS - Not yet implemented

### This example provides:
- [x] Shared resources usage(Strings, Images)
- [x] Shared navigation usage via Deceompose
- [x] Shared logic usage via MVI-Kotlin and moko-MVVM
- [x] Shared UI via decompose on Desktop/Android
- [x] DI without fraemwork


## The Stack
| What | Library |
| ----------- | ----------- |
| DI | ServiceLocator |
| Async | Coroutines |
| Navigation | Decompose |
| UI-Shared | Compose |
| UI-ios | SwiftUI |
| Resources | MokoResources |
| MVVM | Moko-MVVM |
| MVI | MVI-Kotlin |
| Local settings | russhwolf-MPP Setting |

## Directory structure
    
    ├── androidApp          # Mobile app
    ├── build-logic         # Build convention
    ├── desktop             # Desktop app
    ├── iosApp              # IOS native swiftUI + Storyboard app
    ├── shared              # shared code
    ├── resources           # shared resources
    └── shared-ui           # Shared UI for Desktop/Android
