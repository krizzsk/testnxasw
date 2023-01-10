package com.didi.payment.wallet.global.prepaidcard.resp;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/resp/CancelCardResp;", "Ljava/io/Serializable;", "()V", "data", "Lcom/didi/payment/wallet/global/prepaidcard/resp/CancelCardResp$Data;", "getData", "()Lcom/didi/payment/wallet/global/prepaidcard/resp/CancelCardResp$Data;", "setData", "(Lcom/didi/payment/wallet/global/prepaidcard/resp/CancelCardResp$Data;)V", "errmsg", "", "getErrmsg", "()Ljava/lang/String;", "setErrmsg", "(Ljava/lang/String;)V", "errno", "", "getErrno", "()Ljava/lang/Integer;", "setErrno", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Data", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CancelCardResp.kt */
public final class CancelCardResp implements Serializable {
    private Data data;
    private String errmsg;
    private Integer errno;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final void setErrmsg(String str) {
        this.errmsg = str;
    }

    public final Integer getErrno() {
        return this.errno;
    }

    public final void setErrno(Integer num) {
        this.errno = num;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/resp/CancelCardResp$Data;", "Ljava/io/Serializable;", "()V", "cancelStatus", "", "getCancelStatus", "()Ljava/lang/String;", "setCancelStatus", "(Ljava/lang/String;)V", "event", "getEvent", "setEvent", "fullKycStatus", "getFullKycStatus", "setFullKycStatus", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CancelCardResp.kt */
    public static final class Data implements Serializable {
        private String cancelStatus;
        private String event;
        private String fullKycStatus;

        public final String getCancelStatus() {
            return this.cancelStatus;
        }

        public final void setCancelStatus(String str) {
            this.cancelStatus = str;
        }

        public final String getFullKycStatus() {
            return this.fullKycStatus;
        }

        public final void setFullKycStatus(String str) {
            this.fullKycStatus = str;
        }

        public final String getEvent() {
            return this.event;
        }

        public final void setEvent(String str) {
            this.event = str;
        }
    }
}
