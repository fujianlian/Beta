package com.beta.beta

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.settings.builtInZoomControls = false// support zoom
        webView.settings.useWideViewPort = true// 这个很关键
        webView.settings.loadWithOverviewMode = true
        webView.settings.domStorageEnabled = true// h5兼容
        webView.settings.allowFileAccess = true
        webView.settings.setAppCacheEnabled(true)

        webView.webChromeClient = MyChromeClient()
        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://bzb.global:5001")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack()//返回上一页面
                return true
            } else {
                finish()
            }
        }
        return super.onKeyDown(keyCode, event)
    }


    internal open inner class MyChromeClient : WebChromeClient() {

        override fun onReceivedTitle(view: WebView, titles: String) {

        }
    }
}
