package com.github.googee.symfonybuilder.bridge

import com.github.googee.symfonybuilder.ErrorMessage
import com.github.googee.symfonybuilder.file.FileManager
import com.intellij.openapi.project.Project

class RequestManager(fm: FileManager, project: Project) {

    private val open: Open
    private val edit: Edit

    init {
        edit = Edit(project)
        open = Open()
    }

    fun handle(request: Request): Response {
        if (request.action == edit.action.name) {
            return edit.run(request)
        }
        if (request.action == open.action.name) {
            return open.run(request)
        }
        return Response.error(request.action, request.key, "", ErrorMessage.ActionNotFound)
    }
}