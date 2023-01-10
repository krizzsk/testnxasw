package com.didi.map.sdk.sharetrack.external.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.didi.common.map.util.SystemUtil;
import com.didi.passenger.C11267R;

public class BLTextView extends View {

    /* renamed from: a */
    private Paint f31146a;

    /* renamed from: b */
    private Paint f31147b;

    /* renamed from: c */
    private Paint.FontMetrics f31148c;

    /* renamed from: d */
    private Paint.FontMetrics f31149d;

    /* renamed from: e */
    private String f31150e;

    /* renamed from: f */
    private int f31151f;

    /* renamed from: g */
    private int f31152g;

    /* renamed from: h */
    private int f31153h;

    /* renamed from: i */
    private int f31154i;

    /* renamed from: j */
    private int f31155j;

    /* renamed from: k */
    private float f31156k;

    public BLTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BLTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BLTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31151f = GravityCompat.START;
        this.f31154i = -13421773;
        this.f31155j = -869059789;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.BLTextView);
        if (obtainStyledAttributes != null) {
            if (obtainStyledAttributes.getInt(5, 1) == 2) {
                this.f31151f = GravityCompat.END;
            } else {
                this.f31151f = GravityCompat.START;
            }
            this.f31150e = obtainStyledAttributes.getString(4);
            this.f31152g = obtainStyledAttributes.getDimensionPixelSize(1, SystemUtil.dip2px(context, 22.0f));
            this.f31153h = obtainStyledAttributes.getDimensionPixelSize(3, SystemUtil.dip2px(context, 16.0f));
            this.f31154i = obtainStyledAttributes.getColor(0, -13421773);
            this.f31155j = obtainStyledAttributes.getColor(2, -869059789);
            obtainStyledAttributes.recycle();
        }
        m23834a();
    }

    /* renamed from: a */
    private void m23834a() {
        Paint paint = new Paint();
        this.f31146a = paint;
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        this.f31146a.setColor(this.f31154i);
        this.f31146a.setStyle(Paint.Style.FILL);
        this.f31146a.setFlags(1);
        this.f31146a.setTextSize((float) this.f31152g);
        Paint paint2 = new Paint();
        this.f31147b = paint2;
        paint2.setTypeface(Typeface.DEFAULT);
        this.f31147b.setColor(this.f31155j);
        this.f31147b.setStyle(Paint.Style.FILL);
        this.f31147b.setFlags(1);
        this.f31147b.setTextSize((float) this.f31153h);
        if (this.f31151f == 8388611) {
            this.f31146a.setTextAlign(Paint.Align.LEFT);
            this.f31147b.setTextAlign(Paint.Align.LEFT);
        } else {
            this.f31146a.setTextAlign(Paint.Align.RIGHT);
            this.f31147b.setTextAlign(Paint.Align.RIGHT);
        }
        this.f31148c = this.f31146a.getFontMetrics();
        this.f31149d = this.f31147b.getFontMetrics();
    }

    public void setGravity(int i) {
        int i2 = i == 2 ? GravityCompat.END : GravityCompat.START;
        this.f31151f = i2;
        if (i2 == 8388611) {
            this.f31146a.setTextAlign(Paint.Align.LEFT);
            this.f31147b.setTextAlign(Paint.Align.LEFT);
        } else {
            this.f31146a.setTextAlign(Paint.Align.RIGHT);
            this.f31147b.setTextAlign(Paint.Align.RIGHT);
        }
        m23836b();
    }

    public void setTextSize(int i, int i2) {
        this.f31152g = i;
        this.f31153h = i2;
        this.f31146a.setTextSize((float) i);
        this.f31147b.setTextSize((float) this.f31153h);
        m23836b();
    }

    public void setTextColor(int i, int i2) {
        this.f31152g = i;
        this.f31155j = i2;
        this.f31146a.setColor(i);
        this.f31147b.setColor(i2);
        m23836b();
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        if (!str.equals(this.f31150e)) {
            this.f31150e = str;
            requestLayout();
        }
    }

    public String getText() {
        return this.f31150e;
    }

    /* renamed from: b */
    private void m23836b() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            Paint.FontMetricsInt fontMetricsInt = this.f31146a.getFontMetricsInt();
            setMeasuredDimension(m23837c(), (fontMetricsInt.bottom - fontMetricsInt.top) + getPaddingTop() + getPaddingBottom());
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(m23837c(), size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            Paint.FontMetricsInt fontMetricsInt2 = this.f31146a.getFontMetricsInt();
            setMeasuredDimension(size, (fontMetricsInt2.bottom - fontMetricsInt2.top) + getPaddingTop() + getPaddingBottom());
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    /* renamed from: c */
    private int m23837c() {
        float f;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        float f2 = 0.0f;
        if (!TextUtils.isEmpty(this.f31150e)) {
            float measureText = this.f31147b.measureText(" ");
            for (int i = 0; i < this.f31150e.length(); i++) {
                char charAt = this.f31150e.charAt(i);
                String valueOf = String.valueOf(charAt);
                if ((charAt >= '0' && charAt <= '9') || charAt == ',' || charAt == '.') {
                    f = this.f31146a.measureText(valueOf);
                } else {
                    f = this.f31147b.measureText(valueOf);
                }
                f2 += f;
            }
            f2 += measureText * 2.0f;
        }
        return (int) (((float) paddingLeft) + f2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(this.f31150e)) {
            if (this.f31148c == null) {
                this.f31148c = this.f31146a.getFontMetrics();
            }
            if (this.f31149d == null) {
                this.f31149d = this.f31147b.getFontMetrics();
            }
            float height = ((float) (getHeight() >> 1)) + ((Math.abs(this.f31148c.ascent) - this.f31148c.descent) / 2.0f);
            float f = (this.f31149d.bottom + height) - this.f31149d.descent;
            int i = this.f31151f;
            if (i == 8388611) {
                this.f31156k = (float) getPaddingLeft();
                m23835a(canvas, this.f31147b, " ", f);
                for (int i2 = 0; i2 < this.f31150e.length(); i2++) {
                    char charAt = this.f31150e.charAt(i2);
                    String valueOf = String.valueOf(charAt);
                    if ((charAt >= '0' && charAt <= '9') || charAt == ',' || charAt == '.') {
                        m23835a(canvas, this.f31146a, valueOf, height);
                    } else {
                        m23835a(canvas, this.f31147b, valueOf, f);
                    }
                }
                m23835a(canvas, this.f31147b, " ", f);
            } else if (i == 8388613) {
                this.f31156k = (float) (getWidth() - getPaddingRight());
                m23835a(canvas, this.f31147b, " ", f);
                for (int length = this.f31150e.length() - 1; length >= 0; length--) {
                    char charAt2 = this.f31150e.charAt(length);
                    String valueOf2 = String.valueOf(charAt2);
                    if ((charAt2 >= '0' && charAt2 <= '9') || charAt2 == ',' || charAt2 == '.') {
                        m23835a(canvas, this.f31146a, valueOf2, height);
                    } else {
                        m23835a(canvas, this.f31147b, valueOf2, f);
                    }
                }
                m23835a(canvas, this.f31147b, " ", f);
            }
        }
    }

    /* renamed from: a */
    private void m23835a(Canvas canvas, Paint paint, String str, float f) {
        canvas.drawText(str, this.f31156k, f, paint);
        float measureText = paint.measureText(str);
        if (this.f31151f == 8388611) {
            this.f31156k += measureText;
        } else {
            this.f31156k -= measureText;
        }
    }
}
