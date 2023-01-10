package com.didi.map.global.flow.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.map.global.flow.widget.TrafficEventFeedbackView$startCountDown$1", mo23689f = "TrafficEventFeedbackView.kt", mo23690i = {0}, mo23691l = {93}, mo23692m = "invokeSuspend", mo23693n = {"$this$launch"}, mo23694s = {"L$0"})
/* compiled from: TrafficEventFeedbackView.kt */
final class TrafficEventFeedbackView$startCountDown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $time;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TrafficEventFeedbackView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrafficEventFeedbackView$startCountDown$1(Ref.IntRef intRef, TrafficEventFeedbackView trafficEventFeedbackView, Continuation<? super TrafficEventFeedbackView$startCountDown$1> continuation) {
        super(2, continuation);
        this.$time = intRef;
        this.this$0 = trafficEventFeedbackView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrafficEventFeedbackView$startCountDown$1 trafficEventFeedbackView$startCountDown$1 = new TrafficEventFeedbackView$startCountDown$1(this.$time, this.this$0, continuation);
        trafficEventFeedbackView$startCountDown$1.L$0 = obj;
        return trafficEventFeedbackView$startCountDown$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrafficEventFeedbackView$startCountDown$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            goto L_0x004a
        L_0x0014:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            r1 = r7
            r7 = r6
        L_0x0025:
            boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r3 == 0) goto L_0x0055
            kotlin.jvm.internal.Ref$IntRef r3 = r7.$time
            int r3 = r3.element
            if (r3 <= 0) goto L_0x0055
            com.didi.map.global.flow.widget.TrafficEventFeedbackView r3 = r7.this$0
            kotlin.jvm.internal.Ref$IntRef r4 = r7.$time
            int r4 = r4.element
            r3.setMessage(r4)
            r3 = 1000(0x3e8, double:4.94E-321)
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.L$0 = r1
            r7.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r3 != r0) goto L_0x004a
            return r0
        L_0x004a:
            kotlin.jvm.internal.Ref$IntRef r3 = r7.$time
            int r3 = r3.element
            kotlin.jvm.internal.Ref$IntRef r4 = r7.$time
            int r3 = r3 + -1
            r4.element = r3
            goto L_0x0025
        L_0x0055:
            boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r0 == 0) goto L_0x006a
            kotlin.jvm.internal.Ref$IntRef r0 = r7.$time
            int r0 = r0.element
            if (r0 != 0) goto L_0x006a
            com.didi.map.global.flow.widget.TrafficEventFeedbackView r7 = r7.this$0
            com.didi.map.global.flow.scene.order.serving.ITrafficEventFeedbackViewCallback r7 = r7.getCallback()
            r7.countDownDismiss()
        L_0x006a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.widget.TrafficEventFeedbackView$startCountDown$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
