package com.didi.soda.customer.foundation.rpc.net;

import com.didi.soda.customer.foundation.rpc.net.ExceptionFormator;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo148868d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, mo148869k = 3, mo148870mv = {1, 5, 1})
/* renamed from: com.didi.soda.customer.foundation.rpc.net.ExceptionFormator$transformers$lambda-1$$inlined$sortBy$1  reason: invalid class name */
/* compiled from: Comparisons.kt */
public final class ExceptionFormator$transformers$lambda1$$inlined$sortBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((ExceptionFormator.Transform) t).getPriority()), Integer.valueOf(((ExceptionFormator.Transform) t2).getPriority()));
    }
}
