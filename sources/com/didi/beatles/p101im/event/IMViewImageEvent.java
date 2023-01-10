package com.didi.beatles.p101im.event;

import com.didi.beatles.p101im.module.entity.IMMessage;

/* renamed from: com.didi.beatles.im.event.IMViewImageEvent */
public class IMViewImageEvent {
    public IMMessage message;

    public IMViewImageEvent(IMMessage iMMessage) {
        this.message = iMMessage;
    }
}
