package com.didi.entrega.customer.p114h5.hybird;

import android.webkit.GeolocationPermissions;
import android.webkit.WebView;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.soda.web.widgets.SodaWebChromeClient;

/* renamed from: com.didi.entrega.customer.h5.hybird.CustomerHybridWebChromeClient */
public class CustomerHybridWebChromeClient extends SodaWebChromeClient {

    /* renamed from: a */
    private WebChromeClientCallback f22028a;

    public CustomerHybridWebChromeClient(FusionWebView fusionWebView, WebChromeClientCallback webChromeClientCallback) {
        super(fusionWebView);
        this.f22028a = webChromeClientCallback;
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        WebChromeClientCallback webChromeClientCallback = this.f22028a;
        if (webChromeClientCallback != null) {
            webChromeClientCallback.onProgressChanged(webView, i);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        WebChromeClientCallback webChromeClientCallback = this.f22028a;
        if (webChromeClientCallback != null) {
            webChromeClientCallback.onReceivedTitle(webView, str);
        }
    }
}
