package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* compiled from: context.kt */
public final class JavaResolverComponents {

    /* renamed from: a */
    private final StorageManager f5172a;

    /* renamed from: b */
    private final JavaClassFinder f5173b;

    /* renamed from: c */
    private final KotlinClassFinder f5174c;

    /* renamed from: d */
    private final DeserializedDescriptorResolver f5175d;

    /* renamed from: e */
    private final SignaturePropagator f5176e;

    /* renamed from: f */
    private final ErrorReporter f5177f;

    /* renamed from: g */
    private final JavaResolverCache f5178g;

    /* renamed from: h */
    private final JavaPropertyInitializerEvaluator f5179h;

    /* renamed from: i */
    private final SamConversionResolver f5180i;

    /* renamed from: j */
    private final JavaSourceElementFactory f5181j;

    /* renamed from: k */
    private final ModuleClassResolver f5182k;

    /* renamed from: l */
    private final PackagePartProvider f5183l;

    /* renamed from: m */
    private final SupertypeLoopChecker f5184m;

    /* renamed from: n */
    private final LookupTracker f5185n;

    /* renamed from: o */
    private final ModuleDescriptor f5186o;

    /* renamed from: p */
    private final ReflectionTypes f5187p;

    /* renamed from: q */
    private final AnnotationTypeQualifierResolver f5188q;

    /* renamed from: r */
    private final SignatureEnhancement f5189r;

    /* renamed from: s */
    private final JavaClassesTracker f5190s;

    /* renamed from: t */
    private final JavaResolverSettings f5191t;

    /* renamed from: u */
    private final NewKotlinTypeChecker f5192u;

    /* renamed from: v */
    private final JavaTypeEnhancementState f5193v;

    /* renamed from: w */
    private final JavaModuleAnnotationsProvider f5194w;

    /* renamed from: x */
    private final SyntheticJavaPartsProvider f5195x;

    public JavaResolverComponents(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, SignatureEnhancement signatureEnhancement, JavaClassesTracker javaClassesTracker, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState, JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, SyntheticJavaPartsProvider syntheticJavaPartsProvider) {
        StorageManager storageManager2 = storageManager;
        JavaClassFinder javaClassFinder2 = javaClassFinder;
        KotlinClassFinder kotlinClassFinder2 = kotlinClassFinder;
        DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
        SignaturePropagator signaturePropagator2 = signaturePropagator;
        ErrorReporter errorReporter2 = errorReporter;
        JavaResolverCache javaResolverCache2 = javaResolverCache;
        JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator2 = javaPropertyInitializerEvaluator;
        SamConversionResolver samConversionResolver2 = samConversionResolver;
        JavaSourceElementFactory javaSourceElementFactory2 = javaSourceElementFactory;
        ModuleClassResolver moduleClassResolver2 = moduleClassResolver;
        PackagePartProvider packagePartProvider2 = packagePartProvider;
        SupertypeLoopChecker supertypeLoopChecker2 = supertypeLoopChecker;
        LookupTracker lookupTracker2 = lookupTracker;
        ReflectionTypes reflectionTypes2 = reflectionTypes;
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(javaClassFinder2, "finder");
        Intrinsics.checkNotNullParameter(kotlinClassFinder2, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver2, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(signaturePropagator2, "signaturePropagator");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(javaResolverCache2, "javaResolverCache");
        Intrinsics.checkNotNullParameter(javaPropertyInitializerEvaluator2, "javaPropertyInitializerEvaluator");
        Intrinsics.checkNotNullParameter(samConversionResolver2, "samConversionResolver");
        Intrinsics.checkNotNullParameter(javaSourceElementFactory2, "sourceElementFactory");
        Intrinsics.checkNotNullParameter(moduleClassResolver2, "moduleClassResolver");
        Intrinsics.checkNotNullParameter(packagePartProvider2, "packagePartProvider");
        Intrinsics.checkNotNullParameter(supertypeLoopChecker2, "supertypeLoopChecker");
        Intrinsics.checkNotNullParameter(lookupTracker2, "lookupTracker");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(reflectionTypes, "reflectionTypes");
        Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        Intrinsics.checkNotNullParameter(signatureEnhancement, "signatureEnhancement");
        Intrinsics.checkNotNullParameter(javaClassesTracker, "javaClassesTracker");
        Intrinsics.checkNotNullParameter(javaResolverSettings, "settings");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        Intrinsics.checkNotNullParameter(javaModuleAnnotationsProvider, "javaModuleResolver");
        Intrinsics.checkNotNullParameter(syntheticJavaPartsProvider, "syntheticPartsProvider");
        this.f5172a = storageManager2;
        this.f5173b = javaClassFinder2;
        this.f5174c = kotlinClassFinder2;
        this.f5175d = deserializedDescriptorResolver2;
        this.f5176e = signaturePropagator2;
        this.f5177f = errorReporter2;
        this.f5178g = javaResolverCache2;
        this.f5179h = javaPropertyInitializerEvaluator2;
        this.f5180i = samConversionResolver2;
        this.f5181j = javaSourceElementFactory2;
        this.f5182k = moduleClassResolver2;
        this.f5183l = packagePartProvider2;
        this.f5184m = supertypeLoopChecker2;
        this.f5185n = lookupTracker2;
        this.f5186o = moduleDescriptor;
        this.f5187p = reflectionTypes;
        this.f5188q = annotationTypeQualifierResolver;
        this.f5189r = signatureEnhancement;
        this.f5190s = javaClassesTracker;
        this.f5191t = javaResolverSettings;
        this.f5192u = newKotlinTypeChecker;
        this.f5193v = javaTypeEnhancementState;
        this.f5194w = javaModuleAnnotationsProvider;
        this.f5195x = syntheticJavaPartsProvider;
    }

    public final StorageManager getStorageManager() {
        return this.f5172a;
    }

    public final JavaClassFinder getFinder() {
        return this.f5173b;
    }

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.f5174c;
    }

    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.f5175d;
    }

    public final SignaturePropagator getSignaturePropagator() {
        return this.f5176e;
    }

    public final ErrorReporter getErrorReporter() {
        return this.f5177f;
    }

    public final JavaResolverCache getJavaResolverCache() {
        return this.f5178g;
    }

    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.f5179h;
    }

    public final JavaSourceElementFactory getSourceElementFactory() {
        return this.f5181j;
    }

    public final ModuleClassResolver getModuleClassResolver() {
        return this.f5182k;
    }

    public final PackagePartProvider getPackagePartProvider() {
        return this.f5183l;
    }

    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.f5184m;
    }

    public final LookupTracker getLookupTracker() {
        return this.f5185n;
    }

    public final ModuleDescriptor getModule() {
        return this.f5186o;
    }

    public final ReflectionTypes getReflectionTypes() {
        return this.f5187p;
    }

    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.f5188q;
    }

    public final SignatureEnhancement getSignatureEnhancement() {
        return this.f5189r;
    }

    public final JavaClassesTracker getJavaClassesTracker() {
        return this.f5190s;
    }

    public final JavaResolverSettings getSettings() {
        return this.f5191t;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.f5192u;
    }

    public final JavaTypeEnhancementState getJavaTypeEnhancementState() {
        return this.f5193v;
    }

    public final JavaModuleAnnotationsProvider getJavaModuleResolver() {
        return this.f5194w;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaResolverComponents(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, SignatureEnhancement signatureEnhancement, JavaClassesTracker javaClassesTracker, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState, JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, SyntheticJavaPartsProvider syntheticJavaPartsProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, javaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, errorReporter, javaResolverCache, javaPropertyInitializerEvaluator, samConversionResolver, javaSourceElementFactory, moduleClassResolver, packagePartProvider, supertypeLoopChecker, lookupTracker, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, signatureEnhancement, javaClassesTracker, javaResolverSettings, newKotlinTypeChecker, javaTypeEnhancementState, javaModuleAnnotationsProvider, (i & 8388608) != 0 ? SyntheticJavaPartsProvider.Companion.getEMPTY() : syntheticJavaPartsProvider);
    }

    public final SyntheticJavaPartsProvider getSyntheticPartsProvider() {
        return this.f5195x;
    }

    public final JavaResolverComponents replace(JavaResolverCache javaResolverCache) {
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        return new JavaResolverComponents(this.f5172a, this.f5173b, this.f5174c, this.f5175d, this.f5176e, this.f5177f, javaResolverCache, this.f5179h, this.f5180i, this.f5181j, this.f5182k, this.f5183l, this.f5184m, this.f5185n, this.f5186o, this.f5187p, this.f5188q, this.f5189r, this.f5190s, this.f5191t, this.f5192u, this.f5193v, this.f5194w, (SyntheticJavaPartsProvider) null, 8388608, (DefaultConstructorMarker) null);
    }
}
