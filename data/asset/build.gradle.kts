import com.devnunu.ticle.buildsrc.DependencyInfo
import com.devnunu.ticle.buildsrc.configuration.configAndroidModule

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

configAndroidModule(rootProject, enableCompose = false)
android {
    namespace = "com.devnunu.ticle.data.asset"
}
dependencies {

    implementation(project(":model:asset"))

    implementation(DependencyInfo.AndroidX.core)
    implementation(DependencyInfo.AndroidX.lifecycleRuntimeKtx)

    implementation(DependencyInfo.Koin.core)
    implementation(DependencyInfo.Koin.android)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}