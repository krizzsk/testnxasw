package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", mo23689f = "Deprecated.kt", mo23690i = {0, 0, 0}, mo23691l = {53}, mo23692m = "elementAtOrNull", mo23693n = {"$this$consume$iv", "index", "count"}, mo23694s = {"L$0", "I$0", "I$1"})
/* compiled from: Deprecated.kt */
final class ChannelsKt__DeprecatedKt$elementAtOrNull$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$elementAtOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$elementAtOrNull$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return C2743e.m5778b((ReceiveChannel) null, 0, (Continuation) this);
    }
}
