package com.didi.globalsafetoolkit.business.safeCenter.model;

import com.android.didi.bfflib.business.BffBaseObject;
import com.didi.globalsafetoolkit.business.bubble.model.SfBubbleData;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GlobalSfBubbleData extends BffBaseObject {
    public List<SfBubbleData> bubbles;
    @SerializedName("data_version")
    public String dataVer;
    public String page;
}
