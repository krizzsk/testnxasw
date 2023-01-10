package com.didi.beatles.p101im.event;

import com.didi.beatles.p101im.module.entity.IMMessage;

/* renamed from: com.didi.beatles.im.event.IMBackgroundSendMessage */
public class IMBackgroundSendMessage {
    public IMMessage imMessage;

    public IMBackgroundSendMessage(IMMessage iMMessage) {
        this.imMessage = iMMessage;
    }
}
