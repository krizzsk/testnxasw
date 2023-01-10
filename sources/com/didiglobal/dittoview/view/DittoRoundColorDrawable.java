package com.didiglobal.dittoview.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class DittoRoundColorDrawable extends Drawable {

    /* renamed from: a */
    private final Path f52492a = new Path();

    /* renamed from: b */
    private RectF f52493b = new RectF();

    /* renamed from: c */
    private Paint f52494c;

    /* renamed from: d */
    private float[] f52495d;

    /* renamed from: e */
    private Paint f52496e;

    public int getOpacity() {
        return -3;
    }

    public DittoRoundColorDrawable(int i, DittoCorner dittoCorner) {
        float[] fArr = new float[8];
        this.f52495d = fArr;
        float leftTopCorner = dittoCorner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f52495d;
        float rightTopCorner = dittoCorner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f52495d;
        float rightBottomCorner = dittoCorner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f52495d;
        float leftBottomCorner = dittoCorner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f52494c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f52494c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f52496e = paint2;
        paint2.setAntiAlias(true);
        this.f52496e.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f52493b.set(rect);
    }

    public void draw(Canvas canvas) {
        this.f52492a.reset();
        this.f52492a.addRoundRect(this.f52493b, this.f52495d, Path.Direction.CW);
        canvas.drawPath(this.f52492a, this.f52496e);
    }

    public void setAlpha(int i) {
        this.f52494c.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f52494c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
