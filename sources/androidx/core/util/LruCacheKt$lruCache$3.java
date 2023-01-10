package androidx.core.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u00042\b\u0010\t\u001a\u0004\u0018\u0001H\u0004H\n"}, mo148868d2 = {"<anonymous>", "", "K", "", "V", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LruCache.kt */
public final class LruCacheKt$lruCache$3 extends Lambda implements Function4<Boolean, K, V, V, Unit> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    public LruCacheKt$lruCache$3() {
        super(4);
    }

    public final void invoke(boolean z, K k, V v, V v2) {
        Intrinsics.checkNotNullParameter(k, "$noName_1");
        Intrinsics.checkNotNullParameter(v, "$noName_2");
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Boolean) obj).booleanValue(), obj2, obj3, obj4);
        return Unit.INSTANCE;
    }
}
