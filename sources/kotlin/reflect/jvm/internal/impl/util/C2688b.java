package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* renamed from: kotlin.reflect.jvm.internal.impl.util.b */
/* compiled from: modifierChecks.kt */
final class C2688b implements Check {

    /* renamed from: a */
    public static final C2688b f5902a = new C2688b();

    /* renamed from: b */
    private static final String f5903b = "should not have varargs or parameters with default values";

    private C2688b() {
    }

    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    public String getDescription() {
        return f5903b;
    }

    public boolean check(FunctionDescriptor functionDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "functionDescriptor.valueParameters");
        Iterable<ValueParameterDescriptor> iterable = valueParameters;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (ValueParameterDescriptor valueParameterDescriptor : iterable) {
                Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                if (DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) || valueParameterDescriptor.getVarargElementType() != null) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }
}
