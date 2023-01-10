package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "kotlinx.coroutines.flow.CallbackFlowBuilder", mo23689f = "Builders.kt", mo23690i = {0}, mo23691l = {355}, mo23692m = "collectTo", mo23693n = {"scope"}, mo23694s = {"L$0"})
/* compiled from: Builders.kt */
final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ C2837a<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CallbackFlowBuilder$collectTo$1(C2837a<T> aVar, Continuation<? super CallbackFlowBuilder$collectTo$1> continuation) {
        super(continuation);
        this.this$0 = aVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collectTo((ProducerScope) null, this);
    }
}
