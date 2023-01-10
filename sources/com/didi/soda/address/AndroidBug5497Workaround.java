package com.didi.soda.address;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.taxis99.R;

public final class AndroidBug5497Workaround {

    /* renamed from: a */
    private static AndroidBug5497Workaround f41346a;
    public static boolean sInterceptGlobalDialog;

    /* renamed from: b */
    private View f41347b;

    /* renamed from: c */
    private View f41348c;

    /* renamed from: d */
    private Activity f41349d;

    /* renamed from: e */
    private ViewTreeObserver.OnGlobalLayoutListener f41350e;

    /* renamed from: f */
    private int f41351f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnSoftInputVisibilityListener f41352g;

    public interface OnSoftInputVisibilityListener {
        void onVisibility(boolean z);
    }

    private AndroidBug5497Workaround(Activity activity) {
        this.f41349d = activity;
        View findViewById = activity.findViewById(R.id.customer_conductor_root_layout);
        this.f41348c = findViewById;
        this.f41351f = findViewById.getHeight();
    }

    public static AndroidBug5497Workaround getInstance(Activity activity) {
        if (f41346a == null) {
            f41346a = new AndroidBug5497Workaround(activity);
        }
        return f41346a;
    }

    public void assistComponent(ScopeContext scopeContext, final View view) {
        LogUtil.m32588i("Dialog usable", "assistComponent");
        final ViewTreeObserver viewTreeObserver = this.f41349d.getWindow().getDecorView().getViewTreeObserver();
        final C141841 r1 = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m31024a(view, this.mUsableHeightPrevious, false);
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
        LogUtil.m32588i("Dialog usable", "assistGlobalDialog");
        this.f41347b = view;
        this.f41350e = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                if (!AndroidBug5497Workaround.sInterceptGlobalDialog) {
                    this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m31024a(view, this.mUsableHeightPrevious, true);
                }
            }
        };
        this.f41347b.getViewTreeObserver().addOnGlobalLayoutListener(this.f41350e);
    }

    public void assistLocalDialog(ScopeContext scopeContext, final View view) {
        final C141874 r0 = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m31024a(view, this.mUsableHeightPrevious, true);
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
        View view = this.f41347b;
        if (!(view == null || this.f41350e == null)) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f41350e);
        }
        f41346a = null;
    }

    public void setOnSoftInputVisibilityListener(ScopeContext scopeContext, OnSoftInputVisibilityListener onSoftInputVisibilityListener) {
        this.f41352g = onSoftInputVisibilityListener;
        scopeContext.getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                OnSoftInputVisibilityListener unused = AndroidBug5497Workaround.this.f41352g = null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m31024a(View view, int i, boolean z) {
        int a = m31023a(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LogUtil.m32588i("Dialog usable", a + "/" + i + " " + this.f41351f);
        int i2 = this.f41351f;
        if (i2 == 0 || a == i) {
            return i;
        }
        int i3 = i2 - a;
        if (i3 > i2 / 4) {
            if (z) {
                layoutParams.height = i2 - i3;
            }
            OnSoftInputVisibilityListener onSoftInputVisibilityListener = this.f41352g;
            if (onSoftInputVisibilityListener != null) {
                onSoftInputVisibilityListener.onVisibility(true);
            }
        } else {
            if (z) {
                layoutParams.height = i2;
            }
            OnSoftInputVisibilityListener onSoftInputVisibilityListener2 = this.f41352g;
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
    private int m31023a(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int top = this.f41349d.getWindow().getDecorView().getTop();
        View view2 = this.f41348c;
        if (view2 != null) {
            this.f41351f = view2.getHeight();
        }
        return rect.bottom - top;
    }
}
