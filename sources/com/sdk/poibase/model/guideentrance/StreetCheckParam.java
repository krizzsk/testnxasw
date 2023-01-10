package com.sdk.poibase.model.guideentrance;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.env.PaxEnvironment;
import com.sdk.poibase.model.HttpParamBase;
import com.sdk.poibase.util.UrlParseUtils;
import java.util.HashMap;

public class StreetCheckParam extends HttpParamBase {

    /* renamed from: a */
    private String f58763a;

    /* renamed from: b */
    private String f58764b;

    public HashMap<String, Object> getParamMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap<String, String> urlParams = UrlParseUtils.getUrlParams(this.f58764b);
        if (urlParams != null) {
            hashMap.put("size", urlParams.get("size"));
            hashMap.put("location", urlParams.get("location"));
            hashMap.put("heading", urlParams.get("heading"));
        }
        hashMap.put("tirpid", TextUtils.isEmpty(this.f58763a) ? "" : this.f58763a);
        hashMap.put("passenger_id", PaxEnvironment.getInstance().getUid());
        hashMap.put("product_id", PaxEnvironment.getInstance().getProductId());
        hashMap.put("countrycode", PaxEnvironment.getInstance().getCountryCode());
        DLog.m10773d("StreetCheckParam", hashMap.toString(), new Object[0]);
        return hashMap;
    }

    public void setTirpid(String str) {
        this.f58763a = str;
    }

    public void setStreetViewUrl(String str) {
        this.f58764b = str;
    }
}
