package com.didi.dimina.container.p065ui.wheelview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.didi.dimina.container.p065ui.wheelview.adapter.WheelAdapter;
import com.didi.dimina.container.p065ui.wheelview.interfaces.IPickerViewData;
import com.didi.dimina.container.p065ui.wheelview.listener.LoopViewGestureListener;
import com.didi.dimina.container.p065ui.wheelview.listener.OnItemSelectedListener;
import com.didi.dimina.container.p065ui.wheelview.timer.InertiaTimerTask;
import com.didi.dimina.container.p065ui.wheelview.timer.MessageHandler;
import com.didi.dimina.container.p065ui.wheelview.timer.SmoothScrollTimerTask;
import com.didi.dimina.container.util.LogUtil;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.dimina.container.ui.wheelview.view.WheelView */
public class WheelView extends View {

    /* renamed from: P */
    private static final int f19752P = 5;

    /* renamed from: U */
    private static final float f19753U = 0.8f;

    /* renamed from: a */
    private static final String[] f19754a = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};

    /* renamed from: A */
    private boolean f19755A;

    /* renamed from: B */
    private float f19756B;

    /* renamed from: C */
    private float f19757C;

    /* renamed from: D */
    private float f19758D;

    /* renamed from: E */
    private float f19759E;

    /* renamed from: F */
    private int f19760F;

    /* renamed from: G */
    private int f19761G;

    /* renamed from: H */
    private int f19762H;

    /* renamed from: I */
    private int f19763I;

    /* renamed from: J */
    private int f19764J;

    /* renamed from: K */
    private int f19765K;

    /* renamed from: L */
    private int f19766L;

    /* renamed from: M */
    private int f19767M;

    /* renamed from: N */
    private float f19768N;

    /* renamed from: O */
    private long f19769O;

    /* renamed from: Q */
    private int f19770Q;

    /* renamed from: R */
    private int f19771R;

    /* renamed from: S */
    private int f19772S;

    /* renamed from: T */
    private int f19773T;

    /* renamed from: V */
    private float f19774V;

    /* renamed from: W */
    private boolean f19775W;

    /* renamed from: b */
    private DividerType f19776b;

    /* renamed from: c */
    private Context f19777c;

    /* renamed from: d */
    private Handler f19778d;

    /* renamed from: e */
    private GestureDetector f19779e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnItemSelectedListener f19780f;

    /* renamed from: g */
    private boolean f19781g;

    /* renamed from: h */
    private boolean f19782h;

    /* renamed from: i */
    private final ScheduledExecutorService f19783i;

    /* renamed from: j */
    private ScheduledFuture<?> f19784j;

    /* renamed from: k */
    private Paint f19785k;

    /* renamed from: l */
    private Paint f19786l;

    /* renamed from: m */
    private Paint f19787m;

    /* renamed from: n */
    private WheelAdapter f19788n;

    /* renamed from: o */
    private String f19789o;

    /* renamed from: p */
    private int f19790p;

    /* renamed from: q */
    private int f19791q;

    /* renamed from: r */
    private int f19792r;

    /* renamed from: s */
    private int f19793s;

    /* renamed from: t */
    private float f19794t;

    /* renamed from: u */
    private Typeface f19795u;

    /* renamed from: v */
    private int f19796v;

    /* renamed from: w */
    private int f19797w;

    /* renamed from: x */
    private int f19798x;

    /* renamed from: y */
    private int f19799y;

    /* renamed from: z */
    private float f19800z;

    /* renamed from: com.didi.dimina.container.ui.wheelview.view.WheelView$ACTION */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* renamed from: com.didi.dimina.container.ui.wheelview.view.WheelView$DividerType */
    public enum DividerType {
        FILL,
        WRAP,
        CIRCLE
    }

    public WheelView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19781g = false;
        this.f19782h = true;
        this.f19783i = Executors.newSingleThreadScheduledExecutor();
        this.f19795u = Typeface.MONOSPACE;
        this.f19800z = 1.6f;
        this.f19763I = 11;
        this.f19767M = 0;
        this.f19768N = 0.0f;
        this.f19769O = 0;
        this.f19771R = 17;
        this.f19772S = 0;
        this.f19773T = 0;
        this.f19775W = false;
        this.f19790p = getResources().getDimensionPixelSize(R.dimen.dimina_pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.f19774V = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.f19774V = 4.0f;
        } else if (2.0f <= f && f < 3.0f) {
            this.f19774V = 6.0f;
        } else if (f >= 3.0f) {
            this.f19774V = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.dimina_pickerview, 0, 0);
            this.f19771R = obtainStyledAttributes.getInt(0, 17);
            this.f19796v = obtainStyledAttributes.getColor(5, -5723992);
            this.f19797w = obtainStyledAttributes.getColor(4, -14013910);
            this.f19798x = obtainStyledAttributes.getColor(1, -2763307);
            this.f19799y = obtainStyledAttributes.getDimensionPixelSize(2, 2);
            this.f19790p = obtainStyledAttributes.getDimensionPixelOffset(6, this.f19790p);
            this.f19800z = obtainStyledAttributes.getFloat(3, this.f19800z);
            obtainStyledAttributes.recycle();
        }
        m16805a();
        m16807a(context);
    }

    /* renamed from: a */
    private void m16805a() {
        float f = this.f19800z;
        if (f < 1.0f) {
            this.f19800z = 1.0f;
        } else if (f > 4.0f) {
            this.f19800z = 4.0f;
        }
    }

    /* renamed from: a */
    private void m16807a(Context context) {
        this.f19777c = context;
        this.f19778d = new MessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
        this.f19779e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f19755A = true;
        this.f19759E = 0.0f;
        this.f19760F = -1;
        m16810b();
    }

    /* renamed from: b */
    private void m16810b() {
        Paint paint = new Paint();
        this.f19785k = paint;
        paint.setColor(this.f19796v);
        this.f19785k.setAntiAlias(true);
        this.f19785k.setTypeface(this.f19795u);
        this.f19785k.setTextSize((float) this.f19790p);
        Paint paint2 = new Paint();
        this.f19786l = paint2;
        paint2.setColor(this.f19797w);
        this.f19786l.setAntiAlias(true);
        this.f19786l.setTextScaleX(1.1f);
        this.f19786l.setTypeface(this.f19795u);
        this.f19786l.setTextSize((float) this.f19790p);
        Paint paint3 = new Paint();
        this.f19787m = paint3;
        paint3.setColor(this.f19798x);
        this.f19787m.setAntiAlias(true);
        setLayerType(1, (Paint) null);
    }

    /* renamed from: c */
    private void m16812c() {
        if (this.f19788n != null) {
            m16814d();
            int i = (int) (this.f19794t * ((float) (this.f19763I - 1)));
            this.f19764J = (int) (((double) (i * 2)) / 3.141592653589793d);
            this.f19766L = (int) (((double) i) / 3.141592653589793d);
            this.f19765K = View.MeasureSpec.getSize(this.f19770Q);
            int i2 = this.f19764J;
            float f = this.f19794t;
            this.f19756B = (((float) i2) - f) / 2.0f;
            float f2 = (((float) i2) + f) / 2.0f;
            this.f19757C = f2;
            this.f19758D = (f2 - ((f - ((float) this.f19792r)) / 2.0f)) - this.f19774V;
            if (this.f19760F == -1) {
                if (this.f19755A) {
                    this.f19760F = (this.f19788n.getItemsCount() + 1) / 2;
                } else {
                    this.f19760F = 0;
                }
            }
            this.f19762H = this.f19760F;
        }
    }

    /* renamed from: d */
    private void m16814d() {
        Rect rect = new Rect();
        for (int i = 0; i < this.f19788n.getItemsCount(); i++) {
            String a = m16804a(this.f19788n.getItem(i));
            this.f19786l.getTextBounds(a, 0, a.length(), rect);
            int width = rect.width();
            if (width > this.f19791q) {
                this.f19791q = width;
            }
        }
        this.f19786l.getTextBounds("星期", 0, 2, rect);
        int height = rect.height() + 2;
        this.f19792r = height;
        this.f19794t = this.f19800z * ((float) height);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.f19759E;
            float f2 = this.f19794t;
            int i = (int) (((f % f2) + f2) % f2);
            this.f19767M = i;
            if (((float) i) > f2 / 2.0f) {
                this.f19767M = (int) (f2 - ((float) i));
            } else {
                this.f19767M = -i;
            }
        }
        this.f19784j = this.f19783i.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.f19767M), 0, 10, TimeUnit.MILLISECONDS);
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.f19784j = this.f19783i.scheduleWithFixedDelay(new InertiaTimerTask(this, f), 0, 5, TimeUnit.MILLISECONDS);
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.f19784j;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f19784j.cancel(true);
            this.f19784j = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.f19755A = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.f19795u = typeface;
        this.f19785k.setTypeface(typeface);
        this.f19786l.setTypeface(this.f19795u);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.f19777c.getResources().getDisplayMetrics().density * f);
            this.f19790p = i;
            this.f19785k.setTextSize((float) i);
            this.f19786l.setTextSize((float) this.f19790p);
        }
    }

    public final void setCurrentItem(int i) {
        this.f19761G = i;
        this.f19760F = i;
        this.f19759E = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f19780f = onItemSelectedListener;
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.f19788n = wheelAdapter;
        m16812c();
        invalidate();
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 == 0) {
            i++;
        }
        this.f19763I = i + 2;
    }

    public void setAlphaGradient(boolean z) {
        this.f19775W = z;
    }

    public final WheelAdapter getAdapter() {
        return this.f19788n;
    }

    public final int getCurrentItem() {
        int i;
        WheelAdapter wheelAdapter = this.f19788n;
        if (wheelAdapter == null) {
            return 0;
        }
        if (!this.f19755A || ((i = this.f19761G) >= 0 && i < wheelAdapter.getItemsCount())) {
            return Math.max(0, Math.min(this.f19761G, this.f19788n.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(Math.abs(Math.abs(this.f19761G) - this.f19788n.getItemsCount()), this.f19788n.getItemsCount() - 1));
    }

    public final void onItemSelected() {
        if (this.f19780f != null) {
            postDelayed(new Runnable() {
                public void run() {
                    WheelView.this.f19780f.onItemSelected(WheelView.this.getCurrentItem());
                }
            }, 200);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        String str;
        float f2;
        int i;
        Canvas canvas2 = canvas;
        if (this.f19788n != null) {
            int min = Math.min(Math.max(0, this.f19760F), this.f19788n.getItemsCount() - 1);
            this.f19760F = min;
            try {
                this.f19762H = min + (((int) (this.f19759E / this.f19794t)) % this.f19788n.getItemsCount());
            } catch (ArithmeticException unused) {
                LogUtil.m16840e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.f19755A) {
                if (this.f19762H < 0) {
                    this.f19762H = 0;
                }
                if (this.f19762H > this.f19788n.getItemsCount() - 1) {
                    this.f19762H = this.f19788n.getItemsCount() - 1;
                }
            } else {
                if (this.f19762H < 0) {
                    this.f19762H = this.f19788n.getItemsCount() + this.f19762H;
                }
                if (this.f19762H > this.f19788n.getItemsCount() - 1) {
                    this.f19762H -= this.f19788n.getItemsCount();
                }
            }
            float f3 = this.f19759E % this.f19794t;
            float f4 = 10.0f;
            if (this.f19776b == DividerType.WRAP) {
                if (TextUtils.isEmpty(this.f19789o)) {
                    i = (this.f19765K - this.f19791q) >> 1;
                } else {
                    i = (this.f19765K - this.f19791q) >> 2;
                }
                float f5 = (float) (i - 12);
                float f6 = f5 <= 0.0f ? 10.0f : f5;
                float f7 = ((float) this.f19765K) - f6;
                float f8 = this.f19756B;
                Canvas canvas3 = canvas;
                float f9 = f6;
                float f10 = f7;
                canvas3.drawLine(f9, f8, f10, f8, this.f19787m);
                float f11 = this.f19757C;
                canvas3.drawLine(f9, f11, f10, f11, this.f19787m);
            } else if (this.f19776b == DividerType.CIRCLE) {
                this.f19787m.setStyle(Paint.Style.STROKE);
                this.f19787m.setStrokeWidth((float) this.f19799y);
                if (TextUtils.isEmpty(this.f19789o)) {
                    f2 = ((float) (this.f19765K - this.f19791q)) / 2.0f;
                } else {
                    f2 = ((float) (this.f19765K - this.f19791q)) / 4.0f;
                }
                float f12 = f2 - 12.0f;
                if (f12 > 0.0f) {
                    f4 = f12;
                }
                canvas2.drawCircle(((float) this.f19765K) / 2.0f, ((float) this.f19764J) / 2.0f, Math.max((((float) this.f19765K) - f4) - f4, this.f19794t) / 1.8f, this.f19787m);
            } else {
                float f13 = this.f19756B;
                canvas.drawLine(0.0f, f13, (float) this.f19765K, f13, this.f19787m);
                float f14 = this.f19757C;
                canvas.drawLine(0.0f, f14, (float) this.f19765K, f14, this.f19787m);
            }
            if (!TextUtils.isEmpty(this.f19789o) && this.f19782h) {
                canvas2.drawText(this.f19789o, ((float) (this.f19765K - getTextWidth(this.f19786l, this.f19789o))) - this.f19774V, this.f19758D, this.f19786l);
            }
            int i2 = 0;
            while (true) {
                int i3 = this.f19763I;
                if (i2 < i3) {
                    int i4 = this.f19762H - ((i3 / 2) - i2);
                    Object obj = "";
                    if (this.f19755A) {
                        obj = this.f19788n.getItem(m16802a(i4));
                    } else if (i4 >= 0 && i4 <= this.f19788n.getItemsCount() - 1) {
                        obj = this.f19788n.getItem(i4);
                    }
                    canvas.save();
                    double d = (double) (((this.f19794t * ((float) i2)) - f3) / ((float) this.f19766L));
                    float f15 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                    if (f15 > 90.0f || f15 < -90.0f) {
                        f = f3;
                        canvas.restore();
                    } else {
                        if (this.f19782h || TextUtils.isEmpty(this.f19789o) || TextUtils.isEmpty(m16804a(obj))) {
                            str = m16804a(obj);
                        } else {
                            str = m16804a(obj) + this.f19789o;
                        }
                        float pow = (float) Math.pow((double) (Math.abs(f15) / 90.0f), 2.2d);
                        m16808a(str);
                        m16811b(str);
                        m16813c(str);
                        f = f3;
                        float cos = (float) ((((double) this.f19766L) - (Math.cos(d) * ((double) this.f19766L))) - ((Math.sin(d) * ((double) this.f19792r)) / 2.0d));
                        canvas2.translate(0.0f, cos);
                        float f16 = this.f19756B;
                        if (cos > f16 || ((float) this.f19792r) + cos < f16) {
                            float f17 = this.f19757C;
                            if (cos > f17 || ((float) this.f19792r) + cos < f17) {
                                if (cos >= this.f19756B) {
                                    int i5 = this.f19792r;
                                    if (((float) i5) + cos <= this.f19757C) {
                                        canvas2.drawText(str, (float) this.f19772S, ((float) i5) - this.f19774V, this.f19786l);
                                        this.f19761G = this.f19762H - ((this.f19763I / 2) - i2);
                                    }
                                }
                                canvas.save();
                                canvas2.clipRect(0, 0, this.f19765K, (int) this.f19794t);
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                                m16806a(pow, f15);
                                canvas2.drawText(str, ((float) this.f19773T) + (((float) this.f19793s) * pow), (float) this.f19792r, this.f19785k);
                                canvas.restore();
                                canvas.restore();
                                this.f19786l.setTextSize((float) this.f19790p);
                            } else {
                                canvas.save();
                                canvas2.clipRect(0.0f, 0.0f, (float) this.f19765K, this.f19757C - cos);
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                                canvas2.drawText(str, (float) this.f19772S, ((float) this.f19792r) - this.f19774V, this.f19786l);
                                canvas.restore();
                                canvas.save();
                                canvas2.clipRect(0.0f, this.f19757C - cos, (float) this.f19765K, (float) ((int) this.f19794t));
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                                m16806a(pow, f15);
                                canvas2.drawText(str, (float) this.f19773T, (float) this.f19792r, this.f19785k);
                                canvas.restore();
                            }
                        } else {
                            canvas.save();
                            canvas2.clipRect(0.0f, 0.0f, (float) this.f19765K, this.f19756B - cos);
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                            m16806a(pow, f15);
                            canvas2.drawText(str, (float) this.f19773T, (float) this.f19792r, this.f19785k);
                            canvas.restore();
                            canvas.save();
                            canvas2.clipRect(0.0f, this.f19756B - cos, (float) this.f19765K, (float) ((int) this.f19794t));
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                            canvas2.drawText(str, (float) this.f19772S, ((float) this.f19792r) - this.f19774V, this.f19786l);
                            canvas.restore();
                        }
                        canvas.restore();
                        this.f19786l.setTextSize((float) this.f19790p);
                    }
                    i2++;
                    f3 = f;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m16806a(float f, float f2) {
        int i = this.f19793s;
        int i2 = -1;
        int i3 = i > 0 ? 1 : i < 0 ? -1 : 0;
        Paint paint = this.f19785k;
        if (f2 <= 0.0f) {
            i2 = 1;
        }
        paint.setTextSkewX(((float) (i3 * i2)) * 0.5f * f);
        this.f19785k.setAlpha(this.f19775W ? (int) (((90.0f - Math.abs(f2)) / 90.0f) * 255.0f) : 255);
    }

    /* renamed from: a */
    private void m16808a(String str) {
        Rect rect = new Rect();
        this.f19786l.getTextBounds(str, 0, str.length(), rect);
        int i = this.f19790p;
        for (int width = rect.width(); width > this.f19765K; width = rect.width()) {
            i--;
            this.f19786l.setTextSize((float) i);
            this.f19786l.getTextBounds(str, 0, str.length(), rect);
        }
        this.f19785k.setTextSize((float) i);
    }

    /* renamed from: a */
    private int m16802a(int i) {
        if (i < 0) {
            return m16802a(i + this.f19788n.getItemsCount());
        }
        return i > this.f19788n.getItemsCount() + -1 ? m16802a(i - this.f19788n.getItemsCount()) : i;
    }

    /* renamed from: a */
    private String m16804a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).getPickerViewText();
        }
        if (obj instanceof Integer) {
            return m16809b(((Integer) obj).intValue());
        }
        return obj.toString();
    }

    /* renamed from: b */
    private String m16809b(int i) {
        return (i < 0 || i >= 10) ? String.valueOf(i) : f19754a[i];
    }

    /* renamed from: b */
    private void m16811b(String str) {
        String str2;
        Rect rect = new Rect();
        this.f19786l.getTextBounds(str, 0, str.length(), rect);
        int i = this.f19771R;
        if (i == 3) {
            this.f19772S = 0;
        } else if (i == 5) {
            this.f19772S = (this.f19765K - rect.width()) - ((int) this.f19774V);
        } else if (i == 17) {
            if (this.f19781g || (str2 = this.f19789o) == null || str2.equals("") || !this.f19782h) {
                this.f19772S = (int) (((double) (this.f19765K - rect.width())) * 0.5d);
            } else {
                this.f19772S = (int) (((double) (this.f19765K - rect.width())) * 0.25d);
            }
        }
    }

    /* renamed from: c */
    private void m16813c(String str) {
        String str2;
        Rect rect = new Rect();
        this.f19785k.getTextBounds(str, 0, str.length(), rect);
        int i = this.f19771R;
        if (i == 3) {
            this.f19773T = 0;
        } else if (i == 5) {
            this.f19773T = (this.f19765K - rect.width()) - ((int) this.f19774V);
        } else if (i == 17) {
            if (this.f19781g || (str2 = this.f19789o) == null || str2.equals("") || !this.f19782h) {
                this.f19773T = (int) (((double) (this.f19765K - rect.width())) * 0.5d);
            } else {
                this.f19773T = (int) (((double) (this.f19765K - rect.width())) * 0.25d);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f19770Q = i;
        m16812c();
        setMeasuredDimension(this.f19765K, this.f19764J);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f19779e.onTouchEvent(motionEvent);
        float f = ((float) (-this.f19760F)) * this.f19794t;
        float itemsCount = ((float) ((this.f19788n.getItemsCount() - 1) - this.f19760F)) * this.f19794t;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.f19769O = System.currentTimeMillis();
            cancelFuture();
            this.f19768N = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.f19768N - motionEvent.getRawY();
            this.f19768N = motionEvent.getRawY();
            float f2 = this.f19759E + rawY;
            this.f19759E = f2;
            if (!this.f19755A && ((f2 - (this.f19794t * 0.25f) < f && rawY < 0.0f) || (this.f19759E + (this.f19794t * 0.25f) > itemsCount && rawY > 0.0f))) {
                this.f19759E -= rawY;
                z = true;
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i = this.f19766L;
            float f3 = this.f19794t;
            this.f19767M = (int) ((((float) (((int) (((Math.acos((double) ((((float) i) - y) / ((float) i))) * ((double) this.f19766L)) + ((double) (f3 / 2.0f))) / ((double) f3))) - (this.f19763I / 2))) * f3) - (((this.f19759E % f3) + f3) % f3));
            if (System.currentTimeMillis() - this.f19769O > 120) {
                smoothScroll(ACTION.DAGGLE);
            } else {
                smoothScroll(ACTION.CLICK);
            }
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public int getItemsCount() {
        WheelAdapter wheelAdapter = this.f19788n;
        if (wheelAdapter != null) {
            return wheelAdapter.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.f19789o = str;
    }

    public void isCenterLabel(boolean z) {
        this.f19782h = z;
    }

    public void setGravity(int i) {
        this.f19771R = i;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil((double) fArr[i2]);
        }
        return i;
    }

    public void setIsOptions(boolean z) {
        this.f19781g = z;
    }

    public void setTextColorOut(int i) {
        this.f19796v = i;
        this.f19785k.setColor(i);
    }

    public void setTextColorCenter(int i) {
        this.f19797w = i;
        this.f19786l.setColor(i);
    }

    public void setTextXOffset(int i) {
        this.f19793s = i;
        if (i != 0) {
            this.f19786l.setTextScaleX(1.0f);
        }
    }

    public void setDividerWidth(int i) {
        this.f19799y = i;
        this.f19787m.setStrokeWidth((float) i);
    }

    public void setDividerColor(int i) {
        this.f19798x = i;
        this.f19787m.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.f19776b = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.f19800z = f;
            m16805a();
        }
    }

    public boolean isLoop() {
        return this.f19755A;
    }

    public float getTotalScrollY() {
        return this.f19759E;
    }

    public void setTotalScrollY(float f) {
        this.f19759E = f;
    }

    public float getItemHeight() {
        return this.f19794t;
    }

    public int getInitPosition() {
        return this.f19760F;
    }

    public Handler getHandler() {
        return this.f19778d;
    }
}
