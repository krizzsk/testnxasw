package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

final class RealCall implements Call {

    /* renamed from: a */
    final OkHttpClient f7082a;

    /* renamed from: b */
    final RetryAndFollowUpInterceptor f7083b;

    /* renamed from: c */
    final AsyncTimeout f7084c;

    /* renamed from: d */
    final Request f7085d;

    /* renamed from: e */
    final boolean f7086e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f */
    public EventListener f7087f;

    /* renamed from: g */
    private boolean f7088g;

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.f7082a = okHttpClient;
        this.f7085d = request;
        this.f7086e = z;
        this.f7083b = new RetryAndFollowUpInterceptor(okHttpClient, z);
        C29941 r4 = new AsyncTimeout() {
            /* access modifiers changed from: protected */
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.f7084c = r4;
        r4.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    static RealCall m6765a(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.f7087f = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    public Request request() {
        return this.f7085d;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.f7088g) {
                this.f7088g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m6766f();
        this.f7084c.enter();
        this.f7087f.callStart(this);
        try {
            this.f7082a.dispatcher().mo30016a(this);
            Response e = mo30259e();
            if (e != null) {
                this.f7082a.dispatcher().mo30018b(this);
                return e;
            }
            throw new IOException("Canceled");
        } catch (IOException e2) {
            IOException a = mo30254a(e2);
            this.f7087f.callFailed(this, a);
            throw a;
        } catch (Throwable th) {
            this.f7082a.dispatcher().mo30018b(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public IOException mo30254a(@Nullable IOException iOException) {
        if (!this.f7084c.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: f */
    private void m6766f() {
        this.f7083b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.f7088g) {
                this.f7088g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m6766f();
        this.f7087f.callStart(this);
        this.f7082a.dispatcher().mo30015a(new AsyncCall(callback));
    }

    public void cancel() {
        this.f7083b.cancel();
    }

    public Timeout timeout() {
        return this.f7084c;
    }

    public synchronized boolean isExecuted() {
        return this.f7088g;
    }

    public boolean isCanceled() {
        return this.f7083b.isCanceled();
    }

    /* renamed from: a */
    public RealCall clone() {
        return m6765a(this.f7082a, this.f7085d, this.f7086e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public StreamAllocation mo30256b() {
        return this.f7083b.streamAllocation();
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        static {
            Class<RealCall> cls = RealCall.class;
        }

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.mo30258d());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.f7085d.url().host();
        }

        /* access modifiers changed from: package-private */
        public Request request() {
            return RealCall.this.f7085d;
        }

        /* access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: package-private */
        public void executeOn(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                RealCall.this.f7087f.callFailed(RealCall.this, interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.f7082a.dispatcher().mo30017b(this);
            } catch (Throwable th) {
                RealCall.this.f7082a.dispatcher().mo30017b(this);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[Catch:{ all -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x006a A[Catch:{ all -> 0x003d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okio.AsyncTimeout r0 = r0.f7084c
                r0.enter()
                r0 = 1
                r1 = 0
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003f }
                okhttp3.Response r2 = r2.mo30259e()     // Catch:{ IOException -> 0x003f }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003f }
                okhttp3.internal.http.RetryAndFollowUpInterceptor r3 = r3.f7083b     // Catch:{ IOException -> 0x003f }
                boolean r1 = r3.isCanceled()     // Catch:{ IOException -> 0x003f }
                if (r1 == 0) goto L_0x0028
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x003b }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003b }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x003b }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x003b }
                r1.onFailure(r2, r3)     // Catch:{ IOException -> 0x003b }
                goto L_0x002f
            L_0x0028:
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x003b }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003b }
                r1.onResponse(r3, r2)     // Catch:{ IOException -> 0x003b }
            L_0x002f:
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r0 = r0.f7082a
                okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.mo30017b((okhttp3.RealCall.AsyncCall) r5)
                goto L_0x007d
            L_0x003b:
                r1 = move-exception
                goto L_0x0042
            L_0x003d:
                r0 = move-exception
                goto L_0x007e
            L_0x003f:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x0042:
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                java.io.IOException r1 = r2.mo30254a((java.io.IOException) r1)     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x006a
                okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x003d }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
                r3.<init>()     // Catch:{ all -> 0x003d }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x003d }
                okhttp3.RealCall r4 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                java.lang.String r4 = r4.mo30257c()     // Catch:{ all -> 0x003d }
                r3.append(r4)     // Catch:{ all -> 0x003d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x003d }
                r0.log(r2, r3, r1)     // Catch:{ all -> 0x003d }
                goto L_0x002f
            L_0x006a:
                okhttp3.RealCall r0 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                okhttp3.EventListener r0 = r0.f7087f     // Catch:{ all -> 0x003d }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                r0.callFailed(r2, r1)     // Catch:{ all -> 0x003d }
                okhttp3.Callback r0 = r5.responseCallback     // Catch:{ all -> 0x003d }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x003d }
                r0.onFailure(r2, r1)     // Catch:{ all -> 0x003d }
                goto L_0x002f
            L_0x007d:
                return
            L_0x007e:
                okhttp3.RealCall r1 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r1 = r1.f7082a
                okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.mo30017b((okhttp3.RealCall.AsyncCall) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.AsyncCall.execute():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo30257c() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f7086e ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(mo30258d());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo30258d() {
        return this.f7085d.url().redact();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Response mo30259e() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f7082a.interceptors());
        arrayList.add(this.f7083b);
        arrayList.add(new BridgeInterceptor(this.f7082a.cookieJar()));
        arrayList.add(new CacheInterceptor(this.f7082a.mo30172a()));
        arrayList.add(new ConnectInterceptor(this.f7082a));
        if (!this.f7086e) {
            arrayList.addAll(this.f7082a.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.f7086e));
        return new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.f7085d, this, this.f7087f, this.f7082a.connectTimeoutMillis(), this.f7082a.readTimeoutMillis(), this.f7082a.writeTimeoutMillis()).proceed(this.f7085d);
    }
}
