package com.didi.payment.base.view.webview.overrider;

import android.webkit.WebView;
import java.util.LinkedHashSet;
import java.util.Set;

public class OverrideUrlLoaderSet implements OverrideUrlLoader {

    /* renamed from: a */
    private Set<OverrideUrlLoader> f32512a = new LinkedHashSet();

    public void addOverrideUrlLoader(OverrideUrlLoader overrideUrlLoader) {
        if (overrideUrlLoader != null) {
            this.f32512a.add(overrideUrlLoader);
        }
    }

    public boolean removeOverrideUrlLoader(OverrideUrlLoader overrideUrlLoader) {
        return this.f32512a.remove(overrideUrlLoader);
    }

    public void clearAllOverrideUrlLoaders() {
        this.f32512a.clear();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        for (OverrideUrlLoader shouldOverrideUrlLoading : this.f32512a) {
            if (shouldOverrideUrlLoading.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
        }
        return false;
    }
}
