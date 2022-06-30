package com.github.googee.symfonybuilder

import com.github.googee.symfonybuilder.file.FileManager
import com.github.googee.symfonybuilder.file.Site
import com.github.googee.symfonybuilder.view.BrowserFactory
import com.github.googee.symfonybuilder.view.BuilderView
import com.github.googee.symfonybuilder.view.JCEFLoadHandler
import com.intellij.openapi.project.Project

class Start {

    companion object {

        fun run(project: Project): BuilderView {
            val fm = FileManager(project)
            val uri = Site.getURI(fm) + "?ide=idea&plugin=" + Constant.Title
            val browser = BrowserFactory.make(uri)
            val view = BuilderView(browser)
            val handler = JCEFLoadHandler(view)
            browser.jbCefClient.addLoadHandler(handler, browser.cefBrowser)
            return view
        }
    }
}