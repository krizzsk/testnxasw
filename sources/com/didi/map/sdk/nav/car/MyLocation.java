package com.didi.map.sdk.nav.car;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.nav.util.ApolloToggleUtils;
import com.map.sdk.nav.libc.common.CommonUtils;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import java.util.List;

public class MyLocation implements IMyLocationDelegate {

    /* renamed from: a */
    private static final String f30851a = "MyLocation";

    /* renamed from: b */
    private Map f30852b;

    /* renamed from: c */
    private CarMarker f30853c;

    /* renamed from: d */
    private AnimationPartInterface f30854d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public onCarAnimationListener f30855e;

    /* renamed from: f */
    private int f30856f = 3000;

    /* renamed from: g */
    private boolean f30857g = false;

    /* renamed from: h */
    private List<LatLng> f30858h;

    /* renamed from: i */
    private CameraMode f30859i = CameraMode.NORTH_UP;

    /* renamed from: j */
    private boolean f30860j = false;

    /* renamed from: k */
    private int f30861k = -1;

    /* renamed from: l */
    private int f30862l = -1;

    /* renamed from: m */
    private NavOverlay f30863m;

    /* renamed from: n */
    private int f30864n = 0;

    /* renamed from: o */
    private int f30865o = (CommonUtils.getScreenWidth() / 2);

    /* renamed from: p */
    private int f30866p = 0;

    /* renamed from: q */
    private boolean f30867q = false;

    /* renamed from: r */
    private boolean f30868r = false;

    /* renamed from: s */
    private double f30869s;

    /* renamed from: t */
    private boolean f30870t = false;

    private MyLocation(Map map) {
        this.f30852b = map;
        if (map != null && DriverCarNewAnimApollo.getInstance().enable()) {
            DriverCarNewAnimApollo.getInstance().setMapVendor(map.getMapVendor());
        }
        this.f30869s = -1.0d;
    }

    public static IMyLocationDelegate create(Map map) {
        return new MyLocation(map);
    }

    public void set3DCarEnabled(boolean z) {
        this.f30867q = z && ApolloToggleUtils.is3DCarEnabled();
    }

    public void set3DCarIcons(List<String> list) {
        this.f30868r = CarAngleUtil.init(list);
    }

    public boolean refresh3DCarIcons(boolean z, List<String> list) {
        set3DCarEnabled(z);
        set3DCarIcons(list);
        this.f30867q = this.f30867q && this.f30868r;
        CarMarker carMarker = this.f30853c;
        if (carMarker == null) {
            return false;
        }
        int indexByAngle = CarAngleUtil.getIndexByAngle(carMarker.getRotation());
        this.f30853c.setRotation(0.0f);
        this.f30853c.set3DCarEnabled(this.f30867q);
        this.f30853c.setIcon(this.f30852b.getContext(), CarAngleUtil.getCarBitmapDescriptor(this.f30852b.getContext(), indexByAngle));
        return true;
    }

    public void setNavRoutePoints(List<LatLng> list, boolean z) {
        this.f30858h = list;
        m23723a(z);
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.setRoutePoints(list);
        }
    }

    public void setCarMarkerOptions(String str, MarkerOptions markerOptions) {
        if (this.f30852b != null && markerOptions != null) {
            boolean z = this.f30867q && this.f30868r;
            this.f30867q = z;
            if (z) {
                Context context = this.f30852b.getContext();
                CarMarker carMarker = this.f30853c;
                markerOptions.icon(CarAngleUtil.getCarBitmapDescriptor(context, carMarker == null ? 0 : carMarker.getLastIndex()));
            }
            CarMarker carMarker2 = this.f30853c;
            if (carMarker2 == null) {
                Map map = this.f30852b;
                if (TextUtils.isEmpty(str)) {
                    str = "GROUP_DEFAULT";
                }
                Marker addMarker = map.addMarker(str, markerOptions);
                if (addMarker != null) {
                    this.f30853c = new CarMarker(this.f30852b.getContext(), addMarker);
                } else {
                    DLog.m10773d(f30851a, "addMarker error", new Object[0]);
                }
            } else {
                carMarker2.setOptions(markerOptions);
            }
            CarMarker carMarker3 = this.f30853c;
            if (carMarker3 != null) {
                DLog.m10773d(f30851a, "setCarMarkerOptions() id:%s", carMarker3.getId());
                this.f30853c.set3DCarEnabled(this.f30867q);
                this.f30853c.updateOriginIcon(markerOptions.getIcon());
            }
        }
    }

    public synchronized void animateTo(AnimateNode animateNode) {
        animateTo(animateNode, (DMKEventPoint) null);
    }

    public void animateTo(AnimateNode animateNode, DMKEventPoint dMKEventPoint) {
        CarMarker carMarker = this.f30853c;
        if (carMarker == null || carMarker.getMarker() == null) {
            DLog.m10773d(f30851a, "MyLocation animateTo error", new Object[0]);
            return;
        }
        if (!(animateNode == null || animateNode.index == -1)) {
            this.f30866p = animateNode.index;
        }
        List<LatLng> list = this.f30858h;
        if (list != null && this.f30866p > list.size() - 1) {
            this.f30866p = 0;
        }
        m23723a(false);
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.start(animateNode, dMKEventPoint);
        }
    }

    public synchronized void animateCancel(onCarAnimationCancelListener oncaranimationcancellistener) {
        if (this.f30854d != null) {
            this.f30854d.setOnCarAnimationListener((onCarAnimationListener) null);
            this.f30854d.destroy();
            this.f30854d = null;
        }
        if (oncaranimationcancellistener != null) {
            oncaranimationcancellistener.onCancel();
        }
    }

    /* renamed from: a */
    private void m23723a(boolean z) {
        CarMarker carMarker;
        if (this.f30854d == null && (carMarker = this.f30853c) != null && carMarker.getMarker() != null) {
            AnimationNewPart animationNewPart = new AnimationNewPart(this.f30852b, this.f30853c);
            this.f30854d = animationNewPart;
            animationNewPart.setCarHeadParams(this.f30865o, this.f30866p);
            this.f30854d.setAnimationInterval(this.f30856f);
            this.f30854d.setOnCarAnimationListener(new onCarAnimationListener() {
                public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
                    if (MyLocation.this.f30855e != null) {
                        MyLocation.this.f30855e.onUpdateAllLine(list, list2);
                    }
                }

                public void onErase(List<LatLng> list) {
                    if (MyLocation.this.f30855e != null) {
                        MyLocation.this.f30855e.onErase(list);
                    }
                }

                public void onErase(int i, int i2, LatLng latLng) {
                    if (MyLocation.this.f30855e != null) {
                        MyLocation.this.f30855e.onErase(i, i2, latLng);
                    }
                }
            });
            this.f30854d.setCameraMode(this.f30859i, false);
            this.f30854d.setIsBackground(this.f30857g);
            this.f30854d.setRoutePoints(this.f30858h);
            if (z && this.f30859i == CameraMode.CAR_HEAD_UP) {
                this.f30854d.zoomToNav();
            }
            this.f30854d.setCarImageView(this.f30863m);
            this.f30854d.followMyLocation(this.f30860j);
            double d = this.f30869s;
            if (d > 0.0d) {
                this.f30854d.setCarHeadMaxMapLevel(d);
            }
        }
    }

    public void destroy() {
        CarMarker carMarker;
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.setOnCarAnimationListener((onCarAnimationListener) null);
            this.f30854d.destroy();
            this.f30854d.resetMapTilt();
            this.f30854d = null;
        }
        NavOverlay navOverlay = this.f30863m;
        if (navOverlay != null) {
            NavOverlay.removeFromMapView(navOverlay, this.f30852b);
            this.f30863m = null;
        }
        this.f30858h = null;
        Map map = this.f30852b;
        if (!(map == null || (carMarker = this.f30853c) == null)) {
            map.remove(carMarker.getMarker());
            this.f30853c.destroy();
            this.f30853c = null;
        }
        if (this.f30867q) {
            CarAngleUtil.destroy();
        }
        this.f30852b = null;
        this.f30855e = null;
    }

    public void setIsBackground(boolean z) {
        this.f30857g = z;
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.setIsBackground(z);
        }
    }

    public void setCameraMode(CameraMode cameraMode) {
        if (this.f30859i != cameraMode) {
            if (cameraMode != CameraMode.CAR_HEAD_UP) {
                Padding padding = this.f30852b.getPadding();
                if (!(-1 == this.f30861k || -1 == this.f30862l)) {
                    this.f30852b.setPadding(padding.left, this.f30861k, padding.right, this.f30862l);
                }
            } else if (DriverCarNewAnimApollo.getInstance().enable()) {
                setCarImageMarginV2();
            } else {
                m23724b();
            }
        }
        this.f30859i = cameraMode;
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.setCameraMode(cameraMode);
            this.f30854d.setCarImageView(this.f30863m);
        }
    }

    public void followMyLocation(boolean z) {
        this.f30860j = z;
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.followMyLocation(z);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        this.f30861k = i2;
        this.f30862l = i4;
        if (this.f30859i != CameraMode.CAR_HEAD_UP) {
            return;
        }
        if (DriverCarNewAnimApollo.getInstance().enable()) {
            setCarImageMarginV2();
        } else {
            m23724b();
        }
    }

    public void zoomToNav() {
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.zoomToNav();
        }
    }

    public double distanceLeft() {
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            return animationPartInterface.distanceLeft();
        }
        return -1.0d;
    }

    public void setCarHeadMaxMapLevel(double d) {
        this.f30869s = d;
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.setCarHeadMaxMapLevel(d);
        }
    }

    public void setCarMarkerOrImageEnable(boolean z) {
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.setCarMarkerOrImageEnable(z);
        }
    }

    public AnimateNode getCurrentAnimNode() {
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            return animationPartInterface.getCurrentAnimNode();
        }
        return null;
    }

    public void setIsPassenger(boolean z) {
        this.f30870t = z;
    }

    public AnimationPartInterface getCarAnimator() {
        return this.f30854d;
    }

    public CarMarker getCarMarker() {
        return this.f30853c;
    }

    public NavOverlay getCarImage() {
        return this.f30863m;
    }

    public void setAnimationInterval(int i) {
        this.f30856f = i;
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.setAnimationInterval(i);
        }
    }

    public void setCarAnimationListener(onCarAnimationListener oncaranimationlistener) {
        this.f30855e = oncaranimationlistener;
    }

    /* renamed from: a */
    private void m23722a() {
        Map map;
        if (this.f30863m != null || this.f30852b == null) {
            NavOverlay navOverlay = this.f30863m;
            if (navOverlay != null && (map = this.f30852b) != null) {
                navOverlay.setMargin(0, this.f30864n, 0, 0, map.getHeight());
                return;
            }
            return;
        }
        NavOverlay navOverlay2 = new NavOverlay(this.f30852b.getContext(), this.f30864n);
        this.f30863m = navOverlay2;
        CarMarker carMarker = this.f30853c;
        if (carMarker != null) {
            navOverlay2.setIcon(carMarker.getIcon());
        }
        this.f30863m.setVisible(false);
        NavOverlay.addToMapView(this.f30863m, this.f30852b);
    }

    /* renamed from: b */
    private void m23724b() {
        int i;
        Map map = this.f30852b;
        if (map == null) {
            DLog.m10773d(f30851a, "setCarImageMargin , map is null", new Object[0]);
            return;
        }
        Padding padding = map.getPadding();
        int dp2pixel = CommonUtils.dp2pixel(50);
        this.f30864n = this.f30852b.getHeight() / 16;
        double height = ((double) this.f30852b.getHeight()) * 0.33d;
        int i2 = this.f30864n;
        while (true) {
            i = (int) (height + ((double) (i2 * 2)));
            if ((this.f30852b.getHeight() / 2) - i >= this.f30862l + dp2pixel) {
                break;
            }
            this.f30864n -= dp2pixel / 4;
            height = ((double) this.f30852b.getHeight()) * 0.33d;
            i2 = this.f30864n;
        }
        int height2 = ((this.f30852b.getHeight() / 2) - this.f30861k) + i;
        this.f30865o = height2;
        AnimationPartInterface animationPartInterface = this.f30854d;
        if (animationPartInterface != null) {
            animationPartInterface.setCarHeadParams(height2, this.f30866p);
        }
        if (i >= 0) {
            this.f30852b.setPadding(padding.left, i, padding.right, 0);
        } else {
            this.f30852b.setPadding(padding.left, 0, padding.right, -i);
        }
    }

    public void setCarImageMarginV2() {
        Map map = this.f30852b;
        if (map == null || map.getPadding() == null) {
            DLog.m10773d(f30851a, "mMap or padding is null", new Object[0]);
            return;
        }
        Padding padding = this.f30852b.getPadding();
        int i = padding.left;
        int i2 = this.f30861k;
        int i3 = padding.right;
        int i4 = this.f30862l;
        float carPaddingTopRatio = DriverCarNewAnimApollo.getInstance().getCarPaddingTopRatio();
        if (this.f30861k >= 0 && this.f30862l >= 0 && this.f30852b.getHeight() > 0) {
            i2 = (int) (((float) this.f30861k) + (carPaddingTopRatio * ((float) ((this.f30852b.getHeight() - this.f30861k) - this.f30862l))));
            this.f30865o = (int) (((float) i2) + (((float) ((this.f30852b.getHeight() - i2) - i4)) / 2.0f));
            DLog.m10773d(f30851a, "DriverCarAnim pixelNumBetweenCarAndTopView: " + this.f30865o, new Object[0]);
            AnimationPartInterface animationPartInterface = this.f30854d;
            if (animationPartInterface != null) {
                animationPartInterface.setCarHeadParams(this.f30865o, this.f30866p);
            }
        }
        this.f30852b.setPadding(i, i2, i3, i4);
    }
}
