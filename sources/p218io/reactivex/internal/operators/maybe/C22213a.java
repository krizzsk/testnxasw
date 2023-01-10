package p218io.reactivex.internal.operators.maybe;

import p218io.reactivex.Maybe;
import p218io.reactivex.MaybeSource;
import p218io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* renamed from: io.reactivex.internal.operators.maybe.a */
/* compiled from: AbstractMaybeWithUpstream */
abstract class C22213a<T, R> extends Maybe<R> implements HasUpstreamMaybeSource<T> {
    protected final MaybeSource<T> source;

    C22213a(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    public final MaybeSource<T> source() {
        return this.source;
    }
}
