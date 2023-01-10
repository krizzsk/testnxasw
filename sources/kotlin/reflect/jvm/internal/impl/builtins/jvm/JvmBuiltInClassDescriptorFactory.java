package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f4851a = {C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final FqName f4852e = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Name f4853f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final ClassId f4854g;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ModuleDescriptor f4855b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Function1<ModuleDescriptor, DeclarationDescriptor> f4856c;

    /* renamed from: d */
    private final NotNullLazyValue f4857d;

    public JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> function1) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(function1, "computeContainingDeclaration");
        this.f4855b = moduleDescriptor;
        this.f4856c = function1;
        this.f4857d = storageManager.createLazyValue(new JvmBuiltInClassDescriptorFactory$cloneable$2(this, storageManager));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor, (i & 4) != 0 ? C24471.INSTANCE : function1);
    }

    static {
        Name shortName = StandardNames.FqNames.cloneable.shortName();
        Intrinsics.checkNotNullExpressionValue(shortName, "cloneable.shortName()");
        f4853f = shortName;
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe());
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        f4854g = classId;
    }

    /* renamed from: a */
    private final ClassDescriptorImpl m4686a() {
        return (ClassDescriptorImpl) StorageKt.getValue(this.f4857d, (Object) this, (KProperty<?>) f4851a[0]);
    }

    public boolean shouldCreateClass(FqName fqName, Name name) {
        Intrinsics.checkNotNullParameter(fqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        return Intrinsics.areEqual((Object) name, (Object) f4853f) && Intrinsics.areEqual((Object) fqName, (Object) f4852e);
    }

    public ClassDescriptor createClass(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (Intrinsics.areEqual((Object) classId, (Object) f4854g)) {
            return m4686a();
        }
        return null;
    }

    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "packageFqName");
        if (Intrinsics.areEqual((Object) fqName, (Object) f4852e)) {
            return SetsKt.setOf(m4686a());
        }
        return SetsKt.emptySet();
    }

    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.f4854g;
        }
    }
}
