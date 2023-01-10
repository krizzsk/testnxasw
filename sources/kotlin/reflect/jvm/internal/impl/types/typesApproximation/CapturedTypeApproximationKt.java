package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: CapturedTypeApproximation.kt */
public final class CapturedTypeApproximationKt {

    /* compiled from: CapturedTypeApproximation.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: a */
    private static final TypeProjection m5275a(C2680a aVar) {
        boolean d = aVar.mo27174d();
        if (_Assertions.ENABLED && !d) {
            DescriptorRenderer withOptions = DescriptorRenderer.Companion.withOptions(C2679x8e300b6.INSTANCE);
            throw new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + withOptions.render(aVar.mo27171a()) + ": <" + withOptions.renderType(aVar.mo27172b()) + ", " + withOptions.renderType(aVar.mo27173c()) + ">] was found");
        } else if (Intrinsics.areEqual((Object) aVar.mo27172b(), (Object) aVar.mo27173c()) || aVar.mo27171a().getVariance() == Variance.IN_VARIANCE) {
            return new TypeProjectionImpl(aVar.mo27172b());
        } else {
            if (KotlinBuiltIns.isNothing(aVar.mo27172b()) && aVar.mo27171a().getVariance() != Variance.IN_VARIANCE) {
                return new TypeProjectionImpl(m5276a(aVar, Variance.OUT_VARIANCE), aVar.mo27173c());
            }
            if (KotlinBuiltIns.isNullableAny(aVar.mo27173c())) {
                return new TypeProjectionImpl(m5276a(aVar, Variance.IN_VARIANCE), aVar.mo27172b());
            }
            return new TypeProjectionImpl(m5276a(aVar, Variance.OUT_VARIANCE), aVar.mo27173c());
        }
    }

    /* renamed from: a */
    private static final Variance m5276a(C2680a aVar, Variance variance) {
        return variance == aVar.mo27171a().getVariance() ? Variance.INVARIANT : variance;
    }

    /* renamed from: a */
    private static final C2680a m5277a(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        int i = WhenMappings.$EnumSwitchMapping$0[TypeSubstitutor.combine(typeParameterDescriptor.getVariance(), typeProjection).ordinal()];
        if (i == 1) {
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "type");
            KotlinType type2 = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "type");
            return new C2680a(typeParameterDescriptor, type, type2);
        } else if (i == 2) {
            KotlinType type3 = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type3, "type");
            SimpleType nullableAnyType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "typeParameter.builtIns.nullableAnyType");
            return new C2680a(typeParameterDescriptor, type3, nullableAnyType);
        } else if (i == 3) {
            SimpleType nothingType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType();
            Intrinsics.checkNotNullExpressionValue(nothingType, "typeParameter.builtIns.nothingType");
            KotlinType type4 = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type4, "type");
            return new C2680a(typeParameterDescriptor, nothingType, type4);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection typeProjection, boolean z) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
        if (!TypeUtils.contains(type, C2677x21acc51c.INSTANCE)) {
            return typeProjection;
        }
        Variance projectionKind = typeProjection.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(projectionKind, "typeProjection.projectionKind");
        if (projectionKind == Variance.OUT_VARIANCE) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getUpper());
        }
        if (z) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getLower());
        }
        return m5274a(typeProjection);
    }

    /* renamed from: a */
    private static final TypeProjection m5274a(TypeProjection typeProjection) {
        TypeSubstitutor create = TypeSubstitutor.create((TypeSubstitution) new C2678x12aaa596());
        Intrinsics.checkNotNullExpressionValue(create, "create(object : TypeCons…ojection\n        }\n    })");
        return create.substituteWithoutApproximation(typeProjection);
    }

    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(KotlinType kotlinType) {
        KotlinType kotlinType2;
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        if (FlexibleTypesKt.isFlexible(kotlinType)) {
            ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(kotlinType));
            ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(kotlinType));
            return new ApproximationBounds<>(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getLower()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getLower())), kotlinType), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getUpper()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getUpper())), kotlinType));
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (CapturedTypeConstructorKt.isCaptured(kotlinType)) {
            TypeProjection projection = ((CapturedTypeConstructor) constructor).getProjection();
            KotlinType type = projection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
            KotlinType a = m5273a(type, kotlinType);
            int i = WhenMappings.$EnumSwitchMapping$0[projection.getProjectionKind().ordinal()];
            if (i == 2) {
                SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(kotlinType).getNullableAnyType();
                Intrinsics.checkNotNullExpressionValue(nullableAnyType, "type.builtIns.nullableAnyType");
                return new ApproximationBounds<>(a, nullableAnyType);
            } else if (i == 3) {
                SimpleType nothingType = TypeUtilsKt.getBuiltIns(kotlinType).getNothingType();
                Intrinsics.checkNotNullExpressionValue(nothingType, "type.builtIns.nothingType");
                return new ApproximationBounds<>(m5273a((KotlinType) nothingType, kotlinType), a);
            } else {
                throw new AssertionError(Intrinsics.stringPlus("Only nontrivial projections should have been captured, not: ", projection));
            }
        } else if (kotlinType.getArguments().isEmpty() || kotlinType.getArguments().size() != constructor.getParameters().size()) {
            return new ApproximationBounds<>(kotlinType, kotlinType);
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<TypeParameterDescriptor> parameters = constructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
            for (Pair pair : CollectionsKt.zip(kotlinType.getArguments(), parameters)) {
                TypeProjection typeProjection = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "typeParameter");
                C2680a a2 = m5277a(typeProjection, typeParameterDescriptor);
                if (typeProjection.isStarProjection()) {
                    arrayList.add(a2);
                    arrayList2.add(a2);
                } else {
                    ApproximationBounds<C2680a> b = m5278b(a2);
                    arrayList.add(b.component1());
                    arrayList2.add(b.component2());
                }
            }
            Iterable iterable = arrayList;
            boolean z = true;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((C2680a) it.next()).mo27174d()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                SimpleType nothingType2 = TypeUtilsKt.getBuiltIns(kotlinType).getNothingType();
                Intrinsics.checkNotNullExpressionValue(nothingType2, "type.builtIns.nothingType");
                kotlinType2 = nothingType2;
            } else {
                kotlinType2 = m5272a(kotlinType, (List<C2680a>) arrayList);
            }
            return new ApproximationBounds<>(kotlinType2, m5272a(kotlinType, (List<C2680a>) arrayList2));
        }
    }

    /* renamed from: a */
    private static final KotlinType m5273a(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(kotlinType, kotlinType2.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return makeNullableIfNeeded;
    }

    /* renamed from: a */
    private static final KotlinType m5272a(KotlinType kotlinType, List<C2680a> list) {
        boolean z = kotlinType.getArguments().size() == list.size();
        if (!_Assertions.ENABLED || z) {
            Iterable<C2680a> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (C2680a a : iterable) {
                arrayList.add(m5275a(a));
            }
            return TypeSubstitutionKt.replace$default(kotlinType, (List) arrayList, (Annotations) null, (List) null, 6, (Object) null);
        }
        throw new AssertionError(Intrinsics.stringPlus("Incorrect type arguments ", list));
    }

    /* renamed from: b */
    private static final ApproximationBounds<C2680a> m5278b(C2680a aVar) {
        ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(aVar.mo27172b());
        ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(aVar.mo27173c());
        return new ApproximationBounds<>(new C2680a(aVar.mo27171a(), approximateCapturedTypes.component2(), approximateCapturedTypes2.component1()), new C2680a(aVar.mo27171a(), approximateCapturedTypes.component1(), approximateCapturedTypes2.component2()));
    }
}
