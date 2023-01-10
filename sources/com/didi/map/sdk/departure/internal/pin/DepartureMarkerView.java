package com.didi.map.sdk.departure.internal.pin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.didi.map.sdk.departure.internal.util.DimenUtil;
import com.didi.map.sdk.departure.param.PinStyle;
import java.lang.ref.WeakReference;

public class DepartureMarkerView extends View {
    public static final int TYPE_LOADED = 3;
    public static final int TYPE_LOADING = 2;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NO_STOP = 5;
    public static final int TYPE_TEXT = 4;

    /* renamed from: A */
    private float f30624A;

    /* renamed from: B */
    private int f30625B;

    /* renamed from: C */
    private int f30626C;

    /* renamed from: D */
    private boolean f30627D;

    /* renamed from: a */
    int f30628a;

    /* renamed from: b */
    private int f30629b;

    /* renamed from: c */
    private int f30630c;

    /* renamed from: d */
    private int f30631d;

    /* renamed from: e */
    private int f30632e;

    /* renamed from: f */
    private int f30633f;

    /* renamed from: g */
    private int f30634g;

    /* renamed from: h */
    private Paint f30635h;

    /* renamed from: i */
    private Paint f30636i;

    /* renamed from: j */
    private Paint f30637j;

    /* renamed from: k */
    private Paint f30638k;

    /* renamed from: l */
    private Paint f30639l;

    /* renamed from: m */
    private Paint f30640m;

    /* renamed from: n */
    private int f30641n;

    /* renamed from: o */
    private int f30642o;

    /* renamed from: p */
    private int f30643p;

    /* renamed from: q */
    private int f30644q;

    /* renamed from: r */
    private int f30645r;

    /* renamed from: s */
    private int f30646s;

    /* renamed from: t */
    private int f30647t;

    /* renamed from: u */
    private int f30648u;

    /* renamed from: v */
    private int f30649v;

    /* renamed from: w */
    private String f30650w;

    /* renamed from: x */
    private StartLoadingAnimation f30651x;

    /* renamed from: y */
    private StopLoadingAnimation f30652y;

    /* renamed from: z */
    private float f30653z;

    public interface AnimationFinishListener {
        void onFinish();
    }

    public DepartureMarkerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DepartureMarkerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30628a = 1;
        this.f30629b = Color.parseColor("#ffffff");
        this.f30630c = Color.parseColor("#00D0AD");
        this.f30631d = Color.parseColor("#00ffffff");
        this.f30632e = Color.parseColor("#227B6C");
        this.f30633f = Color.parseColor("#ffffff");
        this.f30634g = Color.parseColor("#00D0AD");
        this.f30635h = null;
        this.f30636i = null;
        this.f30637j = null;
        this.f30638k = null;
        this.f30639l = null;
        this.f30640m = null;
        this.f30641n = 0;
        this.f30642o = 0;
        this.f30643p = 0;
        this.f30644q = 0;
        this.f30645r = 0;
        this.f30646s = 0;
        this.f30647t = 0;
        this.f30648u = 0;
        this.f30649v = 0;
        this.f30650w = null;
        this.f30651x = null;
        this.f30652y = null;
        this.f30653z = 0.0f;
        this.f30624A = 0.0f;
        this.f30625B = 0;
        this.f30626C = 0;
        this.f30627D = false;
        this.f30641n = DimenUtil.dip2px(getContext(), 3.0f);
        this.f30642o = DimenUtil.dip2px(getContext(), 11.0f);
        this.f30643p = DimenUtil.dip2px(getContext(), 0.5f);
        this.f30644q = DimenUtil.dip2px(getContext(), 2.0f);
        this.f30645r = DimenUtil.dip2px(getContext(), 10.0f);
        this.f30647t = DimenUtil.dip2px(getContext(), 10.0f);
        this.f30646s = DimenUtil.dip2px(getContext(), -15.0f);
        this.f30648u = DimenUtil.dip2px(getContext(), 3.0f);
        this.f30649v = DimenUtil.dip2px(getContext(), 2.0f);
        Paint paint = new Paint();
        this.f30635h = paint;
        paint.setAntiAlias(true);
        this.f30635h.setColor(this.f30629b);
        Paint paint2 = new Paint();
        this.f30636i = paint2;
        paint2.setAntiAlias(true);
        this.f30636i.setColor(this.f30630c);
        Paint paint3 = new Paint();
        this.f30637j = paint3;
        paint3.setAntiAlias(true);
        this.f30637j.setColor(this.f30631d);
        this.f30637j.setStrokeWidth((float) this.f30643p);
        this.f30637j.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint();
        this.f30638k = paint4;
        paint4.setAntiAlias(true);
        this.f30638k.setColor(this.f30632e);
        Paint paint5 = new Paint();
        this.f30639l = paint5;
        paint5.setAntiAlias(true);
        this.f30639l.setColor(this.f30633f);
        this.f30639l.setTextAlign(Paint.Align.CENTER);
        this.f30639l.setTextSize((float) this.f30647t);
        Paint paint6 = new Paint();
        this.f30640m = paint6;
        paint6.setAntiAlias(true);
        this.f30640m.setColor(this.f30634g);
    }

    public void setPinStyle(PinStyle pinStyle) {
        if (pinStyle != null) {
            if (pinStyle.smallCircleColor != 0) {
                this.f30629b = pinStyle.smallCircleColor;
            }
            if (pinStyle.bigCircleColor != 0) {
                this.f30630c = pinStyle.bigCircleColor;
            }
            if (pinStyle.bigCircleStrokeColor != 0) {
                this.f30631d = pinStyle.bigCircleStrokeColor;
            }
            if (pinStyle.rectColor != 0) {
                this.f30632e = pinStyle.rectColor;
            }
            if (pinStyle.shadowColor != 0) {
                this.f30634g = pinStyle.shadowColor;
            }
            boolean z = pinStyle.rectVisible;
            this.f30627D = z;
            if (!z) {
                this.f30645r = 0;
                this.f30644q = 0;
            }
            this.f30635h.setColor(this.f30629b);
            this.f30636i.setColor(this.f30630c);
            this.f30637j.setColor(this.f30631d);
            this.f30637j.setStrokeWidth((float) this.f30643p);
            this.f30637j.setStyle(Paint.Style.STROKE);
            this.f30638k.setColor(this.f30632e);
            this.f30639l.setColor(this.f30633f);
            this.f30639l.setTextAlign(Paint.Align.CENTER);
            this.f30639l.setTextSize((float) this.f30647t);
            this.f30640m.setColor(this.f30634g);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f30628a == 3) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.f30625B == 0) {
            this.f30625B = this.f30645r + (this.f30642o * 2) + (this.f30649v / 2) + this.f30643p;
        }
        if (this.f30626C == 0) {
            this.f30626C = (this.f30642o * 2) + (this.f30643p * 2);
        }
        setMeasuredDimension(this.f30626C, this.f30625B);
    }

    public void setNormal() {
        clearAnimation();
        this.f30628a = 1;
        invalidate();
    }

    public void setNoStopZoneStatus() {
        clearAnimation();
        this.f30628a = 5;
        invalidate();
    }

    public void setText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f30628a = 4;
            this.f30650w = str.substring(0, 1);
            invalidate();
            return;
        }
        setNormal();
    }

    public void startLoading() {
        clearAnimation();
        this.f30628a = 2;
        StartLoadingAnimation startLoadingAnimation = new StartLoadingAnimation();
        this.f30651x = startLoadingAnimation;
        startLoadingAnimation.setAnimationListener(new DepartureMarkerAnimationListener());
        startAnimation(this.f30651x);
    }

    /* access modifiers changed from: private */
    public void setLoading(float f) {
        this.f30653z = f;
        invalidate();
    }

    public void startJump(final AnimationFinishListener animationFinishListener) {
        clearAnimation();
        this.f30628a = 3;
        StopLoadingAnimation stopLoadingAnimation = new StopLoadingAnimation();
        this.f30652y = stopLoadingAnimation;
        stopLoadingAnimation.setAnimationListener(new DepartureMarkerAnimationListener() {
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                AnimationFinishListener animationFinishListener = animationFinishListener;
                if (animationFinishListener != null) {
                    animationFinishListener.onFinish();
                }
            }
        });
        startAnimation(this.f30652y);
    }

    /* access modifiers changed from: package-private */
    public void setLoaded(float f) {
        this.f30624A = f;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (f >= 0.0f && ((double) f) < 0.5d) {
            layoutParams.width = this.f30626C;
            layoutParams.height = (int) (((float) this.f30625B) + ((f / 0.5f) * ((float) this.f30645r)));
        } else if (((double) f) >= 0.5d && f <= 1.0f) {
            layoutParams.width = this.f30626C;
            layoutParams.height = (int) (((float) this.f30625B) + (((1.0f - f) / 0.5f) * ((float) this.f30645r)));
        }
        setLayoutParams(layoutParams);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f30628a;
        if (i == 1) {
            m23633a(canvas);
        } else if (i == 2) {
            m23636b(canvas);
        } else if (i == 3) {
            m23637c(canvas);
        } else if (i == 4) {
            m23634a(canvas, this.f30650w);
        } else if (i == 5) {
            drawNoStopZoneIcon(canvas);
        } else {
            m23633a(canvas);
        }
    }

    /* renamed from: a */
    private void m23633a(Canvas canvas) {
        if (this.f30627D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f30648u) / 2.0f), (float) (getHeight() - this.f30649v), (((float) getWidth()) / 2.0f) + (((float) this.f30648u) / 2.0f), (float) getHeight()), this.f30640m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f30644q) / 2.0f), (float) this.f30642o, (((float) getWidth()) / 2.0f) + (((float) this.f30644q) / 2.0f), ((float) getHeight()) - (((float) this.f30649v) / 2.0f), this.f30638k);
        }
        this.f30636i.setAlpha(255);
        int i = this.f30642o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i), (float) i, this.f30636i);
        int i2 = this.f30642o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i2), (float) i2, this.f30637j);
        this.f30635h.setAlpha(255);
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30642o + this.f30643p), (float) this.f30641n, this.f30635h);
    }

    /* renamed from: b */
    private void m23636b(Canvas canvas) {
        if (this.f30653z < 0.0f) {
            this.f30653z = 0.0f;
        }
        if (this.f30653z > 1.0f) {
            this.f30653z = 1.0f;
        }
        if (this.f30627D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f30648u) / 2.0f), (float) (getHeight() - this.f30649v), (((float) getWidth()) / 2.0f) + (((float) this.f30648u) / 2.0f), (float) getHeight()), this.f30640m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f30644q) / 2.0f), (float) this.f30642o, (((float) getWidth()) / 2.0f) + (((float) this.f30644q) / 2.0f), ((float) getHeight()) - (((float) this.f30649v) / 2.0f), this.f30638k);
        }
        float f = this.f30653z;
        if (f < 0.0f || ((double) f) >= 0.5d) {
            float f2 = this.f30653z;
            if (((double) f2) >= 0.5d && f2 <= 1.0f) {
                this.f30635h.setAlpha(255);
                int i = this.f30642o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i), (float) i, this.f30635h);
                this.f30636i.setAlpha(255);
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30642o + this.f30643p), ((float) this.f30641n) + (((this.f30653z - 0.5f) / 0.5f) * ((float) (this.f30642o - this.f30641n))), this.f30636i);
                this.f30635h.setAlpha((int) ((((double) this.f30653z) - 0.5d) * 255.0d * 2.0d));
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30642o + this.f30643p), (float) this.f30641n, this.f30635h);
            }
        } else {
            this.f30636i.setAlpha(255);
            int i2 = this.f30642o;
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i2), (float) i2, this.f30636i);
            this.f30635h.setAlpha(255);
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30642o + this.f30643p), ((float) this.f30641n) + ((this.f30653z / 0.5f) * ((float) (this.f30642o - this.f30641n))), this.f30635h);
            this.f30636i.setAlpha((int) (this.f30653z * 255.0f * 2.0f));
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30642o + this.f30643p), (float) this.f30641n, this.f30636i);
        }
        int i3 = this.f30642o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i3), (float) i3, this.f30637j);
    }

    /* renamed from: c */
    private void m23637c(Canvas canvas) {
        float f;
        if (this.f30624A < 0.0f) {
            this.f30624A = 0.0f;
        }
        if (this.f30624A > 1.0f) {
            this.f30624A = 1.0f;
        }
        float f2 = this.f30624A;
        if (f2 < 0.0f || ((double) f2) >= 0.5d) {
            float f3 = this.f30624A;
            if (((double) f3) >= 0.5d && f3 <= 1.0f) {
                if (((double) f3) <= 0.5d || ((double) f3) > 0.75d) {
                    f = ((float) this.f30645r) * ((1.0f - this.f30624A) / 0.25f);
                } else {
                    f = ((f3 - 0.5f) / 0.25f) * ((float) this.f30645r);
                }
                if (this.f30627D) {
                    canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f30648u) / 2.0f), ((float) (getHeight() - this.f30649v)) - f, (((float) getWidth()) / 2.0f) + (((float) this.f30648u) / 2.0f), ((float) getHeight()) - f), this.f30640m);
                    canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f30644q) / 2.0f), (float) this.f30642o, (((float) getWidth()) / 2.0f) + (((float) this.f30644q) / 2.0f), (((float) getHeight()) - (((float) this.f30649v) / 2.0f)) - f, this.f30638k);
                }
                this.f30636i.setAlpha(255);
                int i = this.f30642o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i), (float) i, this.f30636i);
                int i2 = this.f30642o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i2), (float) i2, this.f30637j);
                this.f30635h.setAlpha(255);
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30642o + this.f30643p), (float) this.f30641n, this.f30635h);
                return;
            }
            return;
        }
        if (this.f30627D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f30648u) / 2.0f), (float) (getHeight() - this.f30649v), (((float) getWidth()) / 2.0f) + (((float) this.f30648u) / 2.0f), (float) getHeight()), this.f30640m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f30644q) / 2.0f), (float) this.f30642o, (((float) getWidth()) / 2.0f) + (((float) this.f30644q) / 2.0f), ((float) getHeight()) - (((float) this.f30649v) / 2.0f), this.f30638k);
        }
        this.f30636i.setAlpha(255);
        int i3 = this.f30642o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i3), (float) i3, this.f30636i);
        int i4 = this.f30642o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i4), (float) i4, this.f30637j);
        this.f30635h.setAlpha(255);
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30642o + this.f30643p), (float) this.f30641n, this.f30635h);
    }

    /* renamed from: a */
    private void m23634a(Canvas canvas, String str) {
        if (this.f30627D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f30648u) / 2.0f), (float) (getHeight() - this.f30649v), (((float) getWidth()) / 2.0f) + (((float) this.f30648u) / 2.0f), (float) getHeight()), this.f30640m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f30644q) / 2.0f), (float) this.f30642o, (((float) getWidth()) / 2.0f) + (((float) this.f30644q) / 2.0f), ((float) getHeight()) - (((float) this.f30649v) / 2.0f), this.f30638k);
        }
        int i = this.f30642o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i), (float) i, this.f30636i);
        int i2 = this.f30642o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f30643p + i2), (float) i2, this.f30637j);
        Paint.FontMetrics fontMetrics = this.f30639l.getFontMetrics();
        canvas.drawText(str, ((float) getWidth()) / 2.0f, ((float) this.f30642o) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.f30639l);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StartLoadingAnimation startLoadingAnimation = this.f30651x;
        if (startLoadingAnimation != null) {
            startLoadingAnimation.cancel();
            this.f30651x = null;
        }
        StartLoadingAnimation startLoadingAnimation2 = this.f30651x;
        if (startLoadingAnimation2 != null) {
            startLoadingAnimation2.cancel();
            this.f30651x = null;
        }
    }

    static class StartLoadingAnimation extends Animation {
        private static int sDuration = 1000;
        private WeakReference<DepartureMarkerView> mDepartureMarkerView;

        private StartLoadingAnimation(DepartureMarkerView departureMarkerView) {
            this.mDepartureMarkerView = null;
            this.mDepartureMarkerView = new WeakReference<>(departureMarkerView);
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setDuration((long) sDuration);
            setRepeatCount(-1);
            setRepeatMode(1);
            setInterpolator(new LinearInterpolator());
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            DepartureMarkerView departureMarkerView = (DepartureMarkerView) this.mDepartureMarkerView.get();
            if (departureMarkerView != null) {
                departureMarkerView.setLoading(f);
            }
        }
    }

    static class DepartureMarkerAnimationListener implements Animation.AnimationListener {
        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        DepartureMarkerAnimationListener() {
        }
    }

    static class StopLoadingAnimation extends Animation {
        private static int sDuration = 400;
        private WeakReference<DepartureMarkerView> mDepartureMarkerView;

        private StopLoadingAnimation(DepartureMarkerView departureMarkerView) {
            this.mDepartureMarkerView = null;
            this.mDepartureMarkerView = new WeakReference<>(departureMarkerView);
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setDuration((long) sDuration);
            setRepeatCount(0);
            setInterpolator(new AccelerateInterpolator());
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            DepartureMarkerView departureMarkerView = (DepartureMarkerView) this.mDepartureMarkerView.get();
            if (departureMarkerView != null) {
                departureMarkerView.setLoaded(f);
            }
        }
    }

    public void drawNoStopZoneIcon(Canvas canvas) {
        float width = ((float) getWidth()) / 2.0f;
        if (this.f30627D) {
            canvas.drawOval(new RectF(width - (((float) this.f30648u) / 2.0f), (float) (getHeight() - this.f30649v), (((float) this.f30648u) / 2.0f) + width, (float) getHeight()), this.f30640m);
            int i = this.f30644q;
            canvas.drawRect(width - (((float) i) / 2.0f), (float) this.f30642o, width + (((float) i) / 2.0f), ((float) getHeight()) - (((float) this.f30649v) / 2.0f), this.f30638k);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(255);
        paint.setColor(Color.parseColor("#FF525D"));
        int i2 = this.f30642o;
        canvas.drawCircle(width, (float) (this.f30643p + i2), (float) i2, paint);
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawCircle(width, (float) (this.f30642o + this.f30643p), (float) DimenUtil.dip2px(getContext(), 8.0f), paint);
        paint.setColor(Color.parseColor("#FF525D"));
        int dip2px = DimenUtil.dip2px(getContext(), 4.0f);
        int dip2px2 = DimenUtil.dip2px(getContext(), 7.0f);
        paint.setStrokeWidth((float) dip2px);
        float f = (float) dip2px2;
        float dip2px3 = (float) DimenUtil.dip2px(getContext(), 8.0f);
        canvas.drawLine(width + f, width - dip2px3, width - f, width + dip2px3, paint);
    }
}
