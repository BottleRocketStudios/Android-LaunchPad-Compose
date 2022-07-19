import org.gradle.api.artifacts.dsl.DependencyHandler

// Provides dependencies that can be used throughout the project build.gradle files

// https://github.com/JetBrains/kotlin/blob/master/ChangeLog.md
// https://github.com/JetBrains/kotlin/releases/latest
// https://plugins.jetbrains.com/plugin/6954-kotlin
// https://kotlinlang.org/docs/reference/whatsnew15.html
// https://kotlinlang.org/docs/releases.html#release-details
// TODO: Update corresponding buildSrc/build.gradle.kts value when updating this version!
private const val KOTLIN_VERSION = "1.7.0"
private const val KOTLIN_COROUTINES_VERSION = "1.6.0"
private const val NAVIGATION_VERSION = "2.3.5"

/**
 * Provides the source of truth for version/configuration information to any gradle build file (project and app module build.gradle.kts)
 */
object Config {
    // https://github.com/JLLeitschuh/ktlint-gradle/blob/master/CHANGELOG.md
    // https://github.com/JLLeitschuh/ktlint-gradle/releases
    const val KTLINT_GRADLE_VERSION = "10.2.1"


    // https://android-developers.googleblog.com/2021/09/accelerated-kotlin-build-times-with.html
    // https://github.com/google/ksp/blob/main/docs/quickstart.md
    // https://github.com/google/ksp/releases
    // TODO: First part of version should match version of kotlin - see https://github.com/google/ksp/blob/main/docs/faq.md
    const val KSP_VERSION = "1.6.10-1.0.2"

    /**
     * Called from root project buildscript block in the project root build.gradle.kts
     */
    object BuildScriptPlugins {
        // https://developer.android.com/studio/releases/gradle-plugin
        // TODO: Update corresponding buildSrc/build.gradle.kts value when updating this version!
        const val ANDROID_GRADLE = "com.android.tools.build:gradle:7.1.1"
        const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    }

    /**
     * Called in non-root project modules via id()[org.gradle.kotlin.dsl.PluginDependenciesSpecScope.id]
     * or kotlin()[org.gradle.kotlin.dsl.kotlin] (the PluginDependenciesSpec.kotlin extension function) in a build.gradle.kts
     */
    object ApplyPlugins {
        const val ANDROID_LIBRARY = "com.android.library"
        const val KT_LINT = "org.jlleitschuh.gradle.ktlint"
        object Kotlin {
            const val ANDROID = "android"
        }
        const val MAVEN_PUBLISH = "maven-publish"
    }

    // What each version represents - https://medium.com/androiddevelopers/picking-your-compilesdkversion-minsdkversion-targetsdkversion-a098a0341ebd
    object AndroidSdkVersions {
        const val COMPILE_SDK = 31
        const val MIN_COMPILE_SDK = 29

        // https://developer.android.com/studio/releases/build-tools
        const val BUILD_TOOLS = "31.0.0"
        const val MIN_SDK = 23 // TODO: TEMPLATE - Replace with appropriate project minSdkVersion

        // https://developer.android.com/about/versions/12/behavior-changes-12
        const val TARGET_SDK = 31
    }

    object Compose {
        const val COMPOSE_VERSION = "1.2.0-rc03"
        const val COMPOSE_COMPILER_VERSION = "1.2.0"
    }

}

/**
 * Dependency Version definitions with links to source (if open source)/release notes. Defines the version in one place for multiple dependencies that use the same version.
 * Use [DependencyHandler] extension functions below that provide logical groupings of dependencies including appropriate configuration accessors.
 */
private object Libraries {
    //// AndroidX
    // All androidx dependencies version table: https://developer.android.com/jetpack/androidx/versions#version-table
    // https://developer.android.com/jetpack/androidx/releases/core
    // https://developer.android.com/kotlin/ktx#core-packages
    // https://developer.android.com/jetpack/androidx/releases/
    // https://developer.android.com/kotlin/ktx

    // https://developer.android.com/jetpack/androidx/releases/core
    const val CORE_KTX = "androidx.core:core-ktx:1.7.0"

    // https://developer.android.com/jetpack/androidx/releases/appcompat
    const val APP_COMPAT = "androidx.appcompat:appcompat:1.4.1"

    // Compose
    // Compose-Kotlin version compatibility matrix: https://developer.android.com/jetpack/androidx/releases/compose-kotlin
    // https://developer.android.com/jetpack/androidx/releases/compose
    private const val COMPOSE_VERSION = Config.Compose.COMPOSE_VERSION
    private const val COMPOSE_COMPILER_VERSION = Config.Compose.COMPOSE_COMPILER_VERSION
    const val COMPOSE_COMPILER = "androidx.compose.compiler:compiler:$COMPOSE_COMPILER_VERSION"
    const val COMPOSE_UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
    // Tooling support (Previews, etc.)
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:$COMPOSE_VERSION"
    const val COMPOSE_ANIMATION = "androidx.compose.animation:animation:$COMPOSE_VERSION"
    // Material Design
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:$COMPOSE_VERSION"
    // Material design icons
    const val COMPOSE_MATERIAL_ICONS_CORE = "androidx.compose.material:material-icons-core:$COMPOSE_VERSION"
    const val COMPOSE_MATERIAL_ICONS_EXTENDED = "androidx.compose.material:material-icons-extended:$COMPOSE_VERSION"
    // Integration with observables
    const val COMPOSE_LIVE_DATA = "androidx.compose.runtime:runtime-livedata:$COMPOSE_VERSION"

    // Accompanist
    // https://github.com/google/accompanist/releases
    private const val ACCOMPANIST_VERSION = "0.24.5-alpha"
    const val ACCOMPANIST_WEBVIEW = "com.google.accompanist:accompanist-webview:$ACCOMPANIST_VERSION"
    const val ACCOMPANIST_NAVIGATION_ANIMATION = "com.google.accompanist:accompanist-navigation-animation:$ACCOMPANIST_VERSION"

    // UI Tests
    const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-junit4:$COMPOSE_VERSION"


    // Navigation
    // https://developer.android.com/jetpack/androidx/releases/navigation
    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"
    const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:2.4.0-rc01"

    //// Kotlin
    const val KOTLIN_STDLIB_JDK7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$KOTLIN_VERSION"
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:$KOTLIN_VERSION"

    //// Coroutines + Flow
    // https://kotlinlang.org/docs/reference/coroutines/flow.html
    // https://github.com/Kotlin/kotlinx.coroutines/blob/master/CHANGES.md
    // https://github.com/Kotlin/kotlinx.coroutines/releases
    const val KOTLINX_COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$KOTLIN_COROUTINES_VERSION"
    const val KOTLINX_COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$KOTLIN_COROUTINES_VERSION"

}

/**
 * test and/or androidTest specific dependencies.
 * Use [DependencyHandler] extension functions below that provide logical groupings of dependencies including appropriate configuration accessors.
 */
private object TestLibraries {
    // https://github.com/junit-team/junit4/releases
    // https://github.com/junit-team/junit4/blob/master/doc/ReleaseNotes4.13.md
    const val JUNIT = "junit:junit:4.13.2"

    // main site: https://google.github.io/truth/
    // comparison to other assertion libs: https://google.github.io/truth/comparison
    // benefits: https://google.github.io/truth/benefits
    // javadocs: https://truth.dev/api/1.0/
    // https://github.com/google/truth/releases
    const val TRUTH = "com.google.truth:truth:1.1.3"

    // https://github.com/mockito/mockito-kotlin/wiki/Mocking-and-verifying
    // https://github.com/mockito/mockito-kotlin/releases
    const val MOCKITO_KOTLIN = "org.mockito.kotlin:mockito-kotlin:4.0.0"

    //// AndroidX - testing
    // https://developer.android.com/jetpack/androidx/releases/arch
    const val ARCH_CORE_TESTING = "androidx.arch.core:core-testing:2.1.0"
    const val ANDROIDX_TEST_CORE = "androidx.test:core:1.4.0"
    const val ANDROIDX_TEST_CORE_KTX = "androidx.test:core-ktx:1.4.0"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
    const val JUNIT_EXT_RUNNER = "androidx.test.ext:junit:1.1.3"
    const val JUNIT_EXT_RUNNER_KTX = "androidx.test.ext:junit-ktx:1.1.3"

    //// Kotlinx Coroutine - Testing
    // https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-test/
    const val KOTLINX_COROUTINE_TESTING = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$KOTLIN_COROUTINES_VERSION"

    // Turbine - small emission testing lib for flows (hot or cold)
    // https://github.com/cashapp/turbine/blob/trunk/CHANGELOG.md
    // https://github.com/cashapp/turbine/releases
    const val TURBINE = "app.cash.turbine:turbine:0.7.0"
}

//// Dependency Groups - to be used inside dependencies {} block instead of declaring all necessary lines for a particular dependency
//// See DependencyHandlerUtils.kt to define DependencyHandler extension functions for types not handled (ex: compileOnly).
//// More info in BEST_PRACTICES.md -> Build section
fun DependencyHandler.kotlinDependencies() {
    implementation(Libraries.KOTLIN_STDLIB_JDK7)
    implementation(Libraries.KOTLIN_REFLECT)
}

fun DependencyHandler.coroutineDependencies() {
    implementation(Libraries.KOTLINX_COROUTINES_CORE)
    implementation(Libraries.KOTLINX_COROUTINES_ANDROID)
}

fun DependencyHandler.composeDependencies() {
    implementation(Libraries.COMPOSE_COMPILER)
    implementation(Libraries.COMPOSE_UI)
    implementation(Libraries.COMPOSE_UI_TOOLING)
    implementation(Libraries.COMPOSE_FOUNDATION)

    implementation(Libraries.COMPOSE_ANIMATION)
    implementation(Libraries.COMPOSE_MATERIAL)
    implementation(Libraries.COMPOSE_MATERIAL_ICONS_CORE)
    implementation(Libraries.COMPOSE_MATERIAL_ICONS_EXTENDED)
    implementation(Libraries.COMPOSE_LIVE_DATA)
}

fun DependencyHandler.accompanistDependencies() {
    implementation(Libraries.ACCOMPANIST_WEBVIEW)
    implementation(Libraries.ACCOMPANIST_NAVIGATION_ANIMATION)
}

fun DependencyHandler.appCompatDependencies() {
    implementation(Libraries.APP_COMPAT)
}

fun DependencyHandler.coreKtxDependencies() {
    implementation(Libraries.CORE_KTX)
}


// Test specific dependency groups
fun DependencyHandler.junitDependencies() {
    testImplementation(TestLibraries.JUNIT)
}

fun DependencyHandler.mockitoKotlinDependencies() {
    testImplementation(TestLibraries.MOCKITO_KOTLIN)
}

fun DependencyHandler.truthDependencies() {
    testImplementation(TestLibraries.TRUTH)
}

fun DependencyHandler.archCoreTestingDependencies() {
    testImplementation(TestLibraries.ARCH_CORE_TESTING)
}

fun DependencyHandler.espressoDependencies() {
    androidTestImplementation(TestLibraries.ESPRESSO_CORE)
}

fun DependencyHandler.androidxCoreDependencies() {
    androidTestImplementation(TestLibraries.ANDROIDX_TEST_CORE)
    androidTestImplementation(TestLibraries.ANDROIDX_TEST_CORE_KTX)
}

fun DependencyHandler.extJunitRunnerDependencies() {
    androidTestImplementation(TestLibraries.JUNIT_EXT_RUNNER)
    androidTestImplementation(TestLibraries.JUNIT_EXT_RUNNER_KTX)
}

fun DependencyHandler.kotlinxCoroutineTestingDependencies() {
    testImplementation(TestLibraries.KOTLINX_COROUTINE_TESTING)
}

fun DependencyHandler.turbineDependencies() {
    testImplementation(TestLibraries.TURBINE)
}
