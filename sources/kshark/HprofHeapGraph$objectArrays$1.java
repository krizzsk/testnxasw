package kshark;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;
import kshark.internal.IndexedObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo148868d2 = {"<anonymous>", "Lkshark/HeapObject$HeapObjectArray;", "it", "Lkotlin/Pair;", "", "Lkshark/internal/IndexedObject$IndexedObjectArray;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: HprofHeapGraph.kt */
final class HprofHeapGraph$objectArrays$1 extends Lambda implements Function1<Pair<? extends Long, ? extends IndexedObject.IndexedObjectArray>, HeapObject.HeapObjectArray> {
    final /* synthetic */ HprofHeapGraph this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HprofHeapGraph$objectArrays$1(HprofHeapGraph hprofHeapGraph) {
        super(1);
        this.this$0 = hprofHeapGraph;
    }

    public final HeapObject.HeapObjectArray invoke(Pair<Long, IndexedObject.IndexedObjectArray> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "it");
        long longValue = pair.getFirst().longValue();
        IndexedObject.IndexedObjectArray second = pair.getSecond();
        return new HeapObject.HeapObjectArray(this.this$0, second, longValue, this.this$0.f6408e.getPrimitiveWrapperTypes().contains(Long.valueOf(second.getArrayClassId())));
    }
}
