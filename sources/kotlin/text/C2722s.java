package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.text.s */
/* compiled from: StringBuilderJVM.kt */
final class C2722s {

    /* renamed from: a */
    public static final String f5990a;

    /* renamed from: b */
    public static final C2722s f5991b = new C2722s();

    static {
        String property = System.getProperty("line.separator");
        Intrinsics.checkNotNull(property);
        f5990a = property;
    }

    private C2722s() {
    }
}
