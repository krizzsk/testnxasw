package com.didi.map.global.component.markers.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.passenger.C11267R;

public class MapStrokeTextView extends AppCompatTextView {

    /* renamed from: a */
    private Context f28281a;

    /* renamed from: b */
    private float f28282b = -1.0f;

    /* renamed from: c */
    private ColorStateList f28283c;

    public MapStrokeTextView(Context context) {
        super(context);
        m22176a(context, (AttributeSet) null);
    }

    public MapStrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22176a(context, attributeSet);
    }

    public MapStrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22176a(context, attributeSet);
    }

    /* renamed from: a */
    private void m22176a(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            this.f28281a = context;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.globalMapFlowStrokeTextView);
            this.f28282b = obtainStyledAttributes.getDimension(1, -1.0f);
            this.f28283c = obtainStyledAttributes.getColorStateList(0);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        if (!(paint == null || this.f28283c == null || Float.compare(this.f28282b, -1.0f) <= 0)) {
            int currentTextColor = getCurrentTextColor();
            Paint.Style style = paint.getStyle();
            Paint.Join strokeJoin = paint.getStrokeJoin();
            float strokeWidth = paint.getStrokeWidth();
            float strokeMiter = paint.getStrokeMiter();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeMiter(10.0f);
            paint.setStrokeWidth(this.f28282b);
            setTextColor(this.f28283c);
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
        return this.f28282b;
    }

    public MapStrokeTextView setStrokeWidth(float f) {
        this.f28282b = f;
        return this;
    }

    public ColorStateList getStrokeColor() {
        return this.f28283c;
    }

    public MapStrokeTextView setStrokeColor(int i) {
        this.f28283c = ColorStateList.valueOf(i);
        return this;
    }

    public MapStrokeTextView setStrokeColorResource(int i) {
        Context context = this.f28281a;
        if (context != null) {
            this.f28283c = context.getResources().getColorStateList(i);
        }
        return this;
    }
}
