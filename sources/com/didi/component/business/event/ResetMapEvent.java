package com.didi.component.business.event;

import androidx.core.util.Pools;
import com.didi.common.map.model.Padding;
import com.didi.component.common.util.GLog;

public class ResetMapEvent {

    /* renamed from: a */
    private static final String f13143a = "ResetMapEvent";

    /* renamed from: c */
    private static final Pools.SynchronizedPool<ResetMapEvent> f13144c = new Pools.SynchronizedPool<>(2);

    /* renamed from: b */
    private Padding f13145b;

    private ResetMapEvent() {
    }

    public static ResetMapEvent obtain() {
        ResetMapEvent acquire = f13144c.acquire();
        return acquire != null ? acquire : new ResetMapEvent();
    }

    public void recycle() {
        try {
            f13144c.release(this);
        } catch (IllegalStateException e) {
            GLog.m11358e(f13143a, "ResetMapEvent pool recycle", e);
        }
    }

    public void fillData(int i, int i2, int i3, int i4) {
        Padding padding = this.f13145b;
        if (padding == null) {
            this.f13145b = new Padding(i, i2, i3, i4);
            return;
        }
        padding.left = i;
        this.f13145b.top = i2;
        this.f13145b.right = i3;
        this.f13145b.bottom = i4;
    }

    public Padding getPadding() {
        return this.f13145b;
    }
}
