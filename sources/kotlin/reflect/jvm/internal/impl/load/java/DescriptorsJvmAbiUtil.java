package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

public final class DescriptorsJvmAbiUtil {
    /* renamed from: a */
    private static /* synthetic */ void m4768a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1 || i == 2) {
            objArr[0] = "companionObject";
        } else if (i != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean isPropertyWithBackingFieldInOuterClass(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            m4768a(0);
        }
        if (propertyDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (isClassCompanionObjectWithBackingFieldsInOuter(propertyDescriptor.getContainingDeclaration())) {
            return true;
        }
        if (!DescriptorUtils.isCompanionObject(propertyDescriptor.getContainingDeclaration()) || !hasJvmFieldAnnotation(propertyDescriptor)) {
            return false;
        }
        return true;
    }

    public static boolean isClassCompanionObjectWithBackingFieldsInOuter(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            m4768a(1);
        }
        return DescriptorUtils.isCompanionObject(declarationDescriptor) && DescriptorUtils.isClassOrEnumClass(declarationDescriptor.getContainingDeclaration()) && !isMappedIntrinsicCompanionObject((ClassDescriptor) declarationDescriptor);
    }

    public static boolean isMappedIntrinsicCompanionObject(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            m4768a(2);
        }
        return CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, classDescriptor);
    }

    public static boolean hasJvmFieldAnnotation(CallableMemberDescriptor callableMemberDescriptor) {
        FieldDescriptor backingField;
        if (callableMemberDescriptor == null) {
            m4768a(3);
        }
        if (!(callableMemberDescriptor instanceof PropertyDescriptor) || (backingField = ((PropertyDescriptor) callableMemberDescriptor).getBackingField()) == null || !backingField.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME)) {
            return callableMemberDescriptor.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME);
        }
        return true;
    }
}
