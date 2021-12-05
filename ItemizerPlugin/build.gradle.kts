dependencies {
    api(project(":ItemizerAPI"))
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("project" to project)
        }
        outputs.upToDateWhen { false }
    }
}