package com.didichuxing.apollo.sdk.net;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestParams {

    /* renamed from: a */
    private Map<String, Object> f48299a = new ConcurrentHashMap();

    public void addParam(String str, String str2) {
        this.f48299a.put(str, str2);
    }

    public Map<String, Object> getParams() {
        return this.f48299a;
    }
}
