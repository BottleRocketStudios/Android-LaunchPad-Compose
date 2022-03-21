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
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}