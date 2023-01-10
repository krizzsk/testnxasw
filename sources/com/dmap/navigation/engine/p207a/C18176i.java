package com.dmap.navigation.engine.p207a;

import com.dmap.navigation.base.route.IToastInfo;
import com.dmap.navigation.jni.swig.NaviToastInfo;

/* renamed from: com.dmap.navigation.engine.a.i */
/* compiled from: SimpleToastInfo */
public final class C18176i implements IToastInfo {

    /* renamed from: a */
    private final int f54354a;

    /* renamed from: b */
    private final String f54355b;

    public C18176i(NaviToastInfo naviToastInfo) {
        this.f54354a = naviToastInfo.getType();
        this.f54355b = naviToastInfo.getContent();
    }

    public final String toString() {
        return "SimpleToastInfo{type=" + this.f54354a + ", content='" + this.f54355b + '\'' + '}';
    }

    public final int getType() {
        return this.f54354a;
    }

    public final String getContent() {
        return this.f54355b;
    }
}
