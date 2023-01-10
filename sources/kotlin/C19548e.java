package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\n¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo148868d2 = {"lazyOf", "Lkotlin/Lazy;", "T", "value", "(Ljava/lang/Object;)Lkotlin/Lazy;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/Lazy;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, mo148869k = 5, mo148870mv = {1, 5, 1}, mo148872xi = 1, mo148873xs = "kotlin/LazyKt")
/* renamed from: kotlin.e */
/* compiled from: Lazy.kt */
class C19548e extends C19547d {
    public static final <T> Lazy<T> lazyOf(T t) {
        return new InitializedLazyImpl<>(t);
    }

    /* renamed from: a */
    private static final <T> T m41612a(Lazy<? extends T> lazy, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(lazy, "$this$getValue");
        return lazy.getValue();
    }
}
