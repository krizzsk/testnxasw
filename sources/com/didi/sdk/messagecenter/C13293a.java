package com.didi.sdk.messagecenter;

import com.didi.sdk.messagecenter.p153pb.MsgType;
import com.didi.sdk.messagecenter.util.MLog;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushRequest;
import com.squareup.wire.Message;

/* renamed from: com.didi.sdk.messagecenter.a */
/* compiled from: MessageSender */
class C13293a {

    /* renamed from: a */
    private static final C13293a f39526a = new C13293a();

    /* renamed from: a */
    static C13293a m29746a() {
        return f39526a;
    }

    private C13293a() {
    }

    /* renamed from: a */
    public void mo99269a(Message message) {
        mo99270a(message, (PushCallback) null);
    }

    /* renamed from: a */
    public void mo99270a(Message message, PushCallback pushCallback) {
        mo99268a(MsgType.kMsgTypeDispatchSvrNoRspReq, message, pushCallback);
    }

    /* renamed from: a */
    public void mo99267a(MsgType msgType, Message message) {
        mo99268a(msgType, message, (PushCallback) null);
    }

    /* renamed from: a */
    public void mo99268a(MsgType msgType, Message message, PushCallback pushCallback) {
        if (message == null) {
            MLog.m29817w("send msg: message is null");
            return;
        }
        MLog.m29816i("send msg: " + msgType + "|" + message.getClass() + "|" + pushCallback);
        if (!PushClient.getClient().isConnected()) {
            MLog.m29817w("push client is not connected!");
            return;
        }
        PushRequest build = new PushRequest.Builder().msgType(msgType.getValue()).data(message.toByteArray()).needResponse(pushCallback != null).seqIdOut(new byte[8]).priority(0).build();
        if (pushCallback != null) {
            PushClient.getClient().sendRequest(build, new MessageSender$1(this, pushCallback));
        } else {
            PushClient.getClient().sendRequest(build);
        }
    }
}
