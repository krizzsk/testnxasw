package com.didi.sdk.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.passenger.C11267R;

public class StrokeTextView extends TextView {

    /* renamed from: a */
    private Context f40611a;

    /* renamed from: b */
    private float f40612b = -1.0f;

    /* renamed from: c */
    private ColorStateList f40613c;

    public StrokeTextView(Context context) {
        super(context);
        m30488a(context, (AttributeSet) null);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30488a(context, attributeSet);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30488a(context, attributeSet);
    }

    /* renamed from: a */
    private void m30488a(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            this.f40611a = context;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.stroke_text_view);
            this.f40612b = obtainStyledAttributes.getDimension(1, -1.0f);
            this.f40613c = obtainStyledAttributes.getColorStateList(0);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        if (!(paint == null || this.f40613c == null || Float.compare(this.f40612b, -1.0f) <= 0)) {
            int currentTextColor = getCurrentTextColor();
            Paint.Style style = paint.getStyle();
            Paint.Join strokeJoin = paint.getStrokeJoin();
            float strokeWidth = paint.getStrokeWidth();
            float strokeMiter = paint.getStrokeMiter();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeMiter(10.0f);
            paint.setStrokeWidth(this.f40612b);
            setTextColor(this.f40613c);
            super.onDraw(canvas);
            paint.setStyle(style);
            paint.setStrokeJoin(strokeJoin);
            paint.setStrokeMiter(strokeMiter);
            paint.setStrokeWidth(strokeWidth);
            setTextColor(currentTextColor);
        }
        super.onDraw(canvas);
    }

    public float getStrokeWidth() {
        return this.f40612b;
    }

    public StrokeTextView setStrokeWidth(float f) {
        this.f40612b = f;
        return this;
    }

    public ColorStateList getStrokeColor() {
        return this.f40613c;
    }

    public StrokeTextView setStrokeColor(int i) {
        this.f40613c = ColorStateList.valueOf(i);
        return this;
    }

    public StrokeTextView setStrokeColorResource(int i) {
        Context context = this.f40611a;
        if (context != null) {
            this.f40613c = context.getResources().getColorStateList(i);
        }
        return this;
    }
}
