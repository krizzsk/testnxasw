package com.didi.addressold.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

public class SweepView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static String f9925l = "ignore_id_for_sweep_list_view";

    /* renamed from: o */
    private static final String f9926o = "com.sdk.address.didi.map.joey.SweepView.close_expand_list_view_action";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f9927a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f9928b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f9929c;

    /* renamed from: d */
    private ViewDragHelper f9930d;

    /* renamed from: e */
    private int f9931e;

    /* renamed from: f */
    private int f9932f;

    /* renamed from: g */
    private OnSwipeStatusListener f9933g;

    /* renamed from: h */
    private Status f9934h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f9935i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f9936j;

    /* renamed from: k */
    private boolean f9937k;

    /* renamed from: m */
    private ViewDragHelper.Callback f9938m;

    /* renamed from: n */
    private Status f9939n;

    /* renamed from: p */
    private CloseExpandReceiver f9940p;

    public interface OnSwipeStatusListener {
        void onStartCloseAnimation();

        void onStartOpenAnimation();

        void onStatusChanged(Status status);
    }

    public enum Status {
        Open,
        Close
    }

    public void setStatus(Status status, boolean z) {
        this.f9934h = status;
        if (status == Status.Open) {
            m8649b(z);
        } else {
            m8644a(z);
        }
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8640a(Context context) {
        closeByObject(context, new int[]{hashCode()});
    }

    public static void closeByObject(Context context, int[] iArr) {
        Intent intent = new Intent();
        intent.setAction(f9926o);
        intent.putExtra(f9925l, iArr);
        context.sendBroadcast(intent);
    }

    private class CloseExpandReceiver extends BroadcastReceiver {
        private final int hashCode;

        public CloseExpandReceiver(int i) {
            this.hashCode = i;
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = !belongToIgnore(this.hashCode, intent.getIntArrayExtra(SweepView.f9925l));
            if (SweepView.this.isOpen() && z) {
                SweepView sweepView = SweepView.this;
                sweepView.m8644a(sweepView.f9935i);
            }
        }

        private boolean belongToIgnore(int i, int[] iArr) {
            if (iArr != null && iArr.length > 0) {
                for (int i2 : iArr) {
                    if (i2 == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean isOpen() {
        return this.f9934h == Status.Open;
    }

    public void setOnSwipeStatusListener(OnSwipeStatusListener onSwipeStatusListener) {
        this.f9933g = onSwipeStatusListener;
    }

    public void setDragClickListener(View.OnClickListener onClickListener) {
        View view = this.f9928b;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSmooth(boolean z) {
        this.f9935i = z;
    }

    public SweepView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SweepView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9934h = Status.Close;
        this.f9935i = true;
        this.f9936j = false;
        this.f9937k = false;
        this.f9938m = new ViewDragHelper.Callback() {
            public boolean tryCaptureView(View view, int i) {
                SweepView sweepView = SweepView.this;
                sweepView.m8640a(sweepView.getContext());
                return view == SweepView.this.f9928b;
            }

            public int clampViewPositionHorizontal(View view, int i, int i2) {
                if (view != SweepView.this.f9928b || i > 0) {
                    return 0;
                }
                return Math.max(i, -SweepView.this.f9929c);
            }

            public int getViewHorizontalDragRange(View view) {
                return SweepView.this.f9929c;
            }

            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                if (SweepView.this.f9936j && SweepView.this.f9928b == view) {
                    SweepView.this.f9927a.offsetLeftAndRight(i3);
                }
                SweepView.this.invalidate();
            }

            public void onViewReleased(View view, float f, float f2) {
                if (view != SweepView.this.f9928b) {
                    return;
                }
                if (f == 0.0f && ((float) Math.abs(SweepView.this.f9928b.getLeft())) > ((float) SweepView.this.f9929c) / 2.0f) {
                    SweepView sweepView = SweepView.this;
                    sweepView.m8649b(sweepView.f9935i);
                } else if (f < 0.0f) {
                    SweepView sweepView2 = SweepView.this;
                    sweepView2.m8649b(sweepView2.f9935i);
                } else {
                    SweepView sweepView3 = SweepView.this;
                    sweepView3.m8644a(sweepView3.f9935i);
                }
            }
        };
        this.f9939n = Status.Close;
        this.f9930d = ViewDragHelper.create(this, this.f9938m);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8644a(boolean z) {
        if (this.f9937k) {
            this.f9939n = this.f9934h;
            Status status = Status.Close;
            this.f9934h = status;
            if (!z) {
                m8641a(status);
            } else if (this.f9930d.smoothSlideViewTo(this.f9928b, 0, 0)) {
                OnSwipeStatusListener onSwipeStatusListener = this.f9933g;
                if (onSwipeStatusListener != null) {
                    onSwipeStatusListener.onStartCloseAnimation();
                }
                ViewCompat.postInvalidateOnAnimation(this);
            }
            if (this.f9933g != null && this.f9939n == Status.Open) {
                this.f9933g.onStatusChanged(this.f9934h);
            }
        }
    }

    /* renamed from: a */
    private void m8641a(Status status) {
        if (status == Status.Close) {
            if (this.f9936j) {
                View view = this.f9927a;
                int i = this.f9931e;
                view.layout(i, 0, this.f9929c + i, this.f9932f);
            } else {
                View view2 = this.f9927a;
                int i2 = this.f9931e;
                view2.layout(i2 - this.f9929c, 0, i2, this.f9932f);
            }
            this.f9928b.layout(0, 0, this.f9931e, this.f9932f);
            return;
        }
        View view3 = this.f9927a;
        int i3 = this.f9931e;
        view3.layout(i3 - this.f9929c, 0, i3, this.f9932f);
        View view4 = this.f9928b;
        int i4 = this.f9929c;
        view4.layout(-i4, 0, this.f9931e - i4, this.f9932f);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8649b(boolean z) {
        if (this.f9937k) {
            this.f9939n = this.f9934h;
            Status status = Status.Open;
            this.f9934h = status;
            if (!z) {
                m8641a(status);
            } else if (this.f9930d.smoothSlideViewTo(this.f9928b, -this.f9929c, 0)) {
                OnSwipeStatusListener onSwipeStatusListener = this.f9933g;
                if (onSwipeStatusListener != null) {
                    onSwipeStatusListener.onStartOpenAnimation();
                }
                ViewCompat.postInvalidateOnAnimation(this);
            }
            if (this.f9933g != null && this.f9939n == Status.Close) {
                this.f9933g.onStatusChanged(this.f9934h);
            }
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f9937k && this.f9930d.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 3) {
            return this.f9937k ? this.f9930d.shouldInterceptTouchEvent(motionEvent) : super.onInterceptTouchEvent(motionEvent);
        }
        this.f9930d.cancel();
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (this.f9937k && (viewDragHelper = this.f9930d) != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandable(boolean z) {
        this.f9937k = z;
        m8647b();
        if (z) {
            IntentFilter intentFilter = new IntentFilter(f9926o);
            this.f9940p = new CloseExpandReceiver(hashCode());
            try {
                getContext().registerReceiver(this.f9940p, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f9927a = getChildAt(0);
        this.f9928b = getChildAt(1);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m8647b();
    }

    /* renamed from: b */
    private void m8647b() {
        if (this.f9940p != null) {
            try {
                getContext().unregisterReceiver(this.f9940p);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f9940p = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f9931e = this.f9928b.getMeasuredWidth();
        this.f9932f = this.f9928b.getMeasuredHeight();
        this.f9929c = this.f9927a.getMeasuredWidth();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m8641a(Status.Close);
    }
}
