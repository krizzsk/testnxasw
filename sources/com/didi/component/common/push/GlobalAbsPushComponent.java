package com.didi.component.common.push;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.component.protocol.IPushComponent;
import com.didi.sdk.log.Logger;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushListener;
import com.didi.sdk.push.manager.DPushType;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GlobalAbsPushComponent implements IPushComponent {

    /* renamed from: a */
    private static final String f13536a = "AbsPushComponent";

    /* renamed from: b */
    private static ConcurrentHashMap<String, Set<DPushListener>> f13537b = new ConcurrentHashMap<>();

    public void initPushConfig(Context context) {
    }

    public void startPush() {
    }

    public void stopPush() {
    }

    public void dispatcherPush(String str, DPushBody dPushBody, String str2) {
        Set<DPushListener> set = f13537b.get(str);
        Logger.m29536d(f13536a, "dispatcherPush,pushKey = " + str + ",topic = " + str2 + ",content = " + dPushBody);
        if (set != null && set.size() != 0) {
            for (DPushListener dPushListener : set) {
                if (dPushListener.topic().equals(str2)) {
                    Logger.m29536d(f13536a, "dispatch to listener = " + dPushListener);
                    dPushListener.pushBody(dPushBody);
                }
            }
        }
    }

    public void dispatcherPush(String str, DPushBody dPushBody) {
        Set<DPushListener> set = f13537b.get(str);
        Logger.m29536d(f13536a, "dispatcherPush,pushKey = " + str + ",dipatcher = " + set + ",content = " + dPushBody);
        if (set != null && set.size() != 0) {
            for (DPushListener pushBody : set) {
                pushBody.pushBody(dPushBody);
            }
        }
    }

    public boolean unregisterPush(DPushListener dPushListener) {
        String name = dPushListener.pushType().getName();
        Logger.m29536d(f13536a, "unregisterPush,listener = " + dPushListener + ",key = " + name);
        Set set = f13537b.get(name);
        if (set == null || TextUtils.isEmpty(name)) {
            return false;
        }
        return set.remove(dPushListener);
    }

    public void registerPush(DPushListener dPushListener) {
        Set set;
        DPushType pushType = dPushListener.pushType();
        Logger.m29536d(f13536a, "registerPush,listener = " + dPushListener + ",type = " + pushType);
        String name = pushType.getName();
        if (f13537b.get(name) != null) {
            set = f13537b.get(name);
        } else {
            HashSet hashSet = new HashSet();
            f13537b.put(name, hashSet);
            set = hashSet;
        }
        set.add(dPushListener);
    }
}
