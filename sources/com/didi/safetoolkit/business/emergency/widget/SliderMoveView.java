package com.didi.safetoolkit.business.emergency.widget;

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
import com.didi.safetoolkit.util.SfUIThreadHelper;
import com.didi.safetoolkit.util.SfViewUtils;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;

public class SliderMoveView extends View {
    public static final int STATE_SLIDER_FREE = 3;
    public static final int STATE_SLIDER_IDLE = 0;
    public static final int STATE_SLIDER_LOCKED = 1;
    public static final int STATE_SLIDER_MOVE = 2;

    /* renamed from: a */
    private static final long f37132a = 500;

    /* renamed from: b */
    private static final int f37133b = 5;

    /* renamed from: c */
    private Paint f37134c = new Paint();

    /* renamed from: d */
    private int f37135d;

    /* renamed from: e */
    private Bitmap f37136e;

    /* renamed from: f */
    private float f37137f;

    /* renamed from: g */
    private float f37138g;

    /* renamed from: h */
    private int f37139h;

    /* renamed from: i */
    private GradientDrawable f37140i;

    /* renamed from: j */
    private Bitmap f37141j;

    /* renamed from: k */
    private float f37142k;

    /* renamed from: l */
    private int f37143l;

    /* renamed from: m */
    private int f37144m;

    /* renamed from: n */
    private int f37145n;

    /* renamed from: o */
    private Matrix f37146o = new Matrix();

    /* renamed from: p */
    private RectF f37147p = new RectF();

    /* renamed from: q */
    private Rect f37148q = new Rect();

    /* renamed from: r */
    private float f37149r = -1.0f;

    /* renamed from: s */
    private float f37150s = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f37151t = 0.0f;

    /* renamed from: u */
    private ValueAnimator f37152u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f37153v = 0;

    /* renamed from: w */
    private String f37154w;

    /* renamed from: x */
    private String f37155x;

    /* renamed from: y */
    private boolean f37156y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public SlideButtonViewListener f37157z;

    public interface SlideButtonViewListener {
        void onSliderMove(float f, float f2);

        boolean onSliderStateChange(int i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m28037a(float f) {
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
        m28041a();
    }

    public SliderMoveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28041a();
    }

    public SliderMoveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28041a();
    }

    /* renamed from: a */
    private void m28041a() {
        this.f37156y = DRtlToolkit.rtl();
        this.f37134c.setTextSize((float) SfViewUtils.dp2px(getContext(), 20.0f));
        this.f37134c.setAntiAlias(true);
        this.f37135d = Color.parseColor(ColorUtils.DIDI_GREY);
        this.f37136e = ((BitmapDrawable) getResources().getDrawable(R.drawable.sf_ic_call_police_arrow)).getBitmap();
        this.f37137f = (float) SfViewUtils.dp2px(getContext(), 19.0f);
        this.f37138g = (float) SfViewUtils.dp2px(getContext(), 16.0f);
        this.f37139h = Color.parseColor("#000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f37140i = gradientDrawable;
        gradientDrawable.setShape(0);
        this.f37140i.setColor(Color.parseColor("#FA8988"));
        this.f37141j = ((BitmapDrawable) getResources().getDrawable(R.drawable.sf_ic_call_police_call)).getBitmap();
        this.f37142k = (float) SfViewUtils.dp2px(getContext(), 4.0f);
        this.f37143l = Color.parseColor("#FFFFFF");
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(500);
        this.f37152u = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SliderMoveView sliderMoveView = SliderMoveView.this;
                    float unused = sliderMoveView.f37151t = sliderMoveView.m28037a(floatValue);
                    SliderMoveView.this.invalidate();
                }
            }
        });
        this.f37152u.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                float unused = SliderMoveView.this.f37151t = 0.0f;
                int unused2 = SliderMoveView.this.f37153v = 0;
                SliderMoveView.this.invalidate();
                if (SliderMoveView.this.f37157z != null) {
                    SliderMoveView.this.f37157z.onSliderStateChange(0);
                }
            }

            public void onAnimationCancel(Animator animator) {
                float unused = SliderMoveView.this.f37151t = 0.0f;
                int unused2 = SliderMoveView.this.f37153v = 0;
                SliderMoveView.this.invalidate();
                if (SliderMoveView.this.f37157z != null) {
                    SliderMoveView.this.f37157z.onSliderStateChange(0);
                }
            }
        });
    }

    public float getCurrentPercent() {
        return this.f37151t;
    }

    public void setForegroundText(String str) {
        if (str == null) {
            str = "";
        }
        this.f37155x = str;
        invalidate();
    }

    public void setBackgroundText(String str) {
        if (str == null) {
            str = "";
        }
        this.f37154w = str;
        invalidate();
    }

    public void setListener(SlideButtonViewListener slideButtonViewListener) {
        this.f37157z = slideButtonViewListener;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f37144m = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f37145n = measuredHeight;
        m28042a(canvas, this.f37144m, measuredHeight);
        m28047b(canvas, this.f37144m, this.f37145n);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        boolean z2 = true;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX();
                    int i = this.f37153v;
                    if (i == 1 || i == 2) {
                        float f = this.f37156y ? this.f37149r - x : x - this.f37149r;
                        this.f37151t = m28037a(f / ((float) (this.f37144m - this.f37145n)));
                        int i2 = this.f37153v;
                        this.f37153v = 2;
                        invalidate();
                        SlideButtonViewListener slideButtonViewListener = this.f37157z;
                        if (slideButtonViewListener != null) {
                            if (i2 == 1) {
                                slideButtonViewListener.onSliderStateChange(2);
                            }
                            this.f37157z.onSliderMove(this.f37151t, f);
                        }
                    } else {
                        float f2 = this.f37149r;
                        if (f2 == -1.0f || this.f37150s == -1.0f) {
                            return false;
                        }
                        if (Math.abs(x - f2) > ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                            this.f37153v = 1;
                            invalidate();
                            SlideButtonViewListener slideButtonViewListener2 = this.f37157z;
                            if (slideButtonViewListener2 != null) {
                                slideButtonViewListener2.onSliderStateChange(1);
                            }
                        }
                    }
                } else if (action != 3) {
                    return false;
                }
            }
            if (this.f37149r == -1.0f || this.f37150s == -1.0f) {
                z2 = false;
            } else {
                this.f37149r = -1.0f;
                this.f37150s = -1.0f;
            }
            this.f37153v = 3;
            SlideButtonViewListener slideButtonViewListener3 = this.f37157z;
            if (slideButtonViewListener3 != null) {
                z = slideButtonViewListener3.onSliderStateChange(3);
            }
            if (z) {
                SfUIThreadHelper.postDelay(new Runnable() {
                    public void run() {
                        int unused = SliderMoveView.this.f37153v = 0;
                        float unused2 = SliderMoveView.this.f37151t = 0.0f;
                        SliderMoveView.this.invalidate();
                    }
                }, 500);
            } else {
                this.f37152u.setCurrentPlayTime((long) ((1.0f - this.f37151t) * 500.0f));
                this.f37152u.start();
            }
            return z2;
        }
        float x2 = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = this.f37148q;
        int i3 = (int) (this.f37156y ? ((float) (this.f37144m - this.f37145n)) + this.f37142k : this.f37142k);
        float f3 = this.f37142k;
        m28043a(rect, i3, (int) f3, (int) (((float) (this.f37156y ? this.f37144m : this.f37145n)) - f3), (int) (((float) this.f37145n) - this.f37142k));
        if (!m28045a(this.f37148q, (int) x2, (int) y)) {
            return false;
        }
        this.f37149r = x2;
        this.f37150s = y;
        return true;
    }

    /* renamed from: a */
    private void m28043a(Rect rect, int i, int i2, int i3, int i4) {
        if (rect != null) {
            rect.left = i;
            rect.top = i2;
            rect.right = i3;
            rect.bottom = i4;
        }
    }

    /* renamed from: a */
    private void m28044a(RectF rectF, float f, float f2, float f3, float f4) {
        if (rectF != null) {
            rectF.left = f;
            rectF.top = f2;
            rectF.right = f3;
            rectF.bottom = f4;
        }
    }

    /* renamed from: a */
    private void m28042a(Canvas canvas, int i, int i2) {
        float f;
        Canvas canvas2 = canvas;
        int i3 = i2;
        this.f37134c.setColor(this.f37135d);
        this.f37134c.setStyle(Paint.Style.FILL);
        DIDIFontUtils.Companion.setPaintTypeface(getContext(), this.f37134c);
        float f2 = (float) (((double) i3) / 2.0d);
        float f3 = f2 * 2.0f;
        float f4 = (float) i3;
        m28044a(this.f37147p, 0.0f, 0.0f, f3, f4);
        canvas.drawArc(this.f37147p, 270.0f, -180.0f, false, this.f37134c);
        float f5 = (float) i;
        canvas.drawRect(f2, 0.0f, f5 - f2, f4, this.f37134c);
        m28044a(this.f37147p, f5 - f3, 0.0f, f5, f4);
        canvas.drawArc(this.f37147p, 90.0f, -180.0f, false, this.f37134c);
        this.f37146o.reset();
        float width = this.f37137f / ((float) this.f37136e.getWidth());
        this.f37146o.postScale(this.f37156y ? -width : width, width, 0.5f, 0.5f);
        Matrix matrix = this.f37146o;
        if (this.f37156y) {
            f = this.f37138g + this.f37137f;
        } else {
            float f6 = this.f37138g;
            f = (f5 - f6) - f6;
        }
        matrix.postTranslate(f, (f4 - this.f37137f) / 2.0f);
        canvas.drawBitmap(this.f37136e, this.f37146o, this.f37134c);
        if (!TextUtils.isEmpty(this.f37154w)) {
            this.f37134c.setColor(this.f37139h);
            this.f37134c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            Paint paint = this.f37134c;
            String str = this.f37154w;
            paint.getTextBounds(str, 0, str.length(), this.f37148q);
            canvas.drawText(this.f37154w, (f5 - ((float) this.f37148q.width())) / 2.0f, ((f4 + ((float) this.f37148q.height())) / 2.0f) - 5.0f, this.f37134c);
        }
    }

    /* renamed from: b */
    private void m28047b(Canvas canvas, int i, int i2) {
        if (this.f37153v != 0) {
            this.f37140i.setCornerRadius((float) (((double) i2) / 2.0d));
            this.f37140i.setBounds(this.f37156y ? (int) ((((float) i) - (((float) (i - i2)) * this.f37151t)) - ((float) i2)) : 0, 0, this.f37156y ? i : (int) ((((float) (i - i2)) * this.f37151t) + ((float) i2)), i2);
            this.f37140i.draw(canvas);
            if (!TextUtils.isEmpty(this.f37155x)) {
                this.f37134c.setColor(this.f37143l);
                this.f37134c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                Paint paint = this.f37134c;
                String str = this.f37155x;
                paint.getTextBounds(str, 0, str.length(), this.f37148q);
                float width = (float) this.f37148q.width();
                float height = (float) this.f37148q.height();
                canvas.clipRect(this.f37156y ? (int) (((((float) i) - (((float) (i - i2)) * this.f37151t)) - ((float) i2)) + this.f37142k) : 0, 0, this.f37156y ? i : (int) (((((float) (i - i2)) * this.f37151t) + ((float) i2)) - this.f37142k), i2);
                canvas.drawText(this.f37155x, (((float) i) - width) / 2.0f, ((((float) i2) + height) / 2.0f) - 5.0f, this.f37134c);
            }
        }
        float f = (float) i2;
        float height2 = (f - (this.f37142k * 2.0f)) / ((float) this.f37141j.getHeight());
        this.f37146o.reset();
        this.f37146o.postScale(height2, height2, 0.5f, 0.5f);
        this.f37146o.postTranslate(this.f37156y ? (float) ((int) (((((float) i) - (((float) (i - i2)) * this.f37151t)) - f) + this.f37142k)) : (((float) (i - i2)) * this.f37151t) + this.f37142k, this.f37142k);
        canvas.drawBitmap(this.f37141j, this.f37146o, this.f37134c);
    }

    /* renamed from: a */
    private boolean m28045a(Rect rect, int i, int i2) {
        return rect != null && rect.left < i && i < rect.right && rect.top < i2 && i2 < rect.bottom;
    }
}
