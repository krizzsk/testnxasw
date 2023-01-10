package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;

/* compiled from: ReflectionTypes.kt */
public final class ReflectionTypes {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f4804a;

    /* renamed from: b */
    private final NotFoundClasses f4805b;

    /* renamed from: c */
    private final Lazy f4806c;

    /* renamed from: d */
    private final ClassLookup f4807d = new ClassLookup(1);

    /* renamed from: e */
    private final ClassLookup f4808e = new ClassLookup(1);

    /* renamed from: f */
    private final ClassLookup f4809f = new ClassLookup(1);

    /* renamed from: g */
    private final ClassLookup f4810g = new ClassLookup(2);

    /* renamed from: h */
    private final ClassLookup f4811h = new ClassLookup(3);

    /* renamed from: i */
    private final ClassLookup f4812i = new ClassLookup(1);

    /* renamed from: j */
    private final ClassLookup f4813j = new ClassLookup(2);

    /* renamed from: k */
    private final ClassLookup f4814k = new ClassLookup(3);

    public ReflectionTypes(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.f4805b = notFoundClasses;
        this.f4806c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ReflectionTypes$kotlinReflectScope$2(moduleDescriptor));
    }

    /* renamed from: a */
    private final MemberScope m4673a() {
        return (MemberScope) this.f4806c.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ClassDescriptor m4672a(String str, int i) {
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(className)");
        ClassifierDescriptor contributedClassifier = m4673a().getContributedClassifier(identifier, NoLookupLocation.FROM_REFLECTION);
        ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        return classDescriptor == null ? this.f4805b.getClass(new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, identifier), CollectionsKt.listOf(Integer.valueOf(i))) : classDescriptor;
    }

    /* compiled from: ReflectionTypes.kt */
    private static final class ClassLookup {
        private final int numberOfTypeParameters;

        public ClassLookup(int i) {
            this.numberOfTypeParameters = i;
        }

        public final ClassDescriptor getValue(ReflectionTypes reflectionTypes, KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(reflectionTypes, "types");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            return reflectionTypes.m4672a(CapitalizeDecapitalizeKt.capitalizeAsciiOnly(kProperty.getName()), this.numberOfTypeParameters);
        }
    }

    static {
        Class<ReflectionTypes> cls = ReflectionTypes.class;
        f4804a = new KProperty[]{C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    }

    public final ClassDescriptor getKClass() {
        return this.f4807d.getValue(this, f4804a[0]);
    }

    /* compiled from: ReflectionTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KotlinType createKPropertyStarType(ModuleDescriptor moduleDescriptor) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
            ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, StandardNames.FqNames.kProperty);
            if (findClassAcrossModuleDependencies == null) {
                return null;
            }
            Annotations empty = Annotations.Companion.getEMPTY();
            List<TypeParameterDescriptor> parameters = findClassAcrossModuleDependencies.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "kPropertyClass.typeConstructor.parameters");
            Object single = CollectionsKt.single(parameters);
            Intrinsics.checkNotNullExpressionValue(single, "kPropertyClass.typeConstructor.parameters.single()");
            return KotlinTypeFactory.simpleNotNullType(empty, findClassAcrossModuleDependencies, CollectionsKt.listOf(new StarProjectionImpl((TypeParameterDescriptor) single)));
        }
    }
}
