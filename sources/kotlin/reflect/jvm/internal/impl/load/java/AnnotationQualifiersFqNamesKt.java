package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: AnnotationQualifiersFqNames.kt */
public final class AnnotationQualifiersFqNamesKt {

    /* renamed from: a */
    private static final FqName f5073a = new FqName("javax.annotation.meta.TypeQualifierNickname");

    /* renamed from: b */
    private static final FqName f5074b = new FqName("javax.annotation.meta.TypeQualifier");

    /* renamed from: c */
    private static final FqName f5075c = new FqName("javax.annotation.meta.TypeQualifierDefault");

    /* renamed from: d */
    private static final FqName f5076d = new FqName("kotlin.annotations.jvm.UnderMigration");

    /* renamed from: e */
    private static final List<AnnotationQualifierApplicabilityType> f5077e = CollectionsKt.listOf(AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);

    /* renamed from: f */
    private static final Map<FqName, JavaDefaultQualifiers> f5078f = MapsKt.mapOf(TuplesKt.m41339to(JvmAnnotationNamesKt.getJSPECIFY_NULL_MARKED(), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, (DefaultConstructorMarker) null), f5077e, false, false)));

    /* renamed from: g */
    private static final Map<FqName, JavaDefaultQualifiers> f5079g = MapsKt.plus(MapsKt.mapOf(TuplesKt.m41339to(new FqName("javax.annotation.ParametersAreNullableByDefault"), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, (DefaultConstructorMarker) null), CollectionsKt.listOf(AnnotationQualifierApplicabilityType.VALUE_PARAMETER), false, false, 12, (DefaultConstructorMarker) null)), TuplesKt.m41339to(new FqName("javax.annotation.ParametersAreNonnullByDefault"), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, (DefaultConstructorMarker) null), CollectionsKt.listOf(AnnotationQualifierApplicabilityType.VALUE_PARAMETER), false, false, 12, (DefaultConstructorMarker) null))), (Map) f5078f);

    /* renamed from: h */
    private static final Set<FqName> f5080h = SetsKt.setOf(JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION(), JvmAnnotationNamesKt.getJAVAX_CHECKFORNULL_ANNOTATION());

    public static final FqName getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return f5073a;
    }

    public static final FqName getTYPE_QUALIFIER_FQNAME() {
        return f5074b;
    }

    public static final FqName getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return f5075c;
    }

    public static final FqName getMIGRATION_ANNOTATION_FQNAME() {
        return f5076d;
    }

    public static final Map<FqName, JavaDefaultQualifiers> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return f5078f;
    }

    public static final Map<FqName, JavaDefaultQualifiers> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return f5079g;
    }

    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES() {
        return f5080h;
    }
}
