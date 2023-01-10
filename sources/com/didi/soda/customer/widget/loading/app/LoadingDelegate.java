package com.didi.soda.customer.widget.loading.app;

import android.content.Context;
import android.os.Bundle;
import com.didi.soda.customer.widget.loading.ILoadingHolder;
import com.didi.soda.customer.widget.loading.ILoadingable;
import com.didi.soda.customer.widget.loading.Loading;
import com.didi.soda.customer.widget.loading.LoadingConfig;

public class LoadingDelegate implements ILoadingable {

    /* renamed from: a */
    private Context f44649a;

    /* renamed from: b */
    private ILoadingHolder f44650b;

    public LoadingDelegate(Context context, ILoadingHolder iLoadingHolder) {
        this.f44649a = context;
        this.f44650b = iLoadingHolder;
    }

    public void hideLoading() {
        ILoadingHolder iLoadingHolder;
        if (this.f44649a != null && (iLoadingHolder = this.f44650b) != null) {
            Loading.hide(iLoadingHolder.getFallbackView());
        }
    }

    public boolean isLoading() {
        ILoadingHolder iLoadingHolder;
        if (this.f44649a == null || (iLoadingHolder = this.f44650b) == null) {
            return false;
        }
        return Loading.isShowing(iLoadingHolder.getFallbackView());
    }

    public void showLoading() {
        showLoading((LoadingConfig) null);
    }

    public void showLoading(LoadingConfig loadingConfig) {
        ILoadingHolder iLoadingHolder = this.f44650b;
        if (iLoadingHolder != null) {
            LoadingConfig loadingConfig2 = iLoadingHolder.getLoadingConfig();
            if (loadingConfig != null) {
                loadingConfig2.setWithMaskLayer(loadingConfig.isWithMaskLayer());
                if (loadingConfig.getRenderType() != null) {
                    loadingConfig2.setRenderType(loadingConfig.getRenderType());
                }
                if (loadingConfig.getRenderParams() != null) {
                    Bundle renderParams = loadingConfig2.getRenderParams();
                    if (renderParams != null) {
                        renderParams.putAll(loadingConfig.getRenderParams());
                    } else {
                        loadingConfig2.setRenderParams(loadingConfig.getRenderParams());
                    }
                }
            }
            if (this.f44650b.getFallbackView() != null) {
                Loading.make(this.f44649a, loadingConfig2.getRenderType(), loadingConfig2.getRenderParams(), this.f44650b.getFallbackView(), loadingConfig2.isWithMaskLayer(), loadingConfig2.getLoadingGravity()).show();
            }
        }
    }

    public void showMaskLayerLoading() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setWithMaskLayer(true);
        showLoading(loadingConfig);
    }
}
