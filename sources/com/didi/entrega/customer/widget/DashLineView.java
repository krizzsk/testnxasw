package com.didi.entrega.customer.widget;

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
    private static final int f22138a = 0;

    /* renamed from: b */
    private static final int f22139b = 0;

    /* renamed from: c */
    private static final int f22140c = 0;

    /* renamed from: d */
    private static final int f22141d = 0;

    /* renamed from: e */
    private static final int f22142e = 0;

    /* renamed from: f */
    private Paint f22143f;

    /* renamed from: g */
    private Path f22144g;

    /* renamed from: h */
    private int f22145h = 0;

    /* renamed from: i */
    private int f22146i = 0;

    /* renamed from: j */
    private int f22147j = 0;

    /* renamed from: k */
    private int f22148k = 0;

    /* renamed from: l */
    private int f22149l = 0;

    /* renamed from: m */
    private int f22150m;

    public DashLineView(Context context) {
        super(context);
        m18320a(context, (AttributeSet) null);
    }

    public DashLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18320a(context, attributeSet);
    }

    public DashLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18320a(context, attributeSet);
    }

    public void setDashStyle(int i, int i2, int i3, int i4) {
        this.f22145h = i;
        this.f22146i = i2;
        this.f22147j = i3;
        this.f22148k = i4;
        m18319a();
        postInvalidate();
    }

    public void setHeight(int i) {
        this.f22150m = i;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f22145h != 0) {
            if (this.f22149l == 0) {
                this.f22144g.reset();
                float height = (float) (getHeight() / 2);
                this.f22144g.moveTo(0.0f, height);
                this.f22144g.lineTo((float) getWidth(), height);
            } else {
                this.f22144g.reset();
                float width = (float) (getWidth() / 2);
                this.f22144g.moveTo(width, 0.0f);
                Path path = this.f22144g;
                int i = this.f22150m;
                if (i <= 0) {
                    i = getHeight();
                }
                path.lineTo(width, (float) i);
            }
            canvas.drawPath(this.f22144g, this.f22143f);
        }
    }

    /* renamed from: a */
    private void m18320a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaDashLineView);
            this.f22145h = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.f22146i = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f22147j = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f22148k = obtainStyledAttributes.getColor(0, 0);
            this.f22149l = obtainStyledAttributes.getInt(4, 0);
            obtainStyledAttributes.recycle();
        }
        m18319a();
    }

    /* renamed from: a */
    private void m18319a() {
        Paint paint = new Paint(1);
        this.f22143f = paint;
        paint.setColor(this.f22148k);
        this.f22143f.setStyle(Paint.Style.STROKE);
        this.f22143f.setStrokeWidth((float) this.f22145h);
        this.f22143f.setPathEffect(new DashPathEffect(new float[]{(float) this.f22146i, (float) this.f22147j}, 0.0f));
        this.f22144g = new Path();
    }
}
