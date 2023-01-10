package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.didi.security.uuid.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {

    /* renamed from: b */
    private final Modality f4985b;

    /* renamed from: c */
    private DescriptorVisibility f4986c;

    /* renamed from: d */
    private Collection<? extends PropertyDescriptor> f4987d;

    /* renamed from: e */
    private final PropertyDescriptor f4988e;

    /* renamed from: f */
    private final CallableMemberDescriptor.Kind f4989f;

    /* renamed from: g */
    private final boolean f4990g;

    /* renamed from: h */
    private final boolean f4991h;

    /* renamed from: i */
    private final boolean f4992i;

    /* renamed from: j */
    private final boolean f4993j;

    /* renamed from: k */
    private final boolean f4994k;

    /* renamed from: l */
    private final boolean f4995l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ReceiverParameterDescriptor f4996m;

    /* renamed from: n */
    private ReceiverParameterDescriptor f4997n;

    /* renamed from: o */
    private List<TypeParameterDescriptor> f4998o;

    /* renamed from: p */
    private PropertyGetterDescriptorImpl f4999p;

    /* renamed from: q */
    private PropertySetterDescriptor f5000q;

    /* renamed from: r */
    private boolean f5001r;

    /* renamed from: s */
    private FieldDescriptor f5002s;

    /* renamed from: t */
    private FieldDescriptor f5003t;

    /* renamed from: a */
    private static /* synthetic */ void m4727a(int i) {
        String str;
        int i2;
        Throwable th;
        if (!(i == 23 || i == 33 || i == 34 || i == 36 || i == 37)) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        }
        str = "@NotNull method %s.%s must not return null";
        if (!(i == 23 || i == 33 || i == 34 || i == 36 || i == 37)) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    i2 = 3;
                    break;
            }
        }
        i2 = 2;
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
            case 16:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 30:
                objArr[0] = "kind";
                break;
            case 6:
            case 13:
            case 32:
                objArr[0] = "source";
                break;
            case 14:
                objArr[0] = "outType";
                break;
            case 15:
                objArr[0] = "typeParameters";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
                objArr[0] = "copyConfiguration";
                break;
            case 25:
                objArr[0] = "substitutor";
                break;
            case 26:
                objArr[0] = "accessorDescriptor";
                break;
            case 27:
                objArr[0] = "newOwner";
                break;
            case 28:
                objArr[0] = "newModality";
                break;
            case 29:
                objArr[0] = "newVisibility";
                break;
            case 31:
                objArr[0] = "newName";
                break;
            case 35:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 23) {
            objArr[1] = "getSourceToUseForCopy";
        } else if (i == 33) {
            objArr[1] = "getOriginal";
        } else if (i == 34) {
            objArr[1] = "getKind";
        } else if (i == 36) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 37) {
            switch (i) {
                case 17:
                    objArr[1] = "getTypeParameters";
                    break;
                case 18:
                    objArr[1] = "getReturnType";
                    break;
                case 19:
                    objArr[1] = "getModality";
                    break;
                case 20:
                    objArr[1] = "getVisibility";
                    break;
                case 21:
                    objArr[1] = "getAccessors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[2] = Constants.CREATE_NAME;
                break;
            case 14:
            case 15:
                objArr[2] = "setType";
                break;
            case 16:
                objArr[2] = "setVisibility";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "doSubstitute";
                break;
            case 25:
            case 26:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 35:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (!(i == 23 || i == 33 || i == 34 || i == 36 || i == 37)) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    th = new IllegalArgumentException(format);
                    break;
            }
        }
        th = new IllegalStateException(format);
        throw th;
    }

    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    /* JADX WARNING: type inference failed for: r13v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected PropertyDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r12, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r13, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r14, kotlin.reflect.jvm.internal.impl.descriptors.Modality r15, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r16, boolean r17, kotlin.reflect.jvm.internal.impl.name.Name r18, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r19, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26) {
        /*
            r11 = this;
            r7 = r11
            r8 = r15
            r9 = r16
            r10 = r19
            if (r12 != 0) goto L_0x000c
            r0 = 0
            m4727a((int) r0)
        L_0x000c:
            if (r14 != 0) goto L_0x0012
            r0 = 1
            m4727a((int) r0)
        L_0x0012:
            if (r8 != 0) goto L_0x0018
            r0 = 2
            m4727a((int) r0)
        L_0x0018:
            if (r9 != 0) goto L_0x001e
            r0 = 3
            m4727a((int) r0)
        L_0x001e:
            if (r18 != 0) goto L_0x0024
            r0 = 4
            m4727a((int) r0)
        L_0x0024:
            if (r10 != 0) goto L_0x002a
            r0 = 5
            m4727a((int) r0)
        L_0x002a:
            if (r20 != 0) goto L_0x0030
            r0 = 6
            m4727a((int) r0)
        L_0x0030:
            r4 = 0
            r0 = r11
            r1 = r12
            r2 = r14
            r3 = r18
            r5 = r17
            r6 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 0
            r7.f4987d = r0
            r7.f4985b = r8
            r7.f4986c = r9
            if (r13 != 0) goto L_0x0048
            r0 = r7
            goto L_0x0049
        L_0x0048:
            r0 = r13
        L_0x0049:
            r7.f4988e = r0
            r7.f4989f = r10
            r0 = r21
            r7.f4990g = r0
            r0 = r22
            r7.f4991h = r0
            r0 = r23
            r7.f4992i = r0
            r0 = r24
            r7.f4993j = r0
            r0 = r25
            r7.f4994k = r0
            r0 = r26
            r7.f4995l = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility, boolean, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, boolean, boolean, boolean, boolean, boolean, boolean):void");
    }

    public static PropertyDescriptorImpl create(DeclarationDescriptor declarationDescriptor, Annotations annotations, Modality modality, DescriptorVisibility descriptorVisibility, boolean z, Name name, CallableMemberDescriptor.Kind kind, SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        if (declarationDescriptor == null) {
            m4727a(7);
        }
        if (annotations == null) {
            m4727a(8);
        }
        if (modality == null) {
            m4727a(9);
        }
        if (descriptorVisibility == null) {
            m4727a(10);
        }
        if (name == null) {
            m4727a(11);
        }
        if (kind == null) {
            m4727a(12);
        }
        if (sourceElement == null) {
            m4727a(13);
        }
        return new PropertyDescriptorImpl(declarationDescriptor, (PropertyDescriptor) null, annotations, modality, descriptorVisibility, z, name, kind, sourceElement, z2, z3, z4, z5, z6, z7);
    }

    public void setType(KotlinType kotlinType, List<? extends TypeParameterDescriptor> list, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2) {
        if (kotlinType == null) {
            m4727a(14);
        }
        if (list == null) {
            m4727a(15);
        }
        setOutType(kotlinType);
        this.f4998o = new ArrayList(list);
        this.f4997n = receiverParameterDescriptor2;
        this.f4996m = receiverParameterDescriptor;
    }

    public void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor) {
        initialize(propertyGetterDescriptorImpl, propertySetterDescriptor, (FieldDescriptor) null, (FieldDescriptor) null);
    }

    public void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor, FieldDescriptor fieldDescriptor, FieldDescriptor fieldDescriptor2) {
        this.f4999p = propertyGetterDescriptorImpl;
        this.f5000q = propertySetterDescriptor;
        this.f5002s = fieldDescriptor;
        this.f5003t = fieldDescriptor2;
    }

    public void setSetterProjectedOut(boolean z) {
        this.f5001r = z;
    }

    public void setVisibility(DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility == null) {
            m4727a(16);
        }
        this.f4986c = descriptorVisibility;
    }

    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.f4998o;
        if (list != null) {
            if (list == null) {
                m4727a(17);
            }
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.f4997n;
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.f4996m;
    }

    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type == null) {
            m4727a(18);
        }
        return type;
    }

    public Modality getModality() {
        Modality modality = this.f4985b;
        if (modality == null) {
            m4727a(19);
        }
        return modality;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.f4986c;
        if (descriptorVisibility == null) {
            m4727a(20);
        }
        return descriptorVisibility;
    }

    public PropertyGetterDescriptorImpl getGetter() {
        return this.f4999p;
    }

    public PropertySetterDescriptor getSetter() {
        return this.f5000q;
    }

    public boolean isSetterProjectedOut() {
        return this.f5001r;
    }

    public boolean isLateInit() {
        return this.f4990g;
    }

    public boolean isConst() {
        return this.f4991h;
    }

    public boolean isExternal() {
        return this.f4994k;
    }

    public boolean isDelegated() {
        return this.f4995l;
    }

    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.f4999p;
        if (propertyGetterDescriptorImpl != null) {
            arrayList.add(propertyGetterDescriptorImpl);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.f5000q;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    public PropertyDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            m4727a(22);
        }
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return newCopyBuilder().setSubstitution(typeSubstitutor.getSubstitution()).setOriginal(getOriginal()).build();
    }

    public class CopyConfiguration {
        /* access modifiers changed from: private */
        public boolean copyOverrides = true;
        /* access modifiers changed from: private */
        public ReceiverParameterDescriptor dispatchReceiverParameter = PropertyDescriptorImpl.this.f4996m;
        /* access modifiers changed from: private */
        public CallableMemberDescriptor.Kind kind = PropertyDescriptorImpl.this.getKind();
        /* access modifiers changed from: private */
        public Modality modality = PropertyDescriptorImpl.this.getModality();
        /* access modifiers changed from: private */
        public Name name = PropertyDescriptorImpl.this.getName();
        /* access modifiers changed from: private */
        public List<TypeParameterDescriptor> newTypeParameters = null;
        /* access modifiers changed from: private */
        public PropertyDescriptor original = null;
        /* access modifiers changed from: private */
        public DeclarationDescriptor owner = PropertyDescriptorImpl.this.getContainingDeclaration();
        /* access modifiers changed from: private */
        public boolean preserveSourceElement = false;
        /* access modifiers changed from: private */
        public KotlinType returnType = PropertyDescriptorImpl.this.getType();
        /* access modifiers changed from: private */
        public TypeSubstitution substitution = TypeSubstitution.EMPTY;
        /* access modifiers changed from: private */
        public DescriptorVisibility visibility = PropertyDescriptorImpl.this.getVisibility();

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            int i2 = i;
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? 2 : 3)];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i2 == 1) {
                objArr[1] = "setOwner";
            } else if (i2 == 2) {
                objArr[1] = "setOriginal";
            } else if (i2 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i2 == 5) {
                objArr[1] = "setReturnType";
            } else if (i2 == 7) {
                objArr[1] = "setModality";
            } else if (i2 == 9) {
                objArr[1] = "setVisibility";
            } else if (i2 == 11) {
                objArr[1] = "setKind";
            } else if (i2 == 19) {
                objArr[1] = "setName";
            } else if (i2 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i2 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i2 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i2 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            throw ((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        public CopyConfiguration() {
        }

        public CopyConfiguration setOwner(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(0);
            }
            this.owner = declarationDescriptor;
            return this;
        }

        public CopyConfiguration setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
            this.original = (PropertyDescriptor) callableMemberDescriptor;
            return this;
        }

        public CopyConfiguration setModality(Modality modality2) {
            if (modality2 == null) {
                $$$reportNull$$$0(6);
            }
            this.modality = modality2;
            return this;
        }

        public CopyConfiguration setVisibility(DescriptorVisibility descriptorVisibility) {
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(8);
            }
            this.visibility = descriptorVisibility;
            return this;
        }

        public CopyConfiguration setKind(CallableMemberDescriptor.Kind kind2) {
            if (kind2 == null) {
                $$$reportNull$$$0(10);
            }
            this.kind = kind2;
            return this;
        }

        public CopyConfiguration setSubstitution(TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(15);
            }
            this.substitution = typeSubstitution;
            return this;
        }

        public CopyConfiguration setCopyOverrides(boolean z) {
            this.copyOverrides = z;
            return this;
        }

        public PropertyDescriptor build() {
            return PropertyDescriptorImpl.this.doSubstitute(this);
        }

        /* access modifiers changed from: package-private */
        public PropertyGetterDescriptor getOriginalGetter() {
            PropertyDescriptor propertyDescriptor = this.original;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getGetter();
        }

        /* access modifiers changed from: package-private */
        public PropertySetterDescriptor getOriginalSetter() {
            PropertyDescriptor propertyDescriptor = this.original;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getSetter();
        }
    }

    public CopyConfiguration newCopyBuilder() {
        return new CopyConfiguration();
    }

    /* renamed from: a */
    private SourceElement m4726a(boolean z, PropertyDescriptor propertyDescriptor) {
        SourceElement sourceElement;
        if (z) {
            if (propertyDescriptor == null) {
                propertyDescriptor = getOriginal();
            }
            sourceElement = propertyDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            m4727a(23);
        }
        return sourceElement;
    }

    /* access modifiers changed from: protected */
    public PropertyDescriptor doSubstitute(CopyConfiguration copyConfiguration) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
        if (copyConfiguration == null) {
            m4727a(24);
        }
        PropertyDescriptorImpl createSubstitutedCopy = createSubstitutedCopy(copyConfiguration.owner, copyConfiguration.modality, copyConfiguration.visibility, copyConfiguration.original, copyConfiguration.kind, copyConfiguration.name, m4726a(copyConfiguration.preserveSourceElement, copyConfiguration.original));
        List<TypeParameterDescriptor> typeParameters = copyConfiguration.newTypeParameters == null ? getTypeParameters() : copyConfiguration.newTypeParameters;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor substituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(typeParameters, copyConfiguration.substitution, createSubstitutedCopy, arrayList);
        KotlinType substitute = substituteTypeParameters.substitute(copyConfiguration.returnType, Variance.OUT_VARIANCE);
        FieldDescriptorImpl fieldDescriptorImpl = null;
        if (substitute == null) {
            return null;
        }
        ReceiverParameterDescriptor access$1100 = copyConfiguration.dispatchReceiverParameter;
        if (access$1100 != null) {
            receiverParameterDescriptor = access$1100.substitute(substituteTypeParameters);
            if (receiverParameterDescriptor == null) {
                return null;
            }
        } else {
            receiverParameterDescriptor = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = this.f4997n;
        if (receiverParameterDescriptor2 != null) {
            KotlinType substitute2 = substituteTypeParameters.substitute(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
            if (substitute2 == null) {
                return null;
            }
            receiverParameterDescriptorImpl = new ReceiverParameterDescriptorImpl(createSubstitutedCopy, new ExtensionReceiver(createSubstitutedCopy, substitute2, this.f4997n.getValue()), this.f4997n.getAnnotations());
        } else {
            receiverParameterDescriptorImpl = null;
        }
        createSubstitutedCopy.setType(substitute, arrayList, receiverParameterDescriptor, receiverParameterDescriptorImpl);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.f4999p;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl == null ? null : new PropertyGetterDescriptorImpl(createSubstitutedCopy, propertyGetterDescriptorImpl.getAnnotations(), copyConfiguration.modality, m4723a(this.f4999p.getVisibility(), copyConfiguration.kind), this.f4999p.isDefault(), this.f4999p.isExternal(), this.f4999p.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalGetter(), SourceElement.NO_SOURCE);
        if (propertyGetterDescriptorImpl2 != null) {
            KotlinType returnType = this.f4999p.getReturnType();
            propertyGetterDescriptorImpl2.setInitialSignatureDescriptor(m4724a(substituteTypeParameters, (PropertyAccessorDescriptor) this.f4999p));
            propertyGetterDescriptorImpl2.initialize(returnType != null ? substituteTypeParameters.substitute(returnType, Variance.OUT_VARIANCE) : null);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.f5000q;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = propertySetterDescriptor == null ? null : new PropertySetterDescriptorImpl(createSubstitutedCopy, propertySetterDescriptor.getAnnotations(), copyConfiguration.modality, m4723a(this.f5000q.getVisibility(), copyConfiguration.kind), this.f5000q.isDefault(), this.f5000q.isExternal(), this.f5000q.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalSetter(), SourceElement.NO_SOURCE);
        if (propertySetterDescriptorImpl != null) {
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(propertySetterDescriptorImpl, this.f5000q.getValueParameters(), substituteTypeParameters, false, false, (boolean[]) null);
            if (substitutedValueParameters == null) {
                createSubstitutedCopy.setSetterProjectedOut(true);
                substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, DescriptorUtilsKt.getBuiltIns(copyConfiguration.owner).getNothingType(), this.f5000q.getValueParameters().get(0).getAnnotations()));
            }
            if (substitutedValueParameters.size() == 1) {
                propertySetterDescriptorImpl.setInitialSignatureDescriptor(m4724a(substituteTypeParameters, (PropertyAccessorDescriptor) this.f5000q));
                propertySetterDescriptorImpl.initialize(substitutedValueParameters.get(0));
            } else {
                throw new IllegalStateException();
            }
        }
        FieldDescriptor fieldDescriptor = this.f5002s;
        FieldDescriptorImpl fieldDescriptorImpl2 = fieldDescriptor == null ? null : new FieldDescriptorImpl(fieldDescriptor.getAnnotations(), createSubstitutedCopy);
        FieldDescriptor fieldDescriptor2 = this.f5003t;
        if (fieldDescriptor2 != null) {
            fieldDescriptorImpl = new FieldDescriptorImpl(fieldDescriptor2.getAnnotations(), createSubstitutedCopy);
        }
        createSubstitutedCopy.initialize(propertyGetterDescriptorImpl2, propertySetterDescriptorImpl, fieldDescriptorImpl2, fieldDescriptorImpl);
        if (copyConfiguration.copyOverrides) {
            SmartSet create = SmartSet.create();
            for (PropertyDescriptor substitute3 : getOverriddenDescriptors()) {
                create.add(substitute3.substitute(substituteTypeParameters));
            }
            createSubstitutedCopy.setOverriddenDescriptors(create);
        }
        if (isConst() && this.compileTimeInitializer != null) {
            createSubstitutedCopy.setCompileTimeInitializer(this.compileTimeInitializer);
        }
        return createSubstitutedCopy;
    }

    /* renamed from: a */
    private static DescriptorVisibility m4723a(DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind) {
        return (kind != CallableMemberDescriptor.Kind.FAKE_OVERRIDE || !DescriptorVisibilities.isPrivate(descriptorVisibility.normalize())) ? descriptorVisibility : DescriptorVisibilities.INVISIBLE_FAKE;
    }

    /* renamed from: a */
    private static FunctionDescriptor m4724a(TypeSubstitutor typeSubstitutor, PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (typeSubstitutor == null) {
            m4727a(25);
        }
        if (propertyAccessorDescriptor == null) {
            m4727a(26);
        }
        if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(typeSubstitutor);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, PropertyDescriptor propertyDescriptor, CallableMemberDescriptor.Kind kind, Name name, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            m4727a(27);
        }
        if (modality == null) {
            m4727a(28);
        }
        if (descriptorVisibility == null) {
            m4727a(29);
        }
        if (kind == null) {
            m4727a(30);
        }
        if (name == null) {
            m4727a(31);
        }
        if (sourceElement == null) {
            m4727a(32);
        }
        return new PropertyDescriptorImpl(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, descriptorVisibility, isVar(), name, kind, sourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d);
    }

    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.f4988e;
        PropertyDescriptor original = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original == null) {
            m4727a(33);
        }
        return original;
    }

    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.f4989f;
        if (kind == null) {
            m4727a(34);
        }
        return kind;
    }

    public boolean isExpect() {
        return this.f4992i;
    }

    public boolean isActual() {
        return this.f4993j;
    }

    public FieldDescriptor getBackingField() {
        return this.f5002s;
    }

    public FieldDescriptor getDelegateField() {
        return this.f5003t;
    }

    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            m4727a(35);
        }
        this.f4987d = collection;
    }

    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collection = this.f4987d;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            m4727a(36);
        }
        return collection;
    }

    public PropertyDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z) {
        PropertyDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setOriginal((CallableMemberDescriptor) null).setModality(modality).setVisibility(descriptorVisibility).setKind(kind).setCopyOverrides(z).build();
        if (build == null) {
            m4727a(37);
        }
        return build;
    }
}
