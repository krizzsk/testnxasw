package com.didi.entrega.customer.foundation.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.taxis99.R;

public final class AndroidBug5497Workaround {

    /* renamed from: a */
    private static AndroidBug5497Workaround f21914a;
    public static boolean sInterceptGlobalDialog;

    /* renamed from: b */
    private View f21915b;

    /* renamed from: c */
    private View f21916c;

    /* renamed from: d */
    private Activity f21917d;

    /* renamed from: e */
    private ViewTreeObserver.OnGlobalLayoutListener f21918e;

    /* renamed from: f */
    private int f21919f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnSoftInputVisibilityListener f21920g;

    public interface OnSoftInputVisibilityListener {
        void onVisibility(boolean z);
    }

    private AndroidBug5497Workaround(Activity activity) {
        this.f21917d = activity;
        View findViewById = activity.findViewById(R.id.entrega_conductor_root_layout);
        this.f21916c = findViewById;
        this.f21919f = findViewById.getHeight();
    }

    public static AndroidBug5497Workaround getInstance(Activity activity) {
        if (f21914a == null) {
            f21914a = new AndroidBug5497Workaround(activity);
        }
        return f21914a;
    }

    public void assistComponent(ScopeContext scopeContext, final View view) {
        LogUtil.m18185i("Dialog usable", "assistComponent");
        final ViewTreeObserver viewTreeObserver = this.f21917d.getWindow().getDecorView().getViewTreeObserver();
        final C86811 r1 = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m18231a(view, this.mUsableHeightPrevious, false);
            }
        };
        scopeContext.getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                viewTreeObserver.removeOnGlobalLayoutListener(r1);
            }
        });
        viewTreeObserver.addOnGlobalLayoutListener(r1);
    }

    public void assistGlobalDialog(final View view) {
        LogUtil.m18185i("Dialog usable", "assistGlobalDialog");
        this.f21915b = view;
        this.f21918e = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                if (!AndroidBug5497Workaround.sInterceptGlobalDialog) {
                    this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m18231a(view, this.mUsableHeightPrevious, true);
                }
            }
        };
        this.f21915b.getViewTreeObserver().addOnGlobalLayoutListener(this.f21918e);
    }

    public void assistLocalDialog(ScopeContext scopeContext, final View view) {
        final C86844 r0 = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m18231a(view, this.mUsableHeightPrevious, true);
            }
        };
        scopeContext.getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(r0);
            }
        });
        view.getViewTreeObserver().addOnGlobalLayoutListener(r0);
    }

    public void destroyGlobal() {
        View view = this.f21915b;
        if (!(view == null || this.f21918e == null)) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f21918e);
        }
        f21914a = null;
    }

    public void setOnSoftInputVisibilityListener(ScopeContext scopeContext, OnSoftInputVisibilityListener onSoftInputVisibilityListener) {
        this.f21920g = onSoftInputVisibilityListener;
        scopeContext.getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                OnSoftInputVisibilityListener unused = AndroidBug5497Workaround.this.f21920g = null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m18231a(View view, int i, boolean z) {
        int a = m18230a(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LogUtil.m18185i("Dialog usable", a + "/" + i + " " + this.f21919f);
        int i2 = this.f21919f;
        if (i2 == 0 || a == i) {
            return i;
        }
        int i3 = i2 - a;
        if (i3 > i2 / 4) {
            if (z) {
                layoutParams.height = i2 - i3;
            }
            OnSoftInputVisibilityListener onSoftInputVisibilityListener = this.f21920g;
            if (onSoftInputVisibilityListener != null) {
                onSoftInputVisibilityListener.onVisibility(true);
            }
        } else {
            if (z) {
                layoutParams.height = i2;
            }
            OnSoftInputVisibilityListener onSoftInputVisibilityListener2 = this.f21920g;
            if (onSoftInputVisibilityListener2 != null) {
                onSoftInputVisibilityListener2.onVisibility(false);
            }
            i3 = 0;
        }
        if (z) {
            view.requestLayout();
        } else {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i3);
        }
        return a;
    }

    /* renamed from: a */
    private int m18230a(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int top = this.f21917d.getWindow().getDecorView().getTop();
        View view2 = this.f21916c;
        if (view2 != null) {
            this.f21919f = view2.getHeight();
        }
        return rect.bottom - top;
    }
}
