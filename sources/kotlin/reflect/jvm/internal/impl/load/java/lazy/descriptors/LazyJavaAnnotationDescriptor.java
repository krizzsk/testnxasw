package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f5223a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LazyJavaResolverContext f5224b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final JavaAnnotation f5225c;

    /* renamed from: d */
    private final NullableLazyValue f5226d;

    /* renamed from: e */
    private final NotNullLazyValue f5227e;

    /* renamed from: f */
    private final JavaSourceElement f5228f;

    /* renamed from: g */
    private final NotNullLazyValue f5229g;

    /* renamed from: h */
    private final boolean f5230h;

    /* renamed from: i */
    private final boolean f5231i;

    public LazyJavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation, boolean z) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaAnnotation, "javaAnnotation");
        this.f5224b = lazyJavaResolverContext;
        this.f5225c = javaAnnotation;
        this.f5226d = lazyJavaResolverContext.getStorageManager().createNullableLazyValue(new LazyJavaAnnotationDescriptor$fqName$2(this));
        this.f5227e = this.f5224b.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$type$2(this));
        this.f5228f = this.f5224b.getComponents().getSourceElementFactory().source(this.f5225c);
        this.f5229g = this.f5224b.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$allValueArguments$2(this));
        this.f5230h = this.f5225c.isIdeExternalAnnotation();
        this.f5231i = this.f5225c.isFreshlySupportedTypeUseAnnotation() || z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, javaAnnotation, (i & 4) != 0 ? false : z);
    }

    static {
        Class<LazyJavaAnnotationDescriptor> cls = LazyJavaAnnotationDescriptor.class;
        f5223a = new KProperty[]{C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public FqName getFqName() {
        return (FqName) StorageKt.getValue(this.f5226d, (Object) this, (KProperty<?>) f5223a[0]);
    }

    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.f5227e, (Object) this, (KProperty<?>) f5223a[1]);
    }

    public JavaSourceElement getSource() {
        return this.f5228f;
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map) StorageKt.getValue(this.f5229g, (Object) this, (KProperty<?>) f5223a[2]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ConstantValue<?> m4792a(JavaAnnotationArgument javaAnnotationArgument) {
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            return ConstantValueFactory.INSTANCE.createConstantValue(((JavaLiteralAnnotationArgument) javaAnnotationArgument).getValue());
        }
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
            return m4794a(javaEnumValueAnnotationArgument.getEnumClassId(), javaEnumValueAnnotationArgument.getEntryName());
        } else if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            JavaArrayAnnotationArgument javaArrayAnnotationArgument = (JavaArrayAnnotationArgument) javaAnnotationArgument;
            Name name = javaArrayAnnotationArgument.getName();
            if (name == null) {
                name = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            Intrinsics.checkNotNullExpressionValue(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            return m4795a(name, (List<? extends JavaAnnotationArgument>) javaArrayAnnotationArgument.getElements());
        } else if (javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument) {
            return m4791a(((JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).getAnnotation());
        } else {
            if (javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument) {
                return m4793a(((JavaClassObjectAnnotationArgument) javaAnnotationArgument).getReferencedType());
            }
            return null;
        }
    }

    /* renamed from: a */
    private final ConstantValue<?> m4791a(JavaAnnotation javaAnnotation) {
        return new AnnotationValue(new LazyJavaAnnotationDescriptor(this.f5224b, javaAnnotation, false, 4, (DefaultConstructorMarker) null));
    }

    /* renamed from: a */
    private final ConstantValue<?> m4795a(Name name, List<? extends JavaAnnotationArgument> list) {
        SimpleType type = getType();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        KotlinType kotlinType = null;
        if (KotlinTypeKt.isError(type)) {
            return null;
        }
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(this);
        Intrinsics.checkNotNull(annotationClass);
        ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, annotationClass);
        if (annotationParameterByName != null) {
            kotlinType = annotationParameterByName.getType();
        }
        if (kotlinType == null) {
            kotlinType = this.f5224b.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType("Unknown array element type"));
        }
        Intrinsics.checkNotNullExpressionValue(kotlinType, "DescriptorResolverUtils.… type\")\n                )");
        Iterable<JavaAnnotationArgument> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (JavaAnnotationArgument a : iterable) {
            ConstantValue<?> a2 = m4792a(a);
            if (a2 == null) {
                a2 = new NullValue();
            }
            arrayList.add(a2);
        }
        return ConstantValueFactory.INSTANCE.createArrayValue((List) arrayList, kotlinType);
    }

    /* renamed from: a */
    private final ConstantValue<?> m4794a(ClassId classId, Name name) {
        if (classId == null || name == null) {
            return null;
        }
        return new EnumValue(classId, name);
    }

    /* renamed from: a */
    private final ConstantValue<?> m4793a(JavaType javaType) {
        return KClassValue.Companion.create(this.f5224b.getTypeResolver().transformJavaType(javaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null)));
    }

    public String toString() {
        return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, (AnnotationUseSiteTarget) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ClassDescriptor m4790a(FqName fqName) {
        ModuleDescriptor module = this.f5224b.getModule();
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(fqName)");
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(module, classId, this.f5224b.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    public boolean isIdeExternalAnnotation() {
        return this.f5230h;
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.f5231i;
    }
}
