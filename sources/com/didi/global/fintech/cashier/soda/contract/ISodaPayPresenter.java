package com.didi.global.fintech.cashier.soda.contract;

import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy;
import com.didi.global.fintech.cashier.user.model.GPayMethodItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&¨\u0006\r"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/contract/ISodaPayPresenter;", "", "refreshPayMethodInfo", "", "afterSelectPayment", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "requestPayMethodInfo", "strategy", "Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "payMethodItem", "", "Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem;", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ISodaPayPresenter.kt */
public interface ISodaPayPresenter {
    void refreshPayMethodInfo(List<? extends BasicPayment> list);

    void requestPayMethodInfo(PayInfoStrategy payInfoStrategy, List<GPayMethodItem> list);
}
