package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "kotlinx.coroutines.channels.TickerChannelsKt", mo23689f = "TickerChannels.kt", mo23690i = {0, 0, 1, 1, 2, 2}, mo23691l = {106, 108, 109}, mo23692m = "fixedDelayTicker", mo23693n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, mo23694s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
/* compiled from: TickerChannels.kt */
final class TickerChannelsKt$fixedDelayTicker$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    TickerChannelsKt$fixedDelayTicker$1(Continuation<? super TickerChannelsKt$fixedDelayTicker$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TickerChannelsKt.m5743b(0, 0, (SendChannel<? super Unit>) null, this);
    }
}
