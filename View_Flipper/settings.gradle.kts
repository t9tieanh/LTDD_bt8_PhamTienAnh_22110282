pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven("https://jitpack.io")
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        gradlePluginPortal()
        maven { url = uri("https://maven.scijava.org/content/repositories/public/") }
        maven { url = uri("https://maven.localazy.com/repository/release/") }
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "View_Flipper"
include(":app")
 