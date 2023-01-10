package com.didiglobal.dittoview.view;

import android.graphics.Color;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class DittoShadow {

    /* renamed from: a */
    private int f52510a;

    /* renamed from: b */
    private int f52511b;

    /* renamed from: c */
    private float f52512c;

    /* renamed from: d */
    private String f52513d;

    public boolean isEmpty() {
        return this.f52510a == 0 || this.f52511b <= 0;
    }

    public int getShadowColor() {
        return this.f52510a;
    }

    public void setShadowColor(String str) {
        this.f52510a = Color.parseColor(str);
    }

    public float getShadowOpacity() {
        return this.f52512c;
    }

    public void setShadowOpacity(float f) {
        this.f52512c = f;
    }

    public float getShadowOffsetX() {
        String[] split = this.f52513d.trim().replace(Const.joLeft, "").replace("}", "").split(",");
        if (split == null || split.length <= 0) {
            return 0.0f;
        }
        return Float.parseFloat(split[0]);
    }

    public float getShadowOffsetY() {
        String[] split = this.f52513d.trim().replace(Const.joLeft, "").replace("}", "").split(",");
        if (split == null || split.length <= 1) {
            return 0.0f;
        }
        return Float.parseFloat(split[1]);
    }

    public void setShadowOffset(String str) {
        this.f52513d = str;
    }

    public int getShadowRadius() {
        return this.f52511b;
    }

    public void setShadowRadius(int i) {
        this.f52511b = i;
    }
}
