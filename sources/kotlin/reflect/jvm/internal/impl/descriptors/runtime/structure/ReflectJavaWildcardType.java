package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* compiled from: ReflectJavaWildcardType.kt */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {

    /* renamed from: a */
    private final WildcardType f5070a;

    /* renamed from: b */
    private final Collection<JavaAnnotation> f5071b = CollectionsKt.emptyList();

    /* renamed from: c */
    private final boolean f5072c;

    public ReflectJavaWildcardType(WildcardType wildcardType) {
        Intrinsics.checkNotNullParameter(wildcardType, "reflectType");
        this.f5070a = wildcardType;
    }

    /* access modifiers changed from: protected */
    public WildcardType getReflectType() {
        return this.f5070a;
    }

    public ReflectJavaType getBound() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        Type[] lowerBounds = getReflectType().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(Intrinsics.stringPlus("Wildcard types with many bounds are not yet supported: ", getReflectType()));
        } else if (lowerBounds.length == 1) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Intrinsics.checkNotNullExpressionValue(lowerBounds, "lowerBounds");
            Object single = ArraysKt.single((T[]) lowerBounds);
            Intrinsics.checkNotNullExpressionValue(single, "lowerBounds.single()");
            return factory.create((Type) single);
        } else if (upperBounds.length != 1) {
            return null;
        } else {
            Intrinsics.checkNotNullExpressionValue(upperBounds, "upperBounds");
            Type type = (Type) ArraysKt.single((T[]) upperBounds);
            if (Intrinsics.areEqual((Object) type, (Object) Object.class)) {
                return null;
            }
            ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
            Intrinsics.checkNotNullExpressionValue(type, "ub");
            return factory2.create(type);
        }
    }

    public boolean isExtends() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "reflectType.upperBounds");
        return !Intrinsics.areEqual(ArraysKt.firstOrNull((T[]) (Object[]) upperBounds), (Object) Object.class);
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return this.f5071b;
    }

    public boolean isDeprecatedInJavaDoc() {
        return this.f5072c;
    }
}
