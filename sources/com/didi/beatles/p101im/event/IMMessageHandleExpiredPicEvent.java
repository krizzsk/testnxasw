package com.didi.beatles.p101im.event;

import com.didi.beatles.p101im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.event.IMMessageHandleExpiredPicEvent */
public class IMMessageHandleExpiredPicEvent {
    public List<IMMessage> updateMessages;

    public IMMessageHandleExpiredPicEvent(List<IMMessage> list) {
        this.updateMessages = list;
    }
}
