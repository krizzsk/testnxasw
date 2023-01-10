package com.scwang.smart.refresh.classics;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import com.scwang.smart.drawable.PaintDrawable;

public class ArrowDrawable extends PaintDrawable {

    /* renamed from: a */
    private int f58740a = 0;

    /* renamed from: b */
    private int f58741b = 0;

    /* renamed from: c */
    private Path f58742c = new Path();

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (!(this.f58740a == width && this.f58741b == height)) {
            this.f58742c.reset();
            float f = (float) ((width * 30) / 225);
            float f2 = f * 0.70710677f;
            float f3 = f / 0.70710677f;
            float f4 = (float) width;
            float f5 = f4 / 2.0f;
            float f6 = (float) height;
            this.f58742c.moveTo(f5, f6);
            float f7 = f6 / 2.0f;
            this.f58742c.lineTo(0.0f, f7);
            float f8 = f7 - f2;
            this.f58742c.lineTo(f2, f8);
            float f9 = f / 2.0f;
            float f10 = f5 - f9;
            float f11 = (f6 - f3) - f9;
            this.f58742c.lineTo(f10, f11);
            this.f58742c.lineTo(f10, 0.0f);
            float f12 = f5 + f9;
            this.f58742c.lineTo(f12, 0.0f);
            this.f58742c.lineTo(f12, f11);
            this.f58742c.lineTo(f4 - f2, f8);
            this.f58742c.lineTo(f4, f7);
            this.f58742c.close();
            this.f58740a = width;
            this.f58741b = height;
        }
        canvas.drawPath(this.f58742c, this.mPaint);
    }
}
