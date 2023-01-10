package com.didi.sdk.messagecenter.model;

import com.didi.sdk.messagecenter.annotations.Subscriber;
import com.didi.sdk.messagecenter.p153pb.PushMessageType;
import com.didi.sdk.messagecenter.p153pb.UnifyReq;
import java.io.Serializable;

public class UnifyMessage<T extends Serializable> extends PushMessage {
    public String body;
    public int businessId;
    public int expireTime;

    /* renamed from: id */
    public int f39543id;
    public String level;
    public String media;
    public T msg;
    public String msgId;
    public String msgType;

    @Subscriber(topic = {PushMessageType.kPushMessageTypeUnifyReq})
    public static class RAW extends BaseMessage<UnifyReq> {
    }
}
