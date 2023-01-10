package com.didi.component.business.event;

import com.didi.map.global.sctx.event_reveal.TrafficEventModel;
import java.io.Serializable;

public class TrafficClickEvent implements Serializable {
    public TrafficEventModel event;
    public int type;

    public TrafficClickEvent(TrafficEventModel trafficEventModel, int i) {
        this.event = trafficEventModel;
        this.type = i;
    }

    public String toString() {
        return "TrafficClickEvent{eventid=" + this.event.getEventId() + "event=" + this.event.toString() + ", type=" + this.type + '}';
    }
}
