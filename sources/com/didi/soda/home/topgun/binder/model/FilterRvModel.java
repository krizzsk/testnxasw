package com.didi.soda.home.topgun.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/FilterRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "filterManager", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "getFilterManager", "()Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "setFilterManager", "(Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;)V", "hasAnim", "", "getHasAnim", "()Z", "setHasAnim", "(Z)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FilterRvModel.kt */
public final class FilterRvModel implements RecyclerModel {

    /* renamed from: a */
    private FilterDataManager f45260a;

    /* renamed from: b */
    private boolean f45261b;

    public final FilterDataManager getFilterManager() {
        return this.f45260a;
    }

    public final void setFilterManager(FilterDataManager filterDataManager) {
        this.f45260a = filterDataManager;
    }

    public final boolean getHasAnim() {
        return this.f45261b;
    }

    public final void setHasAnim(boolean z) {
        this.f45261b = z;
    }
}
