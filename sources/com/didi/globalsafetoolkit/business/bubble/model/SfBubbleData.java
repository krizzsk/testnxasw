package com.didi.globalsafetoolkit.business.bubble.model;

import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SfBubbleData extends BffBaseObject implements BffGsonStruct {
    @SerializedName("background_color")
    public String bgColor;
    @SerializedName("buttons")
    public List<ButtonModel> btns;
    @SerializedName("bubble_id")
    public String bubbleId;
    @SerializedName("danger_level")
    public String dangerLevel;
    public int show;
    @SerializedName("show_arrow")
    public boolean showArrow;
    public String text;
    @SerializedName("text_color")
    public String textColor;
    public JsonObject track;

    public static class ButtonModel implements BffGsonStruct {
        public String action;
        @SerializedName("background_color")
        public String bgColor;
        public String text;
        @SerializedName("text_color")
        public String textColor;
        public JsonObject track;
    }
}
