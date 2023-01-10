package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.TextUtil;
import com.google.gson.annotations.SerializedName;
import org.json.JSONArray;
import org.json.JSONObject;

public class CarPayGroupInfoModel extends BaseObject implements BffGsonStruct {
    @SerializedName("payment_methods")
    public int[] channelIds;
    public AccountFreezeData freezeData;
    @SerializedName("frozen_link")
    public String frozenLink;
    @SerializedName("frozen_title")
    public String frozenTitle;
    @SerializedName("icon")
    public String iconUrl;
    public String name;

    public void buildFrozenData() {
        if (this.freezeData == null) {
            this.freezeData = new AccountFreezeData();
        }
        if (!TextUtil.isEmpty(this.frozenTitle)) {
            this.freezeData.freezeStatus = 3;
            this.freezeData.title = this.frozenTitle;
            this.freezeData.link = this.frozenLink;
        }
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            this.name = jSONObject.optString("name");
            this.iconUrl = jSONObject.optString("icon");
            if (jSONObject.has("payment_methods") && (optJSONArray = jSONObject.optJSONArray("payment_methods")) != null && optJSONArray.length() > 0) {
                this.channelIds = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.channelIds[i] = optJSONArray.optInt(i);
                }
            }
            this.frozenTitle = jSONObject.optString("frozen_title");
            this.frozenLink = jSONObject.optString("frozen_link");
            if (this.freezeData == null) {
                this.freezeData = new AccountFreezeData();
            }
            if (!TextUtil.isEmpty(this.frozenTitle)) {
                this.freezeData.freezeStatus = 3;
                this.freezeData.title = this.frozenTitle;
                this.freezeData.link = this.frozenLink;
            }
        }
    }
}
