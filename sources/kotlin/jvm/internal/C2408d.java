package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.DoubleIterator;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lkotlin/jvm/internal/ArrayDoubleIterator;", "Lkotlin/collections/DoubleIterator;", "array", "", "([D)V", "index", "", "hasNext", "", "nextDouble", "", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.d */
/* compiled from: ArrayIterators.kt */
final class C2408d extends DoubleIterator {

    /* renamed from: a */
    private int f4643a;

    /* renamed from: b */
    private final double[] f4644b;

    public C2408d(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "array");
        this.f4644b = dArr;
    }

    public boolean hasNext() {
        return this.f4643a < this.f4644b.length;
    }

    public double nextDouble() {
        try {
            double[] dArr = this.f4644b;
            int i = this.f4643a;
            this.f4643a = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f4643a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
