package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.c */
/* compiled from: KotlinTypeFactory.kt */
final class C2667c extends DelegatingSimpleTypeImpl {
    public boolean isMarkedNullable() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2667c(SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
    }

    /* renamed from: a */
    public C2667c replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new C2667c(simpleType);
    }
}
