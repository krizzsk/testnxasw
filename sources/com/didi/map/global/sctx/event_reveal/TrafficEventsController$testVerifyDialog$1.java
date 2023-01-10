package com.didi.map.global.sctx.event_reveal;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.TrafficEventsController$testVerifyDialog$1", mo23689f = "TrafficEventsController.kt", mo23690i = {}, mo23691l = {154}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* compiled from: TrafficEventsController.kt */
final class TrafficEventsController$testVerifyDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TrafficEventsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrafficEventsController$testVerifyDialog$1(TrafficEventsController trafficEventsController, Continuation<? super TrafficEventsController$testVerifyDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = trafficEventsController;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrafficEventsController$testVerifyDialog$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrafficEventsController$testVerifyDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(5000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DoublePoint build = new DoublePoint.Builder().dlat(Boxing.boxDouble(-23.1111d)).lat(Boxing.boxFloat(-23.1111f)).dlng(Boxing.boxDouble(-43.2222d)).lng(Boxing.boxFloat(-43.2222f)).build();
        TrafficEventsController trafficEventsController = this.this$0;
        this.this$0.m23427a(true, trafficEventsController.m23410a(trafficEventsController.m23411a(1234, "Traffic test title", "Traffic test Subtitle", build)));
        return Unit.INSTANCE;
    }
}
