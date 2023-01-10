package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(mo148867d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\u001a\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\t8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\t8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003\"\u0016\u0010\u0012\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0003\"\u000e\u0010\u0014\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo148868d2 = {"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "getCOMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "getCOMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "getEMPTY_ACTIVE$annotations", "EMPTY_NEW", "getEMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "getSEALED$annotations", "TOO_LATE_TO_CANCEL", "getTOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: JobSupport.kt */
public final class JobSupportKt {
    public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Symbol f6057a = new Symbol("COMPLETING_ALREADY");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Symbol f6058b = new Symbol("COMPLETING_RETRY");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Symbol f6059c = new Symbol("TOO_LATE_TO_CANCEL");

    /* renamed from: d */
    private static final int f6060d = -1;

    /* renamed from: e */
    private static final int f6061e = 0;

    /* renamed from: f */
    private static final int f6062f = 1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Symbol f6063g = new Symbol("SEALED");
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final C2894m f6064h = new C2894m(false);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final C2894m f6065i = new C2894m(true);

    /* renamed from: a */
    private static /* synthetic */ void m5698a() {
    }

    /* renamed from: b */
    private static /* synthetic */ void m5699b() {
    }

    /* renamed from: c */
    private static /* synthetic */ void m5700c() {
    }

    /* renamed from: d */
    private static /* synthetic */ void m5701d() {
    }

    /* renamed from: e */
    private static /* synthetic */ void m5702e() {
    }

    /* renamed from: f */
    private static /* synthetic */ void m5703f() {
    }

    public static /* synthetic */ void getCOMPLETING_WAITING_CHILDREN$annotations() {
    }

    public static final Object boxIncomplete(Object obj) {
        return obj instanceof Incomplete ? new C2895n((Incomplete) obj) : obj;
    }

    public static final Object unboxState(Object obj) {
        C2895n nVar = obj instanceof C2895n ? (C2895n) obj : null;
        return nVar == null ? obj : nVar.f6276a;
    }
}
