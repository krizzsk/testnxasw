package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaClassObjectAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaClassObjectAnnotationArgument {

    /* renamed from: a */
    private final Class<?> f5053a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaClassObjectAnnotationArgument(Name name, Class<?> cls) {
        super(name, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(cls, "klass");
        this.f5053a = cls;
    }

    public JavaType getReferencedType() {
        return ReflectJavaType.Factory.create(this.f5053a);
    }
}
