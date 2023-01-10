package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1 */
/* compiled from: specialBuiltinMembers.kt */
final class C2494x3e04c33b extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final C2494x3e04c33b INSTANCE = new C2494x3e04c33b();

    C2494x3e04c33b() {
        super(1);
    }

    public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "it");
        return Boolean.valueOf(BuiltinMethodsWithSpecialGenericSignature.INSTANCE.m4764a(callableMemberDescriptor));
    }
}
