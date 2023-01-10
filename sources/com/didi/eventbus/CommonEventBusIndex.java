package com.didi.eventbus;

import com.didi.component.business.deeplink.DeeplinkDispatcherFragmentPresenter;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;

public class CommonEventBusIndex implements SubscriberInfoIndex {

    /* renamed from: a */
    private static final Map<Class<?>, SubscriberInfo> f22921a = new HashMap();

    static {
        m18923a(new SimpleSubscriberInfo(DeeplinkDispatcherFragmentPresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", CarInfoUpdateEvent.class, ThreadMode.MAIN)}));
    }

    /* renamed from: a */
    private static void m18923a(SubscriberInfo subscriberInfo) {
        f22921a.put(subscriberInfo.getSubscriberClass(), subscriberInfo);
    }

    public SubscriberInfo getSubscriberInfo(Class<?> cls) {
        SubscriberInfo subscriberInfo = f22921a.get(cls);
        if (subscriberInfo != null) {
            return subscriberInfo;
        }
        return null;
    }
}
