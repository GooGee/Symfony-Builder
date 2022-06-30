package com.github.googee.symfonybuilder.file

class Site {
    companion object {

        const val Key = "URI"

        const val URI = "https://googee.github.io/Code-Diagram-Page"

        fun getURI(fm: FileManager): String {
            // build plugin
            val uriFile = fm.getBuilderFile(Key)
            if (FileManager.isFile(uriFile)) {
                return FileManager.read(uriFile)
            }

            // runIde
            val uri = System.getenv(Key)
            if (uri.isNullOrEmpty()) {
                return URI + "/build" + Version.get()
            }
            return uri
        }
    }
}
