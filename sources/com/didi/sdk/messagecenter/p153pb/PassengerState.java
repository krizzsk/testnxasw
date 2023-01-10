package com.didi.sdk.messagecenter.p153pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.PassengerState */
public enum PassengerState implements ProtoEnum {
    PassengerStateNormal(0),
    PassengerStateHasPaidOff(1),
    PassengerStateHasCommented(2);
    
    private final int value;

    private PassengerState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
