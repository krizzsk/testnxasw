package p218io.reactivex.internal.operators.observable;

import p218io.reactivex.Observable;
import p218io.reactivex.Observer;
import p218io.reactivex.internal.observers.BasicIntQueueDisposable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableRangeLong */
public final class ObservableRangeLong extends Observable<Long> {

    /* renamed from: a */
    private final long f61655a;

    /* renamed from: b */
    private final long f61656b;

    public ObservableRangeLong(long j, long j2) {
        this.f61655a = j;
        this.f61656b = j2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Long> observer) {
        long j = this.f61655a;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j, j + this.f61656b);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableRangeLong$RangeDisposable */
    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final Observer<? super Long> downstream;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(Observer<? super Long> observer, long j, long j2) {
            this.downstream = observer;
            this.index = j;
            this.end = j2;
        }

        /* access modifiers changed from: package-private */
        public void run() {
            if (!this.fused) {
                Observer<? super Long> observer = this.downstream;
                long j = this.end;
                for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                    observer.onNext(Long.valueOf(j2));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }

        public Long poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Long.valueOf(j);
            }
            lazySet(1);
            return null;
        }

        public boolean isEmpty() {
            return this.index == this.end;
        }

        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        public boolean isDisposed() {
            return get() != 0;
        }

        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }
    }
}
