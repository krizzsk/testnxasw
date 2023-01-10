package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImpl extends TypeProjectionBase {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final TypeParameterDescriptor f5835a;

    /* renamed from: b */
    private final Lazy f5836b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new StarProjectionImpl$_type$2(this));

    public boolean isStarProjection() {
        return true;
    }

    public StarProjectionImpl(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        this.f5835a = typeParameterDescriptor;
    }

    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    /* renamed from: a */
    private final KotlinType m5224a() {
        return (KotlinType) this.f5836b.getValue();
    }

    public KotlinType getType() {
        return m5224a();
    }

    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
