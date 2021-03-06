package com.github.googee.symfonybuilder

import com.github.googee.symfonybuilder.bridge.CodeFactory
import com.github.googee.symfonybuilder.bridge.RequestManager
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
            val uri = Site.getFullURI(fm)
            val browser = BrowserFactory.make(uri)
            val rm = RequestManager(fm, project)
            val cf = CodeFactory(browser, rm)
            val view = BuilderView(browser)
            val handler = JCEFLoadHandler(view, cf)
            browser.jbCefClient.addLoadHandler(handler, browser.cefBrowser)
            return view
        }
    }
}