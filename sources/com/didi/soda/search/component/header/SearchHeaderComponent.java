package com.didi.soda.search.component.header;

import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.listener.LoadingViewSupporter;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.search.component.header.Contract;

public class SearchHeaderComponent extends MvpComponent<Contract.AbsSearchHeaderView, Contract.AbsSearchHeaderPresenter> implements LoadingViewSupporter, SearchHeaderInterface {

    /* renamed from: a */
    Contract.AbsSearchHeaderView f46237a;

    /* renamed from: b */
    SearchHeaderPresenter f46238b;

    /* renamed from: c */
    OnBackListener f46239c;

    public SearchHeaderComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public View getLoadingView() {
        return m34385c().getLoadingView();
    }

    public void setSortViewVisible(int i) {
        this.f46237a.setSortViewVisible(i);
    }

    public void setResultViewVisible(int i) {
        this.f46237a.setResultViewVisible(i);
    }

    public void setSearchHomeBackListener(OnBackListener onBackListener) {
        this.f46239c = onBackListener;
    }

    public void handleBack() {
        this.f46238b.handleBack();
    }

    public void resetIsFirstInputShow() {
        this.f46237a.resetIsFirstInputShow();
    }

    public void refreshSuggestion() {
        this.f46238b.refreshSuggestion();
        this.f46237a.showSoftInput();
    }

    public void showSoftInput() {
        this.f46237a.showSoftInput();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchHeaderView onCreateView() {
        return m34385c();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchHeaderPresenter onCreatePresenter() {
        SearchHeaderPresenter searchHeaderPresenter = new SearchHeaderPresenter();
        this.f46238b = searchHeaderPresenter;
        searchHeaderPresenter.setSearchHomeBackListener(this.f46239c);
        return this.f46238b;
    }

    /* renamed from: c */
    private Contract.AbsSearchHeaderView m34385c() {
        if (this.f46237a == null) {
            this.f46237a = new SearchHeaderView();
        }
        return this.f46237a;
    }
}
