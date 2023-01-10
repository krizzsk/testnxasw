package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.credit;

import com.didi.payment.commonsdk.net.WBaseResp;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/Data;", "getData", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/Data;", "setData", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/Data;)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.credit.BankCardResp */
/* compiled from: BankCardResp.kt */
public final class BankCardResp extends WBaseResp {
    private Data data;
    private String type;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }
}
