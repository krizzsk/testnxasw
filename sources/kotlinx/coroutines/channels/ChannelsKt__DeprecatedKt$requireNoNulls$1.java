package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(mo148867d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H@"}, mo148868d2 = {"<anonymous>", "E", "", "it"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", mo23689f = "Deprecated.kt", mo23690i = {}, mo23691l = {}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* compiled from: Deprecated.kt */
final class ChannelsKt__DeprecatedKt$requireNoNulls$1 extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_requireNoNulls;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$requireNoNulls$1(ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$requireNoNulls$1> continuation) {
        super(2, continuation);
        this.$this_requireNoNulls = receiveChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$requireNoNulls$1 channelsKt__DeprecatedKt$requireNoNulls$1 = new ChannelsKt__DeprecatedKt$requireNoNulls$1(this.$this_requireNoNulls, continuation);
        channelsKt__DeprecatedKt$requireNoNulls$1.L$0 = obj;
        return channelsKt__DeprecatedKt$requireNoNulls$1;
    }

    public final Object invoke(E e, Continuation<? super E> continuation) {
        return ((ChannelsKt__DeprecatedKt$requireNoNulls$1) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
