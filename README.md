# KMM Playground [WIP]
<p align="center">
    KMM Playground is a Kotlin Multiplatform application for IOS, JS and JVM example with shared logic
</p>

### **Platforms**
- [x] IOS - shared logic; native UI
- [x] JVM - shared logic and Compose UI
- [x] Android - shared logic and Compose UI
- [ ] JS - Not yet implemented

## The Stack
| What | Library |
| ----------- | ----------- |
| DI | Koin |
| Async | Coroutines |
| Navigation | Decompose |
| UI-Shared | Compose |
| UI-ios | SwiftUI |
| Resources | MokoResources |
| MVVM | Moko-MVVM |
| Local settings | russhwolf-MPP Setting |

## Directory structure
    
    ├── androidApp          # Mobile app
    ├── build-logic         # Build convention
    ├── desktop             # Desktop app
    ├── iosApp              # IOS native swiftUI + Storyboard app
    ├── shared              # shared code
    └── shared-ui           # Shared UI for Desktop/Android
