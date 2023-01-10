package com.didi.soda.customer.foundation.util.loadingmanager;

import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.loading.CommonLoadingImpl;

public class LoadingManager {

    /* renamed from: a */
    ICommonLoading f43861a;

    public LoadingManager(ScopeContext scopeContext, View view, View view2) {
        CommonLoadingImpl commonLoadingImpl = new CommonLoadingImpl();
        this.f43861a = commonLoadingImpl;
        commonLoadingImpl.setLoadingView(scopeContext, view, view2);
    }

    public void hideBlockLoading() {
        this.f43861a.hideBlockLoading();
    }

    public void hideLoading() {
        this.f43861a.hideLoading();
    }

    public boolean isLoading() {
        return this.f43861a.isLoading();
    }

    public void setLoadingViewContain(View view) {
        ICommonLoading iCommonLoading = this.f43861a;
        if (iCommonLoading != null) {
            iCommonLoading.setLoadingViewContain(view);
        }
    }

    public void showBlockLoading() {
        this.f43861a.showBlockLoading();
    }

    public void showLoading(boolean z) {
        this.f43861a.showLoading(z);
    }

    public void showLoading() {
        showLoading(false);
    }
}
