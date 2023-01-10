package com.didi.entrega.customer.widget.scroll;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;

public class CustomerSmoothScroller extends LinearSmoothScroller {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: a */
    private static final float f22454a = 25.0f;

    /* renamed from: b */
    private static final float f22455b = 20.0f;

    /* renamed from: c */
    private static final String f22456c = "CustomerSmoothScroller";

    /* renamed from: d */
    private int f22457d = 0;

    /* renamed from: e */
    private int f22458e = 1;

    /* renamed from: f */
    private int f22459f = -1;

    /* renamed from: g */
    private SmoothScrollListener f22460g;

    public CustomerSmoothScroller(Context context) {
        super(context);
    }

    public void setSmoothScrollListener(SmoothScrollListener smoothScrollListener) {
        this.f22460g = smoothScrollListener;
    }

    public void setOffset(int i) {
        this.f22457d = i;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            this.f22458e = i;
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void setSnapPreference(int i) {
        if (i == -1 || i == 1 || i == 0) {
            this.f22459f = i;
            return;
        }
        throw new IllegalArgumentException("invalid snapPreference:" + i);
    }

    /* access modifiers changed from: protected */
    public int calculateTimeForScrolling(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * (20.0f / ((float) GlobalContext.getContext().getResources().getDisplayMetrics().densityDpi))));
    }

    /* access modifiers changed from: protected */
    public int getVerticalSnapPreference() {
        if (this.f22458e != 1) {
            return super.getVerticalSnapPreference();
        }
        return this.f22459f;
    }

    /* access modifiers changed from: protected */
    public int getHorizontalSnapPreference() {
        if (this.f22458e != 0) {
            return super.getHorizontalSnapPreference();
        }
        return this.f22459f;
    }

    /* access modifiers changed from: protected */
    public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        super.onTargetFound(view, state, action);
        if (this.f22457d != 0 && action.getDuration() >= 1) {
            int i = this.f22458e;
            if (i == 0) {
                action.update(action.getDx() - this.f22457d, action.getDy(), action.getDuration(), action.getInterpolator());
            } else if (i == 1) {
                action.update(action.getDx(), action.getDy() - this.f22457d, action.getDuration(), action.getInterpolator());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        SmoothScrollListener smoothScrollListener = this.f22460g;
        if (smoothScrollListener != null) {
            smoothScrollListener.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        SmoothScrollListener smoothScrollListener = this.f22460g;
        if (smoothScrollListener != null) {
            smoothScrollListener.onStop();
        }
    }

    /* renamed from: a */
    private void m18483a(String str) {
        LogUtil.m18185i(f22456c, str);
    }
}
