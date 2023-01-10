package com.didi.rlab.uni_foundation.apollo.model;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class ApolloModel extends UniModel {

    /* renamed from: a */
    private boolean f36777a;

    /* renamed from: b */
    private Map<String, Object> f36778b;

    public boolean getEnable() {
        return this.f36777a;
    }

    public void setEnable(boolean z) {
        this.f36777a = z;
    }

    public Map<String, Object> getData() {
        return this.f36778b;
    }

    public void setData(Map<String, Object> map) {
        this.f36778b = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("enable", Boolean.valueOf(this.f36777a));
        hashMap.put("data", this.f36778b);
        return hashMap;
    }

    public static ApolloModel fromMap(Map<String, Object> map) {
        ApolloModel apolloModel = new ApolloModel();
        apolloModel.f36777a = (!map.containsKey("enable") || map.get("enable") == null) ? false : ((Boolean) map.get("enable")).booleanValue();
        apolloModel.f36778b = (!map.containsKey("data") || map.get("data") == null) ? new HashMap<>() : (Map) map.get("data");
        return apolloModel;
    }
}
