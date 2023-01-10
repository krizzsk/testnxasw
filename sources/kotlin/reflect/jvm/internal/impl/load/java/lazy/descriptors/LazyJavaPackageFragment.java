package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;

/* compiled from: LazyJavaPackageFragment.kt */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f5258a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final JavaPackage f5259b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final LazyJavaResolverContext f5260c;

    /* renamed from: d */
    private final NotNullLazyValue f5261d;

    /* renamed from: e */
    private final JvmPackageScope f5262e = new JvmPackageScope(this.f5260c, this.f5259b, this);

    /* renamed from: f */
    private final NotNullLazyValue<List<FqName>> f5263f = this.f5260c.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaPackageFragment$subPackages$1(this), CollectionsKt.emptyList());

    /* renamed from: g */
    private final Annotations f5264g;

    /* renamed from: h */
    private final NotNullLazyValue f5265h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage) {
        super(lazyJavaResolverContext.getModule(), javaPackage.getFqName());
        Annotations annotations;
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "outerContext");
        Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        this.f5259b = javaPackage;
        LazyJavaResolverContext childForClassOrPackage$default = ContextKt.childForClassOrPackage$default(lazyJavaResolverContext, this, (JavaTypeParameterListOwner) null, 0, 6, (Object) null);
        this.f5260c = childForClassOrPackage$default;
        this.f5261d = childForClassOrPackage$default.getStorageManager().createLazyValue(new LazyJavaPackageFragment$binaryClasses$2(this));
        if (this.f5260c.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations()) {
            annotations = Annotations.Companion.getEMPTY();
        } else {
            annotations = LazyJavaAnnotationsKt.resolveAnnotations(this.f5260c, this.f5259b);
        }
        this.f5264g = annotations;
        this.f5265h = this.f5260c.getStorageManager().createLazyValue(new LazyJavaPackageFragment$partToFacade$2(this));
    }

    static {
        Class<LazyJavaPackageFragment> cls = LazyJavaPackageFragment.class;
        f5258a = new KProperty[]{C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(cls), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) StorageKt.getValue(this.f5261d, (Object) this, (KProperty<?>) f5258a[0]);
    }

    public Annotations getAnnotations() {
        return this.f5264g;
    }

    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return (List) this.f5263f.invoke();
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        return this.f5262e.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(javaClass);
    }

    public JvmPackageScope getMemberScope() {
        return this.f5262e;
    }

    public String toString() {
        return "Lazy Java package fragment: " + getFqName() + " of module " + this.f5260c.getComponents().getModule();
    }

    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }
}
