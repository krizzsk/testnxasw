package kshark.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.PrimitiveType;
import kshark.internal.IndexedObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, mo148868d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkshark/internal/IndexedObject$IndexedPrimitiveArray;", "it", "Lkshark/internal/ByteSubArray;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: HprofInMemoryIndex.kt */
final class HprofInMemoryIndex$indexedPrimitiveArraySequence$1 extends Lambda implements Function1<Pair<? extends Long, ? extends ByteSubArray>, Pair<? extends Long, ? extends IndexedObject.IndexedPrimitiveArray>> {
    final /* synthetic */ HprofInMemoryIndex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HprofInMemoryIndex$indexedPrimitiveArraySequence$1(HprofInMemoryIndex hprofInMemoryIndex) {
        super(1);
        this.this$0 = hprofInMemoryIndex;
    }

    public final Pair<Long, IndexedObject.IndexedPrimitiveArray> invoke(Pair<Long, ByteSubArray> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "it");
        long longValue = pair.getFirst().longValue();
        ByteSubArray second = pair.getSecond();
        return TuplesKt.m41339to(Long.valueOf(longValue), new IndexedObject.IndexedPrimitiveArray(second.readTruncatedLong(this.this$0.f6487a), PrimitiveType.values()[second.readByte()], second.readInt()));
    }
}
