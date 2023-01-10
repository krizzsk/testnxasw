package com.didi.map.global.sctx.event_reveal;

import com.didi.common.map.util.NetUtils;
import com.didi.map.global.sctx.event_reveal.Result;
import com.didi.map.sdk.proto.driver_gl.event.EventShowReq;
import com.didi.map.sdk.proto.driver_gl.event.EventShowRes;
import com.squareup.wire.Wire;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/TrafficEventsDataSource;", "Lcom/didi/map/global/sctx/event_reveal/ITrafficEventsDataSource;", "timeout", "", "(J)V", "getTimeout", "()J", "getData", "Lcom/didi/map/global/sctx/event_reveal/Result;", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowRes;", "url", "", "param", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowReq;", "(Ljava/lang/String;Lcom/didi/map/sdk/proto/driver_gl/event/EventShowReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRequest", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventsDataSource.kt */
public final class TrafficEventsDataSource implements ITrafficEventsDataSource {

    /* renamed from: a */
    private final long f30072a;

    public TrafficEventsDataSource(long j) {
        this.f30072a = j;
    }

    public final long getTimeout() {
        return this.f30072a;
    }

    public Object getData(String str, EventShowReq eventShowReq, Continuation<? super Result<EventShowRes>> continuation) {
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        return BuildersKt.withContext(Dispatchers.getIO(), new TrafficEventsDataSource$getData$2(this, str, eventShowReq, (Continuation<? super TrafficEventsDataSource$getData$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Result<EventShowRes> m23437a(String str, EventShowReq eventShowReq) {
        try {
            byte[] doPost = NetUtils.doPost(str, eventShowReq.toByteArray());
            if (doPost == null) {
                return new Result.Error(new IllegalStateException("API 返回 null"));
            }
            EventShowRes eventShowRes = (EventShowRes) new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, EventShowRes.class);
            if (eventShowRes == null) {
                return new Result.Error(new IllegalStateException("event/show/ API 返回 null"));
            }
            Integer num = eventShowRes.ret;
            if (num != null) {
                if (num.intValue() == 0) {
                    return new Result.Success<>(eventShowRes);
                }
            }
            return new Result.Error(new IllegalStateException(Intrinsics.stringPlus("event/show/ API return error: ", eventShowRes.msg)));
        } catch (Exception e) {
            return new Result.Error(e);
        }
    }
}
