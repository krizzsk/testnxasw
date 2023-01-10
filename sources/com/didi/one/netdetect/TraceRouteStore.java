package com.didi.one.netdetect;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import com.didi.one.netdetect.model.DetectionParam;
import com.didi.one.netdetect.model.TraceRouteCacheItem;
import com.didi.one.netdetect.model.TraceRouteReportInfo;
import com.didi.one.netdetect.security.SignGenerator;
import com.didi.one.netdetect.util.IOUtil;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;

class TraceRouteStore {

    /* renamed from: a */
    private static String f31873a = "OND_TraceRouteStore";

    /* renamed from: f */
    private static final String f31874f = "/traceroutes";

    /* renamed from: g */
    private static final int f31875g = 3;

    /* renamed from: h */
    private static final long f31876h = 604800000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f31877b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DetectionParam f31878c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SignGenerator f31879d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public File f31880e;

    private TraceRouteStore() {
    }

    private static class SingletonHolader {
        /* access modifiers changed from: private */
        public static TraceRouteStore INSTANCE = new TraceRouteStore();

        private SingletonHolader() {
        }
    }

    /* renamed from: a */
    public static TraceRouteStore m24322a() {
        return SingletonHolader.INSTANCE;
    }

    /* renamed from: a */
    public void mo86360a(Context context, DetectionParam detectionParam, SignGenerator signGenerator) {
        this.f31877b = context;
        this.f31878c = detectionParam;
        this.f31879d = signGenerator;
        m24329c();
        if (m24331d()) {
            mo86363b();
        }
    }

    /* renamed from: c */
    private void m24329c() {
        this.f31880e = IOUtil.createPath(this.f31877b.getFilesDir().getAbsolutePath() + f31874f);
    }

    /* renamed from: a */
    public void mo86362a(String str, int i, TraceRouteReportInfo traceRouteReportInfo) {
        File file = new File(this.f31880e, "traceroute_" + String.valueOf(System.currentTimeMillis()));
        TraceRouteCacheItem traceRouteCacheItem = new TraceRouteCacheItem();
        traceRouteCacheItem.setHost(str);
        traceRouteCacheItem.setFailCount(i);
        traceRouteCacheItem.setInfo(traceRouteReportInfo);
        mo86361a(file, traceRouteCacheItem);
    }

    /* renamed from: a */
    public void mo86361a(File file, TraceRouteCacheItem traceRouteCacheItem) {
        try {
            IOUtil.save(file, new Gson().toJson((Object) traceRouteCacheItem));
        } catch (IOException e) {
            if (file.exists()) {
                file.delete();
            }
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private boolean m24331d() {
        String str = f31873a;
        SystemUtils.log(3, str, this.f31880e.getAbsolutePath() + " is exist: " + this.f31880e.exists(), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 104);
        try {
            String[] list = this.f31880e.list();
            if (list == null || list.length <= 0) {
                return false;
            }
            return true;
        } catch (OutOfMemoryError e) {
            m24332e();
            String str2 = f31873a;
            SystemUtils.log(6, str2, "OOM occur in checkCachedTraceRoute() => " + e.getLocalizedMessage(), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 112);
            System.gc();
            String[] list2 = this.f31880e.list();
            String str3 = f31873a;
            StringBuilder sb = new StringBuilder();
            sb.append("fileCount: ");
            sb.append(list2 == null ? "null" : Integer.valueOf(list2.length));
            SystemUtils.log(3, str3, sb.toString(), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 117);
            return false;
        }
    }

    /* renamed from: e */
    private void m24332e() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long j = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        String str = f31873a;
        SystemUtils.log(6, str, "java maxMemory: " + m24324a(maxMemory), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 130);
        String str2 = f31873a;
        SystemUtils.log(6, str2, "java totalMemory: " + m24324a(j), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 131);
        String str3 = f31873a;
        SystemUtils.log(6, str3, "java freeMemory: " + m24324a(freeMemory), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 132);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) this.f31877b.getSystemService("activity")).getMemoryInfo(memoryInfo);
        String str4 = f31873a;
        SystemUtils.log(6, str4, "MemoryInfo availMem: " + m24324a(memoryInfo.availMem), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 137);
        String str5 = f31873a;
        SystemUtils.log(6, str5, "MemoryInfo totalMem: " + m24324a(memoryInfo.totalMem), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 138);
        String str6 = f31873a;
        SystemUtils.log(6, str6, "MemoryInfo lowMemory: " + memoryInfo.lowMemory, (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 139);
        String str7 = f31873a;
        SystemUtils.log(6, str7, "MemoryInfo threshold: " + m24324a(memoryInfo.threshold), (Throwable) null, "com.didi.one.netdetect.TraceRouteStore", 140);
    }

    /* renamed from: a */
    private String m24324a(long j) {
        return Formatter.formatFileSize(this.f31877b, j);
    }

    /* renamed from: b */
    public void mo86363b() {
        Thread thread = new Thread(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|13|14|23) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0073 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r14 = this;
                    com.didi.one.netdetect.TraceRouteStore r0 = com.didi.one.netdetect.TraceRouteStore.this
                    java.io.File r0 = r0.f31880e
                    java.lang.String[] r0 = r0.list()
                    com.google.gson.Gson r1 = new com.google.gson.Gson
                    r1.<init>()
                    if (r0 == 0) goto L_0x007e
                    int r2 = r0.length
                    r3 = 0
                L_0x0013:
                    if (r3 >= r2) goto L_0x007e
                    r4 = r0[r3]
                    java.io.File r5 = new java.io.File
                    r5.<init>(r4)
                    com.didi.one.netdetect.TraceRouteStore r4 = com.didi.one.netdetect.TraceRouteStore.this
                    boolean r4 = r4.m24326a((java.io.File) r5)
                    if (r4 == 0) goto L_0x0025
                    goto L_0x007b
                L_0x0025:
                    java.lang.String r4 = com.didi.one.netdetect.util.IOUtil.read(r5)     // Catch:{ IOException -> 0x0077 }
                    boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0077 }
                    if (r6 == 0) goto L_0x0033
                    r5.delete()     // Catch:{ IOException -> 0x0077 }
                    goto L_0x007b
                L_0x0033:
                    java.lang.Class<com.didi.one.netdetect.model.TraceRouteCacheItem> r6 = com.didi.one.netdetect.model.TraceRouteCacheItem.class
                    java.lang.Object r4 = r1.fromJson((java.lang.String) r4, r6)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.model.TraceRouteCacheItem r4 = (com.didi.one.netdetect.model.TraceRouteCacheItem) r4     // Catch:{ JsonSyntaxException -> 0x0073 }
                    java.lang.String r6 = r4.getHost()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    int r7 = r4.getFailCount()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.model.TraceRouteReportInfo r11 = r4.getInfo()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JsonSyntaxException -> 0x0073 }
                    r8.<init>()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    r8.append(r6)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    java.lang.String r6 = "/appNetMonitor/v2/trInfoReport"
                    r8.append(r6)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    java.lang.String r9 = r8.toString()     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.TraceRouteStore r6 = com.didi.one.netdetect.TraceRouteStore.this     // Catch:{ JsonSyntaxException -> 0x0073 }
                    android.content.Context r8 = r6.f31877b     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.TraceRouteStore r6 = com.didi.one.netdetect.TraceRouteStore.this     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.model.DetectionParam r10 = r6.f31878c     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.TraceRouteStore r6 = com.didi.one.netdetect.TraceRouteStore.this     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.security.SignGenerator r12 = r6.f31879d     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.TraceRouteStore$1$1 r13 = new com.didi.one.netdetect.TraceRouteStore$1$1     // Catch:{ JsonSyntaxException -> 0x0073 }
                    r13.<init>(r5, r7, r4)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    com.didi.one.netdetect.http.HttpService.traceRouteInfoReport(r8, r9, r10, r11, r12, r13)     // Catch:{ JsonSyntaxException -> 0x0073 }
                    goto L_0x007b
                L_0x0073:
                    r5.delete()     // Catch:{ IOException -> 0x0077 }
                    goto L_0x007b
                L_0x0077:
                    r4 = move-exception
                    r4.printStackTrace()
                L_0x007b:
                    int r3 = r3 + 1
                    goto L_0x0013
                L_0x007e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.one.netdetect.TraceRouteStore.C111441.run():void");
            }
        });
        thread.setPriority(10);
        thread.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m24326a(File file) {
        String[] split = file.getName().split("_");
        if (split.length != 2) {
            return false;
        }
        try {
            if (System.currentTimeMillis() - Long.parseLong(split[1]) <= 604800000) {
                return false;
            }
            file.delete();
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }
}
