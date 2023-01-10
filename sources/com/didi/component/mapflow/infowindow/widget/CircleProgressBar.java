package com.didi.component.mapflow.infowindow.widget;

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
    private int f16096a;

    /* renamed from: b */
    private float f16097b;

    /* renamed from: c */
    private CharSequence f16098c;

    /* renamed from: d */
    private int f16099d;

    /* renamed from: e */
    private int f16100e;

    /* renamed from: f */
    private int f16101f;

    /* renamed from: g */
    private int f16102g;

    /* renamed from: h */
    private int f16103h;

    /* renamed from: i */
    private int f16104i;

    /* renamed from: j */
    private int f16105j;

    /* renamed from: k */
    private int f16106k;

    /* renamed from: l */
    private int f16107l;

    /* renamed from: m */
    private Paint f16108m;

    /* renamed from: n */
    private RectF f16109n;

    public CircleProgressBar(Context context) {
        super(context);
        m13321a(context, (AttributeSet) null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13321a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13321a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m13321a(context, attributeSet);
    }

    /* renamed from: a */
    private void m13321a(Context context, AttributeSet attributeSet) {
        m13322b(context, attributeSet);
        this.f16108m = new Paint();
        this.f16109n = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f16108m.setAntiAlias(true);
        this.f16108m.setColor(InputDeviceCompat.SOURCE_ANY);
        this.f16108m.setStrokeWidth((float) this.f16101f);
        this.f16108m.setStyle(Paint.Style.STROKE);
        canvas.drawColor(0);
        float width = (float) getWidth();
        float height = (float) getHeight();
        float max = Math.max((float) this.f16104i, ((float) this.f16101f) / 2.0f);
        RectF rectF = this.f16109n;
        rectF.top = max;
        rectF.left = max;
        this.f16109n.right = width - max;
        this.f16109n.bottom = height - max;
        this.f16108m.setStyle(Paint.Style.FILL);
        this.f16108m.setColor(this.f16106k);
        canvas.drawArc(this.f16109n, 0.0f, 360.0f, false, this.f16108m);
        this.f16108m.setStyle(Paint.Style.STROKE);
        this.f16108m.setColor(this.f16103h);
        float f = (this.f16097b * 360.0f) / ((float) this.f16096a);
        canvas.drawArc(this.f16109n, (float) this.f16107l, f, false, this.f16108m);
        this.f16108m.setColor(this.f16102g);
        float f2 = ((float) this.f16107l) + f;
        canvas.drawArc(this.f16109n, f2, 360.0f - f, false, this.f16108m);
        this.f16108m.setColor(this.f16105j);
        this.f16108m.setStrokeWidth(0.0f);
        this.f16108m.setStyle(Paint.Style.FILL);
        double d = (double) f2;
        float f3 = width / 2.0f;
        float f4 = height / 2.0f;
        canvas.drawCircle((((float) Math.cos(Math.toRadians(d))) * (f3 - max)) + f3, (((float) Math.sin(Math.toRadians(d))) * (f4 - max)) + f4, (float) this.f16104i, this.f16108m);
        if (!TextUtils.isEmpty(this.f16098c)) {
            this.f16108m.setTextSize((float) this.f16099d);
            this.f16108m.setColor(this.f16100e);
            this.f16108m.setStyle(Paint.Style.FILL);
            CharSequence charSequence = this.f16098c;
            canvas.drawText((String) charSequence, (width - this.f16108m.measureText(charSequence, 0, charSequence.length())) / 2.0f, (f4 + ((float) (this.f16099d / 2))) - 2.0f, this.f16108m);
        }
    }

    public int getMax() {
        return this.f16096a;
    }

    public CircleProgressBar setMax(int i) {
        if (i > 0) {
            this.f16096a = i;
            return this;
        }
        throw new RuntimeException("Max must bigger than 0");
    }

    public float getProgress() {
        return this.f16097b;
    }

    public CircleProgressBar setProgress(float f) {
        this.f16097b = f;
        return this;
    }

    public CharSequence getText() {
        return this.f16098c;
    }

    public CircleProgressBar setText(CharSequence charSequence) {
        this.f16098c = charSequence;
        return this;
    }

    public int getTextSize() {
        return this.f16099d;
    }

    public CircleProgressBar setTextSize(int i) {
        this.f16099d = i;
        return this;
    }

    public int getTextColor() {
        return this.f16100e;
    }

    public CircleProgressBar setTextColor(int i) {
        this.f16100e = i;
        return this;
    }

    public CircleProgressBar setFillColor(int i) {
        this.f16106k = i;
        return this;
    }

    public int getFillColor() {
        return this.f16106k;
    }

    public int getStrokeWidth() {
        return this.f16101f;
    }

    public CircleProgressBar setStrokeWidth(int i) {
        this.f16101f = i;
        return this;
    }

    public int getStrokeColor() {
        return this.f16102g;
    }

    public CircleProgressBar setStrokeColor(int i) {
        this.f16102g = i;
        return this;
    }

    public int getGoneColor() {
        return this.f16103h;
    }

    public CircleProgressBar setGoneColor(int i) {
        this.f16103h = i;
        return this;
    }

    public int getDotRadius() {
        return this.f16104i;
    }

    public CircleProgressBar setDotRadius(int i) {
        this.f16104i = i;
        return this;
    }

    public int getDotColor() {
        return this.f16105j;
    }

    public CircleProgressBar setDotColor(int i) {
        this.f16105j = i;
        return this;
    }

    public int getStartAngle() {
        return this.f16107l;
    }

    public CircleProgressBar setStartAngle(int i) {
        this.f16107l = i;
        return this;
    }

    /* renamed from: b */
    private void m13322b(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f16096a = 100;
            this.f16097b = 80.0f;
            this.f16099d = 20;
            this.f16100e = -65536;
            this.f16101f = 20;
            this.f16102g = -16777216;
            this.f16103h = 0;
            this.f16104i = 30;
            this.f16105j = -16776961;
            this.f16106k = -1;
            this.f16107l = 0;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.circle_progress_bar_attr);
        int integer = obtainStyledAttributes.getInteger(4, 100);
        this.f16096a = integer;
        if (integer > 0) {
            this.f16097b = obtainStyledAttributes.getFloat(5, 80.0f);
            this.f16098c = obtainStyledAttributes.getString(9);
            this.f16099d = obtainStyledAttributes.getDimensionPixelSize(11, 20);
            this.f16100e = obtainStyledAttributes.getColor(10, -65536);
            this.f16101f = obtainStyledAttributes.getDimensionPixelSize(8, 20);
            this.f16102g = obtainStyledAttributes.getColor(7, -16777216);
            this.f16103h = obtainStyledAttributes.getColor(3, 0);
            this.f16104i = obtainStyledAttributes.getDimensionPixelSize(1, 30);
            this.f16105j = obtainStyledAttributes.getColor(0, -16776961);
            this.f16106k = obtainStyledAttributes.getColor(2, -1);
            this.f16107l = obtainStyledAttributes.getInteger(6, 0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new RuntimeException("Max must bigger than 0");
    }
}
