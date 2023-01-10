package com.didi.soda.customer.foundation.login;

import com.didi.unifylogin.listener.LoginListeners;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LoginOutListenerBridge {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<LoginListeners.LoginOutListener> f43539a = new ConcurrentLinkedQueue<>();

    public static ConcurrentLinkedQueue<LoginListeners.LoginOutListener> getLoginOutListeners() {
        return f43539a;
    }

    public static void addLoginOutListener(LoginListeners.LoginOutListener loginOutListener) {
        if (f43539a == null) {
            f43539a = new ConcurrentLinkedQueue<>();
        }
        f43539a.add(loginOutListener);
    }

    public static void removeLoginOutListener(LoginListeners.LoginOutListener loginOutListener) {
        ConcurrentLinkedQueue<LoginListeners.LoginOutListener> concurrentLinkedQueue = f43539a;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.remove(loginOutListener);
        }
    }

    public static void notifyAllSuccess() {
        ConcurrentLinkedQueue<LoginListeners.LoginOutListener> concurrentLinkedQueue = f43539a;
        if (concurrentLinkedQueue != null) {
            Iterator<LoginListeners.LoginOutListener> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().onSuccess();
            }
        }
    }

    public static void clearAllListeners() {
        ConcurrentLinkedQueue<LoginListeners.LoginOutListener> concurrentLinkedQueue = f43539a;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
    }
}
