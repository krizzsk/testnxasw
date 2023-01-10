package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: util.kt */
public final class ValueParameterData {

    /* renamed from: a */
    private final KotlinType f5170a;

    /* renamed from: b */
    private final boolean f5171b;

    public ValueParameterData(KotlinType kotlinType, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.f5170a = kotlinType;
        this.f5171b = z;
    }

    public final boolean getHasDefaultValue() {
        return this.f5171b;
    }

    public final KotlinType getType() {
        return this.f5170a;
    }
}
