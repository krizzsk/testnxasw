package com.didi.hawaii.mapsdkv2.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.map.outer.map.MapView;

/* renamed from: com.didi.hawaii.mapsdkv2.adapter.c */
/* compiled from: ViewBitmapGenerator */
final class C9762c {

    /* renamed from: a */
    private final MapView f26018a;

    /* renamed from: b */
    private View f26019b;

    C9762c(MapView mapView) {
        this.f26018a = mapView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo75430a(View view) {
        if (view == null) {
            return null;
        }
        View view2 = this.f26019b;
        if (view2 == view) {
            return BitmapUtil.convertViewToBitmap(view);
        }
        if (!(view2 == null || view2.getParent() == null || this.f26018a.indexOfChild(this.f26019b) <= 0)) {
            this.f26018a.removeView(this.f26019b);
        }
        this.f26018a.addView(view, new FrameLayout.LayoutParams(-2, -2));
        view.setVisibility(4);
        this.f26019b = view;
        return BitmapUtil.convertViewToBitmap(view);
    }
}
