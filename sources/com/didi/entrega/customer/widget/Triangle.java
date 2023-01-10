package com.didi.entrega.customer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class Triangle extends View {

    /* renamed from: a */
    private boolean f22212a = false;

    /* renamed from: b */
    private Paint f22213b;

    /* renamed from: c */
    private Path f22214c;

    public Triangle(Context context) {
        super(context);
        m18342a();
    }

    public Triangle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18342a();
    }

    public Triangle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18342a();
    }

    public void enableInverted() {
        this.f22212a = true;
        m18343a(getWidth(), getHeight());
    }

    public void onDraw(Canvas canvas) {
        Path path = this.f22214c;
        if (path != null) {
            canvas.drawPath(path, this.f22213b);
        }
        super.onDraw(canvas);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m18343a(i, i2);
    }

    public void setFillColor(int i) {
        this.f22213b.setColor(i);
        invalidate();
    }

    /* renamed from: a */
    private void m18342a() {
        Paint paint = new Paint(1);
        this.f22213b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f22213b.setStrokeWidth(2.0f);
    }

    /* renamed from: a */
    private void m18343a(int i, int i2) {
        Path path = new Path();
        this.f22214c = path;
        if (this.f22212a) {
            path.moveTo((float) (i / 2), (float) i2);
            this.f22214c.lineTo((float) i, 0.0f);
            this.f22214c.lineTo(0.0f, 0.0f);
        } else {
            path.moveTo((float) (i / 2), 0.0f);
            float f = (float) i2;
            this.f22214c.lineTo((float) i, f);
            this.f22214c.lineTo(0.0f, f);
        }
        this.f22214c.close();
    }
}
