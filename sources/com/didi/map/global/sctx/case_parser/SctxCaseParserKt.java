package com.didi.map.global.sctx.case_parser;

import android.util.LruCache;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\u0007"}, mo148868d2 = {"allEqual", "", "T", "Landroid/util/LruCache;", "", "predicate", "Lkotlin/Function2;", "base-sync-trip_release"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SctxCaseParser.kt */
public final class SctxCaseParserKt {
    public static final <T> boolean allEqual(LruCache<Long, T> lruCache, Function2<? super T, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(lruCache, "<this>");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Map<Long, T> snapshot = lruCache.snapshot();
        Intrinsics.checkNotNullExpressionValue(snapshot, "this.snapshot()");
        if (snapshot.isEmpty()) {
            return false;
        }
        if (snapshot.size() == 1) {
            return true;
        }
        Object obj = null;
        for (Map.Entry next : snapshot.entrySet()) {
            if (obj != null && !function2.invoke(obj, next.getValue()).booleanValue()) {
                return false;
            }
            obj = next.getValue();
        }
        return true;
    }
}
