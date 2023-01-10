package com.didi.globalsafetoolkit.business.bubble.model;

import com.android.didi.bfflib.business.BffBaseObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class SfPanelData extends BffBaseObject {
    public JsonArray banner;
    @SerializedName("data_version")
    public String dataVer;
    public JsonArray menus;
    public JsonObject setting;
    public JsonObject timeline;
}