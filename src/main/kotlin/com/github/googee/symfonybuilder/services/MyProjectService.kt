package com.github.googee.symfonybuilder.services

import com.intellij.openapi.project.Project
import com.github.googee.symfonybuilder.MyBundle
import com.github.googee.symfonybuilder.Start
import com.github.googee.symfonybuilder.view.BuilderView

class MyProjectService(val project: Project) {
    private var _view: BuilderView? = null
    val view: BuilderView
        get() {
            if (_view == null) {
                _view = Start.run(project)
            }
            return _view as BuilderView
        }

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
