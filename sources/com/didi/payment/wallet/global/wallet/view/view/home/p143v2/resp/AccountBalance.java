package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp;

import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeAmountStatus;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountBalance;", "Ljava/io/Serializable;", "()V", "balance", "", "getBalance", "()Ljava/lang/String;", "setBalance", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "localBalance", "getLocalBalance", "title", "getTitle", "setTitle", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountBalance */
/* compiled from: WalletHomeModel.kt */
public final class AccountBalance implements Serializable {
    private String balance;
    private String linkUrl;
    private String title;

    public final String getBalance() {
        return this.balance;
    }

    public final void setBalance(String str) {
        this.balance = str;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getLocalBalance() {
        if (WalletHomeAmountStatus.Companion.isShowAmount()) {
            return this.balance;
        }
        return WalletHomeAmountStatus.Companion.getEncryptionStr(4);
    }
}
