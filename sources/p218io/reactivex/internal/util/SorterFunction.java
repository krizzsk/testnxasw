package p218io.reactivex.internal.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p218io.reactivex.functions.Function;

/* renamed from: io.reactivex.internal.util.SorterFunction */
public final class SorterFunction<T> implements Function<List<T>, List<T>> {

    /* renamed from: a */
    final Comparator<? super T> f62069a;

    public SorterFunction(Comparator<? super T> comparator) {
        this.f62069a = comparator;
    }

    public List<T> apply(List<T> list) throws Exception {
        Collections.sort(list, this.f62069a);
        return list;
    }
}
