package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import org.osgi.framework.VersionRange;

/* compiled from: AnnotationQualifiersFqNames.kt */
public final class JavaDefaultQualifiers {

    /* renamed from: a */
    private final NullabilityQualifierWithMigrationStatus f5089a;

    /* renamed from: b */
    private final Collection<AnnotationQualifierApplicabilityType> f5090b;

    /* renamed from: c */
    private final boolean f5091c;

    /* renamed from: d */
    private final boolean f5092d;

    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifierWithMigrationStatus = javaDefaultQualifiers.f5089a;
        }
        if ((i & 2) != 0) {
            collection = javaDefaultQualifiers.f5090b;
        }
        if ((i & 4) != 0) {
            z = javaDefaultQualifiers.f5091c;
        }
        if ((i & 8) != 0) {
            z2 = javaDefaultQualifiers.f5092d;
        }
        return javaDefaultQualifiers.copy(nullabilityQualifierWithMigrationStatus, collection, z, z2);
    }

    public final JavaDefaultQualifiers copy(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(nullabilityQualifierWithMigrationStatus, collection, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaDefaultQualifiers)) {
            return false;
        }
        JavaDefaultQualifiers javaDefaultQualifiers = (JavaDefaultQualifiers) obj;
        return Intrinsics.areEqual((Object) this.f5089a, (Object) javaDefaultQualifiers.f5089a) && Intrinsics.areEqual((Object) this.f5090b, (Object) javaDefaultQualifiers.f5090b) && this.f5091c == javaDefaultQualifiers.f5091c && this.f5092d == javaDefaultQualifiers.f5092d;
    }

    public int hashCode() {
        int hashCode = ((this.f5089a.hashCode() * 31) + this.f5090b.hashCode()) * 31;
        boolean z = this.f5091c;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.f5092d;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f5089a + ", qualifierApplicabilityTypes=" + this.f5090b + ", affectsTypeParameterBasedTypes=" + this.f5091c + ", affectsStarProjection=" + this.f5092d + VersionRange.RIGHT_OPEN;
    }

    public JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        this.f5089a = nullabilityQualifierWithMigrationStatus;
        this.f5090b = collection;
        this.f5091c = z;
        this.f5092d = z2;
    }

    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.f5089a;
    }

    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.f5090b;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JavaDefaultQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r1, java.util.Collection r2, boolean r3, boolean r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 4
            if (r6 == 0) goto L_0x000f
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = r1.getQualifier()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r3 != r6) goto L_0x000e
            r3 = 1
            goto L_0x000f
        L_0x000e:
            r3 = 0
        L_0x000f:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0014
            r4 = r3
        L_0x0014:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers.<init>(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus, java.util.Collection, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getAffectsTypeParameterBasedTypes() {
        return this.f5091c;
    }

    public final boolean getAffectsStarProjection() {
        return this.f5092d;
    }

    public final boolean getMakesTypeParameterNotNull() {
        return this.f5089a.getQualifier() == NullabilityQualifier.NOT_NULL && this.f5091c;
    }
}
