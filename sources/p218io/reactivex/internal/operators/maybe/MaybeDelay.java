package p218io.reactivex.internal.operators.maybe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.MaybeObserver;
import p218io.reactivex.MaybeSource;
import p218io.reactivex.Scheduler;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeDelay */
public final class MaybeDelay<T> extends C22213a<T, T> {

    /* renamed from: a */
    final long f61327a;

    /* renamed from: b */
    final TimeUnit f61328b;

    /* renamed from: c */
    final Scheduler f61329c;

    public MaybeDelay(MaybeSource<T> maybeSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(maybeSource);
        this.f61327a = j;
        this.f61328b = timeUnit;
        this.f61329c = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new DelayMaybeObserver(maybeObserver, this.f61327a, this.f61328b, this.f61329c));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeDelay$DelayMaybeObserver */
    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        final long delay;
        final MaybeObserver<? super T> downstream;
        Throwable error;
        final Scheduler scheduler;
        final TimeUnit unit;
        T value;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.downstream = maybeObserver;
            this.delay = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.downstream.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.downstream.onSuccess(t);
            } else {
                this.downstream.onComplete();
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.value = t;
            schedule();
        }

        public void onError(Throwable th) {
            this.error = th;
            schedule();
        }

        public void onComplete() {
            schedule();
        }

        /* access modifiers changed from: package-private */
        public void schedule() {
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this, this.delay, this.unit));
        }
    }
}
