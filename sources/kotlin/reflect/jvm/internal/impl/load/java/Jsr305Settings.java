package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.osgi.framework.VersionRange;

/* compiled from: Jsr305Settings.kt */
public final class Jsr305Settings {

    /* renamed from: a */
    private final ReportLevel f5107a;

    /* renamed from: b */
    private final ReportLevel f5108b;

    /* renamed from: c */
    private final Map<FqName, ReportLevel> f5109c;

    /* renamed from: d */
    private final Lazy f5110d;

    /* renamed from: e */
    private final boolean f5111e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Jsr305Settings)) {
            return false;
        }
        Jsr305Settings jsr305Settings = (Jsr305Settings) obj;
        return this.f5107a == jsr305Settings.f5107a && this.f5108b == jsr305Settings.f5108b && Intrinsics.areEqual((Object) this.f5109c, (Object) jsr305Settings.f5109c);
    }

    public int hashCode() {
        int hashCode = this.f5107a.hashCode() * 31;
        ReportLevel reportLevel = this.f5108b;
        return ((hashCode + (reportLevel == null ? 0 : reportLevel.hashCode())) * 31) + this.f5109c.hashCode();
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f5107a + ", migrationLevel=" + this.f5108b + ", userDefinedLevelForSpecificAnnotation=" + this.f5109c + VersionRange.RIGHT_OPEN;
    }

    public Jsr305Settings(ReportLevel reportLevel, ReportLevel reportLevel2, Map<FqName, ? extends ReportLevel> map) {
        Intrinsics.checkNotNullParameter(reportLevel, "globalLevel");
        Intrinsics.checkNotNullParameter(map, "userDefinedLevelForSpecificAnnotation");
        this.f5107a = reportLevel;
        this.f5108b = reportLevel2;
        this.f5109c = map;
        this.f5110d = LazyKt.lazy(new Jsr305Settings$description$2(this));
        this.f5111e = this.f5107a == ReportLevel.IGNORE && this.f5108b == ReportLevel.IGNORE && this.f5109c.isEmpty();
    }

    public final ReportLevel getGlobalLevel() {
        return this.f5107a;
    }

    public final ReportLevel getMigrationLevel() {
        return this.f5108b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Jsr305Settings(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, (i & 2) != 0 ? null : reportLevel2, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<FqName, ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.f5109c;
    }

    public final boolean isDisabled() {
        return this.f5111e;
    }
}
