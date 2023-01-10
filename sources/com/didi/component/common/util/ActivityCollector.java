package com.didi.component.common.util;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ActivityCollector {

    /* renamed from: a */
    private static HashMap<Integer, WeakReference<ActivityFinishListener>> f13584a = new HashMap<>();

    public interface ActivityFinishListener {
        void onActivityFinish();
    }

    public static void addFinishListener(ActivityFinishListener activityFinishListener) {
        if (activityFinishListener != null) {
            f13584a.put(Integer.valueOf(activityFinishListener.hashCode()), new WeakReference(activityFinishListener));
        }
    }

    public static void removeFinishListener(ActivityFinishListener activityFinishListener) {
        if (activityFinishListener != null) {
            f13584a.remove(Integer.valueOf(activityFinishListener.hashCode()));
        }
    }

    public static void notifyActivityFinish() {
        ActivityFinishListener activityFinishListener;
        for (WeakReference next : f13584a.values()) {
            if (!(next == null || (activityFinishListener = (ActivityFinishListener) next.get()) == null)) {
                activityFinishListener.onActivityFinish();
            }
        }
    }
}
