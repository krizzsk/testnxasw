package com.didichuxing.xpanel.xcard.view;

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
    private final Path f52227a;

    /* renamed from: b */
    private int f52228b;

    /* renamed from: c */
    private int f52229c;

    /* renamed from: d */
    private RectF f52230d;

    /* renamed from: e */
    private Bitmap f52231e;

    /* renamed from: f */
    private Paint f52232f;

    /* renamed from: g */
    private float[] f52233g = new float[8];

    /* renamed from: h */
    private Matrix f52234h;

    /* renamed from: i */
    private boolean f52235i = true;

    /* renamed from: j */
    private BitmapShader f52236j;

    /* renamed from: k */
    private Paint f52237k;

    /* renamed from: l */
    private boolean f52238l = false;

    /* renamed from: m */
    private float f52239m;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundDrawable(Bitmap bitmap, Corner corner) {
        this.f52231e = bitmap;
        this.f52236j = new BitmapShader(this.f52231e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f52228b = bitmap.getWidth();
        this.f52229c = bitmap.getHeight();
        float[] fArr = this.f52233g;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f52233g;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f52233g;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f52233g;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f52237k = paint;
        paint.setAntiAlias(true);
        this.f52237k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f52232f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f52232f.setAntiAlias(true);
        this.f52232f.setShader(this.f52236j);
        this.f52230d = new RectF();
        this.f52234h = new Matrix();
        this.f52227a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f52230d.set(rect);
        if (!(this.f52229c == 0 || this.f52228b == 0)) {
            this.f52234h.setScale((this.f52230d.width() * 1.0f) / ((float) this.f52228b), (this.f52230d.height() * 1.0f) / ((float) this.f52229c));
        }
        this.f52235i = true;
    }

    public static XPanelRoundDrawable fromBitmap(Bitmap bitmap, Corner corner) {
        if (bitmap != null) {
            return new XPanelRoundDrawable(bitmap, corner);
        }
        return null;
    }

    public void setBorderColor(int i) {
        this.f52237k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f52238l = true;
            this.f52239m = f;
            this.f52237k.setStrokeWidth(f);
            return;
        }
        this.f52238l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f52235i && (bitmapShader = this.f52236j) != null) {
            bitmapShader.setLocalMatrix(this.f52234h);
            this.f52235i = false;
        }
        this.f52227a.reset();
        this.f52227a.addRoundRect(this.f52230d, this.f52233g, Path.Direction.CW);
        canvas.drawPath(this.f52227a, this.f52232f);
        if (this.f52238l) {
            this.f52227a.reset();
            this.f52230d.left += this.f52239m / 2.0f;
            this.f52230d.top += this.f52239m / 2.0f;
            this.f52230d.right -= this.f52239m / 2.0f;
            this.f52230d.bottom -= this.f52239m / 2.0f;
            this.f52227a.addRoundRect(this.f52230d, this.f52233g, Path.Direction.CW);
            canvas.drawPath(this.f52227a, this.f52237k);
        }
    }

    public void setAlpha(int i) {
        this.f52232f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f52232f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f52229c;
    }

    public int getIntrinsicWidth() {
        return this.f52228b;
    }
}
