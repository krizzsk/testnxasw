package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Typography;

/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final DeserializationContext f5715a;

    /* renamed from: b */
    private final TypeDeserializer f5716b;

    /* renamed from: c */
    private final String f5717c;

    /* renamed from: d */
    private final String f5718d;

    /* renamed from: e */
    private boolean f5719e;

    /* renamed from: f */
    private final Function1<Integer, ClassifierDescriptor> f5720f;

    /* renamed from: g */
    private final Function1<Integer, ClassifierDescriptor> f5721g;

    /* renamed from: h */
    private final Map<Integer, TypeParameterDescriptor> f5722h;

    public TypeDeserializer(DeserializationContext deserializationContext, TypeDeserializer typeDeserializer, List<ProtoBuf.TypeParameter> list, String str, String str2, boolean z) {
        Map<Integer, TypeParameterDescriptor> map;
        Intrinsics.checkNotNullParameter(deserializationContext, "c");
        Intrinsics.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(str, "debugName");
        Intrinsics.checkNotNullParameter(str2, "containerPresentableName");
        this.f5715a = deserializationContext;
        this.f5716b = typeDeserializer;
        this.f5717c = str;
        this.f5718d = str2;
        this.f5719e = z;
        this.f5720f = deserializationContext.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$classifierDescriptors$1(this));
        this.f5721g = this.f5715a.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (list.isEmpty()) {
            map = MapsKt.emptyMap();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (ProtoBuf.TypeParameter next : list) {
                linkedHashMap.put(Integer.valueOf(next.getId()), new DeserializedTypeParameterDescriptor(this.f5715a, next, i));
                i++;
            }
            map = linkedHashMap;
        }
        this.f5722h = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeDeserializer(DeserializationContext deserializationContext, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationContext, typeDeserializer, list, str, str2, (i & 32) != 0 ? false : z);
    }

    public final boolean getExperimentalSuspendFunctionTypeEncountered() {
        return this.f5719e;
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt.toList(this.f5722h.values());
    }

    public final KotlinType type(ProtoBuf.Type type) {
        Intrinsics.checkNotNullParameter(type, "proto");
        if (!type.hasFlexibleTypeCapabilitiesId()) {
            return simpleType(type, true);
        }
        String string = this.f5715a.getNameResolver().getString(type.getFlexibleTypeCapabilitiesId());
        SimpleType simpleType$default = simpleType$default(this, type, false, 2, (Object) null);
        ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(type, this.f5715a.getTypeTable());
        Intrinsics.checkNotNull(flexibleUpperBound);
        return this.f5715a.getComponents().getFlexibleTypeDeserializer().create(type, string, simpleType$default, simpleType$default(this, flexibleUpperBound, false, 2, (Object) null));
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return typeDeserializer.simpleType(type, z);
    }

    public final SimpleType simpleType(ProtoBuf.Type type, boolean z) {
        SimpleType simpleType;
        SimpleType simpleType2;
        SimpleType withAbbreviation;
        Intrinsics.checkNotNullParameter(type, "proto");
        if (type.hasClassName()) {
            simpleType = m5177c(type.getClassName());
        } else {
            simpleType = type.hasTypeAliasName() ? m5177c(type.getTypeAliasName()) : null;
        }
        if (simpleType != null) {
            return simpleType;
        }
        TypeConstructor a = m5173a(type);
        if (ErrorUtils.isError(a.getDeclarationDescriptor())) {
            SimpleType createErrorTypeWithCustomConstructor = ErrorUtils.createErrorTypeWithCustomConstructor(a.toString(), a);
            Intrinsics.checkNotNullExpressionValue(createErrorTypeWithCustomConstructor, "createErrorTypeWithCusto….toString(), constructor)");
            return createErrorTypeWithCustomConstructor;
        }
        DeserializedAnnotations deserializedAnnotations = new DeserializedAnnotations(this.f5715a.getStorageManager(), new TypeDeserializer$simpleType$annotations$1(this, type));
        Iterable a2 = m5167a(type, this);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        int i = 0;
        for (Object next : a2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            List<TypeParameterDescriptor> parameters = a.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
            arrayList.add(m5174a((TypeParameterDescriptor) CollectionsKt.getOrNull(parameters, i), (ProtoBuf.Type.Argument) next));
            i = i2;
        }
        List list = CollectionsKt.toList((List) arrayList);
        ClassifierDescriptor declarationDescriptor = a.getDeclarationDescriptor();
        if (!z || !(declarationDescriptor instanceof TypeAliasDescriptor)) {
            Boolean bool = Flags.SUSPEND_TYPE.get(type.getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "SUSPEND_TYPE.get(proto.flags)");
            if (bool.booleanValue()) {
                simpleType2 = m5170a(deserializedAnnotations, a, list, type.getNullable());
            } else {
                simpleType2 = KotlinTypeFactory.simpleType$default(deserializedAnnotations, a, list, type.getNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
                Boolean bool2 = Flags.DEFINITELY_NOT_NULL_TYPE.get(type.getFlags());
                Intrinsics.checkNotNullExpressionValue(bool2, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
                if (bool2.booleanValue()) {
                    DefinitelyNotNullType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, simpleType2, false, 2, (Object) null);
                    if (makeDefinitelyNotNull$default != null) {
                        simpleType2 = makeDefinitelyNotNull$default;
                    } else {
                        throw new IllegalStateException(("null DefinitelyNotNullType for '" + simpleType2 + '\'').toString());
                    }
                }
            }
        } else {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType computeExpandedType = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) declarationDescriptor, list);
            simpleType2 = computeExpandedType.makeNullableAsSpecified(KotlinTypeKt.isNullable(computeExpandedType) || type.getNullable()).replaceAnnotations(Annotations.Companion.create(CollectionsKt.plus(deserializedAnnotations, (DeserializedAnnotations) computeExpandedType.getAnnotations())));
        }
        ProtoBuf.Type abbreviatedType = ProtoTypeTableUtilKt.abbreviatedType(type, this.f5715a.getTypeTable());
        if (!(abbreviatedType == null || (withAbbreviation = SpecialTypesKt.withAbbreviation(simpleType2, simpleType(abbreviatedType, false))) == null)) {
            simpleType2 = withAbbreviation;
        }
        if (!type.hasClassName()) {
            return simpleType2;
        }
        return this.f5715a.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtilKt.getClassId(this.f5715a.getNameResolver(), type.getClassName()), simpleType2);
    }

    /* renamed from: a */
    private static final List<ProtoBuf.Type.Argument> m5167a(ProtoBuf.Type type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf.Type.Argument> argumentList = type.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(argumentList, "argumentList");
        Collection collection = argumentList;
        ProtoBuf.Type outerType = ProtoTypeTableUtilKt.outerType(type, typeDeserializer.f5715a.getTypeTable());
        List<ProtoBuf.Type.Argument> a = outerType == null ? null : m5167a(outerType, typeDeserializer);
        if (a == null) {
            a = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus(collection, a);
    }

    /* renamed from: a */
    private static final ClassDescriptor m5168a(TypeDeserializer typeDeserializer, ProtoBuf.Type type, int i) {
        ClassId classId = NameResolverUtilKt.getClassId(typeDeserializer.f5715a.getNameResolver(), i);
        List mutableList = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence(type, new C2635x131ab842(typeDeserializer)), C2636x131ab843.INSTANCE));
        int count = SequencesKt.count(SequencesKt.generateSequence(classId, C2634x1c22db09.INSTANCE));
        while (mutableList.size() < count) {
            mutableList.add(0);
        }
        return typeDeserializer.f5715a.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    /* renamed from: a */
    private final TypeConstructor m5173a(ProtoBuf.Type type) {
        ClassifierDescriptor classifierDescriptor;
        Object obj;
        if (type.hasClassName()) {
            classifierDescriptor = this.f5720f.invoke(Integer.valueOf(type.getClassName()));
            if (classifierDescriptor == null) {
                classifierDescriptor = m5168a(this, type, type.getClassName());
            }
        } else if (type.hasTypeParameter()) {
            TypeParameterDescriptor a = m5169a(type.getTypeParameter());
            if (a == null) {
                TypeConstructor createErrorTypeConstructor = ErrorUtils.createErrorTypeConstructor("Unknown type parameter " + type.getTypeParameter() + ". Please try recompiling module containing \"" + this.f5718d + Typography.quote);
                Intrinsics.checkNotNullExpressionValue(createErrorTypeConstructor, "createErrorTypeConstruct…\\\"\"\n                    )");
                return createErrorTypeConstructor;
            }
            classifierDescriptor = a;
        } else if (type.hasTypeParameterName()) {
            String string = this.f5715a.getNameResolver().getString(type.getTypeParameterName());
            Iterator it = getOwnTypeParameters().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((TypeParameterDescriptor) obj).getName().asString(), (Object) string)) {
                    break;
                }
            }
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) obj;
            if (typeParameterDescriptor == null) {
                TypeConstructor createErrorTypeConstructor2 = ErrorUtils.createErrorTypeConstructor("Deserialized type parameter " + string + " in " + this.f5715a.getContainingDeclaration());
                Intrinsics.checkNotNullExpressionValue(createErrorTypeConstructor2, "createErrorTypeConstruct….containingDeclaration}\")");
                return createErrorTypeConstructor2;
            }
            classifierDescriptor = typeParameterDescriptor;
        } else if (type.hasTypeAliasName()) {
            classifierDescriptor = this.f5721g.invoke(Integer.valueOf(type.getTypeAliasName()));
            if (classifierDescriptor == null) {
                classifierDescriptor = m5168a(this, type, type.getTypeAliasName());
            }
        } else {
            TypeConstructor createErrorTypeConstructor3 = ErrorUtils.createErrorTypeConstructor("Unknown type");
            Intrinsics.checkNotNullExpressionValue(createErrorTypeConstructor3, "createErrorTypeConstructor(\"Unknown type\")");
            return createErrorTypeConstructor3;
        }
        TypeConstructor typeConstructor = classifierDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "classifier.typeConstructor");
        return typeConstructor;
    }

    /* renamed from: a */
    private final SimpleType m5170a(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        int size = typeConstructor.getParameters().size() - list.size();
        SimpleType simpleType = null;
        if (size == 0) {
            simpleType = m5176b(annotations, typeConstructor, list, z);
        } else if (size == 1) {
            int size2 = list.size() - 1;
            if (size2 >= 0) {
                TypeConstructor typeConstructor2 = typeConstructor.getBuiltIns().getSuspendFunction(size2).getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor2, "functionTypeConstructor.…on(arity).typeConstructor");
                simpleType = KotlinTypeFactory.simpleType$default(annotations, typeConstructor2, list, z, (KotlinTypeRefiner) null, 16, (Object) null);
            } else {
                simpleType = null;
            }
        }
        if (simpleType != null) {
            return simpleType;
        }
        SimpleType createErrorTypeWithArguments = ErrorUtils.createErrorTypeWithArguments(Intrinsics.stringPlus("Bad suspend function in metadata with constructor: ", typeConstructor), list);
        Intrinsics.checkNotNullExpressionValue(createErrorTypeWithArguments, "createErrorTypeWithArgum…      arguments\n        )");
        return createErrorTypeWithArguments;
    }

    /* renamed from: b */
    private final SimpleType m5176b(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        KotlinType simpleType$default = KotlinTypeFactory.simpleType$default(annotations, typeConstructor, list, z, (KotlinTypeRefiner) null, 16, (Object) null);
        if (!FunctionTypesKt.isFunctionType(simpleType$default)) {
            return null;
        }
        return m5171a(simpleType$default);
    }

    /* renamed from: a */
    private final SimpleType m5171a(KotlinType kotlinType) {
        boolean releaseCoroutines = this.f5715a.getComponents().getConfiguration().getReleaseCoroutines();
        TypeProjection typeProjection = (TypeProjection) CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType));
        FqName fqName = null;
        KotlinType type = typeProjection == null ? null : typeProjection.getType();
        if (type == null) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = type.getConstructor().getDeclarationDescriptor();
        FqName fqNameSafe = declarationDescriptor == null ? null : DescriptorUtilsKt.getFqNameSafe(declarationDescriptor);
        boolean z = true;
        if (type.getArguments().size() != 1 || (!SuspendFunctionTypesKt.isContinuation(fqNameSafe, true) && !SuspendFunctionTypesKt.isContinuation(fqNameSafe, false))) {
            return (SimpleType) kotlinType;
        }
        KotlinType type2 = ((TypeProjection) CollectionsKt.single(type.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(type2, "continuationArgumentType.arguments.single().type");
        DeclarationDescriptor containingDeclaration = this.f5715a.getContainingDeclaration();
        if (!(containingDeclaration instanceof CallableDescriptor)) {
            containingDeclaration = null;
        }
        CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
        if (callableDescriptor != null) {
            fqName = DescriptorUtilsKt.fqNameOrNull(callableDescriptor);
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return m5172a(kotlinType, type2);
        }
        if (!this.f5719e && (!releaseCoroutines || !SuspendFunctionTypesKt.isContinuation(fqNameSafe, !releaseCoroutines))) {
            z = false;
        }
        this.f5719e = z;
        return m5172a(kotlinType, type2);
    }

    /* renamed from: a */
    private final SimpleType m5172a(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        Iterable<TypeProjection> dropLast = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dropLast, 10));
        for (TypeProjection type : dropLast) {
            arrayList.add(type.getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, (List) arrayList, (List<Name>) null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    /* renamed from: a */
    private final TypeParameterDescriptor m5169a(int i) {
        TypeParameterDescriptor typeParameterDescriptor = this.f5722h.get(Integer.valueOf(i));
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        TypeDeserializer typeDeserializer = this.f5716b;
        if (typeDeserializer == null) {
            return null;
        }
        return typeDeserializer.m5169a(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final ClassifierDescriptor m5175b(int i) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f5715a.getNameResolver(), i);
        if (classId.isLocal()) {
            return this.f5715a.getComponents().deserializeClass(classId);
        }
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.f5715a.getComponents().getModuleDescriptor(), classId);
    }

    /* renamed from: c */
    private final SimpleType m5177c(int i) {
        if (NameResolverUtilKt.getClassId(this.f5715a.getNameResolver(), i).isLocal()) {
            return this.f5715a.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final ClassifierDescriptor m5178d(int i) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f5715a.getNameResolver(), i);
        if (classId.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.f5715a.getComponents().getModuleDescriptor(), classId);
    }

    /* renamed from: a */
    private final TypeProjection m5174a(TypeParameterDescriptor typeParameterDescriptor, ProtoBuf.Type.Argument argument) {
        if (argument.getProjection() != ProtoBuf.Type.Argument.Projection.STAR) {
            ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
            ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
            Intrinsics.checkNotNullExpressionValue(projection, "typeArgumentProto.projection");
            Variance variance = protoEnumFlags.variance(projection);
            ProtoBuf.Type type = ProtoTypeTableUtilKt.type(argument, this.f5715a.getTypeTable());
            if (type == null) {
                return new TypeProjectionImpl(ErrorUtils.createErrorType("No type recorded"));
            }
            return new TypeProjectionImpl(variance, type(type));
        } else if (typeParameterDescriptor == null) {
            return new StarProjectionForAbsentTypeParameter(this.f5715a.getComponents().getModuleDescriptor().getBuiltIns());
        } else {
            return new StarProjectionImpl(typeParameterDescriptor);
        }
    }

    public String toString() {
        String str = this.f5717c;
        TypeDeserializer typeDeserializer = this.f5716b;
        return Intrinsics.stringPlus(str, typeDeserializer == null ? "" : Intrinsics.stringPlus(". Child of ", typeDeserializer.f5717c));
    }
}
