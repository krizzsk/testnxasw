package com.didi.global.fintech.cashier.soda.contract;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayView;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierCardChannelViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierPayBtnViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierThirdChannelViewHolder;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/contract/ISodaPaymentsView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "cardChannelView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "headerView", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaHeaderViewHolder;", "payBtnView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "scrollTo", "", "index", "", "setupView", "payInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "showLogoView", "thirdChannelView", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierThirdChannelViewHolder;", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IViews.kt */
public interface ISodaPaymentsView extends IGlobalCashierPayView {
    IGlobalCashierCardChannelViewHolder cardChannelView();

    ISodaHeaderViewHolder headerView();

    IGlobalCashierPayBtnViewHolder payBtnView();

    void scrollTo(int i);

    void setupView(PayInfoResponse payInfoResponse);

    void showLogoView();

    IGlobalCashierThirdChannelViewHolder thirdChannelView();
}
