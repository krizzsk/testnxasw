package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
public final class JavaNullabilityAnnotationSettingsKt {

    /* renamed from: a */
    private static final FqName f5094a = new FqName("org.jspecify.nullness");

    /* renamed from: b */
    private static final FqName f5095b = new FqName("org.checkerframework.checker.nullness.compatqual");

    /* renamed from: c */
    private static final NullabilityAnnotationStates<JavaNullabilityAnnotationsStatus> f5096c = new NullabilityAnnotationStatesImpl(MapsKt.mapOf(TuplesKt.m41339to(new FqName("org.jetbrains.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("androidx.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("android.support.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("android.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("com.android.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("org.eclipse.jdt.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("org.checkerframework.checker.nullness.qual"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(f5095b, JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("javax.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("edu.umd.cs.findbugs.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("io.reactivex.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(new FqName("androidx.annotation.RecentlyNullable"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, (KotlinVersion) null, (ReportLevel) null, 4, (DefaultConstructorMarker) null)), TuplesKt.m41339to(new FqName("androidx.annotation.RecentlyNonNull"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, (KotlinVersion) null, (ReportLevel) null, 4, (DefaultConstructorMarker) null)), TuplesKt.m41339to(new FqName("lombok"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.m41339to(f5094a, new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(1, 6), ReportLevel.STRICT)), TuplesKt.m41339to(new FqName("io.reactivex.rxjava3.annotations"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(1, 7), ReportLevel.STRICT))));

    /* renamed from: d */
    private static final JavaNullabilityAnnotationsStatus f5097d = new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, (KotlinVersion) null, (ReportLevel) null, 4, (DefaultConstructorMarker) null);

    public static final FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return f5094a;
    }

    public static /* synthetic */ Jsr305Settings getDefaultJsr305Settings$default(KotlinVersion kotlinVersion, int i, Object obj) {
        if ((i & 1) != 0) {
            kotlinVersion = KotlinVersion.CURRENT;
        }
        return getDefaultJsr305Settings(kotlinVersion);
    }

    public static final Jsr305Settings getDefaultJsr305Settings(KotlinVersion kotlinVersion) {
        ReportLevel reportLevel;
        Intrinsics.checkNotNullParameter(kotlinVersion, "configuredKotlinVersion");
        if (f5097d.getSinceVersion() == null || f5097d.getSinceVersion().compareTo(kotlinVersion) > 0) {
            reportLevel = f5097d.getReportLevelBefore();
        } else {
            reportLevel = f5097d.getReportLevelAfter();
        }
        ReportLevel reportLevel2 = reportLevel;
        return new Jsr305Settings(reportLevel2, getDefaultMigrationJsr305ReportLevelForGivenGlobal(reportLevel2), (Map) null, 4, (DefaultConstructorMarker) null);
    }

    public static final ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(ReportLevel reportLevel) {
        Intrinsics.checkNotNullParameter(reportLevel, "globalReportLevel");
        if (reportLevel == ReportLevel.WARN) {
            return null;
        }
        return reportLevel;
    }

    public static final ReportLevel getDefaultReportLevelForAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "annotationFqName");
        return getReportLevelForAnnotation$default(fqName, NullabilityAnnotationStates.Companion.getEMPTY(), (KotlinVersion) null, 4, (Object) null);
    }

    public static /* synthetic */ ReportLevel getReportLevelForAnnotation$default(FqName fqName, NullabilityAnnotationStates nullabilityAnnotationStates, KotlinVersion kotlinVersion, int i, Object obj) {
        if ((i & 4) != 0) {
            kotlinVersion = KotlinVersion.CURRENT;
        }
        return getReportLevelForAnnotation(fqName, nullabilityAnnotationStates, kotlinVersion);
    }

    public static final ReportLevel getReportLevelForAnnotation(FqName fqName, NullabilityAnnotationStates<? extends ReportLevel> nullabilityAnnotationStates, KotlinVersion kotlinVersion) {
        Intrinsics.checkNotNullParameter(fqName, "annotation");
        Intrinsics.checkNotNullParameter(nullabilityAnnotationStates, "configuredReportLevels");
        Intrinsics.checkNotNullParameter(kotlinVersion, "configuredKotlinVersion");
        ReportLevel reportLevel = (ReportLevel) nullabilityAnnotationStates.get(fqName);
        if (reportLevel != null) {
            return reportLevel;
        }
        JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = f5096c.get(fqName);
        if (javaNullabilityAnnotationsStatus == null) {
            return ReportLevel.IGNORE;
        }
        if (javaNullabilityAnnotationsStatus.getSinceVersion() == null || javaNullabilityAnnotationsStatus.getSinceVersion().compareTo(kotlinVersion) > 0) {
            return javaNullabilityAnnotationsStatus.getReportLevelBefore();
        }
        return javaNullabilityAnnotationsStatus.getReportLevelAfter();
    }
}
