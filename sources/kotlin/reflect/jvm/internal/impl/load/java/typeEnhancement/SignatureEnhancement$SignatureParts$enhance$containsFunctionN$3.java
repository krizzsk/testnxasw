package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: signatureEnhancement.kt */
/* synthetic */ class SignatureEnhancement$SignatureParts$enhance$containsFunctionN$3 extends FunctionReference implements Function1<UnwrappedType, Boolean> {
    public static final SignatureEnhancement$SignatureParts$enhance$containsFunctionN$3 INSTANCE = new SignatureEnhancement$SignatureParts$enhance$containsFunctionN$3();

    SignatureEnhancement$SignatureParts$enhance$containsFunctionN$3() {
        super(1);
    }

    public final String getName() {
        return "containsFunctionN";
    }

    public final String getSignature() {
        return "enhance$containsFunctionN(Lorg/jetbrains/kotlin/types/UnwrappedType;)Z";
    }

    public final KDeclarationContainer getOwner() {
        return C2404Reflection.getOrCreateKotlinClass(Intrinsics.Kotlin.class);
    }

    public final Boolean invoke(UnwrappedType unwrappedType) {
        Intrinsics.checkNotNullParameter(unwrappedType, "p0");
        return Boolean.valueOf(SignatureEnhancement.SignatureParts.enhance$containsFunctionN(unwrappedType));
    }
}
