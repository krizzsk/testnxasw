package com.didi.map.global.flow.scene.order.serving.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.passenger.C11267R;

public class MapStrokeTextView extends TextView {

    /* renamed from: a */
    private Context f29288a;

    /* renamed from: b */
    private float f29289b = -1.0f;

    /* renamed from: c */
    private ColorStateList f29290c;

    public MapStrokeTextView(Context context) {
        super(context);
        m22724a(context, (AttributeSet) null);
    }

    public MapStrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22724a(context, attributeSet);
    }

    public MapStrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22724a(context, attributeSet);
    }

    /* renamed from: a */
    private void m22724a(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            this.f29288a = context;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.globalMapFlowStrokeTextView);
            this.f29289b = obtainStyledAttributes.getDimension(1, -1.0f);
            this.f29290c = obtainStyledAttributes.getColorStateList(0);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        if (!(paint == null || this.f29290c == null || Float.compare(this.f29289b, -1.0f) <= 0)) {
            int currentTextColor = getCurrentTextColor();
            Paint.Style style = paint.getStyle();
            Paint.Join strokeJoin = paint.getStrokeJoin();
            float strokeWidth = paint.getStrokeWidth();
            float strokeMiter = paint.getStrokeMiter();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeMiter(10.0f);
            paint.setStrokeWidth(this.f29289b);
            setTextColor(this.f29290c);
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
        return this.f29289b;
    }

    public MapStrokeTextView setStrokeWidth(float f) {
        this.f29289b = f;
        return this;
    }

    public ColorStateList getStrokeColor() {
        return this.f29290c;
    }

    public MapStrokeTextView setStrokeColor(int i) {
        this.f29290c = ColorStateList.valueOf(i);
        return this;
    }

    public MapStrokeTextView setStrokeColorResource(int i) {
        Context context = this.f29288a;
        if (context != null) {
            this.f29290c = context.getResources().getColorStateList(i);
        }
        return this;
    }
}
