package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RiskInfo implements Serializable {
    @SerializedName("risk_message")
    public String riskMessage;
    @SerializedName("risk_status")
    public int riskStatus;
}
