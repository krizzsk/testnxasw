package com.didi.soda.home.topgun.component.feed;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.widget.tabbar.ITabComponent;

public class HomeFeedComponent extends MvpComponent<HomeFeedView, HomeFeedPresenter> implements ITabComponent {

    /* renamed from: a */
    private HomeFeedPresenter f45307a;

    /* renamed from: b */
    private CustomerPage f45308b;

    public HomeFeedComponent(ViewGroup viewGroup, CustomerPage customerPage) {
        super(viewGroup);
        this.f45308b = customerPage;
    }

    public void onPageResult(Bundle bundle) {
        HomeFeedPresenter homeFeedPresenter = this.f45307a;
        if (homeFeedPresenter != null) {
            homeFeedPresenter.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public HomeFeedView onCreateView() {
        return new HomeFeedView();
    }

    /* access modifiers changed from: protected */
    public HomeFeedPresenter onCreatePresenter() {
        HomeFeedPresenter homeFeedPresenter = new HomeFeedPresenter(this.f45308b);
        this.f45307a = homeFeedPresenter;
        return homeFeedPresenter;
    }
}
