package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.background;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class ApplicationStateMonitor {

    /* renamed from: a */
    private static final AgentLog f50500a = AgentLogManager.getAgentLog();

    /* renamed from: f */
    private static ApplicationStateMonitor f50501f;

    /* renamed from: g */
    private static long f50502g = 0;

    /* renamed from: b */
    private int f50503b;

    /* renamed from: c */
    private final ArrayList<ApplicationStateListener> f50504c = new ArrayList<>();

    /* renamed from: d */
    private boolean f50505d = true;

    /* renamed from: e */
    private final Object f50506e = new Object();

    public void uiHidden() {
    }

    private ApplicationStateMonitor() {
        f50500a.info("Application state monitor has started");
    }

    public static synchronized ApplicationStateMonitor getInstance() {
        ApplicationStateMonitor applicationStateMonitor;
        synchronized (ApplicationStateMonitor.class) {
            if (f50501f == null) {
                f50501f = new ApplicationStateMonitor();
            }
            applicationStateMonitor = f50501f;
        }
        return applicationStateMonitor;
    }

    public void addApplicationStateListener(ApplicationStateListener applicationStateListener) {
        synchronized (this.f50504c) {
            this.f50504c.add(applicationStateListener);
        }
    }

    public void activityStopped() {
        synchronized (this.f50506e) {
            int i = this.f50503b - 1;
            this.f50503b = i;
            if (i == 0) {
                f50500a.info("UI has become hidden (app backgrounded)");
                m37663a();
                this.f50505d = false;
            }
        }
    }

    public void activityStarted() {
        synchronized (this.f50506e) {
            if (this.f50503b == 0) {
                m37665c();
                f50500a.verbose("Application appears to be in the foreground");
                m37664b();
                this.f50505d = true;
            }
            this.f50503b++;
        }
    }

    /* renamed from: a */
    private void m37663a() {
        ArrayList arrayList;
        f50500a.verbose("Application appears to have gone to the background");
        synchronized (this.f50504c) {
            arrayList = new ArrayList(this.f50504c);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ApplicationStateListener) it.next()).applicationBackgrounded(applicationStateEvent);
        }
    }

    /* renamed from: b */
    private void m37664b() {
        ArrayList arrayList;
        synchronized (this.f50504c) {
            arrayList = new ArrayList(this.f50504c);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ApplicationStateListener) it.next()).applicationForegrounded(applicationStateEvent);
        }
    }

    public boolean isForegrounded() {
        return this.f50505d;
    }

    /* renamed from: c */
    private void m37665c() {
        if (System.currentTimeMillis() - f50502g > 3600000) {
            OmegaSDKAdapter.trackMasEvent("omg_lag_open");
            OmegaSDKAdapter.trackMasEvent("omg_anr_open");
            f50502g = System.currentTimeMillis();
        }
    }
}
