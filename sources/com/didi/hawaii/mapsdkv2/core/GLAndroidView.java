package com.didi.hawaii.mapsdkv2.core;

import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;

public class GLAndroidView extends GLOverlayView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final View f26073a;

    /* renamed from: b */
    private final Handler f26074b;

    /* renamed from: c */
    private final LatLng f26075c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final LatLng f26076d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f26077e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f26078f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final FrameLayout f26079g;

    public static class Option extends GLOverlayView.Option {
        public float anchorX = 0.5f;
        public float anchorY = 0.5f;
        public LatLng latLng;
        public View view;
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    public GLAndroidView(GLViewManager gLViewManager, Option option, FrameLayout frameLayout) {
        super(gLViewManager, option, GLOverlayLayer.OVERLAY, false);
        this.f26074b = gLViewManager.getMainHandler();
        LatLng latLng = new LatLng(option.latLng);
        this.f26075c = latLng;
        this.f26076d = new LatLng(latLng);
        this.f26077e = option.anchorX;
        this.f26078f = option.anchorY;
        View view = option.view;
        this.f26073a = view;
        view.setVisibility(4);
        this.f26079g = frameLayout;
        if (frameLayout.indexOfChild(this.f26073a) != -1) {
            this.f26079g.removeView(this.f26073a);
        }
        attachToFrame(true);
    }

    public void setAnchor(float f, float f2) {
        this.f26077e = f;
        this.f26078f = f2;
    }

    public int[] getViewWH() {
        View view = this.f26073a;
        if (view == null) {
            return new int[]{0, 0};
        }
        return new int[]{view.getWidth(), this.f26073a.getHeight()};
    }

    public float getAnchorX() {
        return this.f26077e;
    }

    public float getAnchorY() {
        return this.f26078f;
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        float[] screenLocation = this.mMapCanvas.toScreenLocation(this.f26076d);
        final float f = screenLocation[0];
        final float f2 = screenLocation[1];
        this.f26074b.post(new Runnable() {
            public void run() {
                int height = GLAndroidView.this.f26073a.getHeight();
                GLAndroidView.this.f26073a.setX(f - (((float) GLAndroidView.this.f26073a.getWidth()) * GLAndroidView.this.f26077e));
                GLAndroidView.this.f26073a.setY(f2 - (((float) height) * GLAndroidView.this.f26078f));
                GLAndroidView.this.f26073a.setVisibility(0);
                GLAndroidView.this.f26079g.addView(GLAndroidView.this.f26073a, new FrameLayout.LayoutParams(-2, -2));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        this.f26074b.post(new Runnable() {
            public void run() {
                GLAndroidView.this.f26079g.removeView(GLAndroidView.this.f26073a);
            }
        });
    }

    public void setCenter(LatLng latLng) {
        if (!this.f26075c.equals(latLng)) {
            final double d = latLng.latitude;
            final double d2 = latLng.longitude;
            this.f26075c.latitude = d;
            this.f26075c.longitude = d2;
            set(new RenderTask() {
                public void run() {
                    GLAndroidView.this.f26076d.longitude = d2;
                    GLAndroidView.this.f26076d.latitude = d;
                }
            });
        }
    }

    public LatLng getCenter() {
        return new LatLng(this.f26075c);
    }

    public void onFrameFinish(boolean z) {
        if (z) {
            float[] screenLocation = this.mMapCanvas.toScreenLocation(this.f26076d);
            final float f = screenLocation[0];
            final float f2 = screenLocation[1];
            this.f26074b.post(new Runnable() {
                public void run() {
                    int height = GLAndroidView.this.f26073a.getHeight();
                    GLAndroidView.this.f26073a.setX(f - (((float) GLAndroidView.this.f26073a.getWidth()) * GLAndroidView.this.f26077e));
                    GLAndroidView.this.f26073a.setY(f2 - (((float) height) * GLAndroidView.this.f26078f));
                }
            });
        }
    }

    public void setVisible(boolean z) {
        super.setVisible(z);
        this.f26073a.setVisibility(z ? 0 : 4);
        if (!z) {
            attachToFrame(false);
        } else {
            attachToFrame(true);
        }
    }

    public void setAlpha(float f) {
        super.setAlpha(f);
        this.f26073a.setAlpha(f);
    }
}
