package com.github.googee.symfonybuilder.file

import com.github.googee.symfonybuilder.Constant
import java.net.URLEncoder

class Site {
    companion object {

        const val Key = "URI"
        const val Server = "Server"
        const val URI = "https://googee.github.io/Symfony-Builder-Page"

        fun getURI(fm: FileManager): String {
            val file = fm.getBuilderFile(Key)
            if (FileManager.isFile(file)) {
                return FileManager.read(file)
            }

            val uri = System.getenv(Key)
            if (uri.isNullOrEmpty()) {
                return URI + "/build" + Version.get()
            }
            return uri
        }

        fun getFullURI(fm: FileManager): String {
            val uri = getURI(fm) + "?ide=idea&plugin=" + Constant.Title
            val file = fm.getBuilderFile(Server)
            if (FileManager.isFile(file)) {
                val serverURI = FileManager.read(file)
                return uri + "&server=" + URLEncoder.encode(serverURI, "UTF-8")
            }
            return uri
        }
    }
}
