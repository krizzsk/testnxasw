package p218io.reactivex.internal.operators.flowable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p218io.reactivex.Flowable;
import p218io.reactivex.internal.util.ExceptionHelper;
import p218io.reactivex.internal.util.NotificationLite;
import p218io.reactivex.subscribers.DefaultSubscriber;

/* renamed from: io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent */
public final class BlockingFlowableMostRecent<T> implements Iterable<T> {

    /* renamed from: a */
    final Flowable<T> f60939a;

    /* renamed from: b */
    final T f60940b;

    public BlockingFlowableMostRecent(Flowable<T> flowable, T t) {
        this.f60939a = flowable;
        this.f60940b = t;
    }

    public Iterator<T> iterator() {
        MostRecentSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.f60940b);
        this.f60939a.subscribe(mostRecentSubscriber);
        return mostRecentSubscriber.getIterable();
    }

    /* renamed from: io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent$MostRecentSubscriber */
    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        volatile Object value;

        MostRecentSubscriber(T t) {
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

        public MostRecentSubscriber<T>.Iterator getIterable() {
            return new Iterator();
        }

        /* renamed from: io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent$MostRecentSubscriber$Iterator */
        final class Iterator implements java.util.Iterator<T> {
            private Object buf;

            Iterator() {
            }

            public boolean hasNext() {
                Object obj = MostRecentSubscriber.this.value;
                this.buf = obj;
                return !NotificationLite.isComplete(obj);
            }

            public T next() {
                Object obj = null;
                try {
                    if (this.buf == null) {
                        obj = MostRecentSubscriber.this.value;
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
