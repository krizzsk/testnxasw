package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {

    /* renamed from: a */
    private final StorageManager f5651a;

    /* renamed from: b */
    private final KotlinMetadataFinder f5652b;

    /* renamed from: c */
    private final ModuleDescriptor f5653c;
    protected DeserializationComponents components;

    /* renamed from: d */
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> f5654d;

    /* access modifiers changed from: protected */
    public abstract DeserializedPackageFragment findPackage(FqName fqName);

    public AbstractDeserializedPackageFragmentProvider(StorageManager storageManager, KotlinMetadataFinder kotlinMetadataFinder, ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinMetadataFinder, "finder");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        this.f5651a = storageManager;
        this.f5652b = kotlinMetadataFinder;
        this.f5653c = moduleDescriptor;
        this.f5654d = storageManager.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    }

    /* access modifiers changed from: protected */
    public final StorageManager getStorageManager() {
        return this.f5651a;
    }

    /* access modifiers changed from: protected */
    public final KotlinMetadataFinder getFinder() {
        return this.f5652b;
    }

    /* access modifiers changed from: protected */
    public final ModuleDescriptor getModuleDescriptor() {
        return this.f5653c;
    }

    /* access modifiers changed from: protected */
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setComponents(DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        CollectionsKt.addIfNotNull(collection, this.f5654d.invoke(fqName));
    }

    public boolean isEmpty(FqName fqName) {
        PackageFragmentDescriptor packageFragmentDescriptor;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.f5654d.isComputed(fqName)) {
            packageFragmentDescriptor = this.f5654d.invoke(fqName);
        } else {
            packageFragmentDescriptor = findPackage(fqName);
        }
        return packageFragmentDescriptor == null;
    }

    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return kotlin.collections.CollectionsKt.listOfNotNull(this.f5654d.invoke(fqName));
    }

    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return SetsKt.emptySet();
    }
}
