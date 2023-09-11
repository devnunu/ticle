package com.devnunu.ticle.buildsrc

object DependencyInfo {
    object AndroidX {

        const val core = "androidx.core:core-ktx:1.9.0"
        const val appCompat = "androidx.appcompat:appcompat:1.6.0"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
    }

    object Compose {
        const val bom = "androidx.compose:compose-bom:2023.06.01"

        const val ui = "androidx.compose.ui:ui"
        const val uiGraphics = "androidx.compose.ui:ui-graphics"
        const val uiTooling = "androidx.compose.ui:ui-tooling"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val material = "androidx.compose.material:material"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:3.1.2"
        const val android = "io.insert-koin:koin-android:3.1.2"
    }
}