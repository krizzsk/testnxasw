package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class Triangle extends View {

    /* renamed from: a */
    private boolean f44226a = false;

    /* renamed from: b */
    private Paint f44227b;

    /* renamed from: c */
    private Path f44228c;

    public Triangle(Context context) {
        super(context);
        m32906a();
    }

    public Triangle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32906a();
    }

    public Triangle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32906a();
    }

    public void enableInverted() {
        this.f44226a = true;
        m32907a(getWidth(), getHeight());
    }

    public void onDraw(Canvas canvas) {
        Path path = this.f44228c;
        if (path != null) {
            canvas.drawPath(path, this.f44227b);
        }
        super.onDraw(canvas);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m32907a(i, i2);
    }

    public void setFillColor(int i) {
        this.f44227b.setColor(i);
        invalidate();
    }

    /* renamed from: a */
    private void m32906a() {
        Paint paint = new Paint(1);
        this.f44227b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f44227b.setStrokeWidth(2.0f);
    }

    /* renamed from: a */
    private void m32907a(int i, int i2) {
        Path path = new Path();
        this.f44228c = path;
        if (this.f44226a) {
            path.moveTo((float) (i / 2), (float) i2);
            this.f44228c.lineTo((float) i, 0.0f);
            this.f44228c.lineTo(0.0f, 0.0f);
        } else {
            path.moveTo((float) (i / 2), 0.0f);
            float f = (float) i2;
            this.f44228c.lineTo((float) i, f);
            this.f44228c.lineTo(0.0f, f);
        }
        this.f44228c.close();
    }
}
