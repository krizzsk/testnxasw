package com.didi.ifx.license;

import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IFXModel {

    /* renamed from: A */
    private int f26505A;

    /* renamed from: B */
    private int f26506B;

    /* renamed from: C */
    private int f26507C;

    /* renamed from: D */
    private int f26508D;

    /* renamed from: E */
    private int f26509E;

    /* renamed from: a */
    boolean f26510a;

    /* renamed from: b */
    int f26511b;

    /* renamed from: c */
    String f26512c;

    /* renamed from: d */
    String f26513d;

    /* renamed from: e */
    String f26514e;

    /* renamed from: f */
    String f26515f;

    /* renamed from: g */
    boolean f26516g;

    /* renamed from: h */
    volatile boolean f26517h;

    /* renamed from: i */
    volatile boolean f26518i;

    /* renamed from: j */
    long f26519j;

    /* renamed from: k */
    long f26520k;

    /* renamed from: l */
    long f26521l;

    /* renamed from: m */
    volatile boolean f26522m;

    /* renamed from: n */
    int f26523n;

    /* renamed from: o */
    LicenseFile f26524o;

    /* renamed from: p */
    C10041c f26525p;

    /* renamed from: q */
    int f26526q;

    /* renamed from: r */
    int f26527r;

    /* renamed from: s */
    int f26528s;

    /* renamed from: t */
    int f26529t;

    /* renamed from: u */
    private String f26530u = "IFXModel";

    /* renamed from: v */
    private String f26531v = "IFXModelError";

    /* renamed from: w */
    private long f26532w;

    /* renamed from: x */
    private long f26533x;

    /* renamed from: y */
    private long f26534y;

    /* renamed from: z */
    private int f26535z;

    public IFXModel(String str) {
        this.f26515f = str;
        this.f26516g = false;
        this.f26510a = false;
        this.f26518i = false;
        this.f26517h = false;
        this.f26519j = 10;
        this.f26522m = false;
        this.f26523n = 0;
        this.f26526q = 0;
        this.f26527r = 1;
        this.f26528s = 1;
        this.f26529t = 0;
    }

    /* renamed from: a */
    private void m20983a(long j) {
        if (this.f26526q != 0) {
            String str = this.f26530u;
            SystemUtils.log(4, str, "Model[" + this.f26511b + "] IFX model inference_omg_mode happens error", (Throwable) null, "com.didi.ifx.license.IFXModel", 2);
        } else if (j != -666) {
            String str2 = this.f26512c;
            if (str2 == null || str2.isEmpty()) {
                String str3 = this.f26530u;
                SystemUtils.log(6, str3, "Model[" + this.f26511b + "] License key is invalid when to report", (Throwable) null, "com.didi.ifx.license.IFXModel", 47);
                return;
            }
            try {
                String a = C10039a.m21115a(this.f26512c);
                String str4 = this.f26514e;
                if (str4 == null || str4.isEmpty()) {
                    String str5 = this.f26530u;
                    SystemUtils.log(6, str5, "Model[" + this.f26511b + "] Device Id is invalid when to report", (Throwable) null, "com.didi.ifx.license.IFXModel", 45);
                    return;
                }
                long j2 = j > 60000 ? -8 : j;
                int i = 100;
                if (j2 < 0) {
                    i = j2 == -9 ? 101 : j2 == -1 ? 102 : j2 == -3 ? 104 : j2 == -8 ? 108 : 109;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("license_key_checksum", a);
                hashMap.put("device_id", this.f26514e);
                hashMap.put("sdk_version", "2.1.1");
                hashMap.put("inference_time", Long.valueOf(j2));
                hashMap.put("code", Integer.valueOf(i));
                this.f26525p.mo77461a("tech_ifx_report_inference", (Map<String, Object>) hashMap);
            } catch (Throwable unused) {
                String str6 = this.f26530u;
                SystemUtils.log(6, str6, "Model[" + this.f26511b + "] Fetch license key checksum fail when to report", (Throwable) null, "com.didi.ifx.license.IFXModel", 46);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006a, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m20986c(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = -666(0xfffffffffffffd66, double:NaN)
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0009
            monitor-exit(r7)
            return
        L_0x0009:
            long r0 = r7.f26532w     // Catch:{ all -> 0x006b }
            r2 = 1
            long r0 = r0 + r2
            r7.f26532w = r0     // Catch:{ all -> 0x006b }
            r0 = 60000(0xea60, double:2.9644E-319)
            r4 = -8
            int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x001a
            r8 = r4
        L_0x001a:
            r0 = 0
            int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0059
            r0 = -9
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x002d
            int r8 = r7.f26505A     // Catch:{ all -> 0x006b }
            int r8 = r8 + 1
            r7.f26505A = r8     // Catch:{ all -> 0x006b }
            goto L_0x0069
        L_0x002d:
            r0 = -1
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x003a
            int r8 = r7.f26506B     // Catch:{ all -> 0x006b }
            int r8 = r8 + 1
            r7.f26506B = r8     // Catch:{ all -> 0x006b }
            goto L_0x0069
        L_0x003a:
            r0 = -3
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0047
            int r8 = r7.f26507C     // Catch:{ all -> 0x006b }
            int r8 = r8 + 1
            r7.f26507C = r8     // Catch:{ all -> 0x006b }
            goto L_0x0069
        L_0x0047:
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0052
            int r8 = r7.f26508D     // Catch:{ all -> 0x006b }
            int r8 = r8 + 1
            r7.f26508D = r8     // Catch:{ all -> 0x006b }
            goto L_0x0069
        L_0x0052:
            int r8 = r7.f26509E     // Catch:{ all -> 0x006b }
            int r8 = r8 + 1
            r7.f26509E = r8     // Catch:{ all -> 0x006b }
            goto L_0x0069
        L_0x0059:
            int r0 = r7.f26535z     // Catch:{ all -> 0x006b }
            int r0 = r0 + 1
            r7.f26535z = r0     // Catch:{ all -> 0x006b }
            long r0 = r7.f26533x     // Catch:{ all -> 0x006b }
            long r0 = r0 + r2
            r7.f26533x = r0     // Catch:{ all -> 0x006b }
            long r0 = r7.f26534y     // Catch:{ all -> 0x006b }
            long r0 = r0 + r8
            r7.f26534y = r0     // Catch:{ all -> 0x006b }
        L_0x0069:
            monitor-exit(r7)
            return
        L_0x006b:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.IFXModel.m20986c(long):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo77401a(int i, int i2, String str) {
        String str2;
        this.f26511b = i;
        this.f26514e = str;
        String str3 = this.f26512c;
        if (str3 == null || str3.isEmpty()) {
            String str4 = this.f26530u;
            SystemUtils.log(6, str4, "Model[" + this.f26511b + "] Model uuid is invalid", (Throwable) null, "com.didi.ifx.license.IFXModel", 21);
            this.f26525p.mo77460a(this.f26531v, new Throwable("Model uuid is invalid"));
            return false;
        }
        try {
            str2 = C10039a.m21121b(this.f26512c + this.f26515f);
        } catch (Throwable th) {
            String str5 = this.f26530u;
            SystemUtils.log(4, str5, "Model[" + this.f26511b + "] Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.IFXModel", 15);
            this.f26525p.mo77460a(this.f26531v, th);
            str2 = "model";
        }
        this.f26513d = str2 + this.f26511b + ".ifx.v2.license";
        this.f26521l = System.currentTimeMillis() / 1000;
        return true;
    }

    public long generateToken() {
        long currentTimeMillis = System.currentTimeMillis() ^ C10039a.f26630a;
        int i = C10039a.f26633d;
        if ((!this.f26518i || !this.f26517h) && ((i = new Random().nextInt(C10039a.f26634e)) == C10039a.f26633d || i == C10039a.f26634e)) {
            i--;
        }
        return (((currentTimeMillis * 100) + ((long) i)) ^ C10039a.f26631b) << C10039a.f26632c;
    }

    public String getModelPath() {
        return this.f26515f;
    }

    public void reportInferenceTimeByOMG(long j) {
        if (this.f26526q > 0) {
            m20985b(j);
        } else {
            m20983a(j);
        }
    }

    public boolean setIFXModelInferenceMode(int i) {
        if (this.f26517h) {
            String str = this.f26530u;
            SystemUtils.log(4, str, "Model[" + this.f26511b + "] setIFXModelInferenceMode fail", (Throwable) null, "com.didi.ifx.license.IFXModel", 2);
            return false;
        }
        this.f26526q = i;
        return true;
    }

    public boolean setIFXModelInferenceMode(int i, int i2) {
        if (this.f26517h) {
            String str = this.f26530u;
            SystemUtils.log(4, str, "Model[" + this.f26511b + "] setIFXModelInferenceMode fail", (Throwable) null, "com.didi.ifx.license.IFXModel", 7);
            return false;
        }
        this.f26526q = i;
        this.f26527r = i2;
        return true;
    }

    /* renamed from: b */
    private void m20985b(long j) {
        if (this.f26526q < 1) {
            String str = this.f26530u;
            SystemUtils.log(4, str, "Model[" + this.f26511b + "] IFX model inference_omg_mode happens error", (Throwable) null, "com.didi.ifx.license.IFXModel", 24);
            return;
        }
        m20986c(j);
    }

    /* renamed from: b */
    private void m20984b() {
        this.f26532w = 0;
        this.f26533x = 0;
        this.f26534y = 0;
        this.f26535z = 0;
        this.f26505A = 0;
        this.f26506B = 0;
        this.f26507C = 0;
        this.f26508D = 0;
        this.f26509E = 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:27|28|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r2 = r7.f26530u;
        com.didi.sdk.apm.SystemUtils.log(6, r2, "Model[" + r7.f26511b + "] Fetch license key checksum fail when to report", (java.lang.Throwable) null, "com.didi.ifx.license.IFXModel", 91);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0110, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00ec */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0111=Splitter:B:31:0x0111, B:23:0x00c7=Splitter:B:23:0x00c7, B:12:0x001a=Splitter:B:12:0x001a} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo77400a() {
        /*
            r7 = this;
            monitor-enter(r7)
            long r0 = r7.f26532w     // Catch:{ all -> 0x0136 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x000e
            r7.m20984b()     // Catch:{ all -> 0x0136 }
            monitor-exit(r7)
            return
        L_0x000e:
            java.lang.String r0 = r7.f26512c     // Catch:{ all -> 0x0136 }
            if (r0 == 0) goto L_0x0111
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0136 }
            if (r0 == 0) goto L_0x001a
            goto L_0x0111
        L_0x001a:
            java.lang.String r0 = r7.f26512c     // Catch:{ all -> 0x00ec }
            java.lang.String r0 = com.didi.ifx.license.C10039a.m21115a((java.lang.String) r0)     // Catch:{ all -> 0x00ec }
            java.lang.String r1 = r7.f26514e     // Catch:{ all -> 0x0136 }
            if (r1 == 0) goto L_0x00c7
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0136 }
            if (r1 == 0) goto L_0x002c
            goto L_0x00c7
        L_0x002c:
            long r1 = r7.f26534y     // Catch:{ all -> 0x0136 }
            double r1 = (double) r1     // Catch:{ all -> 0x0136 }
            long r3 = r7.f26533x     // Catch:{ all -> 0x0136 }
            double r3 = (double) r3     // Catch:{ all -> 0x0136 }
            double r1 = r1 / r3
            r3 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r1 = r1 * r3
            long r1 = java.lang.Math.round(r1)     // Catch:{ all -> 0x0136 }
            double r1 = (double) r1     // Catch:{ all -> 0x0136 }
            double r1 = r1 / r3
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0136 }
            r3.<init>()     // Catch:{ all -> 0x0136 }
            java.lang.String r4 = "license_key_checksum"
            r3.put(r4, r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r0 = r7.f26514e     // Catch:{ all -> 0x0136 }
            java.lang.String r4 = "device_id"
            r3.put(r4, r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r0 = "sdk_version"
            java.lang.String r4 = "2.1.1"
            r3.put(r0, r4)     // Catch:{ all -> 0x0136 }
            long r4 = r7.f26532w     // Catch:{ all -> 0x0136 }
            java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r4 = "inference_cnt"
            r3.put(r4, r0)     // Catch:{ all -> 0x0136 }
            long r4 = r7.f26533x     // Catch:{ all -> 0x0136 }
            java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r4 = "inference_success_cnt"
            r3.put(r4, r0)     // Catch:{ all -> 0x0136 }
            java.lang.Double r0 = java.lang.Double.valueOf(r1)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "inference_avg"
            r3.put(r1, r0)     // Catch:{ all -> 0x0136 }
            int r0 = r7.f26535z     // Catch:{ all -> 0x0136 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "code_100_cnt"
            r3.put(r1, r0)     // Catch:{ all -> 0x0136 }
            int r0 = r7.f26505A     // Catch:{ all -> 0x0136 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "code_101_cnt"
            r3.put(r1, r0)     // Catch:{ all -> 0x0136 }
            int r0 = r7.f26506B     // Catch:{ all -> 0x0136 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "code_102_cnt"
            r3.put(r1, r0)     // Catch:{ all -> 0x0136 }
            int r0 = r7.f26507C     // Catch:{ all -> 0x0136 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "code_104_cnt"
            r3.put(r1, r0)     // Catch:{ all -> 0x0136 }
            int r0 = r7.f26508D     // Catch:{ all -> 0x0136 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "code_108_cnt"
            r3.put(r1, r0)     // Catch:{ all -> 0x0136 }
            int r0 = r7.f26509E     // Catch:{ all -> 0x0136 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "code_109_cnt"
            r3.put(r1, r0)     // Catch:{ all -> 0x0136 }
            com.didi.ifx.license.c r0 = r7.f26525p     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "tech_ifx_report_inference_agg"
            r0.mo77461a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r3)     // Catch:{ all -> 0x0136 }
            r7.m20984b()     // Catch:{ all -> 0x0136 }
            monitor-exit(r7)
            return
        L_0x00c7:
            java.lang.String r2 = r7.f26530u     // Catch:{ all -> 0x0136 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
            r0.<init>()     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "Model["
            r0.append(r1)     // Catch:{ all -> 0x0136 }
            int r1 = r7.f26511b     // Catch:{ all -> 0x0136 }
            r0.append(r1)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "] Device Id is invalid when to report"
            r0.append(r1)     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0136 }
            r1 = 6
            r4 = 0
            java.lang.String r5 = "com.didi.ifx.license.IFXModel"
            r6 = 90
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0136 }
            monitor-exit(r7)
            return
        L_0x00ec:
            java.lang.String r2 = r7.f26530u     // Catch:{ all -> 0x0136 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
            r0.<init>()     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "Model["
            r0.append(r1)     // Catch:{ all -> 0x0136 }
            int r1 = r7.f26511b     // Catch:{ all -> 0x0136 }
            r0.append(r1)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "] Fetch license key checksum fail when to report"
            r0.append(r1)     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0136 }
            r1 = 6
            r4 = 0
            java.lang.String r5 = "com.didi.ifx.license.IFXModel"
            r6 = 91
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0136 }
            monitor-exit(r7)
            return
        L_0x0111:
            java.lang.String r2 = r7.f26530u     // Catch:{ all -> 0x0136 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
            r0.<init>()     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "Model["
            r0.append(r1)     // Catch:{ all -> 0x0136 }
            int r1 = r7.f26511b     // Catch:{ all -> 0x0136 }
            r0.append(r1)     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = "] License key is invalid when to report"
            r0.append(r1)     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0136 }
            r1 = 6
            r4 = 0
            java.lang.String r5 = "com.didi.ifx.license.IFXModel"
            r6 = 92
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0136 }
            monitor-exit(r7)
            return
        L_0x0136:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.IFXModel.mo77400a():void");
    }

    public IFXModel(String str, int i) {
        this.f26515f = str;
        this.f26516g = i > 0;
        this.f26510a = false;
        this.f26518i = false;
        this.f26517h = false;
        this.f26519j = 15;
        this.f26522m = false;
        this.f26523n = 0;
        this.f26526q = 0;
        this.f26527r = 10;
    }
}
