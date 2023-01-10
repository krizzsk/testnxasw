package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 */
/* compiled from: specialBuiltinMembers.kt */
final class C2495xdb572182 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final C2495xdb572182 INSTANCE = new C2495xdb572182();

    C2495xdb572182() {
        super(1);
    }

    public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "it");
        return Boolean.valueOf((callableMemberDescriptor instanceof FunctionDescriptor) && BuiltinMethodsWithSpecialGenericSignature.INSTANCE.m4764a(callableMemberDescriptor));
    }
}
