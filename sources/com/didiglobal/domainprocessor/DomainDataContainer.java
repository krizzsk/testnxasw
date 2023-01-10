package com.didiglobal.domainprocessor;

import java.util.HashMap;
import java.util.Map;

public class DomainDataContainer {

    /* renamed from: a */
    private Map<String, Object> f52588a = new HashMap();

    private DomainDataContainer() {
    }

    public synchronized void putObj(String str, Object obj) {
        this.f52588a.put(str, obj);
    }

    public synchronized Object getObj(String str) {
        if (!this.f52588a.containsKey(str)) {
            return null;
        }
        return this.f52588a.get(str);
    }

    public synchronized <T> void putData(String str, T t) {
        this.f52588a.put(str, t);
    }

    public synchronized String getStringData(String str) {
        if (this.f52588a.containsKey(str)) {
            Object obj = this.f52588a.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    public synchronized boolean getBooleanData(String str) {
        if (this.f52588a.containsKey(str)) {
            Object obj = this.f52588a.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }
}
