package com.didi.beatles.p101im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMTopOperationBody */
public class IMTopOperationBody implements Serializable {
    @SerializedName("bt_link")
    public String btnLink;
    @SerializedName("bt_txt")
    public String btnText;
    public String icon;
    @SerializedName("tip_txt")
    public String tipText;
}
