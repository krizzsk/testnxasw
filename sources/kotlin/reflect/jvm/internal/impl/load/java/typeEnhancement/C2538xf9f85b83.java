package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1 */
/* compiled from: signatureEnhancement.kt */
final class C2538xf9f85b83 extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {

    /* renamed from: $p */
    final /* synthetic */ ValueParameterDescriptor f5323$p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2538xf9f85b83(ValueParameterDescriptor valueParameterDescriptor) {
        super(1);
        this.f5323$p = valueParameterDescriptor;
    }

    public final KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "it");
        KotlinType type = callableMemberDescriptor.getValueParameters().get(this.f5323$p.getIndex()).getType();
        Intrinsics.checkNotNullExpressionValue(type, "it.valueParameters[p.index].type");
        return type;
    }
}
