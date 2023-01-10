package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.a */
/* compiled from: utils.kt */
final class C2673a {

    /* renamed from: a */
    private final KotlinType f5877a;

    /* renamed from: b */
    private final C2673a f5878b;

    public C2673a(KotlinType kotlinType, C2673a aVar) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.f5877a = kotlinType;
        this.f5878b = aVar;
    }

    /* renamed from: a */
    public final KotlinType mo27145a() {
        return this.f5877a;
    }

    /* renamed from: b */
    public final C2673a mo27146b() {
        return this.f5878b;
    }
}
