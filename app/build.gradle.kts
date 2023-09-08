import com.devnunu.ticle.buildsrc.DependencyInfo
import com.devnunu.ticle.buildsrc.configuration.configAndroidModule

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

configAndroidModule(rootProject, enableCompose = true)
android {
    namespace = "com.devnunu.ticle"

    defaultConfig {
        applicationId = "com.devnunu.ticle"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":util"))

    implementation(project(":core:base"))

    implementation(project(":data:asset"))

    implementation(project(":model:asset"))

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

    implementation("org.orbit-mvi:orbit-core:6.0.0")
    implementation("org.orbit-mvi:orbit-viewmodel:6.0.0")

    // test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}