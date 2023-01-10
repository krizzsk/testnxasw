package com.didi.sdk.paxadsdk.repo;

import android.view.View;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdCacheManager {

    /* renamed from: a */
    private Map<String, View> f39691a = new HashMap();

    public View matchCachedNativeAdView(List<String> list) {
        for (String next : list) {
            if (matchCachedNativeAdView(next) != null) {
                return matchCachedNativeAdView(next);
            }
        }
        return null;
    }

    public View matchCachedNativeAdView(String str) {
        return this.f39691a.get(str);
    }

    public void cacheNativeAdView(String str, View view) {
        this.f39691a.put(str, view);
    }

    public void clearCache() {
        this.f39691a.clear();
    }
}
