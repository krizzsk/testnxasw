package com.didi.unifylogin.listener.pojo;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class WebViewModel {

    /* renamed from: a */
    private String f47478a;

    /* renamed from: b */
    private String f47479b;

    /* renamed from: c */
    private WeakReference<Activity> f47480c;

    public String getTitle() {
        return this.f47478a;
    }

    public void setTitle(String str) {
        this.f47478a = str;
    }

    public String getUrl() {
        return this.f47479b;
    }

    public void setUrl(String str) {
        this.f47479b = str;
    }

    public Activity getActivity() {
        return (Activity) this.f47480c.get();
    }

    public void setActivity(Activity activity) {
        this.f47480c = new WeakReference<>(activity);
    }
}
