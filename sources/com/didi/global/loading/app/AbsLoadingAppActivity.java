package com.didi.global.loading.app;

import android.app.Activity;
import android.os.Bundle;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.apm.SystemUtils;

public abstract class AbsLoadingAppActivity extends Activity implements ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private LoadingDelegate f24568a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f24568a = new LoadingDelegate(this, this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).build();
    }

    public void showMaskLayerLoading() {
        this.f24568a.showMaskLayerLoading();
    }

    public void showLoading() {
        this.f24568a.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f24568a.showLoading(loadingConfig);
    }

    public void hideLoading() {
        this.f24568a.hideLoading();
    }

    public boolean isLoading() {
        return this.f24568a.isLoading();
    }
}
