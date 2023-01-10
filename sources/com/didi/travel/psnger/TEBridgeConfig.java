package com.didi.travel.psnger;

import android.app.Application;
import java.lang.ref.WeakReference;

public class TEBridgeConfig {

    /* renamed from: a */
    private WeakReference<Application> f46680a;

    /* renamed from: b */
    private IClientConfig f46681b;

    /* renamed from: c */
    private IHostConfig f46682c;

    public void setApplication(Application application) {
        this.f46680a = new WeakReference<>(application);
    }

    public void setClientConfig(IClientConfig iClientConfig) {
        this.f46681b = iClientConfig;
    }

    public void setHostConfig(IHostConfig iHostConfig) {
        this.f46682c = iHostConfig;
    }

    public Application getApplication() {
        WeakReference<Application> weakReference = this.f46680a;
        if (weakReference != null) {
            return (Application) weakReference.get();
        }
        return null;
    }

    public IClientConfig getClientConfig() {
        return this.f46681b;
    }

    public IHostConfig getHostConfig() {
        return this.f46682c;
    }
}
