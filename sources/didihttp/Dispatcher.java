package didihttp;

import didihttp.RealCall;
import didihttp.internal.C21750Util;
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

public final class Dispatcher {

    /* renamed from: a */
    private int f59193a = 64;

    /* renamed from: b */
    private int f59194b = 5;

    /* renamed from: c */
    private Runnable f59195c;

    /* renamed from: d */
    private ExecutorService f59196d;

    /* renamed from: e */
    private final Deque<RealCall.AsyncCall> f59197e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<RealCall.AsyncCall> f59198f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<RealCall> f59199g = new ArrayDeque();

    public Dispatcher(ExecutorService executorService) {
        this.f59196d = executorService;
    }

    public Dispatcher() {
    }

    public synchronized ExecutorService executorService() {
        if (this.f59196d == null) {
            this.f59196d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C21750Util.threadFactory("didiHttp Dispatcher#", false));
        }
        return this.f59196d;
    }

    public synchronized void setMaxRequests(int i) {
        if (i >= 1) {
            this.f59193a = i;
            m44722a();
        } else {
            throw new IllegalArgumentException("max < 1: " + i);
        }
    }

    public synchronized int getMaxRequests() {
        return this.f59193a;
    }

    public synchronized void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            this.f59194b = i;
            m44722a();
        } else {
            throw new IllegalArgumentException("max < 1: " + i);
        }
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.f59194b;
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.f59195c = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo179388a(RealCall.AsyncCall asyncCall) {
        if (this.f59198f.size() >= this.f59193a || m44724c(asyncCall) >= this.f59194b) {
            this.f59197e.add(asyncCall);
        } else {
            this.f59198f.add(asyncCall);
            executorService().execute(asyncCall);
        }
    }

    public synchronized void cancelAll() {
        for (RealCall.AsyncCall asyncCall : this.f59197e) {
            asyncCall.get().cancel();
        }
        for (RealCall.AsyncCall asyncCall2 : this.f59198f) {
            asyncCall2.get().cancel();
        }
        for (RealCall cancel : this.f59199g) {
            cancel.cancel();
        }
    }

    /* renamed from: a */
    private void m44722a() {
        if (this.f59198f.size() < this.f59193a && !this.f59197e.isEmpty()) {
            Iterator<RealCall.AsyncCall> it = this.f59197e.iterator();
            while (it.hasNext()) {
                RealCall.AsyncCall next = it.next();
                if (m44724c(next) < this.f59194b) {
                    it.remove();
                    this.f59198f.add(next);
                    executorService().execute(next);
                }
                if (this.f59198f.size() >= this.f59193a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private int m44724c(RealCall.AsyncCall asyncCall) {
        int i = 0;
        for (RealCall.AsyncCall host : this.f59198f) {
            if (host.host().equals(asyncCall.host())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo179389a(RealCall realCall) {
        this.f59199g.add(realCall);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo179390b(RealCall.AsyncCall asyncCall) {
        m44723a(this.f59198f, asyncCall, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo179391b(RealCall realCall) {
        m44723a(this.f59199g, realCall, false);
    }

    /* renamed from: a */
    private <T> void m44723a(Deque<T> deque, T t, boolean z) {
        int runningCallsCount;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m44722a();
                }
                runningCallsCount = runningCallsCount();
                runnable = this.f59195c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (runningCallsCount == 0 && runnable != null) {
            runnable.run();
        }
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (RealCall.AsyncCall asyncCall : this.f59197e) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f59199g);
        for (RealCall.AsyncCall asyncCall : this.f59198f) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.f59197e.size();
    }

    public synchronized int runningCallsCount() {
        return this.f59198f.size() + this.f59199g.size();
    }
}
