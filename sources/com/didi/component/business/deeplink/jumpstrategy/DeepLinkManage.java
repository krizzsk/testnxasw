package com.didi.component.business.deeplink.jumpstrategy;

import android.util.ArrayMap;
import java.util.Map;

public class DeepLinkManage {
    public static final String PATH_CHANGE_PASSWORD = "/modifypassword";
    public static final String PATH_MANAGER_CONTACTS = "/managerContacts";
    public static final String PATH_SAFE_CENTER = "/safeceter";
    public static final String PATH_SAHRE_BY_SMS = "/shareBySMS";
    public static final String PATH_SELF_CENTER = "/editprofile";
    public static final String PATH_SOS = "/sos";

    /* renamed from: a */
    private static final String f13135a = "one";

    /* renamed from: b */
    private Map<String, INewActivityDeepLink> f13136b;

    public DeepLinkManage() {
        ArrayMap arrayMap = new ArrayMap();
        this.f13136b = arrayMap;
        arrayMap.put(PATH_SOS, new C5183f());
        this.f13136b.put(PATH_SAFE_CENTER, new C5180c());
        this.f13136b.put(PATH_SAHRE_BY_SMS, new C5182e());
        this.f13136b.put(PATH_MANAGER_CONTACTS, new C5178a());
        this.f13136b.put(PATH_SELF_CENTER, new C5181d());
        this.f13136b.put(PATH_CHANGE_PASSWORD, new C5179b());
    }

    public INewActivityDeepLink query(String str) {
        INewActivityDeepLink iNewActivityDeepLink = this.f13136b.get(str);
        return iNewActivityDeepLink != null ? iNewActivityDeepLink : INewActivityDeepLink.DEFAULT;
    }

    public boolean filterHost(String str) {
        return "one".equalsIgnoreCase(str);
    }

    public boolean filterPath(String str) {
        return this.f13136b.containsKey(str);
    }
}
