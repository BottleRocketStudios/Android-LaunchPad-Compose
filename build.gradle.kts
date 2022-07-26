// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Config.BuildScriptPlugins.ANDROID_GRADLE)
        classpath(Config.BuildScriptPlugins.KOTLIN_GRADLE)
    }
}

plugins {
    id(Config.ApplyPlugins.KT_LINT) version Config.KTLINT_GRADLE_VERSION
    id(Config.ApplyPlugins.MAVEN_PUBLISH)
    id(Config.ApplyPlugins.DETEKT) version Config.DETEKT_VERSION
}

detekt {
    config = files("$rootDir/config/detekt/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
        xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
        txt.required.set(true) // similar to the console output, contains issue signature to manually edit baseline files
    }
}
