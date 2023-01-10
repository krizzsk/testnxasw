package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaTypeEnhancementState.kt */
/* synthetic */ class JavaTypeEnhancementState$Companion$DEFAULT$1 extends FunctionReference implements Function1<FqName, ReportLevel> {
    public static final JavaTypeEnhancementState$Companion$DEFAULT$1 INSTANCE = new JavaTypeEnhancementState$Companion$DEFAULT$1();

    JavaTypeEnhancementState$Companion$DEFAULT$1() {
        super(1);
    }

    public final String getName() {
        return "getDefaultReportLevelForAnnotation";
    }

    public final String getSignature() {
        return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
    }

    public final KDeclarationContainer getOwner() {
        return C2404Reflection.getOrCreateKotlinPackage(JavaNullabilityAnnotationSettingsKt.class, "descriptors.jvm");
    }

    public final ReportLevel invoke(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "p0");
        return JavaNullabilityAnnotationSettingsKt.getDefaultReportLevelForAnnotation(fqName);
    }
}
