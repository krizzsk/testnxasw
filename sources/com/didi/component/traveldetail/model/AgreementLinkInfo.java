package com.didi.component.traveldetail.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import java.io.Serializable;
import org.json.JSONObject;

public class AgreementLinkInfo implements Serializable {
    public String icon;
    public String link;
    public LEGORichInfo title;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.has("icon")) {
                this.icon = jSONObject.optString("icon");
            }
            if (jSONObject.has("link")) {
                this.link = jSONObject.optString("link");
            }
            if (jSONObject.has("title")) {
                LEGORichInfo lEGORichInfo = new LEGORichInfo();
                this.title = lEGORichInfo;
                lEGORichInfo.setInfo(jSONObject.optString("title"));
            }
        }
    }
}
