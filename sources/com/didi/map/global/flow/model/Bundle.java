package com.didi.map.global.flow.model;

import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;

public class Bundle {

    /* renamed from: b */
    private static final String f28792b = "Bundle";

    /* renamed from: a */
    Map<String, Object> f28793a;

    public Bundle() {
        this.f28793a = null;
        this.f28793a = new HashMap();
    }

    public void put(String str, Object obj) {
        this.f28793a.put(str, obj);
    }

    public <T> T get(String str) {
        T t = this.f28793a.get(str);
        if (t == null) {
            return null;
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo80334a(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        String str3 = str;
        sb.append(str);
        sb.append(" expected ");
        sb.append(str2);
        sb.append(" but value was a ");
        sb.append(obj.getClass().getName());
        sb.append(".  The default value ");
        sb.append(obj2);
        sb.append(" was returned.");
        SystemUtils.log(5, f28792b, sb.toString(), (Throwable) null, "com.didi.map.global.flow.model.Bundle", 52);
        SystemUtils.log(5, f28792b, "Attempt to cast generated internal exception:", classCastException, "com.didi.map.global.flow.model.Bundle", 53);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo80333a(String str, Object obj, String str2, ClassCastException classCastException) {
        mo80334a(str, obj, str2, "<null>", classCastException);
    }

    public void putInt(String str, int i) {
        this.f28793a.put(str, Integer.valueOf(i));
    }

    public int getInt(String str, int i) {
        Object obj = this.f28793a.get(str);
        if (obj == null) {
            return i;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e) {
            String str2 = str;
            mo80334a(str2, obj, "Short", Integer.valueOf(i), e);
            return i;
        }
    }

    public void putString(String str, String str2) {
        this.f28793a.put(str, str2);
    }

    public String getString(String str, String str2) {
        Object obj = this.f28793a.get(str);
        if (obj == null) {
            return str2;
        }
        try {
            return (String) obj;
        } catch (ClassCastException e) {
            mo80334a(str, obj, "String", str2, e);
            return str2;
        }
    }
}
