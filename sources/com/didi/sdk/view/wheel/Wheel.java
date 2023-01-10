package com.didi.sdk.view.wheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Scroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class Wheel extends View implements GestureDetector.OnGestureListener {

    /* renamed from: c */
    private static final String f41029c = "WheelTest0001";

    /* renamed from: d */
    private static final int f41030d = 200;

    /* renamed from: A */
    private boolean f41031A;

    /* renamed from: B */
    private boolean f41032B;

    /* renamed from: C */
    private int f41033C;

    /* renamed from: D */
    private boolean f41034D = false;

    /* renamed from: a */
    String f41035a = "";

    /* renamed from: b */
    int f41036b = 1;

    /* renamed from: e */
    private GestureDetector f41037e;

    /* renamed from: f */
    private int f41038f;

    /* renamed from: g */
    private int f41039g;

    /* renamed from: h */
    private List<WheelItem> f41040h;

    /* renamed from: i */
    private int f41041i = 20;

    /* renamed from: j */
    private Paint f41042j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f41043k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f41044l = 5.5f;

    /* renamed from: m */
    private List<String> f41045m;

    /* renamed from: n */
    private float f41046n;

    /* renamed from: o */
    private float f41047o;

    /* renamed from: p */
    private boolean f41048p = true;

    /* renamed from: q */
    private boolean f41049q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f41050r;

    /* renamed from: s */
    private int f41051s;

    /* renamed from: t */
    private String f41052t = "";
    /* access modifiers changed from: private */

    /* renamed from: u */
    public OnItemChangedListener f41053u;

    /* renamed from: v */
    private FlingRunnable f41054v;

    /* renamed from: w */
    private int f41055w;

    /* renamed from: x */
    private int f41056x;

    /* renamed from: y */
    private int f41057y;

    /* renamed from: z */
    private int f41058z;

    public interface OnItemChangedListener {
        void onItemChanged(int i);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public Wheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.wheel);
        this.f41039g = obtainStyledAttributes.getColor(3, -16777216);
        this.f41038f = obtainStyledAttributes.getDimensionPixelOffset(4, 48);
        this.f41043k = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        this.f41044l = obtainStyledAttributes.getFloat(5, this.f41044l);
        this.f41057y = obtainStyledAttributes.getDimensionPixelOffset(2, getContext().getResources().getDimensionPixelOffset(R.dimen.wheel_margin_top_bottom));
        this.f41058z = obtainStyledAttributes.getDimensionPixelOffset(1, getContext().getResources().getDimensionPixelOffset(R.dimen.wheel_margin_top_bottom));
        obtainStyledAttributes.recycle();
        setBackgroundColor(getResources().getColor(R.color.white));
        this.f41037e = new GestureDetector(getContext(), this);
        Paint paint = new Paint();
        this.f41042j = paint;
        paint.setAntiAlias(true);
        this.f41042j.setTextAlign(Paint.Align.CENTER);
        if (getResources().getDisplayMetrics().widthPixels <= 720 && getResources().getDisplayMetrics().widthPixels > 480) {
            this.f41038f = (int) (getResources().getDisplayMetrics().density * 18.0f);
        } else if (getResources().getDisplayMetrics().widthPixels <= 480) {
            this.f41038f = (int) (getResources().getDisplayMetrics().density * 16.0f);
        }
        this.f41042j.setTextSize((float) this.f41038f);
        this.f41042j.setColor(this.f41039g);
        Paint.FontMetrics fontMetrics = this.f41042j.getFontMetrics();
        int i = this.f41043k;
        if (i == 0) {
            Rect rect = new Rect();
            this.f41042j.getTextBounds("秦", 0, 1, rect);
            int height = rect.height();
            this.f41051s = height;
            this.f41043k = height + (this.f41041i << 1);
            this.f41033C = (int) (((double) getResources().getDisplayMetrics().density) * 8.5d);
        } else {
            this.f41051s = i;
        }
        this.f41047o = (((float) (this.f41043k / 2)) - fontMetrics.descent) + ((fontMetrics.descent - fontMetrics.ascent) / 2.0f);
        this.f41055w = 0;
        this.f41056x = 0;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public int getTextSize() {
        return this.f41038f;
    }

    public void setTextSize(int i) {
        this.f41038f = i;
    }

    public void setSuffix(String str) {
        this.f41052t = str;
    }

    public int getTextColor() {
        return this.f41039g;
    }

    public void setTextColor(int i) {
        this.f41039g = i;
    }

    public void setOnItemSelectedListener(OnItemChangedListener onItemChangedListener) {
        this.f41053u = onItemChangedListener;
    }

    public float getMaxTextHeight() {
        return (float) this.f41051s;
    }

    public int getSelectedIndex() {
        return this.f41050r;
    }

    public void setSelectedIndex(int i) {
        if (i != this.f41050r) {
            this.f41049q = true;
        }
        this.f41050r = i;
        invalidate();
    }

    public List<String> getData() {
        return this.f41045m;
    }

    public void setData(List<String> list) {
        this.f41048p = true;
        this.f41045m = list;
        this.f41050r = 0;
        FlingRunnable flingRunnable = this.f41054v;
        if (flingRunnable != null) {
            removeCallbacks(flingRunnable);
        }
        invalidate();
    }

    public String getSelectedValue() {
        List<String> list = this.f41045m;
        return (list == null || list.isEmpty() || this.f41050r >= this.f41045m.size()) ? "" : this.f41045m.get(this.f41050r);
    }

    /* renamed from: a */
    private void m30764a() {
        List<String> list = this.f41045m;
        if (list != null && !list.isEmpty() && getMeasuredWidth() != 0 && this.f41050r < this.f41045m.size()) {
            this.f41040h = new ArrayList(this.f41045m.size());
            int measuredWidth = getMeasuredWidth();
            float f = ((float) measuredWidth) / 2.0f;
            int size = this.f41045m.size();
            for (int i = 0; i < size; i++) {
                WheelItem wheelItem = new WheelItem(measuredWidth, this.f41043k, this.f41055w + this.f41056x);
                int i2 = this.f41050r;
                if (i <= i2 - 1) {
                    wheelItem.setTop(this.f41046n - ((float) ((i2 - i) * this.f41043k)));
                } else {
                    wheelItem.setTop(this.f41046n + ((float) ((i - i2) * this.f41043k)));
                }
                if (this.f41045m.get(i).equals(getResources().getString(R.string.now))) {
                    wheelItem.setTitle(this.f41045m.get(i));
                } else {
                    wheelItem.setTitle(this.f41045m.get(i) + this.f41052t);
                }
                wheelItem.setTextCenterX(f);
                wheelItem.setPaint(this.f41042j);
                wheelItem.setTextBaselineY(this.f41047o);
                this.f41040h.add(wheelItem);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f41048p || this.f41049q) {
            this.f41048p = false;
            this.f41049q = false;
            m30764a();
        }
        if (this.f41040h != null) {
            for (int i = 0; i < this.f41040h.size(); i++) {
                WheelItem wheelItem = this.f41040h.get(i);
                this.f41040h.get(i).draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        float maxTextHeight = getMaxTextHeight();
        float f = (((float) measuredHeight) - maxTextHeight) / 2.0f;
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.wheelview_shadow));
        Paint paint2 = paint;
        canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), f - ((float) this.f41033C), paint2);
        float f2 = f + maxTextHeight;
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, f2 + ((float) this.f41033C), (float) getMeasuredWidth(), (2.0f * f) + maxTextHeight, paint2);
        paint.setColor(getResources().getColor(R.color.title_bar_line_bg));
        canvas2.drawLine(0.0f, f - ((float) this.f41033C), (float) getMeasuredWidth(), f - ((float) this.f41033C), paint2);
        canvas2.drawLine(0.0f, f2 + ((float) this.f41033C), (float) getMeasuredWidth(), f2 + ((float) this.f41033C), paint2);
        paint.setColor(getResources().getColor(R.color.white));
        canvas2.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) this.f41057y, paint2);
        canvas2.drawRect(0.0f, (float) (getMeasuredHeight() - this.f41058z), (float) getMeasuredWidth(), (float) getMeasuredHeight(), paint2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean onTouchEvent = this.f41037e.onTouchEvent(motionEvent);
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    return true;
                }
                if (action != 3) {
                    if (action == 4) {
                        this.f41031A = false;
                    }
                    return super.onTouchEvent(motionEvent);
                }
            }
            if (!onTouchEvent) {
                this.f41050r = m30768b();
            }
            return true;
        }
        this.f41031A = true;
        this.f41032B = true;
        return true;
    }

    /* renamed from: b */
    private int m30768b() {
        List<WheelItem> list = this.f41040h;
        int i = 0;
        if (list != null && !list.isEmpty()) {
            int size = this.f41040h.size();
            int measuredHeight = getMeasuredHeight() >> 1;
            int i2 = 0;
            float f = 0.0f;
            float f2 = 0.0f;
            while (true) {
                if (i >= size) {
                    i = i2;
                    break;
                }
                WheelItem wheelItem = this.f41040h.get(i);
                float top = wheelItem.getTop();
                if (((float) wheelItem.getHeight()) + top >= 0.0f) {
                    float f3 = (float) measuredHeight;
                    if (top <= f3 && ((float) this.f41043k) + top >= f3) {
                        f2 = top - this.f41046n;
                        break;
                    } else if (top <= f3 || f >= f3) {
                        if (i != size - 1 || ((float) this.f41043k) + top > f3) {
                            f = ((float) this.f41043k) + top;
                        } else {
                            f2 = top - this.f41046n;
                            i2 = i;
                        }
                    } else if (Math.abs(top - f3) > Math.abs(f - f3)) {
                        f2 = (f - ((float) this.f41043k)) - this.f41046n;
                    } else {
                        f2 = top - this.f41046n;
                    }
                }
                i++;
            }
            m30765a(f2);
        }
        return i;
    }

    private int getRealTimeSelectedIndex() {
        List<WheelItem> list = this.f41040h;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int size = this.f41040h.size();
        int measuredHeight = getMeasuredHeight() >> 1;
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            WheelItem wheelItem = this.f41040h.get(i2);
            float top = wheelItem.getTop();
            if (((float) wheelItem.getHeight()) + top >= 0.0f) {
                float f2 = (float) measuredHeight;
                if (top <= f2 && ((float) this.f41043k) + top >= f2) {
                    return i2;
                }
                if (top > f2 && f < f2) {
                    int i3 = (Math.abs(top - f2) > Math.abs(f - f2) ? 1 : (Math.abs(top - f2) == Math.abs(f - f2) ? 0 : -1));
                    return i2;
                } else if (i2 != size - 1 || ((float) this.f41043k) + top > f2) {
                    f = ((float) this.f41043k) + top;
                } else {
                    i = i2;
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    private int m30771c() {
        List<WheelItem> list = this.f41040h;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int size = this.f41040h.size();
        int measuredHeight = getMeasuredHeight() >> 1;
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            WheelItem wheelItem = this.f41040h.get(i2);
            float top = wheelItem.getTop();
            if (((float) wheelItem.getHeight()) + top >= 0.0f) {
                float f2 = (float) measuredHeight;
                if (top <= f2 && ((float) this.f41043k) + top >= f2) {
                    return i2;
                }
                if (top > f2 && f < f2) {
                    int i3 = (Math.abs(top - f2) > Math.abs(f - f2) ? 1 : (Math.abs(top - f2) == Math.abs(f - f2) ? 0 : -1));
                    return i2;
                } else if (i2 != size - 1 || ((float) this.f41043k) + top > f2) {
                    f = ((float) this.f41043k) + top;
                } else {
                    i = i2;
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m30765a(float f) {
        FlingRunnable flingRunnable = new FlingRunnable();
        this.f41054v = flingRunnable;
        flingRunnable.flingUp((int) (-f), 200);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30770b(float f) {
        if (this.f41040h != null) {
            for (int i = 0; i < this.f41040h.size(); i++) {
                WheelItem wheelItem = this.f41040h.get(i);
                wheelItem.setTop(wheelItem.getTop() + f);
            }
            if (f < 0.0f) {
                List<WheelItem> list = this.f41040h;
                if (list.get(list.size() - 1).getTop() + ((float) this.f41043k) < ((float) ((getMeasuredHeight() - this.f41051s) >> 1))) {
                    m30773d();
                    removeCallbacks(this.f41054v);
                    return;
                }
            }
            if (f > 0.0f) {
                if (this.f41040h.get(0).getTop() > ((float) ((getMeasuredHeight() + this.f41051s) >> 1))) {
                    m30774e();
                    removeCallbacks(this.f41054v);
                }
            }
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        m30772c(f2);
        return true;
    }

    /* renamed from: d */
    private void m30773d() {
        if (this.f41040h != null) {
            float measuredHeight = ((float) ((getMeasuredHeight() - this.f41051s) >> 1)) - ((float) this.f41043k);
            for (int size = this.f41040h.size() - 1; size >= 0; size--) {
                this.f41040h.get(size).setTop(measuredHeight);
                measuredHeight -= (float) this.f41043k;
            }
            invalidate();
        }
    }

    /* renamed from: e */
    private void m30774e() {
        if (this.f41040h != null) {
            float measuredHeight = (float) ((getMeasuredHeight() + this.f41051s) >> 1);
            int size = this.f41040h.size();
            for (int i = 0; i < size; i++) {
                this.f41040h.get(i).setTop(measuredHeight);
                measuredHeight += (float) this.f41043k;
            }
            invalidate();
        }
    }

    /* renamed from: c */
    private void m30772c(float f) {
        WheelItem wheelItem;
        List<WheelItem> list = this.f41040h;
        if (list != null) {
            int size = list.size();
            if (f > 0.0f) {
                wheelItem = this.f41040h.get(size - 1);
                if (wheelItem.getTop() + ((float) this.f41043k) <= ((float) ((getMeasuredHeight() - this.f41051s) >> 1))) {
                    m30773d();
                    return;
                }
            } else {
                wheelItem = this.f41040h.get(0);
                if (wheelItem.getTop() >= ((float) ((getMeasuredHeight() + this.f41051s) >> 1))) {
                    m30774e();
                    return;
                }
            }
            for (int i = 0; i < size; i++) {
                wheelItem = this.f41040h.get(i);
                wheelItem.setTop(wheelItem.getTop() - f);
            }
            SystemUtils.log(3, "WhellTest", "handleScroll item:" + wheelItem.getTitle(), (Throwable) null, "com.didi.sdk.view.wheel.Wheel", 616);
            invalidate();
            m30775f();
        }
    }

    /* renamed from: f */
    private void m30775f() {
        int realTimeSelectedIndex = getRealTimeSelectedIndex();
        if (realTimeSelectedIndex != this.f41050r) {
            this.f41034D = true;
            this.f41050r = realTimeSelectedIndex;
            this.f41035a = getCurrentText();
            m30776g();
            SystemUtils.log(3, f41029c, "sleecte:" + realTimeSelectedIndex + " voiceText:" + this.f41035a + " mdata:" + this.f41045m, (Throwable) null, "com.didi.sdk.view.wheel.Wheel", 632);
        }
    }

    /* renamed from: g */
    private void m30776g() {
        setContentDescription(this.f41035a);
        sendAccessibilityEvent(4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
        }
        float f = (((float) this.f41043k) * this.f41044l) + ((float) (this.f41057y + this.f41058z));
        setMeasuredDimension(size, (int) f);
        this.f41046n = (f - ((float) this.f41043k)) / 2.0f;
    }

    public class FlingRunnable implements Runnable {
        private int mLastFingY;
        private Scroller mScroller;

        public FlingRunnable() {
            this.mScroller = new Scroller(Wheel.this.getContext());
        }

        public void run() {
            if (this.mScroller.computeScrollOffset()) {
                Wheel.this.m30770b((float) (this.mScroller.getCurrY() - this.mLastFingY));
                Wheel.this.invalidate();
                this.mLastFingY = this.mScroller.getCurrY();
                Wheel.this.post(this);
                return;
            }
            Wheel.this.removeCallbacks(this);
            if (Wheel.this.f41053u != null) {
                Wheel.this.f41053u.onItemChanged(Wheel.this.f41050r);
            }
        }

        /* access modifiers changed from: private */
        public void flingUp(int i, int i2) {
            Wheel.this.removeCallbacks(this);
            this.mLastFingY = 0;
            this.mScroller.startScroll(0, 0, 0, i, i2);
            Wheel.this.post(this);
        }

        private void setVisibleCount(float f) {
            float unused = Wheel.this.f41044l = f;
        }

        private void setItemHeight(int i) {
            int unused = Wheel.this.f41043k = i;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private String getCurrentText() {
        List<String> list = this.f41045m;
        if (list == null || this.f41050r > list.size() - 1) {
            SystemUtils.log(3, f41029c, "getCurrentText: 为空  mCurrentIndex:" + this.f41050r, (Throwable) null, "com.didi.sdk.view.wheel.Wheel", 741);
            return "";
        }
        String str = this.f41045m.get(this.f41050r);
        SystemUtils.log(3, f41029c, "getCurrentText:" + str, (Throwable) null, "com.didi.sdk.view.wheel.Wheel", 738);
        return str;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.f41035a);
        accessibilityEvent.setContentDescription(this.f41035a);
    }

    private class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        int count;

        private MyAccessibilityDelegate() {
            this.count = 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(Wheel.class.getName());
            accessibilityEvent.setScrollable(true);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(Wheel.class.getName());
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (!TextUtils.isEmpty(Wheel.this.f41035a)) {
                SystemUtils.log(3, Wheel.f41029c, "onPopulateAccessibilityEvent:" + Wheel.this.f41035a, (Throwable) null, "com.didi.sdk.view.wheel.Wheel$MyAccessibilityDelegate", 774);
                StringBuilder sb = new StringBuilder();
                sb.append(Wheel.this.f41035a);
                int i = this.count + 1;
                this.count = i;
                sb.append(i);
                accessibilityEvent.setContentDescription(sb.toString());
                List text = accessibilityEvent.getText();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Wheel.this.f41035a);
                int i2 = this.count + 1;
                this.count = i2;
                sb2.append(i2);
                text.add(sb2.toString());
            }
        }
    }
}
