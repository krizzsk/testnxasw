package com.didichuxing.dfbasesdk.webview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didichuxing.dfbasesdk.utils.LogUtils;

/* renamed from: com.didichuxing.dfbasesdk.webview.b */
/* compiled from: DFWebViewClient */
class C16143b extends WebViewClient {
    C16143b() {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        LogUtils.m37052d("Webview", "onPageStarted, url===" + str);
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        LogUtils.m37052d("Webview", "onPageFinished, url===" + str);
        super.onPageFinished(webView, str);
    }
}
