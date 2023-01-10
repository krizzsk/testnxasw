package p218io.reactivex.internal.operators.single;

import java.util.Arrays;
import java.util.NoSuchElementException;
import p218io.reactivex.Single;
import p218io.reactivex.SingleObserver;
import p218io.reactivex.SingleSource;
import p218io.reactivex.exceptions.Exceptions;
import p218io.reactivex.functions.Function;
import p218io.reactivex.internal.disposables.EmptyDisposable;
import p218io.reactivex.internal.functions.ObjectHelper;
import p218io.reactivex.internal.operators.single.SingleMap;
import p218io.reactivex.internal.operators.single.SingleZipArray;

/* renamed from: io.reactivex.internal.operators.single.SingleZipIterable */
public final class SingleZipIterable<T, R> extends Single<R> {

    /* renamed from: a */
    final Iterable<? extends SingleSource<? extends T>> f61955a;

    /* renamed from: b */
    final Function<? super Object[], ? extends R> f61956b;

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.f61955a = iterable;
        this.f61956b = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            int i = 0;
            for (SingleSource singleSource : this.f61955a) {
                if (singleSource == null) {
                    EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), (SingleObserver<?>) singleObserver);
                    return;
                }
                if (i == singleSourceArr.length) {
                    singleSourceArr = (SingleSource[]) Arrays.copyOf(singleSourceArr, (i >> 2) + i);
                }
                int i2 = i + 1;
                singleSourceArr[i] = singleSource;
                i = i2;
            }
            if (i == 0) {
                EmptyDisposable.error((Throwable) new NoSuchElementException(), (SingleObserver<?>) singleObserver);
            } else if (i == 1) {
                singleSourceArr[0].subscribe(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            } else {
                SingleZipArray.ZipCoordinator zipCoordinator = new SingleZipArray.ZipCoordinator(singleObserver, i, this.f61956b);
                singleObserver.onSubscribe(zipCoordinator);
                for (int i3 = 0; i3 < i && !zipCoordinator.isDisposed(); i3++) {
                    singleSourceArr[i3].subscribe(zipCoordinator.observers[i3]);
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleZipIterable$SingletonArrayFunc */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Exception {
            return ObjectHelper.requireNonNull(SingleZipIterable.this.f61956b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }
}
