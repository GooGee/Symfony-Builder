package com.github.googee.symfonybuilder.services

import com.intellij.openapi.project.Project
import com.github.googee.symfonybuilder.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
