plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)


    id("kotlin-kapt")
    id("kotlin-parcelize")
    kotlin("plugin.serialization") version "2.0.20"
    alias(libs.plugins.compose.compiler)


}

android {
    namespace = "io.github.junrdev.recycle"
    compileSdk = 35

    defaultConfig {
        applicationId = "io.github.junrdev.recycle"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }


    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //compose
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.androidx.compose.foundation)
    testImplementation(composeBom)
    androidTestImplementation(composeBom)

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Choose one of the following:
    // Material Design 3
    implementation(libs.androidx.material3)


    testImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.androidx.ui.test)

    // Optional - Add full set of material icons
    implementation(libs.androidx.material.icons.extended)

    // Optional - Integration with activities
    implementation(libs.androidx.activity.compose)

    implementation(libs.coil.compose)


    //camera
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
//    implementation(libs.androidx.camera.video)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.camera.extensions)

}