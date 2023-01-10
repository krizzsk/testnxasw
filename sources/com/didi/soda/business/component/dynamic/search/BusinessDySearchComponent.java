package com.didi.soda.business.component.dynamic.search;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.soda.business.component.search.AbBusinessSearchComponent;
import com.didi.soda.business.listener.BusinessSearchChangeListener;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;

public class BusinessDySearchComponent extends AbBusinessSearchComponent<BusinessDySearchView, BusinessDySearchPresent> implements RecommendWordListener {

    /* renamed from: a */
    private BusinessSearchChangeListener f42190a;

    /* renamed from: b */
    private BusinessDySearchPresent f42191b;

    /* renamed from: c */
    private OnPlayAddToCartAnimation f42192c;

    public BusinessDySearchComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onRecommendWordSearch(String str, String str2) {
        this.f42191b.onRecommendWordSearch(str, str2);
    }

    public void setBusinessSearchChangeListener(BusinessSearchChangeListener businessSearchChangeListener) {
        this.f42190a = businessSearchChangeListener;
    }

    public void onPageResult(Bundle bundle) {
        BusinessDySearchPresent businessDySearchPresent = this.f42191b;
        if (businessDySearchPresent != null && bundle != null) {
            businessDySearchPresent.onPageResult(bundle);
        }
    }

    public void goBack() {
        this.f42191b.goBack(1);
    }

    public void setOnPlayAddToCartAnimation(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f42192c = onPlayAddToCartAnimation;
    }

    /* access modifiers changed from: protected */
    public BusinessDySearchView onCreateView() {
        BusinessDySearchView businessDySearchView = new BusinessDySearchView();
        OnPlayAddToCartAnimation onPlayAddToCartAnimation = this.f42192c;
        if (onPlayAddToCartAnimation != null) {
            businessDySearchView.setOnPlayAddToCartAnimation(onPlayAddToCartAnimation);
        }
        return businessDySearchView;
    }

    /* access modifiers changed from: protected */
    public BusinessDySearchPresent onCreatePresenter() {
        BusinessDySearchPresent businessDySearchPresent = new BusinessDySearchPresent();
        this.f42191b = businessDySearchPresent;
        businessDySearchPresent.setBusinessSearchChangeListener(this.f42190a);
        return this.f42191b;
    }
}
