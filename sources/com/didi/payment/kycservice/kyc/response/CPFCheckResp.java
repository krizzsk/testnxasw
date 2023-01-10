package com.didi.payment.kycservice.kyc.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/response/CPFCheckResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/kyc/response/CPFCheckResp$Data;", "getData", "()Lcom/didi/payment/kycservice/kyc/response/CPFCheckResp$Data;", "setData", "(Lcom/didi/payment/kycservice/kyc/response/CPFCheckResp$Data;)V", "Data", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CPFCheckResp.kt */
public final class CPFCheckResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/response/CPFCheckResp$Data;", "", "()V", "migrateTipData", "Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "getMigrateTipData", "()Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "setMigrateTipData", "(Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;)V", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CPFCheckResp.kt */
    public static final class Data {
        @SerializedName("migrateDetail")
        private MigrateTipData migrateTipData;

        public final MigrateTipData getMigrateTipData() {
            return this.migrateTipData;
        }

        public final void setMigrateTipData(MigrateTipData migrateTipData2) {
            this.migrateTipData = migrateTipData2;
        }
    }
}
