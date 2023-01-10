package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: KotlinTypeFactory.kt */
public abstract class DelegatingSimpleTypeImpl extends DelegatingSimpleType {

    /* renamed from: a */
    private final SimpleType f5803a;

    public DelegatingSimpleTypeImpl(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        this.f5803a = simpleType;
    }

    /* access modifiers changed from: protected */
    public SimpleType getDelegate() {
        return this.f5803a;
    }

    public DelegatingSimpleTypeImpl replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return annotations != getAnnotations() ? new C2665a(this, annotations) : this;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        return getDelegate().makeNullableAsSpecified(z).replaceAnnotations(getAnnotations());
    }
}
