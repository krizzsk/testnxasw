package com.didi.ifx.license;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
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

public class MultiLicenseManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f26579a = "MultiLicenseManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f26580b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f26581c;

    /* renamed from: d */
    private boolean f26582d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f26583e;

    /* renamed from: f */
    private int f26584f;

    /* renamed from: g */
    private MultiLicense[] f26585g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f26586h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f26587i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f26588j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f26589k;

    /* renamed from: l */
    private IFXTrackCallback f26590l;
    private long token;

    private class MultiLicense {
        /* access modifiers changed from: private */

        /* renamed from: ቮ */
        public String f26591;
        /* access modifiers changed from: private */

        /* renamed from: ᡆ */
        public boolean f26592;
        /* access modifiers changed from: private */

        /* renamed from: ᬪ */
        public long f26593;

        /* renamed from: Ṉ */
        private ScheduledExecutorService f26594;

        /* renamed from: ᾖ */
        private String f26595;
        /* access modifiers changed from: private */

        /* renamed from: ㄲ */
        public LicenseFile f26596;

        /* renamed from: 㑝 */
        private InferenceMonitor f26597;
        /* access modifiers changed from: private */

        /* renamed from: 㕴 */
        public long f26598;
        /* access modifiers changed from: private */

        /* renamed from: 㡼 */
        public long f26599;
        /* access modifiers changed from: private */

        /* renamed from: 㫨 */
        public int f26600;
        /* access modifiers changed from: private */

        /* renamed from: 䞂 */
        public boolean f26601;
        /* access modifiers changed from: private */

        /* renamed from: 䞦 */
        public String f26602;
        /* access modifiers changed from: private */

        /* renamed from: 䠰 */
        public long f26603;

        /* renamed from: 䧁 */
        private final MediaType f26604;

        /* renamed from: 䫅 */
        private OkHttpClient f26605;

        /* renamed from: 䳷 */
        private int f26606;

        /* renamed from: 侷 */
        private long f26608;
        /* access modifiers changed from: private */

        /* renamed from: 俛 */
        public Gson f26609;

        /* renamed from: 偡 */
        private String f26610;
        /* access modifiers changed from: private */

        /* renamed from: 儵 */
        public String f26611;

        private class HeartBeat implements Runnable {

            /* renamed from: 䞂 */
            private long f26614;

            HeartBeat(long j) {
                this.f26614 = j;
            }

            public void run() {
                try {
                    Thread.sleep(((long) new Random().nextInt((int) this.f26614)) * 1000);
                } catch (InterruptedException e) {
                    String a = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(6, a, "[HeartBeat]Heartbeat of " + MultiLicense.this.f26611 + ": " + e.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$HeartBeat", 5);
                    MultiLicenseManager.this.m21046a("IFXLicenseManagerError", (Throwable) e);
                    Thread.currentThread().interrupt();
                }
                MultiLicense.this.m21061();
            }
        }

        private class InferenceMonitor {

            /* renamed from: ቮ */
            private int f26616;

            /* renamed from: ᡆ */
            private int f26617;

            /* renamed from: ᾖ */
            private int f26619;

            /* renamed from: ㄲ */
            private int f26620;

            /* renamed from: 䞂 */
            private ScheduledExecutorService f26621;

            /* renamed from: 䞦 */
            private int f26622;

            /* renamed from: 䧁 */
            private long f26623;

            /* renamed from: 䫅 */
            private long f26624;

            /* renamed from: 䳷 */
            private int f26625;

            /* renamed from: 偡 */
            private long f26626;

            /* renamed from: 儵 */
            private int f26627;

            InferenceMonitor(int i) {
                m21105();
                this.f26617 = i;
                ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                this.f26621 = newSingleThreadScheduledExecutor;
                C100301 r1 = new Runnable(MultiLicense.this) {
                    public void run() {
                        InferenceMonitor.this.m21109();
                    }
                };
                long j = (long) this.f26617;
                newSingleThreadScheduledExecutor.scheduleWithFixedDelay(r1, j, j, TimeUnit.MINUTES);
            }

            /* access modifiers changed from: private */
            /* renamed from: ቮ */
            public synchronized void m21104() {
                ScheduledExecutorService scheduledExecutorService = this.f26621;
                if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                    if (this.f26626 > 0) {
                        m21109();
                    }
                    this.f26621.shutdown();
                }
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0132=Splitter:B:32:0x0132, B:23:0x00f4=Splitter:B:23:0x00f4} */
            /* renamed from: 偡 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized void m21109() {
                /*
                    r8 = this;
                    monitor-enter(r8)
                    long r0 = r8.f26626     // Catch:{ all -> 0x0147 }
                    r2 = 0
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 != 0) goto L_0x000e
                    r8.m21105()     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x000e:
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = r0.f26591     // Catch:{ all -> 0x0147 }
                    if (r0 == 0) goto L_0x0132
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = r0.f26591     // Catch:{ all -> 0x0147 }
                    boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0147 }
                    if (r0 == 0) goto L_0x0024
                    goto L_0x0132
                L_0x0024:
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0109 }
                    java.lang.String r0 = r0.f26591     // Catch:{ all -> 0x0109 }
                    java.lang.String r0 = com.didi.ifx.license.C10039a.m21115a((java.lang.String) r0)     // Catch:{ all -> 0x0109 }
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r1 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r2 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    android.content.Context r2 = r2.f26583e     // Catch:{ all -> 0x0147 }
                    java.lang.String r2 = com.didi.ifx.license.C10040b.m21124a((android.content.Context) r2)     // Catch:{ all -> 0x0147 }
                    java.lang.String unused = r1.f26602 = r2     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r1 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = r1.f26602     // Catch:{ all -> 0x0147 }
                    if (r1 == 0) goto L_0x00f4
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r1 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = r1.f26602     // Catch:{ all -> 0x0147 }
                    boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0147 }
                    if (r1 == 0) goto L_0x0053
                    goto L_0x00f4
                L_0x0053:
                    long r1 = r8.f26623     // Catch:{ all -> 0x0147 }
                    double r1 = (double) r1     // Catch:{ all -> 0x0147 }
                    long r3 = r8.f26624     // Catch:{ all -> 0x0147 }
                    double r3 = (double) r3     // Catch:{ all -> 0x0147 }
                    double r1 = r1 / r3
                    r3 = 4652007308841189376(0x408f400000000000, double:1000.0)
                    double r1 = r1 * r3
                    long r1 = java.lang.Math.round(r1)     // Catch:{ all -> 0x0147 }
                    double r1 = (double) r1     // Catch:{ all -> 0x0147 }
                    double r1 = r1 / r3
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0147 }
                    r3.<init>()     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = "license_key_checksum"
                    r3.put(r4, r0)     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = r0.f26602     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = "device_id"
                    r3.put(r4, r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = "sdk_version"
                    java.lang.String r4 = "2.1.1"
                    r3.put(r0, r4)     // Catch:{ all -> 0x0147 }
                    long r4 = r8.f26626     // Catch:{ all -> 0x0147 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = "inference_cnt"
                    r3.put(r4, r0)     // Catch:{ all -> 0x0147 }
                    long r4 = r8.f26624     // Catch:{ all -> 0x0147 }
                    java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = "inference_success_cnt"
                    r3.put(r4, r0)     // Catch:{ all -> 0x0147 }
                    java.lang.Double r0 = java.lang.Double.valueOf(r1)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "inference_avg"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f26616     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_100_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f26620     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_101_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f26622     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_102_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f26625     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_104_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f26619     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_108_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    int r0 = r8.f26627     // Catch:{ all -> 0x0147 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "code_109_cnt"
                    r3.put(r1, r0)     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r0 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r1 = "tech_ifx_report_inference_agg"
                    r0.m21047a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r3)     // Catch:{ all -> 0x0147 }
                    r8.m21105()     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x00f4:
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r0 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r2 = r0.f26579a     // Catch:{ all -> 0x0147 }
                    java.lang.String r3 = "[InferenceMonitor]Device Id is invalid"
                    r1 = 6
                    r4 = 0
                    java.lang.String r5 = "com.didi.ifx.license.MultiLicenseManager$MultiLicense$InferenceMonitor"
                    r6 = 46
                    com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x0109:
                    r0 = move-exception
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r1 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r1 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r3 = r1.f26579a     // Catch:{ all -> 0x0147 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0147 }
                    r1.<init>()     // Catch:{ all -> 0x0147 }
                    java.lang.String r2 = "[InferenceMonitor]Fetch license key checksum fail: "
                    r1.append(r2)     // Catch:{ all -> 0x0147 }
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0147 }
                    r1.append(r0)     // Catch:{ all -> 0x0147 }
                    java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0147 }
                    r2 = 6
                    r5 = 0
                    java.lang.String r6 = "com.didi.ifx.license.MultiLicenseManager$MultiLicense$InferenceMonitor"
                    r7 = 47
                    com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x0132:
                    com.didi.ifx.license.MultiLicenseManager$MultiLicense r0 = com.didi.ifx.license.MultiLicenseManager.MultiLicense.this     // Catch:{ all -> 0x0147 }
                    com.didi.ifx.license.MultiLicenseManager r0 = com.didi.ifx.license.MultiLicenseManager.this     // Catch:{ all -> 0x0147 }
                    java.lang.String r2 = r0.f26579a     // Catch:{ all -> 0x0147 }
                    java.lang.String r3 = "[InferenceMonitor]License key is invalid"
                    r1 = 6
                    r4 = 0
                    java.lang.String r5 = "com.didi.ifx.license.MultiLicenseManager$MultiLicense$InferenceMonitor"
                    r6 = 48
                    com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0147 }
                    monitor-exit(r8)
                    return
                L_0x0147:
                    r0 = move-exception
                    monitor-exit(r8)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.MultiLicenseManager.MultiLicense.InferenceMonitor.m21109():void");
            }

            /* renamed from: 䞂 */
            private void m21105() {
                this.f26626 = 0;
                this.f26616 = 0;
                this.f26620 = 0;
                this.f26622 = 0;
                this.f26625 = 0;
                this.f26619 = 0;
                this.f26627 = 0;
                this.f26624 = 0;
                this.f26623 = 0;
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
                return;
             */
            /* renamed from: 䞂 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized void m21106(long r8) {
                /*
                    r7 = this;
                    monitor-enter(r7)
                    r0 = -666(0xfffffffffffffd66, double:NaN)
                    int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                    if (r2 != 0) goto L_0x0009
                    monitor-exit(r7)
                    return
                L_0x0009:
                    long r0 = r7.f26626     // Catch:{ all -> 0x006a }
                    r2 = 1
                    long r0 = r0 + r2
                    r7.f26626 = r0     // Catch:{ all -> 0x006a }
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
                    int r8 = r7.f26620     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f26620 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x002c:
                    r0 = -1
                    int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                    if (r2 != 0) goto L_0x0039
                    int r8 = r7.f26622     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f26622 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x0039:
                    r0 = -3
                    int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                    if (r2 != 0) goto L_0x0046
                    int r8 = r7.f26625     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f26625 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x0046:
                    int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                    if (r0 != 0) goto L_0x0051
                    int r8 = r7.f26619     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f26619 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x0051:
                    int r8 = r7.f26627     // Catch:{ all -> 0x006a }
                    int r8 = r8 + 1
                    r7.f26627 = r8     // Catch:{ all -> 0x006a }
                    goto L_0x0068
                L_0x0058:
                    int r0 = r7.f26616     // Catch:{ all -> 0x006a }
                    int r0 = r0 + 1
                    r7.f26616 = r0     // Catch:{ all -> 0x006a }
                    long r0 = r7.f26624     // Catch:{ all -> 0x006a }
                    long r0 = r0 + r2
                    r7.f26624 = r0     // Catch:{ all -> 0x006a }
                    long r0 = r7.f26623     // Catch:{ all -> 0x006a }
                    long r0 = r0 + r8
                    r7.f26623 = r0     // Catch:{ all -> 0x006a }
                L_0x0068:
                    monitor-exit(r7)
                    return
                L_0x006a:
                    r8 = move-exception
                    monitor-exit(r7)
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.MultiLicenseManager.MultiLicense.InferenceMonitor.m21106(long):void");
            }
        }

        private MultiLicense() {
            this.f26604 = MediaType.parse("application/json; charset=utf-8");
            this.f26608 = 2;
            this.f26598 = 5;
            this.f26603 = 15;
            this.f26593 = 5;
        }

        /* access modifiers changed from: private */
        /* renamed from: ᾖ */
        public void m21061() {
            m21087();
            if (MultiLicenseManager.this.f26580b && System.currentTimeMillis() >= this.f26599 * 1000) {
                long currentTimeMillis = System.currentTimeMillis();
                int r3 = m21069(true);
                if (r3 == -6) {
                    m21101(false);
                } else if (r3 == -1) {
                    m21101(true);
                } else if (r3 == 0) {
                    int r2 = !this.f26601 ? m21065(this.f26596) : 0;
                    if (r2 > 0) {
                        String a = MultiLicenseManager.this.f26579a;
                        SystemUtils.log(4, a, "[updateLicense]CheckLicense fail during update when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 15);
                        boolean unused = MultiLicenseManager.this.f26586h = false;
                        m21073(r2, System.currentTimeMillis() - currentTimeMillis);
                        return;
                    }
                    m21101(false);
                    m21073(r2, System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }

        /* renamed from: 䞦 */
        private void m21087() {
            String str = this.f26591;
            if (str == null || str.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[omegaReport]License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 29);
                return;
            }
            try {
                String a = C10039a.m21115a(this.f26591);
                String a2 = C10040b.m21124a(MultiLicenseManager.this.f26583e);
                this.f26602 = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[omegaReport]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 27);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("license_key_checksum", a);
                hashMap.put("device_id", this.f26602);
                hashMap.put("sdk_version", "2.1.1");
                MultiLicenseManager.this.m21047a("tech_ifx_report", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                String a3 = MultiLicenseManager.this.f26579a;
                SystemUtils.log(6, a3, "[omegaReport]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 28);
            }
        }

        /* renamed from: 䳷 */
        private void m21092() {
            this.f26594.shutdown();
        }

        /* access modifiers changed from: private */
        /* renamed from: 儵 */
        public boolean m21103() {
            m21087();
            if (MultiLicenseManager.this.f26580b) {
                long currentTimeMillis = System.currentTimeMillis();
                int r3 = m21069(false);
                if (r3 == -6) {
                    String a = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(4, a, "[verifyLicense]License file is broken and need pulled from server when process " + this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 36);
                    m21098(this.f26608, this.f26603, this.f26593);
                    return true;
                } else if (r3 == -4) {
                    String a2 = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(4, a2, "[verifyLicense]License file may be modified illegally when process " + this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 32);
                    return false;
                } else if (r3 == -3) {
                    String a3 = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(4, a3, "[verifyLicense]Decode license file fail when process" + this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 29);
                    return false;
                } else if (r3 == -2) {
                    String a4 = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(4, a4, "[verifyLicense]Read license file fail when process " + this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 26);
                    return false;
                } else if (r3 == -1) {
                    m21098(this.f26608, this.f26603, this.f26593);
                    return true;
                } else if (r3 != 0) {
                    String a5 = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(6, a5, "[verifyLicense]Fetch local license fail when process " + this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 7);
                    return false;
                } else {
                    int r32 = !this.f26601 ? m21065(this.f26596) : 0;
                    if (r32 > 0) {
                        String a6 = MultiLicenseManager.this.f26579a;
                        SystemUtils.log(6, a6, "[verifyLicense]CheckLicense fail when process" + this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 15);
                        m21073(r32, System.currentTimeMillis() - currentTimeMillis);
                        return false;
                    }
                    m21073(r32, System.currentTimeMillis() - currentTimeMillis);
                    m21098(this.f26608, this.f26603, this.f26593);
                    return true;
                }
            } else {
                m21098(this.f26608, this.f26603, this.f26593);
                return true;
            }
        }

        /* renamed from: ቮ */
        private void m21057() {
            this.f26605 = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
        }

        /* access modifiers changed from: private */
        /* renamed from: ㄲ */
        public void m21062() {
            m21092();
            InferenceMonitor inferenceMonitor = this.f26597;
            if (inferenceMonitor != null) {
                inferenceMonitor.m21104();
            }
        }

        /* renamed from: 䞂 */
        static /* synthetic */ int m21066(MultiLicense multiLicense) {
            int i = multiLicense.f26600;
            multiLicense.f26600 = i + 1;
            return i;
        }

        /* renamed from: 偡 */
        private void m21101(final boolean z) {
            if (z) {
                if (this.f26600 >= 100) {
                    SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[httpUpdate]Your device must in network", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 6);
                    this.f26600 = 0;
                    return;
                }
            } else if (this.f26600 >= 100) {
                SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[httpUpdate]Your device must in network", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 13);
                this.f26600 = 0;
                return;
            }
            String str = this.f26591;
            if (str == null || str.isEmpty()) {
                String a = MultiLicenseManager.this.f26579a;
                SystemUtils.log(6, a, "[httpUpdate]License key is empty when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 58);
                return;
            }
            String a2 = C10040b.m21124a(MultiLicenseManager.this.f26583e);
            this.f26602 = a2;
            if (a2 == null || a2.isEmpty()) {
                String a3 = MultiLicenseManager.this.f26579a;
                SystemUtils.log(6, a3, "[httpUpdate]Device Id is empty when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 57);
                return;
            }
            this.f26605.newCall(new Request.Builder().url(MultiLicenseManager.this.f26587i).post(RequestBody.create(this.f26604, this.f26609.toJson((Object) new RegisterRequest(this.f26591, this.f26602, "android", C10043e.m21132a(), C10043e.m21133b(), C10043e.m21134c(), C10043e.m21135d(), System.currentTimeMillis() / 1000, "2.1.1")))).build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    String a = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(4, a, "[httpUpdate]HTTP response fail with error: " + iOException.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 1);
                    MultiLicense.this.m21074(0, 0, iOException.getMessage());
                    MultiLicense.m21066(MultiLicense.this);
                }

                public void onResponse(Call call, Response response) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long receivedResponseAtMillis = response.receivedResponseAtMillis() - response.sentRequestAtMillis();
                    MultiLicense.this.m21083(z, receivedResponseAtMillis);
                    int unused = MultiLicense.this.f26600 = 0;
                    if (response.isSuccessful()) {
                        String a = MultiLicenseManager.this.f26579a;
                        SystemUtils.log(3, a, "[httpUpdate]HTTP return code: " + response.code() + " msg: " + response.message(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 8);
                        if (response.body() == null) {
                            SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[httpUpdate]HTTP response body is empty", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 10);
                            MultiLicenseManager.this.m21046a("IFXLicenseManagerError", new Throwable("[httpUpdate]HTTP response body is empty"));
                            MultiLicense.m21066(MultiLicense.this);
                            return;
                        }
                        try {
                            RegisterResponse registerResponse = (RegisterResponse) MultiLicense.this.f26609.fromJson(response.body().string(), RegisterResponse.class);
                            try {
                                long j = registerResponse.get_code();
                                if (j == 20000) {
                                    try {
                                        String str = registerResponse.get_license_content();
                                        if (str == null || str.isEmpty()) {
                                            String a2 = MultiLicenseManager.this.f26579a;
                                            SystemUtils.log(4, a2, "[httpUpdate]Json license data is null when process " + MultiLicense.this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 110);
                                            MultiLicenseManager multiLicenseManager = MultiLicenseManager.this;
                                            multiLicenseManager.m21046a("IFXLicenseManagerError", new Throwable("[httpUpdate]Json license data is null when process " + MultiLicense.this.f26611));
                                            MultiLicense.m21066(MultiLicense.this);
                                            return;
                                        }
                                        try {
                                            LicenseFile licenseFile = (LicenseFile) MultiLicense.this.f26609.fromJson(str, LicenseFile.class);
                                            int r9 = !MultiLicense.this.f26601 ? MultiLicense.this.m21065(licenseFile) : 0;
                                            if (r9 > 0) {
                                                boolean unused2 = MultiLicenseManager.this.f26586h = false;
                                                MultiLicense.this.m21073(r9, (System.currentTimeMillis() - currentTimeMillis) + receivedResponseAtMillis);
                                                return;
                                            }
                                            MultiLicense.this.m21073(r9, (System.currentTimeMillis() - currentTimeMillis) + receivedResponseAtMillis);
                                            try {
                                                MultiLicense.this.m21100(registerResponse.get_license_file(), registerResponse.get_sign_data());
                                                long heartbeatTime = licenseFile.getHeartbeatTime();
                                                long heartbeatBias = licenseFile.getHeartbeatBias();
                                                if (heartbeatTime < 0 || heartbeatBias < 0) {
                                                    String a3 = MultiLicenseManager.this.f26579a;
                                                    SystemUtils.log(4, a3, "[httpUpdate]Heartbeat time from response is invalid when process " + MultiLicense.this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 100);
                                                    MultiLicenseManager multiLicenseManager2 = MultiLicenseManager.this;
                                                    multiLicenseManager2.m21046a("IFXLicenseManagerError", new Throwable("[httpUpdate]Heartbeat time from response is invalid when process " + MultiLicense.this.f26611));
                                                    return;
                                                }
                                                if (!(heartbeatTime == MultiLicense.this.f26603 && heartbeatBias == MultiLicense.this.f26593)) {
                                                    long unused3 = MultiLicense.this.f26603 = heartbeatTime;
                                                    long unused4 = MultiLicense.this.f26593 = heartbeatBias;
                                                    MultiLicense multiLicense = MultiLicense.this;
                                                    multiLicense.m21076(multiLicense.f26598, MultiLicense.this.f26603, MultiLicense.this.f26593);
                                                }
                                                LicenseFile unused5 = MultiLicense.this.f26596 = licenseFile;
                                                long unused6 = MultiLicense.this.f26599 = licenseFile.getUpdateTimestamp();
                                                boolean unused7 = MultiLicense.this.f26592 = false;
                                            } catch (Throwable th) {
                                                String a4 = MultiLicenseManager.this.f26579a;
                                                SystemUtils.log(6, a4, "[httpUpdate]Write ifx.license fail when process " + MultiLicense.this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 104);
                                                MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th);
                                                MultiLicense.m21066(MultiLicense.this);
                                            }
                                        } catch (Throwable th2) {
                                            String a5 = MultiLicenseManager.this.f26579a;
                                            SystemUtils.log(6, a5, "[httpUpdate]Parse json license data fail when process " + MultiLicense.this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 107);
                                            MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th2);
                                            MultiLicense.m21066(MultiLicense.this);
                                        }
                                    } catch (Throwable th3) {
                                        Throwable th4 = th3;
                                        String a6 = MultiLicenseManager.this.f26579a;
                                        SystemUtils.log(4, a6, "[httpUpdate]Get resp license fail when process " + MultiLicense.this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 113);
                                        MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th4);
                                        MultiLicense.m21066(MultiLicense.this);
                                    }
                                } else if (j == 50000) {
                                    boolean unused8 = MultiLicenseManager.this.f26586h = false;
                                    SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[httpUpdate]HTTP response with code 50000", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 174);
                                    MultiLicense.this.m21074(response.code(), j, registerResponse.get_message());
                                    try {
                                        MultiLicense.this.m21082(registerResponse.get_license_file(), registerResponse.get_sign_data());
                                    } catch (Throwable unused9) {
                                        SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[httpUpdate]ErrorSaveLocal fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 179);
                                        MultiLicenseManager.this.m21046a("IFXLicenseManagerError", new Throwable("[httpUpdate]ErrorSaveLocal fail"));
                                    }
                                } else {
                                    String a7 = MultiLicenseManager.this.f26579a;
                                    SystemUtils.log(4, a7, "[httpUpdate]Response with code " + j, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 185);
                                    MultiLicense.this.m21074(response.code(), j, registerResponse.get_message());
                                    MultiLicense.m21066(MultiLicense.this);
                                }
                            } catch (Throwable th5) {
                                SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[httpUpdate]Get resp code fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 188);
                                MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th5);
                                MultiLicense.m21066(MultiLicense.this);
                            }
                        } catch (Throwable th6) {
                            SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[httpUpdate]Parse json response body fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 191);
                            MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th6);
                            MultiLicense.m21066(MultiLicense.this);
                        }
                    } else {
                        String a8 = MultiLicenseManager.this.f26579a;
                        SystemUtils.log(4, a8, "[httpUpdate]HTTP fail with response code " + response.code(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense$1", 291);
                        MultiLicenseManager multiLicenseManager3 = MultiLicenseManager.this;
                        multiLicenseManager3.m21046a("IFXLicenseManagerError", new Throwable("[httpUpdate]HTTP fail with response code " + response.code()));
                        MultiLicense.m21066(MultiLicense.this);
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public boolean m21086(String str, int i, int i2) {
            this.f26601 = false;
            this.f26606 = i2;
            this.f26595 = str;
            this.f26611 = "models[" + i + Const.jaRight;
            String r9 = m21071();
            this.f26591 = r9;
            if (r9 == null || r9.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[licenseInit]Fetch " + this.f26611 + " license key fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 47);
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.f26599 = currentTimeMillis;
            this.f26599 = currentTimeMillis + (((long) this.f26606) * 60);
            if (MultiLicenseManager.this.f26588j == 1) {
                this.f26597 = new InferenceMonitor(MultiLicenseManager.this.f26589k);
            }
            if (MultiLicenseManager.this.f26580b) {
                String unused = MultiLicenseManager.this.f26587i = "https://ifx-license.didiglobal.com/v1/license/register";
                this.f26592 = true;
                this.f26609 = new GsonBuilder().create();
                m21057();
                this.f26600 = 0;
                String str2 = "model" + this.f26611;
                try {
                    this.f26610 = C10039a.m21121b(this.f26591 + this.f26595) + ".ifx.v1.license";
                } catch (Throwable unused2) {
                    SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[licenseInit]Fetch " + this.f26611 + " file prefix fail, use default file name", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 44);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(".ifx.v1.license");
                    this.f26610 = sb.toString();
                }
            }
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public int m21065(LicenseFile licenseFile) {
            String str = this.f26591;
            if (str == null || str.isEmpty()) {
                String a = MultiLicenseManager.this.f26579a;
                SystemUtils.log(4, a, "[checkLicense]License key is empty when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 72);
                return 1;
            } else if (!licenseFile.getLicenseKey().equals(this.f26591)) {
                String a2 = MultiLicenseManager.this.f26579a;
                SystemUtils.log(4, a2, "[checkLicense]License key is invalid when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 53);
                return 1;
            } else {
                String a3 = C10040b.m21124a(MultiLicenseManager.this.f26583e);
                this.f26602 = a3;
                if (a3 == null || a3.isEmpty()) {
                    String a4 = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(4, a4, "[checkLicense]Device id is empty when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 71);
                    return 2;
                } else if (!licenseFile.getDeviceId().equals(this.f26602)) {
                    String a5 = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(4, a5, "[checkLicense]Device_id is invalid when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 64);
                    return 2;
                } else if (System.currentTimeMillis() <= licenseFile.getExpiryTimestamp() * 1000) {
                    return 0;
                } else {
                    String a6 = MultiLicenseManager.this.f26579a;
                    SystemUtils.log(4, a6, "[checkLicense]License is beyond expiry when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 70);
                    return 3;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 偡 */
        public void m21100(String str, String str2) {
            byte[] bytes = str.getBytes();
            byte[] bytes2 = str2.getBytes();
            int length = bytes.length;
            FileOutputStream openFileOutput = MultiLicenseManager.this.f26583e.openFileOutput(this.f26610, 0);
            openFileOutput.write(C10039a.m21119a(length));
            openFileOutput.write(bytes);
            openFileOutput.write(bytes2);
            openFileOutput.write(C10039a.m21119a(616));
            openFileOutput.close();
        }

        /* access modifiers changed from: private */
        /* renamed from: 偡 */
        public String m21097() {
            String str = this.f26591;
            if (str == null || str.isEmpty()) {
                this.f26591 = "null";
            }
            return this.f26591;
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m21074(int i, long j, String str) {
            String str2 = this.f26591;
            if (str2 == null || str2.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[omegaReportHttpException]License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 103);
                return;
            }
            try {
                String a = C10039a.m21115a(this.f26591);
                String a2 = C10040b.m21124a(MultiLicenseManager.this.f26583e);
                this.f26602 = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[omegaReportHttpException]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 101);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("license_key_checksum", a);
                hashMap.put("device_id", this.f26602);
                hashMap.put("sdk_version", "2.1.1");
                hashMap.put("status_code", Integer.valueOf(i));
                hashMap.put("code", Long.valueOf(j));
                hashMap.put("message", str);
                MultiLicenseManager.this.m21047a("tech_ifx_report_http_status", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                String a3 = MultiLicenseManager.this.f26579a;
                SystemUtils.log(6, a3, "[omegaReportHttpException]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 102);
            }
        }

        /* renamed from: 偡 */
        private void m21098(long j, long j2, long j3) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f26594 = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(j3), j, j2, TimeUnit.SECONDS);
            String a = MultiLicenseManager.this.f26579a;
            SystemUtils.log(3, a, "[startHeartBeat]With delay " + j + " base " + j2 + " and bias " + j3 + " when process " + this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 75);
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m21083(boolean z, long j) {
            String str = this.f26591;
            if (str == null || str.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[omegaReportNetworkLatency]License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 133);
                return;
            }
            try {
                String a = C10039a.m21115a(this.f26591);
                String a2 = C10040b.m21124a(MultiLicenseManager.this.f26583e);
                this.f26602 = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[omegaReportNetworkLatency]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 131);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("license_key_checksum", a);
                hashMap.put("device_id", this.f26602);
                hashMap.put("sdk_version", "2.1.1");
                hashMap.put("first_register", Boolean.valueOf(z));
                hashMap.put("latency", Long.valueOf(j));
                MultiLicenseManager.this.m21047a("tech_ifx_report_http_latency", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                String a3 = MultiLicenseManager.this.f26579a;
                SystemUtils.log(6, a3, "[omegaReportNetworkLatency]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 132);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m21073(int i, long j) {
            String str = this.f26591;
            if (str == null || str.isEmpty()) {
                SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[omegaReportLicenseCheck]License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 190);
                return;
            }
            try {
                String a = C10039a.m21115a(this.f26591);
                String a2 = C10040b.m21124a(MultiLicenseManager.this.f26583e);
                this.f26602 = a2;
                if (a2 == null || a2.isEmpty()) {
                    SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[omegaReportLicenseCheck]Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 188);
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
                hashMap.put("device_id", this.f26602);
                hashMap.put("sdk_version", "2.1.1");
                hashMap.put("pass_check", Boolean.valueOf(z));
                hashMap.put("check_time", Long.valueOf(j));
                hashMap.put("code", Integer.valueOf(i2));
                MultiLicenseManager.this.m21047a("tech_ifx_report_check_license", (Map<String, Object>) hashMap);
            } catch (Throwable th) {
                String a3 = MultiLicenseManager.this.f26579a;
                SystemUtils.log(6, a3, "[omegaReportLicenseCheck]Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 189);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m21075(long j) {
            if (MultiLicenseManager.this.f26588j != 1) {
                SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[inferenceStatics]Please use omegaReportInference instead", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 192);
                return;
            }
            InferenceMonitor inferenceMonitor = this.f26597;
            if (inferenceMonitor == null) {
                SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[inferenceStatics]InferenceMonitor is not initialized", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 196);
            } else {
                inferenceMonitor.m21106(j);
            }
        }

        /* renamed from: 䞂 */
        private String m21071() {
            InputStream inputStream;
            try {
                if (MultiLicenseManager.this.f26581c) {
                    inputStream = MultiLicenseManager.this.f26583e.getAssets().open(this.f26595);
                } else {
                    inputStream = new FileInputStream(this.f26595);
                }
                try {
                    C10039a.m21113a(inputStream);
                    try {
                        if (C10039a.m21113a(inputStream) % 100 != C10039a.f26636g) {
                            this.f26601 = true;
                            return "b3b9ca1474334e85a2baf43be1ac3595";
                        }
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        while (i < 4) {
                            try {
                                sb.append(String.format("%08x", new Object[]{Integer.valueOf(C10039a.m21113a(inputStream))}));
                                i++;
                            } catch (Throwable th) {
                                SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[fetchModelUuid]Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 245);
                                MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th);
                                return null;
                            }
                        }
                        return sb.toString();
                    } catch (Throwable th2) {
                        SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[fetchModelUuid]Fetch model version fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 253);
                        MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th2);
                        return null;
                    }
                } catch (Throwable th3) {
                    SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[fetchModelUuid]Fetch framework version fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 255);
                    MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th3);
                    return null;
                }
            } catch (Throwable th4) {
                SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[fetchModelUuid]Open model file fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 257);
                MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th4);
                return null;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m21082(String str, String str2) {
            int length = str.length();
            int length2 = str2.length();
            FileOutputStream openFileOutput = MultiLicenseManager.this.f26583e.openFileOutput(this.f26610, 0);
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

        /* renamed from: 䞂 */
        private int m21069(boolean z) {
            try {
                FileInputStream openFileInput = MultiLicenseManager.this.f26583e.openFileInput(this.f26610);
                if (openFileInput == null) {
                    SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Open ifx.license fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 277);
                    MultiLicenseManager.this.m21046a("IFXLicenseManagerError", new Throwable("[fetchLocalLicenseInfo]Open ifx license fail when process " + this.f26595));
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
                                SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Find ifx.license broken when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 316);
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
                                                    LicenseFile licenseFile = (LicenseFile) this.f26609.fromJson(C10039a.m21116a(b), LicenseFile.class);
                                                    try {
                                                        if (!C10042d.m21131a(b, licenseFile.getPublicKey(), a2)) {
                                                            SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Verify license not pass when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 391);
                                                            return -4;
                                                        }
                                                        this.f26596 = licenseFile;
                                                        long updateTimestamp = licenseFile.getUpdateTimestamp();
                                                        this.f26599 = updateTimestamp;
                                                        if (this.f26592) {
                                                            this.f26599 = updateTimestamp + (((long) this.f26606) * 60);
                                                        }
                                                        if (!z) {
                                                            long heartbeatTime = this.f26596.getHeartbeatTime();
                                                            if (heartbeatTime >= 0) {
                                                                this.f26603 = heartbeatTime;
                                                            }
                                                            long heartbeatBias = this.f26596.getHeartbeatBias();
                                                            if (heartbeatBias >= 0) {
                                                                this.f26593 = heartbeatBias;
                                                            }
                                                        }
                                                        return 0;
                                                    } catch (Throwable th) {
                                                        SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Verify license fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 410);
                                                        MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th);
                                                        return -4;
                                                    }
                                                } catch (Throwable th2) {
                                                    SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Parse license file info fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 412);
                                                    MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th2);
                                                    return -3;
                                                }
                                            } catch (Throwable th3) {
                                                SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Decode license data fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 414);
                                                MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th3);
                                                return -3;
                                            }
                                        } catch (Throwable th4) {
                                            SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Close ifx.license fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 416);
                                            MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th4);
                                            return -2;
                                        }
                                    } catch (Throwable th5) {
                                        SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Read signature in ifx.license fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 418);
                                        MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th5);
                                        return -2;
                                    }
                                } catch (Throwable th6) {
                                    SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Read license content in ifx.license fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 420);
                                    MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th6);
                                    return -2;
                                }
                            } catch (Throwable th7) {
                                SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Read license content in ifx.license fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 422);
                                MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th7);
                                return -2;
                            }
                        } catch (Throwable th8) {
                            SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Read ifx.license fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 424);
                            MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th8);
                            return -2;
                        }
                    } catch (Throwable th9) {
                        SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Read ifx.license fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 426);
                        MultiLicenseManager.this.m21046a("IFXLicenseManagerError", th9);
                        return -2;
                    }
                } catch (IOException e) {
                    SystemUtils.log(6, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]Read ifx.license size fail when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 428);
                    MultiLicenseManager.this.m21046a("IFXLicenseManagerError", (Throwable) e);
                    return -2;
                }
            } catch (FileNotFoundException unused) {
                SystemUtils.log(4, MultiLicenseManager.this.f26579a, "[fetchLocalLicenseInfo]File ifx.license does not exist when process " + this.f26595, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 430);
                return -1;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: 䞂 */
        public void m21076(long j, long j2, long j3) {
            this.f26594.shutdown();
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f26594 = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(j3), j, j2, TimeUnit.SECONDS);
            String a = MultiLicenseManager.this.f26579a;
            SystemUtils.log(3, a, "[resetHeartBeat]With delay " + j + " base " + j2 + " and bias " + j3 + " when process " + this.f26611, (Throwable) null, "com.didi.ifx.license.MultiLicenseManager$MultiLicense", 434);
        }
    }

    public MultiLicenseManager(Context context) {
        this.f26583e = context;
        this.f26580b = true;
        this.f26581c = false;
        this.f26588j = 0;
        this.f26589k = 10;
    }

    public boolean multiLicenseManagerInit(String[] strArr) {
        if (strArr == null) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 1);
            return false;
        }
        int length = strArr.length;
        this.f26584f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 7);
            return false;
        }
        this.f26585g = new MultiLicense[length];
        int[] iArr = new int[length];
        for (int i = 0; i < this.f26584f; i++) {
            iArr[i] = i;
        }
        C10039a.m21117a(iArr);
        for (int i2 = 0; i2 < this.f26584f; i2++) {
            this.f26585g[i2] = new MultiLicense();
            if (!this.f26585g[i2].m21086(strArr[i2], i2, iArr[i2])) {
                SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]License init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 23);
                return false;
            }
        }
        this.f26586h = false;
        this.token = 0;
        return true;
    }

    public boolean multiLicenseManagerInitWithModelInAssets(String[] strArr) {
        this.f26581c = true;
        if (strArr == null) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 3);
            return false;
        }
        int length = strArr.length;
        this.f26584f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 9);
            return false;
        }
        this.f26585g = new MultiLicense[length];
        int[] iArr = new int[length];
        for (int i = 0; i < this.f26584f; i++) {
            iArr[i] = i;
        }
        C10039a.m21117a(iArr);
        for (int i2 = 0; i2 < this.f26584f; i2++) {
            this.f26585g[i2] = new MultiLicense();
            if (!this.f26585g[i2].m21086(strArr[i2], i2, iArr[i2])) {
                SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]License init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 25);
                return false;
            }
        }
        this.f26586h = false;
        this.token = 0;
        return true;
    }

    public void multiLicenseMangerRelease() {
        for (int i = 0; i < this.f26584f; i++) {
            this.f26585g[i].m21062();
        }
    }

    public boolean multiLicenseMangerVerifyLicense() {
        for (int i = 0; i < this.f26584f; i++) {
            if (!this.f26585g[i].m21103()) {
                SystemUtils.log(6, this.f26579a, "[multiLicenseMangerVerifyLicense]License verify fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 4);
                this.f26586h = false;
                return false;
            }
        }
        this.f26586h = true;
        return true;
    }

    public void multiLicenseMangerVerifyToken() {
        long currentTimeMillis = System.currentTimeMillis() ^ C10039a.f26630a;
        int i = C10039a.f26633d;
        if (!this.f26586h && ((i = new Random().nextInt(C10039a.f26634e)) == C10039a.f26633d || i == C10039a.f26634e)) {
            i--;
        }
        this.token = (((currentTimeMillis * 100) + ((long) i)) ^ C10039a.f26631b) << C10039a.f26632c;
    }

    public void omegaReportInference(long[] jArr) {
        if (jArr != null && jArr.length > 0) {
            int i = this.f26588j;
            int i2 = 0;
            if (i == 0) {
                while (i2 < jArr.length) {
                    m21045a(this.f26585g[i2].m21097(), jArr[i2]);
                    i2++;
                }
            } else if (i == 1) {
                while (i2 < jArr.length) {
                    this.f26585g[i2].m21075(jArr[i2]);
                    i2++;
                }
            }
        }
    }

    public void setIFXTrackCallback(IFXTrackCallback iFXTrackCallback) {
        this.f26582d = true;
        this.f26590l = iFXTrackCallback;
    }

    public void setLocationCode(int i) {
        if (i != 1) {
            this.f26587i = "https://ifx-license.didiglobal.com/v1/license/register";
        } else {
            this.f26587i = "https://ifx-license.didiglobal.com/v1/license/register";
        }
    }

    public void setOnlineLicenseSwitch(boolean z) {
        this.f26580b = z;
    }

    /* renamed from: a */
    private void m21045a(String str, long j) {
        if (j != -666) {
            if (this.f26588j != 0) {
                SystemUtils.log(4, this.f26579a, "please use inferenceStatics instead", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 7);
            } else if (str == null || str.isEmpty()) {
                SystemUtils.log(6, this.f26579a, "omegaReportInference: License key is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 52);
            } else {
                try {
                    String a = C10039a.m21115a(str);
                    String a2 = C10040b.m21124a(this.f26583e);
                    if (a2 == null || a2.isEmpty()) {
                        SystemUtils.log(6, this.f26579a, "omegaReportInference: Device Id is invalid", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 50);
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
                    hashMap.put("device_id", a2);
                    hashMap.put("sdk_version", "2.1.1");
                    hashMap.put("inference_time", Long.valueOf(j));
                    hashMap.put("code", Integer.valueOf(i));
                    m21047a("tech_ifx_report_inference", (Map<String, Object>) hashMap);
                } catch (Throwable th) {
                    String str2 = this.f26579a;
                    SystemUtils.log(6, str2, "omegaReportInference: fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 51);
                }
            }
        }
    }

    public boolean multiLicenseManagerInit(String[] strArr, int i) {
        if (strArr == null) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 30);
            return false;
        }
        int length = strArr.length;
        this.f26584f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 36);
            return false;
        }
        this.f26585g = new MultiLicense[length];
        this.f26588j = i;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < this.f26584f; i2++) {
            iArr[i2] = i2;
        }
        C10039a.m21117a(iArr);
        for (int i3 = 0; i3 < this.f26584f; i3++) {
            this.f26585g[i3] = new MultiLicense();
            if (!this.f26585g[i3].m21086(strArr[i3], i3, iArr[i3])) {
                SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]License init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 53);
                return false;
            }
        }
        this.f26586h = false;
        this.token = 0;
        return true;
    }

    public boolean multiLicenseManagerInitWithModelInAssets(String[] strArr, int i) {
        this.f26581c = true;
        if (strArr == null) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 34);
            return false;
        }
        int length = strArr.length;
        this.f26584f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 40);
            return false;
        }
        this.f26585g = new MultiLicense[length];
        this.f26588j = i;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < this.f26584f; i2++) {
            iArr[i2] = i2;
        }
        C10039a.m21117a(iArr);
        for (int i3 = 0; i3 < this.f26584f; i3++) {
            this.f26585g[i3] = new MultiLicense();
            if (!this.f26585g[i3].m21086(strArr[i3], i3, iArr[i3])) {
                SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]License init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 57);
                return false;
            }
        }
        this.f26586h = false;
        this.token = 0;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21047a(String str, Map<String, Object> map) {
        if (this.f26582d) {
            IFXTrackCallback iFXTrackCallback = this.f26590l;
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
    public void m21046a(String str, Throwable th) {
        if (this.f26582d) {
            IFXTrackCallback iFXTrackCallback = this.f26590l;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackError(str, th);
                return;
            }
            return;
        }
        OmegaSDK.trackError(str, th);
    }

    public boolean multiLicenseManagerInit(String[] strArr, int i, int i2) {
        if (strArr == null) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 60);
            return false;
        }
        int length = strArr.length;
        this.f26584f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 66);
            return false;
        }
        this.f26585g = new MultiLicense[length];
        this.f26588j = i;
        this.f26589k = i2;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < this.f26584f; i3++) {
            iArr[i3] = i3;
        }
        C10039a.m21117a(iArr);
        for (int i4 = 0; i4 < this.f26584f; i4++) {
            this.f26585g[i4] = new MultiLicense();
            if (!this.f26585g[i4].m21086(strArr[i4], i4, iArr[i4])) {
                SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]multiLicenseManager license init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 84);
                return false;
            }
        }
        this.f26586h = false;
        this.token = 0;
        return true;
    }

    public boolean multiLicenseManagerInitWithModelInAssets(String[] strArr, int i, int i2) {
        this.f26581c = true;
        if (strArr == null) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models is null", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 66);
            return false;
        }
        int length = strArr.length;
        this.f26584f = length;
        if (length <= 0) {
            SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]Param models length is 0 or negative", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 72);
            return false;
        }
        this.f26585g = new MultiLicense[length];
        this.f26588j = i;
        this.f26589k = i2;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < this.f26584f; i3++) {
            iArr[i3] = i3;
        }
        C10039a.m21117a(iArr);
        for (int i4 = 0; i4 < this.f26584f; i4++) {
            this.f26585g[i4] = new MultiLicense();
            if (!this.f26585g[i4].m21086(strArr[i4], i4, iArr[i4])) {
                SystemUtils.log(6, this.f26579a, "[multiLicenseManagerInit]multiLicenseManager license init fail", (Throwable) null, "com.didi.ifx.license.MultiLicenseManager", 90);
                return false;
            }
        }
        this.f26586h = false;
        this.token = 0;
        return true;
    }
}
