package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.FloatIterator;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lkotlin/jvm/internal/ArrayFloatIterator;", "Lkotlin/collections/FloatIterator;", "array", "", "([F)V", "index", "", "hasNext", "", "nextFloat", "", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.e */
/* compiled from: ArrayIterators.kt */
final class C2409e extends FloatIterator {

    /* renamed from: a */
    private int f4645a;

    /* renamed from: b */
    private final float[] f4646b;

    public C2409e(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "array");
        this.f4646b = fArr;
    }

    public boolean hasNext() {
        return this.f4645a < this.f4646b.length;
    }

    public float nextFloat() {
        try {
            float[] fArr = this.f4646b;
            int i = this.f4645a;
            this.f4645a = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f4645a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
