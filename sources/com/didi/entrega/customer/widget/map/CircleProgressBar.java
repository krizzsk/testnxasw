package com.didi.entrega.customer.widget.map;

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
    private int f22435a;

    /* renamed from: b */
    private float f22436b;

    /* renamed from: c */
    private CharSequence f22437c;

    /* renamed from: d */
    private int f22438d;

    /* renamed from: e */
    private int f22439e;

    /* renamed from: f */
    private int f22440f;

    /* renamed from: g */
    private int f22441g;

    /* renamed from: h */
    private int f22442h;

    /* renamed from: i */
    private int f22443i;

    /* renamed from: j */
    private int f22444j;

    /* renamed from: k */
    private int f22445k;

    /* renamed from: l */
    private int f22446l;

    /* renamed from: m */
    private Paint f22447m;

    /* renamed from: n */
    private RectF f22448n;

    public CircleProgressBar(Context context) {
        super(context);
        m18477a(context, (AttributeSet) null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18477a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18477a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m18477a(context, attributeSet);
    }

    public int getDotColor() {
        return this.f22444j;
    }

    public CircleProgressBar setDotColor(int i) {
        this.f22444j = i;
        return this;
    }

    public int getDotRadius() {
        return this.f22443i;
    }

    public CircleProgressBar setDotRadius(int i) {
        this.f22443i = i;
        return this;
    }

    public int getFillColor() {
        return this.f22445k;
    }

    public CircleProgressBar setFillColor(int i) {
        this.f22445k = i;
        return this;
    }

    public int getGoneColor() {
        return this.f22442h;
    }

    public CircleProgressBar setGoneColor(int i) {
        this.f22442h = i;
        return this;
    }

    public int getMax() {
        return this.f22435a;
    }

    public CircleProgressBar setMax(int i) {
        if (i > 0) {
            this.f22435a = i;
            return this;
        }
        throw new RuntimeException("Max must bigger than 0");
    }

    public float getProgress() {
        return this.f22436b;
    }

    public CircleProgressBar setProgress(float f) {
        this.f22436b = f;
        return this;
    }

    public int getStartAngle() {
        return this.f22446l;
    }

    public CircleProgressBar setStartAngle(int i) {
        this.f22446l = i;
        return this;
    }

    public int getStrokeColor() {
        return this.f22441g;
    }

    public CircleProgressBar setStrokeColor(int i) {
        this.f22441g = i;
        return this;
    }

    public int getStrokeWidth() {
        return this.f22440f;
    }

    public CircleProgressBar setStrokeWidth(int i) {
        this.f22440f = i;
        return this;
    }

    public CharSequence getText() {
        return this.f22437c;
    }

    public CircleProgressBar setText(CharSequence charSequence) {
        this.f22437c = charSequence;
        return this;
    }

    public int getTextColor() {
        return this.f22439e;
    }

    public CircleProgressBar setTextColor(int i) {
        this.f22439e = i;
        return this;
    }

    public int getTextSize() {
        return this.f22438d;
    }

    public CircleProgressBar setTextSize(int i) {
        this.f22438d = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f22447m.setAntiAlias(true);
        this.f22447m.setColor(InputDeviceCompat.SOURCE_ANY);
        this.f22447m.setStrokeWidth((float) this.f22440f);
        this.f22447m.setStyle(Paint.Style.STROKE);
        canvas.drawColor(0);
        float width = (float) getWidth();
        float height = (float) getHeight();
        float max = Math.max((float) this.f22443i, ((float) this.f22440f) / 2.0f);
        RectF rectF = this.f22448n;
        rectF.top = max;
        rectF.left = max;
        this.f22448n.right = width - max;
        this.f22448n.bottom = height - max;
        this.f22447m.setStyle(Paint.Style.FILL);
        this.f22447m.setColor(this.f22445k);
        canvas.drawArc(this.f22448n, 0.0f, 360.0f, false, this.f22447m);
        this.f22447m.setStyle(Paint.Style.STROKE);
        this.f22447m.setColor(this.f22442h);
        float f = (this.f22436b * 360.0f) / ((float) this.f22435a);
        canvas.drawArc(this.f22448n, (float) this.f22446l, f, false, this.f22447m);
        this.f22447m.setColor(this.f22441g);
        float f2 = ((float) this.f22446l) + f;
        canvas.drawArc(this.f22448n, f2, 360.0f - f, false, this.f22447m);
        this.f22447m.setColor(this.f22444j);
        this.f22447m.setStrokeWidth(0.0f);
        this.f22447m.setStyle(Paint.Style.FILL);
        double d = (double) f2;
        float f3 = width / 2.0f;
        float f4 = height / 2.0f;
        canvas.drawCircle((((float) Math.cos(Math.toRadians(d))) * (f3 - max)) + f3, (((float) Math.sin(Math.toRadians(d))) * (f4 - max)) + f4, (float) this.f22443i, this.f22447m);
        if (!TextUtils.isEmpty(this.f22437c)) {
            this.f22447m.setTextSize((float) this.f22438d);
            this.f22447m.setColor(this.f22439e);
            this.f22447m.setStyle(Paint.Style.FILL);
            CharSequence charSequence = this.f22437c;
            canvas.drawText((String) charSequence, (width - this.f22447m.measureText(charSequence, 0, charSequence.length())) / 2.0f, (f4 + ((float) (this.f22438d / 2))) - 2.0f, this.f22447m);
        }
    }

    /* renamed from: a */
    private void m18477a(Context context, AttributeSet attributeSet) {
        m18478b(context, attributeSet);
        this.f22447m = new Paint();
        this.f22448n = new RectF();
    }

    /* renamed from: b */
    private void m18478b(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f22435a = 100;
            this.f22436b = 80.0f;
            this.f22438d = 20;
            this.f22439e = -65536;
            this.f22440f = 20;
            this.f22441g = -16777216;
            this.f22442h = 0;
            this.f22443i = 30;
            this.f22444j = -16776961;
            this.f22445k = -1;
            this.f22446l = 0;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaCircleProgressBarAttr);
        int integer = obtainStyledAttributes.getInteger(4, 100);
        this.f22435a = integer;
        if (integer > 0) {
            this.f22436b = obtainStyledAttributes.getFloat(5, 80.0f);
            this.f22437c = obtainStyledAttributes.getString(9);
            this.f22438d = obtainStyledAttributes.getDimensionPixelSize(11, 20);
            this.f22439e = obtainStyledAttributes.getColor(10, -65536);
            this.f22440f = obtainStyledAttributes.getDimensionPixelSize(8, 20);
            this.f22441g = obtainStyledAttributes.getColor(7, -16777216);
            this.f22442h = obtainStyledAttributes.getColor(3, 0);
            this.f22443i = obtainStyledAttributes.getDimensionPixelSize(1, 30);
            this.f22444j = obtainStyledAttributes.getColor(0, -16776961);
            this.f22445k = obtainStyledAttributes.getColor(2, -1);
            this.f22446l = obtainStyledAttributes.getInteger(6, 0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new RuntimeException("Max must bigger than 0");
    }
}
