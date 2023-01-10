package com.didi.global.loading.app;

import android.app.Fragment;
import android.os.Bundle;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;

public abstract class AbsLoadingAppFragment extends Fragment implements ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private LoadingDelegate f24569a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f24569a = new LoadingDelegate(getActivity(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).build();
    }

    public void showMaskLayerLoading() {
        this.f24569a.showMaskLayerLoading();
    }

    public void showLoading() {
        this.f24569a.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f24569a.showLoading(loadingConfig);
    }

    public void hideLoading() {
        this.f24569a.hideLoading();
    }

    public boolean isLoading() {
        return this.f24569a.isLoading();
    }
}
