package com.didi.global.map.animation.transition.util;

import android.location.Location;
import com.didi.common.map.model.LatLng;
import com.didi.global.map.animation.transition.SodaAnimEngine;
import java.util.HashMap;
import java.util.Map;

public class AngleUtil {

    /* renamed from: a */
    private static final float f24736a = 22.5f;

    /* renamed from: b */
    private static final float f24737b = 11.25f;

    /* renamed from: c */
    private static final float f24738c = 33.75f;

    /* renamed from: d */
    private static final float f24739d = 56.25f;

    /* renamed from: e */
    private static final float f24740e = 78.75f;

    /* renamed from: f */
    private static final float f24741f = 101.25f;

    /* renamed from: g */
    private static final float f24742g = 123.75f;

    /* renamed from: h */
    private static final float f24743h = 146.25f;

    /* renamed from: i */
    private static final float f24744i = 168.75f;

    /* renamed from: j */
    private static final float f24745j = 191.25f;

    /* renamed from: k */
    private static final float f24746k = 213.75f;

    /* renamed from: l */
    private static final float f24747l = 236.25f;

    /* renamed from: m */
    private static final float f24748m = 258.75f;
    public static Map<Integer, Float> mAngleMap = null;

    /* renamed from: n */
    private static final float f24749n = 281.25f;

    /* renamed from: o */
    private static final float f24750o = 303.75f;

    /* renamed from: p */
    private static final float f24751p = 326.25f;

    /* renamed from: q */
    private static final float f24752q = 348.75f;

    public static int getIndexByAngle(float f) {
        if (f >= f24737b && f < f24738c) {
            return 2;
        }
        if (f >= f24738c && f < f24739d) {
            return 3;
        }
        if (f >= f24739d && f < f24740e) {
            return 4;
        }
        if (f >= f24740e && f < f24741f) {
            return 5;
        }
        if (f >= f24741f && f < f24742g) {
            return 6;
        }
        if (f >= f24742g && f < f24743h) {
            return 7;
        }
        if (f >= f24743h && f < f24744i) {
            return 8;
        }
        if (f >= f24744i && f < f24745j) {
            return 9;
        }
        if (f >= f24745j && f < f24746k) {
            return 10;
        }
        if (f >= f24746k && f < f24747l) {
            return 11;
        }
        if (f >= f24747l && f < f24748m) {
            return 12;
        }
        if (f >= f24748m && f < f24749n) {
            return 13;
        }
        if (f >= f24749n && f < f24750o) {
            return 14;
        }
        if (f < f24750o || f >= f24751p) {
            return (f < f24751p || f >= f24752q) ? 1 : 16;
        }
        return 15;
    }

    /* renamed from: a */
    private static Location m19845a(LatLng latLng) {
        Location location = new Location("someLoc");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        return location;
    }

    public static float getAngle(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            return (m19845a(latLng).bearingTo(m19845a(latLng2)) + 360.0f) % 360.0f;
        }
        LogUtil.m19846e("getAngle() from = null || to = null");
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
            mAngleMap.put(2, Float.valueOf(f24736a));
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
