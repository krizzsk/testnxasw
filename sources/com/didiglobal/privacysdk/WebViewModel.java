package com.didiglobal.privacysdk;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class WebViewModel {

    /* renamed from: a */
    private String f53168a;

    /* renamed from: b */
    private String f53169b;

    /* renamed from: c */
    private WeakReference<Activity> f53170c;

    public String getTitle() {
        return this.f53168a;
    }

    public void setTitle(String str) {
        this.f53168a = str;
    }

    public String getUrl() {
        return this.f53169b;
    }

    public void setUrl(String str) {
        this.f53169b = str;
    }

    public Activity getActivity() {
        return (Activity) this.f53170c.get();
    }

    public void setActivity(Activity activity) {
        this.f53170c = new WeakReference<>(activity);
    }
}
