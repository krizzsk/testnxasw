package p218io.reactivex.subjects;

import p218io.reactivex.Observable;
import p218io.reactivex.Observer;

/* renamed from: io.reactivex.subjects.Subject */
public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasObservers();

    public abstract boolean hasThrowable();

    public final Subject<T> toSerialized() {
        if (this instanceof C22234a) {
            return this;
        }
        return new C22234a(this);
    }
}
