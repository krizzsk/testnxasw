package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: TypeWithEnhancement.kt */
public final class SimpleTypeWithEnhancement extends DelegatingSimpleType implements TypeWithEnhancement {

    /* renamed from: a */
    private final SimpleType f5832a;

    /* renamed from: b */
    private final KotlinType f5833b;

    /* access modifiers changed from: protected */
    public SimpleType getDelegate() {
        return this.f5832a;
    }

    public KotlinType getEnhancement() {
        return this.f5833b;
    }

    public SimpleTypeWithEnhancement(SimpleType simpleType, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(kotlinType, "enhancement");
        this.f5832a = simpleType;
        this.f5833b = kotlinType;
    }

    public SimpleType getOrigin() {
        return getDelegate();
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return (SimpleType) TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAnnotations(annotations), getEnhancement());
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return (SimpleType) TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(z), getEnhancement().unwrap().makeNullableAsSpecified(z));
    }

    public SimpleTypeWithEnhancement replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new SimpleTypeWithEnhancement(simpleType, getEnhancement());
    }

    public SimpleTypeWithEnhancement refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new SimpleTypeWithEnhancement((SimpleType) kotlinTypeRefiner.refineType(getDelegate()), kotlinTypeRefiner.refineType(getEnhancement()));
    }
}
