package com.didi.map.global.sctx.event_verify;

import com.didi.map.global.sctx.event_reveal.Result;
import com.didi.map.sdk.proto.driver_gl.event.EventFeedbackReq;
import com.didi.map.sdk.proto.driver_gl.event.EventFeedbackRes;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;

@Metadata(mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, mo148868d2 = {"<anonymous>", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventFeedbackRes;", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_verify.TrafficEventVerifyDataSource$postVerifyData$2", mo23689f = "TrafficEventVerifyDataSource.kt", mo23690i = {}, mo23691l = {18}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* compiled from: TrafficEventVerifyDataSource.kt */
final class TrafficEventVerifyDataSource$postVerifyData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends EventFeedbackRes>>, Object> {
    final /* synthetic */ EventFeedbackReq $req;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ TrafficEventVerifyDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrafficEventVerifyDataSource$postVerifyData$2(TrafficEventVerifyDataSource trafficEventVerifyDataSource, String str, EventFeedbackReq eventFeedbackReq, Continuation<? super TrafficEventVerifyDataSource$postVerifyData$2> continuation) {
        super(2, continuation);
        this.this$0 = trafficEventVerifyDataSource;
        this.$url = str;
        this.$req = eventFeedbackReq;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrafficEventVerifyDataSource$postVerifyData$2(this.this$0, this.$url, this.$req, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<EventFeedbackRes>> continuation) {
        return ((TrafficEventVerifyDataSource$postVerifyData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, mo148868d2 = {"<anonymous>", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventFeedbackRes;", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    @DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_verify.TrafficEventVerifyDataSource$postVerifyData$2$1", mo23689f = "TrafficEventVerifyDataSource.kt", mo23690i = {}, mo23691l = {}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
    /* renamed from: com.didi.map.global.sctx.event_verify.TrafficEventVerifyDataSource$postVerifyData$2$1 */
    /* compiled from: TrafficEventVerifyDataSource.kt */
    static final class C106381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends EventFeedbackRes>>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C106381 r0 = new C106381(trafficEventVerifyDataSource, str, eventFeedbackReq, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<EventFeedbackRes>> continuation) {
            return ((C106381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return CoroutineScopeKt.isActive((CoroutineScope) this.L$0) ? trafficEventVerifyDataSource.m23438a(str, eventFeedbackReq) : new Result.Error(new CancellationException("event/feedback/ request timeout"));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final TrafficEventVerifyDataSource trafficEventVerifyDataSource = this.this$0;
            final String str = this.$url;
            final EventFeedbackReq eventFeedbackReq = this.$req;
            this.label = 1;
            obj = TimeoutKt.withTimeout(10000, new C106381((Continuation<? super C106381>) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
