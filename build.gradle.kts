buildscript {
    dependencies {
        classpath(libs.moko.generator.network)
        classpath(libs.moko.generator.resources)
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.moko.kswift) apply false
    alias(libs.plugins.kotlin.jbcompose) apply false
    id("lint-convention")
}

tasks.register("cleanX", Delete::class) {
    fun clearProject(project:Project){
        project.childProjects.values.forEach(::clearProject)
        delete(project.buildDir)
    }
    clearProject(rootProject)
}
