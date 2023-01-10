package com.didi.globalsafetoolkit.business.emergency.model;

import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.google.gson.annotations.SerializedName;

public class SfEmgStatus extends SfBaseObject {
    @SerializedName("data")
    public Data data;

    public static class Data {
        @SerializedName("is_report_police")
        public int isOnEmergencyCallStatus;
    }
}
