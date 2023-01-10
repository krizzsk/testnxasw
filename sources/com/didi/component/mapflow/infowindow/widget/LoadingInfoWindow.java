package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.taxis99.R;

public class LoadingInfoWindow extends LinearLayout {

    /* renamed from: a */
    private final int f16137a = 200;

    /* renamed from: b */
    private final int[] f16138b = {R.drawable.global_mapflow_loading_1, R.drawable.global_mapflow_loading_2, R.drawable.global_mapflow_loading_3};

    /* renamed from: c */
    private ImageView f16139c;

    /* renamed from: d */
    private int f16140d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IUpdateCallback f16141e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f16142f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f16143g = 200;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Handler f16144h = new Handler(Looper.getMainLooper());

    /* renamed from: i */
    private Runnable f16145i = new Runnable() {
        public void run() {
            LoadingInfoWindow.this.m13336a();
            if (LoadingInfoWindow.this.f16141e != null) {
                LoadingInfoWindow.this.f16141e.update();
            }
            if (!LoadingInfoWindow.this.f16142f) {
                LoadingInfoWindow.this.f16144h.postDelayed(this, LoadingInfoWindow.this.f16143g);
            }
        }
    };

    public interface IUpdateCallback {
        void update();
    }

    public LoadingInfoWindow(Context context) {
        super(context);
        m13337a(context);
    }

    public LoadingInfoWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13337a(context);
    }

    public LoadingInfoWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13337a(context);
    }

    public LoadingInfoWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m13337a(context);
    }

    /* renamed from: a */
    private void m13337a(Context context) {
        inflate(context, R.layout.global_map_loading_window, this);
        this.f16139c = (ImageView) findViewById(R.id.left_loading);
    }

    public void setUpdateCallback(IUpdateCallback iUpdateCallback) {
        this.f16141e = iUpdateCallback;
    }

    public void setIntervalTime(long j) {
        this.f16143g = j;
    }

    public void showLoading() {
        this.f16142f = false;
        this.f16144h.postDelayed(this.f16145i, this.f16143g);
    }

    public void stopLoading() {
        this.f16142f = true;
        this.f16144h.removeCallbacks(this.f16145i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13336a() {
        int i = this.f16140d + 1;
        this.f16140d = i;
        if (i < 0 || i >= this.f16138b.length) {
            this.f16140d = 0;
        }
        this.f16139c.setImageResource(this.f16138b[this.f16140d]);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopLoading();
    }
}
