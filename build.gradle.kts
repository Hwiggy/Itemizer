plugins {
    kotlin("jvm") version "1.5.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "me.hwiggy.minecraft"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://nexus.mcdevs.us/repository/mcdevs")
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly("org.spigotmc:spigot-api:1.17.1-R0.1-SNAPSHOT")
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.8.0")
}

tasks {
    compileKotlin {
        kotlinOptions.freeCompilerArgs = listOf(
            "-Xjvm-default=all"
        )
    }

    processResources {
        filesMatching("plugin.yml") {
            expand("project" to project)
        }
        outputs.upToDateWhen { false }
    }
}