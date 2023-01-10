package com.didi.globalsafetoolkit.business.safeCenter.response;

import com.didi.globalsafetoolkit.business.safeCenter.model.SfCenterCardModel;
import com.didi.globalsafetoolkit.model.ISfBaseObject;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SfSafetyCenterResponse extends SfBaseObject {
    public SfSafetyCenterData data;

    public static class SfSafetyCenterData implements ISfBaseObject {
        @SerializedName("safety_content")
        public List<SfCenterCardModel> safetyContent;
        @SerializedName("show_add")
        public int showAdd;
    }
}
