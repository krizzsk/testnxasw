package com.didi.global.fintech.cashier.soda.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierBaseViewBinder;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.ShowInfo;
import com.didi.global.fintech.cashier.soda.contract.ISodaHeaderViewBinder;
import com.didi.global.fintech.cashier.soda.contract.ISodaHeaderViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00040\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/viewbinder/SodaHeaderViewBinder;", "Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaHeaderViewHolder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaHeaderViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;)V", "onBackClick", "", "setupView", "payInfoResponse", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaHeaderViewBinder.kt */
public final class SodaHeaderViewBinder extends GlobalCashierBaseViewBinder<ISodaHeaderViewHolder, IGlobalMainCashierPresenter, PayInfoResponse> implements ISodaHeaderViewBinder<PayInfoResponse> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SodaHeaderViewBinder(IGlobalMainCashierPresenter iGlobalMainCashierPresenter) {
        super(iGlobalMainCashierPresenter);
        Intrinsics.checkNotNullParameter(iGlobalMainCashierPresenter, "presenter");
    }

    public void onBackClick() {
        ((IGlobalMainCashierPresenter) getPresenter()).onBackPressed("header");
    }

    public void setupView(PayInfoResponse payInfoResponse) {
        ShowInfo showInfo;
        super.setupView(payInfoResponse);
        ISodaHeaderViewHolder iSodaHeaderViewHolder = (ISodaHeaderViewHolder) getViewHolder();
        if (iSodaHeaderViewHolder != null) {
            String str = null;
            if (!(payInfoResponse == null || (showInfo = payInfoResponse.getShowInfo()) == null)) {
                str = showInfo.getNaviTitle();
            }
            iSodaHeaderViewHolder.updateHeaderInfo(str, new SodaHeaderViewBinder$setupView$1(this));
        }
    }
}
