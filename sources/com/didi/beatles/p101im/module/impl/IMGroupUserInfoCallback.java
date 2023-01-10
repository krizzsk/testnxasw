package com.didi.beatles.p101im.module.impl;

import com.didi.beatles.p101im.module.IMSucceedCallback;
import com.didi.beatles.p101im.module.entity.IMUser;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.impl.IMGroupUserInfoCallback */
public interface IMGroupUserInfoCallback extends IMSucceedCallback {
    void onUserInfoLoaded(List<IMUser> list);
}
