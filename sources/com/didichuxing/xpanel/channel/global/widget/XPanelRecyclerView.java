package com.didichuxing.xpanel.channel.global.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.didichuxing.xpanel.base.BorderRecyclerView;
import com.didichuxing.xpanel.base.IState;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.taxis99.R;

public class XPanelRecyclerView extends BorderRecyclerView implements IState {
    public static final int CHECK = 0;
    public static final int IGNORE = 1;
    public static final int X_DEFAULT = 2;
    public static final int X_PULL_DOWN = 3;
    public static final int X_PULL_UP = 1;

    /* renamed from: a */
    private static final String f52000a = "XPanelRecyclerView";

    /* renamed from: t */
    private static float f52001t = ((float) (Math.log(0.28d) / Math.log(0.9d)));

    /* renamed from: v */
    private static final float f52002v = 0.1f;

    /* renamed from: A */
    private float f52003A;

    /* renamed from: B */
    private boolean f52004B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public IFlingListener f52005C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f52006D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public MyScrollerRunnable f52007E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Handler f52008F;

    /* renamed from: G */
    private Rect f52009G;

    /* renamed from: H */
    private boolean f52010H;

    /* renamed from: I */
    private int f52011I;

    /* renamed from: J */
    private int f52012J;

    /* renamed from: K */
    private int f52013K;

    /* renamed from: L */
    private RectF f52014L;

    /* renamed from: M */
    private Paint f52015M;

    /* renamed from: N */
    private Paint f52016N;

    /* renamed from: O */
    private Paint f52017O;

    /* renamed from: P */
    private int f52018P;

    /* renamed from: Q */
    private float f52019Q;

    /* renamed from: R */
    private float f52020R;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f52021b;

    /* renamed from: c */
    private int f52022c;

    /* renamed from: d */
    private boolean f52023d;

    /* renamed from: e */
    private boolean f52024e;

    /* renamed from: f */
    private XPanelSpaceView f52025f;

    /* renamed from: g */
    private boolean f52026g;

    /* renamed from: h */
    private int f52027h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f52028i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f52029j;

    /* renamed from: k */
    private IScrollStateListener f52030k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public RecyclerView.LayoutManager f52031l;

    /* renamed from: m */
    private int f52032m;
    public boolean mHandTouch;
    public IRecyclerViewHelper mHelper;

    /* renamed from: n */
    private int f52033n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Context f52034o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View f52035p;

    /* renamed from: q */
    private final int f52036q;

    /* renamed from: r */
    private float f52037r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f52038s;

    /* renamed from: u */
    private float f52039u;

    /* renamed from: w */
    private float f52040w;

    /* renamed from: x */
    private double f52041x;

    /* renamed from: y */
    private double f52042y;

    /* renamed from: z */
    private double f52043z;

    public interface IFlingListener {
        boolean onFling();
    }

    public interface IRecyclerViewHelper {
        int getTopWhiteBgIndex();

        boolean isItemNeedBgShadow(int i);
    }

    public interface IScrollStateListener {
        void changeState(int i);
    }

    public void requestChildFocus(View view, View view2) {
    }

    public void setHalfIndex(int i) {
    }

    public void stateBindChange(IState.IStateChange iStateChange) {
    }

    public void stateDestory() {
    }

    public void setDefaulStautsTop(int i) {
        this.f52021b = i;
    }

    public void setCardShaderTop(int i) {
        this.f52006D = i;
    }

    public void setRecyclerViewHelper(IRecyclerViewHelper iRecyclerViewHelper) {
        this.mHelper = iRecyclerViewHelper;
    }

    public XPanelRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f52021b = -1;
        this.f52023d = false;
        this.mHandTouch = false;
        this.f52024e = false;
        this.f52025f = null;
        this.f52026g = false;
        this.f52028i = 0;
        this.f52029j = 0;
        this.f52036q = 1;
        this.f52038s = 0;
        this.f52039u = ViewConfiguration.getScrollFriction();
        this.f52003A = 0.0f;
        this.f52004B = true;
        this.f52008F = new Handler(Looper.getMainLooper());
        this.f52009G = new Rect();
        this.f52010H = true;
        this.f52013K = -1;
        this.f52014L = new RectF();
        this.f52018P = 553648128;
        m39138a(context);
    }

    private class SScroller extends Scroller {
        public SScroller(Context context) {
            super(context);
        }

        public SScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public SScroller(Context context, Interpolator interpolator, boolean z) {
            super(context, interpolator, z);
        }
    }

    private class MyScrollerRunnable implements Runnable {
        private int mCurrentY;
        private int mFinalY;
        private SScroller ssCroller;

        public MyScrollerRunnable(Context context) {
            this.ssCroller = new SScroller(context);
        }

        public void stop() {
            this.ssCroller.abortAnimation();
        }

        public void start(int i) {
            this.ssCroller.abortAnimation();
            this.ssCroller.fling(0, 0, 0, i, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            this.mCurrentY = 0;
            this.mFinalY = this.ssCroller.getFinalY();
            XPanelRecyclerView.this.f52008F.post(this);
        }

        public void run() {
            this.ssCroller.computeScrollOffset();
            int currY = this.ssCroller.getCurrY() - this.mCurrentY;
            if (currY != 0) {
                View findViewByPosition = XPanelRecyclerView.this.f52031l.findViewByPosition(0);
                if (findViewByPosition == null || findViewByPosition.getTop() != 0) {
                    XPanelRecyclerView xPanelRecyclerView = XPanelRecyclerView.this;
                    View unused = xPanelRecyclerView.f52035p = xPanelRecyclerView.f52031l.findViewByPosition(1);
                    if (XPanelRecyclerView.this.f52035p != null) {
                        int top = XPanelRecyclerView.this.f52035p.getTop() + XPanelRecyclerView.this.f52006D;
                        if (top > currY && top - (this.mFinalY - this.mCurrentY) < (XPanelRecyclerView.this.getMeasuredHeight() - XPanelRecyclerView.this.f52028i) - XPanelRecyclerView.this.f52029j) {
                            XPanelRecyclerView.this.scrollBy(0, top);
                            this.ssCroller.abortAnimation();
                            XPanelRecyclerView.this.stopScroll();
                            return;
                        } else if (XPanelRecyclerView.this.f52021b > 0 && top - currY > XPanelRecyclerView.this.f52021b) {
                            XPanelRecyclerView xPanelRecyclerView2 = XPanelRecyclerView.this;
                            xPanelRecyclerView2.scrollBy(0, top - xPanelRecyclerView2.f52021b);
                            this.ssCroller.abortAnimation();
                            XPanelRecyclerView.this.stopScroll();
                            return;
                        }
                    }
                    XPanelRecyclerView.this.scrollBy(0, currY);
                } else {
                    this.ssCroller.abortAnimation();
                    return;
                }
            }
            this.mCurrentY = this.ssCroller.getCurrY();
            if (!this.ssCroller.isFinished()) {
                XPanelRecyclerView.this.f52008F.post(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public BorderRecyclerView.Border[] getDismissBorder() {
        return new BorderRecyclerView.Border[]{BorderRecyclerView.Border.TOP};
    }

    /* renamed from: a */
    private void m39138a(Context context) {
        m39137a();
        this.f52034o = context;
        this.f52003A = (float) getResources().getDimensionPixelSize(R.dimen._30dp);
        this.f52022c = 3;
        this.f52027h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f52037r = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setOnFlingListener(new RecyclerView.OnFlingListener() {
            public boolean onFling(int i, int i2) {
                int unused = XPanelRecyclerView.this.f52038s = 0;
                XPanelRecyclerView xPanelRecyclerView = XPanelRecyclerView.this;
                View unused2 = xPanelRecyclerView.f52035p = xPanelRecyclerView.f52031l.findViewByPosition(1);
                int b = (int) (XPanelRecyclerView.this.m39132a(i2) * ((double) Math.signum((float) i2)));
                if (XPanelRecyclerView.this.f52035p != null && XPanelRecyclerView.this.f52035p.getTop() >= 0) {
                    LogcatUtil.m39237d(XPanelRecyclerView.f52000a, "mSplineDistance=" + b);
                    if (XPanelRecyclerView.this.f52005C != null) {
                        return XPanelRecyclerView.this.f52005C.onFling();
                    }
                    return true;
                } else if (i2 >= 0) {
                    return false;
                } else {
                    if (XPanelRecyclerView.this.f52007E == null) {
                        XPanelRecyclerView xPanelRecyclerView2 = XPanelRecyclerView.this;
                        MyScrollerRunnable unused3 = xPanelRecyclerView2.f52007E = new MyScrollerRunnable(xPanelRecyclerView2.f52034o);
                    }
                    LogcatUtil.m39237d(XPanelRecyclerView.f52000a, "mFirstCard==null, start MyScrollerRunnable....");
                    XPanelRecyclerView.this.f52007E.start(i2);
                    return true;
                }
            }
        });
    }

    public boolean fling(int i, int i2) {
        LogcatUtil.m39237d(f52000a, "@fling, velocityY=" + i2);
        return super.fling(i, i2);
    }

    public void setFlingListener(IFlingListener iFlingListener) {
        this.f52005C = iFlingListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public double m39132a(int i) {
        double b = m39141b(i);
        float f = f52001t;
        return ((double) (this.f52039u * this.f52037r)) * Math.exp((((double) f) / (((double) f) - 1.0d)) * b);
    }

    /* renamed from: b */
    private double m39141b(int i) {
        return Math.log((double) ((((float) Math.abs(i)) * 0.1f) / (this.f52039u * this.f52037r)));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i2);
        this.f52032m = size;
        double d = ((double) size) * 0.5d;
        this.f52042y = d;
        this.f52043z = d;
        LogcatUtil.m39237d(f52000a, "@onMeasure, mPullUpLimit=" + this.f52043z);
    }

    public void smoothScrollBy(int i, int i2) {
        this.f52038s = 1;
        super.smoothScrollBy(i, i2);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        this.f52038s = 1;
        super.smoothScrollBy(i, i2, interpolator);
    }

    public void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        XPanelSpaceView xPanelSpaceView;
        if (this.f52023d) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f52013K = motionEvent.getPointerId(0);
            this.f52011I = Math.round(motionEvent.getX() + 0.5f);
            this.f52012J = Math.round(motionEvent.getY() + 0.5f);
            if (this.f52025f == null || getLayoutManager().getChildAt(0) != (xPanelSpaceView = this.f52025f)) {
                this.f52010H = false;
            } else {
                xPanelSpaceView.getHitRect(this.f52009G);
                if (this.f52009G.contains(this.f52011I, this.f52012J)) {
                    this.f52010H = !this.f52025f.contain(((int) motionEvent.getX()) - this.f52025f.getLeft(), ((int) motionEvent.getY()) - this.f52025f.getTop());
                } else {
                    this.f52010H = false;
                }
            }
        } else if (action == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f52013K);
            this.f52033n = findPointerIndex;
            if (findPointerIndex < 0) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int round = Math.round(motionEvent.getX(findPointerIndex) + 0.5f);
            int round2 = Math.round(motionEvent.getY(this.f52033n) + 0.5f);
            if (getScrollState() != 1) {
                int i = round - this.f52011I;
                int i2 = round2 - this.f52012J;
                boolean z = getLayoutManager().canScrollHorizontally() && Math.abs(i) > this.f52027h && (getLayoutManager().canScrollVertically() || Math.abs(i) > Math.abs(i2));
                if (getLayoutManager().canScrollVertically() && Math.abs(i2) > this.f52027h && (getLayoutManager().canScrollHorizontally() || Math.abs(i2) > Math.abs(i))) {
                    z = true;
                }
                if (!z || !super.onInterceptTouchEvent(motionEvent)) {
                    return false;
                }
                return true;
            }
        }
        if (!this.f52010H || this.mHandTouch) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.f52031l = layoutManager;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MyScrollerRunnable myScrollerRunnable = this.f52007E;
        if (myScrollerRunnable != null) {
            myScrollerRunnable.stop();
        }
        if (this.f52023d) {
            return false;
        }
        if (this.f52010H && !this.mHandTouch) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f52024e = true;
        }
        if (action == 2) {
            this.f52040w = motionEvent.getY() - ((float) this.f52012J);
            LogcatUtil.m39239i(f52000a, "mDirection=" + this.f52040w);
            this.f52038s = 0;
            if (this.mHandTouch && this.f52024e && ((float) this.f52012J) - motionEvent.getY() <= (-this.f52003A)) {
                this.f52024e = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListenerScrollState(IScrollStateListener iScrollStateListener) {
        this.f52030k = iScrollStateListener;
    }

    public void bindHandView(XPanelSpaceView xPanelSpaceView) {
        this.f52025f = xPanelSpaceView;
    }

    public void destroy() {
        this.f52025f = null;
    }

    /* renamed from: a */
    private void m39137a() {
        Paint paint = new Paint();
        this.f52016N = paint;
        paint.setColor(0);
        this.f52016N.setAntiAlias(true);
        this.f52016N.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r3.mHelper;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m39139a(android.graphics.Canvas r4, int r5, android.view.View r6) {
        /*
            r3 = this;
            if (r5 == 0) goto L_0x000b
            com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView$IRecyclerViewHelper r0 = r3.mHelper
            if (r0 == 0) goto L_0x000b
            boolean r5 = r0.isItemNeedBgShadow(r5)
            goto L_0x000c
        L_0x000b:
            r5 = 0
        L_0x000c:
            if (r5 != 0) goto L_0x000f
            return
        L_0x000f:
            android.graphics.RectF r5 = r3.f52014L
            int r0 = r6.getLeft()
            float r0 = (float) r0
            int r1 = r6.getTop()
            float r1 = (float) r1
            int r2 = r6.getRight()
            float r2 = (float) r2
            int r6 = r6.getBottom()
            float r6 = (float) r6
            r5.set(r0, r1, r2, r6)
            android.graphics.RectF r5 = r3.f52014L
            android.graphics.Paint r6 = r3.f52017O
            r0 = 0
            r4.drawRoundRect(r5, r0, r0, r6)
            android.graphics.RectF r5 = r3.f52014L
            android.graphics.Paint r6 = r3.f52015M
            r4.drawRoundRect(r5, r0, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView.m39139a(android.graphics.Canvas, int, android.view.View):void");
    }

    /* renamed from: a */
    private void m39140a(Canvas canvas, boolean z, View view) {
        this.f52014L.top = (float) (!z ? view.getBottom() : view.getTop());
        this.f52014L.left = 0.0f;
        this.f52014L.right = (float) getWidth();
        this.f52014L.bottom = (float) getBottom();
        canvas.drawRoundRect(this.f52014L, 0.0f, 0.0f, this.f52016N);
    }

    public void setKeepState(boolean z) {
        this.f52026g = z;
    }

    public void setBottomSpace(int i) {
        this.f52028i = i;
    }

    public void setDecoration(int i) {
        this.f52029j = i;
    }

    public int getState() {
        return this.f52038s;
    }

    public float getDirection() {
        return this.f52040w;
    }

    public boolean isDefault() {
        return this.f52004B;
    }

    public int getStatus() {
        return this.f52022c;
    }

    public void setCurrentStatus(int i) {
        this.f52022c = i;
    }
}
