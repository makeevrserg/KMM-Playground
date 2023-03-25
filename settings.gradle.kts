pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

rootProject.name = "KMM-Playground"
include(":desktop")
// Services
include(":modules:services:resources")
include(":modules:services:core")
include(":modules:services:core-ui")
include(":modules:services:data-preferences")
// Features
include(":modules:features:shared-ui")
include(":modules:features:root")
include(":modules:features:common")
