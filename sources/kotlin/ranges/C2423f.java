package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0002J\u0015\u0010\r\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, mo148868d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", "first", "Lkotlin/UInt;", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "nextUInt", "nextUInt-pVg5ArA", "()I", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.ranges.f */
/* compiled from: UIntRange.kt */
final class C2423f extends UIntIterator {

    /* renamed from: a */
    private final int f4709a;

    /* renamed from: b */
    private boolean f4710b;

    /* renamed from: c */
    private final int f4711c;

    /* renamed from: d */
    private int f4712d;

    private C2423f(int i, int i2, int i3) {
        this.f4709a = i2;
        boolean z = true;
        int uintCompare = UnsignedKt.uintCompare(i, i2);
        if (i3 <= 0 ? uintCompare < 0 : uintCompare > 0) {
            z = false;
        }
        this.f4710b = z;
        this.f4711c = UInt.m47974constructorimpl(i3);
        this.f4712d = !this.f4710b ? this.f4709a : i;
    }

    public /* synthetic */ C2423f(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    public boolean hasNext() {
        return this.f4710b;
    }

    /* renamed from: nextUInt-pVg5ArA  reason: not valid java name */
    public int m46399nextUIntpVg5ArA() {
        int i = this.f4712d;
        if (i != this.f4709a) {
            this.f4712d = UInt.m47974constructorimpl(this.f4711c + i);
        } else if (this.f4710b) {
            this.f4710b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
