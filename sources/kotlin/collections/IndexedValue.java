package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo148868d2 = {"Lkotlin/collections/IndexedValue;", "T", "", "index", "", "value", "(ILjava/lang/Object;)V", "getIndex", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "equals", "", "other", "hashCode", "toString", "", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: IndexedValue.kt */
public final class IndexedValue<T> {

    /* renamed from: a */
    private final int f4524a;

    /* renamed from: b */
    private final T f4525b;

    public static /* synthetic */ IndexedValue copy$default(IndexedValue indexedValue, int i, T t, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = indexedValue.f4524a;
        }
        if ((i2 & 2) != 0) {
            t = indexedValue.f4525b;
        }
        return indexedValue.copy(i, t);
    }

    public final int component1() {
        return this.f4524a;
    }

    public final T component2() {
        return this.f4525b;
    }

    public final IndexedValue<T> copy(int i, T t) {
        return new IndexedValue<>(i, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.f4524a == indexedValue.f4524a && Intrinsics.areEqual((Object) this.f4525b, (Object) indexedValue.f4525b);
    }

    public int hashCode() {
        int i = this.f4524a * 31;
        T t = this.f4525b;
        return i + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "IndexedValue(index=" + this.f4524a + ", value=" + this.f4525b + ")";
    }

    public IndexedValue(int i, T t) {
        this.f4524a = i;
        this.f4525b = t;
    }

    public final int getIndex() {
        return this.f4524a;
    }

    public final T getValue() {
        return this.f4525b;
    }
}
