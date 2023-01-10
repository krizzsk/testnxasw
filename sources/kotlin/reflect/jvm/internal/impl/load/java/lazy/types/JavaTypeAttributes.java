package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.osgi.framework.VersionRange;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeAttributes {

    /* renamed from: a */
    private final TypeUsage f5288a;

    /* renamed from: b */
    private final JavaTypeFlexibility f5289b;

    /* renamed from: c */
    private final boolean f5290c;

    /* renamed from: d */
    private final Set<TypeParameterDescriptor> f5291d;

    /* renamed from: e */
    private final SimpleType f5292e;

    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes javaTypeAttributes, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set<TypeParameterDescriptor> set, SimpleType simpleType, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = javaTypeAttributes.f5288a;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.f5289b;
        }
        JavaTypeFlexibility javaTypeFlexibility2 = javaTypeFlexibility;
        if ((i & 4) != 0) {
            z = javaTypeAttributes.f5290c;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            set = javaTypeAttributes.f5291d;
        }
        Set<TypeParameterDescriptor> set2 = set;
        if ((i & 16) != 0) {
            simpleType = javaTypeAttributes.f5292e;
        }
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility2, z2, set2, simpleType);
    }

    public final JavaTypeAttributes copy(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return new JavaTypeAttributes(typeUsage, javaTypeFlexibility, z, set, simpleType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaTypeAttributes)) {
            return false;
        }
        JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) obj;
        return this.f5288a == javaTypeAttributes.f5288a && this.f5289b == javaTypeAttributes.f5289b && this.f5290c == javaTypeAttributes.f5290c && Intrinsics.areEqual((Object) this.f5291d, (Object) javaTypeAttributes.f5291d) && Intrinsics.areEqual((Object) this.f5292e, (Object) javaTypeAttributes.f5292e);
    }

    public int hashCode() {
        int hashCode = ((this.f5288a.hashCode() * 31) + this.f5289b.hashCode()) * 31;
        boolean z = this.f5290c;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        Set<TypeParameterDescriptor> set = this.f5291d;
        int i2 = 0;
        int hashCode2 = (i + (set == null ? 0 : set.hashCode())) * 31;
        SimpleType simpleType = this.f5292e;
        if (simpleType != null) {
            i2 = simpleType.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f5288a + ", flexibility=" + this.f5289b + ", isForAnnotationParameter=" + this.f5290c + ", visitedTypeParameters=" + this.f5291d + ", defaultType=" + this.f5292e + VersionRange.RIGHT_OPEN;
    }

    public JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        this.f5288a = typeUsage;
        this.f5289b = javaTypeFlexibility;
        this.f5290c = z;
        this.f5291d = set;
        this.f5292e = simpleType;
    }

    public final TypeUsage getHowThisTypeIsUsed() {
        return this.f5288a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set set, SimpleType simpleType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : set, (i & 16) != 0 ? null : simpleType);
    }

    public final JavaTypeFlexibility getFlexibility() {
        return this.f5289b;
    }

    public final boolean isForAnnotationParameter() {
        return this.f5290c;
    }

    public final Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.f5291d;
    }

    public final SimpleType getDefaultType() {
        return this.f5292e;
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility javaTypeFlexibility) {
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return copy$default(this, (TypeUsage) null, javaTypeFlexibility, false, (Set) null, (SimpleType) null, 29, (Object) null);
    }

    public final JavaTypeAttributes withDefaultType(SimpleType simpleType) {
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, (Set) null, simpleType, 15, (Object) null);
    }

    public final JavaTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Set<TypeParameterDescriptor> set = this.f5291d;
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, set != null ? SetsKt.plus(set, typeParameterDescriptor) : SetsKt.setOf(typeParameterDescriptor), (SimpleType) null, 23, (Object) null);
    }
}
