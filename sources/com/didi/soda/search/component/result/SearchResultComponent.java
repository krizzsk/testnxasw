package com.didi.soda.search.component.result;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.soda.customer.listener.LoadingViewSupporter;
import com.didi.soda.search.component.base.AbsSearchResultComponent;
import com.didi.soda.search.component.header.SearchHeaderInterface;
import com.didi.soda.search.component.result.Contract;

public class SearchResultComponent extends AbsSearchResultComponent<Contract.AbsSearchResultView, Contract.AbsSearchResultPresenter> {

    /* renamed from: a */
    SearchResultView f46275a;

    /* renamed from: b */
    SearchResultPresenter f46276b;

    /* renamed from: c */
    private SearchHeaderInterface f46277c;

    public SearchResultComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void setLoadingViewSupporter(LoadingViewSupporter loadingViewSupporter) {
        if (this.f46275a == null) {
            this.f46275a = new SearchResultView();
        }
    }

    public void setSearchHeaderInterface(SearchHeaderInterface searchHeaderInterface) {
        this.f46277c = searchHeaderInterface;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchResultView onCreateView() {
        if (this.f46275a == null) {
            this.f46275a = new SearchResultView();
        }
        this.f46275a.setSearchHeaderInterface(this.f46277c);
        return this.f46275a;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchResultPresenter onCreatePresenter() {
        if (this.f46276b == null) {
            this.f46276b = new SearchResultPresenter();
        }
        return this.f46276b;
    }

    public void setSearchResultLayoutVisibility(int i) {
        this.f46275a.setSearchResultLayoutVisibility(i);
    }

    public void onPageResult(Bundle bundle) {
        SearchResultPresenter searchResultPresenter = this.f46276b;
        if (searchResultPresenter != null) {
            searchResultPresenter.onPageResult(bundle);
        }
    }
}
