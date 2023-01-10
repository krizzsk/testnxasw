package com.didi.beatles.p101im.module;

import com.didi.beatles.p101im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IMMessageReceiveCallback */
public interface IMMessageReceiveCallback {
    void onReceive(List<IMMessage> list);
}
