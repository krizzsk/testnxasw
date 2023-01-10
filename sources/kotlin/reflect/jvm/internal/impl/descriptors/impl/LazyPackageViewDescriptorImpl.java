package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
public class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f4939a;

    /* renamed from: b */
    private final ModuleDescriptorImpl f4940b;

    /* renamed from: c */
    private final FqName f4941c;

    /* renamed from: d */
    private final NotNullLazyValue f4942d;

    /* renamed from: e */
    private final NotNullLazyValue f4943e;

    /* renamed from: f */
    private final MemberScope f4944f;

    public ModuleDescriptorImpl getModule() {
        return this.f4940b;
    }

    public FqName getFqName() {
        return this.f4941c;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl(ModuleDescriptorImpl moduleDescriptorImpl, FqName fqName, StorageManager storageManager) {
        super(Annotations.Companion.getEMPTY(), fqName.shortNameOrSpecial());
        Intrinsics.checkNotNullParameter(moduleDescriptorImpl, "module");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.f4940b = moduleDescriptorImpl;
        this.f4941c = fqName;
        this.f4942d = storageManager.createLazyValue(new LazyPackageViewDescriptorImpl$fragments$2(this));
        this.f4943e = storageManager.createLazyValue(new LazyPackageViewDescriptorImpl$empty$2(this));
        this.f4944f = new LazyScopeAdapter(storageManager, new LazyPackageViewDescriptorImpl$memberScope$1(this));
    }

    static {
        Class<LazyPackageViewDescriptorImpl> cls = LazyPackageViewDescriptorImpl.class;
        f4939a = new KProperty[]{C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "fragments", "getFragments()Ljava/util/List;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "empty", "getEmpty()Z"))};
    }

    public List<PackageFragmentDescriptor> getFragments() {
        return (List) StorageKt.getValue(this.f4942d, (Object) this, (KProperty<?>) f4939a[0]);
    }

    /* access modifiers changed from: protected */
    public final boolean getEmpty() {
        return ((Boolean) StorageKt.getValue(this.f4943e, (Object) this, (KProperty<?>) f4939a[1])).booleanValue();
    }

    public boolean isEmpty() {
        return getEmpty();
    }

    public MemberScope getMemberScope() {
        return this.f4944f;
    }

    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        ModuleDescriptorImpl module = getModule();
        FqName parent = getFqName().parent();
        Intrinsics.checkNotNullExpressionValue(parent, "fqName.parent()");
        return module.getPackage(parent);
    }

    public boolean equals(Object obj) {
        PackageViewDescriptor packageViewDescriptor = obj instanceof PackageViewDescriptor ? (PackageViewDescriptor) obj : null;
        if (packageViewDescriptor != null && Intrinsics.areEqual((Object) getFqName(), (Object) packageViewDescriptor.getFqName()) && Intrinsics.areEqual((Object) getModule(), (Object) packageViewDescriptor.getModule())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + getFqName().hashCode();
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d);
    }
}
