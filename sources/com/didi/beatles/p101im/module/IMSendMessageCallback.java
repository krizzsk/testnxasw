package com.didi.beatles.p101im.module;

import com.didi.beatles.p101im.module.entity.IMMessage;

/* renamed from: com.didi.beatles.im.module.IMSendMessageCallback */
public interface IMSendMessageCallback {
    public static final int ERR_NO_INNER = 100;

    void onError(String str, int i, String str2);

    void onSuccess(IMMessage iMMessage);
}
