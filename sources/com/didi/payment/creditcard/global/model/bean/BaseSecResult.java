package com.didi.payment.creditcard.global.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BaseSecResult implements Serializable {
    @SerializedName("apiMsg")
    public String errMsg;
    @SerializedName("apiCode")
    public int errNo;
}
