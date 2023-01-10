package com.dmap.navigation.engine.event;

import android.graphics.drawable.Drawable;

public class EnlargeMapEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54429a;

    /* renamed from: b */
    private final String f54430b;

    /* renamed from: c */
    private final String f54431c;

    /* renamed from: d */
    private Drawable f54432d;

    public EnlargeMapEvent(int i, String str, String str2) {
        this.f54429a = i;
        this.f54430b = str;
        this.f54431c = str2;
    }

    public String toString() {
        return "EnlargeMapEvent{updateType=" + this.f54429a + ", backgroundPicUrl='" + this.f54430b + '\'' + ", arrowPicUrl='" + this.f54431c + '\'' + '}';
    }

    public int getUpdateType() {
        return this.f54429a;
    }

    public String getBackgroundPicUrl() {
        return this.f54430b;
    }

    public String getArrowPicUrl() {
        return this.f54431c;
    }

    public Drawable getDrawable() {
        return this.f54432d;
    }

    public void setDrawable(Drawable drawable) {
        this.f54432d = drawable;
    }
}
