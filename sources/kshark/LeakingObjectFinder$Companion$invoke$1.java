package kshark;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo148868d2 = {"kshark/LeakingObjectFinder$Companion$invoke$1", "Lkshark/LeakingObjectFinder;", "findLeakingObjectIds", "", "", "graph", "Lkshark/HeapGraph;", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: LeakingObjectFinder.kt */
public final class LeakingObjectFinder$Companion$invoke$1 implements LeakingObjectFinder {
    final /* synthetic */ Function1 $block;

    public LeakingObjectFinder$Companion$invoke$1(Function1 function1) {
        this.$block = function1;
    }

    public Set<Long> findLeakingObjectIds(HeapGraph heapGraph) {
        Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
        return (Set) this.$block.invoke(heapGraph);
    }
}
