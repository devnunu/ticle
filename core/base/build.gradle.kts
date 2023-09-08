import com.devnunu.ticle.buildsrc.DependencyInfo
import com.devnunu.ticle.buildsrc.configuration.configAndroidModule

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

configAndroidModule(rootProject, enableCompose = true)
android {
    namespace = "com.devnunu.ticle.core.base"
}
dependencies {

    implementation(DependencyInfo.AndroidX.core)
    implementation(DependencyInfo.AndroidX.appCompat)
    implementation(DependencyInfo.AndroidX.lifecycleRuntimeKtx)
    implementation(DependencyInfo.AndroidX.activityCompose)

    implementation(platform(DependencyInfo.Compose.bom))
    implementation(DependencyInfo.Compose.ui)
    implementation(DependencyInfo.Compose.uiGraphics)
    implementation(DependencyInfo.Compose.uiToolingPreview)
    implementation(DependencyInfo.Compose.material3)

    implementation(DependencyInfo.Koin.core)
    implementation(DependencyInfo.Koin.android)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}