package com.didi.beatles.p101im.event;

import com.didi.beatles.p101im.module.entity.IMMessage;

/* renamed from: com.didi.beatles.im.event.IMMessageSysCardShowEvent */
public class IMMessageSysCardShowEvent {
    public IMMessage message;

    public IMMessageSysCardShowEvent(IMMessage iMMessage) {
        this.message = iMMessage;
    }
}
