package com.koushikdutta.async;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.koushikdutta.async.c */
/* compiled from: SelectorWrapper */
class C21132c implements Closeable {

    /* renamed from: a */
    public AtomicBoolean f58087a = new AtomicBoolean(false);

    /* renamed from: b */
    Semaphore f58088b = new Semaphore(0);

    /* renamed from: c */
    private Selector f58089c;

    /* renamed from: a */
    public Selector mo173239a() {
        return this.f58089c;
    }

    public C21132c(Selector selector) {
        this.f58089c = selector;
    }

    /* renamed from: b */
    public int mo173241b() throws IOException {
        return this.f58089c.selectNow();
    }

    /* renamed from: c */
    public void mo173242c() throws IOException {
        mo173240a(0);
    }

    /* renamed from: a */
    public void mo173240a(long j) throws IOException {
        try {
            this.f58088b.drainPermits();
            this.f58089c.select(j);
        } finally {
            this.f58088b.release(Integer.MAX_VALUE);
        }
    }

    /* renamed from: d */
    public Set<SelectionKey> mo173244d() {
        return this.f58089c.keys();
    }

    /* renamed from: e */
    public Set<SelectionKey> mo173245e() {
        return this.f58089c.selectedKeys();
    }

    public void close() throws IOException {
        this.f58089c.close();
    }

    /* renamed from: f */
    public boolean mo173246f() {
        return this.f58089c.isOpen();
    }

    /* renamed from: g */
    public void mo173247g() {
        boolean z = !this.f58088b.tryAcquire();
        this.f58089c.wakeup();
        if (!z) {
            if (this.f58087a.getAndSet(true)) {
                this.f58089c.wakeup();
                return;
            }
            try {
                mo173248h();
                this.f58089c.wakeup();
            } finally {
                this.f58087a.set(false);
            }
        }
    }

    /* renamed from: h */
    public boolean mo173248h() {
        int i = 0;
        while (i < 100) {
            try {
                this.f58088b.tryAcquire(10, TimeUnit.MILLISECONDS);
                i++;
            } catch (InterruptedException unused) {
                return true;
            }
        }
        return false;
    }
}
