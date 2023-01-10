package com.didi.hawaii.mapsdkv2.core;

import android.view.ViewDebug;

public class GLUiSetting {
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: a */
    private boolean f26181a = true;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: b */
    private boolean f26182b = true;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: c */
    private boolean f26183c = true;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: d */
    private boolean f26184d = true;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: e */
    private boolean f26185e = false;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: f */
    private boolean f26186f = false;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: g */
    private boolean f26187g = false;

    /* renamed from: h */
    private boolean f26188h = true;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo75959a() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo75960b() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo75961c() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo75962d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo75963e() {
        return true;
    }

    public void setZoomControlsEnabled(boolean z) {
        this.f26185e = z;
    }

    public void setCompassEnabled(boolean z) {
        this.f26187g = z;
    }

    public void setMyLocationButtonEnabled(boolean z) {
        this.f26186f = z;
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f26181a = z;
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f26182b = z;
    }

    public void setTiltGesturesEnabled(boolean z) {
        this.f26183c = z;
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f26184d = z;
    }

    public void setAllGesturesEnabled(boolean z) {
        this.f26188h = z;
        setRotateGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setScrollGesturesEnabled(z);
    }

    public boolean isAllGestureEnabled() {
        return this.f26188h;
    }

    public boolean isRotateGesturesEnabled() {
        return this.f26181a;
    }

    public boolean isScrollGesturesEnabled() {
        return this.f26182b;
    }

    public boolean isTiltGesturesEnabled() {
        return this.f26183c;
    }

    public boolean isZoomGesturesEnabled() {
        return this.f26184d;
    }

    public boolean isZoomControlsEnabled() {
        return this.f26185e;
    }

    public boolean isMyLocationButtonEnabled() {
        return this.f26186f;
    }

    public boolean isCompassEnabled() {
        return this.f26187g;
    }
}
