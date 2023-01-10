package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;

/* compiled from: typeEnhancement.kt */
public final class TypeEnhancementKt {

    /* renamed from: a */
    private static final C2540b f5326a;

    /* renamed from: b */
    private static final C2540b f5327b;

    /* compiled from: typeEnhancement.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MutabilityQualifier.values().length];
            iArr[MutabilityQualifier.READ_ONLY.ordinal()] = 1;
            iArr[MutabilityQualifier.MUTABLE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NullabilityQualifier.values().length];
            iArr2[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            iArr2[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final boolean hasEnhancedNullability(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeEnchancementUtilsKt.hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, kotlinType);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final Annotations m4887a(List<? extends Annotations> list) {
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("At least one Annotations object expected".toString());
        } else if (size != 1) {
            return new CompositeAnnotations((List<? extends Annotations>) CollectionsKt.toList(list));
        } else {
            return (Annotations) CollectionsKt.single(list);
        }
    }

    /* renamed from: a */
    private static final <T> C2541c<T> m4888a(T t) {
        return new C2541c<>(t, (Annotations) null);
    }

    /* renamed from: b */
    private static final <T> C2541c<T> m4891b(T t) {
        return new C2541c<>(t, f5326a);
    }

    /* renamed from: c */
    private static final <T> C2541c<T> m4892c(T t) {
        return new C2541c<>(t, f5327b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final C2541c<ClassifierDescriptor> m4889a(ClassifierDescriptor classifierDescriptor, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        if (!TypeComponentPositionKt.shouldEnhance(typeComponentPosition)) {
            return m4888a(classifierDescriptor);
        }
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            return m4888a(classifierDescriptor);
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        MutabilityQualifier mutability = javaTypeQualifiers.getMutability();
        int i = mutability == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mutability.ordinal()];
        if (i != 1) {
            if (i == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                if (javaToKotlinClassMapper.isReadOnly(classDescriptor)) {
                    return m4892c(javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptor));
                }
            }
        } else if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
            ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
            if (javaToKotlinClassMapper.isMutable(classDescriptor2)) {
                return m4892c(javaToKotlinClassMapper.convertMutableToReadOnly(classDescriptor2));
            }
        }
        return m4888a(classifierDescriptor);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final C2541c<Boolean> m4890a(KotlinType kotlinType, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        if (!TypeComponentPositionKt.shouldEnhance(typeComponentPosition)) {
            return m4888a(Boolean.valueOf(kotlinType.isMarkedNullable()));
        }
        NullabilityQualifier nullability = javaTypeQualifiers.getNullability();
        int i = nullability == null ? -1 : WhenMappings.$EnumSwitchMapping$1[nullability.ordinal()];
        if (i == 1) {
            return m4891b(true);
        }
        if (i != 2) {
            return m4888a(Boolean.valueOf(kotlinType.isMarkedNullable()));
        }
        return m4891b(false);
    }

    static {
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        f5326a = new C2540b(fqName);
        FqName fqName2 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName2, "ENHANCED_MUTABILITY_ANNOTATION");
        f5327b = new C2540b(fqName2);
    }
}
