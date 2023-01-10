package com.didi.global.fintech.cashier.p118ui.omega;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/omega/PubPageType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "CHECKOUT", "INSTALLMENT", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.omega.PubPageType */
/* compiled from: CashierOmegaUtils.kt */
public enum PubPageType {
    CHECKOUT("checkout"),
    INSTALLMENT("installment");
    
    private final String type;

    private PubPageType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
