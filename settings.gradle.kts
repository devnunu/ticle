pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ticle"
include(":app")
include(":core:ui")
include(":core:base")
include(":data:asset")
include(":model:asset")
include(":util")
include(":navigation:api")
include(":navigation:impl")
