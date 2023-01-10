package com.didi.global.fintech.cashier.fastpay.contract;

import com.didi.global.fintech.cashier.model.net.request.fastpay.DeductionChannel;
import com.didi.global.fintech.cashier.p118ui.IFastPayOrderContentViewHolder;
import com.didi.global.fintech.cashier.p118ui.viewholder.OrderType;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderContentViewBinder;", "D", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IFastPayOrderContentViewHolder;", "getOrderItemsByType", "", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/DeductionChannel;", "type", "Lcom/didi/global/fintech/cashier/ui/viewholder/OrderType;", "onAddCardClick", "", "cashier_fastpay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IFastPayViewBinders.kt */
public interface IFastPayOrderContentViewBinder<D> extends IFastPayBaseViewBinder<D, IFastPayOrderContentViewHolder> {
    List<DeductionChannel> getOrderItemsByType(OrderType orderType);

    void onAddCardClick();
}
