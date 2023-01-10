package com.didi.map.global.sctx.event_reveal;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.sctx.event_reveal.Result;
import com.didi.map.sdk.proto.driver_gl.event.EventShowRes;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;

@Metadata(mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H@"}, mo148868d2 = {"<anonymous>", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowRes;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.MockTrafficEventsDataSource$getData$2", mo23689f = "MockTrafficEventsDataSource.kt", mo23690i = {}, mo23691l = {28}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* compiled from: MockTrafficEventsDataSource.kt */
final class MockTrafficEventsDataSource$getData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends EventShowRes>>, Object> {
    int label;
    final /* synthetic */ MockTrafficEventsDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MockTrafficEventsDataSource$getData$2(MockTrafficEventsDataSource mockTrafficEventsDataSource, Continuation<? super MockTrafficEventsDataSource$getData$2> continuation) {
        super(2, continuation);
        this.this$0 = mockTrafficEventsDataSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MockTrafficEventsDataSource$getData$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<EventShowRes>> continuation) {
        return ((MockTrafficEventsDataSource$getData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H@"}, mo148868d2 = {"<anonymous>", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowRes;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    @DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.MockTrafficEventsDataSource$getData$2$1", mo23689f = "MockTrafficEventsDataSource.kt", mo23690i = {}, mo23691l = {}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
    /* renamed from: com.didi.map.global.sctx.event_reveal.MockTrafficEventsDataSource$getData$2$1 */
    /* compiled from: MockTrafficEventsDataSource.kt */
    static final class C106291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends EventShowRes>>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C106291 r0 = new C106291(mockTrafficEventsDataSource, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<EventShowRes>> continuation) {
            return ((C106291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            List<LatLng> routePoints;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                IMockTrafficEventGetter routesGetter = mockTrafficEventsDataSource.getRoutesGetter();
                Boolean bool = null;
                int i = 1;
                if (!(routesGetter == null || (routePoints = routesGetter.getRoutePoints()) == null)) {
                    bool = Boxing.boxBoolean(!routePoints.isEmpty());
                }
                if (!Intrinsics.areEqual((Object) bool, (Object) Boxing.boxBoolean(true))) {
                    SystemUtils.log(3, "TrafficReveal", "MOCK route line is Empty", (Throwable) null, "com.didi.map.global.sctx.event_reveal.MockTrafficEventsDataSource$getData$2$1", 33);
                    return new Result.Error(new IllegalStateException("MOCK route line is Empty"));
                }
                List arrayList = new ArrayList();
                while (true) {
                    int i2 = i + 1;
                    MockTrafficEventsDataSource mockTrafficEventsDataSource = mockTrafficEventsDataSource;
                    arrayList.add(mockTrafficEventsDataSource.m23409a((long) i, Intrinsics.stringPlus("title ", Boxing.boxInt(i)), Intrinsics.stringPlus("Sub Title ", Boxing.boxInt(i)), mockTrafficEventsDataSource.m23408a(mockTrafficEventsDataSource.getRoutesGetter(), ((float) i2) / ((float) 3))));
                    if (i2 > 3) {
                        break;
                    }
                    i = i2;
                }
                EventShowRes build = new EventShowRes.Builder().msg("mock success").ret(Boxing.boxInt(0)).events(arrayList).build();
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return new Result.Success(build);
                }
                return new Result.Error(new CancellationException("超时"));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long timeout = this.this$0.getTimeout();
            final MockTrafficEventsDataSource mockTrafficEventsDataSource = this.this$0;
            this.label = 1;
            obj = TimeoutKt.withTimeout(timeout, new C106291((Continuation<? super C106291>) null), this);
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
