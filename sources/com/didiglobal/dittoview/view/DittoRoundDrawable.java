package com.didiglobal.dittoview.view;

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

public class DittoRoundDrawable extends Drawable {

    /* renamed from: a */
    private final Path f52497a;

    /* renamed from: b */
    private int f52498b;

    /* renamed from: c */
    private int f52499c;

    /* renamed from: d */
    private RectF f52500d;

    /* renamed from: e */
    private Bitmap f52501e;

    /* renamed from: f */
    private Paint f52502f;

    /* renamed from: g */
    private float[] f52503g = new float[8];

    /* renamed from: h */
    private Matrix f52504h;

    /* renamed from: i */
    private boolean f52505i = true;

    /* renamed from: j */
    private BitmapShader f52506j;

    /* renamed from: k */
    private Paint f52507k;

    /* renamed from: l */
    private boolean f52508l = false;

    /* renamed from: m */
    private float f52509m;

    public int getOpacity() {
        return -3;
    }

    public DittoRoundDrawable(Bitmap bitmap, DittoCorner dittoCorner) {
        this.f52501e = bitmap;
        this.f52506j = new BitmapShader(this.f52501e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f52498b = bitmap.getWidth();
        this.f52499c = bitmap.getHeight();
        float[] fArr = this.f52503g;
        float leftTopCorner = dittoCorner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f52503g;
        float rightTopCorner = dittoCorner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f52503g;
        float rightBottomCorner = dittoCorner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f52503g;
        float leftBottomCorner = dittoCorner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f52507k = paint;
        paint.setAntiAlias(true);
        this.f52507k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f52502f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f52502f.setAntiAlias(true);
        this.f52502f.setShader(this.f52506j);
        this.f52500d = new RectF();
        this.f52504h = new Matrix();
        this.f52497a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f52500d.set(rect);
        if (!(this.f52499c == 0 || this.f52498b == 0)) {
            this.f52504h.setScale((this.f52500d.width() * 1.0f) / ((float) this.f52498b), (this.f52500d.height() * 1.0f) / ((float) this.f52499c));
        }
        this.f52505i = true;
    }

    public static DittoRoundDrawable fromBitmap(Bitmap bitmap, DittoCorner dittoCorner) {
        if (bitmap != null) {
            return new DittoRoundDrawable(bitmap, dittoCorner);
        }
        return null;
    }

    public void setBorderColor(int i) {
        this.f52507k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f52508l = true;
            this.f52509m = f;
            this.f52507k.setStrokeWidth(f);
            return;
        }
        this.f52508l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f52505i && (bitmapShader = this.f52506j) != null) {
            bitmapShader.setLocalMatrix(this.f52504h);
            this.f52505i = false;
        }
        this.f52497a.reset();
        this.f52497a.addRoundRect(this.f52500d, this.f52503g, Path.Direction.CW);
        canvas.drawPath(this.f52497a, this.f52502f);
        if (this.f52508l) {
            this.f52497a.reset();
            this.f52500d.left += this.f52509m / 2.0f;
            this.f52500d.top += this.f52509m / 2.0f;
            this.f52500d.right -= this.f52509m / 2.0f;
            this.f52500d.bottom -= this.f52509m / 2.0f;
            this.f52497a.addRoundRect(this.f52500d, this.f52503g, Path.Direction.CW);
            canvas.drawPath(this.f52497a, this.f52507k);
        }
    }

    public void setAlpha(int i) {
        this.f52502f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f52502f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f52499c;
    }

    public int getIntrinsicWidth() {
        return this.f52498b;
    }
}
