package com.didi.map.global.component.markers.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.ArrayList;
import java.util.List;

public class BreathAnimMarker implements IBaseComponent<BreathMarkerParam> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ValueAnimator f28251a;

    /* renamed from: b */
    private Marker f28252b;

    /* renamed from: c */
    private Map f28253c;

    /* renamed from: d */
    private Context f28254d;

    /* renamed from: e */
    private int f28255e = 1000;

    /* renamed from: f */
    private BreathMarkerParam f28256f;

    /* renamed from: g */
    private MarkerModel f28257g;

    /* renamed from: h */
    private Bitmap f28258h;

    public void onMapVisible(boolean z) {
    }

    public Marker getMarker() {
        return this.f28252b;
    }

    public void playAnimation(boolean z) {
        ValueAnimator valueAnimator = this.f28251a;
        if (valueAnimator == null) {
            return;
        }
        if (z) {
            m22169a();
            this.f28251a.start();
            return;
        }
        valueAnimator.removeAllUpdateListeners();
        this.f28251a.cancel();
        setMarkerIcon(this.f28258h);
    }

    public void create(Context context, Map map) {
        this.f28254d = context;
        this.f28253c = map;
        BreathMarkerParam breathMarkerParam = this.f28256f;
        if (breathMarkerParam != null && breathMarkerParam.model != null) {
            MarkerModel access$000 = this.f28256f.model;
            this.f28257g = access$000;
            this.f28258h = access$000.getMarkerIcon();
            this.f28255e = this.f28256f.scaleAnimDuration;
            m22169a();
        }
    }

    public void destroy() {
        ValueAnimator valueAnimator = this.f28251a;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f28251a.cancel();
            this.f28251a = null;
        }
        Map map = this.f28253c;
        if (map != null) {
            map.remove(this.f28252b);
        }
        this.f28252b = null;
    }

    public void setConfigParam(BreathMarkerParam breathMarkerParam) {
        this.f28256f = breathMarkerParam;
    }

    /* renamed from: a */
    private Marker m22168a(MarkerModel markerModel) {
        if (this.f28253c == null || this.f28254d == null || markerModel == null || markerModel.getPoint() == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(markerModel.getPoint()).anchor(markerModel.getAnchorU(), markerModel.getAnchorV()).icon(BitmapDescriptorFactory.fromBitmap(markerModel.getMarkerIcon())).draggable(false);
        if (markerModel.getZOrder() != 0) {
            markerOptions.zIndex(markerModel.getZOrder());
        }
        return this.f28253c.addMarker(markerOptions);
    }

    /* renamed from: a */
    private void m22169a() {
        BreathMarkerParam breathMarkerParam = this.f28256f;
        if (breathMarkerParam != null && this.f28251a == null) {
            float access$200 = breathMarkerParam.scaleMin;
            float access$300 = this.f28256f.scaleMax;
            if (access$200 != access$300) {
                ValueAnimator ofFloat = ObjectAnimator.ofFloat(new float[]{access$200, access$300});
                this.f28251a = ofFloat;
                ofFloat.setDuration((long) this.f28255e);
                this.f28251a.setRepeatMode(2);
                this.f28251a.setRepeatCount(-1);
                this.f28251a.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
                this.f28251a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (BreathAnimMarker.this.f28251a != null && BreathAnimMarker.this.f28251a.isRunning()) {
                            BreathAnimMarker.this.drawBitmapToMarker(valueAnimator);
                        }
                    }
                });
                return;
            }
            setMarkerIcon(this.f28258h);
        }
    }

    public void setMarkerIcon(Bitmap bitmap) {
        if (this.f28253c != null && this.f28254d != null && this.f28257g != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                DLog.m10773d("start point ", "bitmap is null or recycled", new Object[0]);
                return;
            }
            Marker marker = this.f28252b;
            if (marker == null) {
                this.f28257g.setMarkerIcon(bitmap);
                this.f28252b = m22168a(this.f28257g);
                return;
            }
            marker.setIcon(this.f28254d, BitmapDescriptorFactory.fromBitmap(bitmap));
        }
    }

    /* access modifiers changed from: protected */
    public void drawBitmapToMarker(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Bitmap bitmap = this.f28258h;
        if (bitmap != null && !bitmap.isRecycled()) {
            setMarkerIcon(ImageUtil.scale(this.f28258h, ((float) this.f28258h.getWidth()) * floatValue, ((float) this.f28258h.getHeight()) * floatValue, ImageView.ScaleType.CENTER_CROP, false));
        }
    }

    public List<IMapElement> getMarkerElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f28252b;
        if (marker != null) {
            arrayList.add(marker);
        }
        return arrayList;
    }

    public static class BreathMarkerParam {
        /* access modifiers changed from: private */
        public MarkerModel model;
        /* access modifiers changed from: private */
        public int scaleAnimDuration;
        /* access modifiers changed from: private */
        public float scaleMax;
        /* access modifiers changed from: private */
        public float scaleMin;

        public MarkerModel getModel() {
            return this.model;
        }

        public void setModel(MarkerModel markerModel) {
            this.model = markerModel;
        }

        public int getScaleAnimDuration() {
            return this.scaleAnimDuration;
        }

        public void setScaleAnimDuration(int i) {
            this.scaleAnimDuration = i;
        }

        public float getScaleMin() {
            return this.scaleMin;
        }

        public void setScaleMin(float f) {
            this.scaleMin = f;
        }

        public float getScaleMax() {
            return this.scaleMax;
        }

        public void setScaleMax(float f) {
            this.scaleMax = f;
        }

        public BreathMarkerParam(MarkerModel markerModel, int i, float f, float f2) {
            this.model = markerModel;
            this.scaleAnimDuration = i;
            this.scaleMin = f;
            this.scaleMax = f2;
        }
    }
}
