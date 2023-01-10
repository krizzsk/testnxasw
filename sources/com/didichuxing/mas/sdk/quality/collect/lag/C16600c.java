package com.didichuxing.mas.sdk.quality.collect.lag;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.mas.sdk.quality.collect.lag.internal.BlockInfo;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.lag.c */
/* compiled from: CpuSampler */
class C16600c extends C16598a {

    /* renamed from: c */
    private static final String f50691c = "CpuSampler";

    /* renamed from: d */
    private static final int f50692d = 1000;

    /* renamed from: f */
    private static final int f50693f = 10;

    /* renamed from: e */
    private final int f50694e = ((int) (((float) this.f50689b) * 1.2f));

    /* renamed from: g */
    private final LinkedHashMap<Long, String> f50695g = new LinkedHashMap<>();

    /* renamed from: h */
    private int f50696h = 0;

    /* renamed from: i */
    private long f50697i = 0;

    /* renamed from: j */
    private long f50698j = 0;

    /* renamed from: k */
    private long f50699k = 0;

    /* renamed from: l */
    private long f50700l = 0;

    /* renamed from: m */
    private long f50701m = 0;

    /* renamed from: n */
    private long f50702n = 0;

    public C16600c(long j) {
        super(j);
    }

    /* renamed from: a */
    public void mo124921a() {
        super.mo124921a();
        m37769f();
    }

    /* renamed from: d */
    public String mo124925d() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f50695g) {
            for (Map.Entry next : this.f50695g.entrySet()) {
                sb.append(BlockInfo.TIME_FORMATTER.format(Long.valueOf(((Long) next.getKey()).longValue())));
                sb.append(' ');
                sb.append((String) next.getValue());
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public boolean mo124924a(long j, long j2) {
        if (j2 - j <= this.f50689b) {
            return false;
        }
        long j3 = j - this.f50689b;
        long j4 = j + this.f50689b;
        synchronized (this.f50695g) {
            long j5 = 0;
            for (Map.Entry<Long, String> key : this.f50695g.entrySet()) {
                long longValue = ((Long) key.getKey()).longValue();
                if (j3 < longValue && longValue < j4) {
                    if (j5 != 0 && longValue - j5 > ((long) this.f50694e)) {
                        return true;
                    }
                    j5 = longValue;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d A[Catch:{ IOException -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo124923c() {
        /*
            r10 = this;
            boolean r0 = r10.m37768e()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x006a }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x006a }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x006a }
            java.lang.String r4 = "/proc/stat"
            r3.<init>(r4)     // Catch:{ all -> 0x006a }
            r2.<init>(r3)     // Catch:{ all -> 0x006a }
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.<init>(r2, r3)     // Catch:{ all -> 0x006a }
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = ""
            if (r2 != 0) goto L_0x0024
            r2 = r4
        L_0x0024:
            int r5 = r10.f50696h     // Catch:{ all -> 0x0067 }
            if (r5 != 0) goto L_0x002e
            int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0067 }
            r10.f50696h = r5     // Catch:{ all -> 0x0067 }
        L_0x002e:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0067 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x0067 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x0067 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r8.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r9 = "/proc/"
            r8.append(r9)     // Catch:{ all -> 0x0067 }
            int r9 = r10.f50696h     // Catch:{ all -> 0x0067 }
            r8.append(r9)     // Catch:{ all -> 0x0067 }
            java.lang.String r9 = "/stat"
            r8.append(r9)     // Catch:{ all -> 0x0067 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0067 }
            r7.<init>(r8)     // Catch:{ all -> 0x0067 }
            r6.<init>(r7)     // Catch:{ all -> 0x0067 }
            r5.<init>(r6, r3)     // Catch:{ all -> 0x0067 }
            java.lang.String r0 = r5.readLine()     // Catch:{ all -> 0x0068 }
            if (r0 != 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r4 = r0
        L_0x005d:
            r10.m37767a((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ all -> 0x0068 }
            r1.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0063:
            r5.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0073
        L_0x0067:
            r5 = r0
        L_0x0068:
            r0 = r1
            goto L_0x006b
        L_0x006a:
            r5 = r0
        L_0x006b:
            if (r0 == 0) goto L_0x0070
            r0.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0070:
            if (r5 == 0) goto L_0x0073
            goto L_0x0063
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.collect.lag.C16600c.mo124923c():void");
    }

    /* renamed from: e */
    private boolean m37768e() {
        File file = new File("/proc/stat");
        if (!file.exists()) {
            return false;
        }
        return file.canRead();
    }

    /* renamed from: f */
    private void m37769f() {
        this.f50697i = 0;
        this.f50698j = 0;
        this.f50699k = 0;
        this.f50700l = 0;
        this.f50701m = 0;
        this.f50702n = 0;
    }

    /* renamed from: a */
    private void m37767a(String str, String str2) {
        long j;
        long j2;
        String[] split = str.split(" ");
        if (split.length >= 9) {
            long parseLong = Long.parseLong(split[2]);
            long parseLong2 = Long.parseLong(split[3]);
            long parseLong3 = Long.parseLong(split[4]);
            long parseLong4 = Long.parseLong(split[5]);
            long parseLong5 = Long.parseLong(split[6]);
            long parseLong6 = parseLong2 + parseLong + parseLong3 + parseLong4 + parseLong5 + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            String[] split2 = str2.split(" ");
            if (split2.length >= 17) {
                long parseLong7 = Long.parseLong(split2[13]) + Long.parseLong(split2[14]) + Long.parseLong(split2[15]) + Long.parseLong(split2[16]);
                if (this.f50701m != 0) {
                    StringBuilder sb = new StringBuilder();
                    long j3 = parseLong4 - this.f50699k;
                    j2 = parseLong4;
                    long j4 = parseLong6 - this.f50701m;
                    j = parseLong6;
                    sb.append("cpu:");
                    sb.append(((j4 - j3) * 100) / j4);
                    sb.append("% ");
                    sb.append("app:");
                    sb.append(((parseLong7 - this.f50702n) * 100) / j4);
                    sb.append("% ");
                    sb.append(Const.jaLeft);
                    sb.append("user:");
                    sb.append(((parseLong - this.f50697i) * 100) / j4);
                    sb.append("% ");
                    sb.append("system:");
                    sb.append(((parseLong3 - this.f50698j) * 100) / j4);
                    sb.append("% ");
                    sb.append("ioWait:");
                    sb.append(((parseLong5 - this.f50700l) * 100) / j4);
                    sb.append("% ]");
                    synchronized (this.f50695g) {
                        this.f50695g.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
                        if (this.f50695g.size() > 10) {
                            Iterator<Map.Entry<Long, String>> it = this.f50695g.entrySet().iterator();
                            if (it.hasNext()) {
                                this.f50695g.remove((Long) it.next().getKey());
                            }
                        }
                    }
                } else {
                    j = parseLong6;
                    j2 = parseLong4;
                }
                this.f50697i = parseLong;
                this.f50698j = parseLong3;
                this.f50699k = j2;
                this.f50700l = parseLong5;
                this.f50701m = j;
                this.f50702n = parseLong7;
            }
        }
    }
}
