package com.didi.safetoolkit.util;

import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;

public class SfListenerManager {

    /* renamed from: a */
    private static MonitorDataUpdateListener f37299a;

    public interface MonitorDataUpdateListener {
        void monitorUpdate(SfViewMonitorMenuModel sfViewMonitorMenuModel);
    }

    public static void setMonitorUpdateListener(MonitorDataUpdateListener monitorDataUpdateListener) {
        f37299a = monitorDataUpdateListener;
    }

    public static MonitorDataUpdateListener getMonitorUpdateListener() {
        return f37299a;
    }

    public static void removeMonitorUpdateListener() {
        f37299a = null;
    }
}
