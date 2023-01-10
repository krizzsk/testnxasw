package com.didi.entrega.customer.widget;

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
import com.didi.entrega.customer.widget.support.CustomerAppCompatImageView;
import com.didi.passenger.C11267R;

public class CircleImageView extends CustomerAppCompatImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f22102a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f22103b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f22104c = 2;

    /* renamed from: d */
    private static final int f22105d = 0;

    /* renamed from: e */
    private static final int f22106e = -16777216;

    /* renamed from: f */
    private static final int f22107f = 0;

    /* renamed from: g */
    private static final boolean f22108g = false;

    /* renamed from: A */
    private boolean f22109A;

    /* renamed from: h */
    private final RectF f22110h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final RectF f22111i;

    /* renamed from: j */
    private final Matrix f22112j;

    /* renamed from: k */
    private final Paint f22113k;

    /* renamed from: l */
    private final Paint f22114l;

    /* renamed from: m */
    private final Paint f22115m;

    /* renamed from: n */
    private int f22116n;

    /* renamed from: o */
    private int f22117o;

    /* renamed from: p */
    private int f22118p;

    /* renamed from: q */
    private Bitmap f22119q;

    /* renamed from: r */
    private BitmapShader f22120r;

    /* renamed from: s */
    private int f22121s;

    /* renamed from: t */
    private int f22122t;

    /* renamed from: u */
    private float f22123u;

    /* renamed from: v */
    private float f22124v;

    /* renamed from: w */
    private ColorFilter f22125w;

    /* renamed from: x */
    private boolean f22126x;

    /* renamed from: y */
    private boolean f22127y;

    /* renamed from: z */
    private boolean f22128z;

    public CircleImageView(Context context) {
        super(context);
        this.f22110h = new RectF();
        this.f22111i = new RectF();
        this.f22112j = new Matrix();
        this.f22113k = new Paint();
        this.f22114l = new Paint();
        this.f22115m = new Paint();
        this.f22116n = -16777216;
        this.f22117o = 0;
        this.f22118p = 0;
        m18307a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22110h = new RectF();
        this.f22111i = new RectF();
        this.f22112j = new Matrix();
        this.f22113k = new Paint();
        this.f22114l = new Paint();
        this.f22115m = new Paint();
        this.f22116n = -16777216;
        this.f22117o = 0;
        this.f22118p = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaCircleImageView, i, 0);
        this.f22117o = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f22116n = obtainStyledAttributes.getColor(0, -16777216);
        this.f22128z = obtainStyledAttributes.getBoolean(1, false);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f22118p = obtainStyledAttributes.getColor(3, 0);
        }
        obtainStyledAttributes.recycle();
        m18307a();
    }

    public int getBorderColor() {
        return this.f22116n;
    }

    public void setBorderColor(int i) {
        if (i != this.f22116n) {
            this.f22116n = i;
            this.f22114l.setColor(i);
            invalidate();
        }
    }

    public int getBorderWidth() {
        return this.f22117o;
    }

    public void setBorderWidth(int i) {
        if (i != this.f22117o) {
            this.f22117o = i;
            m18310d();
        }
    }

    public int getCircleBackgroundColor() {
        return this.f22118p;
    }

    public void setCircleBackgroundColor(int i) {
        if (i != this.f22118p) {
            this.f22118p = i;
            this.f22115m.setColor(i);
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f22125w;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f22125w) {
            this.f22125w = colorFilter;
            m18308b();
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
        return f22102a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f22102a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public boolean isBorderOverlay() {
        return this.f22128z;
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f22128z) {
            this.f22128z = z;
            m18310d();
        }
    }

    public boolean isDisableCircularTransformation() {
        return this.f22109A;
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.f22109A != z) {
            this.f22109A = z;
            m18309c();
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
        m18309c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m18309c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m18309c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m18309c();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        m18310d();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        m18310d();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f22109A) {
            super.onDraw(canvas);
        } else if (this.f22119q != null) {
            if (this.f22118p != 0) {
                canvas.drawCircle(this.f22110h.centerX(), this.f22110h.centerY(), this.f22123u, this.f22115m);
            }
            canvas.drawCircle(this.f22110h.centerX(), this.f22110h.centerY(), this.f22123u, this.f22113k);
            if (this.f22117o > 0) {
                canvas.drawCircle(this.f22111i.centerX(), this.f22111i.centerY(), this.f22124v, this.f22114l);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m18310d();
    }

    /* renamed from: a */
    private void m18307a() {
        super.setScaleType(f22102a);
        this.f22126x = true;
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new OutlineProvider());
        }
        if (this.f22127y) {
            m18310d();
            this.f22127y = false;
        }
    }

    /* renamed from: b */
    private void m18308b() {
        Paint paint = this.f22113k;
        if (paint != null) {
            paint.setColorFilter(this.f22125w);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        r1 = (android.graphics.drawable.TransitionDrawable) r7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m18305a(android.graphics.drawable.Drawable r7) {
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
            android.graphics.Bitmap$Config r1 = f22103b     // Catch:{ Exception -> 0x0055 }
            r2 = 2
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r2, r2, r1)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0040
        L_0x0032:
            int r1 = r7.getIntrinsicWidth()     // Catch:{ Exception -> 0x0055 }
            int r2 = r7.getIntrinsicHeight()     // Catch:{ Exception -> 0x0055 }
            android.graphics.Bitmap$Config r3 = f22103b     // Catch:{ Exception -> 0x0055 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.widget.CircleImageView.m18305a(android.graphics.drawable.Drawable):android.graphics.Bitmap");
    }

    /* renamed from: c */
    private void m18309c() {
        if (this.f22109A) {
            this.f22119q = null;
        } else {
            this.f22119q = m18305a(getDrawable());
        }
        m18310d();
    }

    /* renamed from: d */
    private void m18310d() {
        int i;
        if (!this.f22126x) {
            this.f22127y = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f22119q == null) {
                invalidate();
                return;
            }
            this.f22120r = new BitmapShader(this.f22119q, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f22113k.setAntiAlias(true);
            this.f22113k.setShader(this.f22120r);
            this.f22114l.setStyle(Paint.Style.STROKE);
            this.f22114l.setAntiAlias(true);
            this.f22114l.setColor(this.f22116n);
            this.f22114l.setStrokeWidth((float) this.f22117o);
            this.f22115m.setStyle(Paint.Style.FILL);
            this.f22115m.setAntiAlias(true);
            this.f22115m.setColor(this.f22118p);
            this.f22122t = this.f22119q.getHeight();
            this.f22121s = this.f22119q.getWidth();
            this.f22111i.set(m18311e());
            this.f22124v = Math.min((this.f22111i.height() - ((float) this.f22117o)) / 2.0f, (this.f22111i.width() - ((float) this.f22117o)) / 2.0f);
            this.f22110h.set(this.f22111i);
            if (!this.f22128z && (i = this.f22117o) > 0) {
                this.f22110h.inset(((float) i) - 1.0f, ((float) i) - 1.0f);
            }
            this.f22123u = Math.min(this.f22110h.height() / 2.0f, this.f22110h.width() / 2.0f);
            m18308b();
            m18312f();
            invalidate();
        }
    }

    /* renamed from: e */
    private RectF m18311e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    /* renamed from: f */
    private void m18312f() {
        float f;
        float f2;
        this.f22112j.set((Matrix) null);
        float f3 = 0.0f;
        if (((float) this.f22121s) * this.f22110h.height() > this.f22110h.width() * ((float) this.f22122t)) {
            f2 = this.f22110h.height() / ((float) this.f22122t);
            f3 = (this.f22110h.width() - (((float) this.f22121s) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.f22110h.width() / ((float) this.f22121s);
            f = (this.f22110h.height() - (((float) this.f22122t) * f2)) * 0.5f;
        }
        this.f22112j.setScale(f2, f2);
        this.f22112j.postTranslate(((float) ((int) (f3 + 0.5f))) + this.f22110h.left, ((float) ((int) (f + 0.5f))) + this.f22110h.top);
        this.f22120r.setLocalMatrix(this.f22112j);
    }

    private class OutlineProvider extends ViewOutlineProvider {
        private OutlineProvider() {
        }

        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.f22111i.roundOut(rect);
            outline.setRoundRect(rect, ((float) rect.width()) / 2.0f);
        }
    }
}
