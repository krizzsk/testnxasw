package com.dmap.navigation.engine.event;

import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.engine.simple.SimpleLocation;
import com.dmap.navigation.jni.swig.BindNaviLocation;
import com.dmap.navigation.jni.swig.NaviLocation;

public class YawEvent extends NaviEvent {

    /* renamed from: a */
    private final INaviLocation f54536a;

    /* renamed from: b */
    private final int f54537b;

    /* renamed from: c */
    private final int f54538c;

    /* renamed from: d */
    private final int f54539d;

    public YawEvent(BindNaviLocation bindNaviLocation, int i, int i2, int i3) {
        this.f54536a = new SimpleLocation((NaviLocation) bindNaviLocation);
        this.f54537b = i;
        this.f54538c = i2;
        this.f54539d = i3;
    }

    public String toString() {
        return "YawEvent{bindLocation=" + this.f54536a + ", bindIndex=" + this.f54537b + ", toastBehavior=" + this.f54538c + ", mainSideYaw=" + this.f54539d + '}';
    }

    public INaviLocation getBindLocation() {
        return this.f54536a;
    }

    public int getBindIndex() {
        return this.f54537b;
    }

    public int getToastBehavior() {
        return this.f54538c;
    }

    public int getMainSideYaw() {
        return this.f54539d;
    }
}
