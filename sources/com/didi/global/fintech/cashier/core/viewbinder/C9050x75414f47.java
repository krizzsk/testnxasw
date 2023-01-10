package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo148868d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, mo148869k = 3, mo148870mv = {1, 5, 1})
/* renamed from: com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierCardChannelViewBinder$topMethod$$inlined$sortByDescending$1 */
/* compiled from: Comparisons.kt */
public final class C9050x75414f47<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Boolean.valueOf(((ChannelItemViewHolderData) t2).getSelected()), Boolean.valueOf(((ChannelItemViewHolderData) t).getSelected()));
    }
}
