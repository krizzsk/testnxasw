package com.dmap.navigation.simple;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.INaviLatLng;
import com.dmap.navigation.base.location.INaviPoi;

public class SimplePoi implements INaviPoi {

    /* renamed from: a */
    private LatLng f54588a;

    /* renamed from: b */
    private String f54589b;

    /* renamed from: c */
    private String f54590c;

    /* renamed from: d */
    private String f54591d;

    public SimplePoi(INaviLatLng iNaviLatLng, String str, String str2) {
        this(iNaviLatLng, str, str2, "");
    }

    public SimplePoi(INaviLatLng iNaviLatLng, String str, String str2, String str3) {
        if (iNaviLatLng instanceof LatLng) {
            this.f54588a = (LatLng) iNaviLatLng;
        } else {
            this.f54588a = new LatLng(iNaviLatLng.getLat(), iNaviLatLng.getLng());
        }
        this.f54589b = str;
        this.f54590c = str2;
        this.f54591d = str3;
    }

    public String toString() {
        return "SimplePoi{latLng=" + this.f54588a + ", name='" + this.f54589b + '\'' + ", uid='" + this.f54590c + '\'' + ", chooseFlag='" + this.f54591d + '\'' + '}';
    }

    public LatLng getLatLng() {
        return this.f54588a;
    }

    public String getUid() {
        return this.f54590c;
    }

    public String getName() {
        return this.f54589b;
    }

    public String getChooseFlag() {
        return this.f54591d;
    }
}
