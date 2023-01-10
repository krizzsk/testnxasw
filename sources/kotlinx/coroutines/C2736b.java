package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0013"}, mo148868d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: kotlinx.coroutines.b */
/* compiled from: Builders.kt */
final class C2736b<T> extends AbstractCoroutine<T> {

    /* renamed from: a */
    private final Thread f6084a;

    /* renamed from: b */
    private final EventLoop f6085b;

    /* access modifiers changed from: protected */
    public boolean isScopedCoroutine() {
        return true;
    }

    public C2736b(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.f6084a = thread;
        this.f6085b = eventLoop;
    }

    /* access modifiers changed from: protected */
    public void afterCompletion(Object obj) {
        if (!Intrinsics.areEqual((Object) Thread.currentThread(), (Object) this.f6084a)) {
            Thread thread = this.f6084a;
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource == null) {
                LockSupport.unpark(thread);
            } else {
                timeSource.unpark(thread);
            }
        }
    }

    /* renamed from: a */
    public final T mo27749a() {
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            EventLoop eventLoop = this.f6085b;
            CompletedExceptionally completedExceptionally = null;
            if (eventLoop != null) {
                EventLoop.incrementUseCount$default(eventLoop, false, 1, (Object) null);
            }
            while (!Thread.interrupted()) {
                EventLoop eventLoop2 = this.f6085b;
                long processNextEvent = eventLoop2 == null ? Long.MAX_VALUE : eventLoop2.processNextEvent();
                if (isCompleted()) {
                    EventLoop eventLoop3 = this.f6085b;
                    if (eventLoop3 != null) {
                        EventLoop.decrementUseCount$default(eventLoop3, false, 1, (Object) null);
                    }
                    AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource2 != null) {
                        timeSource2.unregisterTimeLoopThread();
                    }
                    T unboxState = JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
                    if (unboxState instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) unboxState;
                    }
                    if (completedExceptionally == null) {
                        return unboxState;
                    }
                    throw completedExceptionally.cause;
                }
                AbstractTimeSource timeSource3 = AbstractTimeSourceKt.getTimeSource();
                if (timeSource3 == null) {
                    LockSupport.parkNanos(this, processNextEvent);
                } else {
                    timeSource3.parkNanos(this, processNextEvent);
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } catch (Throwable th) {
            AbstractTimeSource timeSource4 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource4 != null) {
                timeSource4.unregisterTimeLoopThread();
            }
            throw th;
        }
    }
}
