package com.didi.beatles.p101im.module;

import com.didi.beatles.p101im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p101im.api.entity.IMTransBody;
import com.didi.beatles.p101im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IMMessageCallBackImp */
public class IMMessageCallBackImp implements IMMessageCallback {
    public long getSid() {
        return 0;
    }

    public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
    }

    public void onReadStatusChange(List<IMMessage> list, boolean z) {
    }

    public void onReceive(String str) {
    }

    public void onReceive(List<IMMessage> list) {
    }

    public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
    }

    public void onTranslateSucceed(IMTransBody iMTransBody) {
    }
}
