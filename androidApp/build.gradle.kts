plugins {
    id("android-app-convention")
}

android {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = "1.3.0"
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":shared-ui"))
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.foundation:foundation:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    // Moko
    implementation(libs.moko.resources.core)
    implementation(libs.moko.resources.compose)
}