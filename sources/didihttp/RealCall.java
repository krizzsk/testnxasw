package didihttp;

import android.os.Process;
import androidx.core.app.NotificationCompat;
import didihttp.DefaultLogEventHandle;
import didihttp.Interceptor;
import didihttp.LogEventListener;
import didihttp.internal.NamedRunnable;
import didihttp.internal.cache.CacheInterceptor;
import didihttp.internal.connection.ConnectInterceptor;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.http.BridgeInterceptor;
import didihttp.internal.http.CallServerInterceptor;
import didihttp.internal.http.HttpCodec;
import didihttp.internal.http.RealInterceptorChain;
import didihttp.internal.http.RetryAndFollowUpInterceptor;
import didihttp.internal.platform.Platform;
import didihttp.internal.trace.Tree;
import didihttp.logging.HttpLoggingInterceptor;
import didihttpdns.HttpDnsApolloConfig;
import didihttpdns.HttpDnsSwitchInterceptor;
import didinet.NetConfig;
import didinet.NetEngine;
import didinet.ParamInterceptor;
import diditransreq.ConnectSwitcherInterceptor;
import diditransreq.Http2SocketInterceptor;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;

final class RealCall implements Call {

    /* renamed from: e */
    private static LogEventListener.Factory f59246e = new DefaultLogEventHandle.FACTORY();

    /* renamed from: a */
    final DidiHttpClient f59247a;

    /* renamed from: b */
    final RetryAndFollowUpInterceptor f59248b;

    /* renamed from: c */
    final Request f59249c;

    /* renamed from: d */
    final boolean f59250d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LogEventListener f59251f;

    /* renamed from: g */
    private boolean f59252g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public StatisticalContext f59253h;

    private RealCall(DidiHttpClient didiHttpClient, Request request, boolean z) {
        this.f59247a = didiHttpClient;
        this.f59249c = request;
        this.f59250d = z;
        this.f59248b = new RetryAndFollowUpInterceptor(didiHttpClient, z);
        this.f59253h = new StatisticalContext(didiHttpClient, this);
    }

    /* renamed from: a */
    static RealCall m44750a(DidiHttpClient didiHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(didiHttpClient, request, z);
        realCall.f59251f = f59246e.create(realCall);
        return realCall;
    }

    public Request request() {
        return this.f59249c;
    }

    public Response execute() throws IOException {
        this.f59253h.traceTotalStartTime();
        synchronized (this) {
            if (!this.f59252g) {
                this.f59252g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f59251f.callStart(this, Process.myTid());
        m44755f();
        try {
            this.f59247a.dispatcher().mo179389a(this);
            Response e = mo179531e();
            if (e != null) {
                this.f59251f.callEnd(this);
                this.f59247a.dispatcher().mo179391b(this);
                return e;
            }
            throw new IOException("Canceled");
        } catch (IOException e2) {
            this.f59251f.callFailed(this, e2);
            throw e2;
        } catch (Throwable th) {
            this.f59251f.callEnd(this);
            this.f59247a.dispatcher().mo179391b(this);
            throw th;
        }
    }

    /* renamed from: f */
    private void m44755f() {
        this.f59248b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.f59252g) {
                this.f59252g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f59251f.enqueue(this);
        m44755f();
        this.f59253h.traceTotalStartTime();
        this.f59247a.dispatcher().mo179388a(new AsyncCall(callback));
    }

    public void cancel() {
        this.f59248b.cancel();
    }

    public synchronized boolean isExecuted() {
        return this.f59252g;
    }

    public boolean isCanceled() {
        return this.f59248b.isCanceled();
    }

    /* renamed from: a */
    public RealCall clone() {
        return m44750a(this.f59247a, this.f59249c, this.f59250d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public StreamAllocation mo179528b() {
        return this.f59248b.streamAllocation();
    }

    final class AsyncCall extends NamedRunnable {
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.mo179530d());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.f59249c.url().hostAndPath();
        }

        /* access modifiers changed from: package-private */
        public Request request() {
            return RealCall.this.f59249c;
        }

        /* access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0098 A[Catch:{ all -> 0x0087 }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x00b8 A[Catch:{ all -> 0x0087 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r6 = this;
                didihttp.RealCall r0 = didihttp.RealCall.this
                didihttp.StatisticalContext r0 = r0.f59253h
                r0.traceExecuteTime()
                int r0 = android.os.Process.myTid()
                didihttp.RealCall r1 = didihttp.RealCall.this
                didihttp.LogEventListener r1 = r1.f59251f
                didihttp.RealCall r2 = didihttp.RealCall.this
                r1.callStart(r2, r0)
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.String r0 = r0.getName()
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r2 = 1
                java.lang.Object[] r3 = new java.lang.Object[r2]
                didihttp.RealCall r4 = didihttp.RealCall.this
                didihttp.Request r4 = r4.f59249c
                didihttp.HttpUrl r4 = r4.f59254a
                java.lang.String r4 = r4.toString()
                java.lang.String r4 = didihttp.RealCall.m44752a((java.lang.String) r4)
                r5 = 0
                r3[r5] = r4
                java.lang.String r4 = "OneNet %s"
                java.lang.String r3 = java.lang.String.format(r4, r3)
                r1.setName(r3)
                didihttp.RealCall r1 = didihttp.RealCall.this     // Catch:{ IOException -> 0x0089 }
                didihttp.Response r1 = r1.mo179531e()     // Catch:{ IOException -> 0x0089 }
                didihttp.RealCall r3 = didihttp.RealCall.this     // Catch:{ IOException -> 0x0089 }
                didihttp.internal.http.RetryAndFollowUpInterceptor r3 = r3.f59248b     // Catch:{ IOException -> 0x0089 }
                boolean r3 = r3.isCanceled()     // Catch:{ IOException -> 0x0089 }
                if (r3 == 0) goto L_0x0060
                didihttp.Callback r1 = r6.responseCallback     // Catch:{ IOException -> 0x0085 }
                didihttp.RealCall r3 = didihttp.RealCall.this     // Catch:{ IOException -> 0x0085 }
                java.io.IOException r4 = new java.io.IOException     // Catch:{ IOException -> 0x0085 }
                java.lang.String r5 = "Canceled"
                r4.<init>(r5)     // Catch:{ IOException -> 0x0085 }
                r1.onFailure(r3, r4)     // Catch:{ IOException -> 0x0085 }
                goto L_0x0067
            L_0x0060:
                didihttp.Callback r3 = r6.responseCallback     // Catch:{ IOException -> 0x0085 }
                didihttp.RealCall r4 = didihttp.RealCall.this     // Catch:{ IOException -> 0x0085 }
                r3.onResponse(r4, r1)     // Catch:{ IOException -> 0x0085 }
            L_0x0067:
                didihttp.RealCall r1 = didihttp.RealCall.this
                didihttp.LogEventListener r1 = r1.f59251f
                didihttp.RealCall r2 = didihttp.RealCall.this
                r1.callEnd(r2)
                didihttp.RealCall r1 = didihttp.RealCall.this
                didihttp.DidiHttpClient r1 = r1.f59247a
                didihttp.Dispatcher r1 = r1.dispatcher()
                r1.mo179390b((didihttp.RealCall.AsyncCall) r6)
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.setName(r0)
                goto L_0x00c0
            L_0x0085:
                r1 = move-exception
                goto L_0x008b
            L_0x0087:
                r1 = move-exception
                goto L_0x00c1
            L_0x0089:
                r1 = move-exception
                r2 = 0
            L_0x008b:
                didihttp.RealCall r3 = didihttp.RealCall.this     // Catch:{ all -> 0x0087 }
                didihttp.LogEventListener r3 = r3.f59251f     // Catch:{ all -> 0x0087 }
                didihttp.RealCall r4 = didihttp.RealCall.this     // Catch:{ all -> 0x0087 }
                r3.callFailed(r4, r1)     // Catch:{ all -> 0x0087 }
                if (r2 == 0) goto L_0x00b8
                didihttp.internal.platform.Platform r2 = didihttp.internal.platform.Platform.get()     // Catch:{ all -> 0x0087 }
                r3 = 4
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
                r4.<init>()     // Catch:{ all -> 0x0087 }
                java.lang.String r5 = "Callback failure for "
                r4.append(r5)     // Catch:{ all -> 0x0087 }
                didihttp.RealCall r5 = didihttp.RealCall.this     // Catch:{ all -> 0x0087 }
                java.lang.String r5 = r5.mo179529c()     // Catch:{ all -> 0x0087 }
                r4.append(r5)     // Catch:{ all -> 0x0087 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0087 }
                r2.log(r3, r4, r1)     // Catch:{ all -> 0x0087 }
                goto L_0x0067
            L_0x00b8:
                didihttp.Callback r2 = r6.responseCallback     // Catch:{ all -> 0x0087 }
                didihttp.RealCall r3 = didihttp.RealCall.this     // Catch:{ all -> 0x0087 }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x0087 }
                goto L_0x0067
            L_0x00c0:
                return
            L_0x00c1:
                didihttp.RealCall r2 = didihttp.RealCall.this
                didihttp.LogEventListener r2 = r2.f59251f
                didihttp.RealCall r3 = didihttp.RealCall.this
                r2.callEnd(r3)
                didihttp.RealCall r2 = didihttp.RealCall.this
                didihttp.DidiHttpClient r2 = r2.f59247a
                didihttp.Dispatcher r2 = r2.dispatcher()
                r2.mo179390b((didihttp.RealCall.AsyncCall) r6)
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                r2.setName(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.RealCall.AsyncCall.execute():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo179529c() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f59250d ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(mo179530d());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo179530d() {
        return this.f59249c.url().redact();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Response mo179531e() throws IOException {
        NetConfig.UrlConfig urlConfig;
        this.f59253h.newServerCallData();
        Tree tree = new Tree();
        this.f59253h.setInterceptorCallTree(tree);
        NetEngine instance = NetEngine.getInstance();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f59247a.interceptors());
            arrayList.add(new Interceptor() {
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    ((StatisticalContext) ((RealInterceptorChain) chain).getExtraData()).mo179700a(request);
                    return chain.proceed(request);
                }
            });
            if (NetEngine.getInstance().getNetConfig().isReportRawData() && (urlConfig = NetEngine.getInstance().getNetConfig().getUrlConfig(request().f59254a)) != null && urlConfig.isReportRawData()) {
                arrayList.add(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    public void log(String str) {
                        StatisticalContext a = RealCall.this.f59253h;
                        a.appendRawHttpData(str + "\n");
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BODY));
            }
            arrayList.add(new ParamInterceptor());
            Interceptor transformInterceptor = instance.getTransformInterceptor();
            if (transformInterceptor != null) {
                arrayList.add(transformInterceptor);
            } else if (!this.f59247a.f59156E) {
                arrayList.add(new HttpDnsSwitchInterceptor());
            }
            arrayList.add(this.f59248b);
            arrayList.add(new BridgeInterceptor(this.f59247a.cookieJar()));
            arrayList.add(new CacheInterceptor(this.f59247a.mo179301a()));
            arrayList.add(new ConnectSwitcherInterceptor(new ConnectInterceptor(this.f59247a)));
            if (!this.f59250d) {
                arrayList.addAll(this.f59247a.networkInterceptors());
            }
            arrayList.add(new Http2SocketInterceptor());
            arrayList.add(new CallServerInterceptor(this.f59250d));
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (Connection) null, 0, this.f59249c, this, this.f59251f, tree);
            realInterceptorChain.setExtraData(this.f59253h);
            Response proceed = realInterceptorChain.proceed(this.f59249c);
            m44753a(this.f59253h);
            return proceed;
        } catch (Throwable th) {
            tree.popAll();
            this.f59253h.mo179701a(th);
            m44753a(this.f59253h);
            if ((th instanceof SecurityException) || (th instanceof UnsatisfiedLinkError) || (th instanceof IllegalArgumentException)) {
                throw new IOException(th);
            }
            throw th;
        }
    }

    /* renamed from: a */
    private void m44753a(StatisticalContext statisticalContext) {
        statisticalContext.traceTotalEndTime();
        if (HttpDnsApolloConfig.getConfig().isDegenerateIpv6Detect() && !statisticalContext.hasError() && (statisticalContext.currentServerCallData().getRemoteAddress() instanceof Inet4Address)) {
            HttpDnsApolloConfig.getConfig().setEnableIpv6Apollo(true);
        }
        if (this.f59247a.f59155D) {
            for (StatisticalCallback next : NetEngine.getInstance().getStatisticalCallbacks()) {
                if (next != null) {
                    try {
                        next.onStatisticalDataCallback(statisticalContext);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (this.f59247a.f59154C != null) {
            try {
                this.f59247a.f59154C.onStatisticalDataCallback(statisticalContext);
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: a */
    static String m44752a(String str) {
        int indexOf = str.indexOf(63);
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
