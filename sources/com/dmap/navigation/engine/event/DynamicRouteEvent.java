package com.dmap.navigation.engine.event;

public class DynamicRouteEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54422a;

    /* renamed from: b */
    private final String f54423b;

    /* renamed from: c */
    private final String f54424c;

    /* renamed from: d */
    private final int f54425d;

    /* renamed from: e */
    private final int f54426e;

    public DynamicRouteEvent(int i, String str, String str2, int i2, int i3) {
        this.f54422a = i;
        this.f54423b = str;
        this.f54424c = str2;
        this.f54425d = i2;
        this.f54426e = i3;
    }

    public int getOffsetTime() {
        return this.f54422a;
    }

    public String getMoney() {
        return this.f54423b;
    }

    public String getMsg() {
        return this.f54424c;
    }

    public int getType() {
        return this.f54425d;
    }

    public int getAbTest() {
        return this.f54426e;
    }
}
