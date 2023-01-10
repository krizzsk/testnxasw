package com.didi.map.global.component.dropoff.pin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
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
    private static Paint f27809I = null;
    public static int LOADING_BIG_CIRCLE_WIDTH_PX = 0;
    public static final int NO_PARKING_COLOR = Color.parseColor("#fd4060");
    public static int TEXT_LEFT_RIGHT_PADDING_PX = 0;

    /* renamed from: a */
    private static final String f27810a = "PinView";

    /* renamed from: b */
    private static final int f27811b = 1;

    /* renamed from: c */
    private static final int f27812c = 2;

    /* renamed from: d */
    private static final int f27813d = 3;

    /* renamed from: e */
    private static final int f27814e = 4;

    /* renamed from: A */
    private int f27815A;

    /* renamed from: B */
    private int f27816B;

    /* renamed from: C */
    private int f27817C;

    /* renamed from: D */
    private int f27818D;

    /* renamed from: E */
    private int f27819E;

    /* renamed from: F */
    private AnimatorSet f27820F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f27821G;

    /* renamed from: H */
    private RectF f27822H;

    /* renamed from: f */
    private Paint f27823f;

    /* renamed from: g */
    private int f27824g;

    /* renamed from: h */
    private int f27825h;

    /* renamed from: i */
    private int f27826i;

    /* renamed from: j */
    private Paint f27827j;

    /* renamed from: k */
    private int f27828k;

    /* renamed from: l */
    private int f27829l;

    /* renamed from: m */
    private float f27830m;

    /* renamed from: n */
    private Paint f27831n;

    /* renamed from: o */
    private String f27832o;

    /* renamed from: p */
    private int f27833p;

    /* renamed from: q */
    private int f27834q;

    /* renamed from: r */
    private float f27835r;

    /* renamed from: s */
    private float f27836s;

    /* renamed from: t */
    private Paint f27837t;

    /* renamed from: u */
    private int f27838u;

    /* renamed from: v */
    private int f27839v;

    /* renamed from: w */
    private int f27840w;

    /* renamed from: x */
    private int f27841x;

    /* renamed from: y */
    private int f27842y;

    /* renamed from: z */
    private int f27843z;

    public int getNoParkingColor() {
        return this.f27819E;
    }

    public int getNormalColor() {
        return this.f27818D;
    }

    public PinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27823f = null;
        this.f27824g = 0;
        this.f27825h = 0;
        this.f27826i = 0;
        this.f27827j = null;
        this.f27828k = 0;
        this.f27829l = Color.parseColor("#ffffff");
        this.f27830m = 0.0f;
        this.f27831n = null;
        this.f27832o = "PICK-UP";
        this.f27833p = 12;
        this.f27834q = Color.parseColor("#ffffff");
        this.f27835r = 1.0f;
        this.f27836s = 1.0f;
        this.f27837t = null;
        this.f27838u = 0;
        this.f27839v = 0;
        this.f27840w = 3;
        this.f27841x = 400;
        this.f27842y = 0;
        this.f27843z = 0;
        int i2 = DEFAULT_COLOR;
        this.f27815A = i2;
        this.f27816B = i2;
        this.f27817C = i2;
        this.f27818D = i2;
        this.f27819E = NO_PARKING_COLOR;
        this.f27821G = false;
        this.f27822H = new RectF();
        m21966a(context);
    }

    /* renamed from: a */
    private void m21966a(Context context) {
        DEFAULT_TEXT_SIZE_SP = DisplayUtils.sp2px(context, 12.0f);
        TEXT_LEFT_RIGHT_PADDING_PX = DisplayUtils.dp2px(context, 14.0f) * 2;
        DRAGGING_BIG_CIRCLE_RADIUS_PX = DisplayUtils.dp2px(context, 15.0f);
        LOADING_BIG_CIRCLE_WIDTH_PX = DisplayUtils.dp2px(context, 60.0f);
        DEFAULT_BIG_CIRCLE_HEIGHT_PX = DisplayUtils.sp2px(context, 36.0f);
        DEFAULT_BIG_CIRCLE_ANGLE_PX = DisplayUtils.sp2px(context, 20.0f);
        Paint paint = new Paint();
        this.f27823f = paint;
        paint.setAntiAlias(true);
        this.f27823f.setColor(this.f27815A);
        this.f27824g = getPinWidth();
        this.f27825h = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        this.f27826i = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        Paint paint2 = new Paint();
        this.f27827j = paint2;
        paint2.setAntiAlias(true);
        this.f27827j.setColor(this.f27829l);
        this.f27828k = DisplayUtils.dp2px(context, 2.0f);
        Paint paint3 = new Paint();
        this.f27831n = paint3;
        paint3.setAntiAlias(true);
        this.f27831n.setColor(this.f27834q);
        this.f27831n.setTextAlign(Paint.Align.CENTER);
        int i = DEFAULT_TEXT_SIZE_SP;
        this.f27833p = i;
        this.f27831n.setTextSize((float) i);
        DIDIFontUtils.Companion.setPaintTypeface(context, this.f27831n, Typeface.DEFAULT_BOLD);
        Paint paint4 = new Paint();
        this.f27837t = paint4;
        paint4.setAntiAlias(true);
        this.f27837t.setColor(this.f27815A);
        this.f27838u = DisplayUtils.dp2px(context, 4.0f);
        this.f27839v = DisplayUtils.dp2px(context, 20.0f);
        if (context != null) {
            this.f27832o = context.getString(R.string.GRider_destination_Departure_point_lmkd);
        }
    }

    /* renamed from: a */
    private void m21963a() {
        this.f27823f.setColor(this.f27815A);
        this.f27837t.setColor(this.f27815A);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f27842y = getPinWidth();
        int pinHeight = getPinHeight();
        this.f27843z = pinHeight;
        setMeasuredDimension(this.f27842y, pinHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f27822H;
        int i = this.f27842y;
        int i2 = this.f27838u;
        int i3 = this.f27825h;
        rectF.set((((float) i) / 2.0f) - (((float) i2) / 2.0f), ((float) i3) / 2.0f, (((float) i) / 2.0f) + (((float) i2) / 2.0f), (float) (i3 + this.f27839v));
        RectF rectF2 = this.f27822H;
        int i4 = this.f27838u;
        canvas.drawRoundRect(rectF2, ((float) i4) / 2.0f, ((float) i4) / 2.0f, this.f27837t);
        RectF rectF3 = this.f27822H;
        int i5 = this.f27842y;
        int i6 = this.f27824g;
        rectF3.set((((float) i5) / 2.0f) - (((float) i6) / 2.0f), 0.0f, (((float) i5) / 2.0f) + (((float) i6) / 2.0f), (float) this.f27825h);
        RectF rectF4 = this.f27822H;
        int i7 = this.f27826i;
        canvas.drawRoundRect(rectF4, (float) i7, (float) i7, this.f27823f);
        this.f27827j.setAlpha((int) (this.f27830m * 255.0f));
        canvas.drawCircle(((float) this.f27842y) / 2.0f, ((float) this.f27825h) / 2.0f, (float) this.f27828k, this.f27827j);
        this.f27831n.setAlpha((int) (this.f27835r * 255.0f));
        this.f27831n.setTextSize(((float) this.f27833p) * this.f27836s);
        Paint.FontMetrics fontMetrics = this.f27831n.getFontMetrics();
        canvas.drawText(this.f27832o, ((float) this.f27842y) / 2.0f, (((float) this.f27825h) / 2.0f) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.f27831n);
    }

    public String getText() {
        return this.f27832o;
    }

    public boolean isNormal() {
        return this.f27840w == 1;
    }

    public boolean isDragging() {
        return this.f27840w == 2;
    }

    public boolean isLoading() {
        return this.f27840w == 3;
    }

    public boolean isCustom() {
        return this.f27840w == 4;
    }

    public void setPinColor(int i, int i2) {
        this.f27815A = i;
        this.f27816B = i;
        this.f27817C = i;
        this.f27818D = i;
        this.f27819E = i2;
        m21963a();
    }

    public void toNormal() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f27824g != getNormalWidth()) {
            arrayList.add(m21961a(this.f27824g, getNormalWidth()));
        }
        int i = this.f27825h;
        int i2 = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        if (i != i2) {
            arrayList.add(m21969b(i, i2));
        }
        int i3 = this.f27826i;
        int i4 = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        if (i3 != i4) {
            arrayList.add(m21973c(i3, i4));
        }
        int i5 = this.f27815A;
        int i6 = this.f27817C;
        if (i5 != i6) {
            arrayList.add(m21976d(i5, i6));
        }
        if (isLoading()) {
            this.f27836s = 1.0f;
        } else if (isCustom()) {
            this.f27836s = 1.0f;
        }
        float f = this.f27835r;
        if (f < 1.0f) {
            arrayList.add(m21968b(f, 1.0f));
        }
        float f2 = this.f27836s;
        if (f2 < 1.0f) {
            arrayList.add(m21972c(f2, 1.0f));
        }
        float f3 = this.f27830m;
        if (f3 > 0.0f) {
            arrayList.add(m21960a(f3, 0.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f27820F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f27821G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f27821G = false;
                }
            });
            this.f27840w = 1;
            this.f27820F.setDuration(400);
            this.f27820F.playTogether(arrayList);
            this.f27820F.start();
        }
    }

    public void toDragging() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f27824g != getDraggingWidth()) {
            arrayList.add(m21961a(this.f27824g, getDraggingWidth()));
        }
        if (this.f27825h != getDraggingWidth()) {
            arrayList.add(m21969b(this.f27825h, getDraggingWidth()));
        }
        int i = this.f27826i;
        int i2 = DRAGGING_BIG_CIRCLE_RADIUS_PX;
        if (i != i2) {
            arrayList.add(m21973c(i, i2));
        }
        int i3 = this.f27815A;
        int i4 = this.f27817C;
        if (i3 != i4) {
            arrayList.add(m21976d(i3, i4));
        }
        float f = this.f27835r;
        if (f > 0.0f) {
            arrayList.add(m21968b(f, 0.0f));
        }
        float f2 = this.f27836s;
        if (f2 > 0.0f) {
            arrayList.add(m21972c(f2, 0.0f));
        }
        float f3 = this.f27830m;
        if (f3 < 1.0f) {
            arrayList.add(m21960a(f3, 1.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f27820F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f27821G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f27821G = false;
                }
            });
            this.f27840w = 2;
            this.f27820F.setDuration(400);
            this.f27820F.playTogether(arrayList);
            this.f27820F.start();
        }
    }

    public void toLoading() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f27824g != getLoadingWidth()) {
            arrayList.add(m21961a(this.f27824g, getLoadingWidth()));
        }
        int i = this.f27825h;
        int i2 = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        if (i != i2) {
            arrayList.add(m21969b(i, i2));
        }
        int i3 = this.f27826i;
        int i4 = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        if (i3 != i4) {
            arrayList.add(m21973c(i3, i4));
        }
        int i5 = this.f27815A;
        int i6 = this.f27817C;
        if (i5 != i6) {
            arrayList.add(m21976d(i5, i6));
        }
        float f = this.f27835r;
        if (f > 0.0f) {
            arrayList.add(m21968b(f, 0.0f));
        }
        float f2 = this.f27836s;
        if (f2 > 0.0f) {
            arrayList.add(m21972c(f2, 0.0f));
        }
        float f3 = this.f27830m;
        if (f3 > 0.0f) {
            arrayList.add(m21960a(f3, 0.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f27820F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f27821G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f27821G = false;
                }
            });
            this.f27840w = 3;
            this.f27820F.setDuration(400);
            this.f27820F.playTogether(arrayList);
            this.f27820F.start();
        }
    }

    public void showText(String str) {
        this.f27832o = str;
        toNormal();
    }

    public void animSetBigCircleWidthHeightAngle(int i, int i2, int i3) {
        if (i != this.f27824g || i2 != this.f27825h || i3 != this.f27826i || this.f27815A != this.f27817C) {
            stopAnimation();
            ArrayList arrayList = new ArrayList();
            int i4 = this.f27824g;
            if (i != i4) {
                arrayList.add(m21961a(i4, i));
            }
            int i5 = this.f27825h;
            if (i2 != i5) {
                arrayList.add(m21969b(i5, i2));
            }
            int i6 = this.f27826i;
            if (i3 != i6) {
                arrayList.add(m21973c(i6, i3));
            }
            int i7 = this.f27816B;
            int i8 = this.f27817C;
            if (!(i7 == i8 || this.f27815A == i8)) {
                arrayList.add(m21976d(i7, i8));
            }
            float f = this.f27835r;
            if (f > 0.0f) {
                arrayList.add(m21968b(f, 0.0f));
            }
            float f2 = this.f27836s;
            if (f2 > 0.0f) {
                arrayList.add(m21972c(f2, 0.0f));
            }
            float f3 = this.f27830m;
            if (f3 > 0.0f) {
                arrayList.add(m21960a(f3, 0.0f));
            }
            if (arrayList.size() != 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f27820F = animatorSet;
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        boolean unused = PinView.this.f27821G = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        boolean unused = PinView.this.f27821G = false;
                    }
                });
                this.f27840w = 4;
                this.f27820F.setDuration(400);
                this.f27820F.playTogether(arrayList);
                this.f27820F.start();
            }
        }
    }

    public void stopAnimation() {
        this.f27821G = false;
        AnimatorSet animatorSet = this.f27820F;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f27820F = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m21961a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21979f(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m21979f(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f27824g = intValue;
        setPinWidthHeight(intValue, this.f27843z);
    }

    /* renamed from: b */
    private ValueAnimator m21969b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21978e(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m21978e(ValueAnimator valueAnimator) {
        this.f27825h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int pinHeight = getPinHeight();
        this.f27843z = pinHeight;
        setPinWidthHeight(this.f27824g, pinHeight);
    }

    /* renamed from: c */
    private ValueAnimator m21973c(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21977d(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m21977d(ValueAnimator valueAnimator) {
        this.f27826i = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    /* renamed from: a */
    private ValueAnimator m21962a(boolean z) {
        return z ? m21960a(0.0f, 1.0f) : m21960a(1.0f, 0.0f);
    }

    /* renamed from: a */
    private ValueAnimator m21960a(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21975c(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m21975c(ValueAnimator valueAnimator) {
        this.f27830m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: d */
    private ValueAnimator m21976d(int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, i2) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21964a(this.f$1, this.f$2, valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21964a(int i, int i2, ValueAnimator valueAnimator) {
        setPinColor(ColorUtils.blendARGB(i, i2, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
    }

    /* renamed from: b */
    private ValueAnimator m21970b(boolean z) {
        return z ? m21968b(0.0f, 1.0f) : m21968b(1.0f, 0.0f);
    }

    /* renamed from: b */
    private ValueAnimator m21968b(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21971b(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21971b(ValueAnimator valueAnimator) {
        this.f27835r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: c */
    private ValueAnimator m21974c(boolean z) {
        return z ? m21972c(0.0f, 1.0f) : m21972c(1.0f, 0.0f);
    }

    /* renamed from: c */
    private ValueAnimator m21972c(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m21965a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21965a(ValueAnimator valueAnimator) {
        this.f27836s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void setPinStartEndColor(int i, int i2) {
        this.f27816B = i;
        this.f27817C = i2;
    }

    public void setPinColor(int i) {
        this.f27815A = i;
        this.f27823f.setColor(i);
        this.f27837t.setColor(i);
        invalidate();
    }

    public void setPinWidthHeight(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public int getPinWidth() {
        if (this.f27821G) {
            return this.f27824g;
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
        return this.f27824g;
    }

    public int getPinHeight() {
        return this.f27825h + this.f27839v;
    }

    public int getNormalWidth() {
        return TEXT_LEFT_RIGHT_PADDING_PX + getTextWidth(this.f27832o);
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
        return this.f27824g;
    }

    public int getBigCircleHeight() {
        return this.f27825h;
    }

    public static int getTextWidth(String str) {
        if (f27809I == null) {
            Paint paint = new Paint();
            f27809I = paint;
            paint.setAntiAlias(true);
            f27809I.setTextAlign(Paint.Align.CENTER);
            f27809I.setTextSize((float) DEFAULT_TEXT_SIZE_SP);
            f27809I.setTypeface(Typeface.DEFAULT_BOLD);
        }
        Paint paint2 = f27809I;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return (int) paint2.measureText(str);
    }
}
