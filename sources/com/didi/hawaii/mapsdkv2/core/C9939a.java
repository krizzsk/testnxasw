package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

/* renamed from: com.didi.hawaii.mapsdkv2.core.a */
/* compiled from: Texture */
class C9939a extends Texture {

    /* renamed from: a */
    private final Bitmap f26262a;

    /* renamed from: b */
    private final String f26263b;

    C9939a(Resources resources, Bitmap bitmap) {
        this.f26262a = bitmap;
        this.f26263b = resources.mo76367a(bitmap);
    }

    public Bitmap getBitmap() {
        return this.f26262a;
    }

    public String getBitmapKey() {
        return this.f26263b;
    }

    public int getRowCount() {
        return this.f26262a.getHeight();
    }

    public int getColumnCount() {
        return this.f26262a.getWidth();
    }

    public String toString() {
        return "[bitmap:" + this.f26262a + Const.jaRight;
    }
}
