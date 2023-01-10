package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDependenciesImpl implements ModuleDependencies {

    /* renamed from: a */
    private final List<ModuleDescriptorImpl> f4952a;

    /* renamed from: b */
    private final Set<ModuleDescriptorImpl> f4953b;

    /* renamed from: c */
    private final List<ModuleDescriptorImpl> f4954c;

    /* renamed from: d */
    private final Set<ModuleDescriptorImpl> f4955d;

    public ModuleDependenciesImpl(List<ModuleDescriptorImpl> list, Set<ModuleDescriptorImpl> set, List<ModuleDescriptorImpl> list2, Set<ModuleDescriptorImpl> set2) {
        Intrinsics.checkNotNullParameter(list, "allDependencies");
        Intrinsics.checkNotNullParameter(set, "modulesWhoseInternalsAreVisible");
        Intrinsics.checkNotNullParameter(list2, "directExpectedByDependencies");
        Intrinsics.checkNotNullParameter(set2, "allExpectedByDependencies");
        this.f4952a = list;
        this.f4953b = set;
        this.f4954c = list2;
        this.f4955d = set2;
    }

    public List<ModuleDescriptorImpl> getAllDependencies() {
        return this.f4952a;
    }

    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return this.f4953b;
    }

    public List<ModuleDescriptorImpl> getDirectExpectedByDependencies() {
        return this.f4954c;
    }
}
