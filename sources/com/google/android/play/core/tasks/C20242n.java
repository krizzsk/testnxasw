package com.google.android.play.core.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.play.core.tasks.n */
final class C20242n implements OnFailureListener, OnSuccessListener {

    /* renamed from: a */
    private final CountDownLatch f56376a = new CountDownLatch(1);

    private C20242n() {
    }

    /* synthetic */ C20242n(byte[] bArr) {
    }

    /* renamed from: a */
    public final void mo164564a() throws InterruptedException {
        this.f56376a.await();
    }

    /* renamed from: a */
    public final boolean mo164565a(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f56376a.await(j, timeUnit);
    }

    public final void onFailure(Exception exc) {
        this.f56376a.countDown();
    }

    public final void onSuccess(Object obj) {
        this.f56376a.countDown();
    }
}
