import com.devnunu.ticle.buildsrc.DependencyInfo
import com.devnunu.ticle.buildsrc.configuration.configAndroidModule

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

configAndroidModule(rootProject, enableCompose = false)
android {
    namespace = "com.devnunu.ticle.util"
}
dependencies {

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}