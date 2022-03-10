plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

BuildInfoManager.initialize(
    BuildInfoInput(
        appVersion = AppVersion(major = 0, minor = 1, patch = 0, hotfix = 0, showEmptyPatchNumberInVersionName = true), // TODO: TEMPLATE - Replace with appropriate app version
        brandName = "BR_LaunchPad_Compose", // TODO: TEMPLATE - Replace with appropriate project brand name
        productionReleaseVariantName = "productionRelease",
        rootProjectDir = rootDir
    )
)


android {
    compileSdk = Config.AndroidSdkVersions.COMPILE_SDK
    buildToolsVersion = Config.AndroidSdkVersions.BUILD_TOOLS

    defaultConfig {
        minSdk = Config.AndroidSdkVersions.MIN_SDK
        targetSdk = Config.AndroidSdkVersions.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        isCoreLibraryDesugaringEnabled = true
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

    // Kotlin/coroutines
    kotlinDependencies()
    coroutineDependencies()


    // AndroidX
    composeDependencies()

//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}