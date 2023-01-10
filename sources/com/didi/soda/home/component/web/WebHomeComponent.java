package com.didi.soda.home.component.web;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class WebHomeComponent extends MvpComponent<WebHomeView, WebHomePresenter> {

    /* renamed from: a */
    private WebHomePresenter f45103a;

    public WebHomeComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public WebHomeView onCreateView() {
        return new WebHomeView();
    }

    /* access modifiers changed from: protected */
    public WebHomePresenter onCreatePresenter() {
        WebHomePresenter webHomePresenter = new WebHomePresenter();
        this.f45103a = webHomePresenter;
        return webHomePresenter;
    }
}
