package com.didi.globalsafetoolkit.business.safeCenter.model;

import com.didi.globalsafetoolkit.model.ISfBaseObject;
import com.google.gson.annotations.SerializedName;

public class SfCenterCardModel implements ISfBaseObject {
    @SerializedName("image")
    public String bannerUrl;
    public String btnText;
    @SerializedName("sub_title")
    public String content;
    public String title;
    public int typeLocal = 1;
    @SerializedName("link")
    public String url;
}
