package com.didi.beatles.p101im.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.didi.beatles.p101im.views.imageView.IMNetworkImageView;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.beatles.im.views.IMBezelImageView */
public class IMBezelImageView extends IMNetworkImageView {

    /* renamed from: a */
    private Paint f11683a;

    /* renamed from: b */
    private Paint f11684b;

    /* renamed from: c */
    private Rect f11685c;

    /* renamed from: d */
    private RectF f11686d;

    /* renamed from: e */
    private Drawable f11687e;

    /* renamed from: f */
    private Drawable f11688f;

    /* renamed from: g */
    private ColorMatrixColorFilter f11689g;

    /* renamed from: h */
    private boolean f11690h;

    /* renamed from: i */
    private boolean f11691i;

    /* renamed from: j */
    private Bitmap f11692j;

    /* renamed from: k */
    private int f11693k;

    /* renamed from: l */
    private int f11694l;

    public IMBezelImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBezelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMBezelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11690h = false;
        this.f11691i = false;
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(2, (Paint) null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.IMBezelImageView, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        this.f11688f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
        this.f11687e = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.f11690h = obtainStyledAttributes.getBoolean(1, this.f11690h);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f11683a = paint;
        paint.setColor(-16777216);
        Paint paint2 = new Paint();
        this.f11684b = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f11692j = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        if (this.f11690h) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            this.f11689g = new ColorMatrixColorFilter(colorMatrix);
        }
    }

    /* access modifiers changed from: protected */
    public void setMaskDrawable(Drawable drawable) {
        this.f11688f = drawable;
        drawable.setCallback(this);
    }

    /* access modifiers changed from: protected */
    public void setBorderDrawable(Drawable drawable) {
        this.f11687e = drawable;
        drawable.setCallback(this);
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.f11685c = new Rect(0, 0, i3 - i, i4 - i2);
        this.f11686d = new RectF(this.f11685c);
        Drawable drawable = this.f11687e;
        if (drawable != null) {
            drawable.setBounds(this.f11685c);
        }
        Drawable drawable2 = this.f11688f;
        if (drawable2 != null) {
            drawable2.setBounds(this.f11685c);
        }
        if (frame) {
            this.f11691i = false;
        }
        return frame;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Rect rect = this.f11685c;
        if (rect != null) {
            int width = rect.width();
            int height = this.f11685c.height();
            if (width != 0 && height != 0 && this.f11692j != null) {
                if (!(this.f11691i && width == this.f11693k && height == this.f11694l)) {
                    if (width == this.f11693k && height == this.f11694l) {
                        this.f11692j.eraseColor(0);
                    } else {
                        Bitmap bitmap = this.f11692j;
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        try {
                            this.f11692j = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                            this.f11693k = width;
                            this.f11694l = height;
                        } catch (OutOfMemoryError unused) {
                            return;
                        }
                    }
                    if (this.f11692j != null) {
                        Canvas canvas2 = new Canvas(this.f11692j);
                        if (this.f11688f != null) {
                            int save = canvas2.save();
                            this.f11688f.draw(canvas2);
                            this.f11684b.setColorFilter((!this.f11690h || !isPressed()) ? null : this.f11689g);
                            SystemUtils.saveLayer(canvas2, this.f11686d, this.f11684b, 31);
                            super.onDraw(canvas2);
                            canvas2.restoreToCount(save);
                        } else if (!this.f11690h || !isPressed()) {
                            super.onDraw(canvas2);
                        } else {
                            int save2 = canvas2.save();
                            canvas2.drawRect(0.0f, 0.0f, (float) this.f11693k, (float) this.f11694l, this.f11683a);
                            this.f11684b.setColorFilter(this.f11689g);
                            SystemUtils.saveLayer(canvas2, this.f11686d, this.f11684b, 31);
                            super.onDraw(canvas2);
                            canvas2.restoreToCount(save2);
                        }
                        Drawable drawable = this.f11687e;
                        if (drawable != null) {
                            drawable.draw(canvas2);
                        }
                    } else {
                        return;
                    }
                }
                canvas.drawBitmap(this.f11692j, (float) this.f11685c.left, (float) this.f11685c.top, (Paint) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f11687e;
        if (drawable != null && drawable.isStateful()) {
            this.f11687e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f11688f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f11688f.setState(getDrawableState());
        }
        if (isDuplicateParentStateEnabled()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.f11687e || drawable == this.f11688f) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f11687e || drawable == this.f11688f || super.verifyDrawable(drawable);
    }
}
