package com.didi.globalsafetoolkit.util;

import com.didi.globalsafetoolkit.business.toolkit.model.SfViewMonitorMenuModel;

public class SfListenerManager {

    /* renamed from: a */
    private static MonitorDataUpdateListener f25187a;

    public interface MonitorDataUpdateListener {
        void monitorUpdate(SfViewMonitorMenuModel sfViewMonitorMenuModel);
    }

    public static void setMonitorUpdateListener(MonitorDataUpdateListener monitorDataUpdateListener) {
        f25187a = monitorDataUpdateListener;
    }

    public static MonitorDataUpdateListener getMonitorUpdateListener() {
        return f25187a;
    }

    public static void removeMonitorUpdateListener() {
        f25187a = null;
    }
}
