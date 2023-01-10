package kotlin;

import kotlin.jvm.internal.CharCompanionObject;

@Metadata(mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0001H\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, mo148868d2 = {"code", "", "", "getCode$annotations", "(C)V", "getCode", "(C)I", "Char", "kotlin-stdlib"}, mo148869k = 2, mo148870mv = {1, 5, 1})
/* compiled from: CharCode.kt */
public final class CharCodeKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final int m41308a(char c) {
        return c;
    }

    public static /* synthetic */ void getCode$annotations(char c) {
    }

    /* renamed from: a */
    private static final char m41307a(int i) {
        if (i >= m41308a(0) && i <= m41308a((char) CharCompanionObject.MAX_VALUE)) {
            return (char) i;
        }
        throw new IllegalArgumentException("Invalid Char code: " + i);
    }
}
