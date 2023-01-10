package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "kotlinx.coroutines.sync.MutexKt", mo23689f = "Mutex.kt", mo23690i = {0, 0, 0}, mo23691l = {113}, mo23692m = "withLock", mo23693n = {"$this$withLock", "owner", "action"}, mo23694s = {"L$0", "L$1", "L$2"})
/* compiled from: Mutex.kt */
final class MutexKt$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    MutexKt$withLock$1(Continuation<? super MutexKt$withLock$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MutexKt.withLock((Mutex) null, (Object) null, (Function0) null, this);
    }
}
