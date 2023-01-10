package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C11267R;

public class DashLineView extends View {

    /* renamed from: a */
    private static final int f44133a = 0;

    /* renamed from: b */
    private static final int f44134b = 0;

    /* renamed from: c */
    private static final int f44135c = 0;

    /* renamed from: d */
    private static final int f44136d = 0;

    /* renamed from: e */
    private static final int f44137e = 0;

    /* renamed from: f */
    private Paint f44138f;

    /* renamed from: g */
    private Path f44139g;

    /* renamed from: h */
    private int f44140h = 0;

    /* renamed from: i */
    private int f44141i = 0;

    /* renamed from: j */
    private int f44142j = 0;

    /* renamed from: k */
    private int f44143k = 0;

    /* renamed from: l */
    private int f44144l = 0;

    /* renamed from: m */
    private int f44145m;

    public DashLineView(Context context) {
        super(context);
        m32870a(context, (AttributeSet) null);
    }

    public DashLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32870a(context, attributeSet);
    }

    public DashLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32870a(context, attributeSet);
    }

    public void setDashStyle(int i, int i2, int i3, int i4) {
        this.f44140h = i;
        this.f44141i = i2;
        this.f44142j = i3;
        this.f44143k = i4;
        m32869a();
        postInvalidate();
    }

    public void setHeight(int i) {
        this.f44145m = i;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f44140h != 0) {
            if (this.f44144l == 0) {
                this.f44139g.reset();
                float height = (float) (getHeight() / 2);
                this.f44139g.moveTo(0.0f, height);
                this.f44139g.lineTo((float) getWidth(), height);
            } else {
                this.f44139g.reset();
                float width = (float) (getWidth() / 2);
                this.f44139g.moveTo(width, 0.0f);
                Path path = this.f44139g;
                int i = this.f44145m;
                if (i <= 0) {
                    i = getHeight();
                }
                path.lineTo(width, (float) i);
            }
            canvas.drawPath(this.f44139g, this.f44138f);
        }
    }

    /* renamed from: a */
    private void m32870a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.DashLineView);
            this.f44140h = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f44141i = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.f44142j = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f44143k = obtainStyledAttributes.getColor(0, 0);
            this.f44144l = obtainStyledAttributes.getInt(2, 0);
            obtainStyledAttributes.recycle();
        }
        m32869a();
    }

    /* renamed from: a */
    private void m32869a() {
        Paint paint = new Paint(1);
        this.f44138f = paint;
        paint.setColor(this.f44143k);
        this.f44138f.setStyle(Paint.Style.STROKE);
        this.f44138f.setStrokeWidth((float) this.f44140h);
        this.f44138f.setPathEffect(new DashPathEffect(new float[]{(float) this.f44141i, (float) this.f44142j}, 0.0f));
        this.f44139g = new Path();
    }
}
