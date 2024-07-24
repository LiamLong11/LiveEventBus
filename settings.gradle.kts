pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(uri("https://jitpack.io"))
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(uri("https://jitpack.io"))
    }
}

include(":app")
include(":liveeventbus-x")
include(":lebx-processor-gson")
