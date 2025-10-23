plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
}

android {
    namespace = "com.chikara.jetpackcomposeseries"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.chikara.jetpackcomposeseries"
        minSdk = 28
        targetSdk = 35
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    // ✅ Updated Compose compiler for Kotlin 2.0–2.1 support
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.32.0")

    // Extra Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")

    // Compose
    implementation("androidx.compose.material:material:1.5.0")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // ⭐️ FIX: Replaced the incorrect `jvmstubs` dependency with the correct AndroidX Compose Navigation dependency.
    implementation("androidx.navigation:navigation-compose:2.7.7") // ✅ CORRECT dependency

    // Networking (Retrofit + OkHttp)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    // implementation(libs.androidx.navigation.compose.jvmstubs) // ❌ REMOVED: This caused the "Implemented only in JetBrains fork" error.

//    // Coil (image loading)
//    implementation("io.coil-kt:coil-compose:2.3.0")
//    implementation(libs.androidx.runtime.livedata)

    // Tests
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debug
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")

    // ✅ Firebase (compatible with Kotlin 2.0+)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)

    // Data Serializable
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
}

//dependencies {
//
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
//    implementation("com.google.accompanist:accompanist-systemuicontroller:0.32.0")
//
//    // Extra Kotlin
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")
//
//    // Compose
//    implementation("androidx.compose.material:material:1.5.0")
//
//    // Lifecycle
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
//
//    // Networking (Retrofit + OkHttp)
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation("com.squareup.okhttp3:okhttp:4.11.0")
//    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
//
//    // Coroutines
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
//    implementation(libs.androidx.navigation.compose.jvmstubs)
//
////    // Coil (image loading)
////    implementation("io.coil-kt:coil-compose:2.3.0")
////    implementation(libs.androidx.runtime.livedata)
//
//    // Tests
////    testImplementation(libs.junit)
////    androidTestImplementation(libs.androidx.junit)
////    androidTestImplementation(libs.androidx.espresso.core)
////    androidTestImplementation(platform(libs.androidx.compose.bom))
////    androidTestImplementation(libs.androidx.ui.test.junit4)
//
//    // Debug
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
//    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")
//
//    // ✅ Firebase (compatible with Kotlin 2.0+)
//    implementation(libs.firebase.auth)
//    implementation(libs.androidx.credentials)
//    implementation(libs.androidx.credentials.play.services.auth)
//    implementation(libs.googleid)
//
//    // Data Serializable
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
//
////    testImplementation(libs.junit)
////    androidTestImplementation(libs.androidx.junit)
////    androidTestImplementation(libs.androidx.espresso.core)
////    androidTestImplementation(platform(libs.androidx.compose.bom))
////    androidTestImplementation(libs.androidx.ui.test.junit4)
////    debugImplementation(libs.androidx.ui.tooling)
////    debugImplementation(libs.androidx.ui.test.manifest)
//}
