package com.github.googee.symfonybuilder.view

import com.github.googee.symfonybuilder.bridge.CodeFactory
import com.github.googee.symfonybuilder.file.Site
import org.cef.browser.CefBrowser
import org.cef.browser.CefFrame
import org.cef.handler.CefLoadHandler
import org.cef.network.CefRequest

class JCEFLoadHandler(val view: BuilderView, val cf: CodeFactory) : CefLoadHandler {

    override fun onLoadStart(p0: CefBrowser?, p1: CefFrame?, p2: CefRequest.TransitionType?) {
    }

    override fun onLoadingStateChange(p0: CefBrowser?, p1: Boolean, p2: Boolean, p3: Boolean) {
    }

    override fun onLoadError(
        p0: CefBrowser?,
        p1: CefFrame?,
        code: CefLoadHandler.ErrorCode?,
        text: String?,
        url: String?
    ) {
        view.showError("Cannot connect to " + Site.URI)
    }

    override fun onLoadEnd(p0: CefBrowser?, p1: CefFrame?, httpStatusCode: Int) {
        println("HTTP status: $httpStatusCode")
        if (httpStatusCode == 200) {
            view.showWeb()
            cf.inject()
        }
    }
}
