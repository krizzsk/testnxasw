package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.b */
/* compiled from: KotlinTypeFactory.kt */
final class C2666b extends DelegatingSimpleTypeImpl {
    public boolean isMarkedNullable() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2666b(SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
    }

    /* renamed from: a */
    public C2666b replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new C2666b(simpleType);
    }
}
