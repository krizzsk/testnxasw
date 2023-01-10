package com.didi.global.globaluikit.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.taxis99.R;
import java.text.Format;
import java.util.List;

public class LEGOWheelPicker<T> extends View {

    /* renamed from: A */
    private int f24305A;

    /* renamed from: B */
    private Rect f24306B;

    /* renamed from: C */
    private Rect f24307C;

    /* renamed from: D */
    private int f24308D;

    /* renamed from: E */
    private int f24309E;

    /* renamed from: F */
    private int f24310F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public Scroller f24311G;

    /* renamed from: H */
    private int f24312H;

    /* renamed from: I */
    private boolean f24313I;

    /* renamed from: J */
    private VelocityTracker f24314J;

    /* renamed from: K */
    private int f24315K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f24316L;

    /* renamed from: M */
    private int f24317M;

    /* renamed from: N */
    private boolean f24318N;

    /* renamed from: O */
    private int f24319O;

    /* renamed from: P */
    private int f24320P;

    /* renamed from: Q */
    private int f24321Q;

    /* renamed from: R */
    private int f24322R;

    /* renamed from: S */
    private boolean f24323S;

    /* renamed from: T */
    private LEGOLinearGradient f24324T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public Handler f24325U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public OnWheelChangeListener<T> f24326V;

    /* renamed from: W */
    private Runnable f24327W;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<T> f24328a;

    /* renamed from: b */
    private Format f24329b;

    /* renamed from: c */
    private int f24330c;

    /* renamed from: d */
    private int f24331d;

    /* renamed from: e */
    private Paint f24332e;

    /* renamed from: f */
    private boolean f24333f;

    /* renamed from: g */
    private int f24334g;

    /* renamed from: h */
    private int f24335h;

    /* renamed from: i */
    private Paint f24336i;

    /* renamed from: j */
    private String f24337j;

    /* renamed from: k */
    private int f24338k;

    /* renamed from: l */
    private int f24339l;

    /* renamed from: m */
    private Paint f24340m;

    /* renamed from: n */
    private Paint f24341n;

    /* renamed from: o */
    private int f24342o;

    /* renamed from: p */
    private int f24343p;

    /* renamed from: q */
    private String f24344q;

    /* renamed from: r */
    private int f24345r;

    /* renamed from: s */
    private int f24346s;

    /* renamed from: t */
    private int f24347t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f24348u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f24349v;

    /* renamed from: w */
    private boolean f24350w;

    /* renamed from: x */
    private boolean f24351x;

    /* renamed from: y */
    private int f24352y;

    /* renamed from: z */
    private boolean f24353z;

    public interface OnWheelChangeListener<T> {
        void onWheelSelected(T t, int i);
    }

    public LEGOWheelPicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGOWheelPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGOWheelPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24318N = true;
        this.f24321Q = 50;
        this.f24322R = 12000;
        this.f24325U = new Handler();
        this.f24327W = new Runnable() {
            public void run() {
                int b;
                if (LEGOWheelPicker.this.f24311G.computeScrollOffset()) {
                    LEGOWheelPicker lEGOWheelPicker = LEGOWheelPicker.this;
                    int unused = lEGOWheelPicker.f24316L = lEGOWheelPicker.f24311G.getCurrY();
                    LEGOWheelPicker.this.postInvalidate();
                    LEGOWheelPicker.this.f24325U.postDelayed(this, 16);
                }
                if ((LEGOWheelPicker.this.f24311G.isFinished() || (LEGOWheelPicker.this.f24311G.getFinalY() == LEGOWheelPicker.this.f24311G.getCurrY() && LEGOWheelPicker.this.f24311G.getFinalX() == LEGOWheelPicker.this.f24311G.getCurrX())) && LEGOWheelPicker.this.f24348u != 0 && LEGOWheelPicker.this.f24349v != (b = LEGOWheelPicker.this.m19559a((-LEGOWheelPicker.this.f24316L) / LEGOWheelPicker.this.f24348u))) {
                    int unused2 = LEGOWheelPicker.this.f24349v = b;
                    if (LEGOWheelPicker.this.f24326V != null) {
                        LEGOWheelPicker.this.f24326V.onWheelSelected(LEGOWheelPicker.this.f24328a.get(b), b);
                    }
                }
            }
        };
        m19564a(context, attributeSet);
        m19563a();
        this.f24324T = new LEGOLinearGradient(this.f24330c, this.f24334g);
        this.f24306B = new Rect();
        this.f24307C = new Rect();
        this.f24311G = new Scroller(context);
        this.f24312H = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* renamed from: a */
    private void m19564a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.f24331d = getResources().getDimensionPixelSize(R.dimen.lego_date_picker_text_size);
            this.f24330c = -16777216;
            this.f24333f = true;
            this.f24318N = false;
            this.f24345r = 2;
            this.f24334g = -16777216;
            this.f24335h = getResources().getDimensionPixelSize(R.dimen.lego_date_picker_selected_text_size);
            this.f24349v = 0;
            this.f24347t = getResources().getDimensionPixelOffset(R.dimen.lego_date_picker_item_width_space);
            this.f24346s = getResources().getDimensionPixelOffset(R.dimen.lego_date_picker_item_height_space);
            this.f24350w = true;
            this.f24351x = true;
            this.f24352y = 0;
            this.f24353z = false;
            this.f24305A = -16777216;
            this.f24338k = -16777216;
            this.f24339l = getResources().getDimensionPixelSize(R.dimen.lego_date_picker_text_size);
        }
    }

    public void computeTextSize() {
        this.f24343p = 0;
        this.f24342o = 0;
        if (this.f24328a.size() != 0) {
            this.f24341n.setTextSize((float) Math.max(this.f24335h, this.f24331d));
            if (!TextUtils.isEmpty(this.f24344q)) {
                this.f24342o = (int) this.f24341n.measureText(this.f24344q);
            } else {
                this.f24342o = (int) this.f24341n.measureText(this.f24328a.get(0).toString());
            }
            Paint.FontMetrics fontMetrics = this.f24341n.getFontMetrics();
            this.f24343p = (int) (fontMetrics.bottom - fontMetrics.top);
        }
    }

    /* renamed from: a */
    private void m19563a() {
        Paint paint = new Paint(69);
        this.f24341n = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f24341n.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint(69);
        this.f24332e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f24332e.setTextAlign(Paint.Align.CENTER);
        this.f24332e.setColor(this.f24330c);
        this.f24332e.setTextSize((float) this.f24331d);
        Paint paint3 = new Paint(69);
        this.f24336i = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f24336i.setTextAlign(Paint.Align.CENTER);
        this.f24336i.setColor(this.f24334g);
        this.f24336i.setTextSize((float) this.f24335h);
        Paint paint4 = new Paint(69);
        this.f24340m = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f24340m.setTextAlign(Paint.Align.LEFT);
        this.f24340m.setColor(this.f24338k);
        this.f24340m.setTextSize((float) this.f24339l);
    }

    /* renamed from: a */
    private int m19560a(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : Math.min(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i3 = this.f24342o + this.f24347t;
        int visibleItemCount = (this.f24343p + this.f24346s) * getVisibleItemCount();
        setMeasuredDimension(m19560a(mode, size, i3 + getPaddingLeft() + getPaddingRight()), m19560a(mode2, size2, visibleItemCount + getPaddingTop() + getPaddingBottom()));
    }

    /* renamed from: b */
    private void m19568b() {
        int i;
        if (this.f24318N) {
            i = Integer.MIN_VALUE;
        } else {
            i = (-this.f24348u) * (this.f24328a.size() - 1);
        }
        this.f24320P = i;
        this.f24319O = this.f24318N ? Integer.MAX_VALUE : 0;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f24306B.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f24348u = this.f24306B.height() / getVisibleItemCount();
        this.f24308D = this.f24306B.centerX();
        this.f24309E = (int) ((((float) this.f24348u) - (this.f24336i.ascent() + this.f24336i.descent())) / 2.0f);
        Rect rect = this.f24307C;
        int paddingLeft = getPaddingLeft();
        int i5 = this.f24348u * this.f24345r;
        int width = getWidth() - getPaddingRight();
        int i6 = this.f24348u;
        rect.set(paddingLeft, i5, width, i6 + (this.f24345r * i6));
        m19568b();
        int i7 = this.f24309E;
        int i8 = this.f24348u;
        this.f24310F = i7 + (this.f24345r * i8);
        this.f24316L = (-i8) * this.f24349v;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m19559a(int i) {
        if (i < 0) {
            i = (i % this.f24328a.size()) + this.f24328a.size();
        }
        return i >= this.f24328a.size() ? i % this.f24328a.size() : i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        String str;
        super.onDraw(canvas);
        this.f24341n.setTextAlign(Paint.Align.CENTER);
        if (this.f24351x) {
            this.f24341n.setStyle(Paint.Style.FILL);
            this.f24341n.setColor(this.f24352y);
            canvas.drawRect(this.f24307C, this.f24341n);
        }
        if (this.f24353z) {
            this.f24341n.setStyle(Paint.Style.STROKE);
            this.f24341n.setColor(this.f24305A);
            canvas.drawLines(new float[]{(float) this.f24307C.left, (float) this.f24307C.top, (float) this.f24307C.left, (float) this.f24307C.bottom, (float) this.f24307C.right, (float) this.f24307C.top, (float) this.f24307C.right, (float) this.f24307C.bottom}, 0, 8, this.f24341n);
        }
        int i2 = (-this.f24316L) / this.f24348u;
        this.f24341n.setStyle(Paint.Style.FILL);
        for (int i3 = (i2 - this.f24345r) - 1; i3 <= this.f24345r + i2 + 1; i3++) {
            if (this.f24318N) {
                i = m19559a(i3);
            } else {
                if (i3 >= 0 && i3 <= this.f24328a.size() - 1) {
                    i = i3;
                }
            }
            T t = this.f24328a.get(i);
            int i4 = this.f24309E + ((this.f24345r + i3) * this.f24348u) + this.f24316L;
            int abs = Math.abs(this.f24310F - i4);
            if (this.f24333f) {
                int i5 = this.f24348u;
                if (abs < i5) {
                    float f = 1.0f - (((float) abs) / ((float) i5));
                    this.f24336i.setColor(this.f24324T.getColor(f));
                    this.f24332e.setColor(this.f24324T.getColor(f));
                } else {
                    this.f24336i.setColor(this.f24334g);
                    this.f24332e.setColor(this.f24330c);
                }
                int i6 = this.f24310F;
                float height = i4 > i6 ? ((float) (this.f24306B.height() - i4)) / ((float) (this.f24306B.height() - this.f24310F)) : ((float) i4) / ((float) i6);
                if (height < 0.0f) {
                    height = 0.0f;
                }
                int i7 = (int) (height * 255.0f);
                this.f24336i.setAlpha(i7);
                this.f24332e.setAlpha(i7);
            }
            if (this.f24350w) {
                int i8 = this.f24348u;
                if (abs < i8) {
                    float f2 = ((float) (i8 - abs)) / ((float) i8);
                    int i9 = this.f24335h;
                    int i10 = this.f24331d;
                    float f3 = f2 * ((float) (i9 - i10));
                    this.f24336i.setTextSize(((float) i10) + f3);
                    this.f24332e.setTextSize(((float) this.f24331d) + f3);
                } else {
                    this.f24336i.setTextSize((float) this.f24331d);
                    this.f24332e.setTextSize((float) this.f24331d);
                }
            } else {
                this.f24336i.setTextSize((float) this.f24331d);
                this.f24332e.setTextSize((float) this.f24331d);
            }
            try {
                str = this.f24329b == null ? t.toString() : this.f24329b.format(t);
            } catch (IllegalArgumentException unused) {
                str = t.toString();
            }
            if (abs < this.f24348u / 2) {
                canvas.drawText(str, (float) this.f24308D, (float) i4, this.f24336i);
            } else {
                canvas.drawText(str, (float) this.f24308D, (float) i4, this.f24332e);
            }
        }
        if (!TextUtils.isEmpty(this.f24337j)) {
            canvas.drawText(this.f24337j, (float) (this.f24308D + (this.f24342o / 2)), (float) this.f24310F, this.f24340m);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f24314J == null) {
            this.f24314J = VelocityTracker.obtain();
        }
        this.f24314J.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!this.f24311G.isFinished()) {
                this.f24311G.abortAnimation();
                this.f24323S = true;
            } else {
                this.f24323S = false;
            }
            this.f24314J.clear();
            int y = (int) motionEvent.getY();
            this.f24317M = y;
            this.f24315K = y;
            this.f24313I = true;
        } else if (action == 1) {
            if (this.f24323S || this.f24315K != this.f24317M) {
                this.f24314J.computeCurrentVelocity(1000, (float) this.f24322R);
                int yVelocity = (int) this.f24314J.getYVelocity();
                if (Math.abs(yVelocity) > this.f24321Q) {
                    this.f24311G.fling(0, this.f24316L, 0, yVelocity, 0, 0, this.f24320P, this.f24319O);
                    Scroller scroller = this.f24311G;
                    scroller.setFinalY(scroller.getFinalY() + m19565b(this.f24311G.getFinalY() % this.f24348u));
                } else {
                    Scroller scroller2 = this.f24311G;
                    int i = this.f24316L;
                    scroller2.startScroll(0, i, 0, m19565b(i % this.f24348u));
                }
            } else {
                performClick();
                if (motionEvent.getY() > ((float) this.f24307C.bottom)) {
                    int i2 = this.f24348u;
                    this.f24311G.startScroll(0, this.f24316L, 0, (-((((int) (motionEvent.getY() - ((float) this.f24307C.bottom))) / i2) + 1)) * i2);
                } else if (motionEvent.getY() < ((float) this.f24307C.top)) {
                    int y2 = (int) (((float) this.f24307C.top) - motionEvent.getY());
                    int i3 = this.f24348u;
                    this.f24311G.startScroll(0, this.f24316L, 0, ((y2 / i3) + 1) * i3);
                }
            }
            if (!this.f24318N) {
                int finalY = this.f24311G.getFinalY();
                int i4 = this.f24319O;
                if (finalY > i4) {
                    this.f24311G.setFinalY(i4);
                } else {
                    int finalY2 = this.f24311G.getFinalY();
                    int i5 = this.f24320P;
                    if (finalY2 < i5) {
                        this.f24311G.setFinalY(i5);
                    }
                }
            }
            this.f24325U.post(this.f24327W);
            this.f24314J.recycle();
            this.f24314J = null;
        } else if (action == 2 && (!this.f24313I || Math.abs(((float) this.f24315K) - motionEvent.getY()) >= ((float) this.f24312H))) {
            this.f24313I = false;
            this.f24316L = (int) (((float) this.f24316L) + (motionEvent.getY() - ((float) this.f24317M)));
            this.f24317M = (int) motionEvent.getY();
            invalidate();
        }
        return true;
    }

    public boolean performClick() {
        return super.performClick();
    }

    /* renamed from: b */
    private int m19565b(int i) {
        int abs = Math.abs(i);
        int i2 = this.f24348u;
        if (abs > i2 / 2) {
            return this.f24316L < 0 ? (-i2) - i : i2 - i;
        }
        return -i;
    }

    public void setOnWheelChangeListener(OnWheelChangeListener<T> onWheelChangeListener) {
        this.f24326V = onWheelChangeListener;
    }

    public Paint getTextPaint() {
        return this.f24332e;
    }

    public Paint getSelectedItemPaint() {
        return this.f24336i;
    }

    public Paint getPaint() {
        return this.f24341n;
    }

    public Paint getIndicatorPaint() {
        return this.f24340m;
    }

    public List<T> getDataList() {
        return this.f24328a;
    }

    public void setDataList(List<T> list) {
        if (list.size() != 0) {
            this.f24328a = list;
            computeTextSize();
            m19568b();
            requestLayout();
            postInvalidate();
        }
    }

    public int getTextColor() {
        return this.f24330c;
    }

    public void setTextColor(int i) {
        if (this.f24330c != i) {
            this.f24332e.setColor(i);
            this.f24330c = i;
            this.f24324T.setStartColor(i);
            postInvalidate();
        }
    }

    public int getTextSize() {
        return this.f24331d;
    }

    public void setTextSize(int i) {
        if (this.f24331d != i) {
            this.f24331d = i;
            this.f24332e.setTextSize((float) i);
            computeTextSize();
            postInvalidate();
        }
    }

    public int getSelectedItemTextColor() {
        return this.f24334g;
    }

    public void setSelectedItemTextColor(int i) {
        if (this.f24334g != i) {
            this.f24336i.setColor(i);
            this.f24334g = i;
            this.f24324T.setEndColor(i);
            postInvalidate();
        }
    }

    public int getSelectedItemTextSize() {
        return this.f24335h;
    }

    public void setSelectedItemTextSize(int i) {
        if (this.f24335h != i) {
            this.f24336i.setTextSize((float) i);
            this.f24335h = i;
            computeTextSize();
            postInvalidate();
        }
    }

    public String getItemMaximumWidthText() {
        return this.f24344q;
    }

    public void setItemMaximumWidthText(String str) {
        this.f24344q = str;
        requestLayout();
        postInvalidate();
    }

    public int getHalfVisibleItemCount() {
        return this.f24345r;
    }

    public int getVisibleItemCount() {
        return (this.f24345r * 2) + 1;
    }

    public void setHalfVisibleItemCount(int i) {
        if (this.f24345r != i) {
            this.f24345r = i;
            requestLayout();
        }
    }

    public int getItemWidthSpace() {
        return this.f24347t;
    }

    public void setItemWidthSpace(int i) {
        if (this.f24347t != i) {
            this.f24347t = i;
            requestLayout();
        }
    }

    public int getItemHeightSpace() {
        return this.f24346s;
    }

    public void setItemHeightSpace(int i) {
        if (this.f24346s != i) {
            this.f24346s = i;
            requestLayout();
        }
    }

    public int getCurrentPosition() {
        return this.f24349v;
    }

    public void setCurrentItem(T t) {
        setCurrentItem(t);
    }

    public void setCurrentItem(T t, boolean z) {
        int i = -1;
        for (T next : this.f24328a) {
            if (t.toString().equals(next.toString())) {
                i = this.f24328a.indexOf(next);
            }
        }
        setCurrentPosition(i, z);
    }

    public void setCurrentPosition(int i) {
        setCurrentPosition(i, true);
    }

    public synchronized void setCurrentPosition(int i, boolean z) {
        if (i > this.f24328a.size() - 1) {
            i = this.f24328a.size() - 1;
        }
        if (i < 0) {
            i = 0;
        }
        if (!this.f24311G.isFinished()) {
            this.f24311G.abortAnimation();
        }
        if (!z || this.f24348u <= 0) {
            this.f24349v = i;
            this.f24316L = (-this.f24348u) * i;
            postInvalidate();
        } else {
            this.f24311G.startScroll(0, this.f24316L, 0, (this.f24349v - i) * this.f24348u);
            this.f24311G.setFinalY((-i) * this.f24348u);
            this.f24325U.post(this.f24327W);
        }
    }

    public boolean isZoomInSelectedItem() {
        return this.f24350w;
    }

    public void setZoomInSelectedItem(boolean z) {
        if (this.f24350w != z) {
            this.f24350w = z;
            postInvalidate();
        }
    }

    public boolean isCyclic() {
        return this.f24318N;
    }

    public void setCyclic(boolean z) {
        if (this.f24318N != z) {
            this.f24318N = z;
            m19568b();
            requestLayout();
        }
    }

    public int getMinimumVelocity() {
        return this.f24321Q;
    }

    public void setMinimumVelocity(int i) {
        this.f24321Q = i;
    }

    public int getMaximumVelocity() {
        return this.f24322R;
    }

    public void setMaximumVelocity(int i) {
        this.f24322R = i;
    }

    public boolean isTextGradual() {
        return this.f24333f;
    }

    public void setTextGradual(boolean z) {
        if (this.f24333f != z) {
            this.f24333f = z;
            postInvalidate();
        }
    }

    public boolean isShowCurtain() {
        return this.f24351x;
    }

    public void setShowCurtain(boolean z) {
        if (this.f24351x != z) {
            this.f24351x = z;
            postInvalidate();
        }
    }

    public int getCurtainColor() {
        return this.f24352y;
    }

    public void setCurtainColor(int i) {
        if (this.f24352y != i) {
            this.f24352y = i;
            postInvalidate();
        }
    }

    public boolean isShowCurtainBorder() {
        return this.f24353z;
    }

    public void setShowCurtainBorder(boolean z) {
        if (this.f24353z != z) {
            this.f24353z = z;
            postInvalidate();
        }
    }

    public int getCurtainBorderColor() {
        return this.f24305A;
    }

    public void setCurtainBorderColor(int i) {
        if (this.f24305A != i) {
            this.f24305A = i;
            postInvalidate();
        }
    }

    public void setIndicatorText(String str) {
        this.f24337j = str;
        postInvalidate();
    }

    public void setIndicatorTextColor(int i) {
        this.f24338k = i;
        this.f24340m.setColor(i);
        postInvalidate();
    }

    public void setIndicatorTextSize(int i) {
        this.f24339l = i;
        this.f24340m.setTextSize((float) i);
        postInvalidate();
    }

    public void setDataFormat(Format format) {
        this.f24329b = format;
        postInvalidate();
    }

    public Format getDataFormat() {
        return this.f24329b;
    }
}
