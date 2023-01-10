package com.didi.component.business.event;

import androidx.core.util.Pools;
import com.didi.component.common.util.GLog;

public class GuideBubbleOffsetEvent {

    /* renamed from: a */
    private static final String f13137a = "GuideBubbleOffsetEvent";

    /* renamed from: d */
    private static final Pools.SynchronizedPool<GuideBubbleOffsetEvent> f13138d = new Pools.SynchronizedPool<>(2);

    /* renamed from: b */
    private int f13139b;

    /* renamed from: c */
    private int f13140c;

    private GuideBubbleOffsetEvent() {
    }

    public static GuideBubbleOffsetEvent obtain() {
        GuideBubbleOffsetEvent acquire = f13138d.acquire();
        return acquire != null ? acquire : new GuideBubbleOffsetEvent();
    }

    public void recycle() {
        try {
            f13138d.release(this);
        } catch (IllegalStateException e) {
            GLog.m11358e(f13137a, "GuideBubbleOffsetEvent pool recycle", e);
        }
    }

    public void fillData(int i, int i2) {
        this.f13139b = i;
        this.f13140c = i2;
    }

    public int getInitialPixel() {
        return this.f13139b;
    }

    public int getLeftPixel() {
        return this.f13140c;
    }
}
