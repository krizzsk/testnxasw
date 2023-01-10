package com.didi.soda.business.component.dynamic.search;

import android.view.ViewGroup;
import com.didi.soda.business.component.search.AbBusinessHotWordComponent;
import com.didi.soda.business.listener.RecommendWordListener;

public class BusinessDyHotWordComponent extends AbBusinessHotWordComponent<BusinessDyHotWordView, BusinessDyHotWordPresent> {

    /* renamed from: a */
    private RecommendWordListener f42183a;

    public BusinessDyHotWordComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void setRecommendWordListener(RecommendWordListener recommendWordListener) {
        this.f42183a = recommendWordListener;
    }

    /* access modifiers changed from: protected */
    public BusinessDyHotWordView onCreateView() {
        return new BusinessDyHotWordView();
    }

    /* access modifiers changed from: protected */
    public BusinessDyHotWordPresent onCreatePresenter() {
        BusinessDyHotWordPresent businessDyHotWordPresent = new BusinessDyHotWordPresent();
        businessDyHotWordPresent.setRecommendWordListener(this.f42183a);
        return businessDyHotWordPresent;
    }
}
