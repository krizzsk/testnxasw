package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: resolvers.kt */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LazyJavaResolverContext f5207a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final DeclarationDescriptor f5208b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f5209c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Map<JavaTypeParameter, Integer> f5210d;

    /* renamed from: e */
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> f5211e = this.f5207a.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaTypeParameterResolver$resolve$1(this));

    public LazyJavaTypeParameterResolver(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(javaTypeParameterListOwner, "typeParameterOwner");
        this.f5207a = lazyJavaResolverContext;
        this.f5208b = declarationDescriptor;
        this.f5209c = i;
        this.f5210d = CollectionsKt.mapToIndex(javaTypeParameterListOwner.getTypeParameters());
    }

    public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
        Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor invoke = this.f5211e.invoke(javaTypeParameter);
        return invoke == null ? this.f5207a.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter) : invoke;
    }
}
