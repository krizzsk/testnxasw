package com.didiglobal.xpanelnew.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.xpanelnew.util.XpLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class XpScrollView extends NestedScrollView {

    /* renamed from: A */
    private static final int f54235A = 100;

    /* renamed from: B */
    private static final int f54236B = 500;
    public static final int XP_SCROLL_DOWN = 2;
    public static final int XP_SCROLL_IDLE = 3;
    public static final int XP_SCROLL_UP = 1;
    public static final int X_DEFAULT = 2;
    public static final int X_PULL_DOWN = 3;
    public static final int X_PULL_UP = 1;

    /* renamed from: i */
    private static final String f54237i = "XpScrollView";

    /* renamed from: j */
    private static final String f54238j = "XpScrollView";

    /* renamed from: p */
    private static final long f54239p = 10;

    /* renamed from: z */
    private static final int f54240z = 250;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public OnScrollListener f54241C;

    /* renamed from: D */
    private int f54242D;

    /* renamed from: E */
    private int f54243E;

    /* renamed from: F */
    private XpMsgContainerListener f54244F;

    /* renamed from: G */
    private XpMsgClickListener f54245G;

    /* renamed from: H */
    private OnVisibilityChangedListener f54246H;

    /* renamed from: a */
    int f54247a;

    /* renamed from: b */
    int f54248b;

    /* renamed from: c */
    int f54249c;

    /* renamed from: d */
    int f54250d;

    /* renamed from: e */
    boolean f54251e;

    /* renamed from: f */
    boolean f54252f;

    /* renamed from: g */
    Runnable f54253g;

    /* renamed from: h */
    Runnable f54254h;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f54255k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public XpScrollViewListener f54256l;

    /* renamed from: m */
    private int f54257m;

    /* renamed from: n */
    private boolean f54258n;

    /* renamed from: o */
    private Context f54259o;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f54260q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public float f54261r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public float f54262s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Runnable f54263t;

    /* renamed from: u */
    private GestureListener f54264u;

    /* renamed from: v */
    private boolean f54265v;

    /* renamed from: w */
    private boolean f54266w;

    /* renamed from: x */
    private boolean f54267x;

    /* renamed from: y */
    private Rect f54268y;

    public interface GestureListener {
        void fling();
    }

    public interface OnScrollListener {
        void onScrollChanged(int i, int i2, int i3, int i4);

        void onScrollStopped(float f);

        void onScrolling();
    }

    public interface OnVisibilityChangedListener {
        void onVisibilityChanged(int i);
    }

    public interface XpMsgClickListener {
        void onClick();
    }

    public interface XpMsgContainerListener {
        Rect getMsgContainerRect();
    }

    public interface XpScrollViewListener {
        void direction(int i);

        void event(float f, float f2);

        int getAreaCanScrollAboveFirstCard();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface XpStatus {
    }

    public void setBlockFlinging(boolean z) {
        this.f54258n = z;
    }

    public void fling(int i) {
        if (!this.f54258n) {
            super.fling(i);
        }
    }

    public XpScrollView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public XpScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XpScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f54257m = 2;
        this.f54266w = true;
        this.f54267x = false;
        this.f54247a = 0;
        this.f54248b = 0;
        this.f54249c = 0;
        this.f54250d = 0;
        this.f54251e = false;
        this.f54252f = false;
        this.f54253g = new Runnable() {
            public void run() {
                if (XpScrollView.this.f54251e) {
                    SystemUtils.log(3, "XpScrollView", "The mTimerForUpEvent has executed, so set the mIsWaitUpEvent as false", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView$3", 245);
                    XpScrollView.this.f54251e = false;
                    return;
                }
                SystemUtils.log(3, "XpScrollView", "The mTimerForUpEvent has executed, mIsWaitUpEvent is false,so do nothing", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView$3", 249);
            }
        };
        this.f54254h = new Runnable() {
            public void run() {
                if (XpScrollView.this.f54252f) {
                    SystemUtils.log(3, "XpScrollView", "The mTimerForSecondClick has executed,so as a singleClick", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView$4", 333);
                    XpScrollView.this.f54252f = false;
                    return;
                }
                SystemUtils.log(3, "XpScrollView", "The mTimerForSecondClick has executed, the doubleclick has executed ,so do thing", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView$4", 338);
            }
        };
        m40432a(context);
    }

    public void setScrollEnabled(boolean z) {
        this.f54266w = z;
    }

    /* renamed from: a */
    private void m40432a(Context context) {
        this.f54259o = context;
        this.f54263t = new Runnable() {
            public void run() {
                if (XpScrollView.this.f54260q != XpScrollView.this.getScrollY()) {
                    if (XpScrollView.this.f54241C != null) {
                        XpScrollView.this.f54241C.onScrolling();
                    }
                    XpScrollView xpScrollView = XpScrollView.this;
                    int unused = xpScrollView.f54260q = xpScrollView.getScrollY();
                    XpScrollView xpScrollView2 = XpScrollView.this;
                    xpScrollView2.postDelayed(xpScrollView2.f54263t, 10);
                } else if (XpScrollView.this.f54241C != null) {
                    XpScrollView.this.f54241C.onScrollStopped(XpScrollView.this.f54262s);
                }
            }
        };
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int i = 2;
                if (motionEvent.getAction() == 2 && XpScrollView.this.f54256l != null) {
                    XpScrollView.this.f54256l.event(motionEvent.getX(), motionEvent.getY());
                }
                if (motionEvent.getAction() == 1) {
                    boolean unused = XpScrollView.this.f54255k = false;
                    if (motionEvent.getY() != XpScrollView.this.f54261r) {
                        if (motionEvent.getY() <= XpScrollView.this.f54261r) {
                            i = 1;
                        }
                        float unused2 = XpScrollView.this.f54262s = Math.abs(motionEvent.getY() - XpScrollView.this.f54261r);
                        if (XpScrollView.this.f54256l != null) {
                            XpScrollView.this.f54256l.direction(i);
                        }
                        if (XpScrollView.this.getDirection() != i) {
                            XpScrollView.this.setDirection(i);
                        }
                    }
                    XpScrollView xpScrollView = XpScrollView.this;
                    int unused3 = xpScrollView.f54260q = xpScrollView.getScrollY();
                    XpScrollView xpScrollView2 = XpScrollView.this;
                    xpScrollView2.postDelayed(xpScrollView2.f54263t, 10);
                }
                return false;
            }
        });
    }

    public void setDirectionListener(XpScrollViewListener xpScrollViewListener) {
        this.f54256l = xpScrollViewListener;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        OnVisibilityChangedListener onVisibilityChangedListener;
        super.onWindowVisibilityChanged(i);
        boolean z = i == 0;
        SystemUtils.log(6, "onWindowVisiChanged", z + "", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 184);
        SystemUtils.log(6, "onWindowVisiChanged", this.f54267x + "", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 185);
        if (this.f54267x != z && (onVisibilityChangedListener = this.f54246H) != null) {
            this.f54267x = z;
            onVisibilityChangedListener.onVisibilityChanged(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r5.getRawY() < ((float) r0)) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.f54265v
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 != 0) goto L_0x004b
            android.view.View r0 = r4.getChildAt(r1)
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x004a
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r3 = r0.getChildCount()
            if (r3 <= r2) goto L_0x004a
            android.view.View r0 = r0.getChildAt(r2)
            r3 = 2
            int[] r3 = new int[r3]
            if (r0 == 0) goto L_0x004b
            r0.getLocationOnScreen(r3)
            r0 = r3[r2]
            int r3 = r4.getStatus()
            if (r3 != r2) goto L_0x003a
            android.content.Context r0 = r4.f54259o
            r3 = 1106247680(0x41f00000, float:30.0)
            int r0 = com.didiglobal.xpanelnew.util.XpUtils.dip2px(r0, r3)
            goto L_0x0041
        L_0x003a:
            com.didiglobal.xpanelnew.view.widget.XpScrollView$XpScrollViewListener r3 = r4.f54256l
            int r3 = r3.getAreaCanScrollAboveFirstCard()
            int r0 = r0 - r3
        L_0x0041:
            float r3 = r5.getRawY()
            float r0 = (float) r0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x004b
        L_0x004a:
            return r1
        L_0x004b:
            int r0 = r5.getAction()
            if (r0 != r2) goto L_0x0058
            java.lang.String r0 = "MotionEvent"
            java.lang.String r1 = "dispatchTouchEvent"
            com.didiglobal.xpanelnew.util.XpLog.m40350d(r0, r1)
        L_0x0058:
            boolean r5 = super.dispatchTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xpanelnew.view.widget.XpScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f54266w) {
            return false;
        }
        if (this.f54246H != null) {
            this.f54268y = this.f54244F.getMsgContainerRect();
        }
        if (this.f54268y == null) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.f54251e && motionEvent.getAction() != 0) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f54249c = (int) motionEvent.getX();
                this.f54250d = (int) motionEvent.getY();
                if (Math.abs(this.f54249c - this.f54247a) > 100 || Math.abs(this.f54250d - this.f54248b) > 100) {
                    this.f54251e = false;
                    removeCallbacks(this.f54253g);
                    SystemUtils.log(3, "XpScrollView", "The touch down and up distance too far:cancel the click", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 302);
                } else {
                    this.f54251e = false;
                    removeCallbacks(this.f54253g);
                    if (this.f54268y != null && motionEvent.getRawY() > ((float) this.f54268y.top) && motionEvent.getRawY() < ((float) this.f54268y.bottom)) {
                        onSingleClick();
                        return true;
                    }
                }
            } else if (action == 2) {
                this.f54249c = (int) motionEvent.getX();
                this.f54250d = (int) motionEvent.getY();
                if (Math.abs(this.f54249c - this.f54247a) > 100 || Math.abs(this.f54250d - this.f54248b) > 100) {
                    this.f54251e = false;
                    removeCallbacks(this.f54253g);
                    SystemUtils.log(3, "XpScrollView", "The move distance too far:cancel the click", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 292);
                }
            } else if (action != 3) {
                SystemUtils.log(3, "XpScrollView", "irrelevant MotionEvent state:" + motionEvent.getAction(), (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 319);
            }
            this.f54251e = false;
            removeCallbacks(this.f54253g);
            SystemUtils.log(3, "XpScrollView", "The touch cancel state:cancel the click", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 316);
        } else {
            this.f54247a = (int) motionEvent.getX();
            this.f54248b = (int) motionEvent.getY();
            this.f54251e = true;
            postDelayed(this.f54253g, 250);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public void onSingleClick() {
        if (this.f54252f) {
            onDoubleClick();
            this.f54252f = false;
            removeCallbacks(this.f54254h);
            return;
        }
        this.f54252f = true;
        XpMsgClickListener xpMsgClickListener = this.f54245G;
        if (xpMsgClickListener != null) {
            xpMsgClickListener.onClick();
        }
        postDelayed(this.f54254h, 500);
    }

    public void onDoubleClick() {
        SystemUtils.log(3, "XpScrollView", "we can do sth for double click here", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 359);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f54257m = getStatus();
            this.f54261r = motionEvent.getY();
            this.f54255k = true;
            XpLog.m40350d("XpScrollView", "ACTION_DOWN");
        }
        if (motionEvent.getAction() == 1) {
            XpLog.m40350d("MotionEvent", "onInterceptTouchEvent");
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public int getLastStatus() {
        return this.f54257m;
    }

    public void setLastStatus(int i) {
        this.f54257m = i;
    }

    public float getFirstTouchY() {
        return this.f54261r;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f54241C = onScrollListener;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener = this.f54241C;
        if (onScrollListener != null) {
            onScrollListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    public boolean isChildVisible(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        getHitRect(rect);
        return view.getLocalVisibleRect(rect);
    }

    public boolean isAtTop() {
        return getScrollY() <= 0;
    }

    public boolean isAtBottom() {
        return getChildAt(getChildCount() - 1).getBottom() + getPaddingBottom() == getHeight() + getScrollY();
    }

    public void setCurrentStatus(int i) {
        this.f54242D = i;
    }

    public int getStatus() {
        return this.f54242D;
    }

    public int getDirection() {
        return this.f54243E;
    }

    public void setDoingAnim(boolean z) {
        this.f54265v = z;
    }

    public boolean getDoingAnim() {
        return this.f54265v;
    }

    /* access modifiers changed from: private */
    public void setDirection(int i) {
        this.f54243E = i;
    }

    public void setGestureListener(GestureListener gestureListener) {
        this.f54264u = gestureListener;
    }

    public boolean getIsFingerOnScreen() {
        return this.f54255k;
    }

    public void setXpMsgContainerListener(XpMsgContainerListener xpMsgContainerListener) {
        this.f54244F = xpMsgContainerListener;
    }

    public void setXpMsgClickListener(XpMsgClickListener xpMsgClickListener) {
        this.f54245G = xpMsgClickListener;
    }

    public void setOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        this.f54246H = onVisibilityChangedListener;
    }
}
