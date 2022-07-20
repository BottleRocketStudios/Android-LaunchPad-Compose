#LaunchPad Quick Start for Android

The LaunchPad project is intended to be an aid for helping you bring your Android projects to market quickly without the need to reinvent the wheel.  It is open source and free to use.

## LaunchPad Compose
This library provides a collection of Compose widgets and utility functions with the goal of making coding in Compose that much easier.

## Contributing
This project is open source and we welcome updates from all devs.  Look to [`CONTRIBUTING.md`](./CONTRIBUTING.md) for information on how to help out.

## What's in this library
### Convenience Functions
* Check out [`ThemeExtensions.kt`](https://github.com/BottleRocketStudios/Android-LaunchPad-Compose/blob/b1e309bc6cfff82c3f985d055567704772683e1e/launchpad-compose/src/main/java/com/bottlerocketstudios/launchpad/compose/ThemeExtensions.kt) for a collection of easy to use functions for making your Compose Themes easier to read.

### Compose Widgets
* AnimatedListDetail - A ready to use Compose widget for creating a ListDetail view.  It uses AnimatedNavHost from Accompanist library to give a smooth feel during transitions. (___TO BE ADDED___)

## Usage
1. You'll need to add a dependency on jitpack to your project build.gradle.kts file. Make sure it is below primary maven repositories such as google() or mavenCentral() as it should have lower precedence in Gradle's dependency resolution process:

    ```kotlin
    allprojects {
	    repositories {
		    ... // likely already have google() and mavenCentral() above
		    maven(url = "https://jitpack.io")
	    }
    }
    ```
2. You'll need to add the following line to your module's build.gradle.kts:

    ```kotlin
    dependencies {
	    ...
	    implementation("com.github.BottleRocketStudios:Android-LaunchPad-Compose:0.3.0")
    }
    ```