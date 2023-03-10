package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo148867d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, mo148868d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Collect.kt */
public final class CombineKt$zipImpl$1$1$second$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<T2> {
    final /* synthetic */ ProducerScope $$this$produce$inlined;

    public CombineKt$zipImpl$1$1$second$1$invokeSuspend$$inlined$collect$1(ProducerScope producerScope) {
        this.$$this$produce$inlined = producerScope;
    }

    public Object emit(T2 t2, Continuation<? super Unit> continuation) {
        SendChannel channel = this.$$this$produce$inlined.getChannel();
        if (t2 == null) {
            t2 = NullSurrogateKt.NULL;
        }
        Object send = channel.send(t2, continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }
}
