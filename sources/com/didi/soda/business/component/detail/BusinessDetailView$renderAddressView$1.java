package com.didi.soda.business.component.detail;

import com.didi.soda.business.component.detail.Contract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessDetailView.kt */
final class BusinessDetailView$renderAddressView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BusinessDetailView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessDetailView$renderAddressView$1(BusinessDetailView businessDetailView) {
        super(0);
        this.this$0 = businessDetailView;
    }

    public final void invoke() {
        Contract.AbsBusinessDetailPresenter absBusinessDetailPresenter = (Contract.AbsBusinessDetailPresenter) this.this$0.getPresenter();
        if (absBusinessDetailPresenter != null) {
            absBusinessDetailPresenter.openBusinessPositionMapPage();
        }
    }
}
