package com.didi.beatles.p101im.manager;

import android.app.Activity;
import android.util.Log;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.didi.beatles.im.manager.IMActivityController */
public final class IMActivityController {

    /* renamed from: a */
    static boolean f11067a = Log.isLoggable("im_activity_controller", 3);

    /* renamed from: d */
    private static final String f11068d = IMActivityController.class.getSimpleName();

    /* renamed from: b */
    SoftReference<Activity> f11069b;

    /* renamed from: c */
    SoftReference<Activity> f11070c;

    /* renamed from: e */
    private ConcurrentHashMap<Integer, SoftReference<Activity>> f11071e;

    public static IMActivityController getInstance() {
        return Holder.INSTANCE;
    }

    private IMActivityController() {
        this.f11071e = new ConcurrentHashMap<>();
    }

    public void addAcitivty(Activity activity) {
        ConcurrentHashMap<Integer, SoftReference<Activity>> concurrentHashMap = this.f11071e;
        if (concurrentHashMap != null && activity != null) {
            concurrentHashMap.put(Integer.valueOf(activity.hashCode()), new SoftReference(activity));
        }
    }

    public void removeActivity(Activity activity) {
        ConcurrentHashMap<Integer, SoftReference<Activity>> concurrentHashMap = this.f11071e;
        if (concurrentHashMap != null && activity != null) {
            concurrentHashMap.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public boolean hasActivity() {
        ConcurrentHashMap<Integer, SoftReference<Activity>> concurrentHashMap = this.f11071e;
        return (concurrentHashMap == null || concurrentHashMap.size() == 0) ? false : true;
    }

    public List<Activity> getActivities() {
        ArrayList arrayList = new ArrayList();
        for (SoftReference<Activity> softReference : this.f11071e.values()) {
            arrayList.add(softReference.get());
        }
        return arrayList;
    }

    public void setTopActivity(Activity activity) {
        if (activity != null) {
            if (f11067a) {
                IMLog.m10020d(f11068d, C4786I.m9980t("NotificationService setTopActivity argu -->", activity.getClass().getSimpleName()));
            }
            this.f11070c = this.f11069b;
            SoftReference<Activity> softReference = new SoftReference<>(activity);
            this.f11069b = softReference;
            if (f11067a) {
                IMLog.m10020d(f11068d, C4786I.m9980t("NotificationService setTopActivity -->", softReference.get().getClass().getSimpleName()));
            }
        }
    }

    public void setTopActivityNull(Activity activity) {
        if (activity != null) {
            if (f11067a) {
                IMLog.m10020d(f11068d, C4786I.m9980t("NotificationService setTopActivityNull -->", activity.getClass().getSimpleName()));
            }
            if (getTopActivity() != null && getTopActivity().getClass().getSimpleName().equals(activity.getClass().getSimpleName())) {
                this.f11069b = null;
            }
        }
    }

    public Activity getTopActivity() {
        SoftReference<Activity> softReference = this.f11069b;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public Activity getSecondActivity() {
        SoftReference<Activity> softReference = this.f11070c;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void clear() {
        ConcurrentHashMap<Integer, SoftReference<Activity>> concurrentHashMap = this.f11071e;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* renamed from: com.didi.beatles.im.manager.IMActivityController$Holder */
    private static class Holder {
        /* access modifiers changed from: private */
        public static final IMActivityController INSTANCE = new IMActivityController();

        private Holder() {
        }
    }
}
