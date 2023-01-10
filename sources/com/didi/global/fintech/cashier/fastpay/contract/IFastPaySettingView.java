package com.didi.global.fintech.cashier.fastpay.contract;

import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.p118ui.IFastPayHeaderViewHolder;
import com.didi.global.fintech.cashier.p118ui.IFastPayMainBtnViewHolder;
import com.didi.global.fintech.cashier.p118ui.IFastPaySettingContentViewHolder;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingView;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseView;", "contentView", "Lcom/didi/global/fintech/cashier/ui/IFastPaySettingContentViewHolder;", "headerView", "Lcom/didi/global/fintech/cashier/ui/IFastPayHeaderViewHolder;", "payBtnView", "Lcom/didi/global/fintech/cashier/ui/IFastPayMainBtnViewHolder;", "setupView", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "cashier_fastpay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IFastPayViews.kt */
public interface IFastPaySettingView extends IFastPayBaseView {
    IFastPaySettingContentViewHolder contentView();

    IFastPayHeaderViewHolder headerView();

    IFastPayMainBtnViewHolder payBtnView();

    void setupView(FastPayInfoResponse fastPayInfoResponse);
}
