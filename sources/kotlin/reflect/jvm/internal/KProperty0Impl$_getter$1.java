package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KProperty0Impl;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "V", "kotlin.jvm.PlatformType", "invoke"}, mo148869k = 3, mo148870mv = {1, 5, 1})
/* compiled from: KProperty0Impl.kt */
final class KProperty0Impl$_getter$1 extends Lambda implements Function0<KProperty0Impl.Getter<? extends V>> {
    final /* synthetic */ KProperty0Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KProperty0Impl$_getter$1(KProperty0Impl kProperty0Impl) {
        super(0);
        this.this$0 = kProperty0Impl;
    }

    public final KProperty0Impl.Getter<V> invoke() {
        return new KProperty0Impl.Getter<>(this.this$0);
    }
}
