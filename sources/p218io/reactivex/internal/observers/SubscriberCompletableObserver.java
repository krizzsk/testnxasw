package p218io.reactivex.internal.observers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.observers.SubscriberCompletableObserver */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {

    /* renamed from: a */
    final Subscriber<? super T> f60841a;

    /* renamed from: b */
    Disposable f60842b;

    public void request(long j) {
    }

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber) {
        this.f60841a = subscriber;
    }

    public void onComplete() {
        this.f60841a.onComplete();
    }

    public void onError(Throwable th) {
        this.f60841a.onError(th);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f60842b, disposable)) {
            this.f60842b = disposable;
            this.f60841a.onSubscribe(this);
        }
    }

    public void cancel() {
        this.f60842b.dispose();
    }
}
