package com.google.p223ar.core;

import com.google.p223ar.core.exceptions.FatalException;

/* renamed from: com.google.ar.core.TrackingState */
public enum TrackingState {
    TRACKING(0),
    PAUSED(1),
    STOPPED(2);
    
    final int nativeCode;

    private TrackingState(int i) {
        this.nativeCode = i;
    }

    static TrackingState forNumber(int i) {
        for (TrackingState trackingState : values()) {
            if (trackingState.nativeCode == i) {
                return trackingState;
            }
        }
        StringBuilder sb = new StringBuilder(60);
        sb.append("Unexpected value for native TrackingState, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
