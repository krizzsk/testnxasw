package com.didi.sdk.payment.view.browser;

import com.didi.sdk.pay.base.PayBaseInjecter;

public class WebViewListenerHolder {

    /* renamed from: a */
    private static WebViewListener f39728a;

    public static WebViewListener getListener() {
        return f39728a;
    }

    public static void setListener(WebViewListener webViewListener) {
        f39728a = webViewListener;
        PayBaseInjecter.injectWebViewProxy(webViewListener);
    }
}
