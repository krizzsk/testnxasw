package com.didi.map.global.sctx.event_reveal;

import com.didi.map.global.sctx.event_reveal.Result;
import com.didi.map.sdk.proto.driver_gl.event.EventShowReq;
import com.didi.map.sdk.proto.driver_gl.event.EventShowRes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.TrafficEventsController$startFetchEventData$1", mo23689f = "TrafficEventsController.kt", mo23690i = {0}, mo23691l = {298}, mo23692m = "invokeSuspend", mo23693n = {"$this$launch"}, mo23694s = {"L$0"})
/* compiled from: TrafficEventsController.kt */
final class TrafficEventsController$startFetchEventData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TrafficEventsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrafficEventsController$startFetchEventData$1(TrafficEventsController trafficEventsController, Continuation<? super TrafficEventsController$startFetchEventData$1> continuation) {
        super(2, continuation);
        this.this$0 = trafficEventsController;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrafficEventsController$startFetchEventData$1 trafficEventsController$startFetchEventData$1 = new TrafficEventsController$startFetchEventData$1(this.this$0, continuation);
        trafficEventsController$startFetchEventData$1.L$0 = obj;
        return trafficEventsController$startFetchEventData$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrafficEventsController$startFetchEventData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else if (i == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (CoroutineScopeKt.isActive(coroutineScope)) {
            final TrafficEventsController trafficEventsController = this.this$0;
            Job unused = C2746d.m5821a(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C106321((Continuation<? super C106321>) null), 3, (Object) null);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(this.this$0.f30063r * ((long) 1000), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    @DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.TrafficEventsController$startFetchEventData$1$1", mo23689f = "TrafficEventsController.kt", mo23690i = {}, mo23691l = {283}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
    /* renamed from: com.didi.map.global.sctx.event_reveal.TrafficEventsController$startFetchEventData$1$1 */
    /* compiled from: TrafficEventsController.kt */
    static final class C106321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C106321 r0 = new C106321(trafficEventsController, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C106321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ITrafficEventsReqParamGetter access$getParamGetter$p = trafficEventsController.f30050e;
                String str = null;
                EventShowReq requestBody = access$getParamGetter$p == null ? null : access$getParamGetter$p.getRequestBody();
                if (requestBody == null) {
                    return Unit.INSTANCE;
                }
                ITrafficEventsReqParamGetter access$getParamGetter$p2 = trafficEventsController.f30050e;
                if (access$getParamGetter$p2 != null) {
                    str = access$getParamGetter$p2.getEventsUrl();
                }
                if (str == null) {
                    return Unit.INSTANCE;
                }
                Long l = requestBody.curRouteId;
                if ((l == null ? 0 : l.longValue()) == 0) {
                    return Unit.INSTANCE;
                }
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object fetchTrafficEventData = trafficEventsController.f30048c.fetchTrafficEventData(str, requestBody, this);
                if (fetchTrafficEventData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                obj = fetchTrafficEventData;
            } else if (i == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    trafficEventsController.m23423a(e);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result result = (Result) obj;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                if (result instanceof Result.Success) {
                    trafficEventsController.m23421a((EventShowRes) ((Result.Success) result).getData());
                } else if (result instanceof Result.Error) {
                    trafficEventsController.m23423a(((Result.Error) result).getException());
                }
            }
            return Unit.INSTANCE;
        }
    }
}
