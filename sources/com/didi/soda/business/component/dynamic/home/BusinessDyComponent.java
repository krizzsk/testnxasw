package com.didi.soda.business.component.dynamic.home;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.business.component.dynamic.BusinessPresenter;
import com.didi.soda.business.listener.BusinessCategoryListener;
import com.didi.soda.business.manager.BusinessGuideManager;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;

public class BusinessDyComponent extends MvpComponent<BusinessView, BusinessPresenter> {

    /* renamed from: a */
    private BusinessCategoryListener f42165a;

    /* renamed from: b */
    private BusinessPresenter f42166b;

    /* renamed from: c */
    private OnPlayAddToCartAnimation f42167c;

    public BusinessDyComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onPageResult(Bundle bundle) {
        BusinessPresenter businessPresenter = this.f42166b;
        if (businessPresenter != null) {
            businessPresenter.onPageResult(bundle);
        }
    }

    public void setBusinessCategoryListener(BusinessCategoryListener businessCategoryListener) {
        this.f42165a = businessCategoryListener;
    }

    /* access modifiers changed from: protected */
    public BusinessView onCreateView() {
        BusinessView businessView = new BusinessView();
        OnPlayAddToCartAnimation onPlayAddToCartAnimation = this.f42167c;
        if (onPlayAddToCartAnimation != null) {
            businessView.setOnPlayAddToCartAnimation(onPlayAddToCartAnimation);
        }
        return businessView;
    }

    /* access modifiers changed from: protected */
    public BusinessPresenter onCreatePresenter() {
        BusinessPresenter businessPresenter = new BusinessPresenter();
        this.f42166b = businessPresenter;
        businessPresenter.setBusinessCategoryListener(this.f42165a);
        return businessPresenter;
    }

    public boolean onBack() {
        if (!BusinessGuideManager.Companion.getInstance().handleKeyBack()) {
            ((BusinessPresenter) getPresenter()).onBack(1);
        }
        return true;
    }

    public void setOnPlayAnimationListener(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f42167c = onPlayAddToCartAnimation;
    }
}
