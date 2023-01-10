package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

@Metadata(mo148867d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, mo148869k = 4, mo148870mv = {1, 5, 1}, mo148872xi = 48)
public final class JobKt {
    public static final DisposableHandle DisposableHandle(Function0<Unit> function0) {
        return C2900s.m6199a(function0);
    }

    public static final CompletableJob Job(Job job) {
        return C2900s.m6197a(job);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        C2900s.m6201a(coroutineContext, cancellationException);
    }

    public static final void cancel(Job job, String str, Throwable th) {
        C2900s.m6203a(job, str, th);
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        return C2900s.m6195a(job, continuation);
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        C2900s.m6217b(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(Job job, CancellationException cancellationException) {
        C2900s.m6207a(job, cancellationException);
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        C2899r.m6194a(cancellableContinuation, future);
    }

    public static final DisposableHandle cancelFutureOnCompletion(Job job, Future<?> future) {
        return C2899r.m6193a(job, future);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return C2900s.m6200a(job, disposableHandle);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        C2900s.m6219c(coroutineContext);
    }

    public static final void ensureActive(Job job) {
        C2900s.m6222d(job);
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        return C2900s.m6223e(coroutineContext);
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        return C2900s.m6209a(coroutineContext);
    }
}
