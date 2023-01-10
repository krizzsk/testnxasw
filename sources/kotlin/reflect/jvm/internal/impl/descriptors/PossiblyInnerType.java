package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: typeParameterUtils.kt */
public final class PossiblyInnerType {

    /* renamed from: a */
    private final ClassifierDescriptorWithTypeParameters f4888a;

    /* renamed from: b */
    private final List<TypeProjection> f4889b;

    /* renamed from: c */
    private final PossiblyInnerType f4890c;

    public PossiblyInnerType(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, List<? extends TypeProjection> list, PossiblyInnerType possiblyInnerType) {
        Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "classifierDescriptor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        this.f4888a = classifierDescriptorWithTypeParameters;
        this.f4889b = list;
        this.f4890c = possiblyInnerType;
    }

    public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor() {
        return this.f4888a;
    }

    public final List<TypeProjection> getArguments() {
        return this.f4889b;
    }

    public final PossiblyInnerType getOuterType() {
        return this.f4890c;
    }
}
