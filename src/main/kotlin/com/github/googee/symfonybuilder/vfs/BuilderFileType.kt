package com.github.googee.symfonybuilder.vfs

import com.github.googee.symfonybuilder.Constant
import com.intellij.openapi.fileTypes.ex.FakeFileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon
import javax.swing.ImageIcon

class BuilderFileType : FakeFileType() {
    companion object {
        val instance = BuilderFileType()
    }

    override fun getName(): String {
        return Constant.Title
    }

    override fun getDescription(): String {
        return Constant.Title
    }

    override fun getIcon(): Icon {
        return ImageIcon(javaClass.getResource("/image/icon.png"))
    }

    override fun isMyFileType(file: VirtualFile): Boolean {
        return file is BuilderVirtualFile
    }
}