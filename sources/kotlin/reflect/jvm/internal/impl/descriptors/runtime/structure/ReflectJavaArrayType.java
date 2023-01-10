package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;

/* compiled from: ReflectJavaArrayType.kt */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {

    /* renamed from: a */
    private final Type f5048a;

    /* renamed from: b */
    private final ReflectJavaType f5049b;

    /* renamed from: c */
    private final Collection<JavaAnnotation> f5050c;

    /* renamed from: d */
    private final boolean f5051d;

    public ReflectJavaArrayType(Type type) {
        ReflectJavaType reflectJavaType;
        Intrinsics.checkNotNullParameter(type, "reflectType");
        this.f5048a = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof GenericArrayType) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Type genericComponentType = ((GenericArrayType) reflectType).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "genericComponentType");
            reflectJavaType = factory.create(genericComponentType);
        } else {
            if (reflectType instanceof Class) {
                Class cls = (Class) reflectType;
                if (cls.isArray()) {
                    ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                    Class<?> componentType = cls.getComponentType();
                    Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType()");
                    reflectJavaType = factory2.create(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
        }
        this.f5049b = reflectJavaType;
        this.f5050c = CollectionsKt.emptyList();
    }

    /* access modifiers changed from: protected */
    public Type getReflectType() {
        return this.f5048a;
    }

    public ReflectJavaType getComponentType() {
        return this.f5049b;
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return this.f5050c;
    }

    public boolean isDeprecatedInJavaDoc() {
        return this.f5051d;
    }
}
