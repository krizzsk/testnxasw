package p218io.reactivex;

import p218io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.Observer */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Disposable disposable);
}
