package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class CustomerRoundDrawable extends Drawable {

    /* renamed from: a */
    private Path f44092a;

    /* renamed from: b */
    private int f44093b;

    /* renamed from: c */
    private int f44094c;

    /* renamed from: d */
    private RectF f44095d;

    /* renamed from: e */
    private Bitmap f44096e;

    /* renamed from: f */
    private Paint f44097f;

    /* renamed from: g */
    private float[] f44098g = new float[8];

    /* renamed from: h */
    private Matrix f44099h;

    /* renamed from: i */
    private boolean f44100i = true;

    /* renamed from: j */
    private BitmapShader f44101j;

    /* renamed from: k */
    private Paint f44102k;

    /* renamed from: l */
    private boolean f44103l = false;

    /* renamed from: m */
    private float f44104m;

    public int getOpacity() {
        return -3;
    }

    public CustomerRoundDrawable(Context context, int i, Corner corner) {
        m32849a(BitmapFactory.decodeResource(context.getResources(), i), corner);
    }

    public CustomerRoundDrawable(Bitmap bitmap, Corner corner) {
        m32849a(bitmap, corner);
    }

    /* renamed from: a */
    private void m32849a(Bitmap bitmap, Corner corner) {
        this.f44096e = bitmap;
        this.f44101j = new BitmapShader(this.f44096e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f44093b = bitmap.getWidth();
        this.f44094c = bitmap.getHeight();
        float[] fArr = this.f44098g;
        float leftTopCorner = corner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f44098g;
        float rightTopCorner = corner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f44098g;
        float rightBottomCorner = corner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f44098g;
        float leftBottomCorner = corner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        Paint paint = new Paint();
        this.f44102k = paint;
        paint.setAntiAlias(true);
        this.f44102k.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f44097f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f44097f.setAntiAlias(true);
        this.f44097f.setShader(this.f44101j);
        this.f44095d = new RectF();
        this.f44099h = new Matrix();
        this.f44092a = new Path();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f44095d.set(rect);
        if (!(this.f44094c == 0 || this.f44093b == 0)) {
            this.f44099h.setScale((this.f44095d.width() * 1.0f) / ((float) this.f44093b), (this.f44095d.height() * 1.0f) / ((float) this.f44094c));
        }
        this.f44100i = true;
    }

    public void setBorderColor(int i) {
        this.f44102k.setColor(i);
    }

    public void setBorderWidth(float f) {
        if (f > 0.0f) {
            this.f44103l = true;
            this.f44104m = f;
            this.f44102k.setStrokeWidth(f);
            return;
        }
        this.f44103l = false;
    }

    public void draw(Canvas canvas) {
        BitmapShader bitmapShader;
        if (this.f44100i && (bitmapShader = this.f44101j) != null) {
            bitmapShader.setLocalMatrix(this.f44099h);
            this.f44100i = false;
        }
        this.f44092a.reset();
        this.f44092a.addRoundRect(this.f44095d, this.f44098g, Path.Direction.CW);
        canvas.drawPath(this.f44092a, this.f44097f);
        if (this.f44103l) {
            this.f44092a.reset();
            this.f44095d.left += this.f44104m / 2.0f;
            this.f44095d.top += this.f44104m / 2.0f;
            this.f44095d.right -= this.f44104m / 2.0f;
            this.f44095d.bottom -= this.f44104m / 2.0f;
            this.f44092a.addRoundRect(this.f44095d, this.f44098g, Path.Direction.CW);
            canvas.drawPath(this.f44092a, this.f44102k);
        }
    }

    public void setAlpha(int i) {
        this.f44097f.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f44097f.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.f44094c;
    }

    public int getIntrinsicWidth() {
        return this.f44093b;
    }

    public static class Corner {
        private float leftBottomCorner;
        private float leftTopCorner;
        private float rightBottomCorner;
        private float rightTopCorner;

        public void setCorners(float f) {
            this.leftTopCorner = f;
            this.leftBottomCorner = f;
            this.rightTopCorner = f;
            this.rightBottomCorner = f;
        }

        public void setLeftTopCorner(float f) {
            this.leftTopCorner = f;
        }

        public void setLeftBottomCorner(float f) {
            this.leftBottomCorner = f;
        }

        public void setRightTopCorner(float f) {
            this.rightTopCorner = f;
        }

        public void setRightBottomCorner(float f) {
            this.rightBottomCorner = f;
        }

        public float getLeftTopCorner() {
            return this.leftTopCorner;
        }

        public float getLeftBottomCorner() {
            return this.leftBottomCorner;
        }

        public float getRightTopCorner() {
            return this.rightTopCorner;
        }

        public float getRightBottomCorner() {
            return this.rightBottomCorner;
        }
    }
}
