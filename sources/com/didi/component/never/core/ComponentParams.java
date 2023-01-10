package com.didi.component.never.core;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import java.util.Map;

public class ComponentParams {

    /* renamed from: a */
    private WeakReference<Activity> f16486a;

    /* renamed from: b */
    private WeakReference<Fragment> f16487b;

    /* renamed from: c */
    private WeakReference<Map> f16488c;
    public final Bundle extras = new Bundle();
    public String nodeId;
    public String type;

    public ComponentParams add(Activity activity) {
        this.f16486a = new WeakReference<>(activity);
        return this;
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f16486a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public static ComponentParams from(String str) {
        ComponentParams componentParams = new ComponentParams();
        componentParams.nodeId = str;
        return componentParams;
    }

    public ComponentParams add(Fragment fragment) {
        this.f16487b = new WeakReference<>(fragment);
        return this;
    }

    public Fragment getFragment() {
        WeakReference<Fragment> weakReference = this.f16487b;
        if (weakReference != null) {
            return (Fragment) weakReference.get();
        }
        return null;
    }

    public ComponentParams type(String str) {
        this.type = str;
        return this;
    }

    public ComponentParams add(Map map) {
        this.f16488c = new WeakReference<>(map);
        return this;
    }

    public ComponentParams add(Bundle bundle) {
        if (bundle != null) {
            this.extras.putAll(bundle);
        }
        return this;
    }

    public Map getMap() {
        WeakReference<Map> weakReference = this.f16488c;
        if (weakReference != null) {
            return (Map) weakReference.get();
        }
        return null;
    }

    public <T> T getExtra(String str) {
        return this.extras.get(str);
    }

    public Object get(String str) {
        if (getMap() == null) {
            return null;
        }
        return getMap().get(str);
    }

    public String toString() {
        return "ComponentParams{, activity=" + this.f16486a + ", fragment=" + this.f16487b + ", map=" + this.f16488c + ", extras=" + this.extras + '}';
    }
}
