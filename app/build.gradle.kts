plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.connectmqtt"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.connectmqtt"
        minSdk = 29
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding=true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5")
//    implementation ("androidx.work:work-runtime:2.7.1")
//    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("com.github.hannesa2:paho.mqtt.android:3.3.5")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("com.github.hannesa2:paho.mqtt.android:3.3.5@aar")
    implementation ("androidx.room:room-runtime:2.3.0")
    implementation ("com.jakewharton.timber:timber:5.0.1")

// Add below to fix Runtime error(ClassNotFoundException)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")

// Lottie dependency
     implementation ("com.airbnb.android:lottie:6.4.0")

}