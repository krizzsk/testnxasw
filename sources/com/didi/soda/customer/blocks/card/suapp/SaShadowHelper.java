package com.didi.soda.customer.blocks.card.suapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;

public class SaShadowHelper {

    /* renamed from: a */
    private View f43213a;

    /* renamed from: b */
    private Paint f43214b;

    /* renamed from: c */
    private boolean f43215c = true;

    /* renamed from: d */
    private int f43216d;

    /* renamed from: e */
    private int f43217e;

    /* renamed from: f */
    private int f43218f;

    /* renamed from: g */
    private int f43219g;

    public static int fixItemMargin(int i, int i2, int i3) {
        return i - (i2 + i3);
    }

    public SaShadowHelper(View view) {
        this.f43213a = view;
        m32358a(view.getContext());
    }

    /* renamed from: a */
    private void m32358a(Context context) {
        Paint paint = new Paint();
        this.f43214b = paint;
        paint.setAntiAlias(true);
        this.f43214b.setStyle(Paint.Style.FILL);
        this.f43217e = Color.parseColor("#1989A2AE");
    }

    public void setmShadowColor(int i) {
        this.f43217e = i;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m32357a(this.f43213a.getWidth(), this.f43213a.getHeight());
    }

    /* renamed from: a */
    private void m32357a(int i, int i2) {
        if (this.f43215c) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(m32356a(i, i2, 0.0f, (float) this.f43213a.getPaddingBottom(), (float) this.f43218f, (float) this.f43219g, this.f43217e, 0));
            if (Build.VERSION.SDK_INT <= 16) {
                this.f43213a.setBackgroundDrawable(bitmapDrawable);
            } else {
                this.f43213a.setBackground(bitmapDrawable);
            }
        }
    }

    /* renamed from: a */
    private Bitmap m32356a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF((float) this.f43213a.getPaddingLeft(), (float) ((i2 - this.f43213a.getPaddingBottom()) - (((i2 - this.f43213a.getPaddingTop()) - this.f43213a.getPaddingBottom()) / 5)), (float) (i - this.f43213a.getPaddingRight()), (float) (i2 - this.f43213a.getPaddingBottom()));
        this.f43214b.setColor(i4);
        if (!this.f43213a.isInEditMode()) {
            this.f43214b.setShadowLayer(f2, f3, f4, i3);
        }
        float dip2px = (float) dip2px(this.f43213a.getContext(), 20.0f);
        canvas.drawRoundRect(rectF, dip2px, dip2px, this.f43214b);
        return createBitmap;
    }

    public void setShadowLimit(int i) {
        if (this.f43215c) {
            this.f43216d = i;
        }
    }

    public void setShowShadow(boolean z) {
        this.f43215c = z;
    }

    public int getDx() {
        return this.f43218f;
    }

    public void setDx(int i) {
        this.f43218f = i;
    }

    public int getDy() {
        return this.f43219g;
    }

    public void setDy(int i) {
        this.f43219g = i;
    }

    public static int dip2px(Context context, float f) {
        return context == null ? (int) f : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
