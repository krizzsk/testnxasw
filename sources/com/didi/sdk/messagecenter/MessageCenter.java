package com.didi.sdk.messagecenter;

import androidx.lifecycle.LifecycleOwner;
import com.didi.sdk.messagecenter.interfaces.ISubscribe;
import com.didi.sdk.messagecenter.model.PushMessage;
import com.didi.sdk.messagecenter.p153pb.MsgType;
import com.squareup.wire.Message;

public class MessageCenter {
    public static ISubscribe.ISubscribeWrapper bind(Object obj) {
        return C13295b.m29758a().bind(obj);
    }

    public static ISubscribe.ISubscribeWrapper autoBind(LifecycleOwner lifecycleOwner) {
        return C13295b.m29758a().autoBind(lifecycleOwner);
    }

    public static void release(Object obj) {
        C13295b.m29758a().release(obj);
    }

    public static void release(Object obj, Class<? extends PushMessage> cls) {
        C13295b.m29758a().release(obj, cls);
    }

    public static void send(Message message) {
        C13293a.m29746a().mo99269a(message);
    }

    public static void send(MsgType msgType, Message message) {
        C13293a.m29746a().mo99267a(msgType, message);
    }

    public static void send(Message message, PushCallback pushCallback) {
        C13293a.m29746a().mo99270a(message, pushCallback);
    }

    public static void send(MsgType msgType, Message message, PushCallback pushCallback) {
        C13293a.m29746a().mo99268a(msgType, message, pushCallback);
    }
}
