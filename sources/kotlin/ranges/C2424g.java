package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0002J\u0015\u0010\r\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, mo148868d2 = {"Lkotlin/ranges/ULongProgressionIterator;", "Lkotlin/collections/ULongIterator;", "first", "Lkotlin/ULong;", "last", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "nextULong", "nextULong-s-VKNKU", "()J", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.ranges.g */
/* compiled from: ULongRange.kt */
final class C2424g extends ULongIterator {

    /* renamed from: a */
    private final long f4713a;

    /* renamed from: b */
    private boolean f4714b;

    /* renamed from: c */
    private final long f4715c;

    /* renamed from: d */
    private long f4716d;

    private C2424g(long j, long j2, long j3) {
        this.f4713a = j2;
        boolean z = true;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        int ulongCompare = UnsignedKt.ulongCompare(j, j2);
        if (i <= 0 ? ulongCompare < 0 : ulongCompare > 0) {
            z = false;
        }
        this.f4714b = z;
        this.f4715c = ULong.m47999constructorimpl(j3);
        this.f4716d = !this.f4714b ? this.f4713a : j;
    }

    public /* synthetic */ C2424g(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    public boolean hasNext() {
        return this.f4714b;
    }

    /* renamed from: nextULong-s-VKNKU  reason: not valid java name */
    public long m46400nextULongsVKNKU() {
        long j = this.f4716d;
        if (j != this.f4713a) {
            this.f4716d = ULong.m47999constructorimpl(this.f4715c + j);
        } else if (this.f4714b) {
            this.f4714b = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
