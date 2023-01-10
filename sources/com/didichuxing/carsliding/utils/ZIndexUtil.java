package com.didichuxing.carsliding.utils;

public class ZIndexUtil {
    public static final int ZINDEX_TYPE_DEPARTURE_BUBBLE = 3;
    public static final int ZINDEX_TYPE_DEPARTURE_MARK = 4;
    public static final int ZINDEX_TYPE_DRIVER = 7;
    public static final int ZINDEX_TYPE_LOCATION_ARROW = 2;
    public static final int ZINDEX_TYPE_LOCATION_AVATAR = 1;
    public static final int ZINDEX_TYPE_RECOMMEND_DEPARTURE = 6;
    public static final int ZINDEX_TYPE_ROUTE = 8;
    public static final int ZINDEX_TYPE_START_END_POINT = 5;

    /* renamed from: a */
    private static final int f48931a = 85;

    /* renamed from: b */
    private static final int f48932b = 90;

    /* renamed from: c */
    private static final int f48933c = 100;

    /* renamed from: d */
    private static final int f48934d = 95;

    /* renamed from: e */
    private static final int f48935e = 95;

    /* renamed from: f */
    private static final int f48936f = 75;

    /* renamed from: g */
    private static final int f48937g = 70;

    /* renamed from: h */
    private static final int f48938h = 65;

    /* renamed from: i */
    private static final int f48939i = 120;

    /* renamed from: j */
    private static final int f48940j = 30;

    public static int getBiggestAssignedZIndex() {
        return 120;
    }

    public static int getSmallestAssignedZIndex() {
        return 30;
    }

    public static int getZIndex(int i) {
        switch (i) {
            case 1:
                return 85;
            case 2:
                return 90;
            case 3:
                return 100;
            case 4:
            case 5:
                return 95;
            case 6:
                return 75;
            case 7:
                return 70;
            case 8:
                return 65;
            default:
                return 0;
        }
    }
}
