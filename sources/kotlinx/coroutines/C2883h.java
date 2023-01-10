package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BZ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J&\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J`\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u001a\u0010\u001d\u001a\u00020\u000b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\n\u001a\u00020\u0007J\t\u0010 \u001a\u00020!HÖ\u0001R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0002\n\u0000R-\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo148868d2 = {"Lkotlinx/coroutines/CompletedContinuation;", "", "result", "cancelHandler", "Lkotlinx/coroutines/CancelHandler;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "idempotentResume", "cancelCause", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelled", "", "getCancelled", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "invokeHandlers", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "toString", "", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: kotlinx.coroutines.h */
/* compiled from: CancellableContinuationImpl.kt */
final class C2883h {

    /* renamed from: a */
    public final Object f6214a;

    /* renamed from: b */
    public final CancelHandler f6215b;

    /* renamed from: c */
    public final Function1<Throwable, Unit> f6216c;

    /* renamed from: d */
    public final Object f6217d;

    /* renamed from: e */
    public final Throwable f6218e;

    /* renamed from: a */
    public static /* synthetic */ C2883h m6125a(C2883h hVar, Object obj, CancelHandler cancelHandler, Function1<Throwable, Unit> function1, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = hVar.f6214a;
        }
        if ((i & 2) != 0) {
            cancelHandler = hVar.f6215b;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        if ((i & 4) != 0) {
            function1 = hVar.f6216c;
        }
        Function1<Throwable, Unit> function12 = function1;
        if ((i & 8) != 0) {
            obj2 = hVar.f6217d;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = hVar.f6218e;
        }
        return hVar.mo28109a(obj, cancelHandler2, function12, obj4, th);
    }

    /* renamed from: a */
    public final C2883h mo28109a(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        return new C2883h(obj, cancelHandler, function1, obj2, th);
    }

    /* renamed from: b */
    public final Object mo28112b() {
        return this.f6214a;
    }

    /* renamed from: c */
    public final CancelHandler mo28113c() {
        return this.f6215b;
    }

    /* renamed from: d */
    public final Function1<Throwable, Unit> mo28114d() {
        return this.f6216c;
    }

    /* renamed from: e */
    public final Object mo28115e() {
        return this.f6217d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2883h)) {
            return false;
        }
        C2883h hVar = (C2883h) obj;
        return Intrinsics.areEqual(this.f6214a, hVar.f6214a) && Intrinsics.areEqual((Object) this.f6215b, (Object) hVar.f6215b) && Intrinsics.areEqual((Object) this.f6216c, (Object) hVar.f6216c) && Intrinsics.areEqual(this.f6217d, hVar.f6217d) && Intrinsics.areEqual((Object) this.f6218e, (Object) hVar.f6218e);
    }

    /* renamed from: f */
    public final Throwable mo28117f() {
        return this.f6218e;
    }

    public int hashCode() {
        Object obj = this.f6214a;
        int i = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.f6215b;
        int hashCode2 = (hashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        Function1<Throwable, Unit> function1 = this.f6216c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f6217d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f6218e;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f6214a + ", cancelHandler=" + this.f6215b + ", onCancellation=" + this.f6216c + ", idempotentResume=" + this.f6217d + ", cancelCause=" + this.f6218e + VersionRange.RIGHT_OPEN;
    }

    public C2883h(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.f6214a = obj;
        this.f6215b = cancelHandler;
        this.f6216c = function1;
        this.f6217d = obj2;
        this.f6218e = th;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2883h(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : cancelHandler, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }

    /* renamed from: a */
    public final boolean mo28111a() {
        return this.f6218e != null;
    }

    /* renamed from: a */
    public final void mo28110a(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable th) {
        CancelHandler cancelHandler = this.f6215b;
        if (cancelHandler != null) {
            cancellableContinuationImpl.callCancelHandler(cancelHandler, th);
        }
        Function1<Throwable, Unit> function1 = this.f6216c;
        if (function1 != null) {
            cancellableContinuationImpl.callOnCancellation(function1, th);
        }
    }
}
