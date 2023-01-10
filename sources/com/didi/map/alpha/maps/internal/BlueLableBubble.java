package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.map.common.MarkerBitmapUtil;
import com.didi.map.common.utils.SystemUtil;

public class BlueLableBubble implements ILableBubble {

    /* renamed from: a */
    private LableMarkerConfig f26739a;

    /* renamed from: b */
    private MarkerBitmapUtil f26740b;

    public String getIconFileName(boolean z, String str) {
        return "";
    }

    private BlueLableBubble() {
    }

    public BlueLableBubble(LableMarkerConfig lableMarkerConfig, MarkerBitmapUtil markerBitmapUtil) {
        this.f26739a = lableMarkerConfig;
        this.f26740b = markerBitmapUtil;
    }

    public int getTextColor(boolean z, String str) {
        if (z) {
            return this.f26739a.getFontColorNight();
        }
        return this.f26739a.getFontColor();
    }

    public String getMarkerFileName(boolean z, String str, int i) {
        if (!z) {
            if (BitmapUtil.fDensityXH >= 1.0f) {
                if (i == 1) {
                    return this.f26739a.getFileNameLeft();
                }
                if (i == 2) {
                    return this.f26739a.getFileNameRight();
                }
                return this.f26739a.getFileName();
            } else if (i == 1) {
                return this.f26739a.getFileNameLeft2();
            } else {
                if (i == 2) {
                    return this.f26739a.getFileNameRight2();
                }
                return this.f26739a.getFileName2();
            }
        } else if (BitmapUtil.fDensityXH >= 1.0f) {
            if (i == 1) {
                return this.f26739a.getFileNameLeftNight();
            }
            if (i == 2) {
                return this.f26739a.getFileNameRightNight();
            }
            return this.f26739a.getFileNameNight();
        } else if (i == 1) {
            return this.f26739a.getFileNameLeftNight2();
        } else {
            if (i == 2) {
                return this.f26739a.getFileNameRightNight2();
            }
            return this.f26739a.getFileNameNight2();
        }
    }

    public Bitmap getMarkerBitmap(Context context, String str, int i, String str2, String str3, boolean z, int i2) {
        int i3;
        int i4;
        int i5;
        if (context == null) {
            return null;
        }
        int dip2px = (int) SystemUtil.dip2px(context, 7.0f);
        if (BitmapUtil.fDensityXH >= 1.0f) {
            i5 = 8;
            i4 = 8;
            i3 = 19;
        } else {
            i5 = 14;
            i4 = 11;
            i3 = 31;
        }
        int[] iArr = new int[4];
        iArr[0] = dip2px;
        iArr[2] = dip2px;
        iArr[1] = i5;
        iArr[3] = i4;
        int fontSize = this.f26739a.getFontSize();
        if (z) {
            return this.f26740b.getMarkerBitmap_V2(context, str, (float) fontSize, i, str2, i3, iArr);
        }
        return this.f26740b.getMarkerBitmap(context, str, (float) fontSize, i, str2, i3, iArr, 17);
    }
}
