plugins {
    id(Config.ApplyPlugins.ANDROID_LIBRARY)
    kotlin(Config.ApplyPlugins.Kotlin.ANDROID)
    id(Config.ApplyPlugins.MAVEN_PUBLISH)
}

android {
    compileSdk = Config.AndroidSdkVersions.COMPILE_SDK
    buildToolsVersion = Config.AndroidSdkVersions.BUILD_TOOLS
    namespace = "com.bottlerocketstudios.launchpad.compose"

    defaultConfig {
        minSdk = Config.AndroidSdkVersions.MIN_SDK
        targetSdk = Config.AndroidSdkVersions.TARGET_SDK
        aarMetadata {
            minCompileSdk = Config.AndroidSdkVersions.MIN_COMPILE_SDK
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true // Enables Jetpack Compose for this module
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.Compose.COMPOSE_COMPILER_VERSION
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}


dependencies {
    kotlinDependencies()
    coroutineDependencies()
    composeDependencies()
    accompanistDependencies()
}

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                // Applies the component for the release build variant.
                from(components["release"])

                groupId = "com.github.BottleRocketStudios"
                artifactId = "Android-LaunchPad-Compose"
                version = "0.4.0"
            }
        }
    }
}