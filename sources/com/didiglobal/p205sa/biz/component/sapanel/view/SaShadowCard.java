package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.widget.RelativeLayout;
import com.didi.global.globaluikit.utils.UiUtils;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SaShadowCard */
public class SaShadowCard extends RelativeLayout {

    /* renamed from: a */
    private Paint f53713a;

    /* renamed from: b */
    private boolean f53714b = true;

    /* renamed from: c */
    private int f53715c;

    /* renamed from: d */
    private int f53716d;

    /* renamed from: e */
    private int f53717e;

    /* renamed from: f */
    private int f53718f;

    public SaShadowCard(Context context) {
        super(context);
        m40086a(context);
    }

    /* renamed from: a */
    private void m40086a(Context context) {
        Paint paint = new Paint();
        this.f53713a = paint;
        paint.setAntiAlias(true);
        this.f53713a.setStyle(Paint.Style.FILL);
        this.f53716d = Color.parseColor("#E589A2AE");
    }

    public void setmShadowColor(int i) {
        this.f53716d = i;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m40085a(getWidth(), getHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* renamed from: a */
    private void m40085a(int i, int i2) {
        if (this.f53714b) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(m40084a(i, i2, 0.0f, (float) this.f53715c, (float) this.f53717e, (float) this.f53718f, this.f53716d, 0));
            if (Build.VERSION.SDK_INT <= 16) {
                setBackgroundDrawable(bitmapDrawable);
            } else {
                setBackground(bitmapDrawable);
            }
        }
    }

    /* renamed from: a */
    private Bitmap m40084a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF((float) getPaddingLeft(), (float) ((i2 - getPaddingBottom()) - (((i2 - getPaddingTop()) - getPaddingBottom()) / 5)), (float) (i - getPaddingRight()), (float) (i2 - getPaddingBottom()));
        this.f53713a.setColor(i4);
        if (!isInEditMode()) {
            this.f53713a.setShadowLayer(f2, f3, f4, i3);
        }
        float dip2px = (float) UiUtils.dip2px(getContext(), 20.0f);
        canvas.drawRoundRect(rectF, dip2px, dip2px, this.f53713a);
        return createBitmap;
    }

    public void setShadowLimit(int i) {
        if (this.f53714b) {
            this.f53715c = i;
        }
    }

    public void setShowShadow(boolean z) {
        this.f53714b = z;
    }

    public int getDx() {
        return this.f53717e;
    }

    public void setDx(int i) {
        this.f53717e = i;
    }

    public int getDy() {
        return this.f53718f;
    }

    public void setDy(int i) {
        this.f53718f = i;
    }
}
