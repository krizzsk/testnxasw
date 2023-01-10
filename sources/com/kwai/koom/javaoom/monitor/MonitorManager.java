package com.kwai.koom.javaoom.monitor;

import java.util.ArrayList;
import java.util.List;

public class MonitorManager {

    /* renamed from: a */
    private List<Monitor> f58476a = new ArrayList();

    /* renamed from: b */
    private MonitorThread f58477b = new MonitorThread();

    public void start() {
        this.f58477b.start(this.f58476a);
    }

    public void stop() {
        for (Monitor stop : this.f58476a) {
            stop.stop();
        }
        this.f58477b.stop();
    }

    public void startMonitor(Monitor monitor) {
        monitor.start();
    }

    public void stopMonitor(Monitor monitor) {
        monitor.stop();
    }

    public void addMonitor(Monitor monitor) {
        this.f58476a.add(monitor);
    }

    public void removeMonitor(Monitor monitor) {
        this.f58476a.remove(monitor);
    }

    public void setTriggerListener(MonitorTriggerListener monitorTriggerListener) {
        this.f58477b.setMonitorTriggerListener(monitorTriggerListener);
    }
}
