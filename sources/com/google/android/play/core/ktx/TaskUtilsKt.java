package com.google.android.play.core.ktx;

import com.google.android.play.core.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a%\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo148868d2 = {"runTask", "T", "task", "Lcom/google/android/play/core/tasks/Task;", "onCanceled", "Lkotlin/Function0;", "", "(Lcom/google/android/play/core/tasks/Task;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryOffer", "", "E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Z", "tmp.wkwm2e3_release"}, mo148869k = 2, mo148870mv = {1, 1, 16})
/* compiled from: TaskUtils.kt */
public final class TaskUtilsKt {
    public static /* synthetic */ Object runTask$default(Task task, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = TaskUtilsKt$runTask$2.INSTANCE;
        }
        return runTask(task, function0, continuation);
    }

    public static final <E> boolean tryOffer(SendChannel<? super E> sendChannel, E e) {
        Intrinsics.checkParameterIsNotNull(sendChannel, "$this$tryOffer");
        try {
            return sendChannel.offer(e);
        } catch (Exception unused) {
            return false;
        }
    }

    public static final <T> Object runTask(Task<T> task, Function0<Unit> function0, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new C20135xa6fc3b2a(function0, task));
        if (!task.isComplete()) {
            task.addOnSuccessListener(new TaskUtilsKt$runTask$3$2(cancellableContinuation));
            Intrinsics.checkExpressionValueIsNotNull(task.addOnFailureListener(new TaskUtilsKt$runTask$3$3(cancellableContinuation)), "task.addOnFailureListene…ithException(exception) }");
        } else if (task.isSuccessful()) {
            T result = task.getResult();
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m47938constructorimpl(result));
        } else {
            Continuation continuation2 = cancellableContinuation;
            Exception exception = task.getException();
            if (exception == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(exception, "task.exception!!");
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m47938constructorimpl(ResultKt.createFailure(exception)));
        }
        Object result2 = cancellableContinuationImpl.getResult();
        if (result2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result2;
    }
}
