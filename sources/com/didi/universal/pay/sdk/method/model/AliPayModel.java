package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AliPayModel implements Serializable {
    @SerializedName("pay_string")
    public String payString;
}
