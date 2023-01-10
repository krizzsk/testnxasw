package com.didichuxing.dfbasesdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C11267R;

public class DfMaskView extends View {

    /* renamed from: a */
    private Paint f49563a;

    /* renamed from: b */
    private int f49564b = -1;

    /* renamed from: c */
    private Context f49565c;

    /* renamed from: d */
    private Path f49566d;

    /* renamed from: e */
    private Path f49567e;

    /* renamed from: f */
    private int f49568f;

    /* renamed from: g */
    private int f49569g;

    /* renamed from: h */
    private float f49570h = 0.75f;

    /* renamed from: i */
    private int f49571i;

    /* renamed from: j */
    private int f49572j;

    /* renamed from: k */
    private int f49573k;

    /* renamed from: l */
    private int f49574l;

    /* renamed from: m */
    private int f49575m;

    /* renamed from: n */
    private int f49576n;

    /* renamed from: o */
    private int f49577o;

    /* renamed from: p */
    private int f49578p;

    /* renamed from: q */
    private Rect f49579q = new Rect();

    public DfMaskView(Context context) {
        super(context);
        m37125a(context);
    }

    public DfMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m37125a(context);
        m37127a(attributeSet);
    }

    /* renamed from: a */
    private void m37127a(AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = this.f49565c.obtainStyledAttributes(attributeSet, C11267R.styleable.DfMaskView);
            this.f49570h = obtainStyledAttributes.getFloat(3, this.f49570h);
            this.f49573k = obtainStyledAttributes.getDimensionPixelSize(5, this.f49573k);
            this.f49574l = obtainStyledAttributes.getDimensionPixelSize(1, this.f49574l);
            this.f49576n = obtainStyledAttributes.getColor(4, this.f49576n);
            this.f49575m = obtainStyledAttributes.getDimensionPixelSize(2, this.f49575m);
            this.f49577o = obtainStyledAttributes.getColor(0, this.f49577o);
            this.f49578p = (int) (((float) this.f49575m) * 0.5f);
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DfMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m37125a(context);
        m37127a(attributeSet);
    }

    /* renamed from: a */
    private void m37125a(Context context) {
        this.f49565c = context;
        Paint paint = new Paint();
        this.f49563a = paint;
        paint.setAntiAlias(true);
        this.f49563a.setStyle(Paint.Style.STROKE);
        this.f49566d = new Path();
        this.f49567e = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        m37126a(canvas);
        m37128b(canvas);
    }

    /* renamed from: a */
    private void m37126a(Canvas canvas) {
        this.f49563a.setColor(this.f49564b);
        this.f49563a.setStrokeWidth(0.0f);
        this.f49563a.setStyle(Paint.Style.FILL);
        this.f49567e.moveTo(0.0f, 0.0f);
        this.f49567e.lineTo((float) this.f49579q.width(), 0.0f);
        this.f49567e.lineTo((float) this.f49579q.width(), (float) (this.f49579q.top + this.f49578p));
        this.f49567e.lineTo(0.0f, (float) (this.f49579q.top + this.f49578p));
        this.f49567e.close();
        canvas.drawPath(this.f49567e, this.f49563a);
        this.f49567e.reset();
        this.f49567e.moveTo(0.0f, (float) (this.f49579q.bottom - this.f49578p));
        this.f49567e.lineTo((float) this.f49579q.width(), (float) (this.f49579q.bottom - this.f49578p));
        this.f49567e.lineTo((float) this.f49579q.width(), (float) this.f49572j);
        this.f49567e.lineTo(0.0f, (float) this.f49572j);
        this.f49567e.close();
        canvas.drawPath(this.f49567e, this.f49563a);
        this.f49567e.reset();
        this.f49567e.reset();
        this.f49567e.moveTo(0.0f, 0.0f);
        this.f49567e.lineTo((float) this.f49578p, 0.0f);
        this.f49567e.lineTo((float) this.f49578p, (float) this.f49572j);
        this.f49567e.lineTo(0.0f, (float) this.f49572j);
        this.f49567e.close();
        canvas.drawPath(this.f49567e, this.f49563a);
        this.f49567e.reset();
        this.f49567e.reset();
        this.f49567e.moveTo((float) (this.f49579q.width() - this.f49578p), 0.0f);
        this.f49567e.lineTo((float) this.f49579q.width(), 0.0f);
        this.f49567e.lineTo((float) this.f49579q.width(), (float) this.f49572j);
        this.f49567e.lineTo((float) (this.f49579q.width() - this.f49578p), (float) this.f49572j);
        this.f49567e.close();
        canvas.drawPath(this.f49567e, this.f49563a);
        this.f49567e.reset();
    }

    /* renamed from: b */
    private void m37128b(Canvas canvas) {
        this.f49563a.setStyle(Paint.Style.STROKE);
        this.f49563a.setColor(this.f49577o);
        this.f49563a.setStrokeWidth((float) this.f49575m);
        this.f49566d.reset();
        this.f49566d.moveTo((float) this.f49578p, (float) (this.f49579q.top + this.f49574l));
        this.f49566d.lineTo((float) this.f49578p, (float) (this.f49579q.top + this.f49578p));
        this.f49566d.lineTo((float) this.f49574l, (float) (this.f49579q.top + this.f49578p));
        canvas.drawPath(this.f49566d, this.f49563a);
        this.f49566d.reset();
        this.f49566d.moveTo((float) (this.f49579q.width() - this.f49574l), (float) (this.f49579q.top + this.f49578p));
        this.f49566d.lineTo((float) (this.f49579q.width() - this.f49578p), (float) (this.f49579q.top + this.f49578p));
        this.f49566d.lineTo((float) (this.f49579q.width() - this.f49578p), (float) (this.f49579q.top + this.f49574l));
        canvas.drawPath(this.f49566d, this.f49563a);
        this.f49566d.reset();
        this.f49566d.moveTo((float) this.f49578p, (float) (this.f49579q.bottom - this.f49574l));
        this.f49566d.lineTo((float) this.f49578p, (float) (this.f49579q.bottom - this.f49578p));
        this.f49566d.lineTo((float) this.f49574l, (float) (this.f49579q.bottom - this.f49578p));
        canvas.drawPath(this.f49566d, this.f49563a);
        this.f49566d.reset();
        this.f49566d.moveTo((float) (this.f49579q.width() - this.f49574l), (float) (this.f49579q.bottom - this.f49578p));
        this.f49566d.lineTo((float) (this.f49579q.width() - this.f49578p), (float) (this.f49579q.bottom - this.f49578p));
        this.f49566d.lineTo((float) (this.f49579q.width() - this.f49578p), (float) (this.f49579q.bottom - this.f49574l));
        canvas.drawPath(this.f49566d, this.f49563a);
        this.f49566d.reset();
        this.f49563a.setColor(this.f49576n);
        this.f49563a.setStrokeWidth((float) this.f49573k);
        this.f49566d.moveTo((float) this.f49578p, (float) (this.f49579q.top + this.f49578p));
        this.f49566d.lineTo((float) (this.f49579q.width() - this.f49578p), (float) (this.f49579q.top + this.f49578p));
        this.f49566d.lineTo((float) (this.f49579q.width() - this.f49578p), (float) (this.f49579q.bottom - this.f49578p));
        this.f49566d.lineTo((float) this.f49578p, (float) (this.f49579q.bottom - this.f49578p));
        this.f49566d.close();
        canvas.drawPath(this.f49566d, this.f49563a);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f49571i = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f49572j = measuredHeight;
        int i3 = this.f49571i;
        this.f49568f = i3;
        int i4 = (int) (((float) i3) / this.f49570h);
        this.f49569g = i4;
        int i5 = (int) (((float) (measuredHeight - i4)) * 0.5f);
        this.f49579q.set(0, i5, i3, i4 + i5);
    }

    public Rect getMaskRect() {
        return this.f49579q;
    }
}
