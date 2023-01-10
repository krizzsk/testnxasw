package com.didi.sdk.messagecenter;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.messagecenter.adapter.PushListenerAdapter;
import com.didi.sdk.messagecenter.interfaces.IStore;
import com.didi.sdk.messagecenter.model.PushMessage;
import com.didi.sdk.messagecenter.subscribe.Subscription;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.didi.sdk.messagecenter.c */
/* compiled from: SubscribeStore */
class C13296c implements IStore {

    /* renamed from: a */
    private final Map<Class<? extends PushMessage>, CopyOnWriteArrayList<PushListenerAdapter>> f39532a = new HashMap();

    /* renamed from: b */
    private final Map<Object, List<Class<? extends PushMessage>>> f39533b = new HashMap();

    public synchronized void add(Object obj, Subscription subscription) {
        Class<? extends PushMessage> cls = subscription.subscriberMessageClz;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f39532a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f39532a.put(cls, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(new PushListenerAdapter(subscription));
        List list = this.f39533b.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f39533b.put(obj, list);
        }
        list.add(cls);
    }

    public synchronized boolean remove(Object obj) {
        List<Class> list = this.f39533b.get(obj);
        if (list != null) {
            for (Class a : list) {
                m29759a(obj, a);
            }
            this.f39533b.remove(obj);
            return true;
        }
        SystemUtils.log(5, "MessageCenter", "Subscriber to unregister was not registered :" + obj.getClass(), (Throwable) null, "com.didi.sdk.messagecenter.SubscribeStore", 69);
        return false;
    }

    public synchronized boolean removeMessage(Object obj, Class<? extends PushMessage> cls) {
        List list = this.f39533b.get(obj);
        if (list != null) {
            list.remove(cls);
            m29759a(obj, cls);
            if (list.isEmpty()) {
                this.f39533b.remove(obj);
            }
            return true;
        }
        SystemUtils.log(5, "MessageCenter", "Subscriber to unregister was not registered :" + obj.getClass(), (Throwable) null, "com.didi.sdk.messagecenter.SubscribeStore", 85);
        return false;
    }

    public synchronized boolean isSubscribed(Object obj) {
        return this.f39533b.containsKey(obj);
    }

    /* renamed from: a */
    private void m29759a(Object obj, Class<?> cls) {
        List list = this.f39532a.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                PushListenerAdapter pushListenerAdapter = (PushListenerAdapter) list.get(i);
                if (pushListenerAdapter.subscription != null && pushListenerAdapter.subscription.subscriber == obj) {
                    list.remove(i);
                    pushListenerAdapter.release();
                    i--;
                    size--;
                }
                i++;
            }
        }
    }
}
