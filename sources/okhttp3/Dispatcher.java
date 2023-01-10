package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.RealCall;
import okhttp3.internal.C3000Util;

public final class Dispatcher {

    /* renamed from: a */
    static final /* synthetic */ boolean f6999a = (!Dispatcher.class.desiredAssertionStatus());

    /* renamed from: b */
    private int f7000b = 64;

    /* renamed from: c */
    private int f7001c = 5;
    @Nullable

    /* renamed from: d */
    private Runnable f7002d;
    @Nullable

    /* renamed from: e */
    private ExecutorService f7003e;

    /* renamed from: f */
    private final Deque<RealCall.AsyncCall> f7004f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<RealCall.AsyncCall> f7005g = new ArrayDeque();

    /* renamed from: h */
    private final Deque<RealCall> f7006h = new ArrayDeque();

    public Dispatcher(ExecutorService executorService) {
        this.f7003e = executorService;
    }

    public Dispatcher() {
    }

    public synchronized ExecutorService executorService() {
        if (this.f7003e == null) {
            this.f7003e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C3000Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.f7003e;
    }

    public void setMaxRequests(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.f7000b = i;
            }
            m6736a();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }

    public synchronized int getMaxRequests() {
        return this.f7000b;
    }

    public void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.f7001c = i;
            }
            m6736a();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.f7001c;
    }

    public synchronized void setIdleCallback(@Nullable Runnable runnable) {
        this.f7002d = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30015a(RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            this.f7004f.add(asyncCall);
        }
        m6736a();
    }

    public synchronized void cancelAll() {
        for (RealCall.AsyncCall asyncCall : this.f7004f) {
            asyncCall.get().cancel();
        }
        for (RealCall.AsyncCall asyncCall2 : this.f7005g) {
            asyncCall2.get().cancel();
        }
        for (RealCall cancel : this.f7006h) {
            cancel.cancel();
        }
    }

    /* renamed from: a */
    private boolean m6736a() {
        int i;
        boolean z;
        if (f6999a || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<RealCall.AsyncCall> it = this.f7004f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RealCall.AsyncCall next = it.next();
                    if (this.f7005g.size() >= this.f7000b) {
                        break;
                    } else if (m6737c(next) < this.f7001c) {
                        it.remove();
                        arrayList.add(next);
                        this.f7005g.add(next);
                    }
                }
                z = runningCallsCount() > 0;
            }
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                ((RealCall.AsyncCall) arrayList.get(i)).executeOn(executorService());
            }
            return z;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    private int m6737c(RealCall.AsyncCall asyncCall) {
        int i = 0;
        for (RealCall.AsyncCall next : this.f7005g) {
            if (!next.get().f7086e && next.host().equals(asyncCall.host())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo30016a(RealCall realCall) {
        this.f7006h.add(realCall);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo30017b(RealCall.AsyncCall asyncCall) {
        m6735a(this.f7005g, asyncCall);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo30018b(RealCall realCall) {
        m6735a(this.f7006h, realCall);
    }

    /* renamed from: a */
    private <T> void m6735a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f7002d;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!m6736a() && runnable != null) {
            runnable.run();
        }
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (RealCall.AsyncCall asyncCall : this.f7004f) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f7006h);
        for (RealCall.AsyncCall asyncCall : this.f7005g) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.f7004f.size();
    }

    public synchronized int runningCallsCount() {
        return this.f7005g.size() + this.f7006h.size();
    }
}
