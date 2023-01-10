package com.didi.beatles.p101im.module;

import com.didi.beatles.p101im.module.entity.IMSession;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IMFeedSessionCallback */
public interface IMFeedSessionCallback {
    void onFeedSessionsLoad(List<IMSession> list, int i, int i2);
}
