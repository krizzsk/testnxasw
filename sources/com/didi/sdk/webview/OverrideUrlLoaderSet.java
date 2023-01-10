package com.didi.sdk.webview;

import android.webkit.WebView;
import java.util.LinkedHashSet;
import java.util.Set;

public class OverrideUrlLoaderSet implements OverrideUrlLoader {

    /* renamed from: a */
    private Set<OverrideUrlLoader> f41103a = new LinkedHashSet();

    public void addOverrideUrlLoader(OverrideUrlLoader overrideUrlLoader) {
        if (overrideUrlLoader != null) {
            this.f41103a.add(overrideUrlLoader);
        }
    }

    public boolean removeOverrideUrlLoader(OverrideUrlLoader overrideUrlLoader) {
        return this.f41103a.remove(overrideUrlLoader);
    }

    public void clearAllOverrideUrlLoaders() {
        this.f41103a.clear();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        for (OverrideUrlLoader shouldOverrideUrlLoading : this.f41103a) {
            if (shouldOverrideUrlLoading.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
        }
        return false;
    }
}
