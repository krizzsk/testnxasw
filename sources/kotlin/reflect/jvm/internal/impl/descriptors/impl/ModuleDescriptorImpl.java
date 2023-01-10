package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.facebook.internal.NativeProtocol;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin._Assertions;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final StorageManager f4956a;

    /* renamed from: b */
    private final KotlinBuiltIns f4957b;

    /* renamed from: c */
    private final TargetPlatform f4958c;

    /* renamed from: d */
    private final Name f4959d;

    /* renamed from: e */
    private final Map<ModuleCapability<?>, Object> f4960e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final PackageViewDescriptorFactory f4961f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ModuleDependencies f4962g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PackageFragmentProvider f4963h;

    /* renamed from: i */
    private boolean f4964i;

    /* renamed from: j */
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> f4965j;

    /* renamed from: k */
    private final Lazy f4966k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform) {
        this(name, storageManager, kotlinBuiltIns, targetPlatform, (Map) null, (Name) null, 48, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(name, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return ModuleDescriptor.DefaultImpls.accept(this, declarationDescriptorVisitor, d);
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    public KotlinBuiltIns getBuiltIns() {
        return this.f4957b;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ModuleDescriptorImpl(kotlin.reflect.jvm.internal.impl.name.Name r10, kotlin.reflect.jvm.internal.impl.storage.StorageManager r11, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r12, kotlin.reflect.jvm.internal.impl.platform.TargetPlatform r13, java.util.Map r14, kotlin.reflect.jvm.internal.impl.name.Name r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 8
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r6 = r1
            goto L_0x0008
        L_0x0007:
            r6 = r13
        L_0x0008:
            r0 = r16 & 16
            if (r0 == 0) goto L_0x0012
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r7 = r0
            goto L_0x0013
        L_0x0012:
            r7 = r14
        L_0x0013:
            r0 = r16 & 32
            if (r0 == 0) goto L_0x0019
            r8 = r1
            goto L_0x001a
        L_0x0019:
            r8 = r15
        L_0x001a:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, kotlin.reflect.jvm.internal.impl.platform.TargetPlatform, java.util.Map, kotlin.reflect.jvm.internal.impl.name.Name, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map<ModuleCapability<?>, ? extends Object> map, Name name2) {
        super(Annotations.Companion.getEMPTY(), name);
        Intrinsics.checkNotNullParameter(name, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics.checkNotNullParameter(map, "capabilities");
        this.f4956a = storageManager;
        this.f4957b = kotlinBuiltIns;
        this.f4958c = targetPlatform;
        this.f4959d = name2;
        if (name.isSpecial()) {
            Map<ModuleCapability<?>, Object> mutableMap = MapsKt.toMutableMap(map);
            this.f4960e = mutableMap;
            mutableMap.put(KotlinTypeRefinerKt.getREFINER_CAPABILITY(), new Ref(null));
            PackageViewDescriptorFactory packageViewDescriptorFactory = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
            this.f4961f = packageViewDescriptorFactory == null ? PackageViewDescriptorFactory.Default.INSTANCE : packageViewDescriptorFactory;
            this.f4964i = true;
            this.f4965j = this.f4956a.createMemoizedFunction(new ModuleDescriptorImpl$packages$1(this));
            this.f4966k = LazyKt.lazy(new C2487x39a25915(this));
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Module name must be special: ", name));
    }

    public boolean isValid() {
        return this.f4964i;
    }

    public void assertValid() {
        if (!isValid()) {
            throw new InvalidModuleException(Intrinsics.stringPlus("Accessing invalid module descriptor ", this));
        }
    }

    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.f4962g;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        throw new AssertionError("Dependencies of module " + m4720c() + " were not set");
    }

    public PackageViewDescriptor getPackage(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return this.f4965j.invoke(fqName);
    }

    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, function1);
    }

    /* renamed from: a */
    private final CompositePackageFragmentProvider m4718a() {
        return (CompositePackageFragmentProvider) this.f4966k.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final boolean m4719b() {
        return this.f4963h != null;
    }

    public final void setDependencies(ModuleDependencies moduleDependencies) {
        Intrinsics.checkNotNullParameter(moduleDependencies, "dependencies");
        boolean z = this.f4962g == null;
        if (!_Assertions.ENABLED || z) {
            this.f4962g = moduleDependencies;
            return;
        }
        throw new AssertionError("Dependencies of " + m4720c() + " were already set");
    }

    public final void setDependencies(ModuleDescriptorImpl... moduleDescriptorImplArr) {
        Intrinsics.checkNotNullParameter(moduleDescriptorImplArr, "descriptors");
        setDependencies((List<ModuleDescriptorImpl>) ArraysKt.toList((T[]) moduleDescriptorImplArr));
    }

    public final void setDependencies(List<ModuleDescriptorImpl> list) {
        Intrinsics.checkNotNullParameter(list, "descriptors");
        setDependencies(list, SetsKt.emptySet());
    }

    public final void setDependencies(List<ModuleDescriptorImpl> list, Set<ModuleDescriptorImpl> set) {
        Intrinsics.checkNotNullParameter(list, "descriptors");
        Intrinsics.checkNotNullParameter(set, NativeProtocol.AUDIENCE_FRIENDS);
        setDependencies((ModuleDependencies) new ModuleDependenciesImpl(list, set, CollectionsKt.emptyList(), SetsKt.emptySet()));
    }

    public boolean shouldSeeInternalsOf(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "targetModule");
        if (Intrinsics.areEqual((Object) this, (Object) moduleDescriptor)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.f4962g;
        Intrinsics.checkNotNull(moduleDependencies);
        if (!CollectionsKt.contains(moduleDependencies.getModulesWhoseInternalsAreVisible(), moduleDescriptor) && !getExpectedByModules().contains(moduleDescriptor) && !moduleDescriptor.getExpectedByModules().contains(this)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final String m4720c() {
        String name = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
        return name;
    }

    public final void initialize(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "providerForModuleContent");
        boolean z = !m4719b();
        if (!_Assertions.ENABLED || z) {
            this.f4963h = packageFragmentProvider;
            return;
        }
        throw new AssertionError("Attempt to initialize module " + m4720c() + " twice");
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return m4718a();
    }

    public <T> T getCapability(ModuleCapability<T> moduleCapability) {
        Intrinsics.checkNotNullParameter(moduleCapability, "capability");
        return this.f4960e.get(moduleCapability);
    }
}
