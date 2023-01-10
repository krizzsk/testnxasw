package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.a */
/* compiled from: KotlinTypeFactory.kt */
final class C2665a extends DelegatingSimpleTypeImpl {

    /* renamed from: a */
    private final Annotations f5853a;

    public Annotations getAnnotations() {
        return this.f5853a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2665a(SimpleType simpleType, Annotations annotations) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        this.f5853a = annotations;
    }

    /* renamed from: a */
    public C2665a replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new C2665a(simpleType, getAnnotations());
    }
}
