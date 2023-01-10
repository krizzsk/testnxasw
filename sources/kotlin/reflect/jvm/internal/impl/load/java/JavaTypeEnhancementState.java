package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaTypeEnhancementState.kt */
public final class JavaTypeEnhancementState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final JavaTypeEnhancementState f5102d = new JavaTypeEnhancementState(JavaNullabilityAnnotationSettingsKt.getDefaultJsr305Settings$default((KotlinVersion) null, 1, (Object) null), JavaTypeEnhancementState$Companion$DEFAULT$1.INSTANCE);

    /* renamed from: a */
    private final Jsr305Settings f5103a;

    /* renamed from: b */
    private final Function1<FqName, ReportLevel> f5104b;

    /* renamed from: c */
    private final boolean f5105c;

    public JavaTypeEnhancementState(Jsr305Settings jsr305Settings, Function1<? super FqName, ? extends ReportLevel> function1) {
        Intrinsics.checkNotNullParameter(jsr305Settings, "jsr305");
        Intrinsics.checkNotNullParameter(function1, "getReportLevelForAnnotation");
        this.f5103a = jsr305Settings;
        this.f5104b = function1;
        this.f5105c = jsr305Settings.isDisabled() || this.f5104b.invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.IGNORE;
    }

    public final Jsr305Settings getJsr305() {
        return this.f5103a;
    }

    public final Function1<FqName, ReportLevel> getGetReportLevelForAnnotation() {
        return this.f5104b;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.f5105c;
    }

    /* compiled from: JavaTypeEnhancementState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JavaTypeEnhancementState getDEFAULT() {
            return JavaTypeEnhancementState.f5102d;
        }
    }
}
