package com.didi.component.payentrance.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.didi.passenger.C11267R;

public class DriverIconImageView extends ImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f16814a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f16815b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f16816c = 2;

    /* renamed from: d */
    private static final int f16817d = 0;

    /* renamed from: e */
    private static final int f16818e = -16777216;

    /* renamed from: f */
    private static final int f16819f = 0;

    /* renamed from: g */
    private static final boolean f16820g = false;

    /* renamed from: A */
    private boolean f16821A;

    /* renamed from: h */
    private final RectF f16822h;

    /* renamed from: i */
    private final RectF f16823i;

    /* renamed from: j */
    private final Matrix f16824j;

    /* renamed from: k */
    private final Paint f16825k;

    /* renamed from: l */
    private final Paint f16826l;

    /* renamed from: m */
    private final Paint f16827m;

    /* renamed from: n */
    private int f16828n;

    /* renamed from: o */
    private int f16829o;

    /* renamed from: p */
    private int f16830p;

    /* renamed from: q */
    private Bitmap f16831q;

    /* renamed from: r */
    private BitmapShader f16832r;

    /* renamed from: s */
    private int f16833s;

    /* renamed from: t */
    private int f16834t;

    /* renamed from: u */
    private float f16835u;

    /* renamed from: v */
    private float f16836v;

    /* renamed from: w */
    private ColorFilter f16837w;

    /* renamed from: x */
    private boolean f16838x;

    /* renamed from: y */
    private boolean f16839y;

    /* renamed from: z */
    private boolean f16840z;

    public DriverIconImageView(Context context) {
        super(context);
        this.f16822h = new RectF();
        this.f16823i = new RectF();
        this.f16824j = new Matrix();
        this.f16825k = new Paint();
        this.f16826l = new Paint();
        this.f16827m = new Paint();
        this.f16828n = -16777216;
        this.f16829o = 0;
        this.f16830p = 0;
        m14164a();
    }

    public DriverIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DriverIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16822h = new RectF();
        this.f16823i = new RectF();
        this.f16824j = new Matrix();
        this.f16825k = new Paint();
        this.f16826l = new Paint();
        this.f16827m = new Paint();
        this.f16828n = -16777216;
        this.f16829o = 0;
        this.f16830p = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.DriverIconImageView, i, 0);
        this.f16829o = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f16828n = obtainStyledAttributes.getColor(0, -16777216);
        this.f16840z = obtainStyledAttributes.getBoolean(1, false);
        this.f16830p = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
        m14164a();
    }

    /* renamed from: a */
    private void m14164a() {
        super.setScaleType(f16814a);
        this.f16838x = true;
        if (this.f16839y) {
            m14167d();
            this.f16839y = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return f16814a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f16814a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f16821A) {
            super.onDraw(canvas);
        } else if (this.f16831q != null) {
            if (this.f16830p != 0) {
                canvas.drawCircle(this.f16822h.centerX(), this.f16822h.centerY(), this.f16835u, this.f16827m);
            }
            canvas.drawCircle(this.f16822h.centerX(), this.f16822h.centerY(), this.f16835u, this.f16825k);
            if (this.f16829o > 0) {
                canvas.drawCircle(this.f16823i.centerX(), this.f16823i.centerY(), this.f16836v, this.f16826l);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m14167d();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        m14167d();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        m14167d();
    }

    public int getBorderColor() {
        return this.f16828n;
    }

    public void setBorderColor(int i) {
        if (i != this.f16828n) {
            this.f16828n = i;
            this.f16826l.setColor(i);
            invalidate();
        }
    }

    @Deprecated
    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    @Deprecated
    public int getFillColor() {
        return this.f16830p;
    }

    @Deprecated
    public void setFillColor(int i) {
        if (i != this.f16830p) {
            this.f16830p = i;
            this.f16827m.setColor(i);
            invalidate();
        }
    }

    @Deprecated
    public void setFillColorResource(int i) {
        setFillColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.f16829o;
    }

    public void setBorderWidth(int i) {
        if (i != this.f16829o) {
            this.f16829o = i;
            m14167d();
        }
    }

    public boolean isBorderOverlay() {
        return this.f16840z;
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f16840z) {
            this.f16840z = z;
            m14167d();
        }
    }

    public boolean isDisableCircularTransformation() {
        return this.f16821A;
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.f16821A != z) {
            this.f16821A = z;
            m14166c();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m14166c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m14166c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m14166c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m14166c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f16837w) {
            this.f16837w = colorFilter;
            m14165b();
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f16837w;
    }

    /* renamed from: b */
    private void m14165b() {
        Paint paint = this.f16825k;
        if (paint != null) {
            paint.setColorFilter(this.f16837w);
        }
    }

    /* renamed from: a */
    private Bitmap m14163a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, f16815b);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f16815b);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private void m14166c() {
        if (this.f16821A) {
            this.f16831q = null;
        } else {
            this.f16831q = m14163a(getDrawable());
        }
        m14167d();
    }

    /* renamed from: d */
    private void m14167d() {
        int i;
        if (!this.f16838x) {
            this.f16839y = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f16831q == null) {
                invalidate();
                return;
            }
            this.f16832r = new BitmapShader(this.f16831q, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f16825k.setAntiAlias(true);
            this.f16825k.setShader(this.f16832r);
            this.f16826l.setStyle(Paint.Style.STROKE);
            this.f16826l.setAntiAlias(true);
            this.f16826l.setColor(this.f16828n);
            this.f16826l.setStrokeWidth((float) this.f16829o);
            this.f16827m.setStyle(Paint.Style.FILL);
            this.f16827m.setAntiAlias(true);
            this.f16827m.setColor(this.f16830p);
            this.f16834t = this.f16831q.getHeight();
            this.f16833s = this.f16831q.getWidth();
            this.f16823i.set(m14168e());
            this.f16836v = Math.min((this.f16823i.height() - ((float) this.f16829o)) / 2.0f, (this.f16823i.width() - ((float) this.f16829o)) / 2.0f);
            this.f16822h.set(this.f16823i);
            if (!this.f16840z && (i = this.f16829o) > 0) {
                this.f16822h.inset(((float) i) - 1.0f, ((float) i) - 1.0f);
            }
            this.f16835u = Math.min(this.f16822h.height() / 2.0f, this.f16822h.width() / 2.0f);
            m14165b();
            m14169f();
            invalidate();
        }
    }

    /* renamed from: e */
    private RectF m14168e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    /* renamed from: f */
    private void m14169f() {
        float f;
        float f2;
        this.f16824j.set((Matrix) null);
        float f3 = 0.0f;
        if (((float) this.f16833s) * this.f16822h.height() > this.f16822h.width() * ((float) this.f16834t)) {
            f2 = this.f16822h.height() / ((float) this.f16834t);
            f3 = (this.f16822h.width() - (((float) this.f16833s) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.f16822h.width() / ((float) this.f16833s);
            f = (this.f16822h.height() - (((float) this.f16834t) * f2)) * 0.5f;
        }
        this.f16824j.setScale(f2, f2);
        this.f16824j.postTranslate(((float) ((int) (f3 + 0.5f))) + this.f16822h.left, ((float) ((int) (f + 0.5f))) + this.f16822h.top);
        this.f16832r.setLocalMatrix(this.f16824j);
    }
}
