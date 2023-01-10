package com.didi.payment.creditcard.global.model.bean;

import com.google.gson.annotations.SerializedName;

public class SignCancelResult extends BaseResult {
    public static final int ERROR_CODE_UNPAYORDER = 10602;
    @SerializedName("dialogContent")
    public String dialogContent;
    @SerializedName("dialogFaqTip")
    public String dialogFaqTip;
    @SerializedName("dialogFaqUrl")
    public String dialogFaqUrl;
    @SerializedName("encodeOid")
    public String encodeOid;
    @SerializedName("hint_msg")
    public String hingMsg;
    @SerializedName("outTradeId")
    public String outTradeId;
    @SerializedName("productId")
    public String productId;
}
