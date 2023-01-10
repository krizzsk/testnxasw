package didihttp.internal.connection;

import didihttp.Address;
import didihttp.Call;
import didihttp.ConnectionPool;
import didihttp.DidiHttpClient;
import didihttp.LogEventListener;
import didihttp.Route;
import didihttp.ServerCallItem;
import didihttp.internal.C21750Util;
import didihttp.internal.Internal;
import didihttp.internal.http.HttpCodec;
import didihttp.internal.http2.ConnectionShutdownException;
import didihttp.internal.http2.ErrorCode;
import didihttp.internal.http2.StreamResetException;
import didinet.NetConfig;
import didinet.NetEngine;
import didinet.NetworkStateManager;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;

public final class StreamAllocation {

    /* renamed from: a */
    static final /* synthetic */ boolean f59450a = (!StreamAllocation.class.desiredAssertionStatus());
    public final Address address;

    /* renamed from: b */
    private Route f59451b;

    /* renamed from: c */
    private final ConnectionPool f59452c;

    /* renamed from: d */
    private final Object f59453d;

    /* renamed from: e */
    private final RouteSelector f59454e;

    /* renamed from: f */
    private int f59455f;

    /* renamed from: g */
    private RealConnection f59456g;

    /* renamed from: h */
    private boolean f59457h;

    /* renamed from: i */
    private boolean f59458i;

    /* renamed from: j */
    private HttpCodec f59459j;

    /* renamed from: k */
    private Call f59460k;

    /* renamed from: l */
    private LogEventListener f59461l;

    public StreamAllocation(ConnectionPool connectionPool, Address address2, Object obj, Call call, LogEventListener logEventListener) {
        this.f59452c = connectionPool;
        this.address = address2;
        this.f59453d = obj;
        this.f59460k = call;
        this.f59461l = logEventListener;
        this.f59454e = new RouteSelector(address2, m44820a(), call, logEventListener);
    }

    public HttpCodec newStream(DidiHttpClient didiHttpClient, boolean z, ServerCallItem serverCallItem) {
        int connectTimeoutMillis = didiHttpClient.connectTimeoutMillis();
        int readTimeoutMillis = didiHttpClient.readTimeoutMillis();
        int writeTimeoutMillis = didiHttpClient.writeTimeoutMillis();
        NetEngine instance = NetEngine.getInstance();
        NetConfig netConfig = instance.getNetConfig();
        NetworkStateManager networkStateManager = instance.getNetworkStateManager();
        Address address2 = this.address;
        boolean z2 = (address2 == null || address2.sslSocketFactory() == null) ? false : true;
        if (connectTimeoutMillis == 10000) {
            connectTimeoutMillis = netConfig.getConnectTimeout(networkStateManager, z2);
        }
        if (readTimeoutMillis == 10000) {
            readTimeoutMillis = netConfig.getReadTimeout(networkStateManager, z2);
        }
        int i = readTimeoutMillis;
        if (writeTimeoutMillis == 10000) {
            writeTimeoutMillis = netConfig.getWriteTimeout(networkStateManager, z2);
        }
        int i2 = writeTimeoutMillis;
        serverCallItem.setConfigVersion(netConfig.getVersion());
        try {
            HttpCodec newCodec = m44819a(connectTimeoutMillis, i, i2, didiHttpClient.retryOnConnectionFailure(), z, serverCallItem).newCodec(didiHttpClient, this, i, i2);
            synchronized (this.f59452c) {
                this.f59459j = newCodec;
            }
            return newCodec;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r0.isHealthy(r11) != false) goto L_0x001e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private didihttp.internal.connection.RealConnection m44819a(int r7, int r8, int r9, boolean r10, boolean r11, didihttp.ServerCallItem r12) throws java.io.IOException {
        /*
            r6 = this;
        L_0x0000:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r12
            didihttp.internal.connection.RealConnection r0 = r0.m44818a(r1, r2, r3, r4, r5)
            didihttp.ConnectionPool r1 = r6.f59452c
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            return r0
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            boolean r1 = r0.isHealthy(r11)
            if (r1 != 0) goto L_0x001e
            r6.noNewStreams()
            goto L_0x0000
        L_0x001e:
            return r0
        L_0x001f:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.connection.StreamAllocation.m44819a(int, int, int, boolean, boolean, didihttp.ServerCallItem):didihttp.internal.connection.RealConnection");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        r16.traceDnsLookupStart();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        if (r4 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        r4 = r1.f59454e.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
        r16.traceDnsLookupEnd();
        r5 = r1.f59452c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.f59451b = r4;
        r1.f59455f = 0;
        r10 = new didihttp.internal.connection.RealConnection(r1.f59452c, r4, r1.f59454e);
        acquire(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        if (r1.f59458i != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005d, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
        r16.traceConnectStart();
        r10.connect(r12, r13, r14, r15, r16, r1.f59460k, r1.f59461l);
        r16.traceConnectEnd();
        m44820a().connected(r10.route());
        r0 = null;
        r2 = r1.f59452c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        didihttp.internal.Internal.instance.put(r1.f59452c, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008c, code lost:
        if (r10.isMultiplexed() == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        r0 = didihttp.internal.Internal.instance.deduplicate(r1.f59452c, r1.address, r11);
        r10 = r1.f59456g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009a, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009b, code lost:
        didihttp.internal.C21750Util.closeQuietly(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009e, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
        throw new java.io.IOException("Canceled");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private didihttp.internal.connection.RealConnection m44818a(int r12, int r13, int r14, boolean r15, didihttp.ServerCallItem r16) throws java.io.IOException {
        /*
            r11 = this;
            r1 = r11
            r0 = r16
            didihttp.ConnectionPool r2 = r1.f59452c
            monitor-enter(r2)
            boolean r3 = r1.f59457h     // Catch:{ all -> 0x00c5 }
            if (r3 != 0) goto L_0x00bd
            didihttp.internal.http.HttpCodec r3 = r1.f59459j     // Catch:{ all -> 0x00c5 }
            if (r3 != 0) goto L_0x00b5
            boolean r3 = r1.f59458i     // Catch:{ all -> 0x00c5 }
            if (r3 != 0) goto L_0x00ad
            didihttp.internal.connection.RealConnection r3 = r1.f59456g     // Catch:{ all -> 0x00c5 }
            if (r3 == 0) goto L_0x001c
            boolean r4 = r3.noNewStreams     // Catch:{ all -> 0x00c5 }
            if (r4 != 0) goto L_0x001c
            monitor-exit(r2)     // Catch:{ all -> 0x00c5 }
            return r3
        L_0x001c:
            didihttp.internal.Internal r3 = didihttp.internal.Internal.instance     // Catch:{ all -> 0x00c5 }
            didihttp.ConnectionPool r4 = r1.f59452c     // Catch:{ all -> 0x00c5 }
            didihttp.Address r5 = r1.address     // Catch:{ all -> 0x00c5 }
            r3.get(r4, r5, r11)     // Catch:{ all -> 0x00c5 }
            didihttp.internal.connection.RealConnection r3 = r1.f59456g     // Catch:{ all -> 0x00c5 }
            if (r3 == 0) goto L_0x0031
            r3 = 1
            r0.setConnReused(r3)     // Catch:{ all -> 0x00c5 }
            didihttp.internal.connection.RealConnection r0 = r1.f59456g     // Catch:{ all -> 0x00c5 }
            monitor-exit(r2)     // Catch:{ all -> 0x00c5 }
            return r0
        L_0x0031:
            r3 = 0
            r0.setConnReused(r3)     // Catch:{ all -> 0x00c5 }
            didihttp.Route r4 = r1.f59451b     // Catch:{ all -> 0x00c5 }
            monitor-exit(r2)     // Catch:{ all -> 0x00c5 }
            r16.traceDnsLookupStart()
            if (r4 != 0) goto L_0x0043
            didihttp.internal.connection.RouteSelector r2 = r1.f59454e
            didihttp.Route r4 = r2.next()
        L_0x0043:
            r16.traceDnsLookupEnd()
            didihttp.ConnectionPool r5 = r1.f59452c
            monitor-enter(r5)
            r1.f59451b = r4     // Catch:{ all -> 0x00aa }
            r1.f59455f = r3     // Catch:{ all -> 0x00aa }
            didihttp.internal.connection.RealConnection r10 = new didihttp.internal.connection.RealConnection     // Catch:{ all -> 0x00aa }
            didihttp.ConnectionPool r2 = r1.f59452c     // Catch:{ all -> 0x00aa }
            didihttp.internal.connection.RouteSelector r3 = r1.f59454e     // Catch:{ all -> 0x00aa }
            r10.<init>(r2, r4, r3)     // Catch:{ all -> 0x00aa }
            r11.acquire(r10)     // Catch:{ all -> 0x00aa }
            boolean r2 = r1.f59458i     // Catch:{ all -> 0x00aa }
            if (r2 != 0) goto L_0x00a2
            monitor-exit(r5)     // Catch:{ all -> 0x00aa }
            r16.traceConnectStart()
            didihttp.Call r8 = r1.f59460k
            didihttp.LogEventListener r9 = r1.f59461l
            r2 = r10
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r2.connect(r3, r4, r5, r6, r7, r8, r9)
            r16.traceConnectEnd()
            didihttp.internal.connection.RouteDatabase r0 = r11.m44820a()
            didihttp.Route r2 = r10.route()
            r0.connected(r2)
            r0 = 0
            didihttp.ConnectionPool r2 = r1.f59452c
            monitor-enter(r2)
            didihttp.internal.Internal r3 = didihttp.internal.Internal.instance     // Catch:{ all -> 0x009f }
            didihttp.ConnectionPool r4 = r1.f59452c     // Catch:{ all -> 0x009f }
            r3.put(r4, r10)     // Catch:{ all -> 0x009f }
            boolean r3 = r10.isMultiplexed()     // Catch:{ all -> 0x009f }
            if (r3 == 0) goto L_0x009a
            didihttp.internal.Internal r0 = didihttp.internal.Internal.instance     // Catch:{ all -> 0x009f }
            didihttp.ConnectionPool r3 = r1.f59452c     // Catch:{ all -> 0x009f }
            didihttp.Address r4 = r1.address     // Catch:{ all -> 0x009f }
            java.net.Socket r0 = r0.deduplicate(r3, r4, r11)     // Catch:{ all -> 0x009f }
            didihttp.internal.connection.RealConnection r10 = r1.f59456g     // Catch:{ all -> 0x009f }
        L_0x009a:
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            didihttp.internal.C21750Util.closeQuietly((java.net.Socket) r0)
            return r10
        L_0x009f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            throw r0
        L_0x00a2:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)     // Catch:{ all -> 0x00aa }
            throw r0     // Catch:{ all -> 0x00aa }
        L_0x00aa:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00aa }
            throw r0
        L_0x00ad:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = "Canceled"
            r0.<init>(r3)     // Catch:{ all -> 0x00c5 }
            throw r0     // Catch:{ all -> 0x00c5 }
        L_0x00b5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = "codec != null"
            r0.<init>(r3)     // Catch:{ all -> 0x00c5 }
            throw r0     // Catch:{ all -> 0x00c5 }
        L_0x00bd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = "released"
            r0.<init>(r3)     // Catch:{ all -> 0x00c5 }
            throw r0     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00c5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.connection.StreamAllocation.m44818a(int, int, int, boolean, didihttp.ServerCallItem):didihttp.internal.connection.RealConnection");
    }

    public void streamFinished(boolean z, HttpCodec httpCodec) {
        Socket a;
        synchronized (this.f59452c) {
            if (httpCodec != null) {
                if (httpCodec == this.f59459j) {
                    if (!z) {
                        this.f59456g.successCount++;
                    }
                    a = m44821a(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.f59459j + " but was " + httpCodec);
        }
        C21750Util.closeQuietly(a);
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.f59452c) {
            httpCodec = this.f59459j;
        }
        return httpCodec;
    }

    /* renamed from: a */
    private RouteDatabase m44820a() {
        return Internal.instance.routeDatabase(this.f59452c);
    }

    public synchronized RealConnection connection() {
        return this.f59456g;
    }

    public void release() {
        Socket a;
        synchronized (this.f59452c) {
            a = m44821a(false, true, false);
        }
        C21750Util.closeQuietly(a);
    }

    public void noNewStreams() {
        Socket a;
        synchronized (this.f59452c) {
            a = m44821a(true, false, false);
        }
        C21750Util.closeQuietly(a);
    }

    /* renamed from: a */
    private Socket m44821a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f59450a || Thread.holdsLock(this.f59452c)) {
            if (z3) {
                this.f59459j = null;
            }
            if (z2) {
                this.f59457h = true;
            }
            RealConnection realConnection = this.f59456g;
            if (realConnection == null) {
                return null;
            }
            if (z) {
                realConnection.noNewStreams = true;
            }
            if (this.f59459j != null) {
                return null;
            }
            if (!this.f59457h && !this.f59456g.noNewStreams) {
                return null;
            }
            m44822a(this.f59456g);
            if (this.f59456g.allocations.isEmpty()) {
                this.f59456g.idleAtNanos = System.nanoTime();
                if (Internal.instance.connectionBecameIdle(this.f59452c, this.f59456g)) {
                    socket = this.f59456g.socket();
                    this.f59456g = null;
                    return socket;
                }
            }
            socket = null;
            this.f59456g = null;
            return socket;
        }
        throw new AssertionError();
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.f59452c) {
            this.f59458i = true;
            httpCodec = this.f59459j;
            realConnection = this.f59456g;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public void streamFailed(IOException iOException) {
        boolean z;
        Socket a;
        synchronized (this.f59452c) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.errorCode == ErrorCode.REFUSED_STREAM) {
                    this.f59455f++;
                }
                if (streamResetException.errorCode != ErrorCode.REFUSED_STREAM || this.f59455f > 1) {
                    this.f59451b = null;
                }
                z = false;
                a = m44821a(z, false, true);
            } else {
                if (this.f59456g != null && (!this.f59456g.isMultiplexed() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.f59456g.successCount == 0) {
                        if (!(this.f59451b == null || iOException == null)) {
                            this.f59454e.connectFailed(this.f59451b, iOException);
                        }
                        this.f59451b = null;
                    }
                }
                z = false;
                a = m44821a(z, false, true);
            }
            z = true;
            a = m44821a(z, false, true);
        }
        C21750Util.closeQuietly(a);
    }

    public void acquire(RealConnection realConnection) {
        if (!f59450a && !Thread.holdsLock(this.f59452c)) {
            throw new AssertionError();
        } else if (this.f59456g == null) {
            this.f59456g = realConnection;
            realConnection.allocations.add(new StreamAllocationReference(this, this.f59453d));
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private void m44822a(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.allocations.get(i).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (!f59450a && !Thread.holdsLock(this.f59452c)) {
            throw new AssertionError();
        } else if (this.f59459j == null && this.f59456g.allocations.size() == 1) {
            Socket a = m44821a(true, false, false);
            this.f59456g = realConnection;
            realConnection.allocations.add(this.f59456g.allocations.get(0));
            return a;
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean hasMoreRoutes() {
        return this.f59451b != null || this.f59454e.hasNext();
    }

    public void resetProxyIfNoRoutes() {
        if (this.f59451b == null && !this.f59454e.hasInetSocketAddress()) {
            this.f59454e.resetProxy();
        }
    }

    public String toString() {
        RealConnection connection = connection();
        return connection != null ? connection.toString() : this.address.toString();
    }

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }
}
