package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* compiled from: context.kt */
public final class DeserializationComponents {

    /* renamed from: a */
    private final StorageManager f5666a;

    /* renamed from: b */
    private final ModuleDescriptor f5667b;

    /* renamed from: c */
    private final DeserializationConfiguration f5668c;

    /* renamed from: d */
    private final ClassDataFinder f5669d;

    /* renamed from: e */
    private final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> f5670e;

    /* renamed from: f */
    private final PackageFragmentProvider f5671f;

    /* renamed from: g */
    private final LocalClassifierTypeSettings f5672g;

    /* renamed from: h */
    private final ErrorReporter f5673h;

    /* renamed from: i */
    private final LookupTracker f5674i;

    /* renamed from: j */
    private final FlexibleTypeDeserializer f5675j;

    /* renamed from: k */
    private final Iterable<ClassDescriptorFactory> f5676k;

    /* renamed from: l */
    private final NotFoundClasses f5677l;

    /* renamed from: m */
    private final ContractDeserializer f5678m;

    /* renamed from: n */
    private final AdditionalClassPartsProvider f5679n;

    /* renamed from: o */
    private final PlatformDependentDeclarationFilter f5680o;

    /* renamed from: p */
    private final ExtensionRegistryLite f5681p;

    /* renamed from: q */
    private final NewKotlinTypeChecker f5682q;

    /* renamed from: r */
    private final SamConversionResolver f5683r;

    /* renamed from: s */
    private final PlatformDependentTypeTransformer f5684s;

    /* renamed from: t */
    private final ClassDeserializer f5685t;

    public DeserializationComponents(StorageManager storageManager, ModuleDescriptor moduleDescriptor, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends ConstantValue<?>> annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable<? extends ClassDescriptorFactory> iterable, NotFoundClasses notFoundClasses, ContractDeserializer contractDeserializer, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, ExtensionRegistryLite extensionRegistryLite, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver, PlatformDependentTypeTransformer platformDependentTypeTransformer) {
        StorageManager storageManager2 = storageManager;
        ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
        DeserializationConfiguration deserializationConfiguration2 = deserializationConfiguration;
        ClassDataFinder classDataFinder2 = classDataFinder;
        AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends ConstantValue<?>> annotationAndConstantLoader2 = annotationAndConstantLoader;
        PackageFragmentProvider packageFragmentProvider2 = packageFragmentProvider;
        LocalClassifierTypeSettings localClassifierTypeSettings2 = localClassifierTypeSettings;
        ErrorReporter errorReporter2 = errorReporter;
        LookupTracker lookupTracker2 = lookupTracker;
        FlexibleTypeDeserializer flexibleTypeDeserializer2 = flexibleTypeDeserializer;
        Iterable<? extends ClassDescriptorFactory> iterable2 = iterable;
        NotFoundClasses notFoundClasses2 = notFoundClasses;
        ContractDeserializer contractDeserializer2 = contractDeserializer;
        AdditionalClassPartsProvider additionalClassPartsProvider2 = additionalClassPartsProvider;
        ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(deserializationConfiguration2, "configuration");
        Intrinsics.checkNotNullParameter(classDataFinder2, "classDataFinder");
        Intrinsics.checkNotNullParameter(annotationAndConstantLoader2, "annotationAndConstantLoader");
        Intrinsics.checkNotNullParameter(packageFragmentProvider2, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(localClassifierTypeSettings2, "localClassifierTypeSettings");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(lookupTracker2, "lookupTracker");
        Intrinsics.checkNotNullParameter(flexibleTypeDeserializer2, "flexibleTypeDeserializer");
        Intrinsics.checkNotNullParameter(iterable2, "fictitiousClassDescriptorFactories");
        Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        Intrinsics.checkNotNullParameter(contractDeserializer2, "contractDeserializer");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider2, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(extensionRegistryLite, "extensionRegistryLite");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        Intrinsics.checkNotNullParameter(platformDependentTypeTransformer, "platformDependentTypeTransformer");
        this.f5666a = storageManager2;
        this.f5667b = moduleDescriptor2;
        this.f5668c = deserializationConfiguration2;
        this.f5669d = classDataFinder2;
        this.f5670e = annotationAndConstantLoader2;
        this.f5671f = packageFragmentProvider2;
        this.f5672g = localClassifierTypeSettings2;
        this.f5673h = errorReporter2;
        this.f5674i = lookupTracker2;
        this.f5675j = flexibleTypeDeserializer2;
        this.f5676k = iterable2;
        this.f5677l = notFoundClasses2;
        this.f5678m = contractDeserializer2;
        this.f5679n = additionalClassPartsProvider2;
        this.f5680o = platformDependentDeclarationFilter;
        this.f5681p = extensionRegistryLite;
        this.f5682q = newKotlinTypeChecker;
        this.f5683r = samConversionResolver;
        this.f5684s = platformDependentTypeTransformer;
        this.f5685t = new ClassDeserializer(this);
    }

    public final StorageManager getStorageManager() {
        return this.f5666a;
    }

    public final ModuleDescriptor getModuleDescriptor() {
        return this.f5667b;
    }

    public final DeserializationConfiguration getConfiguration() {
        return this.f5668c;
    }

    public final ClassDataFinder getClassDataFinder() {
        return this.f5669d;
    }

    public final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> getAnnotationAndConstantLoader() {
        return this.f5670e;
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        return this.f5671f;
    }

    public final LocalClassifierTypeSettings getLocalClassifierTypeSettings() {
        return this.f5672g;
    }

    public final ErrorReporter getErrorReporter() {
        return this.f5673h;
    }

    public final LookupTracker getLookupTracker() {
        return this.f5674i;
    }

    public final FlexibleTypeDeserializer getFlexibleTypeDeserializer() {
        return this.f5675j;
    }

    public final Iterable<ClassDescriptorFactory> getFictitiousClassDescriptorFactories() {
        return this.f5676k;
    }

    public final NotFoundClasses getNotFoundClasses() {
        return this.f5677l;
    }

    public final ContractDeserializer getContractDeserializer() {
        return this.f5678m;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeserializationComponents(kotlin.reflect.jvm.internal.impl.storage.StorageManager r23, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r24, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration r25, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder r26, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader r27, kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider r28, kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings r29, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r30, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker r31, kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer r32, java.lang.Iterable r33, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r34, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer r35, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider r36, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter r37, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r38, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r39, kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver r40, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r22 = this;
            r0 = r42
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x000d
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider$None r1 = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider r1 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider) r1
            r16 = r1
            goto L_0x000f
        L_0x000d:
            r16 = r36
        L_0x000f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x001a
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter$All r1 = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.All.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter r1 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter) r1
            r17 = r1
            goto L_0x001c
        L_0x001a:
            r17 = r37
        L_0x001c:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x002c
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker$Companion r1 = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl r1 = r1.getDefault()
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r1 = (kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker) r1
            r19 = r1
            goto L_0x002e
        L_0x002c:
            r19 = r39
        L_0x002e:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x003a
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer$None r0 = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer.None.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer r0 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer) r0
            r21 = r0
            goto L_0x003c
        L_0x003a:
            r21 = r41
        L_0x003c:
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r10 = r30
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r18 = r38
            r20 = r40
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader, kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider, kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker, kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer, java.lang.Iterable, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker, kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return this.f5679n;
    }

    public final PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return this.f5680o;
    }

    public final ExtensionRegistryLite getExtensionRegistryLite() {
        return this.f5681p;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.f5682q;
    }

    public final PlatformDependentTypeTransformer getPlatformDependentTypeTransformer() {
        return this.f5684s;
    }

    public final ClassDeserializer getClassDeserializer() {
        return this.f5685t;
    }

    public final ClassDescriptor deserializeClass(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return ClassDeserializer.deserializeClass$default(this.f5685t, classId, (ClassData) null, 2, (Object) null);
    }

    public final DeserializationContext createContext(PackageFragmentDescriptor packageFragmentDescriptor, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource) {
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        Intrinsics.checkNotNullParameter(versionRequirementTable2, "versionRequirementTable");
        BinaryVersion binaryVersion2 = binaryVersion;
        Intrinsics.checkNotNullParameter(binaryVersion2, "metadataVersion");
        return new DeserializationContext(this, nameResolver, packageFragmentDescriptor, typeTable, versionRequirementTable2, binaryVersion2, deserializedContainerSource, (TypeDeserializer) null, CollectionsKt.emptyList());
    }
}
