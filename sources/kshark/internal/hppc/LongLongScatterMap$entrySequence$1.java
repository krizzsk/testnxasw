package kshark.internal.hppc;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo148868d2 = {"<anonymous>", "Lkotlin/Pair;", "", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: LongLongScatterMap.kt */
final class LongLongScatterMap$entrySequence$1 extends Lambda implements Function0<Pair<? extends Long, ? extends Long>> {
    final /* synthetic */ int $max;
    final /* synthetic */ Ref.IntRef $slot;
    final /* synthetic */ LongLongScatterMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LongLongScatterMap$entrySequence$1(LongLongScatterMap longLongScatterMap, Ref.IntRef intRef, int i) {
        super(0);
        this.this$0 = longLongScatterMap;
        this.$slot = intRef;
        this.$max = i;
    }

    public final Pair<Long, Long> invoke() {
        if (this.$slot.element < this.$max) {
            this.$slot.element++;
            while (this.$slot.element < this.$max) {
                long j = this.this$0.f6551a[this.$slot.element];
                if (j != 0) {
                    return TuplesKt.m41339to(Long.valueOf(j), Long.valueOf(this.this$0.f6552b[this.$slot.element]));
                }
                this.$slot.element++;
            }
        }
        if (this.$slot.element != this.$max || !this.this$0.f6556f) {
            return null;
        }
        this.$slot.element++;
        return TuplesKt.m41339to(0L, Long.valueOf(this.this$0.f6552b[this.$max]));
    }
}
