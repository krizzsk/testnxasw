package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class LazySubstitutingClassDescriptor extends ModuleAwareClassDescriptor {

    /* renamed from: a */
    static final /* synthetic */ boolean f4945a = (!LazySubstitutingClassDescriptor.class.desiredAssertionStatus());

    /* renamed from: b */
    private final ModuleAwareClassDescriptor f4946b;

    /* renamed from: c */
    private final TypeSubstitutor f4947c;

    /* renamed from: d */
    private TypeSubstitutor f4948d;

    /* renamed from: e */
    private List<TypeParameterDescriptor> f4949e;

    /* renamed from: f */
    private List<TypeParameterDescriptor> f4950f;

    /* renamed from: g */
    private TypeConstructor f4951g;

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00de A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ void m4717a(int r15) {
        /*
            r0 = 22
            r1 = 13
            r2 = 10
            r3 = 8
            r4 = 6
            r5 = 5
            r6 = 3
            r7 = 2
            if (r15 == r7) goto L_0x001f
            if (r15 == r6) goto L_0x001f
            if (r15 == r5) goto L_0x001f
            if (r15 == r4) goto L_0x001f
            if (r15 == r3) goto L_0x001f
            if (r15 == r2) goto L_0x001f
            if (r15 == r1) goto L_0x001f
            if (r15 == r0) goto L_0x001f
            java.lang.String r8 = "@NotNull method %s.%s must not return null"
            goto L_0x0021
        L_0x001f:
            java.lang.String r8 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
        L_0x0021:
            if (r15 == r7) goto L_0x0033
            if (r15 == r6) goto L_0x0033
            if (r15 == r5) goto L_0x0033
            if (r15 == r4) goto L_0x0033
            if (r15 == r3) goto L_0x0033
            if (r15 == r2) goto L_0x0033
            if (r15 == r1) goto L_0x0033
            if (r15 == r0) goto L_0x0033
            r9 = 2
            goto L_0x0034
        L_0x0033:
            r9 = 3
        L_0x0034:
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r10 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor"
            r11 = 0
            if (r15 == r7) goto L_0x005b
            if (r15 == r6) goto L_0x0056
            if (r15 == r5) goto L_0x0051
            if (r15 == r4) goto L_0x0056
            if (r15 == r3) goto L_0x005b
            if (r15 == r2) goto L_0x0051
            if (r15 == r1) goto L_0x0056
            if (r15 == r0) goto L_0x004c
            r9[r11] = r10
            goto L_0x005f
        L_0x004c:
            java.lang.String r12 = "substitutor"
            r9[r11] = r12
            goto L_0x005f
        L_0x0051:
            java.lang.String r12 = "typeSubstitution"
            r9[r11] = r12
            goto L_0x005f
        L_0x0056:
            java.lang.String r12 = "kotlinTypeRefiner"
            r9[r11] = r12
            goto L_0x005f
        L_0x005b:
            java.lang.String r12 = "typeArguments"
            r9[r11] = r12
        L_0x005f:
            java.lang.String r11 = "substitute"
            java.lang.String r12 = "getUnsubstitutedMemberScope"
            java.lang.String r13 = "getMemberScope"
            r14 = 1
            switch(r15) {
                case 2: goto L_0x00bd;
                case 3: goto L_0x00bd;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00bd;
                case 6: goto L_0x00bd;
                case 7: goto L_0x00ba;
                case 8: goto L_0x00bd;
                case 9: goto L_0x00ba;
                case 10: goto L_0x00bd;
                case 11: goto L_0x00ba;
                case 12: goto L_0x00b7;
                case 13: goto L_0x00bd;
                case 14: goto L_0x00b7;
                case 15: goto L_0x00b2;
                case 16: goto L_0x00ad;
                case 17: goto L_0x00a8;
                case 18: goto L_0x00a3;
                case 19: goto L_0x009e;
                case 20: goto L_0x0099;
                case 21: goto L_0x0094;
                case 22: goto L_0x00bd;
                case 23: goto L_0x0091;
                case 24: goto L_0x008c;
                case 25: goto L_0x0087;
                case 26: goto L_0x0082;
                case 27: goto L_0x007d;
                case 28: goto L_0x0078;
                case 29: goto L_0x0073;
                case 30: goto L_0x006e;
                default: goto L_0x0069;
            }
        L_0x0069:
            java.lang.String r10 = "getTypeConstructor"
            r9[r14] = r10
            goto L_0x00bf
        L_0x006e:
            java.lang.String r10 = "getSealedSubclasses"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0073:
            java.lang.String r10 = "getDeclaredTypeParameters"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0078:
            java.lang.String r10 = "getSource"
            r9[r14] = r10
            goto L_0x00bf
        L_0x007d:
            java.lang.String r10 = "getUnsubstitutedInnerClassesScope"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0082:
            java.lang.String r10 = "getVisibility"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0087:
            java.lang.String r10 = "getModality"
            r9[r14] = r10
            goto L_0x00bf
        L_0x008c:
            java.lang.String r10 = "getKind"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0091:
            r9[r14] = r11
            goto L_0x00bf
        L_0x0094:
            java.lang.String r10 = "getContainingDeclaration"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0099:
            java.lang.String r10 = "getOriginal"
            r9[r14] = r10
            goto L_0x00bf
        L_0x009e:
            java.lang.String r10 = "getName"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00a3:
            java.lang.String r10 = "getAnnotations"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00a8:
            java.lang.String r10 = "getConstructors"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00ad:
            java.lang.String r10 = "getDefaultType"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00b2:
            java.lang.String r10 = "getStaticScope"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00b7:
            r9[r14] = r12
            goto L_0x00bf
        L_0x00ba:
            r9[r14] = r13
            goto L_0x00bf
        L_0x00bd:
            r9[r14] = r10
        L_0x00bf:
            if (r15 == r7) goto L_0x00d6
            if (r15 == r6) goto L_0x00d6
            if (r15 == r5) goto L_0x00d6
            if (r15 == r4) goto L_0x00d6
            if (r15 == r3) goto L_0x00d6
            if (r15 == r2) goto L_0x00d6
            if (r15 == r1) goto L_0x00d3
            if (r15 == r0) goto L_0x00d0
            goto L_0x00d8
        L_0x00d0:
            r9[r7] = r11
            goto L_0x00d8
        L_0x00d3:
            r9[r7] = r12
            goto L_0x00d8
        L_0x00d6:
            r9[r7] = r13
        L_0x00d8:
            java.lang.String r8 = java.lang.String.format(r8, r9)
            if (r15 == r7) goto L_0x00f2
            if (r15 == r6) goto L_0x00f2
            if (r15 == r5) goto L_0x00f2
            if (r15 == r4) goto L_0x00f2
            if (r15 == r3) goto L_0x00f2
            if (r15 == r2) goto L_0x00f2
            if (r15 == r1) goto L_0x00f2
            if (r15 == r0) goto L_0x00f2
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            r15.<init>(r8)
            goto L_0x00f7
        L_0x00f2:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r8)
        L_0x00f7:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor.m4717a(int):void");
    }

    public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor moduleAwareClassDescriptor, TypeSubstitutor typeSubstitutor) {
        this.f4946b = moduleAwareClassDescriptor;
        this.f4947c = typeSubstitutor;
    }

    /* renamed from: a */
    private TypeSubstitutor m4716a() {
        if (this.f4948d == null) {
            if (this.f4947c.isEmpty()) {
                this.f4948d = this.f4947c;
            } else {
                List<TypeParameterDescriptor> parameters = this.f4946b.getTypeConstructor().getParameters();
                this.f4949e = new ArrayList(parameters.size());
                this.f4948d = DescriptorSubstitutor.substituteTypeParameters(parameters, this.f4947c.getSubstitution(), this, this.f4949e);
                this.f4950f = CollectionsKt.filter(this.f4949e, new Function1<TypeParameterDescriptor, Boolean>() {
                    public Boolean invoke(TypeParameterDescriptor typeParameterDescriptor) {
                        return Boolean.valueOf(!typeParameterDescriptor.isCapturedFromOuterDeclaration());
                    }
                });
            }
        }
        return this.f4948d;
    }

    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.f4946b.getTypeConstructor();
        if (this.f4947c.isEmpty()) {
            if (typeConstructor == null) {
                m4717a(0);
            }
            return typeConstructor;
        }
        if (this.f4951g == null) {
            TypeSubstitutor a = m4716a();
            Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            for (KotlinType substitute : supertypes) {
                arrayList.add(a.substitute(substitute, Variance.INVARIANT));
            }
            this.f4951g = new ClassTypeConstructorImpl(this, this.f4949e, arrayList, LockBasedStorageManager.NO_LOCKS);
        }
        TypeConstructor typeConstructor2 = this.f4951g;
        if (typeConstructor2 == null) {
            m4717a(1);
        }
        return typeConstructor2;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution == null) {
            m4717a(5);
        }
        if (kotlinTypeRefiner == null) {
            m4717a(6);
        }
        MemberScope memberScope = this.f4946b.getMemberScope(typeSubstitution, kotlinTypeRefiner);
        if (!this.f4947c.isEmpty()) {
            return new SubstitutingScope(memberScope, m4716a());
        }
        if (memberScope == null) {
            m4717a(7);
        }
        return memberScope;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            m4717a(10);
        }
        MemberScope memberScope = getMemberScope(typeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope == null) {
            m4717a(11);
        }
        return memberScope;
    }

    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.f4946b)));
        if (unsubstitutedMemberScope == null) {
            m4717a(12);
        }
        return unsubstitutedMemberScope;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            m4717a(13);
        }
        MemberScope unsubstitutedMemberScope = this.f4946b.getUnsubstitutedMemberScope(kotlinTypeRefiner);
        if (!this.f4947c.isEmpty()) {
            return new SubstitutingScope(unsubstitutedMemberScope, m4716a());
        }
        if (unsubstitutedMemberScope == null) {
            m4717a(14);
        }
        return unsubstitutedMemberScope;
    }

    public MemberScope getStaticScope() {
        MemberScope staticScope = this.f4946b.getStaticScope();
        if (staticScope == null) {
            m4717a(15);
        }
        return staticScope;
    }

    public SimpleType getDefaultType() {
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(getAnnotations(), getTypeConstructor(), TypeUtils.getDefaultTypeProjections(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
        if (simpleTypeWithNonTrivialMemberScope == null) {
            m4717a(16);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }

    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> constructors = this.f4946b.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (ClassConstructorDescriptor next : constructors) {
            arrayList.add(((ClassConstructorDescriptor) next.newCopyBuilder().setOriginal(next.getOriginal()).setModality(next.getModality()).setVisibility(next.getVisibility()).setKind(next.getKind()).setCopyOverrides(false).build()).substitute(m4716a()));
        }
        return arrayList;
    }

    public Annotations getAnnotations() {
        Annotations annotations = this.f4946b.getAnnotations();
        if (annotations == null) {
            m4717a(18);
        }
        return annotations;
    }

    public Name getName() {
        Name name = this.f4946b.getName();
        if (name == null) {
            m4717a(19);
        }
        return name;
    }

    public ClassDescriptor getOriginal() {
        ClassDescriptor original = this.f4946b.getOriginal();
        if (original == null) {
            m4717a(20);
        }
        return original;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = this.f4946b.getContainingDeclaration();
        if (containingDeclaration == null) {
            m4717a(21);
        }
        return containingDeclaration;
    }

    public ClassDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            m4717a(22);
        }
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return new LazySubstitutingClassDescriptor(this, TypeSubstitutor.createChainedSubstitutor(typeSubstitutor.getSubstitution(), m4716a().getSubstitution()));
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.f4946b.getCompanionObjectDescriptor();
    }

    public ClassKind getKind() {
        ClassKind kind = this.f4946b.getKind();
        if (kind == null) {
            m4717a(24);
        }
        return kind;
    }

    public Modality getModality() {
        Modality modality = this.f4946b.getModality();
        if (modality == null) {
            m4717a(25);
        }
        return modality;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility visibility = this.f4946b.getVisibility();
        if (visibility == null) {
            m4717a(26);
        }
        return visibility;
    }

    public boolean isInner() {
        return this.f4946b.isInner();
    }

    public boolean isData() {
        return this.f4946b.isData();
    }

    public boolean isInline() {
        return this.f4946b.isInline();
    }

    public boolean isFun() {
        return this.f4946b.isFun();
    }

    public boolean isValue() {
        return this.f4946b.isValue();
    }

    public boolean isExternal() {
        return this.f4946b.isExternal();
    }

    public boolean isCompanionObject() {
        return this.f4946b.isCompanionObject();
    }

    public boolean isExpect() {
        return this.f4946b.isExpect();
    }

    public boolean isActual() {
        return this.f4946b.isActual();
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d);
    }

    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope unsubstitutedInnerClassesScope = this.f4946b.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope == null) {
            m4717a(27);
        }
        return unsubstitutedInnerClassesScope;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.f4946b.getUnsubstitutedPrimaryConstructor();
    }

    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        if (sourceElement == null) {
            m4717a(28);
        }
        return sourceElement;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        m4716a();
        List<TypeParameterDescriptor> list = this.f4950f;
        if (list == null) {
            m4717a(29);
        }
        return list;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> sealedSubclasses = this.f4946b.getSealedSubclasses();
        if (sealedSubclasses == null) {
            m4717a(30);
        }
        return sealedSubclasses;
    }

    public InlineClassRepresentation<SimpleType> getInlineClassRepresentation() {
        InlineClassRepresentation<SimpleType> inlineClassRepresentation = this.f4946b.getInlineClassRepresentation();
        if (inlineClassRepresentation == null) {
            return null;
        }
        return new InlineClassRepresentation<>(inlineClassRepresentation.getUnderlyingPropertyName(), m4715a(getInlineClassRepresentation().getUnderlyingType()));
    }

    /* renamed from: a */
    private SimpleType m4715a(SimpleType simpleType) {
        if (simpleType == null || this.f4947c.isEmpty()) {
            return simpleType;
        }
        KotlinType substitute = m4716a().substitute(simpleType, Variance.INVARIANT);
        if (f4945a || (substitute instanceof SimpleType)) {
            return (SimpleType) substitute;
        }
        throw new AssertionError("Substitution for SimpleType should also be a SimpleType, but it is " + substitute + "\n" + "Unsubstituted: " + simpleType);
    }
}
