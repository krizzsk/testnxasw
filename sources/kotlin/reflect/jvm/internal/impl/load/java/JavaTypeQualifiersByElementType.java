package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.EnumMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JavaTypeQualifiersByElementType.kt */
public final class JavaTypeQualifiersByElementType {

    /* renamed from: a */
    private final EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> f5106a;

    public JavaTypeQualifiersByElementType(EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> enumMap) {
        Intrinsics.checkNotNullParameter(enumMap, "defaultQualifiers");
        this.f5106a = enumMap;
    }

    public final EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> getDefaultQualifiers() {
        return this.f5106a;
    }

    public final JavaDefaultQualifiers get(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.f5106a.get(annotationQualifierApplicabilityType);
    }
}
