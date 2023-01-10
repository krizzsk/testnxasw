package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1 */
/* compiled from: typeParameterUtils.kt */
final class C2468x246a49e2 extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
    public static final C2468x246a49e2 INSTANCE = new C2468x246a49e2();

    C2468x246a49e2() {
        super(1);
    }

    public final Boolean invoke(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "it");
        return Boolean.valueOf(declarationDescriptor instanceof CallableDescriptor);
    }
}
