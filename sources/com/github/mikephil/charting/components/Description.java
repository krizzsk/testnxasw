package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

public class Description extends ComponentBase {

    /* renamed from: a */
    private String f54831a = "Description Label";

    /* renamed from: b */
    private MPPointF f54832b;

    /* renamed from: c */
    private Paint.Align f54833c = Paint.Align.RIGHT;

    public Description() {
        this.mTextSize = Utils.convertDpToPixel(8.0f);
    }

    public void setText(String str) {
        this.f54831a = str;
    }

    public String getText() {
        return this.f54831a;
    }

    public void setPosition(float f, float f2) {
        MPPointF mPPointF = this.f54832b;
        if (mPPointF == null) {
            this.f54832b = MPPointF.getInstance(f, f2);
            return;
        }
        mPPointF.f55042x = f;
        this.f54832b.f55043y = f2;
    }

    public MPPointF getPosition() {
        return this.f54832b;
    }

    public void setTextAlign(Paint.Align align) {
        this.f54833c = align;
    }

    public Paint.Align getTextAlign() {
        return this.f54833c;
    }
}
