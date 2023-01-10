package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

/* compiled from: NullabilityQualifierWithMigrationStatus.kt */
public final class NullabilityQualifierWithMigrationStatus {

    /* renamed from: a */
    private final NullabilityQualifier f5312a;

    /* renamed from: b */
    private final boolean f5313b;

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifier nullabilityQualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = nullabilityQualifierWithMigrationStatus.f5312a;
        }
        if ((i & 2) != 0) {
            z = nullabilityQualifierWithMigrationStatus.f5313b;
        }
        return nullabilityQualifierWithMigrationStatus.copy(nullabilityQualifier, z);
    }

    public final NullabilityQualifierWithMigrationStatus copy(NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) obj;
        return this.f5312a == nullabilityQualifierWithMigrationStatus.f5312a && this.f5313b == nullabilityQualifierWithMigrationStatus.f5313b;
    }

    public int hashCode() {
        int hashCode = this.f5312a.hashCode() * 31;
        boolean z = this.f5313b;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f5312a + ", isForWarningOnly=" + this.f5313b + VersionRange.RIGHT_OPEN;
    }

    public NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "qualifier");
        this.f5312a = nullabilityQualifier;
        this.f5313b = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, (i & 2) != 0 ? false : z);
    }

    public final NullabilityQualifier getQualifier() {
        return this.f5312a;
    }

    public final boolean isForWarningOnly() {
        return this.f5313b;
    }
}
