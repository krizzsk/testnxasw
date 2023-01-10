package com.didi.global.fintech.cashier.soda.contract;

import com.didi.global.fintech.cashier.core.contract.IGlobalBizCashierPresenter;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J!\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/contract/ISodaPaymentsPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "onBackClicked", "", "onConfirmBtnClick", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onInstallmentClick", "cardIndex", "", "number", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IPresenters.kt */
public interface ISodaPaymentsPresenter extends IGlobalBizCashierPresenter {
    void onBackClicked();

    void onConfirmBtnClick(CashierAction cashierAction);

    void onInstallmentClick(String str, Integer num);
}
