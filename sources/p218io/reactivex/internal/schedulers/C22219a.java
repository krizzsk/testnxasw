package p218io.reactivex.internal.schedulers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p218io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.schedulers.a */
/* compiled from: DisposeOnCancel */
final class C22219a implements Future<Object> {

    /* renamed from: a */
    final Disposable f62016a;

    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    C22219a(Disposable disposable) {
        this.f62016a = disposable;
    }

    public boolean cancel(boolean z) {
        this.f62016a.dispose();
        return false;
    }
}
