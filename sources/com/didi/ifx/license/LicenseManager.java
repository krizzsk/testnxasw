package com.didi.ifx.license;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LicenseManager {

    /* renamed from: a */
    private boolean f26536a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f26537b;

    /* renamed from: c */
    private boolean f26538c;

    /* renamed from: d */
    private boolean f26539d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f26540e;

    /* renamed from: f */
    private String f26541f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f26542g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LicenseFile f26543h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f26544i;

    /* renamed from: j */
    private String f26545j;

    /* renamed from: k */
    private OkHttpClient f26546k;

    /* renamed from: l */
    private final MediaType f26547l = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: m */
    private String f26548m;

    /* renamed from: n */
    private ScheduledExecutorService f26549n;

    /* renamed from: o */
    private long f26550o = 2;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f26551p = 5;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public long f26552q = 15;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public long f26553r = 5;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f26554s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f26555t;
    private long token;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Gson f26556u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public volatile boolean f26557v;

    /* renamed from: w */
    private int f26558w;

    /* renamed from: x */
    private int f26559x;

    /* renamed from: y */
    private InferenceMonitor f26560y;

    /* renamed from: z */
    private IFXTrackCallback f26561z;

    private class HeartBeat implements Runnable {

        /* renamed from: 䞂 */
        private long f26564;

        public void run() {
            try {
                Thread.sleep(((long) new Random().nextInt((int) this.f26564)) * 1000);
            } catch (InterruptedException e) {
                SystemUtils.log(6, "LicenseManager", "[HeartBeat]" + e.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager$HeartBeat", 5);
                LicenseManager.this.m21008a("IFXLicenseManagerError", (Throwable) e);
                Thread.currentThread().interrupt();
            }
            LicenseManager.this.m21017b();
        }

        private HeartBeat(long j) {
            this.f26564 = j;
        }
    }

    private class InferenceMonitor {

        /* renamed from: ቮ */
        private int f26566;

        /* renamed from: ᡆ */
        private int f26567;

        /* renamed from: ᾖ */
        private int f26569;

        /* renamed from: ㄲ */
        private int f26570;

        /* renamed from: 䞂 */
        private ScheduledExecutorService f26571;

        /* renamed from: 䞦 */
        private int f26572;

        /* renamed from: 䧁 */
        private long f26573;

        /* renamed from: 䫅 */
        private long f26574;

        /* renamed from: 䳷 */
        private int f26575;

        /* renamed from: 偡 */
        private long f26576;

        /* renamed from: 儵 */
        private int f26577;

        InferenceMonitor(int i) {
            m21035();
            this.f26567 = i;
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f26571 = newSingleThreadScheduledExecutor;
            C100271 r1 = new Runnable(LicenseManager.this) {
                public void run() {
                    InferenceMonitor.this.m21039();
                }
            };
            long j = (long) this.f26567;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(r1, j, j, TimeUnit.MINUTES);
        }

        /* access modifiers changed from: private */
        /* renamed from: ቮ */
        public synchronized void m21034() {
            ScheduledExecutorService scheduledExecutorService = this.f26571;
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                if (this.f26576 > 0) {
                    m21039();
                }
                this.f26571.shutdown();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 偡 */
        public synchronized void m21039() {
            if (this.f26576 == 0) {
                m21035();
            } else if (LicenseManager.this.f26542g == null || LicenseManager.this.f26542g.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[InferenceMonitor]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager$InferenceMonitor", 48);
            } else {
                try {
                    String a = C10039a.m21115a(LicenseManager.this.f26542g);
                    LicenseManager licenseManager = LicenseManager.this;
                    String unused = licenseManager.f26544i = C10040b.m21124a(licenseManager.f26540e);
                    if (LicenseManager.this.f26544i != null) {
                        if (!LicenseManager.this.f26544i.isEmpty()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("license_key_checksum", a);
                            hashMap.put("device_id", LicenseManager.this.f26544i);
                            hashMap.put("sdk_version", "2.1.1");
                            hashMap.put("inference_cnt", Long.valueOf(this.f26576));
                            hashMap.put("inference_success_cnt", Long.valueOf(this.f26574));
                            hashMap.put("inference_avg", Double.valueOf(((double) Math.round((((double) this.f26573) / ((double) this.f26574)) * 1000.0d)) / 1000.0d));
                            hashMap.put("code_100_cnt", Integer.valueOf(this.f26566));
                            hashMap.put("code_101_cnt", Integer.valueOf(this.f26570));
                            hashMap.put("code_102_cnt", Integer.valueOf(this.f26572));
                            hashMap.put("code_104_cnt", Integer.valueOf(this.f26575));
                            hashMap.put("code_108_cnt", Integer.valueOf(this.f26569));
                            hashMap.put("code_109_cnt", Integer.valueOf(this.f26577));
                            LicenseManager.this.m21009a("tech_ifx_report_inference_agg", (Map<String, Object>) hashMap);
                            m21035();
                            return;
                        }
                    }
                    SystemUtils.log(6, "LicenseManager", "[InferenceMonitor]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager$InferenceMonitor", 46);
                } catch (Throwable th) {
                    SystemUtils.log(6, "LicenseManager", "[InferenceMonitor]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager$InferenceMonitor", 47);
                }
            }
        }

        /* renamed from: 䞂 */
        private void m21035() {
            this.f26576 = 0;
            this.f26566 = 0;
            this.f26570 = 0;
            this.f26572 = 0;
            this.f26575 = 0;
            this.f26569 = 0;
            this.f26577 = 0;
            this.f26574 = 0;
            this.f26573 = 0;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
            return;
         */
        /* renamed from: 䞂 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void m21036(long r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                r0 = -666(0xfffffffffffffd66, double:NaN)
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x0009
                monitor-exit(r7)
                return
            L_0x0009:
                long r0 = r7.f26576     // Catch:{ all -> 0x006a }
                r2 = 1
                long r0 = r0 + r2
                r7.f26576 = r0     // Catch:{ all -> 0x006a }
                r0 = 30000(0x7530, double:1.4822E-319)
                r4 = -8
                int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r6 <= 0) goto L_0x0019
                r8 = r4
            L_0x0019:
                r0 = 0
                int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r6 >= 0) goto L_0x0058
                r0 = -9
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x002c
                int r8 = r7.f26570     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f26570 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x002c:
                r0 = -1
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x0039
                int r8 = r7.f26572     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f26572 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x0039:
                r0 = -3
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x0046
                int r8 = r7.f26575     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f26575 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x0046:
                int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x0051
                int r8 = r7.f26569     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f26569 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x0051:
                int r8 = r7.f26577     // Catch:{ all -> 0x006a }
                int r8 = r8 + 1
                r7.f26577 = r8     // Catch:{ all -> 0x006a }
                goto L_0x0068
            L_0x0058:
                int r0 = r7.f26566     // Catch:{ all -> 0x006a }
                int r0 = r0 + 1
                r7.f26566 = r0     // Catch:{ all -> 0x006a }
                long r0 = r7.f26574     // Catch:{ all -> 0x006a }
                long r0 = r0 + r2
                r7.f26574 = r0     // Catch:{ all -> 0x006a }
                long r0 = r7.f26573     // Catch:{ all -> 0x006a }
                long r0 = r0 + r8
                r7.f26573 = r0     // Catch:{ all -> 0x006a }
            L_0x0068:
                monitor-exit(r7)
                return
            L_0x006a:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.LicenseManager.InferenceMonitor.m21036(long):void");
        }
    }

    public LicenseManager(Context context) {
        this.f26540e = context;
        this.f26536a = true;
        this.f26537b = false;
        this.f26538c = false;
        this.f26539d = false;
        this.f26558w = 0;
        this.f26559x = 10;
    }

    /* renamed from: a */
    static /* synthetic */ int m20990a(LicenseManager licenseManager) {
        int i = licenseManager.f26555t;
        licenseManager.f26555t = i + 1;
        return i;
    }

    public boolean licenseInit(String str) {
        String str2;
        this.f26545j = str;
        String d = m21026d();
        this.f26542g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 26);
            m21008a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f26558w = 0;
        this.f26554s = System.currentTimeMillis() / 1000;
        if (!this.f26536a) {
            return true;
        }
        this.f26548m = "https://ifx-license.didiglobal.com/v1/license/register";
        try {
            str2 = C10039a.m21121b(this.f26542g + this.f26545j);
        } catch (Throwable th) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 17);
            m21008a("IFXLicenseManagerError", th);
            str2 = "model";
        }
        this.f26541f = str2 + ".ifx.v1.license";
        this.f26556u = new GsonBuilder().create();
        this.f26557v = false;
        this.token = 0;
        m20995a();
        this.f26555t = 0;
        return true;
    }

    public boolean licenseInitWithModelInAssets(String str) {
        String str2;
        this.f26545j = str;
        this.f26538c = true;
        String d = m21026d();
        this.f26542g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 27);
            m21008a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f26558w = 0;
        this.f26554s = System.currentTimeMillis() / 1000;
        if (this.f26536a) {
            this.f26548m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C10039a.m21121b(this.f26542g + this.f26545j);
            } catch (Throwable th) {
                SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 18);
                m21008a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f26541f = str2 + ".ifx.v1.license";
            this.f26556u = new GsonBuilder().create();
            this.f26557v = false;
            this.token = 0;
            m20995a();
            this.f26555t = 0;
        }
        return true;
    }

    public void licenseRelease() {
        m21028e();
        InferenceMonitor inferenceMonitor = this.f26560y;
        if (inferenceMonitor != null) {
            inferenceMonitor.m21034();
        }
    }

    public void omegaReportInference(long j) {
        int i = this.f26558w;
        if (i == 0) {
            m20998a(j);
        } else if (i == 1) {
            m21018b(j);
        }
    }

    public void setIFXTrackCallback(IFXTrackCallback iFXTrackCallback) {
        this.f26539d = true;
        this.f26561z = iFXTrackCallback;
    }

    public void setLocationCode(int i) {
        if (i != 1) {
            this.f26548m = "https://ifx-license.didiglobal.com/v1/license/register";
        } else {
            this.f26548m = "https://ifx-license.didiglobal.com/v1/license/register";
        }
    }

    public void setOnlineLicenseSwitch(boolean z) {
        this.f26536a = z;
    }

    public boolean verifyLicense() {
        m21023c();
        if (this.f26536a) {
            long currentTimeMillis = System.currentTimeMillis();
            int b = m21013b(false);
            if (b == -6) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]License file is broken and need pulled from server", (Throwable) null, "com.didi.ifx.license.LicenseManager", 36);
                this.f26557v = true;
                m20999a(this.f26550o, this.f26552q, this.f26553r);
                return true;
            } else if (b == -4) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]License file may be modified illegally ", (Throwable) null, "com.didi.ifx.license.LicenseManager", 33);
                return false;
            } else if (b == -3) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]Decode license file fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 30);
                return false;
            } else if (b == -2) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]Read license file fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 27);
                return false;
            } else if (b == -1) {
                this.f26557v = true;
                m20999a(this.f26550o, this.f26552q, this.f26553r);
                return true;
            } else if (b != 0) {
                SystemUtils.log(4, "LicenseManager", "[verifyLicense]Fetch local license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 6);
                return false;
            } else {
                int a = !this.f26537b ? m20989a(this.f26543h) : 0;
                if (a > 0) {
                    SystemUtils.log(4, "LicenseManager", "[verifyLicense]Check license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 14);
                    m20996a(a, System.currentTimeMillis() - currentTimeMillis);
                    return false;
                }
                this.f26557v = true;
                m20996a(a, System.currentTimeMillis() - currentTimeMillis);
                m20999a(this.f26550o, this.f26552q, this.f26553r);
                return true;
            }
        } else {
            this.f26557v = true;
            m20999a(this.f26550o, this.f26552q, this.f26553r);
            return true;
        }
    }

    public void verifyToken() {
        long currentTimeMillis = System.currentTimeMillis() ^ C10039a.f26630a;
        int i = C10039a.f26633d;
        if (!this.f26557v && ((i = new Random().nextInt(C10039a.f26634e)) == C10039a.f26633d || i == C10039a.f26634e)) {
            i--;
        }
        this.token = (((currentTimeMillis * 100) + ((long) i)) ^ C10039a.f26631b) << C10039a.f26632c;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21017b() {
        m21023c();
        if (this.f26536a && System.currentTimeMillis() >= this.f26554s * 1000) {
            long currentTimeMillis = System.currentTimeMillis();
            int b = m21013b(true);
            if (b == -6) {
                m21010a(false);
            } else if (b == -1) {
                m21010a(true);
            } else if (b == 0) {
                int a = !this.f26537b ? m20989a(this.f26543h) : 0;
                if (a > 0) {
                    SystemUtils.log(4, "LicenseManager", "[updateLicense]CheckLicense fail when update", (Throwable) null, "com.didi.ifx.license.LicenseManager", 15);
                    this.f26557v = false;
                    m20996a(a, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                m21010a(false);
                m20996a(a, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* renamed from: e */
    private void m21028e() {
        this.f26549n.shutdown();
    }

    /* renamed from: c */
    private void m21023c() {
        String str = this.f26542g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[omegaReport]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 30);
            return;
        }
        try {
            String a = C10039a.m21115a(this.f26542g);
            String a2 = C10040b.m21124a(this.f26540e);
            this.f26544i = a2;
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[omegaReport]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 28);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", this.f26544i);
            hashMap.put("sdk_version", "2.1.1");
            m21009a("tech_ifx_report", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "LicenseManager", "[omegaReport]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 29);
        }
    }

    /* renamed from: a */
    private void m20995a() {
        this.f26546k = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
    }

    /* renamed from: a */
    private void m21010a(final boolean z) {
        if (z) {
            if (this.f26555t >= 100) {
                SystemUtils.log(6, "LicenseManager", "[httpUpdate]Your device must in network", (Throwable) null, "com.didi.ifx.license.LicenseManager", 11);
                this.f26557v = false;
                this.f26555t = 0;
                return;
            }
        } else if (this.f26555t >= 100) {
            SystemUtils.log(6, "LicenseManager", "[httpUpdate]Your device must in network", (Throwable) null, "com.didi.ifx.license.LicenseManager", 18);
            this.f26557v = false;
            this.f26555t = 0;
            return;
        }
        String str = this.f26542g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[httpUpdate]License key is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager", 63);
            return;
        }
        String a = C10040b.m21124a(this.f26540e);
        this.f26544i = a;
        if (a == null || a.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[httpUpdate]Device Id is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager", 62);
            return;
        }
        this.f26546k.newCall(new Request.Builder().url(this.f26548m).post(RequestBody.create(this.f26547l, this.f26556u.toJson((Object) new RegisterRequest(this.f26542g, this.f26544i, "android", C10043e.m21132a(), C10043e.m21133b(), C10043e.m21134c(), C10043e.m21135d(), System.currentTimeMillis() / 1000, "2.1.1")))).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                SystemUtils.log(4, "LicenseManager", "[httpUpdate]HTTP response fail with error: " + iOException.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 1);
                LicenseManager.this.m20997a(0, 0, iOException.getMessage());
                LicenseManager.m20990a(LicenseManager.this);
            }

            public void onResponse(Call call, Response response) {
                long currentTimeMillis = System.currentTimeMillis();
                long receivedResponseAtMillis = response.receivedResponseAtMillis() - response.sentRequestAtMillis();
                LicenseManager.this.m21011a(z, receivedResponseAtMillis);
                int unused = LicenseManager.this.f26555t = 0;
                if (response.isSuccessful()) {
                    SystemUtils.log(3, "LicenseManager", "[httpUpdate]HTTP return code: " + response.code() + " msg: " + response.message(), (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 8);
                    if (response.body() == null) {
                        SystemUtils.log(4, "LicenseManager", "[httpUpdate]HTTP response body is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 10);
                        LicenseManager.this.m21008a("IFXLicenseManagerError", new Throwable("[httpUpdate]HTTP response body is empty"));
                        LicenseManager.m20990a(LicenseManager.this);
                        return;
                    }
                    try {
                        RegisterResponse registerResponse = (RegisterResponse) LicenseManager.this.f26556u.fromJson(response.body().string(), RegisterResponse.class);
                        try {
                            long j = registerResponse.get_code();
                            if (j == 20000) {
                                try {
                                    String str = registerResponse.get_license_content();
                                    if (str == null || str.isEmpty()) {
                                        SystemUtils.log(4, "LicenseManager", "[httpUpdate]Json license data is null", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 107);
                                        LicenseManager.this.m21008a("IFXLicenseManagerError", new Throwable("[httpUpdate]Json license data is null"));
                                        LicenseManager.m20990a(LicenseManager.this);
                                        return;
                                    }
                                    try {
                                        LicenseFile licenseFile = (LicenseFile) LicenseManager.this.f26556u.fromJson(str, LicenseFile.class);
                                        int a = !LicenseManager.this.f26537b ? LicenseManager.this.m20989a(licenseFile) : 0;
                                        if (a > 0) {
                                            boolean unused2 = LicenseManager.this.f26557v = false;
                                            LicenseManager.this.m20996a(a, (System.currentTimeMillis() - currentTimeMillis) + receivedResponseAtMillis);
                                            return;
                                        }
                                        LicenseManager.this.m20996a(a, (System.currentTimeMillis() - currentTimeMillis) + receivedResponseAtMillis);
                                        try {
                                            LicenseManager.this.m21021b(registerResponse.get_license_file(), registerResponse.get_sign_data());
                                            long heartbeatTime = licenseFile.getHeartbeatTime();
                                            long heartbeatBias = licenseFile.getHeartbeatBias();
                                            if (heartbeatTime < 0 || heartbeatBias < 0) {
                                                SystemUtils.log(4, "LicenseManager", "[httpUpdate]Heartbeat time from response is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 99);
                                                LicenseManager.this.m21008a("IFXLicenseManagerError", new Throwable("[httpUpdate]Heartbeat time from response is invalid"));
                                                return;
                                            }
                                            if (!(heartbeatTime == LicenseManager.this.f26552q && heartbeatBias == LicenseManager.this.f26553r)) {
                                                long unused3 = LicenseManager.this.f26552q = heartbeatTime;
                                                long unused4 = LicenseManager.this.f26553r = heartbeatBias;
                                                LicenseManager licenseManager = LicenseManager.this;
                                                licenseManager.m21019b(licenseManager.f26551p, LicenseManager.this.f26552q, LicenseManager.this.f26553r);
                                            }
                                            LicenseFile unused5 = LicenseManager.this.f26543h = licenseFile;
                                            long unused6 = LicenseManager.this.f26554s = licenseFile.getUpdateTimestamp();
                                        } catch (Throwable th) {
                                            SystemUtils.log(4, "LicenseManager", "[httpUpdate]Write ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 101);
                                            LicenseManager.this.m21008a("IFXLicenseManagerError", th);
                                            LicenseManager.m20990a(LicenseManager.this);
                                        }
                                    } catch (Throwable th2) {
                                        SystemUtils.log(6, "LicenseManager", "[httpUpdate]Parse json license data fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 104);
                                        LicenseManager.this.m21008a("IFXLicenseManagerError", th2);
                                        LicenseManager.m20990a(LicenseManager.this);
                                    }
                                } catch (Throwable th3) {
                                    SystemUtils.log(4, "LicenseManager", "[httpUpdate]Get resp license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 110);
                                    LicenseManager.this.m21008a("IFXLicenseManagerError", th3);
                                    LicenseManager.m20990a(LicenseManager.this);
                                }
                            } else if (j == 50000) {
                                boolean unused7 = LicenseManager.this.f26557v = false;
                                SystemUtils.log(4, "LicenseManager", "[httpUpdate]HTTP response code is 50000", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 168);
                                LicenseManager.this.m20997a(response.code(), j, registerResponse.get_message());
                                try {
                                    LicenseManager.this.m21007a(registerResponse.get_license_file(), registerResponse.get_sign_data());
                                } catch (Throwable unused8) {
                                    SystemUtils.log(4, "LicenseManager", "[httpUpdate]errorSaveLocal fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 173);
                                    LicenseManager.this.m21008a("IFXLicenseManagerError", new Throwable("[httpUpdate]errorSaveLocal fail"));
                                }
                            } else {
                                SystemUtils.log(4, "LicenseManager", "[httpUpdate]Response with code " + j, (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 179);
                                LicenseManager.this.m20997a(response.code(), j, registerResponse.get_message());
                                LicenseManager.m20990a(LicenseManager.this);
                            }
                        } catch (Throwable th4) {
                            SystemUtils.log(4, "LicenseManager", "[httpUpdate]Get resp code fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 182);
                            LicenseManager.this.m21008a("IFXLicenseManagerError", th4);
                            LicenseManager.m20990a(LicenseManager.this);
                        }
                    } catch (Throwable th5) {
                        SystemUtils.log(4, "LicenseManager", "[httpUpdate]Parse json response body fail", (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 185);
                        LicenseManager.this.m21008a("IFXLicenseManagerError", th5);
                        LicenseManager.m20990a(LicenseManager.this);
                    }
                } else {
                    SystemUtils.log(4, "LicenseManager", "[httpUpdate]HTTP fail with response code " + response.code(), (Throwable) null, "com.didi.ifx.license.LicenseManager$1", 282);
                    LicenseManager licenseManager2 = LicenseManager.this;
                    licenseManager2.m21008a("IFXLicenseManagerError", new Throwable("[httpUpdate]HTTP fail with response code:" + response.code()));
                    LicenseManager.m20990a(LicenseManager.this);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m20989a(LicenseFile licenseFile) {
        String str = this.f26542g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[checkLicense]License key is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager", 38);
            return 1;
        } else if (!licenseFile.getLicenseKey().equals(this.f26542g)) {
            SystemUtils.log(4, "LicenseManager", "[checkLicense]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 19);
            return 1;
        } else {
            String a = C10040b.m21124a(this.f26540e);
            this.f26544i = a;
            if (a == null || a.isEmpty()) {
                SystemUtils.log(4, "LicenseManager", "[checkLicense]Device id is empty", (Throwable) null, "com.didi.ifx.license.LicenseManager", 37);
                return 2;
            } else if (!licenseFile.getDeviceId().equals(this.f26544i)) {
                SystemUtils.log(4, "LicenseManager", "[checkLicense]Device id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 30);
                return 2;
            } else if (System.currentTimeMillis() <= licenseFile.getExpiryTimestamp() * 1000) {
                return 0;
            } else {
                SystemUtils.log(4, "LicenseManager", "[checkLicense]License is beyond expiry", (Throwable) null, "com.didi.ifx.license.LicenseManager", 36);
                return 3;
            }
        }
    }

    public boolean licenseInit(String str, int i) {
        String str2;
        this.f26545j = str;
        String d = m21026d();
        this.f26542g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 56);
            m21008a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f26558w = i;
        if (i == 1) {
            this.f26560y = new InferenceMonitor(this.f26559x);
        }
        this.f26554s = System.currentTimeMillis() / 1000;
        if (this.f26536a) {
            this.f26548m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C10039a.m21121b(this.f26542g + this.f26545j);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 47);
                m21008a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f26541f = str2 + ".ifx.v1.license";
            this.f26556u = new GsonBuilder().create();
            this.f26557v = false;
            this.token = 0;
            m20995a();
            this.f26555t = 0;
        }
        return true;
    }

    public boolean licenseInitWithModelInAssets(String str, int i) {
        String str2;
        this.f26545j = str;
        this.f26538c = true;
        String d = m21026d();
        this.f26542g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 58);
            m21008a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f26558w = i;
        if (i == 1) {
            this.f26560y = new InferenceMonitor(this.f26559x);
        }
        this.f26554s = System.currentTimeMillis() / 1000;
        if (this.f26536a) {
            this.f26548m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C10039a.m21121b(this.f26542g + this.f26545j);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 49);
                m21008a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f26541f = str2 + ".ifx.v1.license";
            this.f26556u = new GsonBuilder().create();
            this.f26557v = false;
            this.token = 0;
            m20995a();
            this.f26555t = 0;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20997a(int i, long j, String str) {
        String str2 = this.f26542g;
        if (str2 == null || str2.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportHttpException]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 69);
            return;
        }
        try {
            String a = C10039a.m21115a(this.f26542g);
            String a2 = C10040b.m21124a(this.f26540e);
            this.f26544i = a2;
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[omegaReportHttpException]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 67);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", this.f26544i);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("status_code", Integer.valueOf(i));
            hashMap.put("code", Long.valueOf(j));
            hashMap.put("message", str);
            m21009a("tech_ifx_report_http_status", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportHttpException]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 68);
        }
    }

    public boolean licenseInit(String str, int i, int i2) {
        String str2;
        this.f26545j = str;
        String d = m21026d();
        this.f26542g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 87);
            m21008a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f26558w = i;
        this.f26559x = i2;
        if (i == 1) {
            this.f26560y = new InferenceMonitor(i2);
        }
        this.f26554s = System.currentTimeMillis() / 1000;
        if (this.f26536a) {
            this.f26548m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C10039a.m21121b(this.f26542g + this.f26545j);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 78);
                m21008a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f26541f = str2 + ".ifx.v1.license";
            this.f26556u = new GsonBuilder().create();
            this.f26557v = false;
            this.token = 0;
            m20995a();
            this.f26555t = 0;
        }
        return true;
    }

    public boolean licenseInitWithModelInAssets(String str, int i, int i2) {
        String str2;
        this.f26545j = str;
        this.f26538c = true;
        String d = m21026d();
        this.f26542g = d;
        if (d == null || d.isEmpty()) {
            SystemUtils.log(4, "LicenseManager", "[licenseInit]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 90);
            m21008a("IFXLicenseManagerError", new Throwable("[licenseInit]Fetch model uuid fail"));
            return false;
        }
        this.f26558w = i;
        this.f26559x = i2;
        if (i == 1) {
            this.f26560y = new InferenceMonitor(i2);
        }
        this.f26554s = System.currentTimeMillis() / 1000;
        if (this.f26536a) {
            this.f26548m = "https://ifx-license.didiglobal.com/v1/license/register";
            try {
                str2 = C10039a.m21121b(this.f26542g + this.f26545j);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[licenseInit]Fetch file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.LicenseManager", 81);
                m21008a("IFXLicenseManagerError", th);
                str2 = "model";
            }
            this.f26541f = str2 + ".ifx.v1.license";
            this.f26556u = new GsonBuilder().create();
            this.f26557v = false;
            this.token = 0;
            m20995a();
            this.f26555t = 0;
        }
        return true;
    }

    /* renamed from: a */
    private void m20998a(long j) {
        if (j != -666) {
            if (this.f26558w != 0) {
                SystemUtils.log(4, "LicenseManager", "[singleInferenceReport]Please use inferenceStatics instead", (Throwable) null, "com.didi.ifx.license.LicenseManager", 65);
                return;
            }
            String str = this.f26542g;
            if (str == null || str.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[singleInferenceReport]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 110);
                return;
            }
            try {
                String a = C10039a.m21115a(this.f26542g);
                String a2 = C10040b.m21124a(this.f26540e);
                this.f26544i = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, "LicenseManager", "[singleInferenceReport]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 108);
                    return;
                }
                int i = 100;
                if (j < 0) {
                    i = j == -9 ? 101 : j == -1 ? 102 : j == -3 ? 104 : 109;
                }
                if (j > 30000) {
                    j = -8;
                    i = 108;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("license_key_checksum", a);
                hashMap.put("device_id", this.f26544i);
                hashMap.put("sdk_version", "2.1.1");
                hashMap.put("inference_time", Long.valueOf(j));
                hashMap.put("code", Integer.valueOf(i));
                m21009a("tech_ifx_report_inference", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                SystemUtils.log(6, "LicenseManager", "[singleInferenceReport]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 109);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21011a(boolean z, long j) {
        String str = this.f26542g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportNetworkLatency]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 99);
            return;
        }
        try {
            String a = C10039a.m21115a(this.f26542g);
            String a2 = C10040b.m21124a(this.f26540e);
            this.f26544i = a2;
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[omegaReportNetworkLatency]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 97);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", this.f26544i);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("first_register", Boolean.valueOf(z));
            hashMap.put("latency", Long.valueOf(j));
            m21009a("tech_ifx_report_http_latency", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportNetworkLatency]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 98);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20996a(int i, long j) {
        String str = this.f26542g;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportLicenseCheck]License key is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 156);
            return;
        }
        try {
            String a = C10039a.m21115a(this.f26542g);
            String a2 = C10040b.m21124a(this.f26540e);
            this.f26544i = a2;
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "LicenseManager", "[omegaReportLicenseCheck]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.LicenseManager", 154);
                return;
            }
            int i2 = 200;
            boolean z = false;
            boolean z2 = true;
            if (i > 0) {
                i2 = i != 1 ? i != 2 ? i != 3 ? 209 : 203 : 202 : 201;
                z2 = false;
            }
            if (j > 30000) {
                j = -8;
                i2 = 208;
            } else {
                z = z2;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", this.f26544i);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("pass_check", Boolean.valueOf(z));
            hashMap.put("check_time", Long.valueOf(j));
            hashMap.put("code", Integer.valueOf(i2));
            m21009a("tech_ifx_report_check_license", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "LicenseManager", "[omegaReportLicenseCheck]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.LicenseManager", 155);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21021b(String str, String str2) {
        byte[] bytes = str.getBytes();
        byte[] bytes2 = str2.getBytes();
        int length = bytes.length;
        FileOutputStream openFileOutput = this.f26540e.openFileOutput(this.f26541f, 0);
        openFileOutput.write(C10039a.m21119a(length));
        openFileOutput.write(bytes);
        openFileOutput.write(bytes2);
        openFileOutput.write(C10039a.m21119a(616));
        openFileOutput.close();
    }

    /* renamed from: a */
    private void m20999a(long j, long j2, long j3) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f26549n = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(j3), j, j2, TimeUnit.SECONDS);
        SystemUtils.log(3, "LicenseManager", "[startHeartBeat]With delay " + j + " base " + j2 + " and bias " + j3, (Throwable) null, "com.didi.ifx.license.LicenseManager", 123);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21009a(String str, Map<String, Object> map) {
        if (this.f26539d) {
            IFXTrackCallback iFXTrackCallback = this.f26561z;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackEvent(str, map);
                return;
            }
            return;
        }
        OmegaSDKAdapter.trackEvent(str, map);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21008a(String str, Throwable th) {
        if (this.f26539d) {
            IFXTrackCallback iFXTrackCallback = this.f26561z;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackError(str, th);
                return;
            }
            return;
        }
        OmegaSDK.trackError(str, th);
    }

    /* renamed from: b */
    private int m21013b(boolean z) {
        try {
            FileInputStream openFileInput = this.f26540e.openFileInput(this.f26541f);
            if (openFileInput == null) {
                SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Open ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 177);
                m21008a("IFXLicenseManagerError", new Throwable("[fetchLocalLicenseInfo]Open ifx license fail"));
                return -2;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openFileInput);
            try {
                int available = bufferedInputStream.available();
                int i = available - 4;
                try {
                    bufferedInputStream.mark(i);
                    bufferedInputStream.skip((long) i);
                    byte[] bArr = new byte[4];
                    try {
                        bufferedInputStream.read(bArr, 0, 4);
                        bufferedInputStream.reset();
                        if (C10039a.m21114a(bArr, 0) != 616) {
                            SystemUtils.log(4, "LicenseManager", "[fetchLocalLicenseInfo]Find ifx.license broken", (Throwable) null, "com.didi.ifx.license.LicenseManager", 215);
                            return -6;
                        }
                        byte[] bArr2 = new byte[4];
                        try {
                            bufferedInputStream.read(bArr2, 0, 4);
                            int a = C10039a.m21114a(bArr2, 0);
                            byte[] bArr3 = new byte[a];
                            try {
                                bufferedInputStream.read(bArr3, 0, a);
                                int i2 = (available - a) - 8;
                                byte[] bArr4 = new byte[i2];
                                try {
                                    bufferedInputStream.read(bArr4, 0, i2);
                                    String a2 = C10039a.m21116a(bArr4);
                                    try {
                                        bufferedInputStream.close();
                                        try {
                                            byte[] b = C10039a.m21122b(bArr3);
                                            try {
                                                LicenseFile licenseFile = (LicenseFile) this.f26556u.fromJson(C10039a.m21116a(b), LicenseFile.class);
                                                try {
                                                    if (!C10042d.m21131a(b, licenseFile.getPublicKey(), a2)) {
                                                        SystemUtils.log(4, "LicenseManager", "[fetchLocalLicenseInfo]Verify license not pass", (Throwable) null, "com.didi.ifx.license.LicenseManager", 290);
                                                        return -4;
                                                    }
                                                    this.f26543h = licenseFile;
                                                    this.f26554s = licenseFile.getUpdateTimestamp();
                                                    if (!z) {
                                                        long heartbeatTime = this.f26543h.getHeartbeatTime();
                                                        if (heartbeatTime >= 0) {
                                                            this.f26552q = heartbeatTime;
                                                        }
                                                        long heartbeatBias = this.f26543h.getHeartbeatBias();
                                                        if (heartbeatBias >= 0) {
                                                            this.f26553r = heartbeatBias;
                                                        }
                                                    }
                                                    return 0;
                                                } catch (Throwable th) {
                                                    SystemUtils.log(4, "LicenseManager", "[fetchLocalLicenseInfo]Verify license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 306);
                                                    m21008a("IFXLicenseManagerError", th);
                                                    return -3;
                                                }
                                            } catch (Throwable th2) {
                                                SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Parse license file info fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 308);
                                                m21008a("IFXLicenseManagerError", th2);
                                                return -3;
                                            }
                                        } catch (Throwable th3) {
                                            SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Decode license data fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 310);
                                            m21008a("IFXLicenseManagerError", th3);
                                            return -3;
                                        }
                                    } catch (Throwable th4) {
                                        SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Close ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 312);
                                        m21008a("IFXLicenseManagerError", th4);
                                        return -2;
                                    }
                                } catch (Throwable th5) {
                                    SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read signature in ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 314);
                                    m21008a("IFXLicenseManagerError", th5);
                                    return -2;
                                }
                            } catch (Throwable th6) {
                                SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read license content in ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 316);
                                m21008a("IFXLicenseManagerError", th6);
                                return -2;
                            }
                        } catch (Throwable th7) {
                            SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read license content in ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 318);
                            m21008a("IFXLicenseManagerError", th7);
                            return -2;
                        }
                    } catch (Throwable th8) {
                        SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 320);
                        m21008a("IFXLicenseManagerError", th8);
                        return -2;
                    }
                } catch (Throwable th9) {
                    SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read ifx.license fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 322);
                    m21008a("IFXLicenseManagerError", th9);
                    return -2;
                }
            } catch (IOException e) {
                SystemUtils.log(6, "LicenseManager", "[fetchLocalLicenseInfo]Read ifx.license size fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 324);
                m21008a("IFXLicenseManagerError", (Throwable) e);
                return -2;
            }
        } catch (FileNotFoundException unused) {
            SystemUtils.log(4, "LicenseManager", "[fetchLocalLicenseInfo]File ifx.license does not exist", (Throwable) null, "com.didi.ifx.license.LicenseManager", 326);
            return -1;
        }
    }

    /* renamed from: d */
    private String m21026d() {
        InputStream inputStream;
        try {
            if (this.f26538c) {
                inputStream = this.f26540e.getAssets().open(this.f26545j);
            } else {
                inputStream = new FileInputStream(this.f26545j);
            }
            try {
                C10039a.m21113a(inputStream);
                try {
                    if (C10039a.m21113a(inputStream) % 100 != C10039a.f26636g) {
                        this.f26537b = true;
                        return "b3b9ca1474334e85a2baf43be1ac3595";
                    }
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (i < 4) {
                        try {
                            sb.append(String.format("%08x", new Object[]{Integer.valueOf(C10039a.m21113a(inputStream))}));
                            i++;
                        } catch (Throwable th) {
                            SystemUtils.log(4, "LicenseManager", "[fetchModelUuid]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 372);
                            m21008a("IFXLicenseManagerError", th);
                            return null;
                        }
                    }
                    return sb.toString();
                } catch (Throwable th2) {
                    SystemUtils.log(4, "LicenseManager", "[fetchModelUuid]Fetch model version fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 380);
                    m21008a("IFXLicenseManagerError", th2);
                    return null;
                }
            } catch (Throwable th3) {
                SystemUtils.log(4, "LicenseManager", "[fetchModelUuid]Fetch framework version fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 382);
                m21008a("IFXLicenseManagerError", th3);
                return null;
            }
        } catch (Throwable th4) {
            SystemUtils.log(4, "LicenseManager", "[fetchModelUuid]Open model file fail", (Throwable) null, "com.didi.ifx.license.LicenseManager", 384);
            m21008a("IFXLicenseManagerError", th4);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21007a(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        FileOutputStream openFileOutput = this.f26540e.openFileOutput(this.f26541f, 0);
        openFileOutput.write(C10039a.m21119a(length));
        openFileOutput.write(C10039a.m21120b(length).getBytes());
        openFileOutput.write(C10039a.m21120b(length2).getBytes());
        int a = C10039a.m21111a();
        if (a % 2 == 0) {
            a++;
        }
        openFileOutput.write(C10039a.m21119a(a));
        openFileOutput.close();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21019b(long j, long j2, long j3) {
        this.f26549n.shutdown();
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f26549n = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(j3), j, j2, TimeUnit.SECONDS);
        SystemUtils.log(3, "LicenseManager", "[resetHeartBeat]With delay " + j + " base " + j2 + " and bias " + j3, (Throwable) null, "com.didi.ifx.license.LicenseManager", 401);
    }

    /* renamed from: b */
    private void m21018b(long j) {
        if (this.f26558w != 1) {
            SystemUtils.log(4, "LicenseManager", "[inferenceStatics]Please use omegaReportInference instead", (Throwable) null, "com.didi.ifx.license.LicenseManager", 403);
            return;
        }
        InferenceMonitor inferenceMonitor = this.f26560y;
        if (inferenceMonitor == null) {
            SystemUtils.log(4, "LicenseManager", "[inferenceStatics]InferenceMonitor is not initialized", (Throwable) null, "com.didi.ifx.license.LicenseManager", 407);
        } else {
            inferenceMonitor.m21036(j);
        }
    }
}
