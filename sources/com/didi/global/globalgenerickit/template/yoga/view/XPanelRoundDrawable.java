package com.didi.global.globalgenerickit.template.yoga.view;

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
    private final Path f24182a;

    /* renamed from: b */
    private int f24183b;

    /* renamed from: c */
    private int f24184c;

    /* renamed from: d */
    private RectF f24185d;

    /* renamed from: e */
    private Bitmap f24186e;

    /* renamed from: f */
    private Paint f24187f;

    /* renamed from: g */
    private float[] f24188g = new float[8];

    /* renamed from: h */
    private Matrix f24189h;

    /* renamed from: i */
    private boolean f24190i = true;

    /* renamed from: j */
    private BitmapShader f24191j;

    /* renamed from: k */
    private Paint f24192k;

    /* renamed from: l */
    private boolean f24193l = false;

    /* renamed from: m */
    private float f24194m;

    public int getOpacity() {
        return -3;
    }

    public XPanelRoundDrawable(Bitmap bitmap, Corner corner) {
        this.f24186e = bitmap;
        this.f24191j = new BitmapShader(this.f24186e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f24183b = bitmap.getWidth();
        this.f24184c = bitmap.getHeight();
        float[] fArr = this.f24188g;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f24188g;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f24188g;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f24188g;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f24192k = paint;
        paint.setAntiAlias(true);
        this.f24192k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f24187f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f24187f.setAntiAlias(true);
        this.f24187f.setShader(this.f24191j);
        this.f24185d = new RectF();
        this.f24189h = new Matrix();
        this.f24182a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f24185d.set(rect);
        if (!(this.f24184c == 0 || this.f24183b == 0)) {
            this.f24189h.setScale((this.f24185d.width() * 1.0f) / ((float) this.f24183b), (this.f24185d.height() * 1.0f) / ((float) this.f24184c));
        }
        this.f24190i = true;
    }

    public static XPanelRoundDrawable fromBitmap(Bitmap bitmap, Corner corner) {
        if (bitmap != null) {
            return new XPanelRoundDrawable(bitmap, corner);
        }
        return null;
    }

    public void setBorderColor(int i) {
        this.f24192k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f24193l = true;
            this.f24194m = f;
            this.f24192k.setStrokeWidth(f);
            return;
        }
        this.f24193l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f24190i && (bitmapShader = this.f24191j) != null) {
            bitmapShader.setLocalMatrix(this.f24189h);
            this.f24190i = false;
        }
        this.f24182a.reset();
        this.f24182a.addRoundRect(this.f24185d, this.f24188g, Path.Direction.CW);
        canvas.drawPath(this.f24182a, this.f24187f);
        if (this.f24193l) {
            this.f24182a.reset();
            this.f24185d.left += this.f24194m / 2.0f;
            this.f24185d.top += this.f24194m / 2.0f;
            this.f24185d.right -= this.f24194m / 2.0f;
            this.f24185d.bottom -= this.f24194m / 2.0f;
            this.f24182a.addRoundRect(this.f24185d, this.f24188g, Path.Direction.CW);
            canvas.drawPath(this.f24182a, this.f24192k);
        }
    }

    public void setAlpha(int i) {
        this.f24187f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f24187f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f24184c;
    }

    public int getIntrinsicWidth() {
        return this.f24183b;
    }
}
