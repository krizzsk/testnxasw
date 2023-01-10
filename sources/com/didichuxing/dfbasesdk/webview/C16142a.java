package com.didichuxing.dfbasesdk.webview;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.didichuxing.dfbasesdk.act.DFBaseAct;
import com.didichuxing.dfbasesdk.utils.IOUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.taxis99.R;
import java.io.InputStream;

/* renamed from: com.didichuxing.dfbasesdk.webview.a */
/* compiled from: DFWebChromeClient */
class C16142a extends WebChromeClient {

    /* renamed from: a */
    private boolean f49607a;

    C16142a() {
    }

    public void onProgressChanged(WebView webView, int i) {
        LogUtils.m37052d("Webview", "newProgress=" + i + ", mJSInjected=" + this.f49607a);
        if (i < 25) {
            if (this.f49607a) {
                this.f49607a = false;
            }
        } else if (!this.f49607a) {
            m37141a(webView);
            this.f49607a = true;
        }
        Context context = webView.getContext();
        if (context instanceof DFWebviewAct) {
            ((DFWebviewAct) context).mo122552a(i);
        } else if (context instanceof DFBaseWebViewActivity) {
            ((DFBaseWebViewActivity) context).updateWebProgress(i);
        }
        super.onProgressChanged(webView, i);
    }

    /* renamed from: a */
    private void m37141a(WebView webView) {
        InputStream inputStream = null;
        try {
            inputStream = webView.getResources().openRawResource(R.raw.diface_jsbridge);
            C16146d.m37143a(webView, IOUtils.toString(inputStream));
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        } catch (Throwable th) {
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
        IOUtils.closeQuietly(inputStream);
    }

    public void onReceivedTitle(WebView webView, String str) {
        LogUtils.m37052d("Webview", "title=" + str);
        Context context = webView.getContext();
        if (context instanceof DFBaseAct) {
            ((DFBaseAct) context).setActTitle(str);
        }
        super.onReceivedTitle(webView, str);
    }

    public void onConsoleMessage(String str, int i, String str2) {
        LogUtils.m37058i("Webview", "message=" + str + ", lineNum=" + i + ", sourceID=" + str2);
        super.onConsoleMessage(str, i, str2);
    }

    public void onCloseWindow(WebView webView) {
        LogUtils.m37052d("Webview", "onCloseWindow");
        super.onCloseWindow(webView);
    }
}
