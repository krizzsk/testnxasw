package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo148868d2 = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.collections.ac */
/* compiled from: SlidingWindow.kt */
final class C2347ac<T> extends AbstractList<T> implements RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f4536a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f4537b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f4538c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object[] f4539d;

    public C2347ac(Object[] objArr, int i) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.f4539d = objArr;
        boolean z = true;
        if (i >= 0) {
            if (i > this.f4539d.length ? false : z) {
                this.f4536a = this.f4539d.length;
                this.f4538c = i;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + this.f4539d.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
    }

    public C2347ac(int i) {
        this(new Object[i], 0);
    }

    public int getSize() {
        return this.f4538c;
    }

    public T get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return this.f4539d[(this.f4537b + i) % this.f4536a];
    }

    /* renamed from: a */
    public final boolean mo23451a() {
        return size() == this.f4536a;
    }

    public Iterator<T> iterator() {
        return new RingBuffer$iterator$1(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = Arrays.copyOf(tArr, size());
            Intrinsics.checkNotNullExpressionValue(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i = this.f4537b;
        int i2 = 0;
        int i3 = 0;
        while (i3 < size && i < this.f4536a) {
            tArr[i3] = this.f4539d[i];
            i3++;
            i++;
        }
        while (i3 < size) {
            tArr[i3] = this.f4539d[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        if (tArr != null) {
            return tArr;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* renamed from: a */
    public final C2347ac<T> mo23449a(int i) {
        Object[] objArr;
        int i2 = this.f4536a;
        int coerceAtMost = RangesKt.coerceAtMost(i2 + (i2 >> 1) + 1, i);
        if (this.f4537b == 0) {
            objArr = Arrays.copyOf(this.f4539d, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(objArr, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            objArr = toArray(new Object[coerceAtMost]);
        }
        return new C2347ac<>(objArr, size());
    }

    /* renamed from: a */
    public final void mo23450a(T t) {
        if (!mo23451a()) {
            this.f4539d[(this.f4537b + size()) % this.f4536a] = t;
            this.f4538c = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* renamed from: b */
    public final void mo23452b(int i) {
        boolean z = true;
        if (i >= 0) {
            if (i > size()) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
            } else if (i > 0) {
                int i2 = this.f4537b;
                int d = (i2 + i) % this.f4536a;
                if (i2 > d) {
                    ArraysKt.fill((T[]) this.f4539d, null, i2, this.f4536a);
                    ArraysKt.fill((T[]) this.f4539d, null, 0, d);
                } else {
                    ArraysKt.fill((T[]) this.f4539d, null, i2, d);
                }
                this.f4537b = d;
                this.f4538c = size() - i;
            }
        } else {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m2932a(int i, int i2) {
        return (i + i2) % this.f4536a;
    }
}
