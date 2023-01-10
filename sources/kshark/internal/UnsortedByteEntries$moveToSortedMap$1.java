package kshark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kshark.internal.aosp.ByteArrayComparator;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, mo148868d2 = {"kshark/internal/UnsortedByteEntries$moveToSortedMap$1", "Lkshark/internal/aosp/ByteArrayComparator;", "compare", "", "entrySize", "o1Array", "", "o1Index", "o2Array", "o2Index", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: UnsortedByteEntries.kt */
public final class UnsortedByteEntries$moveToSortedMap$1 implements ByteArrayComparator {
    final /* synthetic */ UnsortedByteEntries this$0;

    UnsortedByteEntries$moveToSortedMap$1(UnsortedByteEntries unsortedByteEntries) {
        this.this$0 = unsortedByteEntries;
    }

    public int compare(int i, byte[] bArr, int i2, byte[] bArr2, int i3) {
        Intrinsics.checkParameterIsNotNull(bArr, "o1Array");
        Intrinsics.checkParameterIsNotNull(bArr2, "o2Array");
        if (this.this$0.f6533h) {
            return (this.this$0.m6395b(bArr, i2 * i) > this.this$0.m6395b(bArr2, i3 * i) ? 1 : (this.this$0.m6395b(bArr, i2 * i) == this.this$0.m6395b(bArr2, i3 * i) ? 0 : -1));
        }
        return Intrinsics.compare(this.this$0.m6392a(bArr, i2 * i), this.this$0.m6392a(bArr2, i3 * i));
    }
}
