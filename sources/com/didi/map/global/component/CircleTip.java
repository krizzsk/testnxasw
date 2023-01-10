package com.didi.map.global.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.MapUtils;
import java.util.ArrayList;
import java.util.List;

public class CircleTip implements ICircleTipComponent {

    /* renamed from: a */
    private CircleTipParam f27014a;

    /* renamed from: b */
    private Circle f27015b;

    /* renamed from: c */
    private Marker f27016c;

    /* renamed from: d */
    private ValueAnimator f27017d;

    /* renamed from: e */
    private Context f27018e;

    /* renamed from: f */
    private Map f27019f;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f27018e = context;
        this.f27019f = map;
        m21263a();
    }

    public void destroy() {
        m21268d();
        m21267c();
        ValueAnimator valueAnimator = this.f27017d;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f27017d.cancel();
            this.f27017d = null;
        }
        this.f27019f = null;
        this.f27018e = null;
        this.f27014a = null;
    }

    public void setConfigParam(CircleTipParam circleTipParam) {
        this.f27014a = circleTipParam;
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Circle circle = this.f27015b;
        if (circle != null) {
            arrayList.add(circle);
        }
        Marker marker = this.f27016c;
        if (marker != null) {
            arrayList.add(marker);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m21263a() {
        CircleTipParam circleTipParam;
        if (!(this.f27019f == null || (circleTipParam = this.f27014a) == null)) {
            Circle circle = this.f27015b;
            if (circle == null) {
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(this.f27014a.mCenter);
                if (this.f27014a.isUsingZIndex) {
                    circleOptions.zIndex(this.f27014a.zIndex);
                }
                circleOptions.fillColor(Color.argb(0, Color.red(this.f27014a.fillColor), Color.green(this.f27014a.fillColor), Color.blue(this.f27014a.fillColor)));
                circleOptions.strokeColor(Color.argb(0, Color.red(this.f27014a.strokeColor), Color.green(this.f27014a.fillColor), Color.blue(this.f27014a.strokeColor)));
                circleOptions.strokeWidth((float) this.f27014a.strokeWidthInPixel);
                circleOptions.radius(this.f27014a.radiusInMeters);
                this.f27015b = this.f27019f.addCircle(circleOptions);
                m21266b();
            } else {
                circle.setCenter(circleTipParam.mCenter);
            }
        }
        m21265a(this.f27015b);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m21266b() {
        /*
            r7 = this;
            com.didi.map.global.component.CircleTipParam r0 = r7.f27014a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r0 = r0.fillColor
            com.didi.map.global.component.CircleTipParam r1 = r7.f27014a
            int r1 = r1.strokeColor
            com.didi.map.global.component.IntArrayEvaluator r2 = new com.didi.map.global.component.IntArrayEvaluator
            r2.<init>()
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int[] r5 = new int[r3]
            r5 = {0, 0} // fill-array
            r6 = 0
            r4[r6] = r5
            int[] r3 = new int[r3]
            int r5 = android.graphics.Color.alpha(r0)
            r3[r6] = r5
            int r5 = android.graphics.Color.alpha(r1)
            r6 = 1
            r3[r6] = r5
            r4[r6] = r3
            android.animation.ValueAnimator r2 = android.animation.ValueAnimator.ofObject(r2, r4)
            r7.f27017d = r2
            r3 = 300(0x12c, double:1.48E-321)
            r2.setDuration(r3)
            android.animation.ValueAnimator r2 = r7.f27017d
            com.didi.map.global.component.-$$Lambda$CircleTip$t3E0D2zuVpFkCuot7I6TD6ro3t4 r3 = new com.didi.map.global.component.-$$Lambda$CircleTip$t3E0D2zuVpFkCuot7I6TD6ro3t4
            r3.<init>(r0, r1)
            r2.addUpdateListener(r3)
            android.animation.ValueAnimator r0 = r7.f27017d
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.CircleTip.m21266b():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21264a(int i, int i2, ValueAnimator valueAnimator) {
        int[] iArr = (int[]) valueAnimator.getAnimatedValue();
        Circle circle = this.f27015b;
        if (circle != null) {
            circle.setFillColor(Color.argb(iArr[0], Color.red(i), Color.green(i), Color.blue(i)));
            this.f27015b.setStrokeColor(Color.argb(iArr[1], Color.red(i2), Color.green(i2), Color.blue(i2)));
        }
        Marker marker = this.f27016c;
        if (marker != null) {
            marker.setAlpha(valueAnimator.getAnimatedFraction());
        }
    }

    /* renamed from: a */
    private void m21265a(Circle circle) {
        if (this.f27014a.mViewTip != null && circle != null && this.f27019f != null) {
            Marker marker = this.f27016c;
            if (marker == null) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.anchor(0.5f, 0.7f);
                Circle circle2 = this.f27015b;
                if (circle2 != null) {
                    markerOptions.zIndex(circle2.getZIndex() + 1);
                }
                markerOptions.position(this.f27015b.getBottomTangencyPoint());
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(this.f27014a.mViewTip)));
                this.f27016c = this.f27019f.addMarker(markerOptions);
                return;
            }
            marker.setPosition(this.f27015b.getBottomTangencyPoint());
        }
    }

    /* renamed from: c */
    private void m21267c() {
        Map map;
        Marker marker = this.f27016c;
        if (marker != null && (map = this.f27019f) != null) {
            map.remove(marker);
            this.f27016c = null;
        }
    }

    /* renamed from: d */
    private void m21268d() {
        Map map;
        Circle circle = this.f27015b;
        if (circle != null && (map = this.f27019f) != null) {
            map.remove(circle);
            this.f27015b = null;
        }
    }
}
