package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", mo23689f = "Channels.common.kt", mo23690i = {0, 0}, mo23691l = {129}, mo23692m = "consumeEach", mo23693n = {"action", "channel$iv"}, mo23694s = {"L$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$consumeEach$3<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__Channels_commonKt$consumeEach$3(Continuation<? super ChannelsKt__Channels_commonKt$consumeEach$3> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return C2742d.m5749a((BroadcastChannel) null, (Function1) null, (Continuation<? super Unit>) this);
    }
}
