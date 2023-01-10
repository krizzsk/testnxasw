package com.didi.hawaii.mapsdkv2.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.map.common.MapAssets;
import com.didi.map.outer.map.DMarker;
import com.didi.map.outer.map.DiMapInterface;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.mapsdkv2.adapter.a */
/* compiled from: DefaultInfoWindowAdapter */
final class C9760a<T extends DMarker> implements DiMapInterface.IWindowAdapter<T> {

    /* renamed from: a */
    private final View[] f26012a = new View[2];

    /* renamed from: b */
    private final View[] f26013b = new View[2];

    /* renamed from: c */
    private final Context f26014c;

    /* renamed from: b */
    private void m20568b() {
    }

    C9760a(Context context) {
        this.f26014c = context;
    }

    public View[] getInfoWindow(T t) {
        m20567a();
        return this.f26012a;
    }

    public View[] getOverturnInfoWindow(T t) {
        m20568b();
        return this.f26013b;
    }

    public View getInfoContents(T t) {
        return this.f26012a[0];
    }

    /* renamed from: a */
    private void m20567a() {
        View[] viewArr = this.f26012a;
        if (viewArr[0] == null || viewArr[1] == null) {
            View inflate = LayoutInflater.from(this.f26014c).inflate(R.layout.hawaii_default_infowindow, (ViewGroup) null, false);
            Bitmap bitmapInMapDir = MapAssets.bitmapInMapDir(this.f26014c, "marker_infowindow.9.png");
            if (bitmapInMapDir != null) {
                inflate.setBackgroundDrawable(new NinePatchDrawable(this.f26014c.getResources(), bitmapInMapDir, bitmapInMapDir.getNinePatchChunk(), new Rect(), (String) null));
            }
            this.f26012a[0] = inflate;
            View inflate2 = LayoutInflater.from(this.f26014c).inflate(R.layout.hawaii_default_infowindow, (ViewGroup) null, false);
            Bitmap bitmapInMapDir2 = MapAssets.bitmapInMapDir(this.f26014c, "marker_infowindow.9.png");
            if (bitmapInMapDir2 != null) {
                inflate2.setBackgroundDrawable(new NinePatchDrawable(this.f26014c.getResources(), bitmapInMapDir2, bitmapInMapDir2.getNinePatchChunk(), new Rect(), (String) null));
            }
            this.f26012a[1] = inflate2;
        }
    }
}
