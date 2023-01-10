package com.didi.usercenter.listener;

import com.didi.usercenter.entity.UserInfo;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UserInfoListener {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<InfoListener> f47792a = new ConcurrentLinkedQueue<>();

    public interface InfoListener {
        void onFailure();

        void onGetInfo(UserInfo userInfo);
    }

    public static void addInfoListener(InfoListener infoListener) {
        f47792a.add(infoListener);
    }

    public static void removeListener(InfoListener infoListener) {
        f47792a.remove(infoListener);
    }

    public static ConcurrentLinkedQueue<InfoListener> getInfoListeners() {
        return f47792a;
    }
}
