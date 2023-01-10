package com.didi.dimina.container.p065ui.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.didi.dimina.container.p065ui.refresh.AbsOverView;
import com.didi.dimina.container.p065ui.refresh.IRefresh;
import com.didi.dimina.container.util.LogUtil;

/* renamed from: com.didi.dimina.container.ui.refresh.RefreshLayout */
public class RefreshLayout extends FrameLayout implements IRefresh {

    /* renamed from: a */
    C8263b f19550a = new C8263b() {
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float f3;
            float f4;
            if (Math.abs(f) <= Math.abs(f2) && (RefreshLayout.this.f19554e == null || RefreshLayout.this.f19554e.enableRefresh())) {
                if (RefreshLayout.this.f19556g && RefreshLayout.this.f19551b == AbsOverView.HiRefreshState.STATE_REFRESH) {
                    return true;
                }
                View childAt = RefreshLayout.this.getChildAt(0);
                View a = C8262a.m16600a((ViewGroup) RefreshLayout.this);
                if (C8262a.m16601a(a)) {
                    return false;
                }
                if ((RefreshLayout.this.f19551b != AbsOverView.HiRefreshState.STATE_REFRESH || childAt.getBottom() <= RefreshLayout.this.mAbsOverView.mPullRefreshHeight) && ((childAt.getBottom() > 0 || f2 <= 0.0f) && RefreshLayout.this.f19551b != AbsOverView.HiRefreshState.STATE_OVER_RELEASE)) {
                    if (a.getTop() < RefreshLayout.this.mAbsOverView.mPullRefreshHeight) {
                        f4 = (float) RefreshLayout.this.f19555f;
                        f3 = RefreshLayout.this.mAbsOverView.minDamp;
                    } else {
                        f4 = (float) RefreshLayout.this.f19555f;
                        f3 = RefreshLayout.this.mAbsOverView.maxDamp;
                    }
                    boolean a2 = RefreshLayout.this.m16594a((int) (f4 / f3), true);
                    int unused = RefreshLayout.this.f19555f = (int) (-f2);
                    return a2;
                }
            }
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AbsOverView.HiRefreshState f19551b;

    /* renamed from: c */
    private GestureDetector f19552c;

    /* renamed from: d */
    private AutoScroller f19553d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IRefresh.RefreshListener f19554e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f19555f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f19556g;

    /* renamed from: h */
    private boolean f19557h = true;
    protected AbsOverView mAbsOverView;

    public RefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16592a();
    }

    public RefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16592a();
    }

    public RefreshLayout(Context context) {
        super(context);
        m16592a();
    }

    /* renamed from: a */
    private void m16592a() {
        this.f19552c = new GestureDetector(getContext(), this.f19550a);
        this.f19553d = new AutoScroller();
    }

    public void setDisableRefreshScroll(boolean z) {
        this.f19556g = z;
    }

    public void refreshFinished() {
        View childAt = getChildAt(0);
        LogUtil.m16841i("refreshFinished head-bottom:" + childAt.getBottom());
        this.mAbsOverView.onFinish();
        this.mAbsOverView.setState(AbsOverView.HiRefreshState.STATE_INIT);
        int bottom = childAt.getBottom();
        if (bottom > 0) {
            m16593a(bottom);
        }
        this.f19551b = AbsOverView.HiRefreshState.STATE_INIT;
    }

    public void refreshAuto() {
        AbsOverView.HiRefreshState hiRefreshState = this.f19551b;
        if ((hiRefreshState == null || hiRefreshState == AbsOverView.HiRefreshState.STATE_INIT) && this.f19553d.isFinished()) {
            m16593a(-this.mAbsOverView.mPullRefreshHeight);
        }
    }

    public void setRefreshListener(IRefresh.RefreshListener refreshListener) {
        this.f19554e = refreshListener;
    }

    public void setRefreshOverView(AbsOverView absOverView) {
        AbsOverView absOverView2 = this.mAbsOverView;
        if (absOverView2 != null) {
            removeView(absOverView2);
        }
        this.mAbsOverView = absOverView;
        addView(this.mAbsOverView, 0, new FrameLayout.LayoutParams(-1, -2));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f19553d.isFinished()) {
            return false;
        }
        if (!isEnablePullDownToRefresh()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.f19551b == AbsOverView.HiRefreshState.STATE_REFRESH) {
            return true;
        }
        View childAt = getChildAt(0);
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 65280) {
            if (childAt.getBottom() <= 0 || this.f19551b == AbsOverView.HiRefreshState.STATE_REFRESH) {
                this.f19555f = 0;
            } else {
                m16593a(childAt.getBottom());
                return false;
            }
        }
        boolean onTouchEvent = this.f19552c.onTouchEvent(motionEvent);
        LogUtil.m16841i("gesture consumed：" + onTouchEvent);
        if ((onTouchEvent || !(this.f19551b == AbsOverView.HiRefreshState.STATE_INIT || this.f19551b == AbsOverView.HiRefreshState.STATE_REFRESH)) && childAt.getBottom() != 0) {
            motionEvent.setAction(3);
            return super.dispatchTouchEvent(motionEvent);
        } else if (onTouchEvent) {
            return true;
        } else {
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        if (childAt != null && childAt2 != null) {
            LogUtil.m16841i("onLayout head-height:" + childAt.getMeasuredHeight());
            int top = childAt2.getTop();
            if (this.f19551b == AbsOverView.HiRefreshState.STATE_REFRESH) {
                childAt.layout(0, this.mAbsOverView.mPullRefreshHeight - childAt.getMeasuredHeight(), i3, this.mAbsOverView.mPullRefreshHeight);
                childAt2.layout(0, this.mAbsOverView.mPullRefreshHeight, i3, this.mAbsOverView.mPullRefreshHeight + childAt2.getMeasuredHeight());
            } else {
                childAt.layout(0, top - childAt.getMeasuredHeight(), i3, top);
                childAt2.layout(0, top, i3, childAt2.getMeasuredHeight() + top);
            }
            for (int i5 = 2; i5 < getChildCount(); i5++) {
                getChildAt(i5).layout(0, i2, i3, i4);
            }
            LogUtil.m16841i("onLayout head-bottom:" + childAt.getBottom());
        }
    }

    /* renamed from: a */
    private void m16593a(int i) {
        if ((this.f19554e == null || i <= this.mAbsOverView.mPullRefreshHeight) && (i >= 0 || i < (-this.mAbsOverView.mPullRefreshHeight))) {
            this.f19553d.recover(i);
            return;
        }
        if (i > 0) {
            this.f19553d.recover(i - this.mAbsOverView.mPullRefreshHeight);
        } else {
            this.f19553d.recover(i);
        }
        this.f19551b = AbsOverView.HiRefreshState.STATE_OVER_RELEASE;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16594a(int i, boolean z) {
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        int top = childAt2.getTop() + i;
        LogUtil.m16841i("moveDown childTopWithOffset:" + top + ",child.getTop():" + childAt2.getTop() + ",offsetY:" + i);
        if (top <= 0) {
            LogUtil.m16841i("childTop<=0,mState " + this.f19551b);
            int i2 = -childAt2.getTop();
            childAt.offsetTopAndBottom(i2);
            childAt2.offsetTopAndBottom(i2);
            if (!(this.f19551b == AbsOverView.HiRefreshState.STATE_REFRESH || this.f19551b == AbsOverView.HiRefreshState.STATE_OVER_RELEASE)) {
                this.f19551b = AbsOverView.HiRefreshState.STATE_INIT;
            }
        } else if (this.f19551b == AbsOverView.HiRefreshState.STATE_REFRESH && top > this.mAbsOverView.mPullRefreshHeight) {
            return false;
        } else {
            if (top <= this.mAbsOverView.mPullRefreshHeight) {
                LogUtil.m16841i("childTop<=mAbsOverView.mPullRefreshHeight,mState " + this.f19551b);
                if (this.mAbsOverView.getState() != AbsOverView.HiRefreshState.STATE_VISIBLE && z) {
                    this.mAbsOverView.onVisible();
                    this.mAbsOverView.setState(AbsOverView.HiRefreshState.STATE_VISIBLE);
                    this.f19551b = AbsOverView.HiRefreshState.STATE_VISIBLE;
                }
                childAt.offsetTopAndBottom(i);
                childAt2.offsetTopAndBottom(i);
                if (top == this.mAbsOverView.mPullRefreshHeight && this.f19551b == AbsOverView.HiRefreshState.STATE_OVER_RELEASE) {
                    LogUtil.m16841i("trigger refresh()");
                    m16596b();
                }
            } else {
                LogUtil.m16841i("else ,mState " + this.f19551b);
                if (this.mAbsOverView.getState() != AbsOverView.HiRefreshState.STATE_OVER && z) {
                    this.mAbsOverView.onOver();
                    this.mAbsOverView.setState(AbsOverView.HiRefreshState.STATE_OVER);
                }
                childAt.offsetTopAndBottom(i);
                childAt2.offsetTopAndBottom(i);
            }
        }
        AbsOverView absOverView = this.mAbsOverView;
        if (absOverView != null) {
            absOverView.onScroll(childAt.getBottom(), this.mAbsOverView.mPullRefreshHeight);
        }
        return true;
    }

    /* renamed from: b */
    private void m16596b() {
        if (this.f19554e != null) {
            this.f19551b = AbsOverView.HiRefreshState.STATE_REFRESH;
            this.mAbsOverView.onRefresh();
            this.mAbsOverView.setState(AbsOverView.HiRefreshState.STATE_REFRESH);
            this.f19554e.onRefresh();
        }
    }

    public boolean isEnablePullDownToRefresh() {
        return this.f19557h;
    }

    public void setEnablePullDownToRefresh(boolean z) {
        this.f19557h = z;
    }

    /* renamed from: com.didi.dimina.container.ui.refresh.RefreshLayout$AutoScroller */
    private class AutoScroller implements Runnable {
        private boolean mIsFinished = true;
        private int mLastY;
        private final Scroller mScroller;

        AutoScroller() {
            this.mScroller = new Scroller(RefreshLayout.this.getContext(), new LinearInterpolator());
        }

        public void run() {
            if (this.mScroller.computeScrollOffset()) {
                LogUtil.m16841i("AutoScroller: lastY: " + this.mLastY + ",currY: " + this.mScroller.getCurrY());
                boolean unused = RefreshLayout.this.m16594a(this.mLastY - this.mScroller.getCurrY(), false);
                this.mLastY = this.mScroller.getCurrY();
                RefreshLayout.this.post(this);
                return;
            }
            RefreshLayout.this.removeCallbacks(this);
            this.mIsFinished = true;
        }

        /* access modifiers changed from: package-private */
        public void recover(int i) {
            RefreshLayout.this.removeCallbacks(this);
            this.mLastY = 0;
            this.mIsFinished = false;
            this.mScroller.startScroll(0, 0, 0, i, 300);
            RefreshLayout.this.post(this);
        }

        /* access modifiers changed from: package-private */
        public boolean isFinished() {
            return this.mIsFinished;
        }
    }
}
