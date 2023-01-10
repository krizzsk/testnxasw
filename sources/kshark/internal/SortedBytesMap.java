package kshark.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u00120\u0011J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo148868d2 = {"Lkshark/internal/SortedBytesMap;", "", "longIdentifiers", "", "bytesPerValue", "", "sortedEntries", "", "(ZI[B)V", "bytesPerEntry", "bytesPerKey", "size", "binarySearch", "key", "", "contains", "entrySequence", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "Lkshark/internal/ByteSubArray;", "get", "keyAt", "index", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: SortedBytesMap.kt */
public final class SortedBytesMap {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f6520a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f6521b;

    /* renamed from: c */
    private final int f6522c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final boolean f6523d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f6524e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final byte[] f6525f;

    public SortedBytesMap(boolean z, int i, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "sortedEntries");
        this.f6523d = z;
        this.f6524e = i;
        this.f6525f = bArr;
        int i2 = z ? 8 : 4;
        this.f6520a = i2;
        int i3 = i2 + this.f6524e;
        this.f6521b = i3;
        this.f6522c = this.f6525f.length / i3;
    }

    public final ByteSubArray get(long j) {
        int a = m6388a(j);
        if (a < 0) {
            return null;
        }
        return new ByteSubArray(this.f6525f, (a * this.f6521b) + this.f6520a, this.f6524e, this.f6523d);
    }

    public final boolean contains(long j) {
        return m6388a(j) >= 0;
    }

    public final Sequence<Pair<Long, ByteSubArray>> entrySequence() {
        return SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, this.f6522c)), new SortedBytesMap$entrySequence$1(this));
    }

    /* renamed from: a */
    private final int m6388a(long j) {
        int i = this.f6522c - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            int i4 = (m6389a(i3) > j ? 1 : (m6389a(i3) == j ? 0 : -1));
            if (i4 < 0) {
                i2 = i3 + 1;
            } else if (i4 <= 0) {
                return i3;
            } else {
                i = i3 - 1;
            }
        }
        return ~i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final long m6389a(int i) {
        int i2 = i * this.f6521b;
        if (this.f6523d) {
            return ByteSubArrayKt.readLong(this.f6525f, i2);
        }
        return (long) ByteSubArrayKt.readInt(this.f6525f, i2);
    }
}
