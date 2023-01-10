package com.kwai.koom.javaoom.monitor;

import android.os.Handler;
import android.os.HandlerThread;
import com.didi.sdk.apm.SystemUtils;
import com.kwai.koom.javaoom.common.KConstants;
import java.util.ArrayList;
import java.util.List;

public class MonitorThread {

    /* renamed from: a */
    private static final String f58478a = "MonitorThread";

    /* renamed from: b */
    private HandlerThread f58479b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f58480c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MonitorTriggerListener f58481d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f58482e = false;

    public MonitorThread() {
        HandlerThread handlerThread = new HandlerThread(f58478a);
        this.f58479b = handlerThread;
        handlerThread.start();
        this.f58480c = new Handler(this.f58479b.getLooper());
    }

    public void start(List<Monitor> list) {
        this.f58482e = false;
        SystemUtils.log(4, f58478a, "start", (Throwable) null, "com.kwai.koom.javaoom.monitor.MonitorThread", 45);
        ArrayList<Runnable> arrayList = new ArrayList<>();
        for (Monitor next : list) {
            next.start();
            arrayList.add(new MonitorRunnable(next));
        }
        for (Runnable post : arrayList) {
            this.f58480c.post(post);
        }
    }

    public void stop() {
        this.f58482e = true;
    }

    public void setMonitorTriggerListener(MonitorTriggerListener monitorTriggerListener) {
        this.f58481d = monitorTriggerListener;
    }

    class MonitorRunnable implements Runnable {
        private Monitor monitor;

        public MonitorRunnable(Monitor monitor2) {
            this.monitor = monitor2;
        }

        public void run() {
            if (!MonitorThread.this.f58482e) {
                boolean z = KConstants.Debug.VERBOSE_LOG;
                if (this.monitor.isTrigger()) {
                    SystemUtils.log(4, MonitorThread.f58478a, this.monitor.monitorType() + " monitor " + this.monitor.monitorType() + " trigger", (Throwable) null, "com.kwai.koom.javaoom.monitor.MonitorThread$MonitorRunnable", 88);
                    MonitorThread monitorThread = MonitorThread.this;
                    boolean unused = monitorThread.f58482e = monitorThread.f58481d.onTrigger(this.monitor.monitorType(), this.monitor.getTriggerReason());
                }
                if (!MonitorThread.this.f58482e) {
                    MonitorThread.this.f58480c.postDelayed(this, (long) this.monitor.pollInterval());
                }
            }
        }
    }
}
