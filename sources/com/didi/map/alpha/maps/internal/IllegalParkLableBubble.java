package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.hawaii.basic.HWContextProvider;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.map.common.MarkerBitmapUtil;
import com.didi.map.common.utils.SystemUtil;

public class IllegalParkLableBubble implements ILableBubble {

    /* renamed from: a */
    private final LableMarkerConfig f26764a;

    /* renamed from: b */
    private final MarkerBitmapUtil f26765b;

    /* renamed from: c */
    private final int f26766c = ((int) SystemUtil.dip2px(HWContextProvider.getContext(), 18.0f));

    /* renamed from: d */
    private final int f26767d = ((int) SystemUtil.dip2px(HWContextProvider.getContext(), 14.0f));

    /* renamed from: a */
    private int m21179a(int i) {
        return i == 1 ? 0 : 2;
    }

    public String getIconFileName(boolean z, String str) {
        return "";
    }

    public IllegalParkLableBubble(LableMarkerConfig lableMarkerConfig, MarkerBitmapUtil markerBitmapUtil) {
        this.f26764a = lableMarkerConfig;
        this.f26765b = markerBitmapUtil;
    }

    public int getTextColor(boolean z, String str) {
        return this.f26764a.getFontColor();
    }

    public String getMarkerFileName(boolean z, String str, int i) {
        if (BitmapUtil.fDensityXH >= 1.0f) {
            if (z) {
                return this.f26764a.getFileNameRight();
            }
            return this.f26764a.getFileNameRightNight();
        } else if (z) {
            return this.f26764a.getFileNameRight2();
        } else {
            return this.f26764a.getFileNameRightNight2();
        }
    }

    public int[] getBitmapWh(Context context, String str, int i, String str2, int i2) {
        if (context == null) {
            return null;
        }
        return this.f26765b.getMultiRouteWH(context, str2);
    }

    public Bitmap getMarkerBitmap(Context context, String str, int i, String str2, String str3, boolean z, int i2) {
        if (context == null) {
            return null;
        }
        m21179a(i2);
        int[] iArr = new int[4];
        iArr[0] = this.f26766c;
        iArr[2] = this.f26767d;
        iArr[1] = 39;
        iArr[3] = 10;
        int fontSize = this.f26764a.getFontSize();
        if (z) {
            String str4 = str2;
            return this.f26765b.getMarkerBitmap_V2(context, str2, 19, iArr);
        }
        float f = (float) fontSize;
        return this.f26765b.getMarkerBitmap(context, str, f, i, str2, 19, iArr, 0);
    }
}
