plugins {
    `kotlin-dsl`
}
dependencies {
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.toolsBuild)
    implementation("org.jetbrains.compose:compose-gradle-plugin:${libs.versions.kotlin.jbcompose.get()}")
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.detekt.gradle)
}