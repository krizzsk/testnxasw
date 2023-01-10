package p218io.reactivex.internal.fuseable;

import p218io.reactivex.MaybeSource;

/* renamed from: io.reactivex.internal.fuseable.HasUpstreamMaybeSource */
public interface HasUpstreamMaybeSource<T> {
    MaybeSource<T> source();
}
