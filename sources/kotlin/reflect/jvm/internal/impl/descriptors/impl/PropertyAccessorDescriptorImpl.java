package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public abstract class PropertyAccessorDescriptorImpl extends DeclarationDescriptorNonRootImpl implements PropertyAccessorDescriptor {

    /* renamed from: a */
    static final /* synthetic */ boolean f4976a = (!PropertyAccessorDescriptorImpl.class.desiredAssertionStatus());

    /* renamed from: b */
    private boolean f4977b;

    /* renamed from: c */
    private final boolean f4978c;

    /* renamed from: d */
    private final Modality f4979d;

    /* renamed from: e */
    private final PropertyDescriptor f4980e;

    /* renamed from: f */
    private final boolean f4981f;

    /* renamed from: g */
    private final CallableMemberDescriptor.Kind f4982g;

    /* renamed from: h */
    private DescriptorVisibility f4983h;

    /* renamed from: i */
    private FunctionDescriptor f4984i;

    /* renamed from: a */
    private static /* synthetic */ void m4722a(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    public abstract PropertyAccessorDescriptor getOriginal();

    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return false;
    }

    public boolean isHiddenToOvercomeSignatureClash() {
        return false;
    }

    public boolean isInfix() {
        return false;
    }

    public boolean isOperator() {
        return false;
    }

    public boolean isSuspend() {
        return false;
    }

    public boolean isTailrec() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PropertyAccessorDescriptorImpl(Modality modality, DescriptorVisibility descriptorVisibility, PropertyDescriptor propertyDescriptor, Annotations annotations, Name name, boolean z, boolean z2, boolean z3, CallableMemberDescriptor.Kind kind, SourceElement sourceElement) {
        super(propertyDescriptor.getContainingDeclaration(), annotations, name, sourceElement);
        if (modality == null) {
            m4722a(0);
        }
        if (descriptorVisibility == null) {
            m4722a(1);
        }
        if (propertyDescriptor == null) {
            m4722a(2);
        }
        if (annotations == null) {
            m4722a(3);
        }
        if (name == null) {
            m4722a(4);
        }
        if (sourceElement == null) {
            m4722a(5);
        }
        this.f4984i = null;
        this.f4979d = modality;
        this.f4983h = descriptorVisibility;
        this.f4980e = propertyDescriptor;
        this.f4977b = z;
        this.f4978c = z2;
        this.f4981f = z3;
        this.f4982g = kind;
    }

    public boolean isDefault() {
        return this.f4977b;
    }

    public void setDefault(boolean z) {
        this.f4977b = z;
    }

    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.f4982g;
        if (kind == null) {
            m4722a(6);
        }
        return kind;
    }

    public boolean isExternal() {
        return this.f4978c;
    }

    public boolean isInline() {
        return this.f4981f;
    }

    public FunctionDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            m4722a(7);
        }
        throw new UnsupportedOperationException();
    }

    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            m4722a(8);
        }
        return emptyList;
    }

    public Modality getModality() {
        Modality modality = this.f4979d;
        if (modality == null) {
            m4722a(9);
        }
        return modality;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.f4983h;
        if (descriptorVisibility == null) {
            m4722a(10);
        }
        return descriptorVisibility;
    }

    public void setVisibility(DescriptorVisibility descriptorVisibility) {
        this.f4983h = descriptorVisibility;
    }

    public PropertyDescriptor getCorrespondingProperty() {
        PropertyDescriptor propertyDescriptor = this.f4980e;
        if (propertyDescriptor == null) {
            m4722a(12);
        }
        return propertyDescriptor;
    }

    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return getCorrespondingProperty().getExtensionReceiverParameter();
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return getCorrespondingProperty().getDispatchReceiverParameter();
    }

    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    public PropertyAccessorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    /* access modifiers changed from: protected */
    public Collection<PropertyAccessorDescriptor> getOverriddenDescriptors(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (PropertyDescriptor propertyDescriptor : getCorrespondingProperty().getOverriddenDescriptors()) {
            Object getter = z ? propertyDescriptor.getGetter() : propertyDescriptor.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            m4722a(14);
        }
        if (!f4976a && !collection.isEmpty()) {
            throw new AssertionError("Overridden accessors should be empty");
        }
    }

    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.f4984i;
    }

    public void setInitialSignatureDescriptor(FunctionDescriptor functionDescriptor) {
        this.f4984i = functionDescriptor;
    }
}
