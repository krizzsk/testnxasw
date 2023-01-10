package com.didi.globalsafetoolkit.business.contacts.model;

import com.didi.globalsafetoolkit.business.areaCode.model.SFAreaCodeModel;
import com.didi.globalsafetoolkit.model.ISfBaseObject;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.didi.globalsafetoolkit.model.SfContactsModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class SfContactsManageModel extends SfBaseObject {
    @SerializedName("data")
    public SfContactsDatas datas;

    public static class SfContactsDatas implements ISfBaseObject, Serializable {
        @SerializedName("contact_list")
        public List<SfContactsModel> contacts;
        @SerializedName("default_areacode")
        public SFAreaCodeModel defaultAreaCode;
        @SerializedName("need_areacode_list")
        public List<SfContactsModel> needAreaCodeContacts;
    }
}
