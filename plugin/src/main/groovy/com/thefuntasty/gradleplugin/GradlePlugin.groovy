package com.thefuntasty.gradleplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class GradlePlugin implements Plugin<Project> {

    void apply(Project project) {
        String hash = 'git rev-parse --short HEAD'.execute([], project.rootDir).text.trim()
        project.android.applicationVariants.all { variant ->
            variant.buildConfigField "String", "HASH", "\"${hash}\""
        }
    }
}
