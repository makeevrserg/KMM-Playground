import com.makeevrserg.kmmplayground.Application

plugins {
    id("kmm-library-convention")
    id("dev.icerock.mobile.multiplatform-resources")
    kotlin("native.cocoapods")
}

kotlin {
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../../../iosApp/Podfile")
        framework {
            baseName = "Resources"
            isStatic = false
            // Resources
            export(libs.moko.resources.core)
            export(libs.moko.graphics)
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.moko.resources.core)
            }
        }
    }
}
android {
    namespace = Application.APPLICATION_ID + ".resources"
}
multiplatformResources {
    multiplatformResourcesPackage = Application.APPLICATION_ID + ".resources"
}