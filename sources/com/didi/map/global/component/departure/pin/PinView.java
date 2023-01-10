package com.didi.map.global.component.departure.pin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import com.didi.common.map.util.DisplayUtils;
import com.didi.passenger.C11267R;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;
import java.util.ArrayList;

public class PinView extends View {
    public static final int ANIM_DURATION_MILLIS = 400;
    public static int DEFAULT_BIG_CIRCLE_ANGLE_PX = 0;
    public static int DEFAULT_BIG_CIRCLE_HEIGHT_PX = 0;
    public static final int DEFAULT_COLOR = Color.parseColor("#00ccaa");
    public static int DEFAULT_TEXT_SIZE_SP = 0;
    public static int DRAGGING_BIG_CIRCLE_RADIUS_PX = 0;

    /* renamed from: I */
    private static Paint f27527I = null;
    public static int LOADING_BIG_CIRCLE_WIDTH_PX = 0;
    public static final int NO_PARKING_COLOR = Color.parseColor("#fd4060");
    public static int TEXT_LEFT_RIGHT_PADDING_PX = 0;

    /* renamed from: a */
    private static final String f27528a = "PinView";

    /* renamed from: b */
    private static final int f27529b = 1;

    /* renamed from: c */
    private static final int f27530c = 2;

    /* renamed from: d */
    private static final int f27531d = 3;

    /* renamed from: e */
    private static final int f27532e = 4;

    /* renamed from: A */
    private int f27533A;

    /* renamed from: B */
    private int f27534B;

    /* renamed from: C */
    private int f27535C;

    /* renamed from: D */
    private int f27536D;

    /* renamed from: E */
    private int f27537E;

    /* renamed from: F */
    private AnimatorSet f27538F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f27539G;

    /* renamed from: H */
    private RectF f27540H;

    /* renamed from: f */
    private Paint f27541f;

    /* renamed from: g */
    private int f27542g;

    /* renamed from: h */
    private int f27543h;

    /* renamed from: i */
    private int f27544i;

    /* renamed from: j */
    private Paint f27545j;

    /* renamed from: k */
    private int f27546k;

    /* renamed from: l */
    private int f27547l;

    /* renamed from: m */
    private float f27548m;

    /* renamed from: n */
    private Paint f27549n;

    /* renamed from: o */
    private String f27550o;

    /* renamed from: p */
    private int f27551p;

    /* renamed from: q */
    private int f27552q;

    /* renamed from: r */
    private float f27553r;

    /* renamed from: s */
    private float f27554s;

    /* renamed from: t */
    private Paint f27555t;

    /* renamed from: u */
    private int f27556u;

    /* renamed from: v */
    private int f27557v;

    /* renamed from: w */
    private int f27558w;

    /* renamed from: x */
    private int f27559x;

    /* renamed from: y */
    private int f27560y;

    /* renamed from: z */
    private int f27561z;

    public int getNoParkingColor() {
        return this.f27537E;
    }

    public int getNormalColor() {
        return this.f27536D;
    }

    public PinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27541f = null;
        this.f27542g = 0;
        this.f27543h = 0;
        this.f27544i = 0;
        this.f27545j = null;
        this.f27546k = 0;
        this.f27547l = Color.parseColor("#ffffff");
        this.f27548m = 0.0f;
        this.f27549n = null;
        this.f27550o = "PICK-UP";
        this.f27551p = 12;
        this.f27552q = Color.parseColor("#ffffff");
        this.f27553r = 1.0f;
        this.f27554s = 1.0f;
        this.f27555t = null;
        this.f27556u = 0;
        this.f27557v = 0;
        this.f27558w = 3;
        this.f27559x = 400;
        this.f27560y = 0;
        this.f27561z = 0;
        int i2 = DEFAULT_COLOR;
        this.f27533A = i2;
        this.f27534B = i2;
        this.f27535C = i2;
        this.f27536D = i2;
        this.f27537E = NO_PARKING_COLOR;
        this.f27539G = false;
        this.f27540H = new RectF();
        m21787a(context, attributeSet);
    }

    /* renamed from: a */
    private void m21787a(Context context, AttributeSet attributeSet) {
        DEFAULT_TEXT_SIZE_SP = DisplayUtils.sp2px(context, 12.0f);
        TEXT_LEFT_RIGHT_PADDING_PX = DisplayUtils.dp2px(context, 14.0f) * 2;
        DRAGGING_BIG_CIRCLE_RADIUS_PX = DisplayUtils.dp2px(context, 15.0f);
        LOADING_BIG_CIRCLE_WIDTH_PX = DisplayUtils.dp2px(context, 60.0f);
        DEFAULT_BIG_CIRCLE_HEIGHT_PX = DisplayUtils.sp2px(context, 36.0f);
        DEFAULT_BIG_CIRCLE_ANGLE_PX = DisplayUtils.sp2px(context, 20.0f);
        m21793b(context, attributeSet);
        Paint paint = new Paint();
        this.f27541f = paint;
        paint.setAntiAlias(true);
        this.f27541f.setColor(this.f27533A);
        this.f27542g = getPinWidth();
        this.f27543h = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        this.f27544i = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        Paint paint2 = new Paint();
        this.f27545j = paint2;
        paint2.setAntiAlias(true);
        this.f27545j.setColor(this.f27547l);
        Paint paint3 = new Paint();
        this.f27549n = paint3;
        paint3.setAntiAlias(true);
        this.f27549n.setColor(this.f27552q);
        this.f27549n.setTextAlign(Paint.Align.CENTER);
        int i = DEFAULT_TEXT_SIZE_SP;
        this.f27551p = i;
        this.f27549n.setTextSize((float) i);
        DIDIFontUtils.Companion.setPaintTypeface(context, this.f27549n, Typeface.DEFAULT_BOLD);
        Paint paint4 = new Paint();
        this.f27555t = paint4;
        paint4.setAntiAlias(true);
        this.f27555t.setColor(this.f27533A);
        this.f27556u = DisplayUtils.dp2px(context, 4.0f);
        this.f27557v = DisplayUtils.dp2px(context, 20.0f);
        if (context != null) {
            this.f27550o = context.getString(R.string.GRider_Homepage0714_Get_in_tpiW);
        }
    }

    /* renamed from: b */
    private void m21793b(Context context, AttributeSet attributeSet) {
        int dp2px = DisplayUtils.dp2px(context, 2.0f);
        if (context == null || attributeSet == null) {
            this.f27546k = dp2px;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.departurePinView);
        this.f27546k = (int) obtainStyledAttributes.getDimension(0, (float) dp2px);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m21784a() {
        this.f27541f.setColor(this.f27533A);
        this.f27555t.setColor(this.f27533A);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f27560y = getPinWidth();
        int pinHeight = getPinHeight();
        this.f27561z = pinHeight;
        setMeasuredDimension(this.f27560y, pinHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f27540H;
        int i = this.f27560y;
        int i2 = this.f27556u;
        int i3 = this.f27543h;
        rectF.set((((float) i) / 2.0f) - (((float) i2) / 2.0f), ((float) i3) / 2.0f, (((float) i) / 2.0f) + (((float) i2) / 2.0f), (float) (i3 + this.f27557v));
        RectF rectF2 = this.f27540H;
        int i4 = this.f27556u;
        canvas.drawRoundRect(rectF2, ((float) i4) / 2.0f, ((float) i4) / 2.0f, this.f27555t);
        RectF rectF3 = this.f27540H;
        int i5 = this.f27560y;
        int i6 = this.f27542g;
        rectF3.set((((float) i5) / 2.0f) - (((float) i6) / 2.0f), 0.0f, (((float) i5) / 2.0f) + (((float) i6) / 2.0f), (float) this.f27543h);
        RectF rectF4 = this.f27540H;
        int i7 = this.f27544i;
        canvas.drawRoundRect(rectF4, (float) i7, (float) i7, this.f27541f);
        this.f27545j.setAlpha((int) (this.f27548m * 255.0f));
        canvas.drawCircle(((float) this.f27560y) / 2.0f, ((float) this.f27543h) / 2.0f, (float) this.f27546k, this.f27545j);
        this.f27549n.setAlpha((int) (this.f27553r * 255.0f));
        this.f27549n.setTextSize(((float) this.f27551p) * this.f27554s);
        Paint.FontMetrics fontMetrics = this.f27549n.getFontMetrics();
        canvas.drawText(this.f27550o, ((float) this.f27560y) / 2.0f, (((float) this.f27543h) / 2.0f) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.f27549n);
    }

    public String getText() {
        return this.f27550o;
    }

    public boolean isNormal() {
        return this.f27558w == 1;
    }

    public boolean isDragging() {
        return this.f27558w == 2;
    }

    public boolean isLoading() {
        return this.f27558w == 3;
    }

    public boolean isCustom() {
        return this.f27558w == 4;
    }

    public void setPinColor(int i, int i2) {
        this.f27533A = i;
        this.f27534B = i;
        this.f27535C = i;
        this.f27536D = i;
        this.f27537E = i2;
        m21784a();
    }

    public void toNormal() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f27542g != getNormalWidth()) {
            arrayList.add(m21782a(this.f27542g, getNormalWidth()));
        }
        int i = this.f27543h;
        int i2 = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        if (i != i2) {
            arrayList.add(m21790b(i, i2));
        }
        int i3 = this.f27544i;
        int i4 = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        if (i3 != i4) {
            arrayList.add(m21795c(i3, i4));
        }
        int i5 = this.f27533A;
        int i6 = this.f27535C;
        if (i5 != i6) {
            arrayList.add(m21798d(i5, i6));
        }
        if (isLoading()) {
            this.f27554s = 1.0f;
        } else if (isCustom()) {
            this.f27554s = 1.0f;
        }
        float f = this.f27553r;
        if (f < 1.0f) {
            arrayList.add(m21789b(f, 1.0f));
        }
        float f2 = this.f27554s;
        if (f2 < 1.0f) {
            arrayList.add(m21794c(f2, 1.0f));
        }
        float f3 = this.f27548m;
        if (f3 > 0.0f) {
            arrayList.add(m21781a(f3, 0.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f27538F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f27539G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f27539G = false;
                }
            });
            this.f27558w = 1;
            this.f27538F.setDuration(400);
            this.f27538F.playTogether(arrayList);
            this.f27538F.start();
        }
    }

    public void toDragging() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f27542g != getDraggingWidth()) {
            arrayList.add(m21782a(this.f27542g, getDraggingWidth()));
        }
        if (this.f27543h != getDraggingWidth()) {
            arrayList.add(m21790b(this.f27543h, getDraggingWidth()));
        }
        int i = this.f27544i;
        int i2 = DRAGGING_BIG_CIRCLE_RADIUS_PX;
        if (i != i2) {
            arrayList.add(m21795c(i, i2));
        }
        int i3 = this.f27533A;
        int i4 = this.f27535C;
        if (i3 != i4) {
            arrayList.add(m21798d(i3, i4));
        }
        float f = this.f27553r;
        if (f > 0.0f) {
            arrayList.add(m21789b(f, 0.0f));
        }
        float f2 = this.f27554s;
        if (f2 > 0.0f) {
            arrayList.add(m21794c(f2, 0.0f));
        }
        float f3 = this.f27548m;
        if (f3 < 1.0f) {
            arrayList.add(m21781a(f3, 1.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f27538F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f27539G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f27539G = false;
                }
            });
            this.f27558w = 2;
            this.f27538F.setDuration(400);
            this.f27538F.playTogether(arrayList);
            this.f27538F.start();
        }
    }

    public void toLoading() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f27542g != getLoadingWidth()) {
            arrayList.add(m21782a(this.f27542g, getLoadingWidth()));
        }
        int i = this.f27543h;
        int i2 = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        if (i != i2) {
            arrayList.add(m21790b(i, i2));
        }
        int i3 = this.f27544i;
        int i4 = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        if (i3 != i4) {
            arrayList.add(m21795c(i3, i4));
        }
        int i5 = this.f27533A;
        int i6 = this.f27535C;
        if (i5 != i6) {
            arrayList.add(m21798d(i5, i6));
        }
        float f = this.f27553r;
        if (f > 0.0f) {
            arrayList.add(m21789b(f, 0.0f));
        }
        float f2 = this.f27554s;
        if (f2 > 0.0f) {
            arrayList.add(m21794c(f2, 0.0f));
        }
        float f3 = this.f27548m;
        if (f3 > 0.0f) {
            arrayList.add(m21781a(f3, 0.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f27538F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f27539G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f27539G = false;
                }
            });
            this.f27558w = 3;
            this.f27538F.setDuration(400);
            this.f27538F.playTogether(arrayList);
            this.f27538F.start();
        }
    }

    public void showText(String str) {
        this.f27550o = str;
        toNormal();
    }

    public void animSetBigCircleWidthHeightAngle(int i, int i2, int i3) {
        if (i != this.f27542g || i2 != this.f27543h || i3 != this.f27544i || this.f27533A != this.f27535C) {
            stopAnimation();
            ArrayList arrayList = new ArrayList();
            int i4 = this.f27542g;
            if (i != i4) {
                arrayList.add(m21782a(i4, i));
            }
            int i5 = this.f27543h;
            if (i2 != i5) {
                arrayList.add(m21790b(i5, i2));
            }
            int i6 = this.f27544i;
            if (i3 != i6) {
                arrayList.add(m21795c(i6, i3));
            }
            int i7 = this.f27534B;
            int i8 = this.f27535C;
            if (!(i7 == i8 || this.f27533A == i8)) {
                arrayList.add(m21798d(i7, i8));
            }
            float f = this.f27553r;
            if (f > 0.0f) {
                arrayList.add(m21789b(f, 0.0f));
            }
            float f2 = this.f27554s;
            if (f2 > 0.0f) {
                arrayList.add(m21794c(f2, 0.0f));
            }
            float f3 = this.f27548m;
            if (f3 > 0.0f) {
                arrayList.add(m21781a(f3, 0.0f));
            }
            if (arrayList.size() != 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f27538F = animatorSet;
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        boolean unused = PinView.this.f27539G = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        boolean unused = PinView.this.f27539G = false;
                    }
                });
                this.f27558w = 4;
                this.f27538F.setDuration(400);
                this.f27538F.playTogether(arrayList);
                this.f27538F.start();
            }
        }
    }

    public void stopAnimation() {
        this.f27539G = false;
        AnimatorSet animatorSet = this.f27538F;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f27538F = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m21782a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21801f(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m21801f(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f27542g = intValue;
        setPinWidthHeight(intValue, this.f27561z);
    }

    /* renamed from: b */
    private ValueAnimator m21790b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21800e(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m21800e(ValueAnimator valueAnimator) {
        this.f27543h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int pinHeight = getPinHeight();
        this.f27561z = pinHeight;
        setPinWidthHeight(this.f27542g, pinHeight);
    }

    /* renamed from: c */
    private ValueAnimator m21795c(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21799d(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m21799d(ValueAnimator valueAnimator) {
        this.f27544i = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    /* renamed from: a */
    private ValueAnimator m21783a(boolean z) {
        return z ? m21781a(0.0f, 1.0f) : m21781a(1.0f, 0.0f);
    }

    /* renamed from: a */
    private ValueAnimator m21781a(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21797c(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m21797c(ValueAnimator valueAnimator) {
        this.f27548m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: d */
    private ValueAnimator m21798d(int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, i2) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21785a(this.f$1, this.f$2, valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21785a(int i, int i2, ValueAnimator valueAnimator) {
        setPinColor(ColorUtils.blendARGB(i, i2, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
    }

    /* renamed from: b */
    private ValueAnimator m21791b(boolean z) {
        return z ? m21789b(0.0f, 1.0f) : m21789b(1.0f, 0.0f);
    }

    /* renamed from: b */
    private ValueAnimator m21789b(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21792b(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21792b(ValueAnimator valueAnimator) {
        this.f27553r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: c */
    private ValueAnimator m21796c(boolean z) {
        return z ? m21794c(0.0f, 1.0f) : m21794c(1.0f, 0.0f);
    }

    /* renamed from: c */
    private ValueAnimator m21794c(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21786a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21786a(ValueAnimator valueAnimator) {
        this.f27554s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void setPinStartEndColor(int i, int i2) {
        this.f27534B = i;
        this.f27535C = i2;
    }

    public void setPinColor(int i) {
        this.f27533A = i;
        this.f27541f.setColor(i);
        this.f27555t.setColor(i);
        invalidate();
    }

    public void setPinWidthHeight(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public int getPinWidth() {
        if (this.f27539G) {
            return this.f27542g;
        }
        if (isNormal()) {
            return getNormalWidth();
        }
        if (isDragging()) {
            return getDraggingWidth();
        }
        if (isLoading()) {
            return getLoadingWidth();
        }
        return this.f27542g;
    }

    public int getPinHeight() {
        return this.f27543h + this.f27557v;
    }

    public int getNormalWidth() {
        return TEXT_LEFT_RIGHT_PADDING_PX + getTextWidth(this.f27550o);
    }

    public int getNormalHeight() {
        return DEFAULT_BIG_CIRCLE_HEIGHT_PX;
    }

    public int getDraggingWidth() {
        return DRAGGING_BIG_CIRCLE_RADIUS_PX * 2;
    }

    public int getDraggingHeight() {
        return DRAGGING_BIG_CIRCLE_RADIUS_PX * 2;
    }

    public int getLoadingWidth() {
        return LOADING_BIG_CIRCLE_WIDTH_PX;
    }

    public int getLoadingHeight() {
        return DEFAULT_BIG_CIRCLE_HEIGHT_PX;
    }

    public int getBigCircleWidth() {
        return this.f27542g;
    }

    public int getBigCircleHeight() {
        return this.f27543h;
    }

    public static int getTextWidth(String str) {
        if (f27527I == null) {
            Paint paint = new Paint();
            f27527I = paint;
            paint.setAntiAlias(true);
            f27527I.setTextAlign(Paint.Align.CENTER);
            f27527I.setTextSize((float) DEFAULT_TEXT_SIZE_SP);
            f27527I.setTypeface(Typeface.DEFAULT_BOLD);
        }
        Paint paint2 = f27527I;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return (int) paint2.measureText(str);
    }
}
