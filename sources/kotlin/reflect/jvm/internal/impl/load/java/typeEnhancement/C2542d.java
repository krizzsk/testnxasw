package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.osgi.framework.VersionRange;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d */
/* compiled from: signatureEnhancement.kt */
final class C2542d {

    /* renamed from: a */
    private final KotlinType f5332a;

    /* renamed from: b */
    private final JavaDefaultQualifiers f5333b;

    /* renamed from: c */
    private final TypeParameterDescriptor f5334c;

    /* renamed from: d */
    private final boolean f5335d;

    /* renamed from: b */
    public final KotlinType mo25250b() {
        return this.f5332a;
    }

    /* renamed from: c */
    public final JavaDefaultQualifiers mo25251c() {
        return this.f5333b;
    }

    /* renamed from: d */
    public final TypeParameterDescriptor mo25252d() {
        return this.f5334c;
    }

    /* renamed from: e */
    public final boolean mo25253e() {
        return this.f5335d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2542d)) {
            return false;
        }
        C2542d dVar = (C2542d) obj;
        return Intrinsics.areEqual((Object) this.f5332a, (Object) dVar.f5332a) && Intrinsics.areEqual((Object) this.f5333b, (Object) dVar.f5333b) && Intrinsics.areEqual((Object) this.f5334c, (Object) dVar.f5334c) && this.f5335d == dVar.f5335d;
    }

    public int hashCode() {
        int hashCode = this.f5332a.hashCode() * 31;
        JavaDefaultQualifiers javaDefaultQualifiers = this.f5333b;
        int i = 0;
        int hashCode2 = (hashCode + (javaDefaultQualifiers == null ? 0 : javaDefaultQualifiers.hashCode())) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.f5334c;
        if (typeParameterDescriptor != null) {
            i = typeParameterDescriptor.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.f5335d;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.f5332a + ", defaultQualifiers=" + this.f5333b + ", typeParameterForArgument=" + this.f5334c + ", isFromStarProjection=" + this.f5335d + VersionRange.RIGHT_OPEN;
    }

    public C2542d(KotlinType kotlinType, JavaDefaultQualifiers javaDefaultQualifiers, TypeParameterDescriptor typeParameterDescriptor, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.f5332a = kotlinType;
        this.f5333b = javaDefaultQualifiers;
        this.f5334c = typeParameterDescriptor;
        this.f5335d = z;
    }

    /* renamed from: a */
    public final KotlinType mo25249a() {
        return this.f5332a;
    }
}
