package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", mo23689f = "Emitters.kt", mo23690i = {0}, mo23691l = {216}, mo23692m = "invokeSafely$FlowKt__EmittersKt", mo23693n = {"cause"}, mo23694s = {"L$0"})
/* compiled from: Emitters.kt */
final class FlowKt__EmittersKt$invokeSafely$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    FlowKt__EmittersKt$invokeSafely$1(Continuation<? super FlowKt__EmittersKt$invokeSafely$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return C2869n.m5996b((FlowCollector) null, (Function3) null, (Throwable) null, this);
    }
}
