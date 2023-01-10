package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class JavaClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements JavaCallableMemberDescriptor {

    /* renamed from: a */
    static final /* synthetic */ boolean f5162a = (!JavaClassConstructorDescriptor.class.desiredAssertionStatus());

    /* renamed from: b */
    private Boolean f5163b;

    /* renamed from: c */
    private Boolean f5164c;

    /* renamed from: a */
    private static /* synthetic */ void m4783a(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 11 || i == 18) ? 2 : 3)];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 11 || i == 18) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected JavaClassConstructorDescriptor(ClassDescriptor classDescriptor, JavaClassConstructorDescriptor javaClassConstructorDescriptor, Annotations annotations, boolean z, CallableMemberDescriptor.Kind kind, SourceElement sourceElement) {
        super(classDescriptor, javaClassConstructorDescriptor, annotations, z, kind, sourceElement);
        if (classDescriptor == null) {
            m4783a(0);
        }
        if (annotations == null) {
            m4783a(1);
        }
        if (kind == null) {
            m4783a(2);
        }
        if (sourceElement == null) {
            m4783a(3);
        }
        this.f5163b = null;
        this.f5164c = null;
    }

    public static JavaClassConstructorDescriptor createJavaConstructor(ClassDescriptor classDescriptor, Annotations annotations, boolean z, SourceElement sourceElement) {
        if (classDescriptor == null) {
            m4783a(4);
        }
        if (annotations == null) {
            m4783a(5);
        }
        if (sourceElement == null) {
            m4783a(6);
        }
        return new JavaClassConstructorDescriptor(classDescriptor, (JavaClassConstructorDescriptor) null, annotations, z, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
    }

    public boolean hasStableParameterNames() {
        if (f5162a || this.f5163b != null) {
            return this.f5163b.booleanValue();
        }
        throw new AssertionError("hasStableParameterNames was not set: " + this);
    }

    public void setHasStableParameterNames(boolean z) {
        this.f5163b = Boolean.valueOf(z);
    }

    public boolean hasSynthesizedParameterNames() {
        if (f5162a || this.f5164c != null) {
            return this.f5164c.booleanValue();
        }
        throw new AssertionError("hasSynthesizedParameterNames was not set: " + this);
    }

    public void setHasSynthesizedParameterNames(boolean z) {
        this.f5164c = Boolean.valueOf(z);
    }

    /* access modifiers changed from: protected */
    public JavaClassConstructorDescriptor createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            m4783a(7);
        }
        if (kind == null) {
            m4783a(8);
        }
        if (annotations == null) {
            m4783a(9);
        }
        if (sourceElement == null) {
            m4783a(10);
        }
        if (kind != CallableMemberDescriptor.Kind.DECLARATION && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\n" + "newOwner: " + declarationDescriptor + "\n" + "kind: " + kind);
        } else if (f5162a || name == null) {
            JavaClassConstructorDescriptor createDescriptor = createDescriptor((ClassDescriptor) declarationDescriptor, (JavaClassConstructorDescriptor) functionDescriptor, kind, sourceElement, annotations);
            createDescriptor.setHasStableParameterNames(hasStableParameterNames());
            createDescriptor.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
            if (createDescriptor == null) {
                m4783a(11);
            }
            return createDescriptor;
        } else {
            throw new AssertionError("Attempt to rename constructor: " + this);
        }
    }

    /* access modifiers changed from: protected */
    public JavaClassConstructorDescriptor createDescriptor(ClassDescriptor classDescriptor, JavaClassConstructorDescriptor javaClassConstructorDescriptor, CallableMemberDescriptor.Kind kind, SourceElement sourceElement, Annotations annotations) {
        if (classDescriptor == null) {
            m4783a(12);
        }
        if (kind == null) {
            m4783a(13);
        }
        if (sourceElement == null) {
            m4783a(14);
        }
        if (annotations == null) {
            m4783a(15);
        }
        return new JavaClassConstructorDescriptor(classDescriptor, javaClassConstructorDescriptor, annotations, this.isPrimary, kind, sourceElement);
    }

    public JavaClassConstructorDescriptor enhance(KotlinType kotlinType, List<ValueParameterData> list, KotlinType kotlinType2, Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        if (list == null) {
            m4783a(16);
        }
        if (kotlinType2 == null) {
            m4783a(17);
        }
        JavaClassConstructorDescriptor createSubstitutedCopy = createSubstitutedCopy((DeclarationDescriptor) getContainingDeclaration(), (FunctionDescriptor) null, getKind(), (Name) null, getAnnotations(), getSource());
        if (kotlinType == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(createSubstitutedCopy, kotlinType, Annotations.Companion.getEMPTY());
        }
        createSubstitutedCopy.initialize(receiverParameterDescriptor, getDispatchReceiverParameter(), getTypeParameters(), UtilKt.copyValueParameters(list, getValueParameters(), createSubstitutedCopy), kotlinType2, getModality(), getVisibility());
        if (pair != null) {
            createSubstitutedCopy.putInUserDataMap(pair.getFirst(), pair.getSecond());
        }
        if (createSubstitutedCopy == null) {
            m4783a(18);
        }
        return createSubstitutedCopy;
    }
}
