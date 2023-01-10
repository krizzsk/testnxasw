package com.didi.addressnew.framework.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class CubicBezierInterpolator implements Interpolator {

    /* renamed from: a */
    protected PointF f9248a;

    /* renamed from: b */
    protected PointF f9249b;

    /* renamed from: c */
    protected PointF f9250c;
    protected PointF end;
    protected PointF start;

    public CubicBezierInterpolator(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.f9248a = new PointF();
        this.f9249b = new PointF();
        this.f9250c = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        } else if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        } else {
            this.start = pointF;
            this.end = pointF2;
        }
    }

    public CubicBezierInterpolator(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    public CubicBezierInterpolator(double d, double d2, double d3, double d4) {
        this((float) d, (float) d2, (float) d3, (float) d4);
    }

    public float getInterpolation(float f) {
        return getBezierCoordinateY(getXForTime(f));
    }

    /* access modifiers changed from: protected */
    public float getBezierCoordinateY(float f) {
        this.f9250c.y = this.start.y * 3.0f;
        this.f9249b.y = ((this.end.y - this.start.y) * 3.0f) - this.f9250c.y;
        this.f9248a.y = (1.0f - this.f9250c.y) - this.f9249b.y;
        return f * (this.f9250c.y + ((this.f9249b.y + (this.f9248a.y * f)) * f));
    }

    /* access modifiers changed from: protected */
    public float getXForTime(float f) {
        float f2 = f;
        for (int i = 1; i < 14; i++) {
            float b = m8043b(f2) - f;
            if (((double) Math.abs(b)) < 0.001d) {
                break;
            }
            f2 -= b / m8042a(f2);
        }
        return f2;
    }

    /* renamed from: a */
    private float m8042a(float f) {
        return this.f9250c.x + (f * ((this.f9249b.x * 2.0f) + (this.f9248a.x * 3.0f * f)));
    }

    /* renamed from: b */
    private float m8043b(float f) {
        this.f9250c.x = this.start.x * 3.0f;
        this.f9249b.x = ((this.end.x - this.start.x) * 3.0f) - this.f9250c.x;
        this.f9248a.x = (1.0f - this.f9250c.x) - this.f9249b.x;
        return f * (this.f9250c.x + ((this.f9249b.x + (this.f9248a.x * f)) * f));
    }
}
