package com.didi.map.global.sctx.event_reveal;

import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.proto.driver_gl.event.EventShowReq;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/ITrafficEventsReqParamGetter;", "", "getCarMarker", "Lcom/didi/map/sdk/nav/car/CarMarker;", "getCurRouteId", "", "getEventsUrl", "", "getOrderId", "getRequestBody", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowReq;", "getVerifyUrl", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ITrafficEventsReqParamGetter.kt */
public interface ITrafficEventsReqParamGetter {
    CarMarker getCarMarker();

    long getCurRouteId();

    String getEventsUrl();

    String getOrderId();

    EventShowReq getRequestBody();

    String getVerifyUrl();
}
