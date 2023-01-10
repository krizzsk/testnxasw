package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.C3000Util;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpCodec;

public final class StreamAllocation {

    /* renamed from: a */
    static final /* synthetic */ boolean f7195a = (!StreamAllocation.class.desiredAssertionStatus());
    public final Address address;

    /* renamed from: b */
    private RouteSelector.Selection f7196b;

    /* renamed from: c */
    private Route f7197c;
    public final Call call;

    /* renamed from: d */
    private final ConnectionPool f7198d;

    /* renamed from: e */
    private final Object f7199e;
    public final EventListener eventListener;

    /* renamed from: f */
    private final RouteSelector f7200f;

    /* renamed from: g */
    private int f7201g;

    /* renamed from: h */
    private RealConnection f7202h;

    /* renamed from: i */
    private boolean f7203i;

    /* renamed from: j */
    private boolean f7204j;

    /* renamed from: k */
    private boolean f7205k;

    /* renamed from: l */
    private HttpCodec f7206l;

    public StreamAllocation(ConnectionPool connectionPool, Address address2, Call call2, EventListener eventListener2, Object obj) {
        this.f7198d = connectionPool;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.f7200f = new RouteSelector(address2, m6822b(), call2, eventListener2);
        this.f7199e = obj;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec newCodec = m6820a(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain, this);
            synchronized (this.f7198d) {
                this.f7206l = newCodec;
            }
            return newCodec;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x0018;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection m6820a(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.RealConnection r0 = r3.m6819a(r4, r5, r6, r7, r8)
            okhttp3.ConnectionPool r1 = r3.f7198d
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.isHealthy(r9)
            if (r1 != 0) goto L_0x0018
            r3.noNewStreams()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.m6820a(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    /* renamed from: a */
    private RealConnection m6819a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket a;
        Socket socket;
        RealConnection realConnection;
        RealConnection realConnection2;
        boolean z2;
        Route route;
        boolean z3;
        RouteSelector.Selection selection;
        synchronized (this.f7198d) {
            if (this.f7204j) {
                throw new IllegalStateException("released");
            } else if (this.f7206l != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.f7205k) {
                RealConnection realConnection3 = this.f7202h;
                a = m6817a();
                socket = null;
                if (this.f7202h != null) {
                    realConnection2 = this.f7202h;
                    realConnection = null;
                } else {
                    realConnection = realConnection3;
                    realConnection2 = null;
                }
                if (!this.f7203i) {
                    realConnection = null;
                }
                if (realConnection2 == null) {
                    Internal.instance.get(this.f7198d, this.address, this, (Route) null);
                    if (this.f7202h != null) {
                        realConnection2 = this.f7202h;
                        route = null;
                        z2 = true;
                    } else {
                        route = this.f7197c;
                    }
                } else {
                    route = null;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        C3000Util.closeQuietly(a);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (route != null || ((selection = this.f7196b) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.f7196b = this.f7200f.next();
            z3 = true;
        }
        synchronized (this.f7198d) {
            if (!this.f7205k) {
                if (z3) {
                    List<Route> all = this.f7196b.getAll();
                    int size = all.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        Route route2 = all.get(i5);
                        Internal.instance.get(this.f7198d, this.address, this, route2);
                        if (this.f7202h != null) {
                            realConnection2 = this.f7202h;
                            this.f7197c = route2;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (route == null) {
                        route = this.f7196b.next();
                    }
                    this.f7197c = route;
                    this.f7201g = 0;
                    realConnection2 = new RealConnection(this.f7198d, route);
                    acquire(realConnection2, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        m6822b().connected(realConnection2.route());
        synchronized (this.f7198d) {
            this.f7203i = true;
            Internal.instance.put(this.f7198d, realConnection2);
            if (realConnection2.isMultiplexed()) {
                socket = Internal.instance.deduplicate(this.f7198d, this.address, this);
                realConnection2 = this.f7202h;
            }
        }
        C3000Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection2);
        return realConnection2;
    }

    /* renamed from: a */
    private Socket m6817a() {
        if (f7195a || Thread.holdsLock(this.f7198d)) {
            RealConnection realConnection = this.f7202h;
            if (realConnection == null || !realConnection.noNewStreams) {
                return null;
            }
            return m6818a(false, false, true);
        }
        throw new AssertionError();
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket a;
        boolean z2;
        this.eventListener.responseBodyEnd(this.call, j);
        synchronized (this.f7198d) {
            if (httpCodec != null) {
                if (httpCodec == this.f7206l) {
                    if (!z) {
                        this.f7202h.successCount++;
                    }
                    realConnection = this.f7202h;
                    a = m6818a(z, false, true);
                    if (this.f7202h != null) {
                        realConnection = null;
                    }
                    z2 = this.f7204j;
                }
            }
            throw new IllegalStateException("expected " + this.f7206l + " but was " + httpCodec);
        }
        C3000Util.closeQuietly(a);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z2) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.callEnd(this.call);
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.f7198d) {
            httpCodec = this.f7206l;
        }
        return httpCodec;
    }

    /* renamed from: b */
    private RouteDatabase m6822b() {
        return Internal.instance.routeDatabase(this.f7198d);
    }

    public Route route() {
        return this.f7197c;
    }

    public synchronized RealConnection connection() {
        return this.f7202h;
    }

    public void release() {
        RealConnection realConnection;
        Socket a;
        synchronized (this.f7198d) {
            realConnection = this.f7202h;
            a = m6818a(false, true, false);
            if (this.f7202h != null) {
                realConnection = null;
            }
        }
        C3000Util.closeQuietly(a);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket a;
        synchronized (this.f7198d) {
            realConnection = this.f7202h;
            a = m6818a(true, false, false);
            if (this.f7202h != null) {
                realConnection = null;
            }
        }
        C3000Util.closeQuietly(a);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    /* renamed from: a */
    private Socket m6818a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f7195a || Thread.holdsLock(this.f7198d)) {
            if (z3) {
                this.f7206l = null;
            }
            if (z2) {
                this.f7204j = true;
            }
            RealConnection realConnection = this.f7202h;
            if (realConnection == null) {
                return null;
            }
            if (z) {
                realConnection.noNewStreams = true;
            }
            if (this.f7206l != null) {
                return null;
            }
            if (!this.f7204j && !this.f7202h.noNewStreams) {
                return null;
            }
            m6821a(this.f7202h);
            if (this.f7202h.allocations.isEmpty()) {
                this.f7202h.idleAtNanos = System.nanoTime();
                if (Internal.instance.connectionBecameIdle(this.f7198d, this.f7202h)) {
                    socket = this.f7202h.socket();
                    this.f7202h = null;
                    return socket;
                }
            }
            socket = null;
            this.f7202h = null;
            return socket;
        }
        throw new AssertionError();
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.f7198d) {
            this.f7205k = true;
            httpCodec = this.f7206l;
            realConnection = this.f7202h;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void streamFailed(java.io.IOException r7) {
        /*
            r6 = this;
            okhttp3.ConnectionPool r0 = r6.f7198d
            monitor-enter(r0)
            boolean r1 = r7 instanceof okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0069 }
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            okhttp3.internal.http2.StreamResetException r7 = (okhttp3.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x0069 }
            okhttp3.internal.http2.ErrorCode r7 = r7.errorCode     // Catch:{ all -> 0x0069 }
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0069 }
            if (r7 != r1) goto L_0x001c
            int r7 = r6.f7201g     // Catch:{ all -> 0x0069 }
            int r7 = r7 + r4
            r6.f7201g = r7     // Catch:{ all -> 0x0069 }
            if (r7 <= r4) goto L_0x004a
            r6.f7197c = r3     // Catch:{ all -> 0x0069 }
            goto L_0x0048
        L_0x001c:
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ all -> 0x0069 }
            if (r7 == r1) goto L_0x004a
            r6.f7197c = r3     // Catch:{ all -> 0x0069 }
            goto L_0x0048
        L_0x0023:
            okhttp3.internal.connection.RealConnection r1 = r6.f7202h     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x004a
            okhttp3.internal.connection.RealConnection r1 = r6.f7202h     // Catch:{ all -> 0x0069 }
            boolean r1 = r1.isMultiplexed()     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0033
            boolean r1 = r7 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x004a
        L_0x0033:
            okhttp3.internal.connection.RealConnection r1 = r6.f7202h     // Catch:{ all -> 0x0069 }
            int r1 = r1.successCount     // Catch:{ all -> 0x0069 }
            if (r1 != 0) goto L_0x0048
            okhttp3.Route r1 = r6.f7197c     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0046
            if (r7 == 0) goto L_0x0046
            okhttp3.internal.connection.RouteSelector r1 = r6.f7200f     // Catch:{ all -> 0x0069 }
            okhttp3.Route r5 = r6.f7197c     // Catch:{ all -> 0x0069 }
            r1.connectFailed(r5, r7)     // Catch:{ all -> 0x0069 }
        L_0x0046:
            r6.f7197c = r3     // Catch:{ all -> 0x0069 }
        L_0x0048:
            r7 = 1
            goto L_0x004b
        L_0x004a:
            r7 = 0
        L_0x004b:
            okhttp3.internal.connection.RealConnection r1 = r6.f7202h     // Catch:{ all -> 0x0069 }
            java.net.Socket r7 = r6.m6818a(r7, r2, r4)     // Catch:{ all -> 0x0069 }
            okhttp3.internal.connection.RealConnection r2 = r6.f7202h     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005b
            boolean r2 = r6.f7203i     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r3 = r1
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            okhttp3.internal.C3000Util.closeQuietly((java.net.Socket) r7)
            if (r3 == 0) goto L_0x0068
            okhttp3.EventListener r7 = r6.eventListener
            okhttp3.Call r0 = r6.call
            r7.connectionReleased(r0, r3)
        L_0x0068:
            return
        L_0x0069:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.streamFailed(java.io.IOException):void");
    }

    public void acquire(RealConnection realConnection, boolean z) {
        if (!f7195a && !Thread.holdsLock(this.f7198d)) {
            throw new AssertionError();
        } else if (this.f7202h == null) {
            this.f7202h = realConnection;
            this.f7203i = z;
            realConnection.allocations.add(new StreamAllocationReference(this, this.f7199e));
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private void m6821a(RealConnection realConnection) {
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
        if (!f7195a && !Thread.holdsLock(this.f7198d)) {
            throw new AssertionError();
        } else if (this.f7206l == null && this.f7202h.allocations.size() == 1) {
            Socket a = m6818a(true, false, false);
            this.f7202h = realConnection;
            realConnection.allocations.add(this.f7202h.allocations.get(0));
            return a;
        } else {
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f7196b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasMoreRoutes() {
        /*
            r1 = this;
            okhttp3.Route r0 = r1.f7197c
            if (r0 != 0) goto L_0x0019
            okhttp3.internal.connection.RouteSelector$Selection r0 = r1.f7196b
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x0019
        L_0x000e:
            okhttp3.internal.connection.RouteSelector r0 = r1.f7200f
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.hasMoreRoutes():boolean");
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
