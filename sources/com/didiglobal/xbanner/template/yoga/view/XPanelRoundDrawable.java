package com.didiglobal.xbanner.template.yoga.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class XPanelRoundDrawable extends Drawable {

    /* renamed from: a */
    private final Path f54099a;

    /* renamed from: b */
    private int f54100b;

    /* renamed from: c */
    private int f54101c;

    /* renamed from: d */
    private RectF f54102d;

    /* renamed from: e */
    private Bitmap f54103e;

    /* renamed from: f */
    private Paint f54104f;

    /* renamed from: g */
    private float[] f54105g = new float[8];

    /* renamed from: h */
    private Matrix f54106h;

    /* renamed from: i */
    private boolean f54107i = true;

    /* renamed from: j */
    private BitmapShader f54108j;

    /* renamed from: k */
    private Paint f54109k;

    /* renamed from: l */
    private boolean f54110l = false;

    /* renamed from: m */
    private float f54111m;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundDrawable(Bitmap bitmap, Corner corner) {
        this.f54103e = bitmap;
        this.f54108j = new BitmapShader(this.f54103e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f54100b = bitmap.getWidth();
        this.f54101c = bitmap.getHeight();
        float[] fArr = this.f54105g;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f54105g;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f54105g;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f54105g;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f54109k = paint;
        paint.setAntiAlias(true);
        this.f54109k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f54104f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f54104f.setAntiAlias(true);
        this.f54104f.setShader(this.f54108j);
        this.f54102d = new RectF();
        this.f54106h = new Matrix();
        this.f54099a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f54102d.set(rect);
        if (!(this.f54101c == 0 || this.f54100b == 0)) {
            this.f54106h.setScale((this.f54102d.width() * 1.0f) / ((float) this.f54100b), (this.f54102d.height() * 1.0f) / ((float) this.f54101c));
        }
        this.f54107i = true;
    }

    public static XPanelRoundDrawable fromBitmap(Bitmap bitmap, Corner corner) {
        if (bitmap != null) {
            return new XPanelRoundDrawable(bitmap, corner);
        }
        return null;
    }

    public void setBorderColor(int i) {
        this.f54109k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f54110l = true;
            this.f54111m = f;
            this.f54109k.setStrokeWidth(f);
            return;
        }
        this.f54110l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f54107i && (bitmapShader = this.f54108j) != null) {
            bitmapShader.setLocalMatrix(this.f54106h);
            this.f54107i = false;
        }
        this.f54099a.reset();
        this.f54099a.addRoundRect(this.f54102d, this.f54105g, Path.Direction.CW);
        canvas.drawPath(this.f54099a, this.f54104f);
        if (this.f54110l) {
            this.f54099a.reset();
            this.f54102d.left += this.f54111m / 2.0f;
            this.f54102d.top += this.f54111m / 2.0f;
            this.f54102d.right -= this.f54111m / 2.0f;
            this.f54102d.bottom -= this.f54111m / 2.0f;
            this.f54099a.addRoundRect(this.f54102d, this.f54105g, Path.Direction.CW);
            canvas.drawPath(this.f54099a, this.f54109k);
        }
    }

    public void setAlpha(int i) {
        this.f54104f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f54104f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f54101c;
    }

    public int getIntrinsicWidth() {
        return this.f54100b;
    }
}
