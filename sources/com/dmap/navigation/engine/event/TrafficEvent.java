package com.dmap.navigation.engine.event;

import com.didi.map.base.TrafficEventRoutePoint;
import java.util.List;

public class TrafficEvent extends NaviEvent {

    /* renamed from: a */
    private final List<TrafficEventRoutePoint> f54512a;

    public TrafficEvent(List<TrafficEventRoutePoint> list) {
        this.f54512a = list;
    }

    public List<TrafficEventRoutePoint> getData() {
        return this.f54512a;
    }
}
