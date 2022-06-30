package com.github.googee.symfonybuilder.file

class Ignore(val fm: FileManager) {

    val FileName = ".gitignore"

    fun make() {
        val file = fm.getBuilderFile(FileName)
        if (FileManager.isFile(file)) {
            return
        }
        FileManager.makeFolder(file)
        FileManager.write(file, "*")
    }

}
