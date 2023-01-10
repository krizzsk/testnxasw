package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0013B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f0\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo148868d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "<init>", "()V", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "allocateLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlin/coroutines/Continuation;", "freeLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: kotlinx.coroutines.flow.af */
/* compiled from: StateFlow.kt */
final class C2843af extends AbstractSharedFlowSlot<C2842ae<?>> {

    /* renamed from: a */
    static final /* synthetic */ AtomicReferenceFieldUpdater f6172a = AtomicReferenceFieldUpdater.newUpdater(C2843af.class, Object.class, "_state");
    volatile /* synthetic */ Object _state = null;

    /* renamed from: a */
    public boolean allocateLocked(C2842ae<?> aeVar) {
        if (this._state != null) {
            return false;
        }
        this._state = StateFlowKt.f6159a;
        return true;
    }

    /* renamed from: b */
    public Continuation<Unit>[] freeLocked(C2842ae<?> aeVar) {
        this._state = null;
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    /* renamed from: b */
    public final boolean mo28068b() {
        Object andSet = f6172a.getAndSet(this, StateFlowKt.f6159a);
        Intrinsics.checkNotNull(andSet);
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(andSet instanceof CancellableContinuationImpl))) {
            throw new AssertionError();
        } else if (andSet == StateFlowKt.f6160b) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public final void mo28065a() {
        while (true) {
            Object obj = this._state;
            if (obj != null && obj != StateFlowKt.f6160b) {
                if (obj == StateFlowKt.f6159a) {
                    if (f6172a.compareAndSet(this, obj, StateFlowKt.f6160b)) {
                        return;
                    }
                } else if (f6172a.compareAndSet(this, obj, StateFlowKt.f6159a)) {
                    Unit unit = Unit.INSTANCE;
                    Result.Companion companion = Result.Companion;
                    ((CancellableContinuationImpl) obj).resumeWith(Result.m47938constructorimpl(unit));
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final Object mo28064a(Continuation<? super Unit> continuation) {
        boolean z = true;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        if (!DebugKt.getASSERTIONS_ENABLED() || (!(this._state instanceof CancellableContinuationImpl))) {
            if (!f6172a.compareAndSet(this, StateFlowKt.f6159a, cancellableContinuation)) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (this._state != StateFlowKt.f6160b) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m47938constructorimpl(unit));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
        throw new AssertionError();
    }
}
