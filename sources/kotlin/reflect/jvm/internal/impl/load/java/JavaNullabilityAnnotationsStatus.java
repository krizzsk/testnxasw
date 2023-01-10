package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

/* compiled from: JavaNullabilityAnnotationsStatus.kt */
public final class JavaNullabilityAnnotationsStatus {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final JavaNullabilityAnnotationsStatus f5098d = new JavaNullabilityAnnotationsStatus(ReportLevel.STRICT, (KotlinVersion) null, (ReportLevel) null, 6, (DefaultConstructorMarker) null);

    /* renamed from: a */
    private final ReportLevel f5099a;

    /* renamed from: b */
    private final KotlinVersion f5100b;

    /* renamed from: c */
    private final ReportLevel f5101c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaNullabilityAnnotationsStatus)) {
            return false;
        }
        JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = (JavaNullabilityAnnotationsStatus) obj;
        return this.f5099a == javaNullabilityAnnotationsStatus.f5099a && Intrinsics.areEqual((Object) this.f5100b, (Object) javaNullabilityAnnotationsStatus.f5100b) && this.f5101c == javaNullabilityAnnotationsStatus.f5101c;
    }

    public int hashCode() {
        int hashCode = this.f5099a.hashCode() * 31;
        KotlinVersion kotlinVersion = this.f5100b;
        return ((hashCode + (kotlinVersion == null ? 0 : kotlinVersion.hashCode())) * 31) + this.f5101c.hashCode();
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f5099a + ", sinceVersion=" + this.f5100b + ", reportLevelAfter=" + this.f5101c + VersionRange.RIGHT_OPEN;
    }

    public JavaNullabilityAnnotationsStatus(ReportLevel reportLevel, KotlinVersion kotlinVersion, ReportLevel reportLevel2) {
        Intrinsics.checkNotNullParameter(reportLevel, "reportLevelBefore");
        Intrinsics.checkNotNullParameter(reportLevel2, "reportLevelAfter");
        this.f5099a = reportLevel;
        this.f5100b = kotlinVersion;
        this.f5101c = reportLevel2;
    }

    public final ReportLevel getReportLevelBefore() {
        return this.f5099a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaNullabilityAnnotationsStatus(ReportLevel reportLevel, KotlinVersion kotlinVersion, ReportLevel reportLevel2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, (i & 2) != 0 ? new KotlinVersion(1, 0) : kotlinVersion, (i & 4) != 0 ? reportLevel : reportLevel2);
    }

    public final KotlinVersion getSinceVersion() {
        return this.f5100b;
    }

    public final ReportLevel getReportLevelAfter() {
        return this.f5101c;
    }

    /* compiled from: JavaNullabilityAnnotationsStatus.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JavaNullabilityAnnotationsStatus getDEFAULT() {
            return JavaNullabilityAnnotationsStatus.f5098d;
        }
    }
}
