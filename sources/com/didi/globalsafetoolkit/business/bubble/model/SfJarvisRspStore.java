package com.didi.globalsafetoolkit.business.bubble.model;

import com.google.gson.Gson;

public class SfJarvisRspStore {

    /* renamed from: a */
    private static SfJarvisRspStore f24956a;

    /* renamed from: b */
    private SfJarvisData f24957b;

    public static SfJarvisRspStore getInstance() {
        SfJarvisRspStore sfJarvisRspStore = f24956a;
        if (sfJarvisRspStore != null) {
            return sfJarvisRspStore;
        }
        SfJarvisRspStore sfJarvisRspStore2 = new SfJarvisRspStore();
        f24956a = sfJarvisRspStore2;
        return sfJarvisRspStore2;
    }

    public void setSfJarvisRspData(SfJarvisData sfJarvisData) {
        this.f24957b = sfJarvisData;
    }

    public SfJarvisData getSfJarvisRspData() {
        return this.f24957b;
    }

    public void clearSfJarvisRspData() {
        this.f24957b = null;
    }

    public String getSfJarvisRspStr() {
        if (this.f24957b == null) {
            return "{}";
        }
        return new Gson().toJson((Object) this.f24957b);
    }
}
