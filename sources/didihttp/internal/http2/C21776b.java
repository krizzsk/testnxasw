package didihttp.internal.http2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: didihttp.internal.http2.b */
/* compiled from: Ping */
final class C21776b {

    /* renamed from: a */
    private final CountDownLatch f59612a = new CountDownLatch(1);

    /* renamed from: b */
    private long f59613b = -1;

    /* renamed from: c */
    private long f59614c = -1;

    C21776b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo180010a() {
        if (this.f59613b == -1) {
            this.f59613b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo180011b() {
        if (this.f59614c != -1 || this.f59613b == -1) {
            throw new IllegalStateException();
        }
        this.f59614c = System.nanoTime();
        this.f59612a.countDown();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo180012c() {
        if (this.f59614c == -1) {
            long j = this.f59613b;
            if (j != -1) {
                this.f59614c = j - 1;
                this.f59612a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public long mo180013d() throws InterruptedException {
        this.f59612a.await();
        return this.f59614c - this.f59613b;
    }

    /* renamed from: a */
    public long mo180009a(long j, TimeUnit timeUnit) throws InterruptedException {
        if (this.f59612a.await(j, timeUnit)) {
            return this.f59614c - this.f59613b;
        }
        return -2;
    }
}
