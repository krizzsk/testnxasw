package com.didiglobal.pay.paysecure.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/net/pojo/response/UserVerificationParams;", "Ljava/io/Serializable;", "()V", "checkType", "", "", "getCheckType", "()[Ljava/lang/String;", "setCheckType", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: GateKeeperResponse.kt */
public final class UserVerificationParams implements Serializable {
    @SerializedName("check_type")
    private String[] checkType;

    public final String[] getCheckType() {
        return this.checkType;
    }

    public final void setCheckType(String[] strArr) {
        this.checkType = strArr;
    }
}
