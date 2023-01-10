package com.didi.flutter.nacho2.p116v2.container;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.didi.flutter.nacho2.v2.container.NachoActivityManager */
public class NachoActivityManager {

    /* renamed from: a */
    private WeakReference<Activity> f23006a;

    /* renamed from: b */
    private LinkedList<WeakReference<Activity>> f23007b;

    /* renamed from: c */
    private boolean f23008c;

    /* renamed from: d */
    private Application f23009d;

    /* renamed from: e */
    private boolean f23010e;

    private NachoActivityManager() {
        this.f23007b = new LinkedList<>();
        this.f23010e = false;
    }

    /* renamed from: com.didi.flutter.nacho2.v2.container.NachoActivityManager$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static NachoActivityManager INSTANCE = new NachoActivityManager();

        private SingletonHolder() {
        }
    }

    public static NachoActivityManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Application application) {
        if (!this.f23010e) {
            application.registerActivityLifecycleCallbacks(new NachoActivityLifecycleCallbacks());
            this.f23009d = application;
            this.f23010e = true;
        }
    }

    public WeakReference<Activity> getTopActivity() {
        return this.f23006a;
    }

    public void setTopActivity(WeakReference<Activity> weakReference) {
        this.f23006a = weakReference;
    }

    public LinkedList<WeakReference<Activity>> getActivities() {
        return this.f23007b;
    }

    public void setActivities(LinkedList<WeakReference<Activity>> linkedList) {
        this.f23007b = linkedList;
    }

    public boolean isPaddingOpenContainer() {
        return this.f23008c;
    }

    public void setPaddingOpenContainer(boolean z) {
        this.f23008c = z;
    }

    public boolean isFlutterContainer(Activity activity) {
        return activity instanceof NachoFlutterActivity;
    }

    public Activity getStrictTopActivity() {
        if (this.f23006a == null && this.f23007b.size() > 0) {
            this.f23006a = this.f23007b.getLast();
        }
        WeakReference<Activity> weakReference = this.f23006a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public NachoFlutterActivity getTopContainer() {
        Activity strictTopActivity = getStrictTopActivity();
        if (strictTopActivity instanceof NachoFlutterActivity) {
            return (NachoFlutterActivity) strictTopActivity;
        }
        return null;
    }

    public void openNativeActivity(HashMap<String, Object> hashMap, Class cls) {
        Intent intent = new Intent(this.f23009d, cls);
        intent.putExtra("params", hashMap);
        intent.addFlags(268435456);
        this.f23009d.startActivity(intent);
    }

    public void openFlutterActivity(String str, HashMap<String, Object> hashMap, Class cls) {
        Intent intent = new Intent(this.f23009d, cls);
        intent.putExtra("url", str);
        intent.putExtra("params", hashMap);
        intent.addFlags(268435456);
        this.f23009d.startActivity(intent);
    }

    public boolean closeTopActivity(String str) {
        NachoFlutterActivity topContainer = getTopContainer();
        if (topContainer == null || !topContainer.getPageId().equals(str)) {
            return false;
        }
        topContainer.finish();
        return true;
    }
}
