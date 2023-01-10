package com.didi.sdk.weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ShadowImageView extends ImageView {

    /* renamed from: a */
    private Paint f41224a = new Paint();

    /* renamed from: b */
    private int f41225b;

    public ShadowImageView(Context context) {
        super(context);
        m30964a();
    }

    public ShadowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30964a();
    }

    public ShadowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30964a();
    }

    /* renamed from: a */
    private void m30964a() {
        setLayerType(1, (Paint) null);
        this.f41224a.setAntiAlias(true);
        this.f41224a.setStyle(Paint.Style.FILL);
        this.f41225b = Color.parseColor("#1A294766");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m30965a(getWidth(), getHeight());
    }

    /* renamed from: a */
    private void m30965a(int i, int i2) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(m30963a(i, i2, this.f41225b, 0));
        if (Build.VERSION.SDK_INT <= 16) {
            setBackgroundDrawable(bitmapDrawable);
        } else {
            setBackground(bitmapDrawable);
        }
    }

    /* renamed from: a */
    private Bitmap m30963a(int i, int i2, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        this.f41224a.setAntiAlias(true);
        this.f41224a.setColor(i4);
        if (!isInEditMode()) {
            this.f41224a.setShadowLayer(((float) getPaddingBottom()) * 0.6f, 0.0f, 0.0f, i3);
        }
        canvas.drawCircle((float) ((((i - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft()), (float) ((((i - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingTop()), (float) (((i - getPaddingLeft()) - getPaddingRight()) / 2), this.f41224a);
        return createBitmap;
    }
}
