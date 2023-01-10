package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: FunctionClassDescriptor.kt */
public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final ClassId f4825h = new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, Name.identifier("Function"));
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final ClassId f4826i = new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, Name.identifier("KFunction"));
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final StorageManager f4827a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final PackageFragmentDescriptor f4828b;

    /* renamed from: c */
    private final FunctionClassKind f4829c;

    /* renamed from: d */
    private final int f4830d;

    /* renamed from: e */
    private final FunctionTypeConstructor f4831e = new FunctionTypeConstructor(this);

    /* renamed from: f */
    private final FunctionClassScope f4832f = new FunctionClassScope(this.f4827a, this);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final List<TypeParameterDescriptor> f4833g;

    public Void getCompanionObjectDescriptor() {
        return null;
    }

    public InlineClassRepresentation<SimpleType> getInlineClassRepresentation() {
        return null;
    }

    public Void getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return false;
    }

    public boolean isData() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isFun() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isInner() {
        return false;
    }

    public boolean isValue() {
        return false;
    }

    public final FunctionClassKind getFunctionKind() {
        return this.f4829c;
    }

    public final int getArity() {
        return this.f4830d;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionClassDescriptor(StorageManager storageManager, PackageFragmentDescriptor packageFragmentDescriptor, FunctionClassKind functionClassKind, int i) {
        super(storageManager, functionClassKind.numberedClassName(i));
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(functionClassKind, "functionKind");
        this.f4827a = storageManager;
        this.f4828b = packageFragmentDescriptor;
        this.f4829c = functionClassKind;
        this.f4830d = i;
        ArrayList arrayList = new ArrayList();
        Iterable intRange = new IntRange(1, this.f4830d);
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            m4674a(arrayList, this, Variance.IN_VARIANCE, Intrinsics.stringPlus("P", Integer.valueOf(((IntIterator) it).nextInt())));
            arrayList2.add(Unit.INSTANCE);
        }
        List list = (List) arrayList2;
        m4674a(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.f4833g = CollectionsKt.toList(arrayList);
    }

    /* renamed from: a */
    private static final void m4674a(ArrayList<TypeParameterDescriptor> arrayList, FunctionClassDescriptor functionClassDescriptor, Variance variance, String str) {
        arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(functionClassDescriptor, Annotations.Companion.getEMPTY(), false, variance, Name.identifier(str), arrayList.size(), functionClassDescriptor.f4827a));
    }

    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.f4828b;
    }

    public MemberScope.Empty getStaticScope() {
        return MemberScope.Empty.INSTANCE;
    }

    public TypeConstructor getTypeConstructor() {
        return this.f4831e;
    }

    /* access modifiers changed from: protected */
    public FunctionClassScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f4832f;
    }

    public List<ClassConstructorDescriptor> getConstructors() {
        return CollectionsKt.emptyList();
    }

    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PUBLIC");
        return descriptorVisibility;
    }

    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    public List<ClassDescriptor> getSealedSubclasses() {
        return CollectionsKt.emptyList();
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.f4833g;
    }

    /* compiled from: FunctionClassDescriptor.kt */
    private final class FunctionTypeConstructor extends AbstractClassTypeConstructor {
        final /* synthetic */ FunctionClassDescriptor this$0;

        /* compiled from: FunctionClassDescriptor.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FunctionClassKind.values().length];
                iArr[FunctionClassKind.Function.ordinal()] = 1;
                iArr[FunctionClassKind.KFunction.ordinal()] = 2;
                iArr[FunctionClassKind.SuspendFunction.ordinal()] = 3;
                iArr[FunctionClassKind.KSuspendFunction.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public boolean isDenotable() {
            return true;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FunctionTypeConstructor(FunctionClassDescriptor functionClassDescriptor) {
            super(functionClassDescriptor.f4827a);
            Intrinsics.checkNotNullParameter(functionClassDescriptor, "this$0");
            this.this$0 = functionClassDescriptor;
        }

        /* access modifiers changed from: protected */
        public Collection<KotlinType> computeSupertypes() {
            List list;
            int i = WhenMappings.$EnumSwitchMapping$0[this.this$0.getFunctionKind().ordinal()];
            if (i == 1) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.f4825h);
            } else if (i == 2) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.f4826i, new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, FunctionClassKind.Function.numberedClassName(this.this$0.getArity())));
            } else if (i == 3) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.f4825h);
            } else if (i == 4) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.f4826i, new ClassId(StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE, FunctionClassKind.SuspendFunction.numberedClassName(this.this$0.getArity())));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ModuleDescriptor containingDeclaration = this.this$0.f4828b.getContainingDeclaration();
            Iterable<ClassId> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ClassId classId : iterable) {
                ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(containingDeclaration, classId);
                if (findClassAcrossModuleDependencies != null) {
                    Iterable<TypeParameterDescriptor> takeLast = CollectionsKt.takeLast(getParameters(), findClassAcrossModuleDependencies.getTypeConstructor().getParameters().size());
                    Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(takeLast, 10));
                    for (TypeParameterDescriptor defaultType : takeLast) {
                        arrayList2.add(new TypeProjectionImpl(defaultType.getDefaultType()));
                    }
                    arrayList.add(KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), findClassAcrossModuleDependencies, (List) arrayList2));
                } else {
                    throw new IllegalStateException(("Built-in class " + classId + " not found").toString());
                }
            }
            return CollectionsKt.toList((List) arrayList);
        }

        public List<TypeParameterDescriptor> getParameters() {
            return this.this$0.f4833g;
        }

        public FunctionClassDescriptor getDeclarationDescriptor() {
            return this.this$0;
        }

        public String toString() {
            return getDeclarationDescriptor().toString();
        }

        /* access modifiers changed from: protected */
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }

    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return asString;
    }

    /* compiled from: FunctionClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
