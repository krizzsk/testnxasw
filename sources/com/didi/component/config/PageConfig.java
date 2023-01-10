package com.didi.component.config;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PageConfig {

    /* renamed from: d */
    static final int f14444d = Integer.MAX_VALUE;

    /* renamed from: e */
    private static List<PageIdConverter> f14445e = null;

    /* renamed from: f */
    private static final String f14446f = "global";

    /* renamed from: g */
    private static final String f14447g = "none";

    /* renamed from: h */
    private static final String f14448h = "home";

    /* renamed from: i */
    private static final String f14449i = "wait";

    /* renamed from: j */
    private static final String f14450j = "inservice";

    /* renamed from: k */
    private static final String f14451k = "endservice";

    /* renamed from: l */
    private static final String f14452l = "cancel";

    /* renamed from: m */
    private static final String f14453m = "confirm";

    /* renamed from: n */
    private static final String f14454n = "bookingresult";

    /* renamed from: o */
    private static final String f14455o = "updatepickup";

    /* renamed from: p */
    private static final String f14456p = "trip";

    /* renamed from: q */
    private static final String f14457q = "lockscreen";

    /* renamed from: a */
    int f14458a;

    /* renamed from: b */
    String f14459b;

    /* renamed from: c */
    final Map<String, ComponentConfig> f14460c = new LinkedHashMap();

    public interface PageIdConverter {
        int pageNameToId(String str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo52833a() {
        return this.f14458a > 0 && !TextUtils.isEmpty(this.f14459b) && this.f14460c.size() > 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("pageId:");
        sb.append(this.f14458a);
        sb.append(", ");
        sb.append("pageName:");
        sb.append(this.f14459b);
        for (Map.Entry<String, ComponentConfig> value : this.f14460c.entrySet()) {
            sb.append("\n");
            sb.append(value.getValue());
        }
        sb.append("\n}");
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r0 <= 0) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026 A[LOOP:0: B:12:0x0026->B:15:0x0036, LOOP_START, PHI: r0 
      PHI: (r0v7 int) = (r0v2 int), (r0v11 int) binds: [B:11:0x0020, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.didi.component.config.PageConfig m11978a(java.lang.String r5, org.json.JSONArray r6) throws org.json.JSONException {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L_0x006e
            if (r6 == 0) goto L_0x006e
            int r0 = r6.length()
            if (r0 != 0) goto L_0x0010
            goto L_0x006e
        L_0x0010:
            int r0 = m11977a(r5)
            if (r0 > 0) goto L_0x003b
            java.util.List<com.didi.component.config.PageConfig$PageIdConverter> r2 = f14445e
            if (r2 == 0) goto L_0x003a
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x003a
            java.util.List<com.didi.component.config.PageConfig$PageIdConverter> r2 = f14445e
            java.util.Iterator r2 = r2.iterator()
        L_0x0026:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0038
            java.lang.Object r0 = r2.next()
            com.didi.component.config.PageConfig$PageIdConverter r0 = (com.didi.component.config.PageConfig.PageIdConverter) r0
            int r0 = r0.pageNameToId(r5)
            if (r0 <= 0) goto L_0x0026
        L_0x0038:
            if (r0 > 0) goto L_0x003b
        L_0x003a:
            return r1
        L_0x003b:
            com.didi.component.config.PageConfig r2 = new com.didi.component.config.PageConfig
            r2.<init>()
            r2.f14458a = r0
            r2.f14459b = r5
            r5 = 0
        L_0x0045:
            int r0 = r6.length()
            if (r5 >= r0) goto L_0x0067
            org.json.JSONObject r0 = r6.getJSONObject(r5)
            com.didi.component.config.ComponentConfig r0 = com.didi.component.config.ComponentConfig.m11957a(r0)
            if (r0 == 0) goto L_0x0064
            boolean r3 = r0.valid()
            if (r3 == 0) goto L_0x0064
            java.util.Map<java.lang.String, com.didi.component.config.ComponentConfig> r3 = r2.f14460c
            java.lang.String r4 = r0.type()
            r3.put(r4, r0)
        L_0x0064:
            int r5 = r5 + 1
            goto L_0x0045
        L_0x0067:
            boolean r5 = r2.mo52833a()
            if (r5 == 0) goto L_0x006e
            r1 = r2
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.config.PageConfig.m11978a(java.lang.String, org.json.JSONArray):com.didi.component.config.PageConfig");
    }

    /* renamed from: a */
    private static int m11977a(String str) {
        if (TextUtils.equals(str, "global")) {
            return Integer.MAX_VALUE;
        }
        if (TextUtils.equals(str, "none")) {
            return 900;
        }
        if (TextUtils.equals(str, "home")) {
            return 1001;
        }
        if (TextUtils.equals(str, "wait")) {
            return 1005;
        }
        if (TextUtils.equals(str, f14450j)) {
            return 1010;
        }
        if (TextUtils.equals(str, f14451k)) {
            return 1015;
        }
        if (TextUtils.equals(str, "cancel")) {
            return 1020;
        }
        if (TextUtils.equals(str, "confirm")) {
            return 1030;
        }
        if (TextUtils.equals(str, f14454n)) {
            return 1025;
        }
        if (TextUtils.equals(str, f14455o)) {
            return 1035;
        }
        if (TextUtils.equals(str, "trip")) {
            return 1040;
        }
        return TextUtils.equals(str, f14457q) ? 1045 : -1;
    }

    public static void addExtraPageIdList(PageIdConverter pageIdConverter) {
        if (f14445e == null) {
            f14445e = new ArrayList();
        }
        f14445e.add(pageIdConverter);
    }
}
