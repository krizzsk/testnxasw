package com.didi.entrega.customer.foundation.util.loadingmanager;

import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.loading.CommonLoadingImpl;

public class LoadingManager {

    /* renamed from: a */
    ICommonLoading f22014a;

    public LoadingManager(ScopeContext scopeContext, View view, View view2) {
        CommonLoadingImpl commonLoadingImpl = new CommonLoadingImpl();
        this.f22014a = commonLoadingImpl;
        commonLoadingImpl.setLoadingView(scopeContext, view, view2);
    }

    public void hideBlockLoading() {
        this.f22014a.hideBlockLoading();
    }

    public void hideLoading() {
        this.f22014a.hideLoading();
    }

    public boolean isLoading() {
        return this.f22014a.isLoading();
    }

    public void setLoadingViewContain(View view) {
        ICommonLoading iCommonLoading = this.f22014a;
        if (iCommonLoading != null) {
            iCommonLoading.setLoadingViewContain(view);
        }
    }

    public void showBlockLoading() {
        this.f22014a.showBlockLoading();
    }

    public void showLoading(boolean z) {
        this.f22014a.showLoading(z);
    }

    public void showLoading() {
        showLoading(false);
    }
}
