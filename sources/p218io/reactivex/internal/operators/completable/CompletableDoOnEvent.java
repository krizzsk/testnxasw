package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Consumer;

/* renamed from: io.reactivex.internal.operators.completable.CompletableDoOnEvent */
public final class CompletableDoOnEvent extends Completable {

    /* renamed from: a */
    final CompletableSource f60878a;

    /* renamed from: b */
    final Consumer<? super Throwable> f60879b;

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.f60878a = completableSource;
        this.f60879b = consumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f60878a.subscribe(new DoOnEvent(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableDoOnEvent$DoOnEvent */
    final class DoOnEvent implements CompletableObserver {
        private final CompletableObserver observer;

        DoOnEvent(CompletableObserver completableObserver) {
            this.observer = completableObserver;
        }

        public void onComplete() {
            try {
                CompletableDoOnEvent.this.f60879b.accept(null);
                this.observer.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.observer.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                CompletableDoOnEvent.this.f60879b.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.observer.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }
}
