package com.didi.beatles.p101im.access.style.custom.msgcard;

import com.didi.beatles.p101im.api.entity.IMOrderStatusChangeBody;
import com.didi.beatles.p101im.module.entity.IMMessage;

/* renamed from: com.didi.beatles.im.access.style.custom.msgcard.IMSysOrderCusView */
public abstract class IMSysOrderCusView extends IMMsgCardCusView {
    public void bindContent(IMMessage iMMessage) {
    }

    public void bindSysContent(IMMessage iMMessage, IMOrderStatusChangeBody iMOrderStatusChangeBody) {
        bindContent(iMMessage);
    }
}
