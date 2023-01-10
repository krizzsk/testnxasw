package com.didi.entrega.customer.foundation.util;

import android.view.View;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.widget.CustomerToastView;

public class CustomerToastHelper {

    /* renamed from: a */
    private static final int f21981a = 3000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FrameLayout f21982b;

    public CustomerToastHelper(FrameLayout frameLayout) {
        this.f21982b = frameLayout;
    }

    public void showCustomerToast(ScopeContext scopeContext, String str, ToastUtil.Type type) {
        if (this.f21982b != null) {
            final CustomerToastView customerToastView = new CustomerToastView(this.f21982b.getContext(), this.f21982b);
            customerToastView.updateContent(type, str);
            if (this.f21982b != null && !customerToastView.isShow()) {
                m18248a();
                customerToastView.show();
                C86891 r5 = new Runnable() {
                    public void run() {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f21982b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }
                };
                customerToastView.setTag(r5);
                UiHandlerUtil.postDelayed(r5, 3000);
            }
            if (scopeContext != null) {
                scopeContext.addObserver(new IScopeLifecycle() {
                    public void onCreate(ILive iLive) {
                    }

                    public void onResume(ILive iLive) {
                    }

                    public void onStart(ILive iLive) {
                    }

                    public void onDestroy(ILive iLive) {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f21982b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }

                    public void onPause(ILive iLive) {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f21982b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }

                    public void onStop(ILive iLive) {
                        CustomerToastView customerToastView;
                        if (CustomerToastHelper.this.f21982b != null && (customerToastView = customerToastView) != null) {
                            customerToastView.hide();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m18248a() {
        FrameLayout frameLayout = this.f21982b;
        if (frameLayout != null && frameLayout.getChildCount() > 0) {
            for (int i = 0; i < this.f21982b.getChildCount(); i++) {
                View childAt = this.f21982b.getChildAt(i);
                if (childAt != null && (childAt instanceof CustomerToastView)) {
                    childAt.clearAnimation();
                    if (childAt.getTag() != null && (childAt.getTag() instanceof Runnable)) {
                        UiHandlerUtil.removeCallbacks((Runnable) childAt.getTag());
                    }
                    this.f21982b.removeView(childAt);
                }
            }
        }
    }
}
