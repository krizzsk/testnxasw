package com.didi.beatles.p101im.event;

import com.didi.beatles.p101im.api.entity.IMOrderStatusChangeBody;

/* renamed from: com.didi.beatles.im.event.IMViewStreetImageEvent */
public class IMViewStreetImageEvent {
    public IMOrderStatusChangeBody body;

    public IMViewStreetImageEvent(IMOrderStatusChangeBody iMOrderStatusChangeBody) {
        this.body = iMOrderStatusChangeBody;
    }
}
