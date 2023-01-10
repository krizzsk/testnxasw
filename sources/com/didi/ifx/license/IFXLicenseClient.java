package com.didi.ifx.license;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

public class IFXLicenseClient {

    /* renamed from: a */
    private static volatile IFXLicenseClient f26477a = null;

    /* renamed from: b */
    private static volatile boolean f26478b = false;

    /* renamed from: c */
    private static volatile boolean f26479c = true;

    /* renamed from: d */
    private final MediaType f26480d = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: e */
    private String f26481e;

    /* renamed from: f */
    private Context f26482f;

    /* renamed from: g */
    private int f26483g;

    /* renamed from: h */
    private String f26484h;

    /* renamed from: i */
    private volatile boolean f26485i;

    /* renamed from: j */
    private volatile int f26486j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile HashMap<Integer, IFXModel> f26487k;

    /* renamed from: l */
    private OkHttpClient f26488l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Gson f26489m;

    /* renamed from: n */
    private ScheduledExecutorService f26490n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public long f26491o;

    /* renamed from: p */
    private volatile boolean f26492p;

    /* renamed from: q */
    private boolean f26493q;

    /* renamed from: r */
    private ScheduledExecutorService f26494r;

    /* renamed from: s */
    private int f26495s;

    /* renamed from: t */
    private volatile boolean f26496t;

    /* renamed from: u */
    private MonitorThread f26497u;

    /* renamed from: v */
    private volatile boolean f26498v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C10041c f26499w;

    private class HeartBeat implements Runnable {
        private HeartBeat() {
        }

        public void run() {
            if (IFXLicenseClient.this.f26487k.size() > 0) {
                for (IFXModel a : IFXLicenseClient.this.f26487k.values()) {
                    IFXLicenseClient.this.m20962a(a);
                }
            }
        }
    }

    private class InferenceReporter implements Runnable {
        private InferenceReporter() {
        }

        public void run() {
            if (IFXLicenseClient.this.f26487k.size() > 0) {
                for (IFXModel iFXModel : IFXLicenseClient.this.f26487k.values()) {
                    if (iFXModel.f26526q > 0 && iFXModel.f26529t % iFXModel.f26528s == 0) {
                        iFXModel.mo77400a();
                    }
                    int i = iFXModel.f26529t + 1;
                    iFXModel.f26529t = i;
                    if (i >= iFXModel.f26528s) {
                        iFXModel.f26529t = 0;
                    }
                }
            }
        }
    }

    private class MonitorThread extends Thread {
        private MonitorThread() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(IFXLicenseClient.this.f26491o * 1000);
                    IFXLicenseClient.this.m20972c();
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    private IFXLicenseClient(Context context) {
        this.f26482f = context;
        this.f26483g = 100;
        this.f26487k = new HashMap<>();
        this.f26486j = 0;
        this.f26484h = C10040b.m21124a(this.f26482f);
        this.f26489m = new GsonBuilder().create();
        this.f26481e = "https://ifx-license.didiglobal.com/v1/license/register";
        this.f26491o = 2;
        this.f26492p = false;
        this.f26498v = false;
        this.f26485i = true;
        this.f26493q = false;
        this.f26496t = false;
        f26478b = true;
        m20955a();
        this.f26499w = new C10041c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m20972c() {
        boolean z;
        ScheduledExecutorService scheduledExecutorService;
        if (this.f26487k.size() > 0) {
            long j = Long.MAX_VALUE;
            for (IFXModel iFXModel : this.f26487k.values()) {
                long j2 = iFXModel.f26519j;
                if (j2 < j) {
                    j = j2;
                }
            }
            if (j != this.f26491o) {
                this.f26491o = j;
                z = true;
                if (z && (scheduledExecutorService = this.f26490n) != null && !scheduledExecutorService.isShutdown()) {
                    this.f26490n.shutdown();
                    ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                    this.f26490n = newSingleThreadScheduledExecutor;
                    newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(), 5, this.f26491o, TimeUnit.SECONDS);
                    this.f26492p = true;
                    SystemUtils.log(3, "IFXLicenseClient", "Reset heartbeat thread with time(s) " + this.f26491o, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 23);
                }
            }
        }
        z = false;
        this.f26490n.shutdown();
        ScheduledExecutorService newSingleThreadScheduledExecutor2 = Executors.newSingleThreadScheduledExecutor();
        this.f26490n = newSingleThreadScheduledExecutor2;
        newSingleThreadScheduledExecutor2.scheduleWithFixedDelay(new HeartBeat(), 5, this.f26491o, TimeUnit.SECONDS);
        this.f26492p = true;
        SystemUtils.log(3, "IFXLicenseClient", "Reset heartbeat thread with time(s) " + this.f26491o, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 23);
    }

    /* renamed from: d */
    private synchronized void m20976d() {
        ScheduledExecutorService scheduledExecutorService = this.f26490n;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
        this.f26492p = false;
    }

    /* renamed from: f */
    private synchronized void m20979f() {
        MonitorThread monitorThread = this.f26497u;
        if (monitorThread != null) {
            monitorThread.interrupt();
        }
        this.f26498v = false;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.didi.ifx.license.IFXLicenseClient getIFXLicenseClient(android.content.Context r2) {
        /*
            java.lang.Class<com.didi.ifx.license.IFXLicenseClient> r0 = com.didi.ifx.license.IFXLicenseClient.class
            monitor-enter(r0)
            com.didi.ifx.license.IFXLicenseClient r1 = f26477a     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.didi.ifx.license.IFXLicenseClient r1 = f26477a     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.didi.ifx.license.IFXLicenseClient r1 = new com.didi.ifx.license.IFXLicenseClient     // Catch:{ all -> 0x0015 }
            r1.<init>(r2)     // Catch:{ all -> 0x0015 }
            f26477a = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.didi.ifx.license.IFXLicenseClient r2 = f26477a     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r2
        L_0x001c:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.IFXLicenseClient.getIFXLicenseClient(android.content.Context):com.didi.ifx.license.IFXLicenseClient");
    }

    public static IFXLicenseClient getIFXLicenseClientInJni() {
        if (f26478b) {
            return f26477a;
        }
        return null;
    }

    /* renamed from: i */
    private synchronized void m20982i() {
        if (this.f26494r != null) {
            for (IFXModel a : this.f26487k.values()) {
                a.mo77400a();
            }
            this.f26494r.shutdown();
        }
        this.f26496t = false;
    }

    public static synchronized void releaseIFXLicenseClient() {
        synchronized (IFXLicenseClient.class) {
            if (f26477a != null) {
                f26477a.clearAllModels();
                f26477a = null;
            }
        }
    }

    public synchronized int addModel(IFXModel iFXModel) {
        if (f26479c) {
            f26479c = false;
        }
        if (this.f26487k.size() >= this.f26483g) {
            SystemUtils.log(4, "IFXLicenseClient", "Cannot add more ifx model", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 6);
            return -1;
        }
        int size = this.f26487k.size();
        iFXModel.f26525p = this.f26499w;
        if (!m20973c(iFXModel)) {
            SystemUtils.log(4, "IFXLicenseClient", "Fetch ifx model uuid fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 15);
            return -4;
        } else if (!iFXModel.mo77401a(size, this.f26486j, this.f26484h)) {
            SystemUtils.log(4, "IFXLicenseClient", "Init ifx model fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 20);
            return -2;
        } else {
            this.f26487k.put(Integer.valueOf(size), iFXModel);
            if (m20964a(size)) {
                return size;
            }
            SystemUtils.log(4, "IFXLicenseClient", "verify ifx model fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 27);
            return -3;
        }
    }

    public boolean allRegistered() {
        if (this.f26487k.isEmpty()) {
            return false;
        }
        for (IFXModel iFXModel : this.f26487k.values()) {
            if (!iFXModel.f26517h) {
                return false;
            }
        }
        return true;
    }

    public synchronized void clearAllModels() {
        this.f26487k.clear();
        if (this.f26485i) {
            m20979f();
            m20976d();
        }
        if (this.f26493q) {
            m20982i();
        }
        f26479c = true;
    }

    public int getGroups() {
        return this.f26486j;
    }

    public int getIFXModelsNum() {
        if (this.f26487k == null) {
            return -1;
        }
        return this.f26487k.size();
    }

    public synchronized IFXModel getModel(int i) {
        return this.f26487k.get(Integer.valueOf(i));
    }

    public long getModelVerifyToken(int i) {
        IFXModel iFXModel = this.f26487k.get(Integer.valueOf(i));
        if (iFXModel != null) {
            return iFXModel.generateToken();
        }
        SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Get model according to mid fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 3);
        return 0;
    }

    public boolean isInitialized() {
        return f26478b;
    }

    public boolean midIsValid(int i) {
        if (i < 0 || this.f26487k == null) {
            return false;
        }
        return this.f26487k.containsKey(Integer.valueOf(i));
    }

    public boolean modelIsRegistered(int i) {
        IFXModel iFXModel;
        if (i < 0 || this.f26487k == null || !this.f26487k.containsKey(Integer.valueOf(i)) || (iFXModel = this.f26487k.get(Integer.valueOf(i))) == null) {
            return false;
        }
        return iFXModel.f26517h;
    }

    public void omegaReportInference(int i, long j) {
        IFXModel iFXModel = this.f26487k.get(Integer.valueOf(i));
        if (iFXModel == null) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Get model according to mid fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 3);
            return;
        }
        iFXModel.reportInferenceTimeByOMG(j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void registerAllModels() {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            java.util.HashMap<java.lang.Integer, com.didi.ifx.license.IFXModel> r1 = r5.f26487k     // Catch:{ all -> 0x0051 }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0051 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0051 }
            r2 = 1
        L_0x000d:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0051 }
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0051 }
            com.didi.ifx.license.IFXModel r3 = (com.didi.ifx.license.IFXModel) r3     // Catch:{ all -> 0x0051 }
            boolean r4 = r3.f26517h     // Catch:{ all -> 0x0051 }
            if (r4 != 0) goto L_0x000d
            boolean r0 = r3.f26522m     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0023
            r3.f26518i = r2     // Catch:{ all -> 0x0051 }
        L_0x0023:
            r3.f26517h = r2     // Catch:{ all -> 0x0051 }
            r0 = 1
            goto L_0x000d
        L_0x0027:
            if (r0 != 0) goto L_0x002b
            monitor-exit(r5)
            return
        L_0x002b:
            int r0 = r5.f26486j     // Catch:{ all -> 0x0051 }
            int r0 = r0 + r2
            r5.f26486j = r0     // Catch:{ all -> 0x0051 }
            boolean r0 = r5.f26485i     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0046
            boolean r0 = r5.f26492p     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x003c
            r5.m20972c()     // Catch:{ all -> 0x0051 }
            goto L_0x003f
        L_0x003c:
            r5.m20967b()     // Catch:{ all -> 0x0051 }
        L_0x003f:
            boolean r0 = r5.f26498v     // Catch:{ all -> 0x0051 }
            if (r0 != 0) goto L_0x0046
            r5.m20977e()     // Catch:{ all -> 0x0051 }
        L_0x0046:
            boolean r0 = r5.m20980g()     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x004f
            r5.m20981h()     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r5)
            return
        L_0x0051:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.IFXLicenseClient.registerAllModels():void");
    }

    public synchronized boolean setIFXAuthSwitch(boolean z) {
        if (!f26479c) {
            SystemUtils.log(4, "IFXLicenseClient", "Cannot set ifx auth switch after adding IFXModel", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 2);
            return false;
        }
        this.f26485i = z;
        return true;
    }

    public synchronized void setIFXTrackCallback(IFXTrackCallback iFXTrackCallback) {
        C10041c cVar = this.f26499w;
        cVar.f26637a = true;
        cVar.f26638b = iFXTrackCallback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean setLocationCode(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = f26479c     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0014
            java.lang.String r2 = "IFXLicenseClient"
            java.lang.String r3 = "Cannot set location code after adding IFXModel"
            r1 = 4
            r4 = 0
            java.lang.String r5 = "com.didi.ifx.license.IFXLicenseClient"
            r6 = 2
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0022 }
            r8 = 0
            monitor-exit(r7)
            return r8
        L_0x0014:
            r0 = 1
            if (r8 == r0) goto L_0x001c
            java.lang.String r8 = "https://ifx-license.didiglobal.com/v1/license/register"
            r7.f26481e = r8     // Catch:{ all -> 0x0022 }
            goto L_0x0020
        L_0x001c:
            java.lang.String r8 = "https://ifx-license.didiglobal.com/v1/license/register"
            r7.f26481e = r8     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r7)
            return r0
        L_0x0022:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.ifx.license.IFXLicenseClient.setLocationCode(int):boolean");
    }

    public synchronized boolean setMaxModelNum(int i) {
        if (!f26479c) {
            SystemUtils.log(4, "IFXLicenseClient", "Cannot set max model num after adding IFXModel", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 2);
            return false;
        }
        this.f26483g = i;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20962a(IFXModel iFXModel) {
        int i;
        m20956a(iFXModel.f26511b, iFXModel.f26512c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= iFXModel.f26521l * 1000) {
            int d = m20974d(iFXModel);
            if (d == -6) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] License file is broken in heartbeat", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 28);
                m20968b(iFXModel.f26511b);
            } else if (d == -1) {
                m20968b(iFXModel.f26511b);
            } else if (d != 0) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Fetch local license fail in heartbeat", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 8);
                iFXModel.f26518i = false;
            } else {
                if (!iFXModel.f26510a) {
                    i = m20952a(iFXModel.f26511b, iFXModel.f26512c, iFXModel.f26524o);
                    m20957a(iFXModel.f26511b, iFXModel.f26512c, i, System.currentTimeMillis() - currentTimeMillis);
                } else {
                    i = 0;
                }
                if (i > 0) {
                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Check license fail in heartbeat", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 18);
                    iFXModel.f26518i = false;
                    return;
                }
                m20968b(iFXModel.f26511b);
            }
        }
    }

    /* renamed from: e */
    private synchronized void m20977e() {
        this.f26498v = true;
        MonitorThread monitorThread = new MonitorThread();
        this.f26497u = monitorThread;
        monitorThread.setDaemon(true);
        this.f26497u.start();
    }

    /* renamed from: g */
    private boolean m20980g() {
        if (this.f26487k.size() <= 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (IFXModel next : this.f26487k.values()) {
            if (next.f26526q > 0 && next.f26517h) {
                this.f26493q = true;
                arrayList.add(Integer.valueOf(next.f26527r));
            }
        }
        if (!this.f26493q) {
            return false;
        }
        int i = 1;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 == 0) {
                i = ((Integer) arrayList.get(i2)).intValue();
            } else {
                i = C10039a.m21112a(i, ((Integer) arrayList.get(i2)).intValue());
            }
        }
        for (IFXModel next2 : this.f26487k.values()) {
            if (next2.f26526q > 0) {
                next2.f26529t = 0;
                next2.f26528s = next2.f26527r / i;
            }
        }
        if (this.f26496t && i == this.f26495s) {
            return false;
        }
        this.f26495s = i;
        return true;
    }

    /* renamed from: a */
    private boolean m20964a(int i) {
        int i2 = i;
        IFXModel iFXModel = this.f26487k.get(Integer.valueOf(i));
        if (iFXModel == null) {
            return false;
        }
        m20956a(iFXModel.f26511b, iFXModel.f26512c);
        if (this.f26485i) {
            long currentTimeMillis = System.currentTimeMillis();
            int b = m20965b(iFXModel);
            if (b == -6) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] License file is broken and need pulled from server", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 42);
                iFXModel.f26518i = true;
                return true;
            } else if (b == -4) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] License file may be modified illegally ", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 39);
                return false;
            } else if (b == -3) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] Decode license file fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 36);
                return false;
            } else if (b == -2) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] Read license file fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 33);
                return false;
            } else if (b == -1) {
                iFXModel.f26522m = true;
                return true;
            } else if (b != 0) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] Fetch local license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 14);
                return false;
            } else {
                int a = !iFXModel.f26510a ? m20952a(iFXModel.f26511b, iFXModel.f26512c, iFXModel.f26524o) : 0;
                if (a > 0) {
                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] Check license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 22);
                    m20957a(iFXModel.f26511b, iFXModel.f26512c, a, System.currentTimeMillis() - currentTimeMillis);
                    return false;
                }
                iFXModel.f26518i = true;
                m20957a(iFXModel.f26511b, iFXModel.f26512c, a, System.currentTimeMillis() - currentTimeMillis);
                return true;
            }
        } else {
            iFXModel.f26518i = true;
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m20952a(int i, String str, LicenseFile licenseFile) {
        if (str == null || str.isEmpty()) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] License key is empty when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 28);
            return 1;
        } else if (!licenseFile.getLicenseKey().equals(str)) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] License key is invalid when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 11);
            return 1;
        } else {
            String a = C10040b.m21124a(this.f26482f);
            if (a == null || a.isEmpty()) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Device id is empty when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 27);
                return 2;
            } else if (!licenseFile.getDeviceId().equals(a)) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Device id is invalid when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 21);
                return 2;
            } else if (System.currentTimeMillis() <= licenseFile.getExpiryTimestamp() * 1000) {
                return 0;
            } else {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] License is beyond expiry when check", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 26);
                return 3;
            }
        }
    }

    /* renamed from: d */
    private int m20974d(IFXModel iFXModel) {
        int i = iFXModel.f26511b;
        try {
            FileInputStream openFileInput = this.f26482f.openFileInput(iFXModel.f26513d);
            if (openFileInput == null) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Open ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 18);
                this.f26499w.mo77460a("IFXLicenseClientError", new Throwable("Open ifx license file fail"));
                return -2;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openFileInput);
            try {
                int available = bufferedInputStream.available();
                int i2 = available - 4;
                try {
                    bufferedInputStream.mark(i2);
                    bufferedInputStream.skip((long) i2);
                    byte[] bArr = new byte[4];
                    try {
                        bufferedInputStream.read(bArr, 0, 4);
                        bufferedInputStream.reset();
                        if (C10039a.m21114a(bArr, 0) != 616) {
                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Find ifx.v2.license broken", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 55);
                            return -6;
                        }
                        byte[] bArr2 = new byte[4];
                        try {
                            bufferedInputStream.read(bArr2, 0, 4);
                            int a = C10039a.m21114a(bArr2, 0);
                            byte[] bArr3 = new byte[a];
                            try {
                                bufferedInputStream.read(bArr3, 0, a);
                                int i3 = (available - a) - 8;
                                byte[] bArr4 = new byte[i3];
                                try {
                                    bufferedInputStream.read(bArr4, 0, i3);
                                    String a2 = C10039a.m21116a(bArr4);
                                    try {
                                        bufferedInputStream.close();
                                        try {
                                            byte[] b = C10039a.m21122b(bArr3);
                                            try {
                                                try {
                                                    if (C10042d.m21131a(b, ((LicenseFile) this.f26489m.fromJson(C10039a.m21116a(b), LicenseFile.class)).getPublicKey(), a2)) {
                                                        return 0;
                                                    }
                                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Verify license not pass", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 128);
                                                    return -4;
                                                } catch (Throwable th) {
                                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Verify license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 129);
                                                    this.f26499w.mo77460a("IFXLicenseClientError", th);
                                                    return -3;
                                                }
                                            } catch (Throwable th2) {
                                                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Parse license file info fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 131);
                                                this.f26499w.mo77460a("IFXLicenseClientError", th2);
                                                return -3;
                                            }
                                        } catch (Throwable th3) {
                                            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Decode license data fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 133);
                                            this.f26499w.mo77460a("IFXLicenseClientError", th3);
                                            return -3;
                                        }
                                    } catch (Throwable th4) {
                                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Close ifx.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 135);
                                        this.f26499w.mo77460a("IFXLicenseClientError", th4);
                                        return -2;
                                    }
                                } catch (Throwable th5) {
                                    SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read signature in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 137);
                                    this.f26499w.mo77460a("IFXLicenseClientError", th5);
                                    return -2;
                                }
                            } catch (Throwable th6) {
                                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read license content in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 139);
                                this.f26499w.mo77460a("IFXLicenseClientError", th6);
                                return -2;
                            }
                        } catch (Throwable th7) {
                            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read license content in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 141);
                            this.f26499w.mo77460a("IFXLicenseClientError", th7);
                            return -2;
                        }
                    } catch (Throwable th8) {
                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 143);
                        this.f26499w.mo77460a("IFXLicenseClientError", th8);
                        return -2;
                    }
                } catch (Throwable th9) {
                    SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 145);
                    this.f26499w.mo77460a("IFXLicenseClientError", th9);
                    return -2;
                }
            } catch (IOException e) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license size fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 147);
                this.f26499w.mo77460a("IFXLicenseClientError", (Throwable) e);
                return -2;
            }
        } catch (FileNotFoundException unused) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] File ifx.v2.license does not exist", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 149);
            return -1;
        }
    }

    /* renamed from: a */
    private void m20956a(int i, String str) {
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] License key is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 55);
            return;
        }
        try {
            String a = C10039a.m21115a(str);
            String a2 = C10040b.m21124a(this.f26482f);
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Device Id is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 53);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", a2);
            hashMap.put("sdk_version", "2.1.1");
            this.f26499w.mo77461a("tech_ifx_report", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 54);
        }
    }

    /* renamed from: h */
    private synchronized void m20981h() {
        ScheduledExecutorService scheduledExecutorService;
        if (this.f26496t && (scheduledExecutorService = this.f26494r) != null && !scheduledExecutorService.isShutdown()) {
            this.f26494r.shutdown();
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f26494r = newSingleThreadScheduledExecutor;
        InferenceReporter inferenceReporter = new InferenceReporter();
        long j = (long) this.f26495s;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(inferenceReporter, j, j, TimeUnit.MINUTES);
        this.f26496t = true;
        SystemUtils.log(3, "IFXLicenseClient", "Launch inference reporter thread with time(min) " + this.f26495s, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 36);
    }

    /* renamed from: b */
    private synchronized void m20967b() {
        if (this.f26487k.size() > 0) {
            long j = Long.MAX_VALUE;
            for (IFXModel iFXModel : this.f26487k.values()) {
                long j2 = iFXModel.f26519j;
                if (j2 < j) {
                    j = j2;
                }
            }
            if (j != this.f26491o) {
                this.f26491o = j;
            }
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f26490n = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new HeartBeat(), 2, this.f26491o, TimeUnit.SECONDS);
        this.f26492p = true;
        SystemUtils.log(3, "IFXLicenseClient", "Launch heartbeat thread with time(s) " + this.f26491o, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 64);
    }

    /* renamed from: a */
    private void m20957a(int i, String str, int i2, long j) {
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] License key is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 112);
            return;
        }
        try {
            String a = C10039a.m21115a(str);
            String a2 = C10040b.m21124a(this.f26482f);
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Device Id is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 110);
                return;
            }
            int i3 = 200;
            boolean z = false;
            if (j > 60000) {
                i3 = 208;
                j = -8;
            } else if (i2 > 0) {
                i3 = i2 != 1 ? i2 != 2 ? i2 != 3 ? 209 : 203 : 202 : 201;
            } else {
                z = true;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", a2);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("pass_check", Boolean.valueOf(z));
            hashMap.put("check_time", Long.valueOf(j));
            hashMap.put("code", Integer.valueOf(i3));
            this.f26499w.mo77461a("tech_ifx_report_check_license", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 111);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20963a(String str, String str2, String str3) {
        byte[] bytes = str2.getBytes();
        byte[] bytes2 = str3.getBytes();
        int length = bytes.length;
        FileOutputStream openFileOutput = this.f26482f.openFileOutput(str, 0);
        openFileOutput.write(C10039a.m21119a(length));
        openFileOutput.write(bytes);
        openFileOutput.write(bytes2);
        openFileOutput.write(C10039a.m21119a(616));
        openFileOutput.close();
    }

    /* renamed from: c */
    private boolean m20973c(IFXModel iFXModel) {
        InputStream inputStream;
        try {
            if (iFXModel.f26516g) {
                inputStream = this.f26482f.getAssets().open(iFXModel.f26515f);
            } else {
                inputStream = new FileInputStream(iFXModel.f26515f);
            }
            try {
                C10039a.m21113a(inputStream);
                try {
                    if (C10039a.m21113a(inputStream) % 100 != C10039a.f26636g) {
                        iFXModel.f26510a = true;
                        iFXModel.f26512c = C10039a.f26635f;
                        return true;
                    }
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (i < 4) {
                        try {
                            sb.append(String.format("%08x", new Object[]{Integer.valueOf(C10039a.m21113a(inputStream))}));
                            i++;
                        } catch (Throwable th) {
                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Fetch model uuid fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 120);
                            this.f26499w.mo77460a("IFXLicenseClientError", th);
                            return false;
                        }
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() != 32) {
                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Model uuid with invalid length", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 128);
                        return false;
                    }
                    iFXModel.f26512c = sb2;
                    return true;
                } catch (Throwable th2) {
                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Fetch model version fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 132);
                    this.f26499w.mo77460a("IFXLicenseClientError", th2);
                    return false;
                }
            } catch (Throwable th3) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Fetch framework version fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 134);
                this.f26499w.mo77460a("IFXLicenseClientError", th3);
                return false;
            }
        } catch (Throwable th4) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Open model file fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 136);
            this.f26499w.mo77460a("IFXLicenseClientError", th4);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20958a(int i, String str, int i2, long j, String str2) {
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] License key is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 142);
            return;
        }
        try {
            String a = C10039a.m21115a(str);
            String a2 = C10040b.m21124a(this.f26482f);
            if (a2 == null || a2.isEmpty()) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Device Id is invalid", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 140);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("license_key_checksum", a);
            hashMap.put("device_id", a2);
            hashMap.put("sdk_version", "2.1.1");
            hashMap.put("status_code", Integer.valueOf(i2));
            hashMap.put("code", Long.valueOf(j));
            hashMap.put("message", str2);
            this.f26499w.mo77461a("tech_ifx_report_http_status", (Map<String, Object>) hashMap);
        } catch (Throwable th) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Fetch license key checksum fail: " + th.getMessage(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 141);
        }
    }

    /* renamed from: a */
    private void m20955a() {
        this.f26488l = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
    }

    /* renamed from: b */
    private void m20968b(int i) {
        int i2 = i;
        final IFXModel iFXModel = this.f26487k.get(Integer.valueOf(i));
        if (iFXModel == null) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i2 + "] HTTP update license fail because of no such IFXModelManager", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 150);
            return;
        }
        if (iFXModel.f26522m) {
            if (iFXModel.f26523n >= 40) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i2 + "] HTTP pull license fail because of not in network", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 156);
                iFXModel.f26518i = false;
                iFXModel.f26523n = 0;
                return;
            }
        } else if (iFXModel.f26523n >= 24) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i2 + "] HTTP update license fail because of not in network", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 163);
            iFXModel.f26518i = false;
            iFXModel.f26523n = 0;
            return;
        }
        String str = iFXModel.f26512c;
        if (str == null || str.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i2 + "] HTTP fail because of empty license key", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 206);
            iFXModel.f26523n = iFXModel.f26523n + 1;
            return;
        }
        String str2 = this.f26484h;
        if (str2 == null || str2.isEmpty()) {
            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i2 + "] HTTP fail because of empty device id", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 204);
            iFXModel.f26523n = iFXModel.f26523n + 1;
            return;
        }
        this.f26488l.newCall(new Request.Builder().url(this.f26481e).post(RequestBody.create(this.f26480d, this.f26489m.toJson((Object) new RegisterRequest(str, this.f26484h, "android", C10043e.m21132a(), C10043e.m21133b(), C10043e.m21134c(), C10043e.m21135d(), System.currentTimeMillis() / 1000, "2.1.1")))).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] HTTP response fail with error: " + iOException.getMessage(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 1);
                IFXLicenseClient iFXLicenseClient = IFXLicenseClient.this;
                IFXModel iFXModel = iFXModel;
                iFXLicenseClient.m20958a(iFXModel.f26511b, iFXModel.f26512c, 0, 0, iOException.getMessage());
                IFXModel iFXModel2 = iFXModel;
                iFXModel2.f26523n = iFXModel2.f26523n + 1;
            }

            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    SystemUtils.log(3, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] HTTP return code: " + response.code() + " msg: " + response.message(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 2);
                    if (response.body() == null) {
                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] HTTP response body is empty", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 4);
                        IFXLicenseClient.this.f26499w.mo77460a("IFXLicenseClientError", new Throwable("HTTP response body is empty"));
                        IFXModel iFXModel = iFXModel;
                        iFXModel.f26523n = iFXModel.f26523n + 1;
                        return;
                    }
                    try {
                        RegisterResponse registerResponse = (RegisterResponse) IFXLicenseClient.this.f26489m.fromJson(response.body().string(), RegisterResponse.class);
                        try {
                            long j = registerResponse.get_code();
                            if (j == 20000) {
                                try {
                                    String str = registerResponse.get_license_content();
                                    if (str == null || str.isEmpty()) {
                                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Json license data is null", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 91);
                                        IFXLicenseClient.this.f26499w.mo77460a("IFXLicenseClientError", new Throwable("Json license data is null"));
                                        IFXModel iFXModel2 = iFXModel;
                                        iFXModel2.f26523n = iFXModel2.f26523n + 1;
                                        return;
                                    }
                                    try {
                                        LicenseFile licenseFile = (LicenseFile) IFXLicenseClient.this.f26489m.fromJson(str, LicenseFile.class);
                                        IFXModel iFXModel3 = iFXModel;
                                        iFXModel3.f26524o = licenseFile;
                                        if ((!iFXModel3.f26510a ? IFXLicenseClient.this.m20952a(iFXModel3.f26511b, iFXModel3.f26512c, licenseFile) : 0) > 0) {
                                            iFXModel.f26518i = false;
                                            return;
                                        }
                                        try {
                                            IFXLicenseClient.this.m20963a(iFXModel.f26513d, registerResponse.get_license_file(), registerResponse.get_sign_data());
                                            long heartbeatTime = licenseFile.getHeartbeatTime();
                                            long heartbeatBias = licenseFile.getHeartbeatBias();
                                            if (heartbeatTime >= 0 && heartbeatBias >= 0) {
                                                IFXModel iFXModel4 = iFXModel;
                                                iFXModel4.f26519j = heartbeatTime;
                                                iFXModel4.f26520k = heartbeatBias;
                                            }
                                            iFXModel.f26521l = licenseFile.getUpdateTimestamp();
                                            iFXModel.f26522m = false;
                                            iFXModel.f26523n = 0;
                                        } catch (Throwable th) {
                                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Write ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 85);
                                            IFXLicenseClient.this.f26499w.mo77460a("IFXLicenseClientError", th);
                                            IFXModel iFXModel5 = iFXModel;
                                            iFXModel5.f26523n = iFXModel5.f26523n + 1;
                                        }
                                    } catch (Throwable th2) {
                                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Parse json license data fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 88);
                                        IFXLicenseClient.this.f26499w.mo77460a("IFXLicenseClientError", th2);
                                        IFXModel iFXModel6 = iFXModel;
                                        iFXModel6.f26523n = iFXModel6.f26523n + 1;
                                    }
                                } catch (Throwable th3) {
                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Get resp license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 94);
                                    IFXLicenseClient.this.f26499w.mo77460a("IFXLicenseClientError", th3);
                                    IFXModel iFXModel7 = iFXModel;
                                    iFXModel7.f26523n = iFXModel7.f26523n + 1;
                                }
                            } else if (j == 50000) {
                                iFXModel.f26518i = false;
                                iFXModel.f26523n = 0;
                                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] HTTP response code is 50000", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 146);
                                try {
                                    IFXLicenseClient.this.m20970b(iFXModel.f26513d, registerResponse.get_license_file(), registerResponse.get_sign_data());
                                } catch (Throwable unused) {
                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Write fake ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 150);
                                    IFXLicenseClient.this.f26499w.mo77460a("IFXLicenseClientError", new Throwable("Write fake ifx.v2.license fail"));
                                }
                            } else {
                                SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] HTTP response with code " + j, (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 156);
                                IFXLicenseClient iFXLicenseClient = IFXLicenseClient.this;
                                IFXModel iFXModel8 = iFXModel;
                                iFXLicenseClient.m20958a(iFXModel8.f26511b, iFXModel8.f26512c, response.code(), j, registerResponse.get_message());
                                IFXModel iFXModel9 = iFXModel;
                                iFXModel9.f26523n = iFXModel9.f26523n + 1;
                            }
                        } catch (Throwable th4) {
                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Get resp code fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 159);
                            IFXLicenseClient.this.f26499w.mo77460a("IFXLicenseClientError", th4);
                            IFXModel iFXModel10 = iFXModel;
                            iFXModel10.f26523n = iFXModel10.f26523n + 1;
                        }
                    } catch (Throwable th5) {
                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] Parse json response body fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 162);
                        IFXLicenseClient.this.f26499w.mo77460a("IFXLicenseClientError", th5);
                        IFXModel iFXModel11 = iFXModel;
                        iFXModel11.f26523n = iFXModel11.f26523n + 1;
                    }
                } else {
                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + iFXModel.f26511b + "] HTTP fail with response code " + response.code(), (Throwable) null, "com.didi.ifx.license.IFXLicenseClient$1", 252);
                    C10041c a = IFXLicenseClient.this.f26499w;
                    StringBuilder sb = new StringBuilder();
                    sb.append("HTTP fail with response code:");
                    sb.append(response.code());
                    a.mo77460a("IFXLicenseClientError", new Throwable(sb.toString()));
                    iFXModel.f26523n++;
                }
            }
        });
    }

    /* renamed from: b */
    private int m20965b(IFXModel iFXModel) {
        int i = iFXModel.f26511b;
        try {
            FileInputStream openFileInput = this.f26482f.openFileInput(iFXModel.f26513d);
            if (openFileInput == null) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Open ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 219);
                this.f26499w.mo77460a("IFXLicenseClientError", new Throwable("Open ifx license file fail"));
                return -2;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openFileInput);
            try {
                int available = bufferedInputStream.available();
                int i2 = available - 4;
                try {
                    bufferedInputStream.mark(i2);
                    bufferedInputStream.skip((long) i2);
                    byte[] bArr = new byte[4];
                    try {
                        bufferedInputStream.read(bArr, 0, 4);
                        bufferedInputStream.reset();
                        if (C10039a.m21114a(bArr, 0) != 616) {
                            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Find ifx.v2.license broken", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 256);
                            return -6;
                        }
                        byte[] bArr2 = new byte[4];
                        try {
                            bufferedInputStream.read(bArr2, 0, 4);
                            int a = C10039a.m21114a(bArr2, 0);
                            byte[] bArr3 = new byte[a];
                            try {
                                bufferedInputStream.read(bArr3, 0, a);
                                int i3 = (available - a) - 8;
                                byte[] bArr4 = new byte[i3];
                                try {
                                    bufferedInputStream.read(bArr4, 0, i3);
                                    String a2 = C10039a.m21116a(bArr4);
                                    try {
                                        bufferedInputStream.close();
                                        try {
                                            byte[] b = C10039a.m21122b(bArr3);
                                            try {
                                                LicenseFile licenseFile = (LicenseFile) this.f26489m.fromJson(C10039a.m21116a(b), LicenseFile.class);
                                                try {
                                                    if (!C10042d.m21131a(b, licenseFile.getPublicKey(), a2)) {
                                                        SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Verify license not pass", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 329);
                                                        return -4;
                                                    }
                                                    iFXModel.f26524o = licenseFile;
                                                    iFXModel.f26521l = licenseFile.getUpdateTimestamp();
                                                    long heartbeatTime = iFXModel.f26524o.getHeartbeatTime();
                                                    long heartbeatBias = iFXModel.f26524o.getHeartbeatBias();
                                                    if (heartbeatTime >= 0 && heartbeatBias >= 0) {
                                                        iFXModel.f26519j = heartbeatTime;
                                                        iFXModel.f26520k = heartbeatBias;
                                                    }
                                                    return 0;
                                                } catch (Throwable th) {
                                                    SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] Verify license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 340);
                                                    this.f26499w.mo77460a("IFXLicenseClientError", th);
                                                    return -3;
                                                }
                                            } catch (Throwable th2) {
                                                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Parse license file info fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 342);
                                                this.f26499w.mo77460a("IFXLicenseClientError", th2);
                                                return -3;
                                            }
                                        } catch (Throwable th3) {
                                            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Decode license data fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 344);
                                            this.f26499w.mo77460a("IFXLicenseClientError", th3);
                                            return -3;
                                        }
                                    } catch (Throwable th4) {
                                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Close ifx.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 346);
                                        this.f26499w.mo77460a("IFXLicenseClientError", th4);
                                        return -2;
                                    }
                                } catch (Throwable th5) {
                                    SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read signature in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 348);
                                    this.f26499w.mo77460a("IFXLicenseClientError", th5);
                                    return -2;
                                }
                            } catch (Throwable th6) {
                                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read license content in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 350);
                                this.f26499w.mo77460a("IFXLicenseClientError", th6);
                                return -2;
                            }
                        } catch (Throwable th7) {
                            SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read license content in ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 352);
                            this.f26499w.mo77460a("IFXLicenseClientError", th7);
                            return -2;
                        }
                    } catch (Throwable th8) {
                        SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 354);
                        this.f26499w.mo77460a("IFXLicenseClientError", th8);
                        return -2;
                    }
                } catch (Throwable th9) {
                    SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 356);
                    this.f26499w.mo77460a("IFXLicenseClientError", th9);
                    return -2;
                }
            } catch (IOException e) {
                SystemUtils.log(6, "IFXLicenseClient", "Model[" + i + "] Read ifx.v2.license size fail", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 358);
                this.f26499w.mo77460a("IFXLicenseClientError", (Throwable) e);
                return -2;
            }
        } catch (FileNotFoundException unused) {
            SystemUtils.log(4, "IFXLicenseClient", "Model[" + i + "] File ifx.v2.license does not exist", (Throwable) null, "com.didi.ifx.license.IFXLicenseClient", 360);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20970b(String str, String str2, String str3) {
        int length = str2.length();
        int length2 = str3.length();
        FileOutputStream openFileOutput = this.f26482f.openFileOutput(str, 0);
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
}
