package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VerifyBankAccountParam extends BaseParam implements Serializable {
    @SerializedName("data_len")
    public int dataLen;
    @SerializedName("mfa_version")
    public int mfaVersion;
    @SerializedName("uid")
    public long uid;
    @SerializedName("verify_data")
    public String verifyData;
    @SerializedName("verify_session_id")
    public String verifySessionId;

    public VerifyBankAccountParam(Context context, int i) {
        super(context, i);
    }

    public String getVerifySessionId() {
        return this.verifySessionId;
    }

    public VerifyBankAccountParam setVerifySessionId(String str) {
        this.verifySessionId = str;
        return this;
    }

    public long getUid() {
        return this.uid;
    }

    public VerifyBankAccountParam setUid(long j) {
        this.uid = j;
        return this;
    }

    public int getDataLen() {
        return this.dataLen;
    }

    public VerifyBankAccountParam setDataLen(int i) {
        this.dataLen = i;
        return this;
    }

    public String getVerifyData() {
        return this.verifyData;
    }

    public VerifyBankAccountParam setVerifyData(String str) {
        this.verifyData = str;
        return this;
    }

    public VerifyBankAccountParam setMfaVersion(int i) {
        this.mfaVersion = i;
        return this;
    }
}
