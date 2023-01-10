package com.didi.beatles.p101im.manager;

import com.didi.beatles.p101im.access.core.IMSessionMessageListener;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.utils.IMLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.didi.beatles.im.manager.IMSessionMessageListenerManager */
public class IMSessionMessageListenerManager {

    /* renamed from: a */
    private List<IMSessionMessageListener> f11101a;

    private IMSessionMessageListenerManager() {
        this.f11101a = null;
        this.f11101a = new ArrayList();
    }

    public static IMSessionMessageListenerManager getInstance() {
        return ListenerManagerHolder.INSTANCE;
    }

    /* renamed from: com.didi.beatles.im.manager.IMSessionMessageListenerManager$ListenerManagerHolder */
    private static final class ListenerManagerHolder {
        /* access modifiers changed from: private */
        public static final IMSessionMessageListenerManager INSTANCE = new IMSessionMessageListenerManager();

        private ListenerManagerHolder() {
        }
    }

    public void addMessageListener(IMSessionMessageListener iMSessionMessageListener) {
        IMLog.m10019d("[addMessageListener]");
        synchronized (this.f11101a) {
            if (this.f11101a != null && !this.f11101a.contains(iMSessionMessageListener)) {
                this.f11101a.add(iMSessionMessageListener);
            }
        }
    }

    public void removeMessageListener(IMSessionMessageListener iMSessionMessageListener) {
        IMLog.m10019d("[removeMessageListener]");
        synchronized (this.f11101a) {
            if (this.f11101a != null) {
                this.f11101a.remove(iMSessionMessageListener);
            }
        }
    }

    public void notifyListeners(Set<Long> set) {
        StringBuilder sb = new StringBuilder();
        sb.append("[notifyListeners] listeners=");
        List<IMSessionMessageListener> list = this.f11101a;
        sb.append(list == null ? "0" : Integer.valueOf(list.size()));
        IMLog.m10019d(sb.toString());
        synchronized (this.f11101a) {
            if (this.f11101a != null) {
                if (set != null) {
                    for (IMSessionMessageListener next : this.f11101a) {
                        if (next != null) {
                            next.onSessionMessageArrive(set);
                        }
                    }
                    IMMessageListenerManager.getInstance().notifyListeners();
                }
            }
        }
    }

    public void clear() {
        synchronized (this.f11101a) {
            if (this.f11101a != null) {
                this.f11101a.clear();
            }
        }
    }

    public static Set<Long> generateSessionIdSet(List<IMMessage> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (IMMessage sid : list) {
            hashSet.add(Long.valueOf(sid.getSid()));
        }
        return hashSet;
    }
}
