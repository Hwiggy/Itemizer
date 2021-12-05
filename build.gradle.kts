plugins {
    kotlin("jvm") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

allprojects {
    group = "me.hwiggy.minecraft"
    version = "1.0-SNAPSHOT"

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.github.johnrengelman.shadow")

    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://nexus.mcdevs.us/repository/mcdevs")
        maven("https://repo.codemc.org/repository/maven-public/")
    }

    dependencies {
        compileOnly("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
        compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    }

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
}