package com.didi.global.map.animation.util;

import android.location.Location;
import com.didi.common.map.model.LatLng;
import com.didi.global.map.animation.SodaAnimEngine;
import java.util.HashMap;
import java.util.Map;

public class AngleUtil {

    /* renamed from: a */
    private static final float f24757a = 22.5f;

    /* renamed from: b */
    private static final float f24758b = 11.25f;

    /* renamed from: c */
    private static final float f24759c = 33.75f;

    /* renamed from: d */
    private static final float f24760d = 56.25f;

    /* renamed from: e */
    private static final float f24761e = 78.75f;

    /* renamed from: f */
    private static final float f24762f = 101.25f;

    /* renamed from: g */
    private static final float f24763g = 123.75f;

    /* renamed from: h */
    private static final float f24764h = 146.25f;

    /* renamed from: i */
    private static final float f24765i = 168.75f;

    /* renamed from: j */
    private static final float f24766j = 191.25f;

    /* renamed from: k */
    private static final float f24767k = 213.75f;

    /* renamed from: l */
    private static final float f24768l = 236.25f;

    /* renamed from: m */
    private static final float f24769m = 258.75f;
    public static Map<Integer, Float> mAngleMap = null;

    /* renamed from: n */
    private static final float f24770n = 281.25f;

    /* renamed from: o */
    private static final float f24771o = 303.75f;

    /* renamed from: p */
    private static final float f24772p = 326.25f;

    /* renamed from: q */
    private static final float f24773q = 348.75f;

    public static int getIndexByAngle(float f) {
        if (f >= f24758b && f < f24759c) {
            return 2;
        }
        if (f >= f24759c && f < f24760d) {
            return 3;
        }
        if (f >= f24760d && f < f24761e) {
            return 4;
        }
        if (f >= f24761e && f < f24762f) {
            return 5;
        }
        if (f >= f24762f && f < f24763g) {
            return 6;
        }
        if (f >= f24763g && f < f24764h) {
            return 7;
        }
        if (f >= f24764h && f < f24765i) {
            return 8;
        }
        if (f >= f24765i && f < f24766j) {
            return 9;
        }
        if (f >= f24766j && f < f24767k) {
            return 10;
        }
        if (f >= f24767k && f < f24768l) {
            return 11;
        }
        if (f >= f24768l && f < f24769m) {
            return 12;
        }
        if (f >= f24769m && f < f24770n) {
            return 13;
        }
        if (f >= f24770n && f < f24771o) {
            return 14;
        }
        if (f < f24771o || f >= f24772p) {
            return (f < f24772p || f >= f24773q) ? 1 : 16;
        }
        return 15;
    }

    /* renamed from: a */
    private static Location m19854a(LatLng latLng) {
        Location location = new Location("someLoc");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        return location;
    }

    public static float getAngle(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            return (m19854a(latLng).bearingTo(m19854a(latLng2)) + 360.0f) % 360.0f;
        }
        LogUtil.m19855e("getAngle() from = null || to = null");
        return SodaAnimEngine.DefaultAngle;
    }

    public static int getIndexByLatLng(LatLng latLng, LatLng latLng2) {
        return getIndexByAngle(getAngle(latLng, latLng2));
    }

    public static float getSpecifiedAngle(int i) {
        if (i < 1 || i > 16) {
            return SodaAnimEngine.DefaultAngle;
        }
        if (mAngleMap == null) {
            HashMap hashMap = new HashMap();
            mAngleMap = hashMap;
            hashMap.put(1, Float.valueOf(0.0f));
            mAngleMap.put(2, Float.valueOf(f24757a));
            mAngleMap.put(3, Float.valueOf(45.0f));
            mAngleMap.put(4, Float.valueOf(67.5f));
            mAngleMap.put(5, Float.valueOf(90.0f));
            mAngleMap.put(6, Float.valueOf(112.5f));
            mAngleMap.put(7, Float.valueOf(135.0f));
            mAngleMap.put(8, Float.valueOf(157.5f));
            mAngleMap.put(9, Float.valueOf(180.0f));
            mAngleMap.put(10, Float.valueOf(202.5f));
            mAngleMap.put(11, Float.valueOf(225.0f));
            mAngleMap.put(12, Float.valueOf(247.5f));
            mAngleMap.put(13, Float.valueOf(270.0f));
            mAngleMap.put(14, Float.valueOf(292.5f));
            mAngleMap.put(15, Float.valueOf(315.0f));
            mAngleMap.put(16, Float.valueOf(337.5f));
        }
        return mAngleMap.get(Integer.valueOf(i)).floatValue();
    }

    public static float getSpecifiedAngle(LatLng latLng, LatLng latLng2) {
        return getSpecifiedAngle(getIndexByAngle(getAngle(latLng, latLng2)));
    }
}
