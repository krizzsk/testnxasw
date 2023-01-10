package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.common.PauseableThread;
import com.didi.map.common.ApolloHawaii;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.hawaii.mapsdkv2.core.i */
/* compiled from: TrafficUpdateThread */
class C9947i extends PauseableThread {

    /* renamed from: d */
    private static final long f26302d = ApolloHawaii.getTrafficUpdateInterval();

    /* renamed from: a */
    private final WeakReference<MapDataUpdateHandler> f26303a;

    /* renamed from: b */
    private final WeakReference<GLBaseMapView> f26304b;

    /* renamed from: c */
    private long f26305c = -1;

    C9947i(GLBaseMapView gLBaseMapView, MapDataUpdateHandler mapDataUpdateHandler) {
        super("traffic");
        this.f26303a = new WeakReference<>(mapDataUpdateHandler);
        this.f26304b = new WeakReference<>(gLBaseMapView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo76401a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f26305c >= f26302d || !z) {
            synchronized (this) {
                notify();
            }
            this.f26305c = currentTimeMillis;
        }
    }

    /* access modifiers changed from: protected */
    public int onRun() throws InterruptedException {
        MapDataUpdateHandler mapDataUpdateHandler = (MapDataUpdateHandler) this.f26303a.get();
        GLBaseMapView gLBaseMapView = (GLBaseMapView) this.f26304b.get();
        if (mapDataUpdateHandler == null || gLBaseMapView == null) {
            throw new PauseableThread.Exit();
        }
        BaseMapData baseMapData = gLBaseMapView.getBaseMapData();
        if (baseMapData == null) {
            return 600;
        }
        int onUpdateTrafficData = mapDataUpdateHandler.onUpdateTrafficData(gLBaseMapView, baseMapData);
        if (onUpdateTrafficData <= 0) {
            return Integer.MAX_VALUE;
        }
        return onUpdateTrafficData;
    }
}
