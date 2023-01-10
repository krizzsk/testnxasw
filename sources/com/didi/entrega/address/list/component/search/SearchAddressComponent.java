package com.didi.entrega.address.list.component.search;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.entrega.address.list.component.search.core.SearchAddressPresenter;
import com.didi.entrega.address.list.component.search.core.SearchAddressView;

public class SearchAddressComponent extends MvpComponent<SearchAddressView, SearchAddressPresenter> {

    /* renamed from: a */
    SearchAddressView f21301a;

    public interface OnSearchAnimationListener {
        void onAnimationCompleted();
    }

    public SearchAddressComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void showOrHide(boolean z, OnSearchAnimationListener onSearchAnimationListener) {
        if (getPresenter() != null) {
            ((SearchAddressPresenter) getPresenter()).showOrHide(z, onSearchAnimationListener);
        }
    }

    /* access modifiers changed from: protected */
    public SearchAddressView onCreateView() {
        if (this.f21301a == null) {
            this.f21301a = new SearchAddressView();
        }
        return this.f21301a;
    }

    /* access modifiers changed from: protected */
    public SearchAddressPresenter onCreatePresenter() {
        return new SearchAddressPresenter();
    }

    public void setSearchTextHint(String str) {
        this.f21301a.setSearchTextHint(str);
    }
}
