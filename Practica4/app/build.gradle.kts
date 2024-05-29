plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.demo_celsius_activities_db"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.demo_celsius_activities_db"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation("org.apache.poi:poi:5.2.3")
    implementation("org.apache.poi:poi-ooxml:5.2.3")
    implementation(libs.swiperefreshlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("org.apache.poi:poi:5.2.3") // Para archivos XLS
    implementation("org.apache.poi:poi-ooxml:5.2.3") // Para archivos XLSX
    implementation("org.apache.xmlbeans:xmlbeans:5.1.1") // Necesaria para el soporte de archivos OOXML
    implementation ("org.apache.commons:commons-collections4:4.4")// Dependencia necesaria para POI
    implementation ("org.apache.commons:commons-compress:1.21") // Dependencia necesaria para POI
}