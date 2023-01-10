package com.didi.sdk.view.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.widget.ScrollerCompat;
import com.didi.passenger.C11267R;

public class NumberPickerView extends View {

    /* renamed from: A */
    private static final boolean f40715A = false;

    /* renamed from: B */
    private static final boolean f40716B = true;

    /* renamed from: a */
    private static final int f40717a = -13421773;

    /* renamed from: b */
    private static final int f40718b = -695533;

    /* renamed from: c */
    private static final int f40719c = 14;

    /* renamed from: d */
    private static final int f40720d = 16;

    /* renamed from: e */
    private static final int f40721e = 14;

    /* renamed from: f */
    private static final int f40722f = 8;

    /* renamed from: g */
    private static final int f40723g = 8;

    /* renamed from: h */
    private static final int f40724h = -695533;

    /* renamed from: i */
    private static final int f40725i = 2;

    /* renamed from: j */
    private static final int f40726j = 0;

    /* renamed from: k */
    private static final int f40727k = 3;

    /* renamed from: l */
    private static final int f40728l = 5;

    /* renamed from: m */
    private static final int f40729m = 2;

    /* renamed from: n */
    private static final int f40730n = 1;

    /* renamed from: o */
    private static final int f40731o = 2;

    /* renamed from: p */
    private static final int f40732p = 3;

    /* renamed from: q */
    private static final int f40733q = 32;

    /* renamed from: r */
    private static final int f40734r = 300;

    /* renamed from: s */
    private static final int f40735s = 300;

    /* renamed from: t */
    private static final int f40736t = 600;

    /* renamed from: u */
    private static final String f40737u = "start";

    /* renamed from: v */
    private static final String f40738v = "middle";

    /* renamed from: w */
    private static final String f40739w = "end";

    /* renamed from: x */
    private static final boolean f40740x = true;

    /* renamed from: y */
    private static final boolean f40741y = true;

    /* renamed from: z */
    private static final boolean f40742z = false;

    /* renamed from: C */
    private int f40743C = f40717a;

    /* renamed from: D */
    private int f40744D = -695533;

    /* renamed from: E */
    private int f40745E = -695533;

    /* renamed from: F */
    private int f40746F = 0;

    /* renamed from: G */
    private int f40747G = 0;

    /* renamed from: H */
    private int f40748H = 0;

    /* renamed from: I */
    private int f40749I = 0;

    /* renamed from: J */
    private int f40750J = 0;

    /* renamed from: K */
    private int f40751K = 0;

    /* renamed from: L */
    private int f40752L = 0;

    /* renamed from: M */
    private int f40753M = 0;

    /* renamed from: N */
    private int f40754N = 0;

    /* renamed from: O */
    private int f40755O = -695533;

    /* renamed from: P */
    private int f40756P = 2;

    /* renamed from: Q */
    private int f40757Q = 0;

    /* renamed from: R */
    private int f40758R = 0;

    /* renamed from: S */
    private int f40759S = 3;

    /* renamed from: T */
    private int f40760T = 0;

    /* renamed from: U */
    private int f40761U = 0;

    /* renamed from: V */
    private int f40762V = -1;

    /* renamed from: W */
    private int f40763W = -1;

    /* renamed from: X */
    private int f40764X = 0;

    /* renamed from: Y */
    private int f40765Y = 0;

    /* renamed from: Z */
    private int f40766Z = 0;

    /* renamed from: aA */
    private Paint f40767aA = new Paint();

    /* renamed from: aB */
    private TextPaint f40768aB = new TextPaint();

    /* renamed from: aC */
    private Paint f40769aC = new Paint();

    /* renamed from: aD */
    private String[] f40770aD;

    /* renamed from: aE */
    private CharSequence[] f40771aE;

    /* renamed from: aF */
    private CharSequence[] f40772aF;

    /* renamed from: aG */
    private HandlerThread f40773aG;
    /* access modifiers changed from: private */

    /* renamed from: aH */
    public Handler f40774aH;
    /* access modifiers changed from: private */

    /* renamed from: aI */
    public Handler f40775aI;

    /* renamed from: aJ */
    private OnValueChangeListenerRelativeToRaw f40776aJ;

    /* renamed from: aK */
    private OnValueChangeListener f40777aK;

    /* renamed from: aL */
    private OnScrollListener f40778aL;

    /* renamed from: aM */
    private OnValueChangeListenerInScrolling f40779aM;
    /* access modifiers changed from: private */

    /* renamed from: aN */
    public int f40780aN = 0;

    /* renamed from: aO */
    private int f40781aO;

    /* renamed from: aP */
    private int f40782aP;

    /* renamed from: aQ */
    private int f40783aQ;

    /* renamed from: aR */
    private int f40784aR;

    /* renamed from: aS */
    private float f40785aS = 0.0f;

    /* renamed from: aT */
    private float f40786aT = 0.0f;

    /* renamed from: aU */
    private float f40787aU = 0.0f;

    /* renamed from: aV */
    private boolean f40788aV = false;

    /* renamed from: aW */
    private int f40789aW;

    /* renamed from: aX */
    private int f40790aX;
    /* access modifiers changed from: private */

    /* renamed from: aY */
    public int f40791aY;

    /* renamed from: aZ */
    private float f40792aZ;

    /* renamed from: aa */
    private int f40793aa = 0;

    /* renamed from: ab */
    private int f40794ab = 0;

    /* renamed from: ac */
    private int f40795ac = 0;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f40796ad = 0;

    /* renamed from: ae */
    private int f40797ae = 150;

    /* renamed from: af */
    private int f40798af = 8;

    /* renamed from: ag */
    private String f40799ag;

    /* renamed from: ah */
    private String f40800ah = "";

    /* renamed from: ai */
    private String f40801ai;

    /* renamed from: aj */
    private String f40802aj;

    /* renamed from: ak */
    private String f40803ak;

    /* renamed from: al */
    private String f40804al;

    /* renamed from: am */
    private float f40805am = 1.0f;

    /* renamed from: an */
    private float f40806an = 0.0f;

    /* renamed from: ao */
    private float f40807ao = 0.0f;

    /* renamed from: ap */
    private float f40808ap = 0.0f;

    /* renamed from: aq */
    private boolean f40809aq = true;

    /* renamed from: ar */
    private boolean f40810ar = true;

    /* renamed from: as */
    private boolean f40811as = false;

    /* renamed from: at */
    private boolean f40812at = false;

    /* renamed from: au */
    private boolean f40813au = true;

    /* renamed from: av */
    private boolean f40814av = false;

    /* renamed from: aw */
    private boolean f40815aw = false;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public boolean f40816ax = true;
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public ScrollerCompat f40817ay;

    /* renamed from: az */
    private VelocityTracker f40818az;

    /* renamed from: ba */
    private float f40819ba;

    /* renamed from: bb */
    private float f40820bb;

    /* renamed from: bc */
    private int f40821bc = 0;
    /* access modifiers changed from: private */

    /* renamed from: bd */
    public int f40822bd = 0;
    /* access modifiers changed from: private */

    /* renamed from: be */
    public int f40823be = 0;

    /* renamed from: bf */
    private int f40824bf = 0;

    /* renamed from: bg */
    private int f40825bg = 0;

    /* renamed from: bh */
    private boolean f40826bh;

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(NumberPickerView numberPickerView, int i);
    }

    public interface OnValueChangeListener {
        void onValueChange(NumberPickerView numberPickerView, int i, int i2);
    }

    public interface OnValueChangeListenerInScrolling {
        void onValueChangeInScrolling(NumberPickerView numberPickerView, int i, int i2);
    }

    public interface OnValueChangeListenerRelativeToRaw {
        void onValueChangeRelativeToRaw(NumberPickerView numberPickerView, int i, int i2, String[] strArr);
    }

    /* renamed from: a */
    private float m30548a(float f, float f2, float f3) {
        return f2 + ((f3 - f2) * f);
    }

    /* renamed from: a */
    private int m30550a(float f, int i, int i2) {
        int i3 = (i & -16777216) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        int i6 = (i & 255) >>> 0;
        return ((int) (((float) i6) + (((float) (((i2 & 255) >>> 0) - i6)) * f))) | (((int) (((float) i3) + (((float) (((-16777216 & i2) >>> 24) - i3)) * f))) << 24) | (((int) (((float) i4) + (((float) (((16711680 & i2) >>> 16) - i4)) * f))) << 16) | (((int) (((float) i5) + (((float) (((65280 & i2) >>> 8) - i5)) * f))) << 8);
    }

    public NumberPickerView(Context context) {
        super(context);
        m30564a(context);
    }

    public NumberPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30565a(context, attributeSet);
        m30564a(context);
    }

    public NumberPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30565a(context, attributeSet);
        m30564a(context);
    }

    /* renamed from: a */
    private void m30565a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.NumberPickerView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 17) {
                    this.f40759S = obtainStyledAttributes.getInt(index, 3);
                } else if (index == 3) {
                    this.f40755O = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == 4) {
                    this.f40756P = obtainStyledAttributes.getDimensionPixelSize(index, 2);
                } else if (index == 5) {
                    this.f40757Q = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 6) {
                    this.f40758R = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 19) {
                    this.f40770aD = m30573a(obtainStyledAttributes.getTextArray(index));
                } else if (index == 21) {
                    this.f40743C = obtainStyledAttributes.getColor(index, f40717a);
                } else if (index == 22) {
                    this.f40744D = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == 20) {
                    this.f40745E = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == 25) {
                    this.f40746F = obtainStyledAttributes.getDimensionPixelSize(index, m30553a(context, 14.0f));
                } else if (index == 26) {
                    this.f40747G = obtainStyledAttributes.getDimensionPixelSize(index, m30553a(context, 16.0f));
                } else if (index == 24) {
                    this.f40748H = obtainStyledAttributes.getDimensionPixelSize(index, m30553a(context, 14.0f));
                } else if (index == 14) {
                    this.f40762V = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 13) {
                    this.f40763W = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 27) {
                    this.f40810ar = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 18) {
                    this.f40809aq = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 8) {
                    this.f40799ag = obtainStyledAttributes.getString(index);
                } else if (index == 0) {
                    this.f40804al = obtainStyledAttributes.getString(index);
                } else if (index == 7) {
                    this.f40803ak = obtainStyledAttributes.getString(index);
                } else if (index == 12) {
                    this.f40751K = obtainStyledAttributes.getDimensionPixelSize(index, m30574b(context, 8.0f));
                } else if (index == 11) {
                    this.f40752L = obtainStyledAttributes.getDimensionPixelSize(index, m30574b(context, 8.0f));
                } else if (index == 10) {
                    this.f40753M = obtainStyledAttributes.getDimensionPixelSize(index, m30574b(context, 2.0f));
                } else if (index == 9) {
                    this.f40754N = obtainStyledAttributes.getDimensionPixelSize(index, m30574b(context, 5.0f));
                } else if (index == 1) {
                    this.f40771aE = obtainStyledAttributes.getTextArray(index);
                } else if (index == 2) {
                    this.f40772aF = obtainStyledAttributes.getTextArray(index);
                } else if (index == 16) {
                    this.f40815aw = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == 15) {
                    this.f40816ax = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 23) {
                    this.f40802aj = obtainStyledAttributes.getString(index);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private void m30564a(Context context) {
        this.f40817ay = ScrollerCompat.create(context);
        this.f40797ae = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.f40798af = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.f40746F == 0) {
            this.f40746F = m30553a(context, 14.0f);
        }
        if (this.f40747G == 0) {
            this.f40747G = m30553a(context, 16.0f);
        }
        if (this.f40748H == 0) {
            this.f40748H = m30553a(context, 14.0f);
        }
        if (this.f40751K == 0) {
            this.f40751K = m30574b(context, 8.0f);
        }
        if (this.f40752L == 0) {
            this.f40752L = m30574b(context, 8.0f);
        }
        this.f40767aA.setColor(this.f40755O);
        this.f40767aA.setAntiAlias(true);
        this.f40767aA.setStyle(Paint.Style.STROKE);
        this.f40767aA.setStrokeWidth((float) this.f40756P);
        this.f40768aB.setColor(this.f40743C);
        this.f40768aB.setAntiAlias(true);
        this.f40768aB.setTextAlign(Paint.Align.CENTER);
        this.f40769aC.setColor(this.f40745E);
        this.f40769aC.setAntiAlias(true);
        this.f40769aC.setTextAlign(Paint.Align.CENTER);
        this.f40769aC.setTextSize((float) this.f40748H);
        int i = this.f40759S;
        if (i % 2 == 0) {
            this.f40759S = i + 1;
        }
        if (this.f40762V == -1 || this.f40763W == -1) {
            m30604k();
        }
        m30559a();
    }

    /* renamed from: a */
    private void m30559a() {
        HandlerThread handlerThread = new HandlerThread("HandlerThread-For-Refreshing");
        this.f40773aG = handlerThread;
        handlerThread.start();
        this.f40774aH = new Handler(this.f40773aG.getLooper()) {
            public void handleMessage(Message message) {
                int i;
                int i2;
                int i3 = message.what;
                if (i3 == 1) {
                    int i4 = 0;
                    if (!NumberPickerView.this.f40817ay.isFinished()) {
                        if (NumberPickerView.this.f40780aN == 0) {
                            NumberPickerView.this.m30578b(1);
                        }
                        NumberPickerView.this.f40774aH.sendMessageDelayed(NumberPickerView.this.m30556a(1, 0, 0, message.obj), 32);
                        return;
                    }
                    if (NumberPickerView.this.f40822bd != 0) {
                        if (NumberPickerView.this.f40780aN == 0) {
                            NumberPickerView.this.m30578b(1);
                        }
                        if (NumberPickerView.this.f40822bd < (-NumberPickerView.this.f40791aY) / 2) {
                            i2 = (int) ((((float) (NumberPickerView.this.f40791aY + NumberPickerView.this.f40822bd)) * 300.0f) / ((float) NumberPickerView.this.f40791aY));
                            NumberPickerView.this.f40817ay.startScroll(0, NumberPickerView.this.f40823be, 0, NumberPickerView.this.f40822bd + NumberPickerView.this.f40791aY, i2 * 3);
                            NumberPickerView numberPickerView = NumberPickerView.this;
                            i = numberPickerView.m30582c(numberPickerView.f40823be + NumberPickerView.this.f40791aY + NumberPickerView.this.f40822bd);
                        } else {
                            i2 = (int) ((((float) (-NumberPickerView.this.f40822bd)) * 300.0f) / ((float) NumberPickerView.this.f40791aY));
                            NumberPickerView.this.f40817ay.startScroll(0, NumberPickerView.this.f40823be, 0, NumberPickerView.this.f40822bd, i2 * 3);
                            NumberPickerView numberPickerView2 = NumberPickerView.this;
                            i = numberPickerView2.m30582c(numberPickerView2.f40823be + NumberPickerView.this.f40822bd);
                        }
                        i4 = i2;
                        NumberPickerView.this.postInvalidate();
                    } else {
                        NumberPickerView.this.m30578b(0);
                        NumberPickerView numberPickerView3 = NumberPickerView.this;
                        i = numberPickerView3.m30582c(numberPickerView3.f40823be);
                    }
                    NumberPickerView numberPickerView4 = NumberPickerView.this;
                    Message a = numberPickerView4.m30556a(2, numberPickerView4.f40796ad, i, message.obj);
                    if (NumberPickerView.this.f40816ax) {
                        NumberPickerView.this.f40775aI.sendMessageDelayed(a, (long) (i4 * 2));
                    } else {
                        NumberPickerView.this.f40774aH.sendMessageDelayed(a, (long) (i4 * 2));
                    }
                } else if (i3 == 2) {
                    NumberPickerView.this.m30562a(message.arg1, message.arg2, message.obj);
                }
            }
        };
        this.f40775aI = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 2) {
                    NumberPickerView.this.m30562a(message.arg1, message.arg2, message.obj);
                } else if (i == 3) {
                    NumberPickerView.this.requestLayout();
                }
            }
        };
    }

    /* renamed from: a */
    private void m30561a(int i, int i2) {
        this.f40779aM.onValueChangeInScrolling(this, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m30570a(false);
        setMeasuredDimension(m30592f(i), m30595g(i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        this.f40789aW = i;
        this.f40790aX = i2;
        this.f40791aY = i2 / this.f40759S;
        this.f40820bb = ((float) ((i + getPaddingLeft()) - getPaddingRight())) / 2.0f;
        boolean z = false;
        if (getOneRecycleSize() > 1) {
            if (this.f40812at) {
                i5 = getValue() - this.f40764X;
            } else if (this.f40811as) {
                i5 = this.f40821bc + ((this.f40759S - 1) / 2);
            }
            if (this.f40810ar && this.f40813au) {
                z = true;
            }
            m30579b(i5, z);
            m30588d();
            m30590e();
            m30584c();
            this.f40812at = true;
        }
        i5 = 0;
        z = true;
        m30579b(i5, z);
        m30588d();
        m30590e();
        m30584c();
        this.f40812at = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        HandlerThread handlerThread = this.f40773aG;
        if (handlerThread == null || !handlerThread.isAlive()) {
            m30559a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f40773aG.quit();
        if (this.f40791aY != 0) {
            if (!this.f40817ay.isFinished()) {
                this.f40817ay.abortAnimation();
                this.f40823be = this.f40817ay.getCurrY();
                m30594f();
                int i = this.f40822bd;
                if (i != 0) {
                    int i2 = this.f40791aY;
                    if (i < (-i2) / 2) {
                        this.f40823be = this.f40823be + i2 + i;
                    } else {
                        this.f40823be += i;
                    }
                    m30594f();
                }
                m30578b(0);
            }
            int c = m30582c(this.f40823be);
            int i3 = this.f40796ad;
            if (c != i3 && this.f40815aw) {
                try {
                    if (this.f40777aK != null) {
                        this.f40777aK.onValueChange(this, i3 + this.f40764X, this.f40764X + c);
                    }
                    if (this.f40776aJ != null) {
                        this.f40776aJ.onValueChangeRelativeToRaw(this, this.f40796ad, c, this.f40770aD);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.f40796ad = c;
        }
    }

    public int getOneRecycleSize() {
        return (this.f40763W - this.f40762V) + 1;
    }

    public int getRawContentSize() {
        String[] strArr = this.f40770aD;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public void setDisplayedValuesAndPickedIndex(String[] strArr, int i, boolean z) {
        stopScrolling();
        if (strArr == null) {
            throw new IllegalArgumentException("newDisplayedValues should not be null.");
        } else if (i >= 0) {
            m30581b(strArr);
            m30570a(true);
            m30590e();
            m30603j();
            this.f40796ad = this.f40762V + i;
            m30579b(i, this.f40810ar && this.f40813au);
            if (z) {
                this.f40774aH.sendMessageDelayed(m30598h(1), 0);
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("pickedIndex should not be negative, now pickedIndex is " + i);
        }
    }

    public void setDisplayedValues(String[] strArr, boolean z) {
        setDisplayedValuesAndPickedIndex(strArr, 0, z);
    }

    public void setDisplayedValues(String[] strArr) {
        m30607n();
        stopScrolling();
        if (strArr != null) {
            boolean z = true;
            if ((this.f40765Y - this.f40764X) + 1 <= strArr.length) {
                m30581b(strArr);
                m30570a(true);
                this.f40796ad = this.f40762V + 0;
                if (!this.f40810ar || !this.f40813au) {
                    z = false;
                }
                m30579b(0, z);
                postInvalidate();
                this.f40775aI.sendEmptyMessage(3);
                return;
            }
            throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.f40765Y - this.f40764X) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
        }
        throw new IllegalArgumentException("newDisplayedValues should not be null.");
    }

    public String[] getDisplayedValues() {
        return this.f40770aD;
    }

    public void setWrapSelectorWheel(boolean z) {
        if (this.f40810ar == z) {
            return;
        }
        if (z) {
            this.f40810ar = z;
            m30606m();
            postInvalidate();
        } else if (this.f40780aN == 0) {
            m30577b();
        } else {
            this.f40814av = true;
        }
    }

    public void smoothScrollToValue(int i) {
        smoothScrollToValue(getValue(), i, true);
    }

    public void smoothScrollToValue(int i, boolean z) {
        smoothScrollToValue(getValue(), i, z);
    }

    public void smoothScrollToValue(int i, int i2) {
        smoothScrollToValue(i, i2, true);
    }

    public void smoothScrollToValue(int i, int i2, boolean z) {
        int i3;
        boolean z2 = true;
        int a = m30551a(i, this.f40764X, this.f40765Y, this.f40810ar && this.f40813au);
        int i4 = this.f40764X;
        int i5 = this.f40765Y;
        if (!this.f40810ar || !this.f40813au) {
            z2 = false;
        }
        int a2 = m30551a(i2, i4, i5, z2);
        if (!this.f40810ar || !this.f40813au) {
            i3 = a2 - a;
        } else {
            i3 = a2 - a;
            int oneRecycleSize = getOneRecycleSize() / 2;
            if (i3 < (-oneRecycleSize) || oneRecycleSize < i3) {
                int oneRecycleSize2 = getOneRecycleSize();
                i3 = i3 > 0 ? i3 - oneRecycleSize2 : i3 + oneRecycleSize2;
            }
        }
        setValue(a);
        if (a != a2) {
            m30563a(i3, z);
        }
    }

    public void refreshByNewDisplayedValues(String[] strArr) {
        int minValue = getMinValue();
        int maxValue = (getMaxValue() - minValue) + 1;
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > maxValue) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30562a(int i, int i2, Object obj) {
        m30578b(0);
        if (i != i2 && (obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue())) {
            OnValueChangeListener onValueChangeListener = this.f40777aK;
            if (onValueChangeListener != null) {
                int i3 = this.f40764X;
                onValueChangeListener.onValueChange(this, i + i3, i3 + i2);
            }
            OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw = this.f40776aJ;
            if (onValueChangeListenerRelativeToRaw != null) {
                onValueChangeListenerRelativeToRaw.onValueChangeRelativeToRaw(this, i, i2, this.f40770aD);
            }
        }
        this.f40796ad = i2;
        if (this.f40814av) {
            this.f40814av = false;
            m30577b();
        }
    }

    /* renamed from: a */
    private void m30560a(int i) {
        m30563a(i, true);
    }

    /* renamed from: a */
    private void m30563a(int i, boolean z) {
        int i2;
        int pickedIndexRelativeToRaw;
        int i3;
        int i4;
        if ((!this.f40810ar || !this.f40813au) && ((i3 = pickedIndexRelativeToRaw + i) > (i4 = this.f40763W) || i3 < (i4 = this.f40762V))) {
            i = i4 - (pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw());
        }
        int i5 = this.f40822bd;
        int i6 = this.f40791aY;
        if (i5 < (-i6) / 2) {
            int i7 = i6 + i5;
            int i8 = (int) ((((float) (i5 + i6)) * 300.0f) / ((float) i6));
            i2 = i < 0 ? (-i8) - (i * 300) : i8 + (i * 300);
            i5 = i7;
        } else {
            int i9 = (int) ((((float) (-i5)) * 300.0f) / ((float) i6));
            i2 = i < 0 ? i9 - (i * 300) : i9 + (i * 300);
        }
        int i10 = i5 + (i * this.f40791aY);
        if (i2 < 300) {
            i2 = 300;
        }
        if (i2 > 600) {
            i2 = 600;
        }
        this.f40817ay.startScroll(0, this.f40823be, 0, i10, i2);
        if (z) {
            this.f40774aH.sendMessageDelayed(m30598h(1), (long) (i2 / 4));
        } else {
            this.f40774aH.sendMessageDelayed(m30556a(1, 0, 0, (Object) new Boolean(z)), (long) (i2 / 4));
        }
        postInvalidate();
    }

    public int getMinValue() {
        return this.f40764X;
    }

    public int getMaxValue() {
        return this.f40765Y;
    }

    public void setMinValue(int i) {
        this.f40764X = i;
        this.f40762V = 0;
        m30590e();
    }

    public void setMaxValue(int i) {
        String[] strArr = this.f40770aD;
        if (strArr != null) {
            int i2 = this.f40764X;
            if ((i - i2) + 1 <= strArr.length) {
                this.f40765Y = i;
                int i3 = this.f40762V;
                int i4 = (i - i2) + i3;
                this.f40763W = i4;
                setMinAndMaxShowIndex(i3, i4);
                m30590e();
                return;
            }
            throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.f40764X) + 1) + " and mDisplayedValues.length is " + this.f40770aD.length);
        }
        throw new NullPointerException("mDisplayedValues should not be null");
    }

    public void setValue(int i) {
        int i2 = this.f40764X;
        if (i < i2) {
            throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + i);
        } else if (i <= this.f40765Y) {
            setPickedIndexRelativeToRaw(i - i2);
        } else {
            throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + i);
        }
    }

    public int getValue() {
        return getPickedIndexRelativeToRaw() + this.f40764X;
    }

    public String getContentByCurrValue() {
        return this.f40770aD[getValue() - this.f40764X];
    }

    public boolean getWrapSelectorWheel() {
        return this.f40810ar;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        return this.f40810ar && this.f40813au;
    }

    public void setHintText(String str) {
        if (!m30572a(this.f40799ag, str)) {
            this.f40799ag = str;
            this.f40808ap = m30549a(this.f40769aC.getFontMetrics());
            this.f40749I = m30554a((CharSequence) this.f40799ag, this.f40769aC);
            this.f40775aI.sendEmptyMessage(3);
        }
    }

    public void setSuffixText(String str) {
        if (!m30572a(this.f40800ah, str)) {
            this.f40800ah = str;
            this.f40775aI.sendEmptyMessage(3);
        }
    }

    public void setSuffixScope(String str) {
        if (!m30572a(this.f40801ai, str)) {
            this.f40801ai = str;
            this.f40775aI.sendEmptyMessage(3);
        }
    }

    public void setPickedIndexRelativeToMin(int i) {
        if (i >= 0 && i < getOneRecycleSize()) {
            this.f40796ad = this.f40762V + i;
            m30579b(i, this.f40810ar && this.f40813au);
            postInvalidate();
        }
    }

    public void setNormalTextColor(int i) {
        if (this.f40743C != i) {
            this.f40743C = i;
            postInvalidate();
        }
    }

    public void setSelectedTextColor(int i) {
        if (this.f40744D != i) {
            this.f40744D = i;
            postInvalidate();
        }
    }

    public void setHintTextColor(int i) {
        if (this.f40745E != i) {
            this.f40745E = i;
            this.f40769aC.setColor(i);
            postInvalidate();
        }
    }

    public void setDividerColor(int i) {
        if (this.f40755O != i) {
            this.f40755O = i;
            this.f40767aA.setColor(i);
            postInvalidate();
        }
    }

    public void setPickedIndexRelativeToRaw(int i) {
        int i2 = this.f40762V;
        if (i2 > -1 && i2 <= i && i <= this.f40763W) {
            this.f40796ad = i;
            m30579b(i - i2, this.f40810ar && this.f40813au);
            postInvalidate();
        }
    }

    public int getPickedIndexRelativeToRaw() {
        int i = this.f40822bd;
        if (i == 0) {
            return m30582c(this.f40823be);
        }
        int i2 = this.f40791aY;
        if (i < (-i2) / 2) {
            return m30582c(this.f40823be + i2 + i);
        }
        return m30582c(this.f40823be + i);
    }

    public void setMinAndMaxShowIndex(int i, int i2) {
        setMinAndMaxShowIndex(i, i2, true);
    }

    public void setMinAndMaxShowIndex(int i, int i2, boolean z) {
        if (i <= i2) {
            String[] strArr = this.f40770aD;
            if (strArr == null) {
                throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
            } else if (i >= 0) {
                boolean z2 = true;
                if (i > strArr.length - 1) {
                    throw new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.f40770aD.length - 1) + " minShowIndex is " + i);
                } else if (i2 < 0) {
                    throw new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + i2);
                } else if (i2 <= strArr.length - 1) {
                    this.f40762V = i;
                    this.f40763W = i2;
                    if (z) {
                        this.f40796ad = i + 0;
                        if (!this.f40810ar || !this.f40813au) {
                            z2 = false;
                        }
                        m30579b(0, z2);
                        postInvalidate();
                    }
                } else {
                    throw new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.f40770aD.length - 1) + " maxShowIndex is " + i2);
                }
            } else {
                throw new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + i);
            }
        } else {
            throw new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i + ", maxShowIndex is " + i2 + ".");
        }
    }

    public void setFriction(float f) {
        if (f > 0.0f) {
            ViewConfiguration.get(getContext());
            this.f40805am = ViewConfiguration.getScrollFriction() / f;
            return;
        }
        throw new IllegalArgumentException("you should set a a positive float friction, now friction is " + f);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30578b(int i) {
        if (this.f40780aN != i) {
            this.f40780aN = i;
            OnScrollListener onScrollListener = this.f40778aL;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChange(this, i);
            }
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f40778aL = onScrollListener;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.f40777aK = onValueChangeListener;
    }

    public void setOnValueChangedListenerRelativeToRaw(OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw) {
        this.f40776aJ = onValueChangeListenerRelativeToRaw;
    }

    public void setOnValueChangeListenerInScrolling(OnValueChangeListenerInScrolling onValueChangeListenerInScrolling) {
        this.f40779aM = onValueChangeListenerInScrolling;
    }

    public void setContentTextTypeface(Typeface typeface) {
        this.f40768aB.setTypeface(typeface);
    }

    public void setHintTextTypeface(Typeface typeface) {
        this.f40769aC.setTypeface(typeface);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m30582c(int i) {
        int i2 = this.f40791aY;
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        int i3 = (i / i2) + (this.f40759S / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.f40810ar && this.f40813au) {
            z = true;
        }
        int a = m30552a(i3, oneRecycleSize, z);
        if (a >= 0 && a < getOneRecycleSize()) {
            return a + this.f40762V;
        }
        if (a >= getOneRecycleSize()) {
            return getOneRecycleSize() - 1;
        }
        return this.f40762V;
    }

    /* renamed from: a */
    private int m30552a(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (!z) {
            return i;
        }
        int i3 = i % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    /* renamed from: b */
    private void m30577b() {
        m30579b(getPickedIndexRelativeToRaw() - this.f40762V, false);
        this.f40810ar = false;
        postInvalidate();
    }

    /* renamed from: c */
    private void m30584c() {
        int i = this.f40759S;
        int i2 = i / 2;
        this.f40760T = i2;
        int i3 = i2 + 1;
        this.f40761U = i3;
        int i4 = this.f40790aX;
        this.f40792aZ = (float) ((i2 * i4) / i);
        this.f40819ba = (float) ((i3 * i4) / i);
        if (this.f40757Q < 0) {
            this.f40757Q = 0;
        }
        if (this.f40758R < 0) {
            this.f40758R = 0;
        }
        if (this.f40757Q + this.f40758R != 0 && getPaddingLeft() + this.f40757Q >= (this.f40789aW - getPaddingRight()) - this.f40758R) {
            int paddingLeft = getPaddingLeft() + this.f40757Q + getPaddingRight();
            int i5 = this.f40758R;
            int i6 = (paddingLeft + i5) - this.f40789aW;
            int i7 = this.f40757Q;
            float f = (float) i6;
            int i8 = (int) (((float) i7) - ((((float) i7) * f) / ((float) (i7 + i5))));
            this.f40757Q = i8;
            this.f40758R = (int) (((float) i5) - ((f * ((float) i5)) / ((float) (i8 + i5))));
        }
    }

    /* renamed from: d */
    private void m30588d() {
        int i = this.f40746F;
        int i2 = this.f40791aY;
        if (i > i2) {
            this.f40746F = i2;
        }
        int i3 = this.f40747G;
        int i4 = this.f40791aY;
        if (i3 > i4) {
            this.f40747G = i4;
        }
        Paint paint = this.f40769aC;
        if (paint != null) {
            paint.setTextSize((float) this.f40748H);
            this.f40808ap = m30549a(this.f40769aC.getFontMetrics());
            this.f40749I = m30554a((CharSequence) this.f40799ag, this.f40769aC);
            TextPaint textPaint = this.f40768aB;
            if (textPaint != null) {
                textPaint.setTextSize((float) this.f40747G);
                this.f40807ao = m30549a(this.f40768aB.getFontMetrics());
                this.f40768aB.setTextSize((float) this.f40746F);
                this.f40806an = m30549a(this.f40768aB.getFontMetrics());
                return;
            }
            throw new IllegalArgumentException("mPaintText should not be null.");
        }
        throw new IllegalArgumentException("mPaintHint should not be null.");
    }

    /* renamed from: e */
    private void m30590e() {
        this.f40783aQ = 0;
        this.f40784aR = (-this.f40759S) * this.f40791aY;
        if (this.f40770aD != null) {
            int oneRecycleSize = getOneRecycleSize();
            int i = this.f40759S;
            int i2 = this.f40791aY;
            this.f40783aQ = ((oneRecycleSize - (i / 2)) - 1) * i2;
            this.f40784aR = (-(i / 2)) * i2;
        }
    }

    /* renamed from: d */
    private int m30586d(int i) {
        if (this.f40810ar && this.f40813au) {
            return i;
        }
        int i2 = this.f40784aR;
        if (i >= i2 && i <= (i2 = this.f40783aQ)) {
            return i;
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (r1 < ((float) r3)) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.f40791aY
            r2 = 1
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            android.view.VelocityTracker r1 = r0.f40818az
            if (r1 != 0) goto L_0x0012
            android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
            r0.f40818az = r1
        L_0x0012:
            android.view.VelocityTracker r1 = r0.f40818az
            r3 = r18
            r1.addMovement(r3)
            float r1 = r18.getY()
            r0.f40787aU = r1
            int r1 = r18.getAction()
            r4 = 0
            if (r1 == 0) goto L_0x00c1
            r5 = 0
            r7 = 2
            if (r1 == r2) goto L_0x0072
            if (r1 == r7) goto L_0x0045
            r3 = 3
            if (r1 == r3) goto L_0x0032
            goto L_0x00de
        L_0x0032:
            int r1 = r0.f40823be
            float r1 = (float) r1
            r0.f40785aS = r1
            r17.stopScrolling()
            android.os.Handler r1 = r0.f40774aH
            android.os.Message r3 = r0.m30598h((int) r2)
            r1.sendMessageDelayed(r3, r5)
            goto L_0x00de
        L_0x0045:
            float r1 = r0.f40786aT
            float r3 = r0.f40787aU
            float r1 = r1 - r3
            boolean r3 = r0.f40788aV
            if (r3 == 0) goto L_0x005c
            int r3 = r0.f40798af
            int r5 = -r3
            float r5 = (float) r5
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x005c
            float r3 = (float) r3
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x005c
            goto L_0x006e
        L_0x005c:
            r0.f40788aV = r4
            float r3 = r0.f40785aS
            float r3 = r3 + r1
            int r1 = (int) r3
            int r1 = r0.m30586d((int) r1)
            r0.f40823be = r1
            r17.m30594f()
            r17.invalidate()
        L_0x006e:
            r0.m30578b((int) r2)
            goto L_0x00de
        L_0x0072:
            boolean r1 = r0.f40788aV
            if (r1 == 0) goto L_0x007a
            r17.m30567a((android.view.MotionEvent) r18)
            goto L_0x00de
        L_0x007a:
            android.view.VelocityTracker r1 = r0.f40818az
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3)
            float r1 = r1.getYVelocity()
            float r3 = r0.f40805am
            float r1 = r1 * r3
            int r1 = (int) r1
            int r3 = java.lang.Math.abs(r1)
            int r4 = r0.f40797ae
            if (r3 <= r4) goto L_0x00b4
            androidx.core.widget.ScrollerCompat r8 = r0.f40817ay
            r9 = 0
            int r10 = r0.f40823be
            r11 = 0
            int r12 = -r1
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            r14 = 2147483647(0x7fffffff, float:NaN)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r15 = r0.m30586d((int) r1)
            r1 = 2147483647(0x7fffffff, float:NaN)
            int r16 = r0.m30586d((int) r1)
            r8.fling(r9, r10, r11, r12, r13, r14, r15, r16)
            r17.invalidate()
            r0.m30578b((int) r7)
        L_0x00b4:
            android.os.Handler r1 = r0.f40774aH
            android.os.Message r3 = r0.m30598h((int) r2)
            r1.sendMessageDelayed(r3, r5)
            r17.m30597g()
            goto L_0x00de
        L_0x00c1:
            r0.f40788aV = r2
            android.os.Handler r1 = r0.f40774aH
            r1.removeMessages(r2)
            r17.stopScrolling()
            float r1 = r0.f40787aU
            r0.f40786aT = r1
            int r1 = r0.f40823be
            float r1 = (float) r1
            r0.f40785aS = r1
            r0.m30578b((int) r4)
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r2)
        L_0x00de:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.view.picker.NumberPickerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private void m30567a(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        int i = 0;
        while (i < this.f40759S) {
            int i2 = this.f40791aY;
            if (((float) (i2 * i)) > y || y >= ((float) (i2 * (i + 1)))) {
                i++;
            } else {
                m30591e(i);
                return;
            }
        }
    }

    /* renamed from: e */
    private void m30591e(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.f40759S)) {
            m30560a(i - (i2 / 2));
        }
    }

    /* renamed from: a */
    private float m30549a(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    /* renamed from: b */
    private void m30579b(int i, boolean z) {
        int i2 = i - ((this.f40759S - 1) / 2);
        this.f40821bc = i2;
        int a = m30552a(i2, getOneRecycleSize(), z);
        this.f40821bc = a;
        int i3 = this.f40791aY;
        if (i3 == 0) {
            this.f40811as = true;
            return;
        }
        this.f40823be = i3 * a;
        int i4 = a + (this.f40759S / 2);
        this.f40781aO = i4;
        int oneRecycleSize = i4 % getOneRecycleSize();
        this.f40781aO = oneRecycleSize;
        if (oneRecycleSize < 0) {
            this.f40781aO = oneRecycleSize + getOneRecycleSize();
        }
        this.f40782aP = this.f40781aO;
        m30594f();
    }

    public void computeScroll() {
        if (this.f40791aY != 0 && this.f40817ay.computeScrollOffset()) {
            this.f40823be = this.f40817ay.getCurrY();
            m30594f();
            postInvalidate();
        }
    }

    /* renamed from: f */
    private void m30594f() {
        int floor = (int) Math.floor((double) (((float) this.f40823be) / ((float) this.f40791aY)));
        this.f40821bc = floor;
        int i = this.f40823be;
        int i2 = this.f40791aY;
        int i3 = -(i - (floor * i2));
        this.f40822bd = i3;
        if (this.f40779aM != null) {
            if ((-i3) > i2 / 2) {
                this.f40782aP = floor + 1 + (this.f40759S / 2);
            } else {
                this.f40782aP = floor + (this.f40759S / 2);
            }
            int oneRecycleSize = this.f40782aP % getOneRecycleSize();
            this.f40782aP = oneRecycleSize;
            if (oneRecycleSize < 0) {
                this.f40782aP = oneRecycleSize + getOneRecycleSize();
            }
            int i4 = this.f40781aO;
            int i5 = this.f40782aP;
            if (i4 != i5) {
                m30561a(i4, i5);
            }
            this.f40781aO = this.f40782aP;
        }
    }

    /* renamed from: g */
    private void m30597g() {
        VelocityTracker velocityTracker = this.f40818az;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f40818az.recycle();
            this.f40818az = null;
        }
    }

    /* renamed from: a */
    private void m30570a(boolean z) {
        m30599h();
        m30602i();
        if (!z) {
            return;
        }
        if (this.f40824bf == Integer.MIN_VALUE || this.f40825bg == Integer.MIN_VALUE) {
            this.f40775aI.sendEmptyMessage(3);
        }
    }

    /* renamed from: f */
    private int m30592f(int i) {
        int mode = View.MeasureSpec.getMode(i);
        this.f40824bf = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = 0;
        int i3 = Math.max(this.f40749I, this.f40750J) == 0 ? 0 : this.f40752L;
        if (Math.max(this.f40749I, this.f40750J) != 0) {
            i2 = this.f40751K;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + Math.max(this.f40794ab, Math.max(this.f40766Z, this.f40795ac) + ((i2 + Math.max(this.f40749I, this.f40750J) + i3 + (this.f40754N * 2)) * 2));
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    /* renamed from: g */
    private int m30595g(int i) {
        int mode = View.MeasureSpec.getMode(i);
        this.f40825bg = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom() + (this.f40759S * (this.f40793aa + (this.f40753M * 2)));
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f40826bh) {
            m30566a(canvas);
        }
        m30580b(canvas);
        m30585c(canvas);
    }

    public void hide() {
        this.f40826bh = true;
        invalidate();
    }

    public void show() {
        this.f40826bh = false;
        invalidate();
    }

    /* renamed from: a */
    private void m30566a(Canvas canvas) {
        float f;
        float f2;
        float f3;
        int i;
        float f4 = 0.0f;
        int i2 = 0;
        while (i2 < this.f40759S + 1) {
            float f5 = (float) (this.f40822bd + (this.f40791aY * i2));
            int a = m30552a(this.f40821bc + i2, getOneRecycleSize(), this.f40810ar && this.f40813au);
            int i3 = this.f40759S;
            if (i2 == i3 / 2) {
                int i4 = this.f40791aY;
                f3 = ((float) (this.f40822bd + i4)) / ((float) i4);
                i = m30550a(f3, this.f40743C, this.f40744D);
                f2 = m30548a(f3, (float) this.f40746F, (float) this.f40747G);
                f = m30548a(f3, this.f40806an, this.f40807ao);
            } else if (i2 == (i3 / 2) + 1) {
                float f6 = 1.0f - f4;
                int a2 = m30550a(f6, this.f40743C, this.f40744D);
                float a3 = m30548a(f6, (float) this.f40746F, (float) this.f40747G);
                float a4 = m30548a(f6, this.f40806an, this.f40807ao);
                f3 = f4;
                i = a2;
                f2 = a3;
                f = a4;
            } else {
                int i5 = this.f40743C;
                f2 = (float) this.f40746F;
                f = this.f40806an;
                int i6 = i5;
                f3 = f4;
                i = i6;
            }
            this.f40768aB.setColor(i);
            this.f40768aB.setTextSize(f2);
            if (a >= 0 && a < getOneRecycleSize()) {
                String str = this.f40770aD[a + this.f40762V];
                if (TextUtils.isEmpty(this.f40801ai) || str.matches(this.f40801ai)) {
                    str = str + this.f40800ah;
                }
                if (this.f40802aj != null) {
                    str = TextUtils.ellipsize(str, this.f40768aB, (float) (getWidth() - (this.f40754N * 2)), getEllipsizeType()).toString();
                }
                canvas.drawText(str, this.f40820bb, f5 + ((float) (this.f40791aY / 2)) + f, this.f40768aB);
            } else if (!TextUtils.isEmpty(this.f40803ak)) {
                canvas.drawText(this.f40803ak, this.f40820bb, f5 + ((float) (this.f40791aY / 2)) + f, this.f40768aB);
            }
            i2++;
            f4 = f3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.text.TextUtils.TruncateAt getEllipsizeType() {
        /*
            r5 = this;
            java.lang.String r0 = r5.f40802aj
            int r1 = r0.hashCode()
            r2 = -1074341483(0xffffffffbff6d995, float:-1.9285151)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x002d
            r2 = 100571(0x188db, float:1.4093E-40)
            if (r1 == r2) goto L_0x0023
            r2 = 109757538(0x68ac462, float:5.219839E-35)
            if (r1 == r2) goto L_0x0018
            goto L_0x0037
        L_0x0018:
            java.lang.String r1 = "start"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 0
            goto L_0x0038
        L_0x0023:
            java.lang.String r1 = "end"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 2
            goto L_0x0038
        L_0x002d:
            java.lang.String r1 = "middle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 1
            goto L_0x0038
        L_0x0037:
            r0 = -1
        L_0x0038:
            if (r0 == 0) goto L_0x004c
            if (r0 == r4) goto L_0x0049
            if (r0 != r3) goto L_0x0041
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END
            return r0
        L_0x0041:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Illegal text ellipsize type."
            r0.<init>(r1)
            throw r0
        L_0x0049:
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.MIDDLE
            return r0
        L_0x004c:
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.START
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.view.picker.NumberPickerView.getEllipsizeType():android.text.TextUtils$TruncateAt");
    }

    /* renamed from: b */
    private void m30580b(Canvas canvas) {
        if (this.f40809aq) {
            canvas.drawLine((float) (getPaddingLeft() + this.f40757Q), this.f40792aZ, (float) ((this.f40789aW - getPaddingRight()) - this.f40758R), this.f40792aZ, this.f40767aA);
            canvas.drawLine((float) (getPaddingLeft() + this.f40757Q), this.f40819ba, (float) ((this.f40789aW - getPaddingRight()) - this.f40758R), this.f40819ba, this.f40767aA);
        }
    }

    /* renamed from: c */
    private void m30585c(Canvas canvas) {
        if (!TextUtils.isEmpty(this.f40799ag)) {
            canvas.drawText(this.f40799ag, this.f40820bb + ((float) ((this.f40766Z + this.f40749I) / 2)) + ((float) this.f40751K), ((this.f40792aZ + this.f40819ba) / 2.0f) + this.f40808ap, this.f40769aC);
        }
    }

    /* renamed from: h */
    private void m30599h() {
        float textSize = this.f40768aB.getTextSize();
        this.f40768aB.setTextSize((float) this.f40747G);
        this.f40766Z = m30555a((CharSequence[]) this.f40770aD, (Paint) this.f40768aB);
        this.f40794ab = m30555a(this.f40771aE, (Paint) this.f40768aB);
        this.f40795ac = m30555a(this.f40772aF, (Paint) this.f40768aB);
        this.f40768aB.setTextSize((float) this.f40748H);
        this.f40750J = m30554a((CharSequence) this.f40804al, (Paint) this.f40768aB);
        this.f40768aB.setTextSize(textSize);
    }

    /* renamed from: a */
    private int m30555a(CharSequence[] charSequenceArr, Paint paint) {
        if (charSequenceArr == null) {
            return 0;
        }
        int i = 0;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence != null) {
                i = Math.max(m30554a(charSequence, paint), i);
            }
        }
        return i;
    }

    /* renamed from: a */
    private int m30554a(CharSequence charSequence, Paint paint) {
        if (!TextUtils.isEmpty(charSequence)) {
            return (int) (paint.measureText(charSequence.toString()) + 0.5f);
        }
        return 0;
    }

    /* renamed from: i */
    private void m30602i() {
        float textSize = this.f40768aB.getTextSize();
        this.f40768aB.setTextSize((float) this.f40747G);
        this.f40793aa = (int) (((double) (this.f40768aB.getFontMetrics().bottom - this.f40768aB.getFontMetrics().top)) + 0.5d);
        this.f40768aB.setTextSize(textSize);
    }

    /* renamed from: a */
    private void m30571a(String[] strArr) {
        this.f40762V = 0;
        this.f40763W = strArr.length - 1;
        this.f40770aD = strArr;
        m30606m();
    }

    /* renamed from: b */
    private void m30581b(String[] strArr) {
        this.f40770aD = strArr;
        m30606m();
    }

    /* renamed from: j */
    private void m30603j() {
        m30605l();
        m30606m();
        this.f40762V = 0;
        this.f40763W = this.f40770aD.length - 1;
    }

    /* renamed from: k */
    private void m30604k() {
        m30605l();
        m30606m();
        if (this.f40762V == -1) {
            this.f40762V = 0;
        }
        if (this.f40763W == -1) {
            this.f40763W = this.f40770aD.length - 1;
        }
        setMinAndMaxShowIndex(this.f40762V, this.f40763W, false);
    }

    /* renamed from: l */
    private void m30605l() {
        if (this.f40770aD == null) {
            String[] strArr = new String[1];
            this.f40770aD = strArr;
            strArr[0] = "0";
        }
    }

    /* renamed from: m */
    private void m30606m() {
        this.f40813au = this.f40770aD.length > this.f40759S;
    }

    /* renamed from: a */
    private int m30551a(int i, int i2, int i3, boolean z) {
        if (z) {
            if (i > i3) {
                return (((i - i3) % getOneRecycleSize()) + i2) - 1;
            }
            return i < i2 ? ((i - i2) % getOneRecycleSize()) + i3 + 1 : i;
        } else if (i > i3) {
            return i3;
        } else {
            return i < i2 ? i2 : i;
        }
    }

    /* renamed from: n */
    private void m30607n() {
        Handler handler = this.f40774aH;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public void stopScrolling() {
        ScrollerCompat scrollerCompat = this.f40817ay;
        if (scrollerCompat != null && !scrollerCompat.isFinished()) {
            ScrollerCompat scrollerCompat2 = this.f40817ay;
            scrollerCompat2.startScroll(0, scrollerCompat2.getCurrY(), 0, 0, 1);
            this.f40817ay.abortAnimation();
            postInvalidate();
        }
    }

    public void stopScrollingAndCorrectPosition() {
        stopScrolling();
        Handler handler = this.f40774aH;
        if (handler != null) {
            handler.sendMessageDelayed(m30598h(1), 0);
        }
    }

    /* renamed from: h */
    private Message m30598h(int i) {
        return m30556a(i, 0, 0, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Message m30556a(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    /* renamed from: a */
    private boolean m30572a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    /* renamed from: a */
    private int m30553a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* renamed from: b */
    private int m30574b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private String[] m30573a(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return null;
        }
        String[] strArr = new String[charSequenceArr.length];
        for (int i = 0; i < charSequenceArr.length; i++) {
            strArr[i] = charSequenceArr[i].toString();
        }
        return strArr;
    }
}
