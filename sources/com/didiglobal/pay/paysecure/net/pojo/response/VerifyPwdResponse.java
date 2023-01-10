package com.didiglobal.pay.paysecure.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/net/pojo/response/VerifyPwdResponse;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/BaseData;", "()V", "failDescription", "", "getFailDescription", "()Ljava/lang/String;", "setFailDescription", "(Ljava/lang/String;)V", "token", "getToken", "setToken", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: VerifyPwdResponse.kt */
public final class VerifyPwdResponse extends BaseData {
    @SerializedName("fail_description")
    private String failDescription;
    private String token;

    public final String getFailDescription() {
        return this.failDescription;
    }

    public final void setFailDescription(String str) {
        this.failDescription = str;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }
}
