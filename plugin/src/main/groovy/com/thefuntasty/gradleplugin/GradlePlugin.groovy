package com.thefuntasty.gradleplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class GradlePlugin implements Plugin<Project> {

    void apply(Project project) {
        project.android.applicationVariants.all { variant ->
            String hash = 'git rev-parse --short HEAD'.execute([], project.rootDir).text.trim()
            if (hash.isEmpty()) {
                hash = ""
            }
            variant.buildConfigField "String", "HASH", "\"${hash}\""
        }
    }
}
