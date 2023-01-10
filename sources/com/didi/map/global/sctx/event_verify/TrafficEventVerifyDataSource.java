package com.didi.map.global.sctx.event_verify;

import com.didi.common.map.util.NetUtils;
import com.didi.map.global.sctx.event_reveal.Result;
import com.didi.map.global.sctx.event_reveal.TrafficEventsDuplicateVerifyException;
import com.didi.map.sdk.proto.driver_gl.event.EventFeedbackReq;
import com.didi.map.sdk.proto.driver_gl.event.EventFeedbackRes;
import com.squareup.wire.Wire;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_verify/TrafficEventVerifyDataSource;", "", "()V", "ERROR_CODE_HAS_REPORTED", "", "postVerifyData", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventFeedbackRes;", "url", "", "req", "Lcom/didi/map/sdk/proto/driver_gl/event/EventFeedbackReq;", "(Ljava/lang/String;Lcom/didi/map/sdk/proto/driver_gl/event/EventFeedbackReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRequest", "param", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventVerifyDataSource.kt */
public final class TrafficEventVerifyDataSource {

    /* renamed from: a */
    private final int f30081a = 35011;

    public final Object postVerifyData(String str, EventFeedbackReq eventFeedbackReq, Continuation<? super Result<EventFeedbackRes>> continuation) {
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        return BuildersKt.withContext(Dispatchers.getIO(), new TrafficEventVerifyDataSource$postVerifyData$2(this, str, eventFeedbackReq, (Continuation<? super TrafficEventVerifyDataSource$postVerifyData$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Result<EventFeedbackRes> m23438a(String str, EventFeedbackReq eventFeedbackReq) {
        try {
            byte[] doPost = NetUtils.doPost(str, eventFeedbackReq.toByteArray());
            if (doPost == null) {
                return new Result.Error(new IllegalStateException("API 返回 null"));
            }
            EventFeedbackRes eventFeedbackRes = (EventFeedbackRes) new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, EventFeedbackRes.class);
            if (eventFeedbackRes == null) {
                return new Result.Error(new IllegalStateException("event/feedback/ API 返回 null"));
            }
            Integer num = eventFeedbackRes.ret;
            int i = this.f30081a;
            if (num != null) {
                if (num.intValue() == i) {
                    String str2 = eventFeedbackRes.msg;
                    Intrinsics.checkNotNullExpressionValue(str2, "result.msg");
                    return new Result.Error(new TrafficEventsDuplicateVerifyException(str2));
                }
            }
            Integer num2 = eventFeedbackRes.ret;
            if (num2 != null) {
                if (num2.intValue() == 0) {
                    return new Result.Success<>(eventFeedbackRes);
                }
            }
            return new Result.Error(new IllegalStateException(Intrinsics.stringPlus("event/feedback/ API return error: ", eventFeedbackRes.msg)));
        } catch (Exception e) {
            return new Result.Error(e);
        }
    }
}
