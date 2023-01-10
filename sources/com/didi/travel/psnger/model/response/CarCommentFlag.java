package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarCommentFlag extends BaseObject {
    public static String sCarEvaluateTags;
    public static int sShowCardEvaluateTag;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("tags")) {
            sShowCardEvaluateTag = jSONObject.optInt("bShowCards");
            sCarEvaluateTags = jSONObject.toString();
        }
    }
}
