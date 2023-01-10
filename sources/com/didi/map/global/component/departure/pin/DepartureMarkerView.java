package com.didi.map.global.component.departure.pin;

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
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.model.PinStyle;
import java.lang.ref.WeakReference;

public class DepartureMarkerView extends View {
    public static final int TYPE_LOADED = 3;
    public static final int TYPE_LOADING = 2;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NO_STOP = 5;
    public static final int TYPE_TEXT = 4;

    /* renamed from: A */
    private float f27472A;

    /* renamed from: B */
    private int f27473B;

    /* renamed from: C */
    private int f27474C;

    /* renamed from: D */
    private boolean f27475D;

    /* renamed from: E */
    private Context f27476E;

    /* renamed from: a */
    int f27477a;

    /* renamed from: b */
    private int f27478b;

    /* renamed from: c */
    private int f27479c;

    /* renamed from: d */
    private int f27480d;

    /* renamed from: e */
    private int f27481e;

    /* renamed from: f */
    private int f27482f;

    /* renamed from: g */
    private int f27483g;

    /* renamed from: h */
    private Paint f27484h;

    /* renamed from: i */
    private Paint f27485i;

    /* renamed from: j */
    private Paint f27486j;

    /* renamed from: k */
    private Paint f27487k;

    /* renamed from: l */
    private Paint f27488l;

    /* renamed from: m */
    private Paint f27489m;

    /* renamed from: n */
    private int f27490n;

    /* renamed from: o */
    private int f27491o;

    /* renamed from: p */
    private int f27492p;

    /* renamed from: q */
    private int f27493q;

    /* renamed from: r */
    private int f27494r;

    /* renamed from: s */
    private int f27495s;

    /* renamed from: t */
    private int f27496t;

    /* renamed from: u */
    private int f27497u;

    /* renamed from: v */
    private int f27498v;

    /* renamed from: w */
    private String f27499w;

    /* renamed from: x */
    private StartLoadingAnimation f27500x;

    /* renamed from: y */
    private StopLoadingAnimation f27501y;

    /* renamed from: z */
    private float f27502z;

    public interface AnimationFinishListener {
        void onFinish();
    }

    public DepartureMarkerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DepartureMarkerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27477a = 1;
        this.f27478b = Color.parseColor("#ffffff");
        this.f27479c = Color.parseColor("#00D0AD");
        this.f27480d = Color.parseColor("#00ffffff");
        this.f27481e = Color.parseColor("#227B6C");
        this.f27482f = Color.parseColor("#ffffff");
        this.f27483g = Color.parseColor("#00D0AD");
        this.f27484h = null;
        this.f27485i = null;
        this.f27486j = null;
        this.f27487k = null;
        this.f27488l = null;
        this.f27489m = null;
        this.f27490n = 0;
        this.f27491o = 0;
        this.f27492p = 0;
        this.f27493q = 0;
        this.f27494r = 0;
        this.f27495s = 0;
        this.f27496t = 0;
        this.f27497u = 0;
        this.f27498v = 0;
        this.f27499w = null;
        this.f27500x = null;
        this.f27501y = null;
        this.f27502z = 0.0f;
        this.f27472A = 0.0f;
        this.f27473B = 0;
        this.f27474C = 0;
        this.f27475D = false;
        this.f27476E = context;
        this.f27490n = DisplayUtils.dp2px(context, 3.0f);
        this.f27491o = DisplayUtils.dp2px(context, 11.0f);
        this.f27492p = DisplayUtils.dp2px(context, 0.5f);
        this.f27493q = DisplayUtils.dp2px(context, 2.0f);
        this.f27494r = DisplayUtils.dp2px(context, 10.0f);
        this.f27496t = DisplayUtils.dp2px(context, 10.0f);
        this.f27495s = DisplayUtils.dp2px(context, -15.0f);
        this.f27497u = DisplayUtils.dp2px(context, 3.0f);
        this.f27498v = DisplayUtils.dp2px(context, 2.0f);
        Paint paint = new Paint();
        this.f27484h = paint;
        paint.setAntiAlias(true);
        this.f27484h.setColor(this.f27478b);
        Paint paint2 = new Paint();
        this.f27485i = paint2;
        paint2.setAntiAlias(true);
        this.f27485i.setColor(this.f27479c);
        Paint paint3 = new Paint();
        this.f27486j = paint3;
        paint3.setAntiAlias(true);
        this.f27486j.setColor(this.f27480d);
        this.f27486j.setStrokeWidth((float) this.f27492p);
        this.f27486j.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint();
        this.f27487k = paint4;
        paint4.setAntiAlias(true);
        this.f27487k.setColor(this.f27481e);
        Paint paint5 = new Paint();
        this.f27488l = paint5;
        paint5.setAntiAlias(true);
        this.f27488l.setColor(this.f27482f);
        this.f27488l.setTextAlign(Paint.Align.CENTER);
        this.f27488l.setTextSize((float) this.f27496t);
        Paint paint6 = new Paint();
        this.f27489m = paint6;
        paint6.setAntiAlias(true);
        this.f27489m.setColor(this.f27483g);
    }

    public void setPinStyle(PinStyle pinStyle) {
        if (pinStyle != null) {
            if (pinStyle.smallCircleColor != 0) {
                this.f27478b = pinStyle.smallCircleColor;
            }
            if (pinStyle.bigCircleColor != 0) {
                this.f27479c = pinStyle.bigCircleColor;
            }
            if (pinStyle.bigCircleStrokeColor != 0) {
                this.f27480d = pinStyle.bigCircleStrokeColor;
            }
            if (pinStyle.rectColor != 0) {
                this.f27481e = pinStyle.rectColor;
            }
            if (pinStyle.shadowColor != 0) {
                this.f27483g = pinStyle.shadowColor;
            }
            boolean z = pinStyle.rectVisible;
            this.f27475D = z;
            if (!z) {
                this.f27494r = 0;
                this.f27493q = 0;
            }
            this.f27484h.setColor(this.f27478b);
            this.f27485i.setColor(this.f27479c);
            this.f27486j.setColor(this.f27480d);
            this.f27486j.setStrokeWidth((float) this.f27492p);
            this.f27486j.setStyle(Paint.Style.STROKE);
            this.f27487k.setColor(this.f27481e);
            this.f27488l.setColor(this.f27482f);
            this.f27488l.setTextAlign(Paint.Align.CENTER);
            this.f27488l.setTextSize((float) this.f27496t);
            this.f27489m.setColor(this.f27483g);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f27477a == 3) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.f27473B == 0) {
            this.f27473B = this.f27494r + (this.f27491o * 2) + (this.f27498v / 2) + this.f27492p;
        }
        if (this.f27474C == 0) {
            this.f27474C = (this.f27491o * 2) + (this.f27492p * 2);
        }
        setMeasuredDimension(this.f27474C, this.f27473B);
    }

    public void setNormal() {
        clearAnimation();
        this.f27477a = 1;
        invalidate();
    }

    public void setNoStopZoneStatus() {
        clearAnimation();
        this.f27477a = 5;
        invalidate();
    }

    public void setText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f27477a = 4;
            this.f27499w = str.substring(0, 1);
            invalidate();
            return;
        }
        setNormal();
    }

    public void startLoading() {
        clearAnimation();
        this.f27477a = 2;
        StartLoadingAnimation startLoadingAnimation = new StartLoadingAnimation();
        this.f27500x = startLoadingAnimation;
        startLoadingAnimation.setAnimationListener(new DepartureMarkerAnimationListener());
        startAnimation(this.f27500x);
    }

    /* access modifiers changed from: private */
    public void setLoading(float f) {
        this.f27502z = f;
        invalidate();
    }

    public void startJump(final AnimationFinishListener animationFinishListener) {
        clearAnimation();
        this.f27477a = 3;
        StopLoadingAnimation stopLoadingAnimation = new StopLoadingAnimation();
        this.f27501y = stopLoadingAnimation;
        stopLoadingAnimation.setAnimationListener(new DepartureMarkerAnimationListener() {
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                AnimationFinishListener animationFinishListener = animationFinishListener;
                if (animationFinishListener != null) {
                    animationFinishListener.onFinish();
                }
            }
        });
        startAnimation(this.f27501y);
    }

    /* access modifiers changed from: package-private */
    public void setLoaded(float f) {
        this.f27472A = f;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (f >= 0.0f && ((double) f) < 0.5d) {
            layoutParams.width = this.f27474C;
            layoutParams.height = (int) (((float) this.f27473B) + ((f / 0.5f) * ((float) this.f27494r)));
        } else if (((double) f) >= 0.5d && f <= 1.0f) {
            layoutParams.width = this.f27474C;
            layoutParams.height = (int) (((float) this.f27473B) + (((1.0f - f) / 0.5f) * ((float) this.f27494r)));
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
        int i = this.f27477a;
        if (i == 1) {
            m21753a(canvas);
        } else if (i == 2) {
            m21756b(canvas);
        } else if (i == 3) {
            m21757c(canvas);
        } else if (i == 4) {
            m21754a(canvas, this.f27499w);
        } else if (i == 5) {
            drawNoStopZoneIcon(canvas);
        } else {
            m21753a(canvas);
        }
    }

    /* renamed from: a */
    private void m21753a(Canvas canvas) {
        if (this.f27475D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f27497u) / 2.0f), (float) (getHeight() - this.f27498v), (((float) getWidth()) / 2.0f) + (((float) this.f27497u) / 2.0f), (float) getHeight()), this.f27489m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f27493q) / 2.0f), (float) this.f27491o, (((float) getWidth()) / 2.0f) + (((float) this.f27493q) / 2.0f), ((float) getHeight()) - (((float) this.f27498v) / 2.0f), this.f27487k);
        }
        this.f27485i.setAlpha(255);
        int i = this.f27491o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i), (float) i, this.f27485i);
        int i2 = this.f27491o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i2), (float) i2, this.f27486j);
        this.f27484h.setAlpha(255);
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27491o + this.f27492p), (float) this.f27490n, this.f27484h);
    }

    /* renamed from: b */
    private void m21756b(Canvas canvas) {
        if (this.f27502z < 0.0f) {
            this.f27502z = 0.0f;
        }
        if (this.f27502z > 1.0f) {
            this.f27502z = 1.0f;
        }
        if (this.f27475D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f27497u) / 2.0f), (float) (getHeight() - this.f27498v), (((float) getWidth()) / 2.0f) + (((float) this.f27497u) / 2.0f), (float) getHeight()), this.f27489m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f27493q) / 2.0f), (float) this.f27491o, (((float) getWidth()) / 2.0f) + (((float) this.f27493q) / 2.0f), ((float) getHeight()) - (((float) this.f27498v) / 2.0f), this.f27487k);
        }
        float f = this.f27502z;
        if (f < 0.0f || ((double) f) >= 0.5d) {
            float f2 = this.f27502z;
            if (((double) f2) >= 0.5d && f2 <= 1.0f) {
                this.f27484h.setAlpha(255);
                int i = this.f27491o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i), (float) i, this.f27484h);
                this.f27485i.setAlpha(255);
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27491o + this.f27492p), ((float) this.f27490n) + (((this.f27502z - 0.5f) / 0.5f) * ((float) (this.f27491o - this.f27490n))), this.f27485i);
                this.f27484h.setAlpha((int) ((((double) this.f27502z) - 0.5d) * 255.0d * 2.0d));
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27491o + this.f27492p), (float) this.f27490n, this.f27484h);
            }
        } else {
            this.f27485i.setAlpha(255);
            int i2 = this.f27491o;
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i2), (float) i2, this.f27485i);
            this.f27484h.setAlpha(255);
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27491o + this.f27492p), ((float) this.f27490n) + ((this.f27502z / 0.5f) * ((float) (this.f27491o - this.f27490n))), this.f27484h);
            this.f27485i.setAlpha((int) (this.f27502z * 255.0f * 2.0f));
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27491o + this.f27492p), (float) this.f27490n, this.f27485i);
        }
        int i3 = this.f27491o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i3), (float) i3, this.f27486j);
    }

    /* renamed from: c */
    private void m21757c(Canvas canvas) {
        float f;
        if (this.f27472A < 0.0f) {
            this.f27472A = 0.0f;
        }
        if (this.f27472A > 1.0f) {
            this.f27472A = 1.0f;
        }
        float f2 = this.f27472A;
        if (f2 < 0.0f || ((double) f2) >= 0.5d) {
            float f3 = this.f27472A;
            if (((double) f3) >= 0.5d && f3 <= 1.0f) {
                if (((double) f3) <= 0.5d || ((double) f3) > 0.75d) {
                    f = ((float) this.f27494r) * ((1.0f - this.f27472A) / 0.25f);
                } else {
                    f = ((f3 - 0.5f) / 0.25f) * ((float) this.f27494r);
                }
                if (this.f27475D) {
                    canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f27497u) / 2.0f), ((float) (getHeight() - this.f27498v)) - f, (((float) getWidth()) / 2.0f) + (((float) this.f27497u) / 2.0f), ((float) getHeight()) - f), this.f27489m);
                    canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f27493q) / 2.0f), (float) this.f27491o, (((float) getWidth()) / 2.0f) + (((float) this.f27493q) / 2.0f), (((float) getHeight()) - (((float) this.f27498v) / 2.0f)) - f, this.f27487k);
                }
                this.f27485i.setAlpha(255);
                int i = this.f27491o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i), (float) i, this.f27485i);
                int i2 = this.f27491o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i2), (float) i2, this.f27486j);
                this.f27484h.setAlpha(255);
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27491o + this.f27492p), (float) this.f27490n, this.f27484h);
                return;
            }
            return;
        }
        if (this.f27475D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f27497u) / 2.0f), (float) (getHeight() - this.f27498v), (((float) getWidth()) / 2.0f) + (((float) this.f27497u) / 2.0f), (float) getHeight()), this.f27489m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f27493q) / 2.0f), (float) this.f27491o, (((float) getWidth()) / 2.0f) + (((float) this.f27493q) / 2.0f), ((float) getHeight()) - (((float) this.f27498v) / 2.0f), this.f27487k);
        }
        this.f27485i.setAlpha(255);
        int i3 = this.f27491o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i3), (float) i3, this.f27485i);
        int i4 = this.f27491o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i4), (float) i4, this.f27486j);
        this.f27484h.setAlpha(255);
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27491o + this.f27492p), (float) this.f27490n, this.f27484h);
    }

    /* renamed from: a */
    private void m21754a(Canvas canvas, String str) {
        if (this.f27475D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f27497u) / 2.0f), (float) (getHeight() - this.f27498v), (((float) getWidth()) / 2.0f) + (((float) this.f27497u) / 2.0f), (float) getHeight()), this.f27489m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f27493q) / 2.0f), (float) this.f27491o, (((float) getWidth()) / 2.0f) + (((float) this.f27493q) / 2.0f), ((float) getHeight()) - (((float) this.f27498v) / 2.0f), this.f27487k);
        }
        int i = this.f27491o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i), (float) i, this.f27485i);
        int i2 = this.f27491o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f27492p + i2), (float) i2, this.f27486j);
        Paint.FontMetrics fontMetrics = this.f27488l.getFontMetrics();
        canvas.drawText(str, ((float) getWidth()) / 2.0f, ((float) this.f27491o) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.f27488l);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StartLoadingAnimation startLoadingAnimation = this.f27500x;
        if (startLoadingAnimation != null) {
            startLoadingAnimation.cancel();
            this.f27500x = null;
        }
        StartLoadingAnimation startLoadingAnimation2 = this.f27500x;
        if (startLoadingAnimation2 != null) {
            startLoadingAnimation2.cancel();
            this.f27500x = null;
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
        if (this.f27475D) {
            canvas.drawOval(new RectF(width - (((float) this.f27497u) / 2.0f), (float) (getHeight() - this.f27498v), (((float) this.f27497u) / 2.0f) + width, (float) getHeight()), this.f27489m);
            int i = this.f27493q;
            canvas.drawRect(width - (((float) i) / 2.0f), (float) this.f27491o, width + (((float) i) / 2.0f), ((float) getHeight()) - (((float) this.f27498v) / 2.0f), this.f27487k);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(255);
        paint.setColor(Color.parseColor("#FF525D"));
        int i2 = this.f27491o;
        canvas.drawCircle(width, (float) (this.f27492p + i2), (float) i2, paint);
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawCircle(width, (float) (this.f27491o + this.f27492p), (float) DisplayUtils.dp2px(this.f27476E, 8.0f), paint);
        paint.setColor(Color.parseColor("#FF525D"));
        int dp2px = DisplayUtils.dp2px(this.f27476E, 4.0f);
        int dp2px2 = DisplayUtils.dp2px(this.f27476E, 7.0f);
        paint.setStrokeWidth((float) dp2px);
        float f = (float) dp2px2;
        float dp2px3 = (float) DisplayUtils.dp2px(this.f27476E, 8.0f);
        canvas.drawLine(width + f, width - dp2px3, width - f, width + dp2px3, paint);
    }
}
