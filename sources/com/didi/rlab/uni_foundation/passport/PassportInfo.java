package com.didi.rlab.uni_foundation.passport;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class PassportInfo extends UniModel {

    /* renamed from: a */
    private String f36857a;

    /* renamed from: b */
    private String f36858b;

    /* renamed from: c */
    private String f36859c;

    /* renamed from: d */
    private String f36860d;

    /* renamed from: e */
    private long f36861e;

    /* renamed from: f */
    private Map<String, String> f36862f;

    public String getPhone() {
        return this.f36857a;
    }

    public void setPhone(String str) {
        this.f36857a = str;
    }

    public String getEmail() {
        return this.f36858b;
    }

    public void setEmail(String str) {
        this.f36858b = str;
    }

    public String getToken() {
        return this.f36859c;
    }

    public void setToken(String str) {
        this.f36859c = str;
    }

    public String getUid() {
        return this.f36860d;
    }

    public void setUid(String str) {
        this.f36860d = str;
    }

    public long getRole() {
        return this.f36861e;
    }

    public void setRole(long j) {
        this.f36861e = j;
    }

    public Map<String, String> getExtent() {
        return this.f36862f;
    }

    public void setExtent(Map<String, String> map) {
        this.f36862f = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("phone", this.f36857a);
        hashMap.put("email", this.f36858b);
        hashMap.put("token", this.f36859c);
        hashMap.put("uid", this.f36860d);
        hashMap.put("role", Long.valueOf(this.f36861e));
        hashMap.put("extent", this.f36862f);
        return hashMap;
    }

    public static PassportInfo fromMap(Map<String, Object> map) {
        PassportInfo passportInfo = new PassportInfo();
        String str = "";
        passportInfo.f36857a = (!map.containsKey("phone") || map.get("phone") == null) ? str : (String) map.get("phone");
        passportInfo.f36858b = (!map.containsKey("email") || map.get("email") == null) ? str : (String) map.get("email");
        passportInfo.f36859c = (!map.containsKey("token") || map.get("token") == null) ? str : (String) map.get("token");
        if (map.containsKey("uid") && map.get("uid") != null) {
            str = (String) map.get("uid");
        }
        passportInfo.f36860d = str;
        passportInfo.f36861e = (!map.containsKey("role") || map.get("role") == null) ? 0 : ((Number) map.get("role")).longValue();
        passportInfo.f36862f = (!map.containsKey("extent") || map.get("extent") == null) ? new HashMap<>() : (Map) map.get("extent");
        return passportInfo;
    }
}
