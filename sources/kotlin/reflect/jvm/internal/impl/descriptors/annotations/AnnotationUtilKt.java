package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.didi.soda.blocks.constant.TrackConst;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;

/* compiled from: annotationUtil.kt */
public final class AnnotationUtilKt {

    /* renamed from: a */
    private static final Name f4904a;

    /* renamed from: b */
    private static final Name f4905b;

    /* renamed from: c */
    private static final Name f4906c;

    /* renamed from: d */
    private static final Name f4907d;

    /* renamed from: e */
    private static final Name f4908e;

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3);
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "replaceWith");
        Intrinsics.checkNotNullParameter(str3, "level");
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(kotlinBuiltIns, StandardNames.FqNames.replaceWith, MapsKt.mapOf(TuplesKt.m41339to(f4907d, new StringValue(str2)), TuplesKt.m41339to(f4908e, new ArrayValue(CollectionsKt.emptyList(), new C2472xf14e0c1a(kotlinBuiltIns)))));
        FqName fqName = StandardNames.FqNames.deprecated;
        Name name = f4906c;
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.deprecationLevel);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.deprecationLevel)");
        Name identifier = Name.identifier(str3);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(level)");
        return new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt.mapOf(TuplesKt.m41339to(f4904a, new StringValue(str)), TuplesKt.m41339to(f4905b, new AnnotationValue(builtInAnnotationDescriptor)), TuplesKt.m41339to(name, new EnumValue(classId, identifier))));
    }

    static {
        Name identifier = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"message\")");
        f4904a = identifier;
        Name identifier2 = Name.identifier("replaceWith");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"replaceWith\")");
        f4905b = identifier2;
        Name identifier3 = Name.identifier("level");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"level\")");
        f4906c = identifier3;
        Name identifier4 = Name.identifier(TrackConst.Params.EXPRESSION);
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(\"expression\")");
        f4907d = identifier4;
        Name identifier5 = Name.identifier("imports");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(\"imports\")");
        f4908e = identifier5;
    }
}
