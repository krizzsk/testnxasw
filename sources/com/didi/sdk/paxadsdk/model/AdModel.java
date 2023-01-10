package com.didi.sdk.paxadsdk.model;

import com.didi.sdk.paxadsdk.utils.AdLogger;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class AdModel implements Serializable {
    private String adid;
    private String agency;

    public String getAgency() {
        return this.agency;
    }

    public void setAgency(String str) {
        this.agency = str;
    }

    public String getAdid() {
        return this.adid;
    }

    public void setAdid(String str) {
        this.adid = str;
    }

    public void parseJSONObject(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.adid = jSONObject.optString(Constants.JSON_KEY_ANDID);
            this.agency = jSONObject.optString("agency");
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.JSON_KEY_ANDID, this.adid);
            jSONObject.put("agency", this.agency);
        } catch (JSONException e) {
            AdLogger.m29885e("admodel parse error", e);
            e.printStackTrace();
        }
        return jSONObject;
    }
}
