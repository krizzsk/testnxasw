package com.didi.map.global.component.departure.carpool;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.component.departure.model.CircleParam;
import com.didi.map.global.component.departure.view.CarPoolTipsView;
import java.util.ArrayList;
import java.util.List;

public class CarpoolDepartureController {

    /* renamed from: a */
    private Map f27278a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f27279b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Circle f27280c;

    /* renamed from: d */
    private Circle f27281d;

    /* renamed from: e */
    private CircleParam f27282e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ValueAnimator f27283f;

    /* renamed from: g */
    private final int f27284g = 100;

    /* renamed from: h */
    private View f27285h;

    /* renamed from: i */
    private int f27286i = 2;

    public CarpoolDepartureController(Map map, int i) {
        this.f27278a = map;
        if (i == 1 || i == 2) {
            this.f27286i = i;
        }
        m21576a();
        this.f27285h = new CarPoolTipsView(this.f27278a.getContext());
    }

    /* renamed from: a */
    private void m21576a() {
        int i = this.f27286i;
        if (i == 1) {
            this.f27282e = new CircleParam(300.0d, 436260010, -16724822, 3);
        } else if (i == 2) {
            this.f27282e = new CircleParam(200.0d, 436260010, -16724822, 4);
        }
    }

    public synchronized List<LatLng> getBestViewPoints(LatLng latLng) {
        if (this.f27282e == null) {
            return null;
        }
        if (this.f27278a != null && this.f27278a.getMapVendor() == MapVendor.DIDI) {
            if (this.f27281d == null) {
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(latLng);
                circleOptions.strokeWidth((float) this.f27282e.strokeWidthInPixel);
                circleOptions.visible(false);
                circleOptions.radius(this.f27282e.radiusInMeters);
                this.f27281d = this.f27278a.addCircle(circleOptions);
            } else {
                this.f27281d.setCenter(latLng);
            }
            if (this.f27281d != null) {
                return this.f27281d.getBounderPoints();
            }
        }
        ArrayList arrayList = new ArrayList();
        LatLng computeOffset = DDSphericalUtil.computeOffset(latLng, this.f27282e.radiusInMeters, 0.0d);
        LatLng computeOffset2 = DDSphericalUtil.computeOffset(latLng, this.f27282e.radiusInMeters, 90.0d);
        LatLng computeOffset3 = DDSphericalUtil.computeOffset(latLng, this.f27282e.radiusInMeters, 180.0d);
        LatLng computeOffset4 = DDSphericalUtil.computeOffset(latLng, this.f27282e.radiusInMeters, 270.0d);
        arrayList.add(computeOffset);
        arrayList.add(computeOffset2);
        arrayList.add(computeOffset3);
        arrayList.add(computeOffset4);
        return arrayList;
    }

    public void drawCircle(LatLng latLng) {
        if (this.f27278a != null && this.f27282e != null && latLng != null) {
            ValueAnimator valueAnimator = this.f27283f;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f27283f.removeAllListeners();
                this.f27283f.cancel();
                this.f27283f = null;
                Circle circle = this.f27280c;
                if (circle != null) {
                    this.f27278a.remove(circle);
                    this.f27280c = null;
                }
                Marker marker = this.f27279b;
                if (marker != null) {
                    this.f27278a.remove(marker);
                    this.f27279b = null;
                }
            }
            Circle circle2 = this.f27280c;
            if (circle2 == null) {
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(latLng);
                circleOptions.fillColor(this.f27282e.fillColor);
                circleOptions.strokeColor(this.f27282e.strokeColor);
                circleOptions.zIndex(100);
                circleOptions.strokeWidth((float) this.f27282e.strokeWidthInPixel);
                circleOptions.radius(this.f27282e.radiusInMeters);
                this.f27280c = this.f27278a.addCircle(circleOptions);
                m21580c();
            } else {
                circle2.setCenter(latLng);
            }
            m21577a(this.f27280c);
        }
    }

    /* renamed from: a */
    private void m21577a(Circle circle) {
        if (circle != null) {
            Marker marker = this.f27279b;
            if (marker == null) {
                MarkerOptions markerOptions = new MarkerOptions();
                Circle circle2 = this.f27280c;
                int zIndex = circle2 != null ? circle2.getZIndex() : 0;
                if (zIndex != 0) {
                    markerOptions.zIndex(zIndex + 1);
                }
                markerOptions.anchor(0.5f, 1.0f);
                markerOptions.position(circle.getBottomTangencyPoint());
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(this.f27285h)));
                this.f27279b = this.f27278a.addMarker(markerOptions);
                return;
            }
            marker.setPosition(circle.getBottomTangencyPoint());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeCircle(boolean r15) {
        /*
            r14 = this;
            if (r15 != 0) goto L_0x0006
            r14.m21579b()
            return
        L_0x0006:
            r15 = 1065353216(0x3f800000, float:1.0)
            android.animation.ValueAnimator r0 = r14.f27283f
            r1 = 300(0x12c, double:1.48E-321)
            if (r0 == 0) goto L_0x0034
            boolean r15 = r0.isRunning()
            if (r15 == 0) goto L_0x0015
            return
        L_0x0015:
            android.animation.ValueAnimator r15 = r14.f27283f
            float r15 = r15.getAnimatedFraction()
            android.animation.ValueAnimator r0 = r14.f27283f
            long r3 = r0.getCurrentPlayTime()
            android.animation.ValueAnimator r0 = r14.f27283f
            r0.removeAllUpdateListeners()
            android.animation.ValueAnimator r0 = r14.f27283f
            r0.removeAllListeners()
            android.animation.ValueAnimator r0 = r14.f27283f
            r0.cancel()
            r0 = 0
            r14.f27283f = r0
            goto L_0x0035
        L_0x0034:
            r3 = r1
        L_0x0035:
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r1 = r3
        L_0x003d:
            com.didi.common.map.model.Circle r0 = r14.f27280c
            if (r0 == 0) goto L_0x0098
            int r0 = r0.getFillColor()
            com.didi.common.map.model.Circle r3 = r14.f27280c
            int r3 = r3.getStrokeColor()
            com.didi.map.global.component.departure.carpool.CarpoolDepartureController$IntArrayEvaluator r4 = new com.didi.map.global.component.departure.carpool.CarpoolDepartureController$IntArrayEvaluator
            r4.<init>()
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r7 = 3
            int[] r8 = new int[r7]
            int r9 = android.graphics.Color.alpha(r0)
            r10 = 0
            r8[r10] = r9
            int r9 = android.graphics.Color.alpha(r3)
            r11 = 1
            r8[r11] = r9
            com.didi.common.map.model.Circle r9 = r14.f27280c
            double r12 = r9.getRadius()
            int r9 = (int) r12
            r8[r5] = r9
            r6[r10] = r8
            int[] r5 = new int[r7]
            r5 = {0, 0, 0} // fill-array
            r6[r11] = r5
            android.animation.ValueAnimator r4 = android.animation.ValueAnimator.ofObject(r4, r6)
            r14.f27283f = r4
            r4.setDuration(r1)
            android.animation.ValueAnimator r1 = r14.f27283f
            com.didi.map.global.component.departure.carpool.CarpoolDepartureController$1 r2 = new com.didi.map.global.component.departure.carpool.CarpoolDepartureController$1
            r2.<init>(r0, r3, r15)
            r1.addUpdateListener(r2)
            android.animation.ValueAnimator r15 = r14.f27283f
            com.didi.map.global.component.departure.carpool.CarpoolDepartureController$2 r0 = new com.didi.map.global.component.departure.carpool.CarpoolDepartureController$2
            r0.<init>()
            r15.addListener(r0)
            android.animation.ValueAnimator r15 = r14.f27283f
            r15.start()
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.carpool.CarpoolDepartureController.removeCircle(boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21579b() {
        Circle circle = this.f27280c;
        if (circle != null) {
            this.f27278a.remove(circle);
            this.f27280c = null;
        }
        Circle circle2 = this.f27281d;
        if (circle2 != null) {
            this.f27278a.remove(circle2);
            this.f27281d = null;
        }
        Marker marker = this.f27279b;
        if (marker != null) {
            this.f27278a.remove(marker);
            this.f27279b = null;
        }
        ValueAnimator valueAnimator = this.f27283f;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f27283f.removeAllListeners();
            this.f27283f.cancel();
            this.f27283f = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m21580c() {
        /*
            r10 = this;
            com.didi.map.global.component.departure.model.CircleParam r0 = r10.f27282e
            int r0 = r0.fillColor
            com.didi.map.global.component.departure.model.CircleParam r1 = r10.f27282e
            int r1 = r1.strokeColor
            com.didi.map.global.component.departure.carpool.CarpoolDepartureController$IntArrayEvaluator r2 = new com.didi.map.global.component.departure.carpool.CarpoolDepartureController$IntArrayEvaluator
            r2.<init>()
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 3
            int[] r6 = new int[r5]
            r6 = {0, 0, 0} // fill-array
            r7 = 0
            r4[r7] = r6
            int[] r5 = new int[r5]
            int r6 = android.graphics.Color.alpha(r0)
            r5[r7] = r6
            int r6 = android.graphics.Color.alpha(r1)
            r7 = 1
            r5[r7] = r6
            com.didi.map.global.component.departure.model.CircleParam r6 = r10.f27282e
            double r8 = r6.radiusInMeters
            int r6 = (int) r8
            r5[r3] = r6
            r4[r7] = r5
            android.animation.ValueAnimator r2 = android.animation.ValueAnimator.ofObject(r2, r4)
            r10.f27283f = r2
            r3 = 300(0x12c, double:1.48E-321)
            r2.setDuration(r3)
            android.animation.ValueAnimator r2 = r10.f27283f
            com.didi.map.global.component.departure.carpool.CarpoolDepartureController$3 r3 = new com.didi.map.global.component.departure.carpool.CarpoolDepartureController$3
            r3.<init>(r0, r1)
            r2.addUpdateListener(r3)
            android.animation.ValueAnimator r0 = r10.f27283f
            com.didi.map.global.component.departure.carpool.CarpoolDepartureController$4 r1 = new com.didi.map.global.component.departure.carpool.CarpoolDepartureController$4
            r1.<init>()
            r0.addListener(r1)
            android.animation.ValueAnimator r0 = r10.f27283f
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.carpool.CarpoolDepartureController.m21580c():void");
    }

    private class IntArrayEvaluator implements TypeEvaluator<int[]> {
        private int[] mArray;

        public IntArrayEvaluator() {
        }

        public IntArrayEvaluator(int[] iArr) {
            this.mArray = iArr;
        }

        public int[] evaluate(float f, int[] iArr, int[] iArr2) {
            int[] iArr3 = this.mArray;
            if (iArr3 == null) {
                iArr3 = new int[iArr.length];
            }
            for (int i = 0; i < iArr3.length; i++) {
                int i2 = iArr[i];
                iArr3[i] = (int) (((float) i2) + (((float) (iArr2[i] - i2)) * f));
            }
            return iArr3;
        }
    }
}
