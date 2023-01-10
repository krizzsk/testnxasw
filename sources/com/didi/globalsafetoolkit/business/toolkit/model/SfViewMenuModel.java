package com.didi.globalsafetoolkit.business.toolkit.model;

import com.didi.globalsafetoolkit.model.ISfBaseObject;
import com.didi.soda.customer.blocks.BlocksConst;
import java.io.Serializable;
import org.json.JSONObject;

public class SfViewMenuModel implements ISfBaseObject, Serializable {
    public static final String TYPE_AUDIO_RECORD = "recode_voice";
    public static final String TYPE_REALTIME_MONITOR = "monitor";
    public static final String TYPE_SAFE_CENTER = "safety_center";
    public static final String newIconKey = "sf_toolkit_item_icon_new";
    public String content;
    public int icon;
    public boolean isNew;
    public String time;
    public String title;
    public String type;

    public int getIconResId() {
        return 0;
    }

    public static SfViewMenuModel parseType(JSONObject jSONObject) {
        SfViewMenuModel sfViewMenuModel;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        if ("safety_center".equals(optString)) {
            sfViewMenuModel = new SfViewSafeCenterMenuModel();
        } else if ("recode_voice".equals(optString)) {
            sfViewMenuModel = new SfViewRecordMenuModel();
        } else if ("monitor".equals(optString)) {
            sfViewMenuModel = new SfViewMonitorMenuModel();
        } else {
            sfViewMenuModel = new SfViewMenuModel();
        }
        sfViewMenuModel.parse(jSONObject);
        return sfViewMenuModel;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.content = jSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
            boolean z = true;
            if (jSONObject.optInt("is_new") != 1) {
                z = false;
            }
            this.isNew = z;
            this.type = jSONObject.optString("type");
            this.icon = getIconResId();
        }
    }
}
