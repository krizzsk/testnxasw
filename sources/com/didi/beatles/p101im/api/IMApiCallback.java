package com.didi.beatles.p101im.api;

import com.didi.beatles.p101im.api.entity.IMMessageDown;

/* renamed from: com.didi.beatles.im.api.IMApiCallback */
public interface IMApiCallback {
    void onReceiveGroupMessage(IMMessageDown iMMessageDown);

    void onReceiveSingleMessage(IMMessageDown iMMessageDown);

    void updateSingleMessageMaxId(long j);
}
