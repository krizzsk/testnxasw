package com.didi.map.setting.common.conf;

import com.didi.map.setting.common.apollo.NavConfApollo;
import com.didi.map.setting.common.apollo.NavShowListApollo;
import java.util.List;

public class DefaultConfProvider {

    /* renamed from: a */
    private static INavSettingConf f31395a;

    /* renamed from: b */
    private static List<String> f31396b;

    /* renamed from: c */
    private static NavShowListApollo f31397c;

    public static INavSettingConf getConfig() {
        if (f31395a == null) {
            NavConfApollo navConfApollo = new NavConfApollo();
            navConfApollo.init();
            f31395a = navConfApollo;
        }
        return f31395a;
    }

    public static NavShowListApollo getNavShowListApollo() {
        if (f31397c == null) {
            NavShowListApollo navShowListApollo = new NavShowListApollo();
            f31397c = navShowListApollo;
            navShowListApollo.init();
        }
        return f31397c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0094, code lost:
        if (r0.equals("MX") != false) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> getShowTypeList(android.content.Context r13) {
        /*
            java.util.List<java.lang.String> r0 = f31396b
            if (r0 != 0) goto L_0x01bd
            com.didi.map.setting.common.apollo.NavShowListApollo r0 = getNavShowListApollo()
            boolean r1 = r0.allow()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            if (r1 == 0) goto L_0x003f
            java.lang.String r0 = r0.getNavFilter()
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x003e }
            r4.<init>(r0)     // Catch:{ all -> 0x003e }
            int r0 = r4.length()     // Catch:{ all -> 0x003e }
            r5 = 0
        L_0x0022:
            if (r5 >= r0) goto L_0x003f
            org.json.JSONObject r6 = r4.optJSONObject(r5)     // Catch:{ all -> 0x003e }
            java.lang.String r7 = "navi_type"
            java.lang.String r6 = r6.optString(r7)     // Catch:{ all -> 0x003e }
            java.lang.String r6 = getNavPkgNameByType(r6)     // Catch:{ all -> 0x003e }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x003e }
            if (r7 != 0) goto L_0x003b
            r2.add(r6)     // Catch:{ all -> 0x003e }
        L_0x003b:
            int r5 = r5 + 1
            goto L_0x0022
        L_0x003e:
        L_0x003f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            f31396b = r0
            java.lang.String r4 = "local_google"
            if (r1 == 0) goto L_0x0056
            boolean r0 = r2.contains(r4)
            if (r0 == 0) goto L_0x0059
            java.util.List<java.lang.String> r0 = f31396b
            r0.add(r4)
            goto L_0x0059
        L_0x0056:
            r0.add(r4)
        L_0x0059:
            com.didi.map.sdk.maprouter.global.PlatInfo r0 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()
            java.lang.String r0 = r0.getCountryCode()
            r5 = -1
            int r6 = r0.hashCode()
            r7 = 2100(0x834, float:2.943E-42)
            r8 = 5
            r9 = 4
            r10 = 3
            r11 = 2
            r12 = 1
            if (r6 == r7) goto L_0x00b5
            r7 = 2128(0x850, float:2.982E-42)
            if (r6 == r7) goto L_0x00ab
            r7 = 2374(0x946, float:3.327E-42)
            if (r6 == r7) goto L_0x00a1
            r7 = 2415(0x96f, float:3.384E-42)
            if (r6 == r7) goto L_0x0097
            r7 = 2475(0x9ab, float:3.468E-42)
            if (r6 == r7) goto L_0x008e
            r3 = 2627(0xa43, float:3.681E-42)
            if (r6 == r3) goto L_0x0084
            goto L_0x00bf
        L_0x0084:
            java.lang.String r3 = "RU"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00bf
            r3 = 4
            goto L_0x00c0
        L_0x008e:
            java.lang.String r6 = "MX"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00bf
            goto L_0x00c0
        L_0x0097:
            java.lang.String r3 = "KZ"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00bf
            r3 = 5
            goto L_0x00c0
        L_0x00a1:
            java.lang.String r3 = "JP"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00bf
            r3 = 3
            goto L_0x00c0
        L_0x00ab:
            java.lang.String r3 = "BR"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00bf
            r3 = 2
            goto L_0x00c0
        L_0x00b5:
            java.lang.String r3 = "AU"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00bf
            r3 = 1
            goto L_0x00c0
        L_0x00bf:
            r3 = -1
        L_0x00c0:
            java.lang.String r0 = "com.waze"
            java.lang.String r5 = "com.google.android.apps.maps"
            if (r3 == 0) goto L_0x0179
            if (r3 == r12) goto L_0x0179
            if (r3 == r11) goto L_0x0179
            if (r3 == r10) goto L_0x0151
            if (r3 == r9) goto L_0x00d1
            if (r3 == r8) goto L_0x00d1
            goto L_0x012d
        L_0x00d1:
            java.lang.String r3 = "ru.dublgis.dgismobile"
            java.lang.String r6 = "ru.yandex.yandexmaps"
            java.lang.String r7 = "ru.yandex.yandexnavi"
            if (r1 == 0) goto L_0x0114
            boolean r8 = r2.contains(r7)
            if (r8 == 0) goto L_0x00e7
            java.util.List<java.lang.String> r8 = f31396b
            r8.add(r7)
        L_0x00e7:
            boolean r7 = r2.contains(r6)
            if (r7 == 0) goto L_0x00f2
            java.util.List<java.lang.String> r7 = f31396b
            r7.add(r6)
        L_0x00f2:
            boolean r6 = r2.contains(r3)
            if (r6 == 0) goto L_0x00fd
            java.util.List<java.lang.String> r6 = f31396b
            r6.add(r3)
        L_0x00fd:
            boolean r3 = r2.contains(r0)
            if (r3 == 0) goto L_0x0108
            java.util.List<java.lang.String> r3 = f31396b
            r3.add(r0)
        L_0x0108:
            boolean r3 = r2.contains(r5)
            if (r3 == 0) goto L_0x012d
            java.util.List<java.lang.String> r3 = f31396b
            r3.add(r5)
            goto L_0x012d
        L_0x0114:
            java.util.List<java.lang.String> r8 = f31396b
            r8.add(r7)
            java.util.List<java.lang.String> r7 = f31396b
            r7.add(r6)
            java.util.List<java.lang.String> r6 = f31396b
            r6.add(r3)
            java.util.List<java.lang.String> r3 = f31396b
            r3.add(r0)
            java.util.List<java.lang.String> r3 = f31396b
            r3.add(r5)
        L_0x012d:
            if (r1 == 0) goto L_0x0146
            boolean r1 = r2.contains(r5)
            if (r1 == 0) goto L_0x013a
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r5)
        L_0x013a:
            boolean r1 = r2.contains(r0)
            if (r1 == 0) goto L_0x019c
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r0)
            goto L_0x019c
        L_0x0146:
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r5)
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r0)
            goto L_0x019c
        L_0x0151:
            java.lang.String r0 = "com.navitime.local.carnavitime"
            java.lang.String r3 = "jp.co.yahoo.android.apps.navi"
            if (r1 == 0) goto L_0x016e
            boolean r1 = r2.contains(r3)
            if (r1 == 0) goto L_0x0162
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r3)
        L_0x0162:
            boolean r1 = r2.contains(r0)
            if (r1 == 0) goto L_0x019c
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r0)
            goto L_0x019c
        L_0x016e:
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r3)
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r0)
            goto L_0x019c
        L_0x0179:
            if (r1 == 0) goto L_0x0192
            boolean r1 = r2.contains(r5)
            if (r1 == 0) goto L_0x0186
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r5)
        L_0x0186:
            boolean r1 = r2.contains(r0)
            if (r1 == 0) goto L_0x019c
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r0)
            goto L_0x019c
        L_0x0192:
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r5)
            java.util.List<java.lang.String> r1 = f31396b
            r1.add(r0)
        L_0x019c:
            java.util.List<java.lang.String> r0 = f31396b
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L_0x01bd
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade$Companion r0 = com.ddmap.sdk.degrade.gnav.GoogleNavDegrade.Companion
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade r0 = r0.getInstance()
            com.didi.map.sdk.maprouter.global.PlatInfo r1 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()
            java.lang.String r1 = r1.getClientVersion()
            boolean r13 = r0.needDegrade(r13, r1)
            if (r13 == 0) goto L_0x01bd
            java.util.List<java.lang.String> r13 = f31396b
            r13.remove(r4)
        L_0x01bd:
            java.util.List<java.lang.String> r13 = f31396b
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.setting.common.conf.DefaultConfProvider.getShowTypeList(android.content.Context):java.util.List");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getNavPkgNameByType(java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case 48: goto L_0x003f;
                case 49: goto L_0x0035;
                case 50: goto L_0x002b;
                case 51: goto L_0x0021;
                case 52: goto L_0x0017;
                case 53: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0049
        L_0x000d:
            java.lang.String r0 = "5"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 5
            goto L_0x004a
        L_0x0017:
            java.lang.String r0 = "4"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 4
            goto L_0x004a
        L_0x0021:
            java.lang.String r0 = "3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 3
            goto L_0x004a
        L_0x002b:
            java.lang.String r0 = "2"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 2
            goto L_0x004a
        L_0x0035:
            java.lang.String r0 = "1"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x003f:
            java.lang.String r0 = "0"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 0
            goto L_0x004a
        L_0x0049:
            r6 = -1
        L_0x004a:
            if (r6 == 0) goto L_0x006b
            if (r6 == r5) goto L_0x0068
            if (r6 == r4) goto L_0x0065
            if (r6 == r3) goto L_0x0061
            if (r6 == r2) goto L_0x005d
            if (r6 == r1) goto L_0x0059
            java.lang.String r6 = ""
            return r6
        L_0x0059:
            java.lang.String r6 = "ru.dublgis.dgismobile"
            return r6
        L_0x005d:
            java.lang.String r6 = "ru.yandex.yandexnavi"
            return r6
        L_0x0061:
            java.lang.String r6 = "ru.yandex.yandexmaps"
            return r6
        L_0x0065:
            java.lang.String r6 = "com.waze"
            return r6
        L_0x0068:
            java.lang.String r6 = "com.google.android.apps.maps"
            return r6
        L_0x006b:
            java.lang.String r6 = "local_google"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.setting.common.conf.DefaultConfProvider.getNavPkgNameByType(java.lang.String):java.lang.String");
    }
}
