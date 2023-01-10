package com.didi.map.global.flow.utils;

import android.content.Context;
import com.sdk.poibase.store.PoiStore;

public class WaitingSceneCache {

    /* renamed from: a */
    private static final String f29807a = "Key_Has_Show_Recommend_Pickup";

    /* renamed from: b */
    private PoiStore f29808b;

    /* renamed from: c */
    private Context f29809c;

    /* renamed from: d */
    private boolean f29810d;

    /* renamed from: e */
    private boolean f29811e = true;

    public WaitingSceneCache(Context context) {
        this.f29809c = context;
    }

    /* renamed from: a */
    private void m23096a() {
        Context context = this.f29809c;
        if (context != null && !this.f29810d && this.f29811e) {
            this.f29808b = PoiStore.getInstance(context);
            this.f29810d = true;
        }
    }

    public void setSupported(boolean z) {
        this.f29811e = z;
    }

    public void setRecommendPickupStatus(boolean z) {
        m23096a();
        PoiStore poiStore = this.f29808b;
        if (poiStore != null) {
            poiStore.putAndSave(f29807a, z);
        }
    }

    public boolean hasShowedRecommendPickup() {
        m23096a();
        PoiStore poiStore = this.f29808b;
        if (poiStore != null) {
            return poiStore.getBoolean(f29807a, false);
        }
        return false;
    }
}
