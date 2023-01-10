package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: ResolutionAnchorProvider.kt */
public final class ResolutionAnchorProviderKt {

    /* renamed from: a */
    private static final ModuleCapability<ResolutionAnchorProvider> f5573a = new ModuleCapability<>("ResolutionAnchorProvider");

    public static final ModuleDescriptor getResolutionAnchorIfAny(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        ResolutionAnchorProvider resolutionAnchorProvider = (ResolutionAnchorProvider) moduleDescriptor.getCapability(f5573a);
        if (resolutionAnchorProvider == null) {
            return null;
        }
        return resolutionAnchorProvider.getResolutionAnchor(moduleDescriptor);
    }
}
