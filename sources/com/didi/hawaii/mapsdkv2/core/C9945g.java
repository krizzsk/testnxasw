package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

/* renamed from: com.didi.hawaii.mapsdkv2.core.g */
/* compiled from: Texture */
class C9945g extends Texture {

    /* renamed from: a */
    private String f26298a;

    /* renamed from: b */
    private final int[] f26299b;

    public Bitmap getBitmap() {
        return null;
    }

    C9945g(String str, int i, int i2) {
        int[] iArr = new int[2];
        this.f26299b = iArr;
        this.f26298a = str;
        iArr[0] = i;
        iArr[1] = i2;
    }

    public String getBitmapKey() {
        return this.f26298a;
    }

    public int getRowCount() {
        return this.f26299b[0];
    }

    public int getColumnCount() {
        return this.f26299b[1];
    }

    public String toString() {
        return "[map_pack:" + this.f26298a + Const.jaRight;
    }
}
