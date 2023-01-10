package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.osgi.framework.namespace.IdentityNamespace;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020'H\u0016J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001bH\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020,H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006-"}, mo148868d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getComputeJavaType$annotations", "()V", "isMarkedNullable", "", "()Z", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "makeNullableAsSpecified", "nullable", "makeNullableAsSpecified$kotlin_reflection", "toString", "", "kotlin-reflection"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: KTypeImpl.kt */
public final class KTypeImpl implements KTypeBase {

    /* renamed from: a */
    static final /* synthetic */ KProperty[] f4767a;

    /* renamed from: b */
    private final ReflectProperties.LazySoftVal<Type> f4768b;

    /* renamed from: c */
    private final ReflectProperties.LazySoftVal f4769c;

    /* renamed from: d */
    private final ReflectProperties.LazySoftVal f4770d;

    /* renamed from: e */
    private final KotlinType f4771e;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Variance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$0[Variance.IN_VARIANCE.ordinal()] = 2;
            $EnumSwitchMapping$0[Variance.OUT_VARIANCE.ordinal()] = 3;
        }
    }

    static {
        Class<KTypeImpl> cls = KTypeImpl.class;
        f4767a = new KProperty[]{C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), IdentityNamespace.REQUIREMENT_CLASSIFIER_DIRECTIVE, "getClassifier()Lkotlin/reflect/KClassifier;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "arguments", "getArguments()Ljava/util/List;"))};
    }

    public List<KTypeProjection> getArguments() {
        return (List) this.f4770d.getValue(this, f4767a[1]);
    }

    public KClassifier getClassifier() {
        return (KClassifier) this.f4769c.getValue(this, f4767a[0]);
    }

    public KTypeImpl(KotlinType kotlinType, Function0<? extends Type> function0) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.f4771e = kotlinType;
        ReflectProperties.LazySoftVal<Type> lazySoftVal = null;
        ReflectProperties.LazySoftVal<Type> lazySoftVal2 = !(function0 instanceof ReflectProperties.LazySoftVal) ? null : function0;
        if (lazySoftVal2 != null) {
            lazySoftVal = lazySoftVal2;
        } else if (function0 != null) {
            lazySoftVal = ReflectProperties.lazySoft(function0);
        }
        this.f4768b = lazySoftVal;
        this.f4769c = ReflectProperties.lazySoft(new KTypeImpl$classifier$2(this));
        this.f4770d = ReflectProperties.lazySoft(new KTypeImpl$arguments$2(this, function0));
    }

    public final KotlinType getType() {
        return this.f4771e;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KTypeImpl(KotlinType kotlinType, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i & 2) != 0 ? null : function0);
    }

    public Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> lazySoftVal = this.f4768b;
        if (lazySoftVal != null) {
            return lazySoftVal.invoke();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final KClassifier m4633a(KotlinType kotlinType) {
        KotlinType type;
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) declarationDescriptor);
            if (javaClass == null) {
                return null;
            }
            if (javaClass.isArray()) {
                TypeProjection typeProjection = (TypeProjection) CollectionsKt.singleOrNull(kotlinType.getArguments());
                if (typeProjection == null || (type = typeProjection.getType()) == null) {
                    return new KClassImpl(javaClass);
                }
                Intrinsics.checkNotNullExpressionValue(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
                KClassifier a = m4633a(type);
                if (a != null) {
                    return new KClassImpl(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(a))));
                }
                throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
            } else if (TypeUtils.isNullableType(kotlinType)) {
                return new KClassImpl(javaClass);
            } else {
                Class<?> primitiveByWrapper = ReflectClassUtilKt.getPrimitiveByWrapper(javaClass);
                if (primitiveByWrapper != null) {
                    javaClass = primitiveByWrapper;
                }
                return new KClassImpl(javaClass);
            }
        } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl((KTypeParameterOwnerImpl) null, (TypeParameterDescriptor) declarationDescriptor);
        } else {
            if (!(declarationDescriptor instanceof TypeAliasDescriptor)) {
                return null;
            }
            throw new NotImplementedError("An operation is not implemented: " + "Type alias classifiers are not yet supported");
        }
    }

    public boolean isMarkedNullable() {
        return this.f4771e.isMarkedNullable();
    }

    public List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.f4771e);
    }

    public final KTypeImpl makeNullableAsSpecified$kotlin_reflection(boolean z) {
        if (!FlexibleTypesKt.isFlexible(this.f4771e) && isMarkedNullable() == z) {
            return this;
        }
        KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(this.f4771e, z);
        Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "TypeUtils.makeNullableAsSpecified(type, nullable)");
        return new KTypeImpl(makeNullableAsSpecified, this.f4768b);
    }

    public boolean equals(Object obj) {
        return (obj instanceof KTypeImpl) && Intrinsics.areEqual((Object) this.f4771e, (Object) ((KTypeImpl) obj).f4771e);
    }

    public int hashCode() {
        return this.f4771e.hashCode();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this.f4771e);
    }
}
