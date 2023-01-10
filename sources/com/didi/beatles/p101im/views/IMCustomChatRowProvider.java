package com.didi.beatles.p101im.views;

import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.views.messageCard.IMBaseRenderView;

/* renamed from: com.didi.beatles.im.views.IMCustomChatRowProvider */
public interface IMCustomChatRowProvider {
    IMBaseRenderView getCustomChatRow(int i, MessageAdapter messageAdapter);

    int getCustomChatRowType(IMMessage iMMessage);
}
