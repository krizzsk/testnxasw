package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kshark.FilteringLeakingObjectFinder;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"kshark/AndroidObjectInspectors$Companion$createLeakingObjectFilters$2$1", "Lkshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "isLeakingObject", "", "heapObject", "Lkshark/HeapObject;", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
public final class AndroidObjectInspectors$Companion$createLeakingObjectFilters$2$1 implements FilteringLeakingObjectFinder.LeakingObjectFilter {
    final /* synthetic */ Function1 $filter;

    AndroidObjectInspectors$Companion$createLeakingObjectFilters$2$1(Function1 function1) {
        this.$filter = function1;
    }

    public boolean isLeakingObject(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
        return ((Boolean) this.$filter.invoke(heapObject)).booleanValue();
    }
}
