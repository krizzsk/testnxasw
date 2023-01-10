package kshark.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo148868d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkshark/internal/ByteSubArray;", "keyIndex", "", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: SortedBytesMap.kt */
final class SortedBytesMap$entrySequence$1 extends Lambda implements Function1<Integer, Pair<? extends Long, ? extends ByteSubArray>> {
    final /* synthetic */ SortedBytesMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SortedBytesMap$entrySequence$1(SortedBytesMap sortedBytesMap) {
        super(1);
        this.this$0 = sortedBytesMap;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Pair<Long, ByteSubArray> invoke(int i) {
        return TuplesKt.m41339to(Long.valueOf(this.this$0.m6389a(i)), new ByteSubArray(this.this$0.f6525f, (this.this$0.f6521b * i) + this.this$0.f6520a, this.this$0.f6524e, this.this$0.f6523d));
    }
}
