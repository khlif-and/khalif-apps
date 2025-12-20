import java.util.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.baselineprofile)
}

android {
    namespace = "com.nafaskarya.muslimdaily"
    compileSdk = 34

    val keystorePropertiesFile = rootProject.file("keystore.properties")
    val keystoreProperties = Properties()
    if (keystorePropertiesFile.exists()) {
        keystoreProperties.load(FileInputStream(keystorePropertiesFile))
    }

    signingConfigs {
        create("release") {
            if (keystorePropertiesFile.exists()) {
                keyAlias = keystoreProperties.getProperty("keyAlias")
                keyPassword = keystoreProperties.getProperty("keyPassword")
                storeFile = file(keystoreProperties.getProperty("storeFile"))
                storePassword = keystoreProperties.getProperty("storePassword")
            }
        }
    }

    defaultConfig {
        applicationId = "com.nafaskarya.muslimdaily"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = "18"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.window)
    implementation(libs.androidx.profileinstaller)
    "baselineProfile"(project(":baselineprofile"))

    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)

    implementation(libs.androidx.material3)
    implementation(libs.androidx.material3.windowSizeClass)
    implementation(libs.androidx.material.icons.extended)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.datastore.preferences)
    implementation(libs.protobuf.javalite)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.kotlinx.coroutines.play.services)
    implementation(libs.play.services.location)

    implementation(libs.coil.compose)
    implementation(libs.coil.gif)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.shimmer)
    implementation(libs.timber)

    implementation(libs.landscapist.coil)
    implementation(libs.landscapist.animation)
    implementation(libs.landscapist.placeholder)

    implementation(libs.androidx.work.runtime.ktx)

    coreLibraryDesugaring(libs.desugar.jdk.libs)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}