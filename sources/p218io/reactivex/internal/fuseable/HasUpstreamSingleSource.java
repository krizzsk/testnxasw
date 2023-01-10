package p218io.reactivex.internal.fuseable;

import p218io.reactivex.SingleSource;

/* renamed from: io.reactivex.internal.fuseable.HasUpstreamSingleSource */
public interface HasUpstreamSingleSource<T> {
    SingleSource<T> source();
}
