package p218io.reactivex.internal.operators.single;

import java.util.concurrent.TimeUnit;
import p218io.reactivex.Scheduler;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: io.reactivex.internal.operators.single.SingleDelay */
public final class SingleDelay<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<? extends T> f61863a;

    /* renamed from: b */
    final long f61864b;

    /* renamed from: c */
    final TimeUnit f61865c;

    /* renamed from: d */
    final Scheduler f61866d;

    /* renamed from: e */
    final boolean f61867e;

    public SingleDelay(SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f61863a = singleSource;
        this.f61864b = j;
        this.f61865c = timeUnit;
        this.f61866d = scheduler;
        this.f61867e = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.f61863a.subscribe(new Delay(sequentialDisposable, singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDelay$Delay */
    final class Delay implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;

        /* renamed from: sd */
        private final SequentialDisposable f61868sd;

        Delay(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.f61868sd = sequentialDisposable;
            this.downstream = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f61868sd.replace(disposable);
        }

        public void onSuccess(T t) {
            this.f61868sd.replace(SingleDelay.this.f61866d.scheduleDirect(new OnSuccess(t), SingleDelay.this.f61864b, SingleDelay.this.f61865c));
        }

        public void onError(Throwable th) {
            this.f61868sd.replace(SingleDelay.this.f61866d.scheduleDirect(new OnError(th), SingleDelay.this.f61867e ? SingleDelay.this.f61864b : 0, SingleDelay.this.f61865c));
        }

        /* renamed from: io.reactivex.internal.operators.single.SingleDelay$Delay$OnSuccess */
        final class OnSuccess implements Runnable {
            private final T value;

            OnSuccess(T t) {
                this.value = t;
            }

            public void run() {
                Delay.this.downstream.onSuccess(this.value);
            }
        }

        /* renamed from: io.reactivex.internal.operators.single.SingleDelay$Delay$OnError */
        final class OnError implements Runnable {

            /* renamed from: e */
            private final Throwable f61869e;

            OnError(Throwable th) {
                this.f61869e = th;
            }

            public void run() {
                Delay.this.downstream.onError(this.f61869e);
            }
        }
    }
}
