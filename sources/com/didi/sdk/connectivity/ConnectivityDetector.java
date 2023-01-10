package com.didi.sdk.connectivity;

import android.content.Context;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.connectivity.NetworkChangeHandler;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectivityDetector {

    /* renamed from: a */
    private static final String f38489a = "didi-connectivity";

    /* renamed from: b */
    private static ConnectivityDetector f38490b = null;

    /* renamed from: i */
    private static final int f38491i = 1000;

    /* renamed from: c */
    private AtomicBoolean f38492c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f38493d;

    /* renamed from: e */
    private ExecutorService f38494e = new ThreadPoolExecutor(0, 10, 60, TimeUnit.SECONDS, new SynchronousQueue(), new C12994e(f38489a, false), new ThreadPoolExecutor.DiscardPolicy() {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (!threadPoolExecutor.isShutdown() && (runnable instanceof FutureTask)) {
                ((FutureTask) runnable).cancel(true);
            }
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Config f38495f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f38496g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile long f38497h;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile ConnectivityStatistics f38498j;

    private ConnectivityDetector() {
    }

    public static ConnectivityDetector getsInstance() {
        if (f38490b == null) {
            synchronized (ConnectivityDetector.class) {
                if (f38490b == null) {
                    f38490b = new ConnectivityDetector();
                }
            }
        }
        return f38490b;
    }

    public void init(Context context) {
        this.f38493d = context.getApplicationContext();
        if (this.f38492c.compareAndSet(false, true)) {
            NetworkChangeHandler.m29035a().mo97877a(context);
            NetworkChangeHandler.m29035a().mo97878a((NetworkChangeHandler.NetworkChangedCallback) new NetworkChangeHandler.NetworkChangedCallback() {
                public void onAvailable(Context context) {
                    if (ConnectivityDetector.this.f38495f != null) {
                        C12992c.m29060a(String.format("无网到有网，触发连通性检测。[当前网络 %s]", new Object[]{NetworkChangeHandler.m29037d(context)}));
                        ConnectivityDetector.this.detect();
                    }
                }

                public void onLost(Context context) {
                    if (ConnectivityDetector.this.f38495f != null) {
                        String d = NetworkChangeHandler.m29037d(context);
                        C12992c.m29060a(String.format("网络断开，当前网络[%s]", new Object[]{d}));
                        if (ConnectivityDetector.this.f38498j == null || ConnectivityDetector.this.f38498j.f38511l != ConnectivityStatusSource.NETWORK_CHANGED || ConnectivityDetector.this.f38498j.f38510k != ConnectivityStatus.UNREACHABLE) {
                            ConnectivityDetector connectivityDetector = ConnectivityDetector.this;
                            ConnectivityStatistics unused = connectivityDetector.f38498j = ConnectivityStatistics.m29032a(false, connectivityDetector.f38495f, d);
                        }
                    }
                }
            });
            Config config = (Config) new C12990a().provider();
            this.f38495f = config;
            if (config != null) {
                this.f38498j = ConnectivityStatistics.m29031a(NetworkChangeHandler.m29037d(context));
            }
        }
    }

    public void detect() {
        detect((String) null, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if ((java.lang.System.currentTimeMillis() - r13.f38497h) >= ((long) (r13.f38495f.f38482e * 1000))) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        com.didi.sdk.connectivity.C12992c.m29060a("距离上次检测小于阈值，本次退出！");
        r13.f38496g = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        r1 = new java.util.ArrayList();
        r2 = r13.f38495f.f38486i.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        if (r2.hasNext() == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        r3 = r2.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (com.didi.one.netdetect.util.NetUtil.isIpAddress(r3.host) == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r4 = didihttpdns.HttpDnsManager.getInstance().lookup(r3.f38487ip);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        r3.f38487ip = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0076, code lost:
        if (android.text.TextUtils.isEmpty(r14) != false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        if (r15 <= 0) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        r6 = new com.didi.sdk.connectivity.Config.Item(r14, r15, r13.f38495f.f38480c, r13.f38495f.f38483f, r13.f38495f.f38484g, r13.f38495f.f38485h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0096, code lost:
        if (com.didi.one.netdetect.util.NetUtil.isIpAddress(r14) == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        r1.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        r14 = didihttpdns.HttpDnsManager.getInstance().lookup(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a8, code lost:
        if (android.text.TextUtils.isEmpty(r14) != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        r6.f38487ip = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ac, code lost:
        r1.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b3, code lost:
        if (r1.size() != 0) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b5, code lost:
        r13.f38496g = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b8, code lost:
        r13.f38497h = java.lang.System.currentTimeMillis();
        com.didi.sdk.connectivity.C12992c.m29060a(java.lang.String.format("开始检测[当前网络 %s]", new java.lang.Object[]{com.didi.sdk.connectivity.NetworkChangeHandler.m29037d(r13.f38493d)}));
        r14 = r13.f38494e;
        r14.execute(new com.didi.sdk.connectivity.Task(r13.f38493d, r14, r1, new com.didi.sdk.connectivity.ConnectivityDetector.C129793(r13)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void detect(java.lang.String r14, int r15) {
        /*
            r13 = this;
            com.didi.sdk.connectivity.Config r0 = r13.f38495f
            if (r0 == 0) goto L_0x00e7
            android.content.Context r0 = r13.f38493d
            if (r0 != 0) goto L_0x000a
            goto L_0x00e7
        L_0x000a:
            monitor-enter(r13)
            boolean r0 = r13.f38496g     // Catch:{ all -> 0x00e4 }
            if (r0 == 0) goto L_0x0017
            java.lang.String r14 = "正在检测，本次退出！"
            com.didi.sdk.connectivity.C12992c.m29060a((java.lang.String) r14)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r13)     // Catch:{ all -> 0x00e4 }
            return
        L_0x0017:
            r0 = 1
            r13.f38496g = r0     // Catch:{ all -> 0x00e4 }
            monitor-exit(r13)     // Catch:{ all -> 0x00e4 }
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r13.f38497h
            long r1 = r1 - r3
            com.didi.sdk.connectivity.Config r3 = r13.f38495f
            int r3 = r3.f38482e
            int r3 = r3 * 1000
            long r3 = (long) r3
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0037
            java.lang.String r14 = "距离上次检测小于阈值，本次退出！"
            com.didi.sdk.connectivity.C12992c.m29060a((java.lang.String) r14)
            r13.f38496g = r5
            return
        L_0x0037:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.didi.sdk.connectivity.Config r2 = r13.f38495f
            java.util.List<com.didi.sdk.connectivity.Config$Item> r2 = r2.f38486i
            java.util.Iterator r2 = r2.iterator()
        L_0x0044:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0072
            java.lang.Object r3 = r2.next()
            com.didi.sdk.connectivity.Config$Item r3 = (com.didi.sdk.connectivity.Config.Item) r3
            java.lang.String r4 = r3.host
            boolean r4 = com.didi.one.netdetect.util.NetUtil.isIpAddress(r4)
            if (r4 == 0) goto L_0x005c
            r1.add(r3)
            goto L_0x0044
        L_0x005c:
            didihttpdns.HttpDnsManager r4 = didihttpdns.HttpDnsManager.getInstance()
            java.lang.String r6 = r3.f38487ip
            java.lang.String r4 = r4.lookup(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x006e
            r3.f38487ip = r4
        L_0x006e:
            r1.add(r3)
            goto L_0x0044
        L_0x0072:
            boolean r2 = android.text.TextUtils.isEmpty(r14)
            if (r2 != 0) goto L_0x00af
            if (r15 <= 0) goto L_0x00af
            com.didi.sdk.connectivity.Config$Item r2 = new com.didi.sdk.connectivity.Config$Item
            com.didi.sdk.connectivity.Config r3 = r13.f38495f
            int r9 = r3.f38480c
            com.didi.sdk.connectivity.Config r3 = r13.f38495f
            int r10 = r3.f38483f
            com.didi.sdk.connectivity.Config r3 = r13.f38495f
            int r11 = r3.f38484g
            com.didi.sdk.connectivity.Config r3 = r13.f38495f
            int r12 = r3.f38485h
            r6 = r2
            r7 = r14
            r8 = r15
            r6.<init>(r7, r8, r9, r10, r11, r12)
            boolean r15 = com.didi.one.netdetect.util.NetUtil.isIpAddress(r14)
            if (r15 == 0) goto L_0x009c
            r1.add(r2)
            goto L_0x00af
        L_0x009c:
            didihttpdns.HttpDnsManager r15 = didihttpdns.HttpDnsManager.getInstance()
            java.lang.String r14 = r15.lookup(r14)
            boolean r15 = android.text.TextUtils.isEmpty(r14)
            if (r15 != 0) goto L_0x00ac
            r2.f38487ip = r14
        L_0x00ac:
            r1.add(r2)
        L_0x00af:
            int r14 = r1.size()
            if (r14 != 0) goto L_0x00b8
            r13.f38496g = r5
            return
        L_0x00b8:
            long r14 = java.lang.System.currentTimeMillis()
            r13.f38497h = r14
            java.lang.String r14 = "开始检测[当前网络 %s]"
            java.lang.Object[] r15 = new java.lang.Object[r0]
            android.content.Context r0 = r13.f38493d
            java.lang.String r0 = com.didi.sdk.connectivity.NetworkChangeHandler.m29037d(r0)
            r15[r5] = r0
            java.lang.String r14 = java.lang.String.format(r14, r15)
            com.didi.sdk.connectivity.C12992c.m29060a((java.lang.String) r14)
            java.util.concurrent.ExecutorService r14 = r13.f38494e
            com.didi.sdk.connectivity.Task r15 = new com.didi.sdk.connectivity.Task
            android.content.Context r0 = r13.f38493d
            com.didi.sdk.connectivity.ConnectivityDetector$3 r2 = new com.didi.sdk.connectivity.ConnectivityDetector$3
            r2.<init>()
            r15.<init>(r0, r14, r1, r2)
            r14.execute(r15)
            return
        L_0x00e4:
            r14 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x00e4 }
            throw r14
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.connectivity.ConnectivityDetector.detect(java.lang.String, int):void");
    }

    public void trigger(String str, boolean z, Throwable th) {
        if (this.f38495f != null) {
            if (z) {
                if (this.f38498j == null || this.f38498j.f38511l != ConnectivityStatusSource.REQUEST_SUCCESS) {
                    C12992c.m29060a(String.format("%s 请求成功，标记为有网", new Object[]{str}));
                    this.f38498j = ConnectivityStatistics.m29029a(this.f38495f);
                }
            } else if (th == null || th.getMessage() == null || !th.getMessage().contains("Canceled")) {
                try {
                    URL url = new URL(str);
                    String host = url.getHost();
                    String protocol = url.getProtocol();
                    int i = "https".equals(protocol) ? 443 : "http".equals(protocol) ? 80 : 0;
                    C12992c.m29060a(String.format("%s 请求失败，触发检测", new Object[]{str}));
                    detect(host, i);
                } catch (Throwable th2) {
                    SystemUtils.log(3, f38489a, Log.getStackTraceString(th2), (Throwable) null, "com.didi.sdk.connectivity.ConnectivityDetector", 220);
                }
            }
        }
    }

    public ConnectivityStatistics getLastConnStatistics() {
        if (this.f38495f != null) {
            return this.f38498j;
        }
        return null;
    }
}
