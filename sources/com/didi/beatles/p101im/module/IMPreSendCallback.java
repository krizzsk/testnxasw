package com.didi.beatles.p101im.module;

import com.didi.beatles.p101im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IMPreSendCallback */
public interface IMPreSendCallback {
    void insertSuccess(List<IMMessage> list);
}
