package p218io.reactivex;

/* renamed from: io.reactivex.MaybeConverter */
public interface MaybeConverter<T, R> {
    R apply(Maybe<T> maybe);
}
