package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 */
/* compiled from: TypeDeserializer.kt */
final class C2636x131ab843 extends Lambda implements Function1<ProtoBuf.Type, Integer> {
    public static final C2636x131ab843 INSTANCE = new C2636x131ab843();

    C2636x131ab843() {
        super(1);
    }

    public final Integer invoke(ProtoBuf.Type type) {
        Intrinsics.checkNotNullParameter(type, "it");
        return Integer.valueOf(type.getArgumentCount());
    }
}
