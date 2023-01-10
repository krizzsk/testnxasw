package com.didi.map.global.component.trafficreport.model;

import com.taxis99.R;

public enum EventHandleStatus {
    RECEIVED(0, R.string.GRider_PassengerReports_HeSp_AdJW),
    ADOPTED(2, R.string.GRider_PassengerReports_JspB_nSar),
    ACTIVE(3, R.string.GRider_PassengerReports_tDBj_tNod);
    
    private final int nameId;
    private final int type;

    private EventHandleStatus(int i, int i2) {
        this.type = i;
        this.nameId = i2;
    }

    public int getType() {
        return this.type;
    }

    public int getNameId() {
        return this.nameId;
    }

    public static EventHandleStatus getStatus(int i) {
        if (i == 2) {
            return ADOPTED;
        }
        if (i != 3) {
            return RECEIVED;
        }
        return ACTIVE;
    }
}
