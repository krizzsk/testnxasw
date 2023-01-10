package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.MathUtils;
import com.didichuxing.diface.utils.DisplayUtils;
import com.taxis99.R;

public class RoundMaskLiveness extends View {

    /* renamed from: w */
    private static final int f49908w = -657931;

    /* renamed from: x */
    private static int f49909x = -13399809;

    /* renamed from: a */
    private Paint f49910a;

    /* renamed from: b */
    private int f49911b;

    /* renamed from: c */
    private RectF f49912c;

    /* renamed from: d */
    private PorterDuffXfermode f49913d;

    /* renamed from: e */
    private int f49914e;

    /* renamed from: f */
    private Bitmap f49915f;

    /* renamed from: g */
    private int f49916g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f49917h;

    /* renamed from: i */
    private Rect f49918i;

    /* renamed from: j */
    private ValueAnimator f49919j;

    /* renamed from: k */
    private boolean f49920k;

    /* renamed from: l */
    private boolean f49921l;

    /* renamed from: m */
    private final int f49922m = DisplayUtils.dip2px(getContext(), 10.0f);

    /* renamed from: n */
    private Path f49923n;

    /* renamed from: o */
    private String f49924o = "";

    /* renamed from: p */
    private int f49925p = -1;

    /* renamed from: q */
    private int f49926q = 1719960708;

    /* renamed from: r */
    private int f49927r;

    /* renamed from: s */
    private int f49928s;

    /* renamed from: t */
    private Rect f49929t;

    /* renamed from: u */
    private int f49930u = -1;

    /* renamed from: v */
    private Context f49931v;

    /* renamed from: y */
    private int f49932y = 70;

    public RoundMaskLiveness(Context context) {
        super(context);
        this.f49931v = context;
        m37373a();
    }

    public RoundMaskLiveness(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49931v = context;
        m37373a();
    }

    /* renamed from: a */
    private void m37373a() {
        f49909x = -13399809;
        this.f49911b = DisplayUtils.dip2px(getContext(), 5.0f);
        this.f49910a = new Paint(1);
        this.f49913d = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.df_face_gradient_rect_area);
        this.f49915f = decodeResource;
        int height = decodeResource.getHeight();
        this.f49916g = height;
        this.f49917h = (-height) / 3;
        this.f49927r = DisplayUtils.dip2px(getContext(), 17.0f);
        this.f49928s = DisplayUtils.dip2px(getContext(), 12.0f);
        this.f49929t = new Rect();
    }

    public void setProgress(int i) {
        this.f49914e = MathUtils.clamp(i, 0, 100);
        invalidate();
    }

    public void setHintMessage(String str) {
        this.f49924o = str;
        postInvalidate();
    }

    public void setHintMessage(int i) {
        try {
            this.f49924o = getResources().getString(i);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        this.f49910a.setColor(this.f49930u);
        int i = width / 2;
        int i2 = i - this.f49922m;
        float f = (float) i;
        float f2 = (float) i2;
        canvas2.drawCircle(f, f, f2, this.f49910a);
        this.f49910a.setXfermode(this.f49913d);
        canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.f49910a);
        this.f49910a.setXfermode((Xfermode) null);
        if (this.f49912c == null) {
            int i3 = this.f49911b;
            int i4 = this.f49922m;
            this.f49912c = new RectF((float) (i3 / 2), (float) (((i - i2) - i4) + (i3 / 2)), (float) (width - (i3 / 2)), (float) (((i + i2) + i4) - (i3 / 2)));
        }
        mo122882a(canvas2, i2);
        this.f49910a.setColor(f49908w);
        this.f49910a.setStyle(Paint.Style.STROKE);
        this.f49910a.setStrokeWidth((float) this.f49911b);
        float f3 = (float) 90;
        float f4 = (float) 360;
        canvas.drawArc(this.f49912c, f3, f4, false, this.f49910a);
        if (this.f49914e != 0) {
            this.f49910a.setColor(f49909x);
            this.f49910a.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawArc(this.f49912c, f3, (float) ((int) ((((float) this.f49914e) / 100.0f) * f4)), false, this.f49910a);
        }
        if (this.f49921l && !this.f49920k) {
            if (this.f49923n == null) {
                Path path = new Path();
                this.f49923n = path;
                path.addCircle(f, f, f2, Path.Direction.CCW);
            }
            Rect rect = this.f49918i;
            if (rect == null) {
                int i5 = this.f49917h;
                this.f49918i = new Rect(0, i5, width, this.f49916g + i5);
            } else {
                rect.top = this.f49917h;
                this.f49918i.bottom = this.f49917h + this.f49916g;
            }
            LogUtils.m37051d("progress 100, rectStartY===" + this.f49917h);
            canvas2.clipRect(this.f49918i);
            canvas2.clipPath(this.f49923n, Region.Op.INTERSECT);
            canvas2.drawBitmap(this.f49915f, (Rect) null, this.f49918i, this.f49910a);
            if (this.f49919j == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f49917h, width - this.f49916g});
                this.f49919j = ofInt;
                ofInt.setRepeatCount(-1);
                this.f49919j.setRepeatMode(1);
                this.f49919j.setInterpolator(new LinearInterpolator());
                this.f49919j.setDuration(3000);
                this.f49919j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int unused = RoundMaskLiveness.this.f49917h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        RoundMaskLiveness.this.postInvalidate();
                    }
                });
                this.f49919j.start();
            }
        }
        this.f49910a.reset();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo122882a(Canvas canvas, int i) {
        if (!TextUtils.isEmpty(this.f49924o)) {
            this.f49910a.setStrokeJoin(Paint.Join.BEVEL);
            this.f49910a.setStyle(Paint.Style.FILL);
            this.f49910a.setColor(this.f49926q);
            this.f49910a.setTextSize((float) this.f49927r);
            Paint paint = this.f49910a;
            String str = this.f49924o;
            paint.getTextBounds(str, 0, str.length(), this.f49929t);
            double d = (double) i;
            int sin = (int) (((Math.sin(1.0471975511965976d) * d) * 3.0d) / 2.0d);
            int cos = (int) (d - (Math.cos(1.0471975511965976d) * d));
            if (this.f49929t.width() > sin) {
                this.f49910a.setTextSize((float) this.f49928s);
                Paint paint2 = this.f49910a;
                String str2 = this.f49924o;
                paint2.getTextBounds(str2, 0, str2.length(), this.f49929t);
            }
            canvas.drawArc(this.f49912c, 210.0f, 120.0f, false, this.f49910a);
            this.f49910a.setColor(this.f49925p);
            this.f49910a.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f49924o, this.f49912c.width() / 2.0f, (float) (((cos * 2) / 3) + (this.f49911b / 2) + (this.f49929t.height() / 2)), this.f49910a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo122881a(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-13244);
        canvas.drawBitmap(this.f49915f, (Rect) null, this.f49918i, paint);
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Bitmap mo122883b(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-10048769);
        float f = (float) (i / 2);
        canvas.drawCircle(f, f, f, paint);
        return createBitmap;
    }

    public void onFaceOk() {
        this.f49921l = true;
        invalidate();
    }

    public void cancelRectAnim() {
        ValueAnimator valueAnimator = this.f49919j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f49920k = true;
            this.f49919j = null;
            invalidate();
        }
    }

    public void resetRectAnim() {
        this.f49917h = (-this.f49916g) / 3;
        this.f49920k = false;
        this.f49921l = false;
    }

    /* renamed from: b */
    private void m37374b() {
        int i = this.f49932y - 5;
        this.f49932y = i;
        if (((float) i) <= 10.0f) {
            this.f49932y = 70;
        }
        postDelayed(new Runnable() {
            public void run() {
                RoundMaskLiveness.this.invalidate();
            }
        }, 200);
    }

    public void updateStatus(int i, int i2) {
        this.f49930u = i;
        this.f49914e = i2;
        invalidate();
    }
}
