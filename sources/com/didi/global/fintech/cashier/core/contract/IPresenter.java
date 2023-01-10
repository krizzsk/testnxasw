package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.core.contract.IView;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u0017\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IPresenter;", "V", "Lcom/didi/global/fintech/cashier/core/contract/IView;", "", "IView", "bindView", "", "view", "(Lcom/didi/global/fintech/cashier/core/contract/IView;)V", "onBind", "unBind", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IGlobalCashierPresenters.kt */
public interface IPresenter<V extends IView> {
    IView IView();

    void bindView(V v);

    void onBind();

    void unBind();
}
