package p218io.reactivex.internal.operators.completable;

import p218io.reactivex.Completable;
import p218io.reactivex.CompletableObserver;
import p218io.reactivex.CompletableSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.exceptions.CompositeException;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Action;
import p218io.reactivex.functions.Consumer;
import p218io.reactivex.internal.disposables.DisposableHelper;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.completable.CompletablePeek */
public final class CompletablePeek extends Completable {

    /* renamed from: a */
    final CompletableSource f60906a;

    /* renamed from: b */
    final Consumer<? super Disposable> f60907b;

    /* renamed from: c */
    final Consumer<? super Throwable> f60908c;

    /* renamed from: d */
    final Action f60909d;

    /* renamed from: e */
    final Action f60910e;

    /* renamed from: f */
    final Action f60911f;

    /* renamed from: g */
    final Action f60912g;

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.f60906a = completableSource;
        this.f60907b = consumer;
        this.f60908c = consumer2;
        this.f60909d = action;
        this.f60910e = action2;
        this.f60911f = action3;
        this.f60912g = action4;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f60906a.subscribe(new CompletableObserverImplementation(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletablePeek$CompletableObserverImplementation */
    final class CompletableObserverImplementation implements CompletableObserver, Disposable {
        final CompletableObserver downstream;
        Disposable upstream;

        CompletableObserverImplementation(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void onSubscribe(Disposable disposable) {
            try {
                CompletablePeek.this.f60907b.accept(disposable);
                if (DisposableHelper.validate(this.upstream, disposable)) {
                    this.upstream = disposable;
                    this.downstream.onSubscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                disposable.dispose();
                this.upstream = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th, this.downstream);
            }
        }

        public void onError(Throwable th) {
            if (this.upstream == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            try {
                CompletablePeek.this.f60908c.accept(th);
                CompletablePeek.this.f60910e.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.downstream.onError(th);
            doAfter();
        }

        public void onComplete() {
            if (this.upstream != DisposableHelper.DISPOSED) {
                try {
                    CompletablePeek.this.f60909d.run();
                    CompletablePeek.this.f60910e.run();
                    this.downstream.onComplete();
                    doAfter();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void doAfter() {
            try {
                CompletablePeek.this.f60911f.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        public void dispose() {
            try {
                CompletablePeek.this.f60912g.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}
