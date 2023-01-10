package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.processor.OverScrollDecorator */
public class OverScrollDecorator extends Decorator {

    /* renamed from: b */
    private static final int f53881b = 3000;

    /* renamed from: c */
    private static final int f53882c = 0;

    /* renamed from: d */
    private static final int f53883d = 1;

    /* renamed from: e */
    private static final int f53884e = 2;

    /* renamed from: g */
    private static final int f53885g = 60;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public float f53886a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f53887f = 0;

    /* renamed from: h */
    private boolean f53888h = false;

    /* renamed from: i */
    private boolean f53889i = false;

    /* renamed from: j */
    private boolean f53890j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f53891k = new Handler() {
        public void handleMessage(Message message) {
            int touchSlop = OverScrollDecorator.this.f53880cp.getTouchSlop();
            int i = message.what;
            if (i == 0) {
                int unused = OverScrollDecorator.this.f53887f = -1;
            } else if (i != 1) {
                if (i == 2) {
                    int unused2 = OverScrollDecorator.this.f53887f = 60;
                    return;
                }
                return;
            }
            OverScrollDecorator.m40195a(OverScrollDecorator.this);
            View targetView = OverScrollDecorator.this.f53880cp.getTargetView();
            if (OverScrollDecorator.this.f53880cp.allowOverScroll()) {
                if (OverScrollDecorator.this.f53886a >= 3000.0f) {
                    if (ScrollingUtil.isViewToTop(targetView, touchSlop)) {
                        OverScrollDecorator.this.f53880cp.getAnimProcessor().animOverScrollTop(OverScrollDecorator.this.f53886a, OverScrollDecorator.this.f53887f);
                        float unused3 = OverScrollDecorator.this.f53886a = 0.0f;
                        int unused4 = OverScrollDecorator.this.f53887f = 60;
                    }
                } else if (OverScrollDecorator.this.f53886a <= -3000.0f && ScrollingUtil.isViewToBottom(targetView, touchSlop)) {
                    OverScrollDecorator.this.f53880cp.getAnimProcessor().animOverScrollBottom(OverScrollDecorator.this.f53886a, OverScrollDecorator.this.f53887f);
                    float unused5 = OverScrollDecorator.this.f53886a = 0.0f;
                    int unused6 = OverScrollDecorator.this.f53887f = 60;
                }
            }
            if (OverScrollDecorator.this.f53887f < 60) {
                OverScrollDecorator.this.f53891k.sendEmptyMessageDelayed(1, 10);
            }
        }
    };

    /* renamed from: a */
    static /* synthetic */ int m40195a(OverScrollDecorator overScrollDecorator) {
        int i = overScrollDecorator.f53887f;
        overScrollDecorator.f53887f = i + 1;
        return i;
    }

    public OverScrollDecorator(TwinklingRefreshLayout.CoContext coContext, IDecorator iDecorator) {
        super(coContext, iDecorator);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.decorator != null && this.decorator.dispatchTouchEvent(motionEvent);
    }

    public boolean interceptTouchEvent(MotionEvent motionEvent) {
        return this.decorator != null && this.decorator.interceptTouchEvent(motionEvent);
    }

    public boolean dealTouchEvent(MotionEvent motionEvent) {
        return this.decorator != null && this.decorator.dealTouchEvent(motionEvent);
    }

    public void onFingerDown(MotionEvent motionEvent) {
        if (this.decorator != null) {
            this.decorator.onFingerDown(motionEvent);
        }
        this.f53888h = ScrollingUtil.isViewToTop(this.f53880cp.getTargetView(), this.f53880cp.getTouchSlop());
        this.f53889i = ScrollingUtil.isViewToBottom(this.f53880cp.getTargetView(), this.f53880cp.getTouchSlop());
    }

    public void onFingerUp(MotionEvent motionEvent, boolean z) {
        if (this.decorator != null) {
            this.decorator.onFingerUp(motionEvent, this.f53890j && z);
        }
        this.f53890j = false;
    }

    public void onFingerScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2, float f3, float f4) {
        if (this.decorator != null) {
            this.decorator.onFingerScroll(motionEvent, motionEvent2, f, f2, f3, f4);
        }
    }

    public void onFingerFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.decorator != null) {
            this.decorator.onFingerFling(motionEvent, motionEvent2, f, f2);
        }
        if (this.f53880cp.enableOverScroll()) {
            int y = (int) (motionEvent2.getY() - motionEvent.getY());
            if (y < (-this.f53880cp.getTouchSlop()) && this.f53889i) {
                return;
            }
            if (y <= this.f53880cp.getTouchSlop() || !this.f53888h) {
                this.f53886a = f2;
                if (Math.abs(f2) >= 3000.0f) {
                    this.f53891k.sendEmptyMessage(0);
                    this.f53890j = true;
                    return;
                }
                this.f53886a = 0.0f;
                this.f53887f = 60;
            }
        }
    }
}
