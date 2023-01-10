package com.dmap.navigation.engine.simple;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.engine.core.camera.INaviCamera;
import com.dmap.navigation.jni.swig.NaviCamera;
import com.dmap.navigation.simple.SimpleLatlng;

public class SimpleNaviCamera implements INaviCamera {

    /* renamed from: a */
    private final int f54559a;

    /* renamed from: b */
    private final int f54560b;

    /* renamed from: c */
    private final LatLng f54561c;

    /* renamed from: d */
    private final int f54562d;

    /* renamed from: e */
    private final int f54563e;

    /* renamed from: f */
    private final int f54564f;

    /* renamed from: g */
    private final String f54565g;

    public SimpleNaviCamera(NaviCamera naviCamera) {
        this.f54559a = naviCamera.getType();
        this.f54560b = naviCamera.getSpeed();
        this.f54561c = new SimpleLatlng(naviCamera.getLatLng().getLat(), naviCamera.getLatLng().getLng());
        this.f54562d = naviCamera.getWeight();
        this.f54563e = naviCamera.getGroupId();
        this.f54564f = naviCamera.getBubbleType();
        this.f54565g = null;
    }

    public SimpleNaviCamera(int i, int i2, LatLng latLng, String str) {
        this.f54559a = i;
        this.f54560b = i2;
        this.f54561c = latLng;
        this.f54565g = str;
        this.f54562d = 0;
        this.f54563e = 0;
        this.f54564f = 0;
    }

    public String toString() {
        return "SimpleNaviCamera{type=" + this.f54559a + ", speed=" + this.f54560b + ", latLng=" + this.f54561c + ", weight=" + this.f54562d + ", groupId=" + this.f54563e + ", bubbleType=" + this.f54564f + ", describe='" + this.f54565g + '\'' + '}';
    }

    public int getType() {
        return this.f54559a;
    }

    public int getSpeed() {
        return this.f54560b;
    }

    public LatLng getLatLng() {
        return this.f54561c;
    }

    public int getWeight() {
        return this.f54562d;
    }

    public int getGroupId() {
        return this.f54563e;
    }

    public int getBubbleType() {
        return this.f54564f;
    }

    public String getDescribe() {
        return this.f54565g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof INaviCamera)) {
            return false;
        }
        INaviCamera iNaviCamera = (INaviCamera) obj;
        return this.f54561c != null && iNaviCamera.getLatLng() != null && this.f54559a == iNaviCamera.getType() && this.f54560b == iNaviCamera.getSpeed() && this.f54562d == iNaviCamera.getWeight() && this.f54561c.equals(iNaviCamera.getLatLng());
    }
}
