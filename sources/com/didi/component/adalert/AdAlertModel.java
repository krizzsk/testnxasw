package com.didi.component.adalert;

import com.didi.sdk.paxadsdk.model.AdModel;
import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdAlertModel extends BaseObject {
    public List<AdModel> list;
    public JSONObject mLogData;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        super.parse(jSONObject);
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ads")) != null) {
                this.mLogData = optJSONObject2.optJSONObject("log_data");
                this.list = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                    if (!(optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("data")) == null)) {
                        AdModel adModel = new AdModel();
                        adModel.parseJSONObject(optJSONObject);
                        this.list.add(adModel);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
