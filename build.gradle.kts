// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val composeVersion by extra("1.0.0")
    val kotlinSerializationVersion by extra("1.2.1")
    val composeActivityVersion by extra("1.3.0-beta02")
    val ktxCoreVersion by extra("1.5.0")
    val lifeCycleVersion by extra("2.3.1")
    val materialVersion by extra("1.3.0")
    val composeNavigationVersion by extra("2.4.0-alpha03")
    val dataStoreVersion by extra("1.0.0-beta02")
    val coroutinesVersion by extra("1.5.0-native-mt")
    val kotlinVersion by extra("1.5.10")
    val moshiVersion by extra(":1.11.0")
    val systemUIControllerVersion by extra("0.12.0")
    val espressoVersion by extra("3.3.0")
    val compose_version by extra("1.0.0")

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register(name = "clean", type = Delete::class) {
    delete(rootProject.buildDir)
}