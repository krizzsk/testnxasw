package p218io.reactivex.internal.operators.observable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p218io.reactivex.ObservableSource;
import p218io.reactivex.internal.util.ExceptionHelper;
import p218io.reactivex.internal.util.NotificationLite;
import p218io.reactivex.observers.DefaultObserver;

/* renamed from: io.reactivex.internal.operators.observable.BlockingObservableMostRecent */
public final class BlockingObservableMostRecent<T> implements Iterable<T> {

    /* renamed from: a */
    final ObservableSource<T> f61473a;

    /* renamed from: b */
    final T f61474b;

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t) {
        this.f61473a = observableSource;
        this.f61474b = t;
    }

    public Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.f61474b);
        this.f61473a.subscribe(mostRecentObserver);
        return mostRecentObserver.getIterable();
    }

    /* renamed from: io.reactivex.internal.operators.observable.BlockingObservableMostRecent$MostRecentObserver */
    static final class MostRecentObserver<T> extends DefaultObserver<T> {
        volatile Object value;

        MostRecentObserver(T t) {
            this.value = NotificationLite.next(t);
        }

        public void onComplete() {
            this.value = NotificationLite.complete();
        }

        public void onError(Throwable th) {
            this.value = NotificationLite.error(th);
        }

        public void onNext(T t) {
            this.value = NotificationLite.next(t);
        }

        public MostRecentObserver<T>.Iterator getIterable() {
            return new Iterator();
        }

        /* renamed from: io.reactivex.internal.operators.observable.BlockingObservableMostRecent$MostRecentObserver$Iterator */
        final class Iterator implements java.util.Iterator<T> {
            private Object buf;

            Iterator() {
            }

            public boolean hasNext() {
                Object obj = MostRecentObserver.this.value;
                this.buf = obj;
                return !NotificationLite.isComplete(obj);
            }

            public T next() {
                Object obj = null;
                try {
                    if (this.buf == null) {
                        obj = MostRecentObserver.this.value;
                    }
                    if (NotificationLite.isComplete(this.buf)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.isError(this.buf)) {
                        T value = NotificationLite.getValue(this.buf);
                        this.buf = obj;
                        return value;
                    } else {
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));
                    }
                } finally {
                    this.buf = obj;
                }
            }

            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }
    }
}
