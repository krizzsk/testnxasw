package com.didi.map.global.sctx.event_reveal;

import com.didi.common.map.model.LatLng;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/IMockTrafficEventGetter;", "", "getRoutePoints", "", "Lcom/didi/common/map/model/LatLng;", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MockTrafficEventsDataSource.kt */
public interface IMockTrafficEventGetter {
    List<LatLng> getRoutePoints();
}
