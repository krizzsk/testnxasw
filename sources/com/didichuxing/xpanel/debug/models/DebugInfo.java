package com.didichuxing.xpanel.debug.models;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.xpanel.util.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class DebugInfo {

    /* renamed from: a */
    private String f52047a;

    /* renamed from: b */
    private String f52048b;

    /* renamed from: c */
    private String f52049c;

    /* renamed from: d */
    private String f52050d;

    /* renamed from: e */
    private HashMap<String, Object> f52051e;

    /* renamed from: f */
    private List<String> f52052f = new ArrayList();

    public DebugInfo(String str, HashMap<String, Object> hashMap, String str2) {
        this.f52051e = hashMap;
        StringBuilder sb = new StringBuilder();
        this.f52048b = Utils.formatDate(new Date());
        try {
            if (TextUtils.isEmpty(str)) {
                this.f52050d = "error";
            } else {
                this.f52050d = new JSONObject(str).toString(2);
            }
            this.f52049c = (String) hashMap.get("dimensions");
            for (Map.Entry next : hashMap.entrySet()) {
                String str3 = (String) next.getKey();
                this.f52052f.add(str3);
                sb.append(str3);
                sb.append("=");
                sb.append(next.getValue());
                sb.append(ParamKeys.SIGN_AND);
            }
            String sb2 = sb.toString();
            this.f52047a = str2 + "?" + sb2.substring(0, sb2.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDimension() {
        return this.f52049c;
    }

    public List<String> getKeyList() {
        return this.f52052f;
    }

    public String getResult() {
        return this.f52050d;
    }

    public HashMap<String, Object> getParams() {
        HashMap<String, Object> hashMap = this.f52051e;
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    public String getRequestUrl() {
        return this.f52047a;
    }

    public String getRequestTime() {
        return this.f52048b;
    }
}
