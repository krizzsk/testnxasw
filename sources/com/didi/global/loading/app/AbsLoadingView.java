package com.didi.global.loading.app;

import android.content.Context;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;

public abstract class AbsLoadingView implements ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private LoadingDelegate f24570a;

    public AbsLoadingView(Context context) {
        this.f24570a = new LoadingDelegate(context, this);
    }

    public void showMaskLayerLoading() {
        this.f24570a.showMaskLayerLoading();
    }

    public void showLoading() {
        this.f24570a.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f24570a.showLoading(loadingConfig);
    }

    public void hideLoading() {
        this.f24570a.hideLoading();
    }

    public boolean isLoading() {
        return this.f24570a.isLoading();
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().build();
    }
}
