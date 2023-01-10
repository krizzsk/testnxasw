package com.didi.safetoolkit.business.bubble.model;

import com.google.gson.Gson;

public class SfJarvisRspStore {

    /* renamed from: a */
    private static SfJarvisRspStore f37042a;

    /* renamed from: b */
    private SfJarvisData f37043b;

    public static SfJarvisRspStore getInstance() {
        SfJarvisRspStore sfJarvisRspStore = f37042a;
        if (sfJarvisRspStore != null) {
            return sfJarvisRspStore;
        }
        SfJarvisRspStore sfJarvisRspStore2 = new SfJarvisRspStore();
        f37042a = sfJarvisRspStore2;
        return sfJarvisRspStore2;
    }

    public void setSfJarvisRspData(SfJarvisData sfJarvisData) {
        this.f37043b = sfJarvisData;
    }

    public SfJarvisData getSfJarvisRspData() {
        return this.f37043b;
    }

    public void clearSfJarvisRspData() {
        this.f37043b = null;
    }

    public String getSfJarvisRspStr() {
        if (this.f37043b == null) {
            return "{}";
        }
        return new Gson().toJson((Object) this.f37043b);
    }
}
