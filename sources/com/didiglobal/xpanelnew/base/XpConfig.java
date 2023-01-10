package com.didiglobal.xpanelnew.base;

import com.didiglobal.xpanelnew.omega.XPanelOmegaCallback;

public class XpConfig {

    /* renamed from: a */
    private float f54148a;

    /* renamed from: b */
    private float f54149b;

    /* renamed from: c */
    private float f54150c;

    /* renamed from: d */
    private float f54151d;

    /* renamed from: e */
    private int f54152e;

    public float getCardRoundedCornerDp() {
        return this.f54148a;
    }

    private XpConfig(Builder builder) {
        this.f54148a = builder.cardRoundedCorner;
        this.f54149b = builder.defaultFoldHeight;
        this.f54150c = builder.defaultDpSecondCardShowHeight;
        this.f54151d = builder.oneCardAndXDp;
        this.f54152e = builder.firstCardHeightWillChangeTo;
    }

    public float getDefaultDpFoldHeight() {
        return this.f54149b;
    }

    public float getDefaultDpSecondCardShowHeight() {
        return this.f54150c;
    }

    public int getFirstCardHeightWillChangeTo() {
        return this.f54152e;
    }

    public float getOneCardAndXDp() {
        return this.f54151d;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public float cardRoundedCorner = 20.0f;
        /* access modifiers changed from: private */
        public float defaultDpSecondCardShowHeight = 70.0f;
        /* access modifiers changed from: private */
        public float defaultFoldHeight = 100.0f;
        /* access modifiers changed from: private */
        public int firstCardHeightWillChangeTo = 0;
        /* access modifiers changed from: private */
        public float oneCardAndXDp = 0.0f;
        private XPanelOmegaCallback xPanelOmegaCallback;

        public Builder setRoundedCorner(float f) {
            this.cardRoundedCorner = f;
            return this;
        }

        public Builder setOneCardAndXDp(float f) {
            this.oneCardAndXDp = f;
            return this;
        }

        public Builder setFirstCardHeightWillChangeTo(int i) {
            this.firstCardHeightWillChangeTo = i;
            return this;
        }

        public XpConfig build() {
            return new XpConfig(this);
        }

        public Builder setDefaultFoldHeight(float f) {
            this.defaultFoldHeight = f;
            return this;
        }

        public Builder setDefaultDpSecondCardShowHeight(float f) {
            this.defaultDpSecondCardShowHeight = f;
            return this;
        }
    }
}
