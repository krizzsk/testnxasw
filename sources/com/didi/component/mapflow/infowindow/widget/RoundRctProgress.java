package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C11267R;
import com.didiglobal.font.DIDIFontUtils;

public class RoundRctProgress extends View {
    public static final int PI_RADIUS = 180;

    /* renamed from: a */
    private float f16153a;

    /* renamed from: b */
    private int f16154b;

    /* renamed from: c */
    private int f16155c;

    /* renamed from: d */
    private int f16156d;

    /* renamed from: e */
    private int f16157e;

    /* renamed from: f */
    private int f16158f;

    /* renamed from: g */
    private int f16159g;

    /* renamed from: h */
    private int f16160h;

    /* renamed from: i */
    private PointF f16161i;

    /* renamed from: j */
    private PointF f16162j;

    /* renamed from: k */
    private float f16163k;

    /* renamed from: l */
    private RectF f16164l;

    /* renamed from: m */
    private RectF f16165m;

    /* renamed from: n */
    private Path f16166n = new Path();

    /* renamed from: o */
    private Path f16167o = new Path();

    /* renamed from: p */
    private RectF f16168p;

    /* renamed from: q */
    private RectF f16169q;

    /* renamed from: r */
    private Paint f16170r = new Paint();

    /* renamed from: s */
    private Paint f16171s = new Paint();

    /* renamed from: t */
    private Paint f16172t = new Paint();

    /* renamed from: u */
    private CharSequence f16173u;

    /* renamed from: v */
    private int f16174v;

    /* renamed from: w */
    private int f16175w;

    public void setProgress(int i) {
        this.f16153a = (float) i;
    }

    public RoundRctProgress(Context context) {
        super(context);
    }

    public RoundRctProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13346a(context, attributeSet);
    }

    public RoundRctProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13346a(context, attributeSet);
    }

    /* renamed from: a */
    private void m13346a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RoundRctProgress);
        this.f16153a = (float) obtainStyledAttributes.getInt(2, 0);
        this.f16154b = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f16155c = obtainStyledAttributes.getDimensionPixelOffset(0, 1);
        this.f16156d = obtainStyledAttributes.getInt(7, 315);
        this.f16157e = obtainStyledAttributes.getColor(3, Color.argb(90, 90, 90, 90));
        this.f16158f = obtainStyledAttributes.getColor(4, Color.argb(90, 90, 90, 90));
        this.f16174v = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f16175w = obtainStyledAttributes.getColor(5, Color.argb(90, 90, 90, 90));
        obtainStyledAttributes.recycle();
        this.f16170r.setStyle(Paint.Style.STROKE);
        this.f16170r.setStrokeWidth((float) this.f16155c);
        this.f16170r.setAntiAlias(true);
        this.f16170r.setColor(this.f16157e);
        this.f16171s.setStyle(Paint.Style.STROKE);
        this.f16171s.setStrokeWidth((float) this.f16155c);
        this.f16171s.setAntiAlias(true);
        this.f16171s.setColor(this.f16158f);
        this.f16172t.setTextSize((float) this.f16174v);
        this.f16172t.setTypeface(Typeface.DEFAULT_BOLD);
        DIDIFontUtils.Companion.setPaintTypeface(getContext(), this.f16172t);
        this.f16172t.setColor(this.f16175w);
        this.f16172t.setStyle(Paint.Style.FILL);
        this.f16172t.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f16159g = i;
        this.f16160h = i2;
        float paddingStart = ((float) ((i - getPaddingStart()) - getPaddingEnd())) / 2.0f;
        float paddingTop = ((float) ((this.f16160h - getPaddingTop()) - getPaddingBottom())) / 2.0f;
        this.f16163k = (float) Math.sqrt((double) ((paddingStart * paddingStart) + (paddingTop * paddingTop)));
        this.f16161i = new PointF(((float) getPaddingStart()) + paddingStart, ((float) getPaddingTop()) + paddingTop);
        this.f16162j = new PointF((float) (((double) this.f16161i.x) + (((double) this.f16163k) * Math.cos((((double) this.f16156d) * 3.141592653589793d) / 180.0d))), (float) (((double) this.f16161i.y) + (((double) this.f16163k) * Math.sin((((double) this.f16156d) * 3.141592653589793d) / 180.0d))));
        this.f16164l = new RectF((float) getPaddingStart(), (float) getPaddingTop(), (float) (this.f16159g - getPaddingEnd()), (float) (this.f16160h - getPaddingBottom()));
        this.f16165m = new RectF((float) getPaddingStart(), (float) getPaddingTop(), (float) (this.f16159g - getPaddingEnd()), (float) (this.f16160h - getPaddingBottom()));
        this.f16168p = new RectF(this.f16161i.x - this.f16163k, this.f16161i.y - this.f16163k, this.f16161i.x + this.f16163k, this.f16161i.y + this.f16163k);
        this.f16169q = new RectF(this.f16161i.x - this.f16163k, this.f16161i.y - this.f16163k, this.f16161i.x + this.f16163k, this.f16161i.y + this.f16163k);
        this.f16166n.reset();
        this.f16167o.reset();
        Path path = this.f16166n;
        RectF rectF = this.f16164l;
        int i5 = this.f16154b;
        path.addRoundRect(rectF, (float) i5, (float) i5, Path.Direction.CW);
        Path path2 = this.f16167o;
        RectF rectF2 = this.f16165m;
        int i6 = this.f16154b;
        path2.addRoundRect(rectF2, (float) i6, (float) i6, Path.Direction.CW);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (!TextUtils.isEmpty(this.f16173u)) {
            CharSequence charSequence = this.f16173u;
            canvas.drawText((String) charSequence, (((float) this.f16159g) - this.f16172t.measureText(charSequence, 0, charSequence.length())) / 2.0f, (float) (((this.f16160h / 2) + (this.f16174v / 2)) - 2), this.f16172t);
        }
        this.f16166n.reset();
        this.f16167o.reset();
        Path path = this.f16166n;
        RectF rectF = this.f16164l;
        int i = this.f16154b;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CW);
        Path path2 = this.f16167o;
        RectF rectF2 = this.f16165m;
        int i2 = this.f16154b;
        path2.addRoundRect(rectF2, (float) i2, (float) i2, Path.Direction.CW);
        canvas.clipPath(this.f16167o);
        canvas.clipPath(m13345a((float) this.f16156d, this.f16167o, this.f16169q), Region.Op.DIFFERENCE);
        RectF rectF3 = this.f16165m;
        int i3 = this.f16154b;
        canvas.drawRoundRect(rectF3, (float) i3, (float) i3, this.f16171s);
        canvas.clipPath(this.f16166n);
        canvas.clipPath(m13345a(((this.f16153a * 360.0f) / 100.0f) + ((float) this.f16156d), this.f16166n, this.f16168p), Region.Op.DIFFERENCE);
        RectF rectF4 = this.f16164l;
        int i4 = this.f16154b;
        canvas.drawRoundRect(rectF4, (float) i4, (float) i4, this.f16170r);
        canvas.restore();
    }

    /* renamed from: a */
    private Path m13345a(float f, Path path, RectF rectF) {
        path.reset();
        path.moveTo(this.f16161i.x, this.f16161i.y);
        path.lineTo(this.f16162j.x, this.f16162j.y);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        path.lineTo((float) (((double) this.f16161i.x) + (((double) this.f16163k) * Math.cos(d))), (float) (((double) this.f16161i.y) + (((double) this.f16163k) * Math.sin(d))));
        path.close();
        int i = this.f16156d;
        path.addArc(rectF, (float) i, f - ((float) i));
        return path;
    }

    public RoundRctProgress setProgress(float f) {
        this.f16153a = f;
        return this;
    }

    public RoundRctProgress setText(CharSequence charSequence) {
        this.f16173u = charSequence;
        return this;
    }

    public void update() {
        invalidate();
    }
}
