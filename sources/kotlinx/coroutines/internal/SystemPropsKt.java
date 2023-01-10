package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, mo148869k = 4, mo148870mv = {1, 5, 1}, mo148872xi = 48)
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return C2888c.m6180a();
    }

    public static final int systemProp(String str, int i, int i2, int i3) {
        return C2889d.m6182a(str, i, i2, i3);
    }

    public static final long systemProp(String str, long j, long j2, long j3) {
        return C2889d.m6184a(str, j, j2, j3);
    }

    public static final String systemProp(String str) {
        return C2888c.m6181a(str);
    }

    public static final boolean systemProp(String str, boolean z) {
        return C2889d.m6186a(str, z);
    }
}
