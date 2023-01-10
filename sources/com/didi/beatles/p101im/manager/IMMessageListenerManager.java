package com.didi.beatles.p101im.manager;

import com.didi.beatles.p101im.access.core.IMMessageListener;
import com.didi.beatles.p101im.utils.IMLog;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.manager.IMMessageListenerManager */
public class IMMessageListenerManager {

    /* renamed from: a */
    private List<IMMessageListener> f11095a;

    private IMMessageListenerManager() {
        this.f11095a = null;
        this.f11095a = new ArrayList();
    }

    public static IMMessageListenerManager getInstance() {
        return ListenerManagerHolder.INSTANCE;
    }

    /* renamed from: com.didi.beatles.im.manager.IMMessageListenerManager$ListenerManagerHolder */
    private static final class ListenerManagerHolder {
        /* access modifiers changed from: private */
        public static final IMMessageListenerManager INSTANCE = new IMMessageListenerManager();

        private ListenerManagerHolder() {
        }
    }

    public void addMessageListener(IMMessageListener iMMessageListener) {
        IMLog.m10019d("[addMessageListener]");
        synchronized (this.f11095a) {
            if (this.f11095a != null && !this.f11095a.contains(iMMessageListener)) {
                this.f11095a.add(iMMessageListener);
            }
        }
    }

    public void removeMessageListener(IMMessageListener iMMessageListener) {
        IMLog.m10019d("[removeMessageListener]");
        synchronized (this.f11095a) {
            if (this.f11095a != null) {
                this.f11095a.remove(iMMessageListener);
            }
        }
    }

    public void notifyListeners() {
        StringBuilder sb = new StringBuilder();
        sb.append("[notifyListeners] listeners=");
        List<IMMessageListener> list = this.f11095a;
        sb.append(list == null ? "0" : Integer.valueOf(list.size()));
        IMLog.m10019d(sb.toString());
        synchronized (this.f11095a) {
            if (this.f11095a != null) {
                for (IMMessageListener iMMessageListener : new ArrayList(this.f11095a)) {
                    if (iMMessageListener != null) {
                        iMMessageListener.onMessageArrive();
                    }
                }
            }
        }
    }

    public void clear() {
        synchronized (this.f11095a) {
            if (this.f11095a != null) {
                this.f11095a.clear();
            }
        }
    }
}
