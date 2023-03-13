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
include(":androidApp")
include(":desktop")
include(":shared")
// Services
include(":modules:services:resources")
include(":modules:services:core")
include(":modules:services:data-preferences")
// Features
include(":modules:features:shared-ui")
