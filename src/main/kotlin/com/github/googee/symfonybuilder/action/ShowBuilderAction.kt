package com.github.googee.symfonybuilder.action

import com.github.googee.symfonybuilder.vfs.BuilderVirtualFile
import com.github.googee.symfonybuilder.vfs.BuilderVirtualFileSystem
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager

class ShowBuilderAction : AnAction() {
    private var vf: BuilderVirtualFile? = null

    override fun actionPerformed(e: AnActionEvent) {
        if (e.project == null) {
            return
        }

        val manager = FileEditorManager.getInstance(e.project!!)
        if (vf == null) {
            vf = BuilderVirtualFile(BuilderVirtualFileSystem())
        }
        manager.openFile(vf!!, true)
    }
}