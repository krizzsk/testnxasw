package com.didiglobal.font;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class GlobalTypeFaceSpan extends MetricAffectingSpan {

    /* renamed from: a */
    private final Typeface f52746a;

    public GlobalTypeFaceSpan(Typeface typeface) {
        this.f52746a = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        m39609a(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m39609a(textPaint);
    }

    /* renamed from: a */
    private void m39609a(Paint paint) {
        Typeface typeface = paint.getTypeface();
        int style = (typeface != null ? typeface.getStyle() : 0) & (~this.f52746a.getStyle());
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.f52746a);
    }
}
