package com.didi.rlab.uni_foundation.passport;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class LoginResult extends UniModel {

    /* renamed from: a */
    private long f36855a;

    /* renamed from: b */
    private long f36856b;

    public long getEvent() {
        return this.f36855a;
    }

    public void setEvent(long j) {
        this.f36855a = j;
    }

    public long getEventType() {
        return this.f36856b;
    }

    public void setEventType(long j) {
        this.f36856b = j;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", Long.valueOf(this.f36855a));
        hashMap.put("eventType", Long.valueOf(this.f36856b));
        return hashMap;
    }

    public static LoginResult fromMap(Map<String, Object> map) {
        LoginResult loginResult = new LoginResult();
        long j = 0;
        loginResult.f36855a = (!map.containsKey("event") || map.get("event") == null) ? 0 : ((Number) map.get("event")).longValue();
        if (map.containsKey("eventType") && map.get("eventType") != null) {
            j = ((Number) map.get("eventType")).longValue();
        }
        loginResult.f36856b = j;
        return loginResult;
    }
}
