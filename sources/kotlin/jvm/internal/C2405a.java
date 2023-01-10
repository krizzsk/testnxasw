package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lkotlin/jvm/internal/ArrayBooleanIterator;", "Lkotlin/collections/BooleanIterator;", "array", "", "([Z)V", "index", "", "hasNext", "", "nextBoolean", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.a */
/* compiled from: ArrayIterators.kt */
final class C2405a extends BooleanIterator {

    /* renamed from: a */
    private int f4637a;

    /* renamed from: b */
    private final boolean[] f4638b;

    public C2405a(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "array");
        this.f4638b = zArr;
    }

    public boolean hasNext() {
        return this.f4637a < this.f4638b.length;
    }

    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f4638b;
            int i = this.f4637a;
            this.f4637a = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f4637a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
