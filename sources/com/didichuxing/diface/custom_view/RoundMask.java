package com.didichuxing.diface.custom_view;

import android.animation.ValueAnimator;
import android.content.Context;
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
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.didichuxing.diface.utils.DisplayUtils;
import com.taxis99.R;

public class RoundMask extends View {

    /* renamed from: o */
    private static final int f50083o = -657931;

    /* renamed from: p */
    private static final int f50084p = -13399809;

    /* renamed from: a */
    private Paint f50085a;

    /* renamed from: b */
    private int f50086b;

    /* renamed from: c */
    private int f50087c;

    /* renamed from: d */
    private RectF f50088d;

    /* renamed from: e */
    private PorterDuffXfermode f50089e;

    /* renamed from: f */
    private int f50090f;

    /* renamed from: g */
    private Path f50091g;

    /* renamed from: h */
    private Rect f50092h;

    /* renamed from: i */
    private ValueAnimator f50093i;

    /* renamed from: j */
    private Bitmap f50094j;

    /* renamed from: k */
    private int f50095k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f50096l;

    /* renamed from: m */
    private boolean f50097m;

    /* renamed from: n */
    private boolean f50098n;

    /* renamed from: q */
    private int f50099q = 70;

    public RoundMask(Context context) {
        super(context);
        m37461a();
    }

    /* renamed from: a */
    private void m37461a() {
        this.f50086b = DisplayUtils.dip2px(getContext(), 10.0f);
        this.f50087c = DisplayUtils.dip2px(getContext(), 4.0f);
        this.f50085a = new Paint(1);
        this.f50089e = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.df_face_gradient_rect_area);
        this.f50094j = decodeResource;
        int height = decodeResource.getHeight();
        this.f50095k = height;
        this.f50096l = (-height) / 3;
    }

    public void setProgress(int i) {
        if (i < 0) {
            this.f50090f = 0;
        } else if (i > 100) {
            this.f50090f = 100;
        } else {
            this.f50090f = i;
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = getWidth();
        int height = getHeight();
        this.f50085a.setColor(-1);
        canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.f50085a);
        int i = width / 2;
        int i2 = i - this.f50086b;
        this.f50085a.setXfermode(this.f50089e);
        this.f50085a.setColor(-65536);
        float f = (float) i;
        float f2 = (float) (height / 2);
        float f3 = (float) i2;
        canvas2.drawCircle(f, f2, f3, this.f50085a);
        this.f50085a.setXfermode((Xfermode) null);
        if (this.f50088d == null) {
            this.f50088d = new RectF((float) (this.f50087c / 2), (float) ((((getHeight() / 2) - i2) - this.f50086b) + (this.f50087c / 2)), (float) (getWidth() - (this.f50087c / 2)), (float) ((((getHeight() / 2) + i2) + this.f50086b) - (this.f50087c / 2)));
        }
        this.f50085a.setColor(f50083o);
        this.f50085a.setStyle(Paint.Style.STROKE);
        this.f50085a.setStrokeWidth((float) this.f50087c);
        float f4 = (float) 90;
        float f5 = (float) 360;
        canvas.drawArc(this.f50088d, f4, f5, false, this.f50085a);
        if (this.f50090f != 0) {
            this.f50085a.setColor(f50084p);
            canvas.drawArc(this.f50088d, f4, (float) ((int) ((((float) this.f50090f) / 100.0f) * f5)), false, this.f50085a);
        }
        if (this.f50098n) {
            if (this.f50091g == null) {
                Path path = new Path();
                this.f50091g = path;
                path.addCircle(f, f2, f3, Path.Direction.CCW);
            }
            Rect rect = this.f50092h;
            if (rect == null) {
                int i3 = this.f50096l;
                this.f50092h = new Rect(0, i3, width, this.f50095k + i3);
            } else {
                rect.top = this.f50096l;
                this.f50092h.bottom = this.f50096l + this.f50095k;
            }
            canvas2.clipRect(this.f50092h);
            canvas2.clipPath(this.f50091g, Region.Op.INTERSECT);
            canvas2.drawBitmap(this.f50094j, (Rect) null, this.f50092h, this.f50085a);
            if (this.f50093i == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f50096l, (width - this.f50095k) + 200});
                this.f50093i = ofInt;
                ofInt.setRepeatCount(-1);
                this.f50093i.setRepeatMode(1);
                this.f50093i.setInterpolator(new LinearInterpolator());
                this.f50093i.setDuration(3000);
                this.f50093i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int unused = RoundMask.this.f50096l = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        RoundMask.this.postInvalidate();
                    }
                });
                this.f50093i.start();
            }
        }
        this.f50085a.reset();
    }

    /* renamed from: b */
    private void m37462b() {
        int i = this.f50099q - 5;
        this.f50099q = i;
        if (((float) i) <= 10.0f) {
            this.f50099q = 70;
        }
        postDelayed(new Runnable() {
            public void run() {
                RoundMask.this.invalidate();
            }
        }, 200);
    }

    public void onFaceOk() {
        this.f50098n = true;
        invalidate();
    }

    public void cancelRectAnim() {
        this.f50096l = (-this.f50095k) / 3;
        this.f50098n = false;
        ValueAnimator valueAnimator = this.f50093i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f50097m = true;
            this.f50093i = null;
            invalidate();
        }
    }
}
