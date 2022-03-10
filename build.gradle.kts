// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Config.BuildScriptPlugins.ANDROID_GRADLE)
        classpath(Config.BuildScriptPlugins.KOTLIN_GRADLE)
//        classpath(Config.BuildScriptPlugins.GRADLE_VERSIONS)
//        classpath(Config.BuildScriptPlugins.NAVIGATION_SAFE_ARGS_GRADLE)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}


plugins {
}

