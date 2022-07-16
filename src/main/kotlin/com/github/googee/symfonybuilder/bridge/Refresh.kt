package com.github.googee.symfonybuilder.bridge

import com.github.googee.symfonybuilder.file.FileManager

class Refresh {
    companion object {
        val action = ActionEnum.refresh

        fun run(): Response {
            FileManager.refresh()
            return Response.ok(action.name, "", "")
        }
    }
}
