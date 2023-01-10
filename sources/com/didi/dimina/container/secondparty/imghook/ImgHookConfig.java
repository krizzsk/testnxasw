package com.didi.dimina.container.secondparty.imghook;

import java.util.HashSet;

public class ImgHookConfig {

    /* renamed from: g */
    private static final boolean f19055g = true;

    /* renamed from: k */
    private static final String f19056k = "dimina_saga_big_img_report_config";

    /* renamed from: l */
    private static volatile ImgHookConfig f19057l;

    /* renamed from: a */
    String f19058a = "307_200";

    /* renamed from: b */
    String f19059b = "307_200";

    /* renamed from: c */
    String f19060c = "4G_5G_WIFI";

    /* renamed from: d */
    String f19061d = "^x-cache.+$";

    /* renamed from: e */
    int f19062e = 10;

    /* renamed from: f */
    int f19063f = 1;

    /* renamed from: h */
    private long f19064h = -1;

    /* renamed from: i */
    private long f19065i = -1;

    /* renamed from: j */
    private HashSet<Integer> f19066j = null;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo60644a() {
        long j = this.f19064h;
        if (j != -1) {
            return j;
        }
        try {
            long parseLong = Long.parseLong(this.f19058a.replace("_", ""));
            this.f19064h = parseLong;
            return parseLong;
        } catch (Throwable unused) {
            this.f19064h = 307200;
            return 307200;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo60645b() {
        long j = this.f19065i;
        if (j != -1) {
            return j;
        }
        try {
            long parseLong = Long.parseLong(this.f19059b.replace("_", ""));
            this.f19065i = parseLong;
            return parseLong;
        } catch (Throwable unused) {
            this.f19065i = 307200;
            return 307200;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public HashSet<Integer> mo60646c() {
        HashSet<Integer> hashSet = this.f19066j;
        if (hashSet != null) {
            return hashSet;
        }
        try {
            String[] split = this.f19060c.split("_");
            this.f19066j = new HashSet<>();
            for (String str : split) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -2015525726) {
                    if (hashCode != 1621) {
                        if (hashCode != 1652) {
                            if (hashCode != 1683) {
                                if (hashCode != 1714) {
                                    if (hashCode == 2664213) {
                                        if (str.equals("WIFI")) {
                                            c = 4;
                                        }
                                    }
                                } else if (str.equals("5G")) {
                                    c = 3;
                                }
                            } else if (str.equals("4G")) {
                                c = 2;
                            }
                        } else if (str.equals("3G")) {
                            c = 1;
                        }
                    } else if (str.equals("2G")) {
                        c = 0;
                    }
                } else if (str.equals("MOBILE")) {
                    c = 5;
                }
                if (c == 0) {
                    this.f19066j.add(2);
                } else if (c == 1) {
                    this.f19066j.add(3);
                } else if (c == 2) {
                    this.f19066j.add(5);
                } else if (c == 3) {
                    this.f19066j.add(6);
                } else if (c == 4) {
                    this.f19066j.add(1);
                } else if (c == 5) {
                    this.f19066j.add(4);
                }
            }
            return this.f19066j;
        } catch (Throwable unused) {
            HashSet<Integer> hashSet2 = new HashSet<>();
            this.f19066j = hashSet2;
            hashSet2.add(5);
            this.f19066j.add(6);
            this.f19066j.add(1);
            return this.f19066j;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0098, code lost:
        return f19057l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.dimina.container.secondparty.imghook.ImgHookConfig getConfig() {
        /*
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r0 = f19057l
            if (r0 == 0) goto L_0x0007
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r0 = f19057l
            return r0
        L_0x0007:
            java.lang.Class<com.didi.dimina.container.secondparty.imghook.ImgLoadHooker> r0 = com.didi.dimina.container.secondparty.imghook.ImgLoadHooker.class
            monitor-enter(r0)
            com.didi.dimina.container.Dimina$Config r1 = com.didi.dimina.container.Dimina.getConfig()     // Catch:{ all -> 0x0099 }
            boolean r1 = r1.isDebug()     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x001f
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r1 = new com.didi.dimina.container.secondparty.imghook.ImgHookConfig     // Catch:{ all -> 0x0099 }
            r1.<init>()     // Catch:{ all -> 0x0099 }
            f19057l = r1     // Catch:{ all -> 0x0099 }
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r1 = f19057l     // Catch:{ all -> 0x0099 }
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return r1
        L_0x001f:
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r1 = f19057l     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = "dimina_saga_big_img_report_config"
            com.didichuxing.apollo.sdk.IToggle r1 = com.didichuxing.apollo.sdk.Apollo.getToggle(r1)     // Catch:{ all -> 0x0099 }
            boolean r2 = r1.allow()     // Catch:{ all -> 0x0099 }
            if (r2 != 0) goto L_0x0032
            r1 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return r1
        L_0x0032:
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r2 = new com.didi.dimina.container.secondparty.imghook.ImgHookConfig     // Catch:{ all -> 0x0099 }
            r2.<init>()     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "resolution"
            java.lang.String r5 = r2.f19058a     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r3.getStringParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f19058a = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "byte_count"
            java.lang.String r5 = r2.f19059b     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r3.getStringParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f19059b = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "net_types"
            java.lang.String r5 = r2.f19060c     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r3.getStringParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f19060c = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "cdn_regx"
            java.lang.String r5 = r2.f19061d     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r3.getStringParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f19061d = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "async_request_count"
            int r5 = r2.f19062e     // Catch:{ all -> 0x0099 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0099 }
            int r3 = r3.getIntParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f19062e = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r1 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = "async_gif"
            int r4 = r2.f19063f     // Catch:{ all -> 0x0099 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0099 }
            int r1 = r1.getIntParam(r3, r4)     // Catch:{ all -> 0x0099 }
            r2.f19063f = r1     // Catch:{ all -> 0x0099 }
            f19057l = r2     // Catch:{ all -> 0x0099 }
        L_0x0095:
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r0 = f19057l
            return r0
        L_0x0099:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.imghook.ImgHookConfig.getConfig():com.didi.dimina.container.secondparty.imghook.ImgHookConfig");
    }

    public static String getConfigStr() {
        if (f19057l == null) {
            return "";
        }
        return "ImgHookConfig{resolution='" + f19057l.f19058a + '\'' + ", byteCount='" + f19057l.f19059b + '\'' + ", netTypes='" + f19057l.f19060c + '\'' + ", cdnRegx='" + f19057l.f19061d + '\'' + ", asyncRequestCount=" + f19057l.f19062e + ", asyncGif=" + f19057l.f19063f + '}';
    }
}
