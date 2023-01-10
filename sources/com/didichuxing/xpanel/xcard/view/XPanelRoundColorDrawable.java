package com.didichuxing.xpanel.xcard.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class XPanelRoundColorDrawable extends Drawable {

    /* renamed from: a */
    private final Path f52222a = new Path();

    /* renamed from: b */
    private RectF f52223b = new RectF();

    /* renamed from: c */
    private Paint f52224c;

    /* renamed from: d */
    private float[] f52225d;

    /* renamed from: e */
    private Paint f52226e;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundColorDrawable(int i, Corner corner) {
        float[] fArr = new float[8];
        this.f52225d = fArr;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f52225d;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f52225d;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f52225d;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f52224c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f52224c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f52226e = paint2;
        paint2.setAntiAlias(true);
        this.f52226e.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f52223b.set(rect);
    }

    public void draw(Canvas canvas) {
        this.f52222a.reset();
        this.f52222a.addRoundRect(this.f52223b, this.f52225d, Path.Direction.CW);
        canvas.drawPath(this.f52222a, this.f52226e);
    }

    public void setAlpha(int i) {
        this.f52224c.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f52224c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
