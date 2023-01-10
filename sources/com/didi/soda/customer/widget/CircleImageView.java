package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.widget.support.CustomerAppCompatImageView;

public class CircleImageView extends CustomerAppCompatImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f44036a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f44037b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f44038c = 2;

    /* renamed from: d */
    private static final int f44039d = 0;

    /* renamed from: e */
    private static final int f44040e = -16777216;

    /* renamed from: f */
    private static final int f44041f = 0;

    /* renamed from: g */
    private static final boolean f44042g = false;

    /* renamed from: A */
    private boolean f44043A;

    /* renamed from: h */
    private final RectF f44044h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final RectF f44045i;

    /* renamed from: j */
    private final Matrix f44046j;

    /* renamed from: k */
    private final Paint f44047k;

    /* renamed from: l */
    private final Paint f44048l;

    /* renamed from: m */
    private final Paint f44049m;

    /* renamed from: n */
    private int f44050n;

    /* renamed from: o */
    private int f44051o;

    /* renamed from: p */
    private int f44052p;

    /* renamed from: q */
    private Bitmap f44053q;

    /* renamed from: r */
    private BitmapShader f44054r;

    /* renamed from: s */
    private int f44055s;

    /* renamed from: t */
    private int f44056t;

    /* renamed from: u */
    private float f44057u;

    /* renamed from: v */
    private float f44058v;

    /* renamed from: w */
    private ColorFilter f44059w;

    /* renamed from: x */
    private boolean f44060x;

    /* renamed from: y */
    private boolean f44061y;

    /* renamed from: z */
    private boolean f44062z;

    public CircleImageView(Context context) {
        super(context);
        this.f44044h = new RectF();
        this.f44045i = new RectF();
        this.f44046j = new Matrix();
        this.f44047k = new Paint();
        this.f44048l = new Paint();
        this.f44049m = new Paint();
        this.f44050n = -16777216;
        this.f44051o = 0;
        this.f44052p = 0;
        m32824a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44044h = new RectF();
        this.f44045i = new RectF();
        this.f44046j = new Matrix();
        this.f44047k = new Paint();
        this.f44048l = new Paint();
        this.f44049m = new Paint();
        this.f44050n = -16777216;
        this.f44051o = 0;
        this.f44052p = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CircleImageView, i, 0);
        this.f44051o = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f44050n = obtainStyledAttributes.getColor(0, -16777216);
        this.f44062z = obtainStyledAttributes.getBoolean(1, false);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f44052p = obtainStyledAttributes.getColor(3, 0);
        }
        obtainStyledAttributes.recycle();
        m32824a();
    }

    public int getBorderColor() {
        return this.f44050n;
    }

    public void setBorderColor(int i) {
        if (i != this.f44050n) {
            this.f44050n = i;
            this.f44048l.setColor(i);
            invalidate();
        }
    }

    public int getBorderWidth() {
        return this.f44051o;
    }

    public void setBorderWidth(int i) {
        if (i != this.f44051o) {
            this.f44051o = i;
            m32827d();
        }
    }

    public int getCircleBackgroundColor() {
        return this.f44052p;
    }

    public void setCircleBackgroundColor(int i) {
        if (i != this.f44052p) {
            this.f44052p = i;
            this.f44049m.setColor(i);
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f44059w;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f44059w) {
            this.f44059w = colorFilter;
            m32825b();
            invalidate();
        }
    }

    @Deprecated
    public int getFillColor() {
        return getCircleBackgroundColor();
    }

    @Deprecated
    public void setFillColor(int i) {
        setCircleBackgroundColor(i);
    }

    public ImageView.ScaleType getScaleType() {
        return f44036a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f44036a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public boolean isBorderOverlay() {
        return this.f44062z;
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f44062z) {
            this.f44062z = z;
            m32827d();
        }
    }

    public boolean isDisableCircularTransformation() {
        return this.f44043A;
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.f44043A != z) {
            this.f44043A = z;
            m32826c();
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    @Deprecated
    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public void setCircleBackgroundColorResource(int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    @Deprecated
    public void setFillColorResource(int i) {
        setCircleBackgroundColorResource(i);
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m32826c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m32826c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m32826c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m32826c();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        m32827d();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        m32827d();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f44043A) {
            super.onDraw(canvas);
        } else if (this.f44053q != null) {
            if (this.f44052p != 0) {
                canvas.drawCircle(this.f44044h.centerX(), this.f44044h.centerY(), this.f44057u, this.f44049m);
            }
            canvas.drawCircle(this.f44044h.centerX(), this.f44044h.centerY(), this.f44057u, this.f44047k);
            if (this.f44051o > 0) {
                canvas.drawCircle(this.f44045i.centerX(), this.f44045i.centerY(), this.f44058v, this.f44048l);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m32827d();
    }

    /* renamed from: a */
    private void m32824a() {
        super.setScaleType(f44036a);
        this.f44060x = true;
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new OutlineProvider());
        }
        if (this.f44061y) {
            m32827d();
            this.f44061y = false;
        }
    }

    /* renamed from: b */
    private void m32825b() {
        Paint paint = this.f44047k;
        if (paint != null) {
            paint.setColorFilter(this.f44059w);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        r1 = (android.graphics.drawable.TransitionDrawable) r7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m32822a(android.graphics.drawable.Drawable r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof android.graphics.drawable.TransitionDrawable
            if (r1 == 0) goto L_0x001a
            r1 = r7
            android.graphics.drawable.TransitionDrawable r1 = (android.graphics.drawable.TransitionDrawable) r1
            int r2 = r1.getNumberOfLayers()
            if (r2 <= 0) goto L_0x001a
            int r2 = r2 + -1
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            if (r1 == 0) goto L_0x001a
            r7 = r1
        L_0x001a:
            boolean r1 = r7 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L_0x0026
            android.graphics.drawable.BitmapDrawable r7 = (android.graphics.drawable.BitmapDrawable) r7
            android.graphics.Bitmap r7 = r7.getBitmap()
            return r7
        L_0x0026:
            boolean r1 = r7 instanceof android.graphics.drawable.ColorDrawable     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0032
            android.graphics.Bitmap$Config r1 = f44037b     // Catch:{ Exception -> 0x0055 }
            r2 = 2
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r2, r2, r1)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0040
        L_0x0032:
            int r1 = r7.getIntrinsicWidth()     // Catch:{ Exception -> 0x0055 }
            int r2 = r7.getIntrinsicHeight()     // Catch:{ Exception -> 0x0055 }
            android.graphics.Bitmap$Config r3 = f44037b     // Catch:{ Exception -> 0x0055 }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3)     // Catch:{ Exception -> 0x0055 }
        L_0x0040:
            android.graphics.Canvas r2 = new android.graphics.Canvas     // Catch:{ Exception -> 0x0055 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0055 }
            int r3 = r2.getWidth()     // Catch:{ Exception -> 0x0055 }
            int r4 = r2.getHeight()     // Catch:{ Exception -> 0x0055 }
            r5 = 0
            r7.setBounds(r5, r5, r3, r4)     // Catch:{ Exception -> 0x0055 }
            r7.draw(r2)     // Catch:{ Exception -> 0x0055 }
            return r1
        L_0x0055:
            r7 = move-exception
            r7.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.CircleImageView.m32822a(android.graphics.drawable.Drawable):android.graphics.Bitmap");
    }

    /* renamed from: c */
    private void m32826c() {
        if (this.f44043A) {
            this.f44053q = null;
        } else {
            this.f44053q = m32822a(getDrawable());
        }
        m32827d();
    }

    /* renamed from: d */
    private void m32827d() {
        int i;
        if (!this.f44060x) {
            this.f44061y = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f44053q == null) {
                invalidate();
                return;
            }
            this.f44054r = new BitmapShader(this.f44053q, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f44047k.setAntiAlias(true);
            this.f44047k.setShader(this.f44054r);
            this.f44048l.setStyle(Paint.Style.STROKE);
            this.f44048l.setAntiAlias(true);
            this.f44048l.setColor(this.f44050n);
            this.f44048l.setStrokeWidth((float) this.f44051o);
            this.f44049m.setStyle(Paint.Style.FILL);
            this.f44049m.setAntiAlias(true);
            this.f44049m.setColor(this.f44052p);
            this.f44056t = this.f44053q.getHeight();
            this.f44055s = this.f44053q.getWidth();
            this.f44045i.set(m32828e());
            this.f44058v = Math.min((this.f44045i.height() - ((float) this.f44051o)) / 2.0f, (this.f44045i.width() - ((float) this.f44051o)) / 2.0f);
            this.f44044h.set(this.f44045i);
            if (!this.f44062z && (i = this.f44051o) > 0) {
                this.f44044h.inset(((float) i) - 1.0f, ((float) i) - 1.0f);
            }
            this.f44057u = Math.min(this.f44044h.height() / 2.0f, this.f44044h.width() / 2.0f);
            m32825b();
            m32829f();
            invalidate();
        }
    }

    /* renamed from: e */
    private RectF m32828e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    /* renamed from: f */
    private void m32829f() {
        float f;
        float f2;
        this.f44046j.set((Matrix) null);
        float f3 = 0.0f;
        if (((float) this.f44055s) * this.f44044h.height() > this.f44044h.width() * ((float) this.f44056t)) {
            f2 = this.f44044h.height() / ((float) this.f44056t);
            f3 = (this.f44044h.width() - (((float) this.f44055s) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.f44044h.width() / ((float) this.f44055s);
            f = (this.f44044h.height() - (((float) this.f44056t) * f2)) * 0.5f;
        }
        this.f44046j.setScale(f2, f2);
        this.f44046j.postTranslate(((float) ((int) (f3 + 0.5f))) + this.f44044h.left, ((float) ((int) (f + 0.5f))) + this.f44044h.top);
        this.f44054r.setLocalMatrix(this.f44046j);
    }

    private class OutlineProvider extends ViewOutlineProvider {
        private OutlineProvider() {
        }

        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.f44045i.roundOut(rect);
            outline.setRoundRect(rect, ((float) rect.width()) / 2.0f);
        }
    }
}
