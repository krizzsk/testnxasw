package androidx.window.java.layout;

import androidx.core.util.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, mo148868d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1", mo23689f = "WindowInfoTrackerCallbackAdapter.kt", mo23690i = {}, mo23691l = {96}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* compiled from: WindowInfoTrackerCallbackAdapter.kt */
final class WindowInfoTrackerCallbackAdapter$addListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Consumer<T> $consumer;
    final /* synthetic */ Flow<T> $flow;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowInfoTrackerCallbackAdapter$addListener$1$1(Flow<? extends T> flow, Consumer<T> consumer, Continuation<? super WindowInfoTrackerCallbackAdapter$addListener$1$1> continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.$consumer = consumer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WindowInfoTrackerCallbackAdapter$addListener$1$1(this.$flow, this.$consumer, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowInfoTrackerCallbackAdapter$addListener$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$flow.collect(new C0854x3e71c403(this.$consumer), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
