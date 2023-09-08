package com.devnunu.ticle.buildsrc.configuration

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import com.devnunu.ticle.buildsrc.VersionInfo
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.withType
import java.io.FileInputStream
import java.util.Properties
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.configAndroidModule(
    rootProject: Project,
    enableCompose: Boolean = false
) {
    (this as ExtensionAware).extensions.configure("android", Action<BaseExtension> {
        configAndroidExtension(rootProject, enableCompose)
    })
}

fun BaseExtension.configAndroidExtension(rootProject: Project, enableCompose: Boolean) {
    setCompileSdkVersion(VersionInfo.compileSdkVersion)

    defaultConfig {
        targetSdk = VersionInfo.targetSdkVersion
        minSdk = VersionInfo.minSdkVersion
    }


    flavorDimensions("tier")

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_17)
        targetCompatibility(JavaVersion.VERSION_17)
    }

    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }

    rootProject.tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    if (enableCompose) {
        buildFeatures.compose = true

        composeOptions {
            kotlinCompilerExtensionVersion = "1.4.8"
        }
    }
}