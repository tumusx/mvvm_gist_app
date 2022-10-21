buildscript {

    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.42")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath ("com.google.gms:google-services:4.3.14")
    }
}

plugins {
    id ("com.android.library") version "7.2.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.10" apply false
    id ("com.google.dagger.hilt.android") version "2.42" apply false
    id("com.android.application") version "7.2.2" apply false
}


tasks.register(name= "type", type = Delete::class){
    delete(rootProject.buildDir)
}