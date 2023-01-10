package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.processor.RefreshProcessor */
public class RefreshProcessor implements IDecorator {

    /* renamed from: a */
    private float f53892a;

    /* renamed from: b */
    private float f53893b;

    /* renamed from: c */
    private boolean f53894c = false;

    /* renamed from: cp */
    protected TwinklingRefreshLayout.CoContext f53895cp;

    /* renamed from: d */
    private boolean f53896d = false;

    /* renamed from: e */
    private boolean f53897e = false;

    /* renamed from: f */
    private boolean f53898f = false;

    /* renamed from: g */
    private MotionEvent f53899g;

    public boolean dealTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean interceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onFingerDown(MotionEvent motionEvent) {
    }

    public void onFingerFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
    }

    public RefreshProcessor(TwinklingRefreshLayout.CoContext coContext) {
        if (coContext != null) {
            this.f53895cp = coContext;
            return;
        }
        throw new NullPointerException("The coprocessor can not be null.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r0 != 3) goto L_0x0193;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x019a
            if (r0 == r2) goto L_0x0177
            r3 = 2
            if (r0 == r3) goto L_0x0012
            r3 = 3
            if (r0 == r3) goto L_0x0177
            goto L_0x0193
        L_0x0012:
            r6.f53899g = r7
            float r0 = r7.getX()
            float r1 = r6.f53892a
            float r0 = r0 - r1
            float r1 = r7.getY()
            float r4 = r6.f53893b
            float r1 = r1 - r4
            boolean r4 = r6.f53894c
            r5 = 0
            if (r4 != 0) goto L_0x00ac
            float r0 = java.lang.Math.abs(r0)
            float r4 = java.lang.Math.abs(r1)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x00ac
            float r0 = java.lang.Math.abs(r1)
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r4 = r6.f53895cp
            int r4 = r4.getTouchSlop()
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ac
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0077
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            android.view.View r0 = r0.getTargetView()
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r4 = r6.f53895cp
            int r4 = r4.getTouchSlop()
            boolean r0 = com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil.isViewToTop(r0, r4)
            if (r0 == 0) goto L_0x0077
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.allowPullDown()
            if (r0 == 0) goto L_0x0077
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            r0.setStatePTD()
            float r0 = r7.getX()
            r6.f53892a = r0
            float r7 = r7.getY()
            r6.f53893b = r7
            r6.m40200a()
            r6.f53894c = r2
            return r2
        L_0x0077:
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ac
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            android.view.View r0 = r0.getTargetView()
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r4 = r6.f53895cp
            int r4 = r4.getTouchSlop()
            boolean r0 = com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil.isViewToBottom(r0, r4)
            if (r0 == 0) goto L_0x00ac
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.allowPullUp()
            if (r0 == 0) goto L_0x00ac
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            r0.setStatePBU()
            float r0 = r7.getX()
            r6.f53892a = r0
            float r7 = r7.getY()
            r6.f53893b = r7
            r6.f53894c = r2
            r6.m40200a()
            return r2
        L_0x00ac:
            boolean r0 = r6.f53894c
            if (r0 == 0) goto L_0x0193
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.isRefreshVisible()
            if (r0 != 0) goto L_0x0170
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.isLoadingVisible()
            if (r0 == 0) goto L_0x00c2
            goto L_0x0170
        L_0x00c2:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.isPrepareFinishRefresh()
            if (r0 != 0) goto L_0x0111
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.isStatePTD()
            if (r0 == 0) goto L_0x0111
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            int r0 = r0.getTouchSlop()
            int r0 = -r0
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00f0
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            android.view.View r0 = r0.getTargetView()
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r3 = r6.f53895cp
            int r3 = r3.getTouchSlop()
            boolean r0 = com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil.isViewToTop(r0, r3)
            if (r0 != 0) goto L_0x00f5
        L_0x00f0:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            r0.dispatchTouchEventSuper(r7)
        L_0x00f5:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r7 = r6.f53895cp
            float r7 = r7.getMaxHeadHeight()
            r0 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 * r0
            float r7 = java.lang.Math.min(r7, r1)
            float r1 = java.lang.Math.max(r5, r7)
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r7 = r6.f53895cp
            com.didiglobal.sa.biz.weight.tkrefreshlayout.processor.AnimProcessor r7 = r7.getAnimProcessor()
            r7.scrollHeadByMove(r1)
            goto L_0x0162
        L_0x0111:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.isPrepareFinishLoadMore()
            if (r0 != 0) goto L_0x0162
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.isStatePBU()
            if (r0 == 0) goto L_0x0162
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            int r0 = r0.getTouchSlop()
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x013e
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            android.view.View r0 = r0.getTargetView()
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r4 = r6.f53895cp
            int r4 = r4.getTouchSlop()
            boolean r0 = com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil.isViewToBottom(r0, r4)
            if (r0 != 0) goto L_0x0143
        L_0x013e:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            r0.dispatchTouchEventSuper(r7)
        L_0x0143:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r7 = r6.f53895cp
            int r7 = r7.getMaxBottomHeight()
            int r7 = -r7
            int r7 = r7 * 2
            float r7 = (float) r7
            float r7 = java.lang.Math.max(r7, r1)
            float r1 = java.lang.Math.min(r5, r7)
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r7 = r6.f53895cp
            com.didiglobal.sa.biz.weight.tkrefreshlayout.processor.AnimProcessor r7 = r7.getAnimProcessor()
            float r0 = java.lang.Math.abs(r1)
            r7.scrollBottomByMove(r0)
        L_0x0162:
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x016f
            boolean r7 = r6.f53898f
            if (r7 != 0) goto L_0x016f
            r6.f53898f = r2
            r6.m40201b()
        L_0x016f:
            return r2
        L_0x0170:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r7 = r0.dispatchTouchEventSuper(r7)
            return r7
        L_0x0177:
            boolean r0 = r6.f53894c
            if (r0 == 0) goto L_0x0193
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r7 = r6.f53895cp
            boolean r7 = r7.isStatePTD()
            if (r7 == 0) goto L_0x0186
            r6.f53896d = r2
            goto L_0x0190
        L_0x0186:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r7 = r6.f53895cp
            boolean r7 = r7.isStatePBU()
            if (r7 == 0) goto L_0x0190
            r6.f53897e = r2
        L_0x0190:
            r6.f53894c = r1
            return r2
        L_0x0193:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r7 = r0.dispatchTouchEventSuper(r7)
            return r7
        L_0x019a:
            r6.f53898f = r1
            r6.f53894c = r1
            float r0 = r7.getX()
            r6.f53892a = r0
            float r0 = r7.getY()
            r6.f53893b = r0
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.isEnableKeepIView()
            if (r0 == 0) goto L_0x01cc
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.isRefreshing()
            if (r0 != 0) goto L_0x01bf
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            r0.setPrepareFinishRefresh(r1)
        L_0x01bf:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            boolean r0 = r0.isLoadingMore()
            if (r0 != 0) goto L_0x01cc
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            r0.setPrepareFinishLoadMore(r1)
        L_0x01cc:
            com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext r0 = r6.f53895cp
            r0.dispatchTouchEventSuper(r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor.RefreshProcessor.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private void m40200a() {
        MotionEvent motionEvent = this.f53899g;
        if (motionEvent != null) {
            this.f53895cp.dispatchTouchEventSuper(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime() + ((long) ViewConfiguration.getLongPressTimeout()), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
        }
    }

    /* renamed from: b */
    private void m40201b() {
        MotionEvent motionEvent = this.f53899g;
        this.f53895cp.dispatchTouchEventSuper(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
    }

    public void onFingerUp(MotionEvent motionEvent, boolean z) {
        if (!z && this.f53896d) {
            this.f53895cp.getAnimProcessor().dealPullDownRelease();
        }
        if (!z && this.f53897e) {
            this.f53895cp.getAnimProcessor().dealPullUpRelease();
        }
        this.f53896d = false;
        this.f53897e = false;
    }

    public void onFingerScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2, float f3, float f4) {
        int touchSlop = this.f53895cp.getTouchSlop();
        if (this.f53895cp.isRefreshVisible() && f2 >= ((float) touchSlop) && !this.f53895cp.isOpenFloatRefresh()) {
            this.f53895cp.getAnimProcessor().animHeadHideByVy((int) f4);
        }
        if (this.f53895cp.isLoadingVisible() && f2 <= ((float) (-touchSlop))) {
            this.f53895cp.getAnimProcessor().animBottomHideByVy((int) f4);
        }
    }
}
