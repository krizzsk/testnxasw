package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.didi.map.constant.StringConstant;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedEnhancementInfoKt {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final JavaTypeQualifiers f5314a = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, (MutabilityQualifier) null, false, false, 8, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final JavaTypeQualifiers f5315b = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, (MutabilityQualifier) null, false, false, 8, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final JavaTypeQualifiers f5316c = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, (MutabilityQualifier) null, true, false, 8, (DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final Map<String, PredefinedFunctionEnhancementInfo> f5317d;

    static {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents.javaLang("Object");
        String javaFunction = signatureBuildingComponents.javaFunction("Predicate");
        String javaFunction2 = signatureBuildingComponents.javaFunction("Function");
        String javaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        String javaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        String javaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        String javaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        String javaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        String javaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator")).function("forEachRemaining", new C2508xb250426d(javaFunction3));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("Iterable")).function("spliterator", new C2514xb250462e(signatureBuildingComponents));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Collection"));
        classEnhancementBuilder.function("removeIf", new C2515xb25049ef(javaFunction));
        classEnhancementBuilder.function("stream", new C2516xb25049f0(javaUtil));
        classEnhancementBuilder.function("parallelStream", new C2517xb25049f1(javaUtil));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("List")).function("replaceAll", new C2518xb2504db0(javaFunction6));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil(StringConstant.META_NAME));
        classEnhancementBuilder2.function("forEach", new C2519xb2505171(javaFunction5));
        classEnhancementBuilder2.function("putIfAbsent", new C2520xb2505172(javaLang));
        classEnhancementBuilder2.function("replace", new C2521xb2505173(javaLang));
        classEnhancementBuilder2.function("replace", new C2522xb2505174(javaLang));
        classEnhancementBuilder2.function("replaceAll", new C2523xb2505175(javaFunction4));
        classEnhancementBuilder2.function("compute", new C2524xb2505176(javaLang, javaFunction4));
        classEnhancementBuilder2.function("computeIfAbsent", new C2525xb2505177(javaLang, javaFunction2));
        classEnhancementBuilder2.function("computeIfPresent", new C2526xb2505178(javaLang, javaFunction4));
        classEnhancementBuilder2.function("merge", new C2527xb2505179(javaLang, javaFunction4));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaUtil2);
        classEnhancementBuilder3.function("empty", new C2528xb2505532(javaUtil2));
        classEnhancementBuilder3.function("of", new C2529xb2505533(javaLang, javaUtil2));
        classEnhancementBuilder3.function("ofNullable", new C2530xb2505534(javaLang, javaUtil2));
        classEnhancementBuilder3.function("get", new C2531xb2505535(javaLang));
        classEnhancementBuilder3.function("ifPresent", new C2532xb2505536(javaFunction3));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("ref/Reference")).function("get", new C2533xb25058f3(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction).function("test", new C2534xb2505cb4(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("BiPredicate")).function("test", new C2535xb2506075(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction3).function("accept", new C2509x97b836dd(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction5).function("accept", new C2510x97b83a9e(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction2).function(PrepaidConstant.SCENE_APPLY, new C2511x97b83e5f(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction4).function(PrepaidConstant.SCENE_APPLY, new C2512x97b84220(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("Supplier")).function("get", new C2513x97b845e1(javaLang));
        f5317d = signatureEnhancementBuilder.mo25232a();
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return f5317d;
    }
}
