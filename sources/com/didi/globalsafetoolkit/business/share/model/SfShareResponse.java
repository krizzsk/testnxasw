package com.didi.globalsafetoolkit.business.share.model;

import com.didi.globalsafetoolkit.business.areaCode.model.SFAreaCodeModel;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.didi.globalsafetoolkit.model.SfContactsModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class SfShareResponse extends SfBaseObject {
    public SfResponseData data;

    public static class SfResponseData {
        @SerializedName("default_areacode")
        public SFAreaCodeModel defaultAreacode;
        @SerializedName("need_areacode_list")
        public ArrayList<SfContactsModel> needAreaCodeList;
        @SerializedName("share_success_count")
        public int shareSuccessCount;
        @SerializedName("share_title")
        public String shareTitle;
        @SerializedName("share_url")
        public String shareUrl;
        @SerializedName("text")
        public String successText;
    }
}
