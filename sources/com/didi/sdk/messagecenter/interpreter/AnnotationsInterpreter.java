package com.didi.sdk.messagecenter.interpreter;

import com.didi.sdk.messagecenter.annotations.Subscriber;
import com.didi.sdk.messagecenter.p153pb.MsgType;
import com.didi.sdk.messagecenter.p153pb.PushMessageType;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationsInterpreter implements IInterpreter {

    /* renamed from: a */
    private static final Map<Class, Set<String>> f39539a = new LinkedHashMap();

    /* renamed from: b */
    private static final Map<Class, String> f39540b = new LinkedHashMap();

    public int explainUnifyId(Class<?> cls) {
        return 0;
    }

    public Set<String> explainTopic(Class<?> cls) {
        Subscriber subscriber;
        if (f39539a.containsKey(cls)) {
            return f39539a.get(cls);
        }
        if (!cls.isAnnotationPresent(Subscriber.class) || (subscriber = (Subscriber) cls.getAnnotation(Subscriber.class)) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        PushMessageType[] pushMessageTypeArr = subscriber.topic();
        MsgType[] alternativeTopic = subscriber.alternativeTopic();
        if (pushMessageTypeArr != null && pushMessageTypeArr.length > 0) {
            for (PushMessageType pushMessageType : pushMessageTypeArr) {
                hashSet.add(pushMessageType.getValue() + "");
            }
        }
        if (alternativeTopic != null && alternativeTopic.length > 0) {
            for (MsgType msgType : alternativeTopic) {
                hashSet.add(msgType.getValue() + "");
            }
        }
        f39539a.put(cls, hashSet);
        return hashSet;
    }

    public String explainType(Class<?> cls) {
        Subscriber subscriber;
        if (f39540b.containsKey(cls)) {
            return f39540b.get(cls);
        }
        if (!cls.isAnnotationPresent(Subscriber.class) || (subscriber = (Subscriber) cls.getAnnotation(Subscriber.class)) == null) {
            return "";
        }
        String name = subscriber.type().getName();
        f39540b.put(cls, name);
        return name;
    }
}
