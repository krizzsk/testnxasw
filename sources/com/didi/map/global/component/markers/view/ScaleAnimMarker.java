package com.didi.map.global.component.markers.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.ArrayList;
import java.util.List;

public class ScaleAnimMarker implements IBaseComponent<ScaleMarkerParam> {

    /* renamed from: a */
    private Canvas f28301a;

    /* renamed from: b */
    private ValueAnimator f28302b;

    /* renamed from: c */
    private Interpolator f28303c;

    /* renamed from: d */
    private Matrix f28304d;

    /* renamed from: e */
    private Paint f28305e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Marker f28306f;

    /* renamed from: g */
    private Context f28307g;

    /* renamed from: h */
    private Map f28308h;

    /* renamed from: i */
    private Bitmap f28309i;

    /* renamed from: j */
    private Bitmap f28310j;

    /* renamed from: k */
    private Bitmap f28311k;

    /* renamed from: l */
    private int f28312l = 500;

    /* renamed from: m */
    private ScaleMarkerParam f28313m;

    /* renamed from: n */
    private String f28314n = "ScaleAnimMarker";

    /* renamed from: o */
    private boolean f28315o = true;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f28307g = context;
        this.f28308h = map;
        if (map != null && map.getMapVendor() == MapVendor.HUAWEI) {
            boolean unused = this.f28313m.hasScaleAnim = false;
        }
        if (this.f28313m.hasScaleAnim) {
            m22179a();
        }
        if (this.f28308h != null && MapVendor.DIDI == this.f28308h.getMapVendor()) {
            this.f28315o = false;
        }
        m22182b();
    }

    public void destroy() {
        m22183b(false);
        Marker marker = this.f28306f;
        if (marker != null) {
            this.f28308h.remove(marker);
            this.f28306f.remove();
            this.f28306f = null;
        }
        ValueAnimator valueAnimator = this.f28302b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f28302b.removeAllUpdateListeners();
            this.f28302b = null;
        }
        if (this.f28309i != null) {
            this.f28309i = null;
        }
        Bitmap bitmap = this.f28311k;
        if (bitmap != null) {
            if (this.f28315o) {
                bitmap.recycle();
            }
            this.f28311k = null;
        }
        Bitmap bitmap2 = this.f28310j;
        if (bitmap2 != null) {
            if (this.f28315o) {
                bitmap2.recycle();
            }
            this.f28310j = null;
        }
        this.f28301a = null;
        this.f28304d = null;
        this.f28305e = null;
    }

    public void setConfigParam(ScaleMarkerParam scaleMarkerParam) {
        if (scaleMarkerParam != null) {
            this.f28313m = scaleMarkerParam;
            this.f28309i = scaleMarkerParam.markerIcon;
        }
    }

    /* renamed from: a */
    private void m22179a() {
        this.f28304d = new Matrix();
        this.f28305e = new Paint();
        Bitmap bitmap = this.f28309i;
        if (bitmap == null || bitmap.isRecycled()) {
            DLog.m10773d(this.f28314n, "icon 参数为空", new Object[0]);
            return;
        }
        int width = this.f28309i.getWidth();
        int height = this.f28309i.getHeight();
        this.f28311k = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        this.f28310j = Bitmap.createScaledBitmap(this.f28309i, width, height, true);
        Canvas canvas = new Canvas(this.f28311k);
        this.f28301a = canvas;
        canvas.setMatrix(this.f28304d);
    }

    /* renamed from: a */
    private void m22180a(Bitmap bitmap, LatLng latLng, int i) {
        if (latLng == null || this.f28308h == null || bitmap == null || bitmap.isRecycled()) {
            DLog.m10773d(this.f28314n, "scaleMarkerParam 参数异常", new Object[0]);
            return;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        if (i != 0) {
            markerOptions.zIndex(i);
        }
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        this.f28306f = this.f28308h.addMarker(markerOptions);
    }

    /* renamed from: b */
    private void m22182b() {
        ScaleMarkerParam scaleMarkerParam = this.f28313m;
        if (scaleMarkerParam == null) {
            return;
        }
        if (!scaleMarkerParam.hasScaleAnim) {
            m22180a(this.f28309i, this.f28313m.latLng, this.f28313m.zIndex);
            return;
        }
        Bitmap createScaleBitmap = createScaleBitmap(0.01f);
        if (createScaleBitmap != null) {
            m22180a(createScaleBitmap, this.f28313m.latLng, this.f28313m.zIndex);
        }
    }

    /* renamed from: a */
    private void m22181a(boolean z) {
        if (this.f28303c == null) {
            this.f28303c = PathInterpolatorCompat.create(0.3f, 0.2f, 0.1f, 1.0f);
        }
        ValueAnimator valueAnimator = this.f28302b;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f28302b.cancel();
            this.f28302b.removeAllUpdateListeners();
        }
        if (z) {
            ValueAnimator ofFloat = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f28302b = ofFloat;
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (ScaleAnimMarker.this.f28306f != null) {
                        ScaleAnimMarker.this.f28306f.setVisible(true);
                    }
                }
            });
        } else {
            ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.f28302b = ofFloat2;
            ofFloat2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (ScaleAnimMarker.this.f28306f != null) {
                        ScaleAnimMarker.this.f28306f.setVisible(false);
                    }
                }
            });
        }
        this.f28302b.setDuration((long) this.f28312l);
        this.f28302b.setRepeatCount(0);
        this.f28302b.setInterpolator(this.f28303c);
        this.f28302b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Bitmap createScaleBitmap = ScaleAnimMarker.this.createScaleBitmap(((Float) valueAnimator.getAnimatedValue()).floatValue());
                if (createScaleBitmap != null) {
                    ScaleAnimMarker.this.setMarkerIcon(createScaleBitmap);
                }
            }
        });
    }

    /* renamed from: b */
    private void m22183b(boolean z) {
        ValueAnimator valueAnimator = this.f28302b;
        if (valueAnimator == null) {
            return;
        }
        if (z) {
            valueAnimator.start();
        } else {
            valueAnimator.cancel();
        }
    }

    public void setMarkerIcon(Bitmap bitmap) {
        Context context;
        Marker marker = this.f28306f;
        if (marker != null && (context = this.f28307g) != null) {
            marker.setIcon(context, BitmapDescriptorFactory.fromBitmap(bitmap));
            if (this.f28313m.getzIndex() != 0) {
                this.f28306f.setZIndex(this.f28313m.getzIndex());
            }
        }
    }

    public void showMarker(LatLng latLng) {
        if (this.f28313m != null && this.f28308h != null) {
            Marker marker = this.f28306f;
            if (marker == null) {
                m22182b();
            } else {
                marker.setVisible(true);
            }
            if (latLng != null) {
                this.f28313m.setLatLng(latLng);
                updatePosition(latLng);
            }
            if (this.f28313m.hasScaleAnim) {
                m22181a(true);
                m22183b(true);
            }
        }
    }

    public void hideMarker(boolean z) {
        Map map;
        if (this.f28306f != null && (map = this.f28308h) != null) {
            if (!z || map.getMapVendor() == MapVendor.HUAWEI) {
                this.f28306f.setVisible(false);
                return;
            }
            m22181a(false);
            m22183b(true);
        }
    }

    public void updatePosition(LatLng latLng) {
        Marker marker = this.f28306f;
        if (marker != null && latLng != null) {
            float a = m22177a(marker.getPosition(), latLng);
            if (a != 0.0f) {
                this.f28306f.setRotation(a % 360.0f);
            }
            this.f28306f.setPosition(latLng);
        }
    }

    public void updateIcon(Bitmap bitmap) {
        Marker marker = this.f28306f;
        if (marker != null && marker.isVisible()) {
            this.f28309i = bitmap;
            setMarkerIcon(bitmap);
        }
    }

    public List<IMapElement> getMarkerElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f28306f;
        if (marker != null) {
            arrayList.add(marker);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Bitmap createScaleBitmap(float f) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this.f28304d == null || this.f28301a == null || this.f28305e == null || (bitmap = this.f28310j) == null || bitmap.isRecycled() || (bitmap2 = this.f28311k) == null || bitmap2.isRecycled()) {
            return null;
        }
        this.f28301a.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f28304d.setScale(f, f, (float) (this.f28310j.getWidth() / 2), (float) (this.f28310j.getHeight() / 2));
        this.f28301a.drawBitmap(this.f28310j, this.f28304d, this.f28305e);
        return this.f28311k;
    }

    /* renamed from: a */
    private float m22177a(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        return (float) (90.0d - ((Math.atan2(latLng2.latitude - latLng.latitude, latLng2.longitude - latLng.longitude) / 3.141592653589793d) * 180.0d));
    }

    public static class ScaleMarkerParam {
        /* access modifiers changed from: private */
        public boolean hasScaleAnim;
        /* access modifiers changed from: private */
        public LatLng latLng;
        /* access modifiers changed from: private */
        public Bitmap markerIcon;
        /* access modifiers changed from: private */
        public int zIndex;

        public ScaleMarkerParam(LatLng latLng2, Bitmap bitmap, boolean z) {
            this.latLng = latLng2;
            this.markerIcon = bitmap;
            this.hasScaleAnim = z;
        }

        public LatLng getLatLng() {
            return this.latLng;
        }

        public Bitmap getMarkerIcon() {
            return this.markerIcon;
        }

        public void setLatLng(LatLng latLng2) {
            this.latLng = latLng2;
        }

        public void setMarkerIcon(Bitmap bitmap) {
            this.markerIcon = bitmap;
        }

        public int getzIndex() {
            return this.zIndex;
        }

        public void setzIndex(int i) {
            this.zIndex = i;
        }

        public boolean isHasScaleAnim() {
            return this.hasScaleAnim;
        }

        public void setHasScaleAnim(boolean z) {
            this.hasScaleAnim = z;
        }
    }
}
