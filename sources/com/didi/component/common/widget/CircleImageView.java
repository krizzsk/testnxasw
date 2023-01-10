package com.didi.component.common.widget;

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

public class CircleImageView extends ImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f13776a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f13777b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f13778c = 2;

    /* renamed from: d */
    private static final int f13779d = 0;

    /* renamed from: e */
    private static final int f13780e = -16777216;

    /* renamed from: f */
    private static final int f13781f = 0;

    /* renamed from: g */
    private static final boolean f13782g = false;

    /* renamed from: h */
    private final RectF f13783h = new RectF();

    /* renamed from: i */
    private final RectF f13784i = new RectF();

    /* renamed from: j */
    private final Matrix f13785j = new Matrix();

    /* renamed from: k */
    private final Paint f13786k = new Paint();

    /* renamed from: l */
    private final Paint f13787l = new Paint();

    /* renamed from: m */
    private final Paint f13788m = new Paint();

    /* renamed from: n */
    private int f13789n = -16777216;

    /* renamed from: o */
    private int f13790o = 0;

    /* renamed from: p */
    private int f13791p = 0;

    /* renamed from: q */
    private Bitmap f13792q;

    /* renamed from: r */
    private BitmapShader f13793r;

    /* renamed from: s */
    private int f13794s;

    /* renamed from: t */
    private int f13795t;

    /* renamed from: u */
    private float f13796u;

    /* renamed from: v */
    private float f13797v;

    /* renamed from: w */
    private ColorFilter f13798w;

    /* renamed from: x */
    private boolean f13799x;

    /* renamed from: y */
    private boolean f13800y;

    /* renamed from: z */
    private boolean f13801z;

    public CircleImageView(Context context) {
        super(context);
        m11451a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CircleImageView, 0, 0);
        this.f13790o = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f13789n = obtainStyledAttributes.getColor(0, -16777216);
        this.f13801z = obtainStyledAttributes.getBoolean(1, false);
        this.f13791p = obtainStyledAttributes.getColor(4, 0);
        obtainStyledAttributes.recycle();
        m11451a();
    }

    /* renamed from: a */
    private void m11451a() {
        super.setScaleType(f13776a);
        this.f13799x = true;
        if (this.f13800y) {
            m11452b();
            this.f13800y = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return f13776a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f13776a) {
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
        if (this.f13792q != null) {
            if (this.f13791p != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f13796u, this.f13788m);
            }
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f13796u, this.f13786k);
            if (this.f13790o != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f13797v, this.f13787l);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m11452b();
    }

    public int getBorderColor() {
        return this.f13789n;
    }

    public void setBorderColor(int i) {
        if (i != this.f13789n) {
            this.f13789n = i;
            this.f13787l.setColor(i);
            invalidate();
        }
    }

    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public int getFillColor() {
        return this.f13791p;
    }

    public void setFillColor(int i) {
        if (i != this.f13791p) {
            this.f13791p = i;
            this.f13788m.setColor(i);
            invalidate();
        }
    }

    public void setFillColorResource(int i) {
        setFillColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.f13790o;
    }

    public void setBorderWidth(int i) {
        if (i != this.f13790o) {
            this.f13790o = i;
            m11452b();
        }
    }

    public boolean isBorderOverlay() {
        return this.f13801z;
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f13801z) {
            this.f13801z = z;
            m11452b();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f13792q = bitmap;
        m11452b();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f13792q = m11450a(drawable);
        m11452b();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f13792q = m11450a(getDrawable());
        m11452b();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f13792q = uri != null ? m11450a(getDrawable()) : null;
        m11452b();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f13798w) {
            this.f13798w = colorFilter;
            this.f13786k.setColorFilter(colorFilter);
            invalidate();
        }
    }

    /* renamed from: a */
    private Bitmap m11450a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, f13777b);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f13777b);
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

    /* renamed from: b */
    private void m11452b() {
        if (!this.f13799x) {
            this.f13800y = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f13792q == null) {
                invalidate();
                return;
            }
            this.f13793r = new BitmapShader(this.f13792q, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f13786k.setAntiAlias(true);
            this.f13786k.setShader(this.f13793r);
            this.f13787l.setStyle(Paint.Style.STROKE);
            this.f13787l.setAntiAlias(true);
            this.f13787l.setColor(this.f13789n);
            this.f13787l.setStrokeWidth((float) this.f13790o);
            this.f13788m.setStyle(Paint.Style.FILL);
            this.f13788m.setAntiAlias(true);
            this.f13788m.setColor(this.f13791p);
            this.f13795t = this.f13792q.getHeight();
            this.f13794s = this.f13792q.getWidth();
            this.f13784i.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f13797v = Math.min((this.f13784i.height() - ((float) this.f13790o)) / 2.0f, (this.f13784i.width() - ((float) this.f13790o)) / 2.0f);
            this.f13783h.set(this.f13784i);
            if (!this.f13801z) {
                RectF rectF = this.f13783h;
                int i = this.f13790o;
                rectF.inset((float) i, (float) i);
            }
            this.f13796u = Math.min(this.f13783h.height() / 2.0f, this.f13783h.width() / 2.0f);
            m11453c();
            invalidate();
        }
    }

    /* renamed from: c */
    private void m11453c() {
        float f;
        float f2;
        this.f13785j.set((Matrix) null);
        float f3 = 0.0f;
        if (((float) this.f13794s) * this.f13783h.height() > this.f13783h.width() * ((float) this.f13795t)) {
            f2 = this.f13783h.height() / ((float) this.f13795t);
            f3 = (this.f13783h.width() - (((float) this.f13794s) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.f13783h.width() / ((float) this.f13794s);
            f = (this.f13783h.height() - (((float) this.f13795t) * f2)) * 0.5f;
        }
        this.f13785j.setScale(f2, f2);
        this.f13785j.postTranslate(((float) ((int) (f3 + 0.5f))) + this.f13783h.left, ((float) ((int) (f + 0.5f))) + this.f13783h.top);
        this.f13793r.setLocalMatrix(this.f13785j);
    }
}
