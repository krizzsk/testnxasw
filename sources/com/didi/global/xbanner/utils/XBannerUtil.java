package com.didi.global.xbanner.utils;

import android.content.Context;
import android.graphics.Color;
import rui.config.RConfigConstants;

public class XBannerUtil {

    /* renamed from: a */
    private static float f24855a = 74.0f;

    /* renamed from: b */
    private static float f24856b = 167.0f;

    /* renamed from: c */
    private static float f24857c;

    /* renamed from: d */
    private static float f24858d;

    public static int getColor(String str) {
        try {
            if (!str.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
                str = RConfigConstants.KEYWORD_COLOR_SIGN + str;
            }
            return Color.parseColor(str);
        } catch (Exception unused) {
            return Color.parseColor("#ffffff");
        }
    }

    public static int getItemWidth(Context context) {
        return DisplayUtils.dip2px(context, 290.0f);
    }

    public static int getItemHeight(Context context) {
        return (int) (((double) getItemWidth(context)) * 0.25d);
    }

    public static int getDefaultItemHeight(Context context) {
        return DisplayUtils.dip2px(context, m19941a());
    }

    public static int getUnfoldItemHeight(Context context) {
        return (int) (((double) getItemWidth(context)) * 0.5d);
    }

    public static int getUnfoldDefaultItemHeight(Context context) {
        return DisplayUtils.dip2px(context, m19942b());
    }

    public static int getFullItemWidth(Context context) {
        return DisplayUtils.getScreenWidth(context);
    }

    public static int getFullItemWidthWithoutMargin(Context context) {
        return DisplayUtils.getScreenWidth(context) - DisplayUtils.dip2px(context, 20.0f);
    }

    /* renamed from: a */
    private static float m19941a() {
        float f = f24857c;
        return f <= 0.0f ? f24855a : f;
    }

    public static void setItemHeight(float f) {
        f24857c = f;
    }

    /* renamed from: b */
    private static float m19942b() {
        float f = f24858d;
        return f <= 0.0f ? f24856b : f;
    }

    public static void setItemUnfoldHeight(float f) {
        f24858d = f;
    }

    public static int px2dpFromServer(int i) {
        return i / 2;
    }
}
