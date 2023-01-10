package com.didi.map.global.sctx.event_reveal;

import com.didi.common.map.util.DLog;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.map.global.sctx.event_reveal.Result;
import com.didi.map.global.sctx.event_verify.TrafficEventVerifyRepository;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.event.EventFeedbackReq;
import com.taxis99.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.TrafficEventsController$doVerify$1", mo23689f = "TrafficEventsController.kt", mo23690i = {}, mo23691l = {}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* compiled from: TrafficEventsController.kt */
final class TrafficEventsController$doVerify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $cardType;
    final /* synthetic */ int $code;
    final /* synthetic */ TrafficEventModel $event;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TrafficEventsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrafficEventsController$doVerify$1(TrafficEventsController trafficEventsController, TrafficEventModel trafficEventModel, int i, int i2, Continuation<? super TrafficEventsController$doVerify$1> continuation) {
        super(2, continuation);
        this.this$0 = trafficEventsController;
        this.$event = trafficEventModel;
        this.$code = i;
        this.$cardType = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrafficEventsController$doVerify$1 trafficEventsController$doVerify$1 = new TrafficEventsController$doVerify$1(this.this$0, this.$event, this.$code, this.$cardType, continuation);
        trafficEventsController$doVerify$1.L$0 = obj;
        return trafficEventsController$doVerify$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrafficEventsController$doVerify$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    @DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.TrafficEventsController$doVerify$1$1", mo23689f = "TrafficEventsController.kt", mo23690i = {}, mo23691l = {531}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
    /* renamed from: com.didi.map.global.sctx.event_reveal.TrafficEventsController$doVerify$1$1 */
    /* compiled from: TrafficEventsController.kt */
    static final class C106311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C106311 r0 = new C106311(trafficEventsController2, trafficEventModel, i, i2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C106311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Boolean bool;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                String uid = PaxEnvironment.getInstance().getUid();
                Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
                Long longOrNull = StringsKt.toLongOrNull(uid);
                long longValue = longOrNull == null ? 0 : longOrNull.longValue();
                ITrafficEventsReqParamGetter access$getParamGetter$p = trafficEventsController2.f30050e;
                Long l = null;
                String verifyUrl = access$getParamGetter$p == null ? null : access$getParamGetter$p.getVerifyUrl();
                if (verifyUrl == null) {
                    bool = null;
                } else {
                    bool = Boxing.boxBoolean(verifyUrl.length() > 0);
                }
                if (!Intrinsics.areEqual((Object) bool, (Object) Boxing.boxBoolean(true))) {
                    return Unit.INSTANCE;
                }
                String access$getTAG$p = trafficEventsController2.f30052g;
                StringBuilder sb = new StringBuilder();
                sb.append("do verify|eventId:");
                TrafficEventModel trafficEventModel = trafficEventModel;
                if (trafficEventModel != null) {
                    l = Boxing.boxLong(trafficEventModel.getEventId());
                }
                sb.append(l);
                sb.append("|code:");
                sb.append(i);
                sb.append("|cardType:");
                sb.append(i2);
                DLog.m10773d(access$getTAG$p, sb.toString(), new Object[0]);
                EventFeedbackReq.Builder lang = new EventFeedbackReq.Builder().eventId(Boxing.boxLong(trafficEventModel.getEventId())).source(Boxing.boxInt(1)).timestamp(Boxing.boxLong(System.currentTimeMillis() / ((long) 1000))).feedbackPoint(trafficEventModel.getEventPoint()).userId(Boxing.boxLong(longValue)).feedCode(Boxing.boxInt(i)).didiVersion(PaxEnvironment.getInstance().getAppVersion()).token(PaxEnvironment.getInstance().getToken()).countryId(PaxEnvironment.getInstance().getCountryCode()).cityId(Boxing.boxInt(PaxEnvironment.getInstance().getCityId())).lang(Locale.getDefault().getLanguage());
                ITrafficEventsReqParamGetter access$getParamGetter$p2 = trafficEventsController2.f30050e;
                String str = "";
                if (access$getParamGetter$p2 != null) {
                    String orderId = access$getParamGetter$p2.getOrderId();
                    if (orderId != null) {
                        str = orderId;
                    }
                }
                EventFeedbackReq build = lang.orderId(str).cardType(Boxing.boxInt(i2)).build();
                TrafficEventVerifyRepository access$getVerifyRepository$p = trafficEventsController2.f30049d;
                Intrinsics.checkNotNullExpressionValue(build, "param");
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object postVerifyData = access$getVerifyRepository$p.postVerifyData(verifyUrl, build, this);
                if (postVerifyData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                obj = postVerifyData;
            } else if (i == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    trafficEventsController2.m23423a(e);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result result = (Result) obj;
            if (CoroutineScopeKt.isActive(coroutineScope) && i != trafficEventsController2.f30059n) {
                if (result instanceof Result.Success) {
                    LEGOToastHelper.showShortPosToast(trafficEventsController2.f30046a, trafficEventsController2.f30046a.getString(R.string.GRider_PassengerReports__nKvx));
                    trafficEventsController2.f30062q.add(Boxing.boxLong(trafficEventModel.getEventId()));
                } else if (result instanceof Result.Error) {
                    if (((Result.Error) result).getException() instanceof TrafficEventsDuplicateVerifyException) {
                        LEGOToastHelper.showShortNagToast(trafficEventsController2.f30046a, trafficEventsController2.f30046a.getString(R.string.GRider_PassengerReports__ZGAx));
                    } else {
                        LEGOToastHelper.showShortNagToast(trafficEventsController2.f30046a, trafficEventsController2.f30046a.getString(R.string.GRider_PassengerReports__CuFm));
                    }
                    trafficEventsController2.m23423a(((Result.Error) result).getException());
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TrafficEventsController trafficEventsController = this.this$0;
            final TrafficEventModel trafficEventModel = this.$event;
            final int i = this.$code;
            final int i2 = this.$cardType;
            final TrafficEventsController trafficEventsController2 = trafficEventsController;
            trafficEventsController.f30058m = C2746d.m5821a((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new C106311((Continuation<? super C106311>) null), 3, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
