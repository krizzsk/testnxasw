package com.didi.globalsafetoolkit.business.emergency.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.globalsafetoolkit.util.SfUIThreadHelper;
import com.didi.globalsafetoolkit.util.SfViewUtils;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;

public class SliderMoveView extends View {
    public static final int STATE_SLIDER_FREE = 3;
    public static final int STATE_SLIDER_IDLE = 0;
    public static final int STATE_SLIDER_LOCKED = 1;
    public static final int STATE_SLIDER_MOVE = 2;

    /* renamed from: a */
    private static final long f25026a = 500;

    /* renamed from: b */
    private static final int f25027b = 5;

    /* renamed from: c */
    private Paint f25028c = new Paint();

    /* renamed from: d */
    private int f25029d;

    /* renamed from: e */
    private Bitmap f25030e;

    /* renamed from: f */
    private float f25031f;

    /* renamed from: g */
    private float f25032g;

    /* renamed from: h */
    private int f25033h;

    /* renamed from: i */
    private GradientDrawable f25034i;

    /* renamed from: j */
    private Bitmap f25035j;

    /* renamed from: k */
    private float f25036k;

    /* renamed from: l */
    private int f25037l;

    /* renamed from: m */
    private int f25038m;

    /* renamed from: n */
    private int f25039n;

    /* renamed from: o */
    private Matrix f25040o = new Matrix();

    /* renamed from: p */
    private RectF f25041p = new RectF();

    /* renamed from: q */
    private Rect f25042q = new Rect();

    /* renamed from: r */
    private float f25043r = -1.0f;

    /* renamed from: s */
    private float f25044s = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f25045t = 0.0f;

    /* renamed from: u */
    private ValueAnimator f25046u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f25047v = 0;

    /* renamed from: w */
    private String f25048w;

    /* renamed from: x */
    private String f25049x;

    /* renamed from: y */
    private boolean f25050y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public SlideButtonViewListener f25051z;

    public interface SlideButtonViewListener {
        void onSliderMove(float f, float f2);

        boolean onSliderStateChange(int i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m20053a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public SliderMoveView(Context context) {
        super(context);
        m20057a();
    }

    public SliderMoveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20057a();
    }

    public SliderMoveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20057a();
    }

    /* renamed from: a */
    private void m20057a() {
        this.f25050y = DRtlToolkit.rtl();
        this.f25028c.setTextSize((float) SfViewUtils.dp2px(getContext(), 20.0f));
        this.f25028c.setAntiAlias(true);
        this.f25029d = Color.parseColor(ColorUtils.DIDI_GREY);
        this.f25030e = ((BitmapDrawable) getResources().getDrawable(R.drawable.sf_ic_call_police_arrow)).getBitmap();
        this.f25031f = (float) SfViewUtils.dp2px(getContext(), 19.0f);
        this.f25032g = (float) SfViewUtils.dp2px(getContext(), 16.0f);
        this.f25033h = Color.parseColor("#000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f25034i = gradientDrawable;
        gradientDrawable.setShape(0);
        this.f25034i.setColor(Color.parseColor("#FA8988"));
        this.f25035j = ((BitmapDrawable) getResources().getDrawable(R.drawable.sf_ic_call_police_call)).getBitmap();
        this.f25036k = (float) SfViewUtils.dp2px(getContext(), 4.0f);
        this.f25037l = Color.parseColor("#FFFFFF");
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(500);
        this.f25046u = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SliderMoveView sliderMoveView = SliderMoveView.this;
                    float unused = sliderMoveView.f25045t = sliderMoveView.m20053a(floatValue);
                    SliderMoveView.this.invalidate();
                }
            }
        });
        this.f25046u.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                float unused = SliderMoveView.this.f25045t = 0.0f;
                int unused2 = SliderMoveView.this.f25047v = 0;
                SliderMoveView.this.invalidate();
                if (SliderMoveView.this.f25051z != null) {
                    SliderMoveView.this.f25051z.onSliderStateChange(0);
                }
            }

            public void onAnimationCancel(Animator animator) {
                float unused = SliderMoveView.this.f25045t = 0.0f;
                int unused2 = SliderMoveView.this.f25047v = 0;
                SliderMoveView.this.invalidate();
                if (SliderMoveView.this.f25051z != null) {
                    SliderMoveView.this.f25051z.onSliderStateChange(0);
                }
            }
        });
    }

    public float getCurrentPercent() {
        return this.f25045t;
    }

    public void setForegroundText(String str) {
        if (str == null) {
            str = "";
        }
        this.f25049x = str;
        invalidate();
    }

    public void setBackgroundText(String str) {
        if (str == null) {
            str = "";
        }
        this.f25048w = str;
        invalidate();
    }

    public void setListener(SlideButtonViewListener slideButtonViewListener) {
        this.f25051z = slideButtonViewListener;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f25038m = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f25039n = measuredHeight;
        m20058a(canvas, this.f25038m, measuredHeight);
        m20063b(canvas, this.f25038m, this.f25039n);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        boolean z2 = true;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX();
                    int i = this.f25047v;
                    if (i == 1 || i == 2) {
                        float f = this.f25050y ? this.f25043r - x : x - this.f25043r;
                        this.f25045t = m20053a(f / ((float) (this.f25038m - this.f25039n)));
                        int i2 = this.f25047v;
                        this.f25047v = 2;
                        invalidate();
                        SlideButtonViewListener slideButtonViewListener = this.f25051z;
                        if (slideButtonViewListener != null) {
                            if (i2 == 1) {
                                slideButtonViewListener.onSliderStateChange(2);
                            }
                            this.f25051z.onSliderMove(this.f25045t, f);
                        }
                    } else {
                        float f2 = this.f25043r;
                        if (f2 == -1.0f || this.f25044s == -1.0f) {
                            return false;
                        }
                        if (Math.abs(x - f2) > ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                            this.f25047v = 1;
                            invalidate();
                            SlideButtonViewListener slideButtonViewListener2 = this.f25051z;
                            if (slideButtonViewListener2 != null) {
                                slideButtonViewListener2.onSliderStateChange(1);
                            }
                        }
                    }
                } else if (action != 3) {
                    return false;
                }
            }
            if (this.f25043r == -1.0f || this.f25044s == -1.0f) {
                z2 = false;
            } else {
                this.f25043r = -1.0f;
                this.f25044s = -1.0f;
            }
            this.f25047v = 3;
            SlideButtonViewListener slideButtonViewListener3 = this.f25051z;
            if (slideButtonViewListener3 != null) {
                z = slideButtonViewListener3.onSliderStateChange(3);
            }
            if (z) {
                SfUIThreadHelper.postDelay(new Runnable() {
                    public void run() {
                        int unused = SliderMoveView.this.f25047v = 0;
                        float unused2 = SliderMoveView.this.f25045t = 0.0f;
                        SliderMoveView.this.invalidate();
                    }
                }, 500);
            } else {
                this.f25046u.setCurrentPlayTime((long) ((1.0f - this.f25045t) * 500.0f));
                this.f25046u.start();
            }
            return z2;
        }
        float x2 = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = this.f25042q;
        int i3 = (int) (this.f25050y ? ((float) (this.f25038m - this.f25039n)) + this.f25036k : this.f25036k);
        float f3 = this.f25036k;
        m20059a(rect, i3, (int) f3, (int) (((float) (this.f25050y ? this.f25038m : this.f25039n)) - f3), (int) (((float) this.f25039n) - this.f25036k));
        if (!m20061a(this.f25042q, (int) x2, (int) y)) {
            return false;
        }
        this.f25043r = x2;
        this.f25044s = y;
        return true;
    }

    /* renamed from: a */
    private void m20059a(Rect rect, int i, int i2, int i3, int i4) {
        if (rect != null) {
            rect.left = i;
            rect.top = i2;
            rect.right = i3;
            rect.bottom = i4;
        }
    }

    /* renamed from: a */
    private void m20060a(RectF rectF, float f, float f2, float f3, float f4) {
        if (rectF != null) {
            rectF.left = f;
            rectF.top = f2;
            rectF.right = f3;
            rectF.bottom = f4;
        }
    }

    /* renamed from: a */
    private void m20058a(Canvas canvas, int i, int i2) {
        float f;
        Canvas canvas2 = canvas;
        int i3 = i2;
        this.f25028c.setColor(this.f25029d);
        this.f25028c.setStyle(Paint.Style.FILL);
        DIDIFontUtils.Companion.setPaintTypeface(getContext(), this.f25028c);
        float f2 = (float) (((double) i3) / 2.0d);
        float f3 = f2 * 2.0f;
        float f4 = (float) i3;
        m20060a(this.f25041p, 0.0f, 0.0f, f3, f4);
        canvas.drawArc(this.f25041p, 270.0f, -180.0f, false, this.f25028c);
        float f5 = (float) i;
        canvas.drawRect(f2, 0.0f, f5 - f2, f4, this.f25028c);
        m20060a(this.f25041p, f5 - f3, 0.0f, f5, f4);
        canvas.drawArc(this.f25041p, 90.0f, -180.0f, false, this.f25028c);
        this.f25040o.reset();
        float width = this.f25031f / ((float) this.f25030e.getWidth());
        this.f25040o.postScale(this.f25050y ? -width : width, width, 0.5f, 0.5f);
        Matrix matrix = this.f25040o;
        if (this.f25050y) {
            f = this.f25032g + this.f25031f;
        } else {
            float f6 = this.f25032g;
            f = (f5 - f6) - f6;
        }
        matrix.postTranslate(f, (f4 - this.f25031f) / 2.0f);
        canvas.drawBitmap(this.f25030e, this.f25040o, this.f25028c);
        if (!TextUtils.isEmpty(this.f25048w)) {
            this.f25028c.setColor(this.f25033h);
            this.f25028c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            Paint paint = this.f25028c;
            String str = this.f25048w;
            paint.getTextBounds(str, 0, str.length(), this.f25042q);
            canvas.drawText(this.f25048w, (f5 - ((float) this.f25042q.width())) / 2.0f, ((f4 + ((float) this.f25042q.height())) / 2.0f) - 5.0f, this.f25028c);
        }
    }

    /* renamed from: b */
    private void m20063b(Canvas canvas, int i, int i2) {
        if (this.f25047v != 0) {
            this.f25034i.setCornerRadius((float) (((double) i2) / 2.0d));
            this.f25034i.setBounds(this.f25050y ? (int) ((((float) i) - (((float) (i - i2)) * this.f25045t)) - ((float) i2)) : 0, 0, this.f25050y ? i : (int) ((((float) (i - i2)) * this.f25045t) + ((float) i2)), i2);
            this.f25034i.draw(canvas);
            if (!TextUtils.isEmpty(this.f25049x)) {
                this.f25028c.setColor(this.f25037l);
                this.f25028c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                Paint paint = this.f25028c;
                String str = this.f25049x;
                paint.getTextBounds(str, 0, str.length(), this.f25042q);
                float width = (float) this.f25042q.width();
                float height = (float) this.f25042q.height();
                canvas.clipRect(this.f25050y ? (int) (((((float) i) - (((float) (i - i2)) * this.f25045t)) - ((float) i2)) + this.f25036k) : 0, 0, this.f25050y ? i : (int) (((((float) (i - i2)) * this.f25045t) + ((float) i2)) - this.f25036k), i2);
                canvas.drawText(this.f25049x, (((float) i) - width) / 2.0f, ((((float) i2) + height) / 2.0f) - 5.0f, this.f25028c);
            }
        }
        float f = (float) i2;
        float height2 = (f - (this.f25036k * 2.0f)) / ((float) this.f25035j.getHeight());
        this.f25040o.reset();
        this.f25040o.postScale(height2, height2, 0.5f, 0.5f);
        this.f25040o.postTranslate(this.f25050y ? (float) ((int) (((((float) i) - (((float) (i - i2)) * this.f25045t)) - f) + this.f25036k)) : (((float) (i - i2)) * this.f25045t) + this.f25036k, this.f25036k);
        canvas.drawBitmap(this.f25035j, this.f25040o, this.f25028c);
    }

    /* renamed from: a */
    private boolean m20061a(Rect rect, int i, int i2) {
        return rect != null && rect.left < i && i < rect.right && rect.top < i2 && i2 < rect.bottom;
    }
}
