package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class DescriptorSubstitutor {
    /* renamed from: a */
    private static /* synthetic */ void m5209a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 4 ? 3 : 2)];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        throw (i != 4 ? new IllegalArgumentException(format) : new IllegalStateException(format));
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> list, TypeSubstitution typeSubstitution, DeclarationDescriptor declarationDescriptor, List<TypeParameterDescriptor> list2) {
        if (list == null) {
            m5209a(0);
        }
        if (typeSubstitution == null) {
            m5209a(1);
        }
        if (declarationDescriptor == null) {
            m5209a(2);
        }
        if (list2 == null) {
            m5209a(3);
        }
        TypeSubstitutor substituteTypeParameters = substituteTypeParameters(list, typeSubstitution, declarationDescriptor, list2, (boolean[]) null);
        if (substituteTypeParameters != null) {
            if (substituteTypeParameters == null) {
                m5209a(4);
            }
            return substituteTypeParameters;
        }
        throw new AssertionError("Substitution failed");
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> list, TypeSubstitution typeSubstitution, DeclarationDescriptor declarationDescriptor, List<TypeParameterDescriptor> list2, boolean[] zArr) {
        TypeSubstitution typeSubstitution2 = typeSubstitution;
        List<TypeParameterDescriptor> list3 = list2;
        if (list == null) {
            m5209a(5);
        }
        if (typeSubstitution2 == null) {
            m5209a(6);
        }
        if (declarationDescriptor == null) {
            m5209a(7);
        }
        if (list3 == null) {
            m5209a(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i = 0;
        for (TypeParameterDescriptor next : list) {
            TypeParameterDescriptorImpl createForFurtherModification = TypeParameterDescriptorImpl.createForFurtherModification(declarationDescriptor, next.getAnnotations(), next.isReified(), next.getVariance(), next.getName(), i, SourceElement.NO_SOURCE, next.getStorageManager());
            hashMap.put(next.getTypeConstructor(), new TypeProjectionImpl(createForFurtherModification.getDefaultType()));
            hashMap2.put(next, createForFurtherModification);
            list3.add(createForFurtherModification);
            i++;
        }
        TypeConstructorSubstitution createByConstructorsMap = TypeConstructorSubstitution.createByConstructorsMap(hashMap);
        TypeSubstitutor createChainedSubstitutor = TypeSubstitutor.createChainedSubstitutor(typeSubstitution2, createByConstructorsMap);
        TypeSubstitutor createChainedSubstitutor2 = TypeSubstitutor.createChainedSubstitutor(typeSubstitution.replaceWithNonApproximating(), createByConstructorsMap);
        for (TypeParameterDescriptor next2 : list) {
            TypeParameterDescriptorImpl typeParameterDescriptorImpl = (TypeParameterDescriptorImpl) hashMap2.get(next2);
            for (KotlinType next3 : next2.getUpperBounds()) {
                ClassifierDescriptor declarationDescriptor2 = next3.getConstructor().getDeclarationDescriptor();
                KotlinType substitute = ((!(declarationDescriptor2 instanceof TypeParameterDescriptor) || !TypeUtilsKt.hasTypeParameterRecursiveBounds((TypeParameterDescriptor) declarationDescriptor2)) ? createChainedSubstitutor2 : createChainedSubstitutor).substitute(next3, Variance.OUT_VARIANCE);
                if (substitute == null) {
                    return null;
                }
                if (!(substitute == next3 || zArr == null)) {
                    zArr[0] = true;
                }
                typeParameterDescriptorImpl.addUpperBound(substitute);
            }
            typeParameterDescriptorImpl.setInitialized();
        }
        return createChainedSubstitutor;
    }
}
