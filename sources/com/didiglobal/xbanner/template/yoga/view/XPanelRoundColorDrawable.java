package com.didiglobal.xbanner.template.yoga.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class XPanelRoundColorDrawable extends Drawable {

    /* renamed from: a */
    private final Path f54094a = new Path();

    /* renamed from: b */
    private RectF f54095b = new RectF();

    /* renamed from: c */
    private Paint f54096c;

    /* renamed from: d */
    private float[] f54097d;

    /* renamed from: e */
    private Paint f54098e;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundColorDrawable(int i, Corner corner) {
        float[] fArr = new float[8];
        this.f54097d = fArr;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f54097d;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f54097d;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f54097d;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f54096c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f54096c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f54098e = paint2;
        paint2.setAntiAlias(true);
        this.f54098e.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f54095b.set(rect);
    }

    public void draw(Canvas canvas) {
        this.f54094a.reset();
        this.f54094a.addRoundRect(this.f54095b, this.f54097d, Path.Direction.CW);
        canvas.drawPath(this.f54094a, this.f54098e);
    }

    public void setAlpha(int i) {
        this.f54096c.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f54096c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
