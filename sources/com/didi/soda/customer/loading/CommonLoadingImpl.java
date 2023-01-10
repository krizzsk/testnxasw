package com.didi.soda.customer.loading;

import android.view.View;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.loadingmanager.ICommonLoading;
import com.didi.soda.customer.widget.loading.ILoadingHolder;
import com.didi.soda.customer.widget.loading.ILoadingable;
import com.didi.soda.customer.widget.loading.LoadingConfig;
import com.didi.soda.customer.widget.loading.LoadingRenderType;
import com.didi.soda.customer.widget.loading.app.LoadingDelegate;

public class CommonLoadingImpl implements ICommonLoading, ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private View f43953a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LoadingDelegate f43954b;

    public View getFallbackView() {
        return this.f43953a;
    }

    public LoadingConfig getLoadingConfig() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setRenderType(LoadingRenderType.ANIMATION);
        return loadingConfig;
    }

    public void hideBlockLoading() {
        this.f43954b.hideLoading();
    }

    public void hideLoading() {
        this.f43954b.hideLoading();
    }

    public boolean isLoading() {
        return this.f43954b.isLoading();
    }

    public void setLoadingView(ScopeContext scopeContext, View view, View view2) {
        this.f43954b = new LoadingDelegate(GlobalContext.getContext(), this);
        scopeContext.addObserver(new IScopeLifecycle() {
            public void onCreate(ILive iLive) {
            }

            public void onDestroy(ILive iLive) {
            }

            public void onPause(ILive iLive) {
            }

            public void onResume(ILive iLive) {
            }

            public void onStart(ILive iLive) {
            }

            public void onStop(ILive iLive) {
                CommonLoadingImpl.this.f43954b.hideLoading();
            }
        });
        this.f43953a = view2;
    }

    public void setLoadingViewContain(View view) {
        if (view != null) {
            this.f43953a = view;
        }
    }

    public void showBlockLoading() {
        this.f43954b.showMaskLayerLoading();
    }

    public void showLoading(boolean z) {
        this.f43954b.showLoading();
    }

    public void showLoading() {
        this.f43954b.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f43954b.showLoading(loadingConfig);
    }
}
