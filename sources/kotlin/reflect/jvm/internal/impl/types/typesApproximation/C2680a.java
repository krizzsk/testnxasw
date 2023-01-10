package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.typesApproximation.a */
/* compiled from: CapturedTypeApproximation.kt */
final class C2680a {

    /* renamed from: a */
    private final TypeParameterDescriptor f5888a;

    /* renamed from: b */
    private final KotlinType f5889b;

    /* renamed from: c */
    private final KotlinType f5890c;

    public C2680a(TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(kotlinType, "inProjection");
        Intrinsics.checkNotNullParameter(kotlinType2, "outProjection");
        this.f5888a = typeParameterDescriptor;
        this.f5889b = kotlinType;
        this.f5890c = kotlinType2;
    }

    /* renamed from: a */
    public final TypeParameterDescriptor mo27171a() {
        return this.f5888a;
    }

    /* renamed from: b */
    public final KotlinType mo27172b() {
        return this.f5889b;
    }

    /* renamed from: c */
    public final KotlinType mo27173c() {
        return this.f5890c;
    }

    /* renamed from: d */
    public final boolean mo27174d() {
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(this.f5889b, this.f5890c);
    }
}
