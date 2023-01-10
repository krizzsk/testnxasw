package com.didi.global.globaluikit.config;

import android.graphics.Rect;

public class LEGOUIConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f24286a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f24287b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Rect f24288c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f24289d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f24290e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f24291f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f24292g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f24293h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Rect f24294i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Rect f24295j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f24296k;

    public int getDrawerTitleTextSize() {
        return this.f24286a;
    }

    public int getDrawerContentTextSize() {
        return this.f24287b;
    }

    public Rect getDrawerOutMargin() {
        return this.f24288c;
    }

    public int getDrawerCornerRadius() {
        return this.f24289d;
    }

    public int getDrawerBgColor() {
        return this.f24290e;
    }

    public float getDrawerBgAlpha() {
        return this.f24291f;
    }

    public int getDrawerBtnRes() {
        return this.f24296k;
    }

    public int getDrawerHoriBtnInterval() {
        return this.f24292g;
    }

    public Rect getHoriBtnLayoutOutMargin() {
        return this.f24294i;
    }

    public Rect getVertiBtnLayoutOutMargin() {
        return this.f24295j;
    }

    public int getDrawerVertiBtnInterval() {
        return this.f24293h;
    }

    public static class Builder {
        private final LEGOUIConfig config = new LEGOUIConfig();

        public LEGOUIConfig build() {
            return this.config;
        }

        public Builder setDrawerTitleTextSize(int i) {
            int unused = this.config.f24286a = i;
            return this;
        }

        public Builder setDrawerContentTextSize(int i) {
            int unused = this.config.f24287b = i;
            return this;
        }

        public Builder setDrawerOutMargin(Rect rect) {
            Rect unused = this.config.f24288c = rect;
            return this;
        }

        public Builder setHoriBtnLayoutOutMargin(Rect rect) {
            Rect unused = this.config.f24294i = rect;
            return this;
        }

        public Builder setVertiBtnLayoutOutMargin(Rect rect) {
            Rect unused = this.config.f24295j = rect;
            return this;
        }

        public Builder setDrawerCornerRadius(int i) {
            int unused = this.config.f24289d = i;
            return this;
        }

        public Builder setDrawerBgColor(int i) {
            int unused = this.config.f24290e = i;
            return this;
        }

        public Builder setDrawerBgAlpha(float f) {
            float unused = this.config.f24291f = f;
            return this;
        }

        public Builder setDrawerBtnRes(int i) {
            int unused = this.config.f24296k = i;
            return this;
        }

        public Builder setDrawerHoriBtnInterval(int i) {
            int unused = this.config.f24292g = i;
            return this;
        }

        public Builder setDrawerVertiBtnInterval(int i) {
            int unused = this.config.f24293h = i;
            return this;
        }
    }
}
