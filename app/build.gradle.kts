plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.newsappwithmvvmclean"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newsappwithmvvmclean"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
//        buildConfigField("String","API_KEY","77af850922f8452497c842704f0f50bb")
//        buildConfigField("String","BASE_URL","https://newsapi.org/")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources=true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    kapt {
        correctErrorTypes = true
        useBuildCache = true
    }
}

dependencies {


    val room_version = "2.6.1"
//    Room
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
// To use Kotlin annotation processing tool (kapt)
    kapt ("androidx.room:room-compiler:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

//    ViewModel & Livedata
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
    // Lifecycles only (without ViewModel or LiveData)
    implementation(libs.androidx.lifecycle.runtime.ktx)

//    Retrofit
    implementation(libs.converter.gson)
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation (libs.gson)

//    Hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)

//    Glide
    implementation(libs.glide)

//    Navigation
    // Views/Fragments integration
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

//    Firebase
    implementation(libs.firebase.analytics)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}