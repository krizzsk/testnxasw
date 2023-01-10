package com.didi.hawaii.mapsdkv2.adapter;

import android.content.Context;
import android.util.Pair;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.didi.hawaii.mapsdkv2.adapter.b */
/* compiled from: OverlayDelegate */
class C9761b {

    /* renamed from: a */
    final Map<String, Pair<?, GLOverlayView>> f26017a;
    protected final Context context;
    protected final GLViewManager viewManager;

    C9761b(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        this.viewManager = gLViewManager;
        this.f26017a = map;
        this.context = gLViewManager.getMapContext().getAndroidContext();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Pair<?, GLOverlayView> mo75428a(String str) {
        return this.f26017a.get(str);
    }

    /* access modifiers changed from: protected */
    public void add(String str, Object obj, GLOverlayView gLOverlayView) {
        this.viewManager.addView(gLOverlayView);
        this.f26017a.put(str, new Pair(obj, gLOverlayView));
    }

    /* access modifiers changed from: protected */
    public void remove(String str) {
        Pair remove = this.f26017a.remove(str);
        if (remove != null) {
            this.viewManager.removeView((GLOverlayView) remove.second);
        }
    }

    /* renamed from: a */
    static void m20575a(Map<String, Pair<?, GLOverlayView>> map, GLViewManager gLViewManager) {
        Iterator<Map.Entry<String, Pair<?, GLOverlayView>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            gLViewManager.removeView((GLOverlayView) ((Pair) it.next().getValue()).second);
            it.remove();
        }
    }
}
