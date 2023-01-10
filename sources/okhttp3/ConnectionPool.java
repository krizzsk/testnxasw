package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.C3000Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool {

    /* renamed from: c */
    static final /* synthetic */ boolean f6972c = (!ConnectionPool.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final Executor f6973d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C3000Util.threadFactory("OkHttp ConnectionPool", true));

    /* renamed from: a */
    final RouteDatabase f6974a;

    /* renamed from: b */
    boolean f6975b;

    /* renamed from: e */
    private final int f6976e;

    /* renamed from: f */
    private final long f6977f;

    /* renamed from: g */
    private final Runnable f6978g;

    /* renamed from: h */
    private final Deque<RealConnection> f6979h;

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.f6978g = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                L_0x0000:
                    okhttp3.ConnectionPool r0 = okhttp3.ConnectionPool.this
                    long r1 = java.lang.System.nanoTime()
                    long r0 = r0.mo29964a((long) r1)
                    r2 = -1
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 != 0) goto L_0x0011
                    return
                L_0x0011:
                    r2 = 0
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 <= 0) goto L_0x0000
                    r2 = 1000000(0xf4240, double:4.940656E-318)
                    long r4 = r0 / r2
                    long r2 = r2 * r4
                    long r0 = r0 - r2
                    okhttp3.ConnectionPool r2 = okhttp3.ConnectionPool.this
                    monitor-enter(r2)
                    okhttp3.ConnectionPool r3 = okhttp3.ConnectionPool.this     // Catch:{ InterruptedException -> 0x002b }
                    int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                    r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
                    goto L_0x002b
                L_0x0029:
                    r0 = move-exception
                    goto L_0x002d
                L_0x002b:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    goto L_0x0000
                L_0x002d:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.ConnectionPool.C29881.run():void");
            }
        };
        this.f6979h = new ArrayDeque();
        this.f6974a = new RouteDatabase();
        this.f6976e = i;
        this.f6977f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    public synchronized int idleConnectionCount() {
        int i;
        i = 0;
        for (RealConnection realConnection : this.f6979h) {
            if (realConnection.allocations.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    public synchronized int connectionCount() {
        return this.f6979h.size();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public RealConnection mo29966a(Address address, StreamAllocation streamAllocation, Route route) {
        if (f6972c || Thread.holdsLock(this)) {
            for (RealConnection next : this.f6979h) {
                if (next.isEligible(address, route)) {
                    streamAllocation.acquire(next, true);
                    return next;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public Socket mo29965a(Address address, StreamAllocation streamAllocation) {
        if (f6972c || Thread.holdsLock(this)) {
            for (RealConnection next : this.f6979h) {
                if (next.isEligible(address, (Route) null) && next.isMultiplexed() && next != streamAllocation.connection()) {
                    return streamAllocation.releaseAndAcquire(next);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29967a(RealConnection realConnection) {
        if (f6972c || Thread.holdsLock(this)) {
            if (!this.f6975b) {
                this.f6975b = true;
                f6973d.execute(this.f6978g);
            }
            this.f6979h.add(realConnection);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo29968b(RealConnection realConnection) {
        if (!f6972c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (realConnection.noNewStreams || this.f6976e == 0) {
            this.f6979h.remove(realConnection);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    public void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<RealConnection> it = this.f6979h.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next.allocations.isEmpty()) {
                    next.noNewStreams = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        for (RealConnection socket : arrayList) {
            C3000Util.closeQuietly(socket.socket());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo29964a(long j) {
        synchronized (this) {
            RealConnection realConnection = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (RealConnection next : this.f6979h) {
                if (m6719a(next, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.idleAtNanos;
                    if (j3 > j2) {
                        realConnection = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f6977f) {
                if (i <= this.f6976e) {
                    if (i > 0) {
                        long j4 = this.f6977f - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f6977f;
                        return j5;
                    } else {
                        this.f6975b = false;
                        return -1;
                    }
                }
            }
            this.f6979h.remove(realConnection);
            C3000Util.closeQuietly(realConnection.socket());
            return 0;
        }
    }

    /* renamed from: a */
    private int m6719a(RealConnection realConnection, long j) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i = 0;
        while (i < list.size()) {
            Reference reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.f6977f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
