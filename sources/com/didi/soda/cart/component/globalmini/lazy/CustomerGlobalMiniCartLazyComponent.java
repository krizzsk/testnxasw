package com.didi.soda.cart.component.globalmini.lazy;

import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.cart.component.globalmini.lazy.Contract;
import com.didi.soda.customer.base.lazycomponent.LazyComponent;
import com.didi.soda.customer.component.provider.ICartProvider;

public class CustomerGlobalMiniCartLazyComponent extends LazyComponent<Contract.AbsGlobalMiniCartView, Contract.AbsGlobalMiniCartPresenter> implements ICartProvider {

    /* renamed from: b */
    private Contract.AbsGlobalMiniCartView f42553b;

    public CustomerGlobalMiniCartLazyComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public boolean isCanShow() {
        if (this.f42553b == null) {
            return false;
        }
        load();
        return this.f42553b.isCanShow();
    }

    public void hideAll() {
        if (this.f42553b != null) {
            load();
            this.f42553b.hideAll();
        }
    }

    public void showAll() {
        if (this.f42553b != null) {
            load();
            this.f42553b.showAll();
        }
    }

    public void setOnClickCartListener(View.OnClickListener onClickListener) {
        if (this.f42553b != null) {
            load();
            this.f42553b.setOnClickCartListener(onClickListener);
        }
    }

    public void hide() {
        if (this.f42553b != null) {
            load();
            this.f42553b.hide();
        }
    }

    public void hideLoading() {
        if (this.f42553b != null) {
            load();
            this.f42553b.hideLoading();
        }
    }

    public void show() {
        if (this.f42553b != null) {
            load();
            this.f42553b.show();
        }
    }

    public void showLoading() {
        if (this.f42553b != null) {
            load();
            this.f42553b.showLoading();
        }
    }

    /* access modifiers changed from: protected */
    public Contract.AbsGlobalMiniCartPresenter onCreatePresenter() {
        return new CustomerGlobalMiniCartLazyPresenter();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsGlobalMiniCartView onCreateView() {
        CustomerGlobalMiniCartLazyView customerGlobalMiniCartLazyView = new CustomerGlobalMiniCartLazyView();
        this.f42553b = customerGlobalMiniCartLazyView;
        return customerGlobalMiniCartLazyView;
    }
}
