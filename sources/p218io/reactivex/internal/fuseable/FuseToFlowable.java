package p218io.reactivex.internal.fuseable;

import p218io.reactivex.Flowable;

/* renamed from: io.reactivex.internal.fuseable.FuseToFlowable */
public interface FuseToFlowable<T> {
    Flowable<T> fuseToFlowable();
}
