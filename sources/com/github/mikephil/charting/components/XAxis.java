package com.github.mikephil.charting.components;

import com.github.mikephil.charting.utils.Utils;

public class XAxis extends AxisBase {

    /* renamed from: a */
    private boolean f54873a = false;

    /* renamed from: b */
    private XAxisPosition f54874b = XAxisPosition.TOP;
    public int mLabelHeight = 1;
    public int mLabelRotatedHeight = 1;
    public int mLabelRotatedWidth = 1;
    protected float mLabelRotationAngle = 0.0f;
    public int mLabelWidth = 1;

    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.mYOffset = Utils.convertDpToPixel(4.0f);
    }

    public XAxisPosition getPosition() {
        return this.f54874b;
    }

    public void setPosition(XAxisPosition xAxisPosition) {
        this.f54874b = xAxisPosition;
    }

    public float getLabelRotationAngle() {
        return this.mLabelRotationAngle;
    }

    public void setLabelRotationAngle(float f) {
        this.mLabelRotationAngle = f;
    }

    public void setAvoidFirstLastClipping(boolean z) {
        this.f54873a = z;
    }

    public boolean isAvoidFirstLastClippingEnabled() {
        return this.f54873a;
    }
}
