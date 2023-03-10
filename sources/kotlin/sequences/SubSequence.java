package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: Sequences.kt */
public final class SubSequence<T> implements DropTakeSequence<T>, Sequence<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Sequence<T> f5947a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f5948b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f5949c;

    public SubSequence(Sequence<? extends T> sequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f5947a = sequence;
        this.f5948b = i;
        this.f5949c = i2;
        boolean z = true;
        if (i >= 0) {
            if (this.f5949c >= 0) {
                if (!(this.f5949c < this.f5948b ? false : z)) {
                    throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + this.f5949c + " < " + this.f5948b).toString());
                }
                return;
            }
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + this.f5949c).toString());
        }
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + this.f5948b).toString());
    }

    /* renamed from: a */
    private final int m5317a() {
        return this.f5949c - this.f5948b;
    }

    public Sequence<T> drop(int i) {
        return i >= m5317a() ? SequencesKt.emptySequence() : new SubSequence<>(this.f5947a, this.f5948b + i, this.f5949c);
    }

    public Sequence<T> take(int i) {
        if (i >= m5317a()) {
            return this;
        }
        Sequence<T> sequence = this.f5947a;
        int i2 = this.f5948b;
        return new SubSequence<>(sequence, i2, i + i2);
    }

    public Iterator<T> iterator() {
        return new SubSequence$iterator$1(this);
    }
}
