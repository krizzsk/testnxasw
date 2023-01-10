package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BankModel implements Serializable {
    @SerializedName("app_pay_string")
    public String appPayString;
    @SerializedName("pay_string")
    public String payString;
}
