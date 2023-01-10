package com.dmap.navigation.engine.event;

import android.graphics.drawable.Drawable;

public class VecEnlargeMapEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54523a;

    /* renamed from: b */
    private final String f54524b;

    /* renamed from: c */
    private final String f54525c;

    /* renamed from: d */
    private Drawable f54526d;

    public VecEnlargeMapEvent(int i, String str, String str2) {
        this.f54523a = i;
        this.f54525c = str;
        this.f54524b = str2;
    }

    public String toString() {
        return "VecEnlargeMapEvent{updateType=" + this.f54523a + ", key='" + this.f54524b + '\'' + ", url='" + this.f54525c + '\'' + '}';
    }

    public int getUpdateType() {
        return this.f54523a;
    }

    public String getKey() {
        return this.f54524b;
    }

    public String getUrl() {
        return this.f54525c;
    }

    public Drawable getDrawable() {
        return this.f54526d;
    }

    public void setDrawable(Drawable drawable) {
        this.f54526d = drawable;
    }
}
