package com.didi.beatles.p101im.event;

import com.didi.beatles.p101im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.event.IMMessageColloectionUpdateEvent */
public class IMMessageColloectionUpdateEvent {
    public List<IMMessage> updateMessages;

    public IMMessageColloectionUpdateEvent(List<IMMessage> list) {
        this.updateMessages = list;
    }
}
