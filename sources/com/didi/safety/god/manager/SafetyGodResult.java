package com.didi.safety.god.manager;

import java.util.Map;

public class SafetyGodResult {

    /* renamed from: a */
    private int f37375a = 100;

    /* renamed from: b */
    private String f37376b;

    /* renamed from: c */
    private String f37377c;

    /* renamed from: d */
    private Map<String, String> f37378d;

    public void setReturnCode(int i) {
        this.f37375a = i;
    }

    public void setMessage(String str) {
        this.f37376b = str;
    }

    public void setKeeperID(String str) {
        this.f37377c = str;
    }

    public void setJson(Map<String, String> map) {
        this.f37378d = map;
    }

    public String getMessage() {
        return this.f37376b;
    }

    public String getKeeperID() {
        return this.f37377c;
    }

    public Map<String, String> getLastConfig() {
        return this.f37378d;
    }

    public int getCode() {
        return this.f37375a;
    }
}
