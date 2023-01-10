package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

@Metadata(mo148867d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\b\u0010\b\u001a\u00020\tH\u0002\u001a\u000e\u0010\n\u001a\u00020\u0003*\u0004\u0018\u00010\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"MAGIC", "", "MARKED_NULL", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_TRUE", "MIN_CAPACITY", "REHASH", "Lkotlinx/coroutines/internal/Symbol;", "noImpl", "", "mark", "", "kotlinx-coroutines-core"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ConcurrentWeakMap.kt */
public final class ConcurrentWeakMapKt {

    /* renamed from: a */
    private static final int f6118a = -1640531527;

    /* renamed from: b */
    private static final int f6119b = 16;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Symbol f6120c = new Symbol("REHASH");

    /* renamed from: d */
    private static final C2749a f6121d = new C2749a((Object) null);

    /* renamed from: e */
    private static final C2749a f6122e = new C2749a(true);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final C2749a m5831a(Object obj) {
        if (obj == null) {
            return f6121d;
        }
        if (Intrinsics.areEqual(obj, (Object) true)) {
            return f6122e;
        }
        return new C2749a(obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final Void m5830a() {
        throw new UnsupportedOperationException("not implemented");
    }
}
