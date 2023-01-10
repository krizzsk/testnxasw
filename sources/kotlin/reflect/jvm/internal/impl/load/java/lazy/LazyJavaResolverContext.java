package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: context.kt */
public final class LazyJavaResolverContext {

    /* renamed from: a */
    private final JavaResolverComponents f5202a;

    /* renamed from: b */
    private final TypeParameterResolver f5203b;

    /* renamed from: c */
    private final Lazy<JavaTypeQualifiersByElementType> f5204c;

    /* renamed from: d */
    private final Lazy f5205d;

    /* renamed from: e */
    private final JavaTypeResolver f5206e;

    public LazyJavaResolverContext(JavaResolverComponents javaResolverComponents, TypeParameterResolver typeParameterResolver, Lazy<JavaTypeQualifiersByElementType> lazy) {
        Intrinsics.checkNotNullParameter(javaResolverComponents, "components");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        Intrinsics.checkNotNullParameter(lazy, "delegateForDefaultTypeQualifiers");
        this.f5202a = javaResolverComponents;
        this.f5203b = typeParameterResolver;
        this.f5204c = lazy;
        this.f5205d = lazy;
        this.f5206e = new JavaTypeResolver(this, typeParameterResolver);
    }

    public final JavaResolverComponents getComponents() {
        return this.f5202a;
    }

    public final TypeParameterResolver getTypeParameterResolver() {
        return this.f5203b;
    }

    public final Lazy<JavaTypeQualifiersByElementType> getDelegateForDefaultTypeQualifiers$descriptors_jvm() {
        return this.f5204c;
    }

    public final JavaTypeQualifiersByElementType getDefaultTypeQualifiers() {
        return (JavaTypeQualifiersByElementType) this.f5205d.getValue();
    }

    public final JavaTypeResolver getTypeResolver() {
        return this.f5206e;
    }

    public final StorageManager getStorageManager() {
        return this.f5202a.getStorageManager();
    }

    public final ModuleDescriptor getModule() {
        return this.f5202a.getModule();
    }
}
