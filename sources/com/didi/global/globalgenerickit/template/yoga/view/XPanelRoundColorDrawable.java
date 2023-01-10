package com.didi.global.globalgenerickit.template.yoga.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class XPanelRoundColorDrawable extends Drawable {

    /* renamed from: a */
    private final Path f24177a = new Path();

    /* renamed from: b */
    private RectF f24178b = new RectF();

    /* renamed from: c */
    private Paint f24179c;

    /* renamed from: d */
    private float[] f24180d;

    /* renamed from: e */
    private Paint f24181e;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundColorDrawable(int i, Corner corner) {
        float[] fArr = new float[8];
        this.f24180d = fArr;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f24180d;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f24180d;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f24180d;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f24179c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f24179c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f24181e = paint2;
        paint2.setAntiAlias(true);
        this.f24181e.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f24178b.set(rect);
    }

    public void draw(Canvas canvas) {
        this.f24177a.reset();
        this.f24177a.addRoundRect(this.f24178b, this.f24180d, Path.Direction.CW);
        canvas.drawPath(this.f24177a, this.f24181e);
    }

    public void setAlpha(int i) {
        this.f24179c.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f24179c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
