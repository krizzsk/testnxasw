package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.adapt.MapUtil;
import rui.config.RConfigConstants;

public class BitmapFormater {
    public static final int FORMAT_ASSET = 2;
    public static final int FORMAT_BITMAP = 7;
    public static final int FORMAT_DEFAULT = 5;
    public static final int FORMAT_DEFAULT_F = 6;
    public static final int FORMAT_FILE = 3;
    public static final int FORMAT_NONE = -1;
    public static final int FORMAT_PATH = 4;
    public static final int FORMAT_RESOURCE = 1;

    /* renamed from: a */
    private static final String f26709a = "marker_default.png";

    /* renamed from: b */
    private int f26710b = -1;

    /* renamed from: c */
    private int f26711c = -1;

    /* renamed from: d */
    private String f26712d = "";

    /* renamed from: e */
    private String f26713e = "";

    /* renamed from: f */
    private String f26714f = "";

    /* renamed from: g */
    private float f26715g = -1.0f;

    /* renamed from: h */
    private Bitmap f26716h = null;

    /* renamed from: i */
    private String f26717i = null;

    /* renamed from: a */
    private String m21153a(float f) {
        if (f < 30.0f) {
            return "RED.png";
        }
        if (f >= 30.0f && f < 60.0f) {
            return "ORANGE.png";
        }
        if (f >= 60.0f && f < 120.0f) {
            return "YELLOW.png";
        }
        if (f >= 120.0f && f < 180.0f) {
            return "GREEN.png";
        }
        if (f >= 180.0f && f < 210.0f) {
            return "CYAN.png";
        }
        if (f >= 210.0f && f < 240.0f) {
            return "AZURE.png";
        }
        if (f >= 240.0f && f < 270.0f) {
            return "BLUE.png";
        }
        if (f >= 270.0f && f < 300.0f) {
            return "VIOLET.png";
        }
        if (f >= 300.0f && f < 330.0f) {
            return "MAGENTAV.png";
        }
        if (f >= 330.0f) {
            return "ROSE.png";
        }
        return null;
    }

    public BitmapFormater(int i) {
        this.f26710b = i;
    }

    public String getBitmapId() {
        return this.f26717i;
    }

    /* renamed from: a */
    private String m21154a(Bitmap bitmap) {
        String obj = bitmap.toString();
        if (obj == null) {
            obj = "";
        }
        String replace = obj.replace("android.graphics.Bitmap@", "");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        return (replace + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.hashCode() + RConfigConstants.KEYWORD_COLOR_SIGN + width + RConfigConstants.KEYWORD_COLOR_SIGN + height + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getRowBytes()) + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getPixel(width / 2, height / 2);
    }

    public Bitmap getBitmap(Context context) {
        Bitmap bitmap = this.f26716h;
        if (bitmap != null) {
            this.f26717i = m21154a(bitmap);
            return this.f26716h;
        } else if (context == null) {
            return null;
        } else {
            switch (this.f26710b) {
                case 1:
                    this.f26717i = "res_" + this.f26711c;
                    if (MapUtil.bimMapCach != null) {
                        this.f26716h = MapUtil.bimMapCach.get(this.f26717i);
                    }
                    if (this.f26716h == null) {
                        this.f26716h = MapUtil.decodeBitmapFromRes(context, this.f26711c);
                        if (!(MapUtil.bimMapCach == null || this.f26716h == null)) {
                            MapUtil.bimMapCach.put(this.f26717i, this.f26716h);
                            break;
                        }
                    }
                    break;
                case 2:
                    this.f26717i = "asset_" + this.f26712d;
                    if (MapUtil.bimMapCach != null) {
                        this.f26716h = MapUtil.bimMapCach.get(this.f26717i);
                    }
                    if (this.f26716h == null) {
                        Bitmap bimpaFromAsset2 = MapUtil.getBimpaFromAsset2(context, this.f26712d);
                        this.f26716h = bimpaFromAsset2;
                        if (bimpaFromAsset2 == null) {
                            Bitmap bitmapFromAsset = MapUtil.getBitmapFromAsset(context, this.f26712d);
                            this.f26716h = bitmapFromAsset;
                            if (bitmapFromAsset != null) {
                                this.f26716h = MapUtil.adaptFromXhResource(bitmapFromAsset);
                            }
                        }
                        if (!(MapUtil.bimMapCach == null || this.f26716h == null)) {
                            MapUtil.bimMapCach.put(this.f26717i, this.f26716h);
                            break;
                        }
                    }
                    break;
                case 3:
                    this.f26717i = "file_" + this.f26713e;
                    if (MapUtil.bimMapCach != null) {
                        this.f26716h = MapUtil.bimMapCach.get(this.f26717i);
                    }
                    if (this.f26716h == null) {
                        this.f26716h = MapUtil.decodeBitmapFromFile(context, this.f26713e);
                        break;
                    }
                    break;
                case 4:
                    this.f26717i = "path_" + this.f26714f;
                    if (MapUtil.bimMapCach != null) {
                        this.f26716h = MapUtil.bimMapCach.get(this.f26717i);
                    }
                    if (this.f26716h == null) {
                        this.f26716h = MapUtil.decodeBitmapFromPath(this.f26714f);
                        if (!(MapUtil.bimMapCach == null || this.f26716h == null)) {
                            MapUtil.bimMapCach.put(this.f26717i, this.f26716h);
                            break;
                        }
                    }
                    break;
                case 5:
                    this.f26717i = "asset_marker_default.png";
                    if (MapUtil.bimMapCach != null) {
                        this.f26716h = MapUtil.bimMapCach.get(this.f26717i);
                    }
                    if (this.f26716h == null) {
                        this.f26716h = MapUtil.getBitmapFromAsset(context, f26709a);
                        if (!(MapUtil.bimMapCach == null || this.f26716h == null)) {
                            MapUtil.bimMapCach.put(this.f26717i, this.f26716h);
                            break;
                        }
                    }
                    break;
                case 6:
                    String a = m21153a(this.f26715g);
                    if (a != null) {
                        this.f26717i = "asset_" + a;
                        if (MapUtil.bimMapCach != null) {
                            this.f26716h = MapUtil.bimMapCach.get(this.f26717i);
                        }
                        if (this.f26716h == null) {
                            this.f26716h = MapUtil.getBitmapFromAsset(context, a);
                            if (!(MapUtil.bimMapCach == null || this.f26716h == null)) {
                                MapUtil.bimMapCach.put(this.f26717i, this.f26716h);
                                break;
                            }
                        }
                    }
                    break;
            }
            return this.f26716h;
        }
    }

    public void setResourceId(int i) {
        this.f26711c = i;
    }

    public void setAssetsName(String str) {
        this.f26712d = str;
    }

    public void setFileName(String str) {
        this.f26713e = str;
    }

    public void setPathName(String str) {
        this.f26714f = str;
    }

    public void setDefuatlColor(float f) {
        this.f26715g = f;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f26716h = bitmap;
    }

    public int getFormateType() {
        return this.f26710b;
    }
}
