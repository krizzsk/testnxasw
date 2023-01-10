package com.didi.soda.customer.component.provider;

import android.view.View;
import java.lang.ref.WeakReference;

public class CartProviderProxy implements ICartProvider {

    /* renamed from: a */
    private WeakReference f43405a;

    public CartProviderProxy(ICartProvider iCartProvider) {
        this.f43405a = new WeakReference(iCartProvider);
    }

    public boolean isCanShow() {
        ICartProvider iCartProvider = (ICartProvider) this.f43405a.get();
        if (iCartProvider != null) {
            return iCartProvider.isCanShow();
        }
        return false;
    }

    public void hideAll() {
        ICartProvider iCartProvider = (ICartProvider) this.f43405a.get();
        if (iCartProvider != null) {
            iCartProvider.hideAll();
        }
    }

    public void showAll() {
        ICartProvider iCartProvider = (ICartProvider) this.f43405a.get();
        if (iCartProvider != null) {
            iCartProvider.showAll();
        }
    }

    public void setOnClickCartListener(View.OnClickListener onClickListener) {
        ICartProvider iCartProvider = (ICartProvider) this.f43405a.get();
        if (iCartProvider != null) {
            iCartProvider.setOnClickCartListener(onClickListener);
        }
    }

    public void hide() {
        ICartProvider iCartProvider = (ICartProvider) this.f43405a.get();
        if (iCartProvider != null) {
            iCartProvider.hide();
        }
    }

    public void hideLoading() {
        ICartProvider iCartProvider = (ICartProvider) this.f43405a.get();
        if (iCartProvider != null) {
            iCartProvider.hideLoading();
        }
    }

    public void show() {
        ICartProvider iCartProvider = (ICartProvider) this.f43405a.get();
        if (iCartProvider != null) {
            iCartProvider.show();
        }
    }

    public void showLoading() {
        ICartProvider iCartProvider = (ICartProvider) this.f43405a.get();
        if (iCartProvider != null) {
            iCartProvider.showLoading();
        }
    }
}
