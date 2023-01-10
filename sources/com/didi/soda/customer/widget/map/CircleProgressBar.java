package com.didi.soda.customer.widget.map;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.didi.passenger.C11267R;

public class CircleProgressBar extends View {
    public static final float DEFAULT_CURRENT_PROGRESS = 80.0f;
    public static final int DEFAULT_DOT_COLOR = -16776961;
    public static final int DEFAULT_DOT_RADIUS = 30;
    public static final int DEFAULT_FILL_COLOR = -1;
    public static final int DEFAULT_GONE_COLOR = 0;
    public static final int DEFAULT_MAX_PROGRESS = 100;
    public static final int DEFAULT_START_ANGLE = 0;
    public static final int DEFAULT_STROKE_COLOR = -16777216;
    public static final int DEFAULT_STROKE_WIDTH = 20;
    public static final int DEFAULT_TEXT_COLOR = -65536;
    public static final int DEFAULT_TEXT_SIZE = 20;

    /* renamed from: a */
    private int f44679a;

    /* renamed from: b */
    private float f44680b;

    /* renamed from: c */
    private CharSequence f44681c;

    /* renamed from: d */
    private int f44682d;

    /* renamed from: e */
    private int f44683e;

    /* renamed from: f */
    private int f44684f;

    /* renamed from: g */
    private int f44685g;

    /* renamed from: h */
    private int f44686h;

    /* renamed from: i */
    private int f44687i;

    /* renamed from: j */
    private int f44688j;

    /* renamed from: k */
    private int f44689k;

    /* renamed from: l */
    private int f44690l;

    /* renamed from: m */
    private Paint f44691m;

    /* renamed from: n */
    private RectF f44692n;

    public CircleProgressBar(Context context) {
        super(context);
        m33166a(context, (AttributeSet) null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33166a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33166a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m33166a(context, attributeSet);
    }

    public int getDotColor() {
        return this.f44688j;
    }

    public CircleProgressBar setDotColor(int i) {
        this.f44688j = i;
        return this;
    }

    public int getDotRadius() {
        return this.f44687i;
    }

    public CircleProgressBar setDotRadius(int i) {
        this.f44687i = i;
        return this;
    }

    public int getFillColor() {
        return this.f44689k;
    }

    public CircleProgressBar setFillColor(int i) {
        this.f44689k = i;
        return this;
    }

    public int getGoneColor() {
        return this.f44686h;
    }

    public CircleProgressBar setGoneColor(int i) {
        this.f44686h = i;
        return this;
    }

    public int getMax() {
        return this.f44679a;
    }

    public CircleProgressBar setMax(int i) {
        if (i > 0) {
            this.f44679a = i;
            return this;
        }
        throw new RuntimeException("Max must bigger than 0");
    }

    public float getProgress() {
        return this.f44680b;
    }

    public CircleProgressBar setProgress(float f) {
        this.f44680b = f;
        return this;
    }

    public int getStartAngle() {
        return this.f44690l;
    }

    public CircleProgressBar setStartAngle(int i) {
        this.f44690l = i;
        return this;
    }

    public int getStrokeColor() {
        return this.f44685g;
    }

    public CircleProgressBar setStrokeColor(int i) {
        this.f44685g = i;
        return this;
    }

    public int getStrokeWidth() {
        return this.f44684f;
    }

    public CircleProgressBar setStrokeWidth(int i) {
        this.f44684f = i;
        return this;
    }

    public CharSequence getText() {
        return this.f44681c;
    }

    public CircleProgressBar setText(CharSequence charSequence) {
        this.f44681c = charSequence;
        return this;
    }

    public int getTextColor() {
        return this.f44683e;
    }

    public CircleProgressBar setTextColor(int i) {
        this.f44683e = i;
        return this;
    }

    public int getTextSize() {
        return this.f44682d;
    }

    public CircleProgressBar setTextSize(int i) {
        this.f44682d = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f44691m.setAntiAlias(true);
        this.f44691m.setColor(InputDeviceCompat.SOURCE_ANY);
        this.f44691m.setStrokeWidth((float) this.f44684f);
        this.f44691m.setStyle(Paint.Style.STROKE);
        canvas.drawColor(0);
        float width = (float) getWidth();
        float height = (float) getHeight();
        float max = Math.max((float) this.f44687i, ((float) this.f44684f) / 2.0f);
        RectF rectF = this.f44692n;
        rectF.top = max;
        rectF.left = max;
        this.f44692n.right = width - max;
        this.f44692n.bottom = height - max;
        this.f44691m.setStyle(Paint.Style.FILL);
        this.f44691m.setColor(this.f44689k);
        canvas.drawArc(this.f44692n, 0.0f, 360.0f, false, this.f44691m);
        this.f44691m.setStyle(Paint.Style.STROKE);
        this.f44691m.setColor(this.f44686h);
        float f = (this.f44680b * 360.0f) / ((float) this.f44679a);
        canvas.drawArc(this.f44692n, (float) this.f44690l, f, false, this.f44691m);
        this.f44691m.setColor(this.f44685g);
        float f2 = ((float) this.f44690l) + f;
        canvas.drawArc(this.f44692n, f2, 360.0f - f, false, this.f44691m);
        this.f44691m.setColor(this.f44688j);
        this.f44691m.setStrokeWidth(0.0f);
        this.f44691m.setStyle(Paint.Style.FILL);
        double d = (double) f2;
        float f3 = width / 2.0f;
        float f4 = height / 2.0f;
        canvas.drawCircle((((float) Math.cos(Math.toRadians(d))) * (f3 - max)) + f3, (((float) Math.sin(Math.toRadians(d))) * (f4 - max)) + f4, (float) this.f44687i, this.f44691m);
        if (!TextUtils.isEmpty(this.f44681c)) {
            this.f44691m.setTextSize((float) this.f44682d);
            this.f44691m.setColor(this.f44683e);
            this.f44691m.setStyle(Paint.Style.FILL);
            CharSequence charSequence = this.f44681c;
            canvas.drawText((String) charSequence, (width - this.f44691m.measureText(charSequence, 0, charSequence.length())) / 2.0f, (f4 + ((float) (this.f44682d / 2))) - 2.0f, this.f44691m);
        }
    }

    /* renamed from: a */
    private void m33166a(Context context, AttributeSet attributeSet) {
        m33167b(context, attributeSet);
        this.f44691m = new Paint();
        this.f44692n = new RectF();
    }

    /* renamed from: b */
    private void m33167b(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f44679a = 100;
            this.f44680b = 80.0f;
            this.f44682d = 20;
            this.f44683e = -65536;
            this.f44684f = 20;
            this.f44685g = -16777216;
            this.f44686h = 0;
            this.f44687i = 30;
            this.f44688j = -16776961;
            this.f44689k = -1;
            this.f44690l = 0;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CircleProgressBarAttr);
        int integer = obtainStyledAttributes.getInteger(4, 100);
        this.f44679a = integer;
        if (integer > 0) {
            this.f44680b = obtainStyledAttributes.getFloat(5, 80.0f);
            this.f44681c = obtainStyledAttributes.getString(9);
            this.f44682d = obtainStyledAttributes.getDimensionPixelSize(11, 20);
            this.f44683e = obtainStyledAttributes.getColor(10, -65536);
            this.f44684f = obtainStyledAttributes.getDimensionPixelSize(8, 20);
            this.f44685g = obtainStyledAttributes.getColor(7, -16777216);
            this.f44686h = obtainStyledAttributes.getColor(3, 0);
            this.f44687i = obtainStyledAttributes.getDimensionPixelSize(1, 30);
            this.f44688j = obtainStyledAttributes.getColor(0, -16776961);
            this.f44689k = obtainStyledAttributes.getColor(2, -1);
            this.f44690l = obtainStyledAttributes.getInteger(6, 0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new RuntimeException("Max must bigger than 0");
    }
}
