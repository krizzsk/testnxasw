package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.osgi.framework.VersionRange;

/* compiled from: LazyJavaScope.kt */
public abstract class LazyJavaScope extends MemberScopeImpl {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f5272a;

    /* renamed from: b */
    private final LazyJavaResolverContext f5273b;

    /* renamed from: c */
    private final LazyJavaScope f5274c;

    /* renamed from: d */
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> f5275d;

    /* renamed from: e */
    private final NotNullLazyValue<DeclaredMemberIndex> f5276e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> f5277f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final MemoizedFunctionToNullable<Name, PropertyDescriptor> f5278g;

    /* renamed from: h */
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> f5279h;

    /* renamed from: i */
    private final NotNullLazyValue f5280i;

    /* renamed from: j */
    private final NotNullLazyValue f5281j;

    /* renamed from: k */
    private final NotNullLazyValue f5282k;

    /* renamed from: l */
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> f5283l;

    /* access modifiers changed from: protected */
    public abstract Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    /* access modifiers changed from: protected */
    public abstract Set<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    /* access modifiers changed from: protected */
    public void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* access modifiers changed from: protected */
    public abstract DeclaredMemberIndex computeMemberIndex();

    /* access modifiers changed from: protected */
    public abstract void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name);

    /* access modifiers changed from: protected */
    public abstract void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection);

    /* access modifiers changed from: protected */
    public abstract Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    /* access modifiers changed from: protected */
    public abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    /* access modifiers changed from: protected */
    public abstract DeclarationDescriptor getOwnerDescriptor();

    /* access modifiers changed from: protected */
    public boolean isVisibleAsFunction(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract MethodSignatureData resolveMethodSignature(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, (i & 2) != 0 ? null : lazyJavaScope);
    }

    /* access modifiers changed from: protected */
    public final LazyJavaResolverContext getC() {
        return this.f5273b;
    }

    /* access modifiers changed from: protected */
    public final LazyJavaScope getMainScope() {
        return this.f5274c;
    }

    public LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        this.f5273b = lazyJavaResolverContext;
        this.f5274c = lazyJavaScope;
        this.f5275d = lazyJavaResolverContext.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaScope$allDescriptors$1(this), CollectionsKt.emptyList());
        this.f5276e = this.f5273b.getStorageManager().createLazyValue(new LazyJavaScope$declaredMemberIndex$1(this));
        this.f5277f = this.f5273b.getStorageManager().createMemoizedFunction(new LazyJavaScope$declaredFunctions$1(this));
        this.f5278g = this.f5273b.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaScope$declaredField$1(this));
        this.f5279h = this.f5273b.getStorageManager().createMemoizedFunction(new LazyJavaScope$functions$1(this));
        this.f5280i = this.f5273b.getStorageManager().createLazyValue(new LazyJavaScope$functionNamesLazy$2(this));
        this.f5281j = this.f5273b.getStorageManager().createLazyValue(new LazyJavaScope$propertyNamesLazy$2(this));
        this.f5282k = this.f5273b.getStorageManager().createLazyValue(new LazyJavaScope$classNamesLazy$2(this));
        this.f5283l = this.f5273b.getStorageManager().createMemoizedFunction(new LazyJavaScope$properties$1(this));
    }

    /* access modifiers changed from: protected */
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.f5275d;
    }

    /* access modifiers changed from: protected */
    public final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.f5276e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m4838a(Set<SimpleFunctionDescriptor> set) {
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : set) {
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) next, false, false, 2, (Object) null);
            Object obj = linkedHashMap.get(computeJvmDescriptor$default);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(computeJvmDescriptor$default, obj);
            }
            ((List) obj).add(next);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection collection = list;
                Collection selectMostSpecificInEachOverridableGroup = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(collection, LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1.INSTANCE);
                set.removeAll(collection);
                set.addAll(selectMostSpecificInEachOverridableGroup);
            }
        }
    }

    /* compiled from: LazyJavaScope.kt */
    protected static final class MethodSignatureData {
        private final List<String> errors;
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodSignatureData)) {
                return false;
            }
            MethodSignatureData methodSignatureData = (MethodSignatureData) obj;
            return Intrinsics.areEqual((Object) this.returnType, (Object) methodSignatureData.returnType) && Intrinsics.areEqual((Object) this.receiverType, (Object) methodSignatureData.receiverType) && Intrinsics.areEqual((Object) this.valueParameters, (Object) methodSignatureData.valueParameters) && Intrinsics.areEqual((Object) this.typeParameters, (Object) methodSignatureData.typeParameters) && this.hasStableParameterNames == methodSignatureData.hasStableParameterNames && Intrinsics.areEqual((Object) this.errors, (Object) methodSignatureData.errors);
        }

        public int hashCode() {
            int hashCode = this.returnType.hashCode() * 31;
            KotlinType kotlinType = this.receiverType;
            int hashCode2 = (((((hashCode + (kotlinType == null ? 0 : kotlinType.hashCode())) * 31) + this.valueParameters.hashCode()) * 31) + this.typeParameters.hashCode()) * 31;
            boolean z = this.hasStableParameterNames;
            if (z) {
                z = true;
            }
            return ((hashCode2 + (z ? 1 : 0)) * 31) + this.errors.hashCode();
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + VersionRange.RIGHT_OPEN;
        }

        public MethodSignatureData(KotlinType kotlinType, KotlinType kotlinType2, List<? extends ValueParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, boolean z, List<String> list3) {
            Intrinsics.checkNotNullParameter(kotlinType, "returnType");
            Intrinsics.checkNotNullParameter(list, "valueParameters");
            Intrinsics.checkNotNullParameter(list2, "typeParameters");
            Intrinsics.checkNotNullParameter(list3, "errors");
            this.returnType = kotlinType;
            this.receiverType = kotlinType2;
            this.valueParameters = list;
            this.typeParameters = list2;
            this.hasStableParameterNames = z;
            this.errors = list3;
        }

        public final KotlinType getReturnType() {
            return this.returnType;
        }

        public final KotlinType getReceiverType() {
            return this.receiverType;
        }

        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        public final List<String> getErrors() {
            return this.errors;
        }
    }

    /* access modifiers changed from: protected */
    public final JavaMethodDescriptor resolveMethodToFunctionDescriptor(JavaMethod javaMethod) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Map<K, V> map;
        JavaMethod javaMethod2 = javaMethod;
        Intrinsics.checkNotNullParameter(javaMethod2, "method");
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.f5273b, javaMethod2), javaMethod.getName(), this.f5273b.getComponents().getSourceElementFactory().source(javaMethod2), ((DeclaredMemberIndex) this.f5276e.invoke()).findRecordComponentByName(javaMethod.getName()) != null && javaMethod.getValueParameters().isEmpty());
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(\n      …eters.isEmpty()\n        )");
        LazyJavaResolverContext childForMethod$default = ContextKt.childForMethod$default(this.f5273b, createJavaMethod, javaMethod2, 0, 4, (Object) null);
        Iterable<JavaTypeParameter> typeParameters = javaMethod.getTypeParameters();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter resolveTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter2 = childForMethod$default.getTypeParameterResolver().resolveTypeParameter(resolveTypeParameter);
            Intrinsics.checkNotNull(resolveTypeParameter2);
            arrayList.add(resolveTypeParameter2);
        }
        ResolvedValueParameters resolveValueParameters = resolveValueParameters(childForMethod$default, createJavaMethod, javaMethod.getValueParameters());
        MethodSignatureData resolveMethodSignature = resolveMethodSignature(javaMethod2, (List) arrayList, computeMethodReturnType(javaMethod2, childForMethod$default), resolveValueParameters.getDescriptors());
        KotlinType receiverType = resolveMethodSignature.getReceiverType();
        if (receiverType == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(createJavaMethod, receiverType, Annotations.Companion.getEMPTY());
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<TypeParameterDescriptor> typeParameters2 = resolveMethodSignature.getTypeParameters();
        List<ValueParameterDescriptor> valueParameters = resolveMethodSignature.getValueParameters();
        KotlinType returnType = resolveMethodSignature.getReturnType();
        Modality convertFromFlags = Modality.Companion.convertFromFlags(false, javaMethod.isAbstract(), !javaMethod.isFinal());
        DescriptorVisibility descriptorVisibility = UtilsKt.toDescriptorVisibility(javaMethod.getVisibility());
        if (resolveMethodSignature.getReceiverType() != null) {
            map = MapsKt.mapOf(TuplesKt.m41339to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt.first(resolveValueParameters.getDescriptors())));
        } else {
            map = MapsKt.emptyMap();
        }
        createJavaMethod.initialize(receiverParameterDescriptor2, dispatchReceiverParameter, typeParameters2, valueParameters, returnType, convertFromFlags, descriptorVisibility, map);
        createJavaMethod.setParameterNamesStatus(resolveMethodSignature.getHasStableParameterNames(), resolveValueParameters.getHasSynthesizedNames());
        if (!resolveMethodSignature.getErrors().isEmpty()) {
            childForMethod$default.getComponents().getSignaturePropagator().reportSignatureErrors(createJavaMethod, resolveMethodSignature.getErrors());
        }
        return createJavaMethod;
    }

    /* access modifiers changed from: protected */
    public final KotlinType computeMethodReturnType(JavaMethod javaMethod, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(javaMethod, "method");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        return lazyJavaResolverContext.getTypeResolver().transformJavaType(javaMethod.getReturnType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, javaMethod.getContainingClass().isAnnotationType(), (TypeParameterDescriptor) null, 2, (Object) null));
    }

    /* compiled from: LazyJavaScope.kt */
    protected static final class ResolvedValueParameters {
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        public ResolvedValueParameters(List<? extends ValueParameterDescriptor> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "descriptors");
            this.descriptors = list;
            this.hasSynthesizedNames = z;
        }

        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }
    }

    /* JADX WARNING: type inference failed for: r9v9, types: [kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters resolveValueParameters(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r21, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r22, java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> r23) {
        /*
            r20 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "jValueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = r2
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.lang.Iterable r3 = kotlin.collections.CollectionsKt.withIndex(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
            r5 = 0
            r6 = 0
        L_0x002f:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x012c
            java.lang.Object r7 = r3.next()
            kotlin.collections.IndexedValue r7 = (kotlin.collections.IndexedValue) r7
            int r11 = r7.component1()
            java.lang.Object r7 = r7.component2()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter r7 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter) r7
            r8 = r7
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner r8 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner) r8
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r12 = kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(r0, r8)
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r8 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r9 = 3
            r10 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r8 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r8, r5, r10, r9, r10)
            boolean r9 = r7.isVararg()
            r13 = 1
            if (r9 == 0) goto L_0x008d
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r9 = r7.getType()
            boolean r14 = r9 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
            if (r14 == 0) goto L_0x0066
            r10 = r9
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType r10 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) r10
        L_0x0066:
            if (r10 == 0) goto L_0x0081
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r9 = r21.getTypeResolver()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r9.transformArrayType(r10, r8, r13)
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r9 = r21.getModule()
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r9 = r9.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = r9.getArrayElementType(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.m41339to(r8, r9)
            goto L_0x009d
        L_0x0081:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "Vararg parameter should be an array: "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r7)
            r0.<init>(r1)
            throw r0
        L_0x008d:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r9 = r21.getTypeResolver()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r14 = r7.getType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r9.transformJavaType(r14, r8)
            kotlin.Pair r8 = kotlin.TuplesKt.m41339to(r8, r10)
        L_0x009d:
            java.lang.Object r9 = r8.component1()
            r14 = r9
            kotlin.reflect.jvm.internal.impl.types.KotlinType r14 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r14
            java.lang.Object r8 = r8.component2()
            r18 = r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r18 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r18
            kotlin.reflect.jvm.internal.impl.name.Name r8 = r22.getName()
            java.lang.String r8 = r8.asString()
            java.lang.String r9 = "equals"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x00db
            int r8 = r23.size()
            if (r8 != r13) goto L_0x00db
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r8 = r21.getModule()
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = r8.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = r8.getNullableAnyType()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r14)
            if (r8 == 0) goto L_0x00db
            java.lang.String r8 = "other"
            kotlin.reflect.jvm.internal.impl.name.Name r8 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r8)
            goto L_0x00f7
        L_0x00db:
            kotlin.reflect.jvm.internal.impl.name.Name r8 = r7.getName()
            if (r8 != 0) goto L_0x00e2
            r6 = 1
        L_0x00e2:
            if (r8 != 0) goto L_0x00f7
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)
            java.lang.String r9 = "p"
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r8)
            kotlin.reflect.jvm.internal.impl.name.Name r8 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r8)
            java.lang.String r9 = "identifier(\"p$index\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
        L_0x00f7:
            r13 = r8
            java.lang.String r8 = "if (function.name.asStri…(\"p$index\")\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r8)
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl r15 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl
            r9 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r9
            r10 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r8 = r21.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r8 = r8.getSourceElementFactory()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r7 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement) r7
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r7 = r8.source(r7)
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = (kotlin.reflect.jvm.internal.impl.descriptors.SourceElement) r7
            r8 = r15
            r5 = r15
            r15 = r16
            r16 = r17
            r17 = r19
            r19 = r7
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r4.add(r5)
            r5 = 0
            goto L_0x002f
        L_0x012c:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r0 = kotlin.collections.CollectionsKt.toList(r4)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters
            r1.<init>(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.resolveValueParameters(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.util.List):kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters");
    }

    static {
        Class<LazyJavaScope> cls = LazyJavaScope.class;
        f5272a = new KProperty[]{C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    /* renamed from: a */
    private final Set<Name> m4836a() {
        return (Set) StorageKt.getValue(this.f5280i, (Object) this, (KProperty<?>) f5272a[0]);
    }

    /* renamed from: b */
    private final Set<Name> m4839b() {
        return (Set) StorageKt.getValue(this.f5281j, (Object) this, (KProperty<?>) f5272a[1]);
    }

    /* renamed from: c */
    private final Set<Name> m4841c() {
        return (Set) StorageKt.getValue(this.f5282k, (Object) this, (KProperty<?>) f5272a[2]);
    }

    public Set<Name> getFunctionNames() {
        return m4836a();
    }

    public Set<Name> getVariableNames() {
        return m4839b();
    }

    public Set<Name> getClassifierNames() {
        return m4841c();
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (!getFunctionNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return this.f5279h.invoke(name);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final PropertyDescriptor m4837a(JavaField javaField) {
        PropertyDescriptorImpl b = m4840b(javaField);
        b.initialize((PropertyGetterDescriptorImpl) null, (PropertySetterDescriptor) null, (FieldDescriptor) null, (FieldDescriptor) null);
        b.setType(m4843d(javaField), CollectionsKt.emptyList(), getDispatchReceiverParameter(), (ReceiverParameterDescriptor) null);
        if (DescriptorUtils.shouldRecordInitializerForProperty(b, b.getType())) {
            b.setCompileTimeInitializer(this.f5273b.getStorageManager().createNullableLazyValue(new LazyJavaScope$resolveProperty$1(this, javaField, b)));
        }
        PropertyDescriptor propertyDescriptor = b;
        this.f5273b.getComponents().getJavaResolverCache().recordField(javaField, propertyDescriptor);
        return propertyDescriptor;
    }

    /* renamed from: b */
    private final PropertyDescriptorImpl m4840b(JavaField javaField) {
        JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.f5273b, javaField), Modality.FINAL, UtilsKt.toDescriptorVisibility(javaField.getVisibility()), !javaField.isFinal(), javaField.getName(), this.f5273b.getComponents().getSourceElementFactory().source(javaField), m4842c(javaField));
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            owne…d.isFinalStatic\n        )");
        return create;
    }

    /* renamed from: c */
    private final boolean m4842c(JavaField javaField) {
        return javaField.isFinal() && javaField.isStatic();
    }

    /* renamed from: d */
    private final KotlinType m4843d(JavaField javaField) {
        boolean z = false;
        KotlinType transformJavaType = this.f5273b.getTypeResolver().transformJavaType(javaField.getType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null));
        if ((KotlinBuiltIns.isPrimitiveType(transformJavaType) || KotlinBuiltIns.isString(transformJavaType)) && m4842c(javaField) && javaField.getHasConstantNotNullInitializer()) {
            z = true;
        }
        if (!z) {
            return transformJavaType;
        }
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(transformJavaType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(propertyType)");
        return makeNotNullable;
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (!getVariableNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return this.f5283l.invoke(name);
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this.f5275d.invoke();
    }

    /* access modifiers changed from: protected */
    public final List<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name next : computeClassNames(descriptorKindFilter, function1)) {
                if (function1.invoke(next).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(linkedHashSet, getContributedClassifier(next, noLookupLocation));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) && !descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name next2 : computeFunctionNames(descriptorKindFilter, function1)) {
                if (function1.invoke(next2).booleanValue()) {
                    linkedHashSet.addAll(getContributedFunctions(next2, noLookupLocation));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) && !descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name next3 : computePropertyNames(descriptorKindFilter, function1)) {
                if (function1.invoke(next3).booleanValue()) {
                    linkedHashSet.addAll(getContributedVariables(next3, noLookupLocation));
                }
            }
        }
        return CollectionsKt.toList(linkedHashSet);
    }

    public String toString() {
        return Intrinsics.stringPlus("Lazy scope for ", getOwnerDescriptor());
    }
}
